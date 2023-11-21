package sdpfinal.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sdpfinal.demo.models.MenuItem;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findAllByRestaurantName(String restaurantName);
}
