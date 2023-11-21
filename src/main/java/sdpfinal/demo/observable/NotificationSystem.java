package sdpfinal.demo.observable;

import sdpfinal.demo.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem implements Observable {
    private List<Observer> customerList;
    private String news;

    public NotificationSystem() {
        customerList = new ArrayList<>();
    }

    public void setNews(String news) {
        this.news = news;
        notifyCustomers();
    }

    @Override
    public void registerCustomer(Observer o) {
        customerList.add(o);
    }

    @Override
    public void removeCustomer(Observer o) {
        customerList.remove(o);
    }

    @Override
    public void notifyCustomers() {
        for (Observer order : customerList) {
            order.update(news);
        }
    }
}
