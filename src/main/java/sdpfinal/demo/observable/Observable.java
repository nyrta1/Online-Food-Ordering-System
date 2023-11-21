package sdpfinal.demo.observable;

public interface Observable {
    void registerCustomer(Observer o);
    void removeCustomer(Observer o);
    void notifyCustomers();
}
