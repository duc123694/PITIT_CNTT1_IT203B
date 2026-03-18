package Bai4;

public class b4 {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach(new Fan());
        sensor.attach(new Humidifier());

        sensor.setTemperature(18);
        sensor.setTemperature(26);
    }
}
