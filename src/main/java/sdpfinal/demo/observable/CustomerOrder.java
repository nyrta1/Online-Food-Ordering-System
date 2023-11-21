package sdpfinal.demo.observable;

import sdpfinal.demo.models.Customer;

public class CustomerOrder implements Observer {
    private Customer customer;
    private String foodName;

    public CustomerOrder(Customer customer, Observable o, String foodName) {
        this.customer = customer;
        o.registerCustomer(this);
        this.foodName = foodName;
    }

    @Override
    public void update(String news) {
        System.out.println(customer.getUsername() + ", your meal is done " + foodName + "!");
    }
}
