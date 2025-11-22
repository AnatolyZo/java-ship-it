package ru.yandex.practicum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {
    //Вычисление стоимости стандартной посылки при весе 20, базовая стоимость - 2
    @Test
    public void shouldBeStandardParcelCost40IfWeight20() {
        StandardParcel standardParcel = new StandardParcel("Стол", 20,
                "ул. 8 марта, 10", 2);
        Assertions.assertEquals(40, standardParcel.calculateDeliveryCost());
    }

    //Вычисление стоимости хрупкой посылки при весе 15, базовая стоимость - 4
    @Test
    public void shouldBeFragileParcelCost60IfWeight15() {
        FragileParcel fragileParcel = new FragileParcel("Стекло", 15,
                "ул. Свободы, 38", 2);
        Assertions.assertEquals(60, fragileParcel.calculateDeliveryCost());
    }

    //Вычисление стоимости скоропортящейся посылки при весе 5, базовая стоимость - 3
    @Test
    public void shouldBePerishableParcelCost15IfWeight5() {
        PerishableParcel perishableParcel = new PerishableParcel("Сыр", 5,
                "ул. Мира, 117", 2, 15);
        Assertions.assertEquals(15, perishableParcel.calculateDeliveryCost());
    }
}
