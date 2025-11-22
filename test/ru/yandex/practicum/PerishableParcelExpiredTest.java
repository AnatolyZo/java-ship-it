package ru.yandex.practicum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.PerishableParcel;

public class PerishableParcelExpiredTest {
    //Определение годности скоропортящейся посылки на 16 день со сроком годности 15, отправленной 1 числа
    @Test
    public void shouldPerishableParcelBeExpiredWhenCurrentDay16AndSendDay1AndTimeToLive15() {
        PerishableParcel perishableParcel = new PerishableParcel("Сыр", 5,
                "ул. Мира, 117", 1, 15);
        int currentDay = 16;
        Assertions.assertFalse(perishableParcel.isExpired(currentDay));
    }

    //Определение годности скоропортящейся посылки на 17 день со сроком годности 15, отправленной 1 числа
    @Test
    public void shouldPerishableParcelBeExpiredWhenCurrentDay17AndSendDay1AndTimeToLive15() {
        PerishableParcel perishableParcel = new PerishableParcel("Сыр", 5,
                "ул. Мира, 117", 1, 15);
        int currentDay = 17;
        Assertions.assertTrue(perishableParcel.isExpired(currentDay));
    }

    //Определение годности скоропортящейся посылки на 15 день со сроком годности 15, отправленной 1 числа
    @Test
    public void shouldPerishableParcelBeExpiredWhenCurrentDay15AndSendDay1AndTimeToLive15() {
        PerishableParcel perishableParcel = new PerishableParcel("Сыр", 5,
                "ул. Мира, 117", 1, 15);
        int currentDay = 15;
        Assertions.assertFalse(perishableParcel.isExpired(currentDay));
    }
}
