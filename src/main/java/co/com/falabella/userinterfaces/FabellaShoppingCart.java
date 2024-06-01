package co.com.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class FabellaShoppingCart extends PageObject {
    public static final Target SHOPPING_CART_TITLE = Target.the("shoppin_cart_title").located(By.xpath("//p[contains(text(),'Carro')]"));

    public static final Target SHOPPING_CART_NAMES = Target.the("shopping_cart_name").located(By.xpath("//*[@class='chakra-link css-1rkc0u7']"));
    public static final Target SHOPPING_CART_QUANTITY = Target.the("shopping_cart_quantity").located(By.xpath("//input[contains(@id, 'qty')]"));

}
