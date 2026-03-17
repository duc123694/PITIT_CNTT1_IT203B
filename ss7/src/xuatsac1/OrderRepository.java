package xuatsac1;

import java.util.*;

interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
