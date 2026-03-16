package Xuatsac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Ticket {
    String id;
    String roomName;
    boolean isSold = false;
    boolean isHeld = false;
    boolean isVIP = false;
    long holdExpiryTime = 0;

    public Ticket(String id, String roomName) {
        this.id = id;
        this.roomName = roomName;
    }

    public synchronized boolean isAvailable() {
        if (isSold) return false;
        if (!isHeld) return true;
        return System.currentTimeMillis() > holdExpiryTime;
    }
}

class TicketPool {
    String roomName;
    List<Xuatsac.bai2.Ticket> tickets;

    public TicketPool(String roomName, int count) {
        this.roomName = roomName;
        this.tickets = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            tickets.add(new Xuatsac.bai2.Ticket(roomName + "-" + String.format("%03d", i), roomName));
        }
    }

    public synchronized Xuatsac.bai2.Ticket holdTicket(boolean asVIP) {
        for (Xuatsac.bai2.Ticket t : tickets) {
            if (t.isAvailable()) {
                t.isHeld = true;
                t.isVIP = asVIP;
                t.holdExpiryTime = System.currentTimeMillis() + 5000;
                return t;
            }
        }
        return null;
    }

    public synchronized void sellHeldTicket(Xuatsac.bai2.Ticket t) {
        if (t != null && t.isHeld) {
            t.isSold = true;
            t.isHeld = false;
            t.holdExpiryTime = 0;
        }
    }

    public synchronized void releaseExpiredTickets() {
        long now = System.currentTimeMillis();
        for (Xuatsac.bai2.Ticket t : tickets) {
            if (t.isHeld && !t.isSold && now > t.holdExpiryTime) {
                System.out.println(">>> [TimeoutManager]: Vé " + t.id + " hết hạn giữ, đã trả lại kho");
                t.isHeld = false;
                t.holdExpiryTime = 0;
                t.isVIP = false;
            }
        }
    }
}

class BookingCounter extends Thread {
    String counterName;
    Xuatsac.bai2.TicketPool pool;
    boolean isVIP;
    boolean customerWillPay;

    public BookingCounter(String name, Xuatsac.bai2.TicketPool pool, boolean isVIP, boolean pay) {
        this.counterName = name;
        this.pool = pool;
        this.isVIP = isVIP;
        this.customerWillPay = pay;
    }

    @Override
    public void run() {
        Xuatsac.bai2.Ticket t = pool.holdTicket(isVIP);
        if (t != null) {
            System.out.println(counterName + ": Đã giữ vé " + t.id + (isVIP ? " (VIP)" : "") + ". Vui lòng thanh toán trong 5s");

            try {
                Thread.sleep(3000);

                if (customerWillPay) {
                    pool.sellHeldTicket(t);
                    System.out.println(counterName + ": Thanh toán thành công vé " + t.id);
                } else {
                    System.out.println(counterName + ": Khách không thực hiện thanh toán...");
                }
            } catch (InterruptedException e) {
                System.out.println(counterName + " bị gián đoạn.");
            }
        } else {
            System.out.println(counterName + ": Phòng " + pool.roomName + " đang bận hoặc hết vé, vui lòng chờ...");
        }
    }
}

class TimeoutManager extends Thread {
    List<Xuatsac.bai2.TicketPool> pools;

    public TimeoutManager(List<Xuatsac.bai2.TicketPool> pools) {
        this.pools = pools;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (Xuatsac.bai2.TicketPool p : pools) {
                    p.releaseExpiredTickets();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }
    }
}

public class bai1 {
    public static void main(String[] args) throws InterruptedException {
        Xuatsac.bai2.TicketPool poolA = new Xuatsac.bai2.TicketPool("A", 10);
        Xuatsac.bai2.TicketPool poolB = new Xuatsac.bai2.TicketPool("B", 10);
        Xuatsac.bai2.TicketPool poolC = new Xuatsac.bai2.TicketPool("C", 10);
        List<Xuatsac.bai2.TicketPool> allPools = Arrays.asList(poolA, poolB, poolC);

        TimeoutManager manager = new TimeoutManager(allPools);
        manager.start();

        System.out.println("--- HỆ THỐNG BÁN VÉ BẮT ĐẦU ---");

        BookingCounter q1 = new BookingCounter("Quầy 1", poolA, true, true);
        q1.start();

        Thread.sleep(1000);
        BookingCounter q2 = new BookingCounter("Quầy 2", poolA, false, false);
        q2.start();


        Thread.sleep(10000);

        System.out.println("\n--- Sau 10 giây ---");
        BookingCounter q3 = new BookingCounter("Quầy 3", poolA, false, true);
        q3.start();

        q3.join();
        System.out.println("--- KẾT THÚC PHIÊN LÀM VIỆC ---");
    }
}