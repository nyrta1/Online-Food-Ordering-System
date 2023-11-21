package sdpfinal.demo.services;

import sdpfinal.demo.models.MenuItem;

import java.util.List;

public interface MenuItemService {
    void save(MenuItem menuItem);

    List<MenuItem> findAllByRestaurantName(String resName);

    List<MenuItem> findAll();
}
