package co.com.falabella.task;

import co.com.falabella.utils.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.Random;


import static co.com.falabella.userinterfaces.FalabellaCatalogPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class
SelectProduct implements Task {
    Random random = new Random();
    List<Product> productShoppingCart;
    List<Float> productShoppingCartPrices;
    Float price;

    public SelectProduct(List<Product> productShoppingCart, List<Float> productShoppingCartPrices) {
        this.productShoppingCart = productShoppingCart;
        this.productShoppingCartPrices = productShoppingCartPrices;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int randomNumber, randomQuantity;
        CATALOG_NAMES.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        List<WebElementFacade> productList = CATALOG_NAMES.resolveAllFor(actor);
        List<WebElementFacade> pricesList = CATALOG_PRICE.resolveAllFor(actor);
        List<WebElementFacade> buttonList = BUTTON_ADD_CART.resolveAllFor(actor);


        for (int i = 0; i < 3; i++) {

            randomNumber = random.nextInt(productList.size());
            //randomQuantity = random.nextInt(5) + 1;
            price = Float.parseFloat(pricesList.get(randomNumber).getText().replace("$", "").replace(".", "").replace(" ", ""));
            actor.attemptsTo(
                    Scroll.to(productList.get(randomNumber)),
                    HoverOverElement.over(buttonList.get(randomNumber)),
                    Click.on(buttonList.get(randomNumber))
            );


            if (PRODUCT_SIZE.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor)) {
                actor.attemptsTo(
                        Click.on(PRODUCT_SIZE)
                );
            }


            if (PRODUCT_QUANTITY.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor)) {
                String stockString = PRODUCT_STOCK.resolveFor(actor).getText().replace("unidades.", "").replace(" ", "").substring(6);
                int stock = Integer.parseInt(stockString);
                if (stock > 5) {
                    randomQuantity = random.nextInt(5) + 1;
                } else {
                    randomQuantity = random.nextInt(stock) + 1;
                }
                productShoppingCart.add(new Product(productList.get(randomNumber).getText(), randomQuantity));
                productShoppingCartPrices.add(price * randomQuantity);
                actor.attemptsTo(
                        WaitUntil.the(DENY_PRECART, isVisible()).forNoMoreThan(5).seconds(),
                        SendKeys.of(Keys.BACK_SPACE).into(PRODUCT_QUANTITY),
                        Enter.theValue(String.valueOf(randomQuantity)).into(PRODUCT_QUANTITY),
                        Click.on(PRE_SHOPPING_CART)
                );
            } else {
                productShoppingCart.add(new Product(productList.get(randomNumber).getText(), 1));
                productShoppingCartPrices.add(price);
            }
            if (ADD_CART.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor)) {
                actor.attemptsTo(
                        Click.on(ADD_CART));
            }
            if (DENY_PRECART.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor)) {
                actor.attemptsTo(
                        WaitUntil.the(DENY_PRECART, isClickable()).forNoMoreThan(5).seconds(),
                        JavaScriptClick.on(DENY_PRECART),
                        WaitUntil.the(DENY_PRECART, isNotVisible()).forNoMoreThan(5).seconds()
                );
            }
        }

    }

    public static SelectProduct randomly(List<Product> productShoppingCart, List<Float> productShoppingCartPrices) {
        return instrumented(SelectProduct.class, productShoppingCart, productShoppingCartPrices);

    }
}
