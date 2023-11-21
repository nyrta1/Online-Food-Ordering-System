package sdpfinal.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdpfinal.demo.models.MenuItem;
import sdpfinal.demo.repositories.MenuItemRepository;
import sdpfinal.demo.services.MenuItemService;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public void save(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> findAllByRestaurantName(String resName) {
        return menuItemRepository.findAllByRestaurantName(resName);
    }

    @Override
    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }
}
