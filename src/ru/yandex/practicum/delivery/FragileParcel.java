package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    static final int BASE_DELIVERY_COST = BaseDeliveryCost.FRAGILE.getDeliveryCost();

    public FragileParcel() {

    }

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int calculateDeliveryCost() {
        return BASE_DELIVERY_COST * weight;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation + ".");
    }
}
