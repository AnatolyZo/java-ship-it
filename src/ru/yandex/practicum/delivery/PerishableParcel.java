package ru.yandex.practicum.delivery;

import java.util.Scanner;

public class PerishableParcel extends Parcel {
    private int timeToLive;
    static final int BASE_DELIVERY_COST = BaseDeliveryCost.PERISHABLE.getDeliveryCost();

    public PerishableParcel() {

    }

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int calculateDeliveryCost() {
        return BASE_DELIVERY_COST * weight;
    }

    @Override
    public void setParameters() {
        super.setParameters();
        Scanner scanner = new Scanner(System.in);

        setTimeToLive(scanner);
    }

    public boolean isExpired(int currentDay) {
        if ((sendDay + timeToLive) >= currentDay) {
            return false;
        }

        return true;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Scanner scanner) {
        System.out.println("Введите срок годности посылки:");

        while (true) {
            int timeToLive = Integer.parseInt(scanner.nextLine());
            if (timeToLive > 0) {
                this.timeToLive = timeToLive;
                break;
            } else {
                System.out.println("Срок годности посылки должен быть больше нуля, повторите ввод.");
            }
        }
    }
}
