package sdpfinal.demo.factory;

import sdpfinal.demo.models.Restaurant;

public class RestaurantFactory {
    public static Restaurant createRestaurant(String name,
                                       String address,
                                       String cuisine, String owner) {
        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantId(null);
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setCuisine(cuisine);
        restaurant.setOwner(owner);

        return restaurant;
    }
}
