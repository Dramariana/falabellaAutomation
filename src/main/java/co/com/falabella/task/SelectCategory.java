package co.com.falabella.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static co.com.falabella.userinterfaces.FalabellaHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectCategory implements Task {
    Random random = new Random();

    @Override
    public <T extends Actor> void performAs(T actor) {

        MENU_BUTTON.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        actor.attemptsTo(Click.on(MENU_BUTTON));

        List<WebElementFacade> categoryList = CATEGORY_MENU.resolveAllFor(actor);


        int randomNumber = random.nextInt(categoryList.size());

        actor.attemptsTo(
                Click.on(categoryList.get(randomNumber)));

        List<WebElementFacade> secondCategoryList = SECOND_CATEGORY_MENU.resolveAllFor(actor);

        randomNumber = random.nextInt(secondCategoryList.size());

        actor.attemptsTo(
                Scroll.to(secondCategoryList.get(randomNumber)),
                Click.on(secondCategoryList.get(randomNumber)));

    }

    public static SelectCategory randomly() {
        return instrumented(SelectCategory.class);

    }

}
