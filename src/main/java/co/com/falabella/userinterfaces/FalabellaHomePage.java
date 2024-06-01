package co.com.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.falabella.com.co/falabella-co")
public class FalabellaHomePage extends PageObject {

    public static final Target MENU_BUTTON= Target.the("menu_button").located(By.id("testId-HamburgerBtn-toggle"));

    public static final Target CATEGORY_MENU= Target.the("category_menu").located(By.className("TaxonomyDesktop-module_categoryWrapper__3YBaF"));
    public static final Target SECOND_CATEGORY_MENU= Target.the("second_category_menu").located(By.className("SecondLevelCategories-module_secondLevelCategoryTitle__13Ukq"));

}
