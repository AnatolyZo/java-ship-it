package ru.yandex.practicum.delivery;

public enum BaseDeliveryCost {
    STANDARD(2),
    PERISHABLE(3),
    FRAGILE(4);

    private int deliveryCost;

    BaseDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }
}
