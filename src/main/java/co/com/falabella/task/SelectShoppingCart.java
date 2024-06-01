package co.com.falabella.task;

import co.com.falabella.utils.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import java.time.Duration;
import java.util.List;

import static co.com.falabella.userinterfaces.FabellaShoppingCart.*;
import static co.com.falabella.userinterfaces.FalabellaCatalogPage.PRODUCT_PRICE;
import static co.com.falabella.userinterfaces.FalabellaCatalogPage.SHOPPING_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectShoppingCart implements Task {
    List<Product> productShoppingCartVerification;
    List<Float> productShoppingCartVerificationPrices;

    public SelectShoppingCart(List<Product> productShoppingCartVerification, List<Float> productShoppingCartVerificationPrices) {

        this.productShoppingCartVerification = productShoppingCartVerification;
        this.productShoppingCartVerificationPrices = productShoppingCartVerificationPrices;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int quantity;
        float price;
        actor.attemptsTo(
                Click.on(SHOPPING_CART)
        );
        SHOPPING_CART_TITLE.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        List<WebElementFacade> productCartListName = SHOPPING_CART_NAMES.resolveAllFor(actor);
        List<WebElementFacade> productCartListQuantity = SHOPPING_CART_QUANTITY.resolveAllFor(actor);
        List<WebElementFacade> productCartListPrice = PRODUCT_PRICE.resolveAllFor(actor);

        for (int i = 0; i < productCartListName.size(); i++) {
            quantity = Integer.valueOf(productCartListQuantity.get(i).getValue());
            price = Float.parseFloat(productCartListPrice.get(i).getText().replace("$", "").replace(".", "").replace(" ", ""));
            productShoppingCartVerification.add(new Product(productCartListName.get(i).getText(), quantity));
            productShoppingCartVerificationPrices.add(price * quantity);
        }
    }

    public static SelectShoppingCart view(List<Product> productShoppingCartVerification, List<Float> productShoppingCartVerificationPrices) {
        return instrumented(SelectShoppingCart.class, productShoppingCartVerification, productShoppingCartVerificationPrices);

    }
}
