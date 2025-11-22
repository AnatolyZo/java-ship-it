package ru.yandex.practicum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

public class AddParcelInBoxTest {
    //Определение возможности добавления в коробку 3 посылок общим весом 101 при вместимости коробки 100
    @Test
    public void should3ParcelsBeAddedWhenSummuryWeight101() {
        ParcelBox<StandardParcel> standardParcelsBox = new ParcelBox<>("для стандартных посылок",
                100);
        standardParcelsBox.addParcel(new StandardParcel("Стол", 20,
                "ул. 8 марта, 10", 1));
        standardParcelsBox.addParcel(new StandardParcel("Стеллаж", 30,
                "ул. Мира, 117", 1));
        standardParcelsBox.addParcel(new StandardParcel("Шкаф", 51,
                "ул. Ленина, 13", 1));

        Assertions.assertEquals(2, standardParcelsBox.getListOfParcels().size());
    }

    //Определение возможности добавления в коробку 3 посылок общим весом 100 при вместимости коробки 100
    @Test
    public void should3ParcelsBeAddedWhenSummuryWeight100() {
        ParcelBox<StandardParcel> standardParcelsBox = new ParcelBox<>("для стандартных посылок",
                100);
        standardParcelsBox.addParcel(new StandardParcel("Стол", 20,
                "ул. 8 марта, 10", 1));
        standardParcelsBox.addParcel(new StandardParcel("Стеллаж", 30,
                "ул. Мира, 117", 1));
        standardParcelsBox.addParcel(new StandardParcel("Шкаф", 50,
                "ул. Ленина, 13", 1));

        Assertions.assertEquals(3, standardParcelsBox.getListOfParcels().size());
    }

    //Определение возможности добавления в коробку 3 посылок общим весом 99 при вместимости коробки 100
    @Test
    public void should3ParcelsBeAddedWhenSummuryWeight99() {
        ParcelBox<StandardParcel> standardParcelsBox = new ParcelBox<>("для стандартных посылок",
                100);
        standardParcelsBox.addParcel(new StandardParcel("Стол", 20,
                "ул. 8 марта, 10", 1));
        standardParcelsBox.addParcel(new StandardParcel("Стеллаж", 30,
                "ул. Мира, 117", 1));
        standardParcelsBox.addParcel(new StandardParcel("Шкаф", 49,
                "ул. Ленина, 13", 1));

        Assertions.assertEquals(3, standardParcelsBox.getListOfParcels().size());
    }
}
