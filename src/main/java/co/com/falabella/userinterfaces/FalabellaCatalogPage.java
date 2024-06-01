package co.com.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class FalabellaCatalogPage extends PageObject {

    public static final Target BUTTON_ADD_CART = Target.the("button_add_cart").located(By.xpath("//button[contains(@id, 'testId-Pod')]"));
    public static final Target DENY_PRECART = Target.the("deny_precart").located(By.xpath("//*[@id=\"testId-searchResults\"]/div[1]/div/div/div/div/div[1]/button"));
    public static final Target PRE_SHOPPING_CART = Target.the("pre_shopping_cart").located(By.xpath("//*[@class='jsx-1941891310 footer']"));
    public static final Target ADD_CART = Target.the("add_cart").located(By.id("add-to-cart"));
    public static final Target SHOPPING_CART = Target.the("shopping_cart").located(By.id("testId-UserAction-basket"));

    public static final Target PRODUCT_QUANTITY = Target.the("product_quantity").located(By.id("testId-stepper-input"));

    public static final Target CATALOG_NAMES = Target.the("catalog_result").located(By.xpath("//*[contains(@id, 'testId-pod-displaySubTitle')]"));
    public static final Target CATALOG_PRICE = Target.the("catalog_price").located(By.xpath("//*[contains(@class, 'copy10 primary medium jsx-3451706699 normal')]"));
    public static final Target PRODUCT_PRICE = Target.the("product_price").located(By.xpath("//*[@class='chakra-text price-2 css-1tup3zp']"));

    public static final Target PRODUCT_SIZE = Target.the("product_size").located(By.xpath("//button[contains(@id, 'testId-sizeButton')]"));
    public static final Target PRODUCT_STOCK = Target.the("product_stock").located(By.xpath("//*[@class= 'jsx-4205635298 max-units-text']"));
    public static final Target TOTAL_SHOPPING_CART = Target.the("total_shopping_cart").located(By.xpath("//*[@class='chakra-text css-1nq5gzm'][contains(text(), '$')]"));

}
