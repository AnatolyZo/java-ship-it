package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelsBox = new ParcelBox<>("для стандартных посылок", 100);
    private static ParcelBox<FragileParcel> fragileParcelsBox = new ParcelBox<>("для хрупких посылок", 100);
    private static ParcelBox<PerishableParcel> perishableParcelsBox = new ParcelBox<>("для скоропортящихся посылок", 100);
    private static List<Trackable> trackableParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    trackParcels();
                    break;
                case 5:
                    showBoxParcels();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить посылки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void showAddParcelMenu() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
    }

    private static void addParcel() {
        showAddParcelMenu();

        while (true) {
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case 1:
                    StandardParcel newStandardParcel = new StandardParcel();
                    newStandardParcel.setParameters();
                    standardParcelsBox.addParcel(newStandardParcel);
                    allParcels.add(newStandardParcel);
                    return;
                case 2:
                    FragileParcel newFragileParcel = new FragileParcel();
                    newFragileParcel.setParameters();
                    fragileParcelsBox.addParcel(newFragileParcel);
                    allParcels.add(newFragileParcel);
                    trackableParcels.add(newFragileParcel);
                    return;
                case 3:
                    PerishableParcel newPerishableParcel = new PerishableParcel();
                    newPerishableParcel.setParameters();
                    perishableParcelsBox.addParcel(newPerishableParcel);
                    allParcels.add(newPerishableParcel);
                    return;
                default:
                    System.out.println("Введите корректный номер типа посылки (1, 2 или 3).");
            }
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int parcelsTotalCost = 0;

        for (Parcel parcel : allParcels) {
            parcelsTotalCost += parcel.calculateDeliveryCost();
        }

        System.out.println("Стоимость доставки всех посылок составляет " + parcelsTotalCost);
    }

    private static void trackParcels() {
        System.out.println("Укажите новое местоположение посылки:");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void showBoxParcels() {
        showAddParcelMenu();

        int command = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case 1:
                standardParcelsBox.getAllParcels();
                return;
            case 2:
                fragileParcelsBox.getAllParcels();
                return;
            case 3:
                perishableParcelsBox.getAllParcels();
                return;
            default:
                System.out.println("Введите корректный номер типа посылки (1, 2 или 3).");
        }
    }
}

