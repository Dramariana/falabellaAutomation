package co.com.falabella.stepdefinitions;

import co.com.falabella.task.Deny;
import co.com.falabella.task.SelectCategory;
import co.com.falabella.task.SelectProduct;
import co.com.falabella.task.SelectShoppingCart;
import co.com.falabella.userinterfaces.FalabellaHomePage;
import co.com.falabella.utils.Product;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.ArrayList;
import java.util.List;

public class FalabellaAutomationStepdefinition {


    FalabellaHomePage falabellaHomePage;
    List<Product> productShoppingCart;
    List<Float> productShoppingCartPrices;
    List<Product> productShoppingCartVerification;
    List<Float> productShoppingCartVerificationPrices;
    @Managed(driver = "firefox", uniqueSession = true)
    public WebDriver hisBrowser;


    private final Actor user = Actor.named("Mariana");


    @Before
    public void actorCanBrowseTheWeb() {
        user.can(BrowseTheWeb.with(hisBrowser));
        hisBrowser.manage().window().maximize();
        FirefoxProfile profile = new FirefoxProfile();
        // Configurar el perfil según sea necesario
        FirefoxOptions options = new FirefoxOptions().setProfile(profile);
        options.setAcceptInsecureCerts(true);
    }

    @Given("user enters falabella site")
    public void userEntersFalabellaSite() {
        user.wasAbleTo(Open.browserOn().the(falabellaHomePage));
        user.attemptsTo(Deny.popup(hisBrowser));
    }

    @Given("user select category")
    public void userSelectCategory() {
        user.attemptsTo(SelectCategory.randomly());

    }

    @When("user select three products")
    public void userSelectThreeProducts() {
        productShoppingCart = new ArrayList<Product>();
        productShoppingCartVerification = new ArrayList<Product>();
        productShoppingCartPrices = new ArrayList<Float>();
        productShoppingCartVerificationPrices = new ArrayList<Float>();
        user.attemptsTo(SelectProduct.randomly(productShoppingCart, productShoppingCartPrices));
        user.attemptsTo(SelectShoppingCart.view(productShoppingCartVerification, productShoppingCartVerificationPrices));

        assertThat(productShoppingCartVerification, containsInAnyOrder(productShoppingCart.toArray()));
        Product productTotal = new Product();
        productTotal.Total(productShoppingCartVerification);
    }

    @Then("user sees the total value of his purchase")
    public void userSeesTheTotalValueOfHisPurchase() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
