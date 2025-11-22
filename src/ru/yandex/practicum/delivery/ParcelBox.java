package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private String boxDescription;
    private int currentBoxWeight;
    private final int maxBoxWieght;
    ArrayList<T> listOfParcels = new ArrayList<>();

    public ParcelBox(String boxDescription, int maxBoxWieght) {
        this.boxDescription = boxDescription;
        currentBoxWeight = 0;
        this.maxBoxWieght = maxBoxWieght;
    }

    public void addParcel(T newParcel) {
        //Вычисление свободного места в коробке под посылку (максималный вес минус вес текущего заполнения)
        if (newParcel.getWeight() <= (maxBoxWieght - currentBoxWeight)) {
            listOfParcels.add(newParcel);
            currentBoxWeight += newParcel.getWeight();
        } else {
            System.out.println("Посылку невозможно добавить в коробку в связи с превышением допустимого веса коробки.");
        }
    }

    public void getAllParcels() {
        if (listOfParcels.size() == 0) {
            System.out.println("Коробка " + boxDescription + " пуста.");
        } else {
            System.out.println("Содержимое коробки " + boxDescription + ":");
        }

        for (T parcel : listOfParcels) {
            System.out.println(parcel);
        }
    }

    public String getBoxDescription() {
        return boxDescription;
    }

    public void setBoxDescription(String boxDescription) {
        this.boxDescription = boxDescription;
    }

    public int getCurrentBoxWeight() {
        return currentBoxWeight;
    }

    public void setCurrentBoxWeight(int currentBoxWeight) {
        this.currentBoxWeight = currentBoxWeight;
    }

    public int getMaxBoxWieght() {
        return maxBoxWieght;
    }

    public ArrayList<T> getListOfParcels() {
        return listOfParcels;
    }

    public void setListOfParcels(ArrayList<T> listOfParcels) {
        this.listOfParcels = listOfParcels;
    }
}
