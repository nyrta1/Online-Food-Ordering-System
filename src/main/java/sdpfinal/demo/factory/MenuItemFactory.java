package sdpfinal.demo.factory;

import sdpfinal.demo.models.MenuItem;
import sdpfinal.demo.models.Restaurant;

public class MenuItemFactory {
    public static MenuItem createMenuItem(String restaurantName,
                                   String name,
                                   String description,
                                   Double price) {
        MenuItem menuItem = new MenuItem();

        menuItem.setItemId(null);
        menuItem.setRestaurantName(restaurantName);
        menuItem.setName(name);
        menuItem.setDescription(description);
        menuItem.setPrice(price);

        return menuItem;
    }
}
