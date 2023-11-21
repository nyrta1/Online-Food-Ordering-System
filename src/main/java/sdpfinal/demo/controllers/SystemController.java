package sdpfinal.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sdpfinal.demo.de_en_code_decarator.EncryptStringProvider;
import sdpfinal.demo.de_en_code_decarator.PlainStringProvider;
import sdpfinal.demo.factory.CustomerFactory;
import sdpfinal.demo.factory.MenuItemFactory;
import sdpfinal.demo.factory.RestaurantFactory;
import sdpfinal.demo.models.*;
import sdpfinal.demo.observable.CustomerOrder;
import sdpfinal.demo.observable.NotificationSystem;
import sdpfinal.demo.observable.Observer;
import sdpfinal.demo.payment.PaymentStrategy;
import sdpfinal.demo.payment.type_of_payment.HalykBankPayment;
import sdpfinal.demo.payment.type_of_payment.JusanBankPayment;
import sdpfinal.demo.payment.type_of_payment.KaspiBankPayment;
import sdpfinal.demo.repositories.MenuItemRepository;
import sdpfinal.demo.services.MenuItemService;
import sdpfinal.demo.services.PaymentService;
import sdpfinal.demo.services.RestaurantService;
import sdpfinal.demo.services.UserService;
import sdpfinal.demo.translate.objectstosql.Converter;
import sdpfinal.demo.translate.objectstosql.DatabaseMethods;
import sdpfinal.demo.translate.objectstosql.ExecuteSQL;
import sdpfinal.demo.translate.objectstosql.StringReaderAdapter;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Controller
public class SystemController {
    private final static Scanner scanner = new Scanner(System.in);

    private static UserService userService;
    private static RestaurantService restaurantService;
    private static MenuItemService menuItemService;
    private static PaymentService paymentService;
    private static Customer currentUser;

    @Autowired
    public SystemController(UserService userService, RestaurantService restaurantService, MenuItemService menuItemService, PaymentService paymentService) {
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.menuItemService = menuItemService;
        this.paymentService = paymentService;
    }

    public static void managementSystem() throws SQLException {
        System.out.println("**********************************************");
        System.out.println("***----------Food Ordering System----------***");
        System.out.println("**********************************************");
        System.out.println("***---------Powered by Spring Boot---------***");
        System.out.println("**********************************************");
        System.out.println("\n");
        System.out.println("1. Login \n2. Register");

        switch (scanner.nextInt()){
            case 1 -> {
                System.out.print("Enter username: ");
                String username = scanner.next();

                System.out.print("Enter password: ");
                String password = scanner.next();

                String encryptedPassword = new EncryptStringProvider(new PlainStringProvider(password)).getStringValue();

                currentUser = userService.findByUsername(username);

                if (!currentUser.getPassword().equals(encryptedPassword) || currentUser.getUsername().isEmpty()){
                    System.err.println("Username or password is incorrect!");
                    managementSystem();
                }

                switch (currentUser.getRole()) {
                    case Roles.CUSTOMER -> {
                        customerPage();
                    }
                    case Roles.MANAGER -> {
                        restaurantManagerPage();
                    }
                    case Roles.ADMIN -> {
                        adminPage();
                    }
                    default -> {
                        System.out.println("Undefined role!");
                        managementSystem();
                    }
                }
            }
            case 2 -> {
                System.out.print("Enter firstname: ");
                String firstName = scanner.next();
                System.out.print("Enter lastName: ");
                String lastName = scanner.next();
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter phone: ");
                String phone = scanner.next();
                System.out.print("Enter address: ");
                String address = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();

                String encryptedPassword = new EncryptStringProvider(new PlainStringProvider(password)).getStringValue();

                currentUser = CustomerFactory.createCustomer(firstName, lastName, username, phone, address, encryptedPassword, Roles.CUSTOMER);
                userService.save(currentUser);

                customerPage();
            }
            default -> {
                System.err.println("Invalid choice");
                managementSystem();
            }
        }
    }

    private static void restaurantManagerPage() throws SQLException {
        System.out.println("Welcome to manager page!");
        System.out.println("Menu: \n1. Add a dish to the menu \n0. Log out");
        switch (scanner.nextInt()){
            case 1 -> {
                System.out.println("Enter the restaurant name: ");
                String resName = scanner.next();
                Restaurant restaurant = restaurantService.findByName(resName);

                if (!currentUser.getUsername().equals(restaurant.getOwner()) || restaurant.getName().isEmpty()) {
                    System.out.println("You are not owner this restaurant");
                    restaurantManagerPage();
                }

                System.out.println("Enter dish name: ");
                String dishName = scanner.next();
                System.out.println("Enter description: ");
                String description = scanner.next();
                System.out.println("Enter price: ");
                Double price = scanner.nextDouble();

                MenuItem menuItem = MenuItemFactory.createMenuItem(resName, dishName, description, price);
                menuItemService.save(menuItem);

                System.out.println("The dish added successfully!");
                restaurantManagerPage();
            }
            case 0 -> {
                System.out.println("You are logged out");
                managementSystem();
            }
            default -> {
                System.err.println("Invalid choice");
                restaurantManagerPage();
            }
        }
    }

    private static void adminPage() throws SQLException {
        System.out.println("Welcome to admin page!");
        System.out.println("Menu: \n1. Create restaurant \n2. View all users in system BY USING JDBC CONVERTER \n0. Log out");
        switch (scanner.nextInt()){
            case 1 -> {
                System.out.println("Enter name:");
                String name = scanner.next();
                System.out.println("Enter address: ");
                String address = scanner.next();
                System.out.println("Enter cuisine: ");
                String cuisine = scanner.next();
                System.out.println("Enter the username of owner");
                String owner = scanner.next();

                Restaurant restaurant = RestaurantFactory.createRestaurant(name, address, cuisine, owner);

                restaurantService.save(restaurant);
                System.out.println("Restaurant successfully registered!");
                adminPage();
            }
            case 2 -> {
                Converter translate = new StringReaderAdapter(new ExecuteSQL());
                translate.translate(DatabaseMethods.SELECT, new Object[]{}, "customer");
                adminPage();
            }
            case 0 -> {
                System.out.println("You are logged out");
                managementSystem();
            }
            default -> {
                System.err.println("Invalid choice");
                adminPage();
            }
        }
    }

    private static void customerPage() throws SQLException {
        System.out.println("Welcome to customer page!");
        System.out.println("Menu: \n1. View all restaurants near " + currentUser.getAddress() + " \n2. View all dishes of restaurant \n3. Get all dishes \n4. Buy something \n0. Log out");
        switch (scanner.nextInt()){
            case 1 -> {
                List<Restaurant> nearRestaurants = restaurantService.findAllRestaurantsNear(currentUser.getAddress());
                System.out.println("List of restaurants near " + currentUser.getAddress() + ":");

                for (int i = 1; i <= 4; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");

                System.out.printf("| %-15.15s ", "restaurantId");
                System.out.printf("| %-15.15s ", "name");
                System.out.printf("| %-15.15s ", "address");
                System.out.printf("| %-15.15s ", "cuisine");
                System.out.println("|");

                for (int i = 1; i <= 4; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");

                for (Restaurant restaurant : nearRestaurants) {
                    System.out.printf("| %-15.15s ", restaurant.getRestaurantId());
                    System.out.printf("| %-15.15s ", restaurant.getName());
                    System.out.printf("| %-15.15s ", restaurant.getAddress());
                    System.out.printf("| %-15.15s ", restaurant.getCuisine());
                    System.out.println("|");
                }

                for (int i = 1; i <= 4; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");
                customerPage();
            }
            case 2 -> {
                System.out.println("Enter the restaurant name: ");
                String resName = scanner.next();
                List<MenuItem> menuItemList = menuItemService.findAllByRestaurantName(resName);

                // sout
                for (int i = 1; i <= 5; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");

                System.out.printf("| %-15.15s ", "ItemID");
                System.out.printf("| %-15.15s ", "RestaurantName");
                System.out.printf("| %-15.15s ", "Name");
                System.out.printf("| %-15.15s ", "Description");
                System.out.printf("| %-15.15s ", "Price");
                System.out.println("|");

                for (int i = 1; i <= 5; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");

                for (MenuItem menuItem : menuItemList) {
                    System.out.printf("| %-15.15s ", menuItem.getItemId());
                    System.out.printf("| %-15.15s ", menuItem.getRestaurantName());
                    System.out.printf("| %-15.15s ", menuItem.getName());
                    System.out.printf("| %-15.15s ", menuItem.getDescription());
                    System.out.printf("| %-15.15s ", menuItem.getPrice());
                    System.out.println("|");
                }

                for (int i = 1; i <= 5; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");
                customerPage();
            }
            case 3 -> {
                List<MenuItem> menuItemList = menuItemService.findAll();

                for (int i = 1; i <= 5; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");

                System.out.printf("| %-15.15s ", "ItemID");
                System.out.printf("| %-15.15s ", "RestaurantName");
                System.out.printf("| %-15.15s ", "Name");
                System.out.printf("| %-15.15s ", "Description");
                System.out.printf("| %-15.15s ", "Price");
                System.out.println("|");

                for (int i = 1; i <= 5; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");

                for (MenuItem menuItem : menuItemList) {
                    System.out.printf("| %-15.15s ", menuItem.getItemId());
                    System.out.printf("| %-15.15s ", menuItem.getRestaurantName());
                    System.out.printf("| %-15.15s ", menuItem.getName());
                    System.out.printf("| %-15.15s ", menuItem.getDescription());
                    System.out.printf("| %-15.15s ", menuItem.getPrice());
                    System.out.println("|");
                }

                for (int i = 1; i <= 5; i++) {
                    System.out.print("+-----------------");
                }
                System.out.println("+");
                customerPage();
            }
            case 4 -> {
                System.out.println("Enter the restaurant name: ");
                String resName = scanner.next();
                System.out.println("Enter the dish name: ");
                String dishName = scanner.next();

                // search

                System.out.println("Payment: \n1. Halyk \n2. Jusan \n3. Kaspi");
                String bankChoice = scanner.next();
                switch (bankChoice) {
                    case "Halyk" -> {
                        PaymentStrategy payment = new HalykBankPayment();
                        Payment process = new Payment(null, bankChoice);
                        paymentService.save(process);
                        payment.pay();
                    }
                    case "Jusan" -> {
                        PaymentStrategy payment = new JusanBankPayment();
                        Payment process = new Payment(null, bankChoice);
                        paymentService.save(process);
                        payment.pay();
                    }
                    case "Kaspi" -> {
                        PaymentStrategy payment = new KaspiBankPayment();
                        Payment process = new Payment(null, bankChoice);
                        paymentService.save(process);
                        payment.pay();
                    }
                    default -> {
                        System.err.println("Invalid choice");
                        customerPage();
                    }
                }

                // Observer Pattern for notification system
                NotificationSystem notifySys = new NotificationSystem();
                Observer observer = new CustomerOrder(currentUser, notifySys, dishName);
                notifySys.setNews(dishName);

                System.out.println(currentUser.getUsername() + " got the food");

                notifySys.removeCustomer(observer);

                customerPage();
            }
            case 0 -> {
                System.out.println("You are logged out");
                managementSystem();
            }
            default -> {
                System.err.println("Invalid choice");
                customerPage();
            }
        }
    }
}
