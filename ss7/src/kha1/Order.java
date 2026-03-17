package kha1;

import java.util.HashMap;
import java.util.Map;

public class Order {
    String orderid;
    double total;
    Customer customer;
    Map<Product,Integer> products = new HashMap<>();
    public Order(String id,Customer customer){
        this.orderid=orderid;
        this.customer = customer;
    }
    public void add(Product p,int quantity){
        products.put(p,quantity);
    }
}
