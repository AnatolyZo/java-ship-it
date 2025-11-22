package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    static final int BASE_DELIVERY_COST = BaseDeliveryCost.STANDARD.getDeliveryCost();

    public StandardParcel() {

    }

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int calculateDeliveryCost() {
        return BASE_DELIVERY_COST * weight;
    }
}
