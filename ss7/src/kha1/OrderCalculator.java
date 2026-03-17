package kha1;

public class OrderCalculator {
    public double caculateTotal(Order order){
        double sum = 0;
        for (Product p: order.products.keySet()){
            int qty = order.products.get(p);
            sum += p.price*qty;
        }
        return sum;
    }
}
