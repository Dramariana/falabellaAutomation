package co.com.falabella.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.Duration;
import java.util.List;

import static co.com.falabella.userinterfaces.FalabellaHomePage.CATEGORY_MENU;
import static co.com.falabella.userinterfaces.FalabellaHomePage.MENU_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Select implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        MENU_BUTTON.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        actor.attemptsTo(Click.on(MENU_BUTTON));
        List<WebElementFacade> categoryList = CATEGORY_MENU.resolveAllFor(actor);

        System.out.println("Cantidad de categorias encontrados:" +  categoryList.size());
        for (int i = 0; i <  categoryList.size(); i++) {
            System.out.println("producto #" + (i + 1) + ": " +  categoryList.get(i).getText());
        }

    }

    public static Select Category() {
        return instrumented(Select.class);

    }
}
