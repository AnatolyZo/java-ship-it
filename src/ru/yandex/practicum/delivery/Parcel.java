package ru.yandex.practicum.delivery;
import java.util.Scanner;

public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    @Override
    public String toString() {
        return "Наименование - " + description +
                ", вес - " + weight +
                ", адрес доставки - " + deliveryAddress +
                ", день отправления посылки - " + sendDay;
    }

    public Parcel() {

    }

    //Классы с параметрами введены для удобства проведения юнит-тестов
    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        if (this instanceof FragileParcel) {
            System.out.println("Посылка " + description + " обернута в защитную пленку.");
        }
        System.out.println("Посылка " + description + " упакована.");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress + ".");
    }

    public abstract int calculateDeliveryCost();

    public String getDescription() {
        return description;
    }

    public void setDescription(Scanner scanner) {
        System.out.println("Введите описание посылки:");

        /*Здесь и далее в методах set проверка пустой строки для полей String
        и проверка положительных значений для полей int*/
        while (true) {
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                this.description = description;
                break;
            } else {
                System.out.println("Не введено наименование посылки, повторите ввод.");
            }
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Scanner scanner) {
        System.out.println("Введите вес посылки:");

        while (true) {
            int weight = Integer.parseInt(scanner.nextLine());
            if (weight > 0) {
                this.weight = weight;
                break;
            } else {
                System.out.println("Вес посылки должен быть больше нуля, повторите ввод.");
            }
        }
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Scanner scanner) {
        System.out.println("Введите адрес доставки:");

        while (true) {
            String deliveryAddress = scanner.nextLine();
            if (!deliveryAddress.isEmpty()) {
                this.deliveryAddress = deliveryAddress;
                break;
            } else {
                System.out.println("Не введен адрес доставки посылки посылки, повторите ввод.");
            }
        }
    }

    public int getSendDay() {
        return sendDay;
    }

    public void setSendDay(Scanner scanner) {
        System.out.println("Введите день отправления посылки:");

        while (true) {
            int sendDay = Integer.parseInt(scanner.nextLine());
            if (sendDay > 0) {
                this.sendDay = sendDay;
                break;
            } else {
                System.out.println("День отправки посылки должен быть больше нуля, повторите ввод.");
            }
        }
    }

    //Метод, необходимый для создания объекта конкретной посылки
    public void setParameters() {
        Scanner scanner = new Scanner(System.in);

        setDescription(scanner);
        setWeight(scanner);
        setDeliveryAddress(scanner);
        setSendDay(scanner);
    }
}
