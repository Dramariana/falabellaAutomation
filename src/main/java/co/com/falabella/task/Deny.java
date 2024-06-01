package co.com.falabella.task;

import com.sun.media.jfxmedia.locator.Locator;
import javafx.scene.effect.Shadow;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Deny implements Task {
    WebDriver driver;

    public Deny(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SearchContext shadowRoot = driver.findElement(By.className("airship-html-prompt-shadow")).getShadowRoot();
        WebElement element = shadowRoot.findElement(By.cssSelector(".airship-prompt-container .airship-alert-buttons .airship-btn-deny"));
        element.click();
    }

    public static Deny popup(WebDriver driver) {
        return instrumented(Deny.class, driver);

    }


}
