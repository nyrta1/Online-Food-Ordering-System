package sdpfinal.demo.services;

import sdpfinal.demo.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAllRestaurantsNear(String address);
    Restaurant findByName(String name);
    void save(Restaurant restaurant);
}
