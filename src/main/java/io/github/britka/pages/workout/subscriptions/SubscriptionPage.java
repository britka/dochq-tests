package io.github.britka.pages.workout.subscriptions;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.github.britka.driver.DriverHolder;
import io.github.britka.models.CardData;
import io.github.britka.pages.workout.MyWorkoutsPage;
import io.qameta.allure.Step;

/**
 * Created by Serhii Bryt
 * 15.03.2024 18:59
 **/
public class SubscriptionPage {
    Page page = DriverHolder.getInstance().getPage();

    public SubscriptionPage(Page page) {
        this.page = page;
    }

    public SubscriptionPage() {
    }

    @Step("Select subscription: {plan}")
    public SubscriptionPage selectPlan(PlanEnum plan) {
        page.locator("_react=[name $= \"%s\"]".formatted(plan.name()))
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("SELECT"))
                .click();
        return this;
    }

    public SubscriptionPage previous() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("PREVIOUS")).click();
        return this;
    }

    public SubscriptionPage next() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
        return this;
    }

    @Step("Enter card data: {cardData}")
    public SubscriptionPage enterCardData(CardData cardData) {
        FrameLocator frame = page.frameLocator("[name*=__privateStripeFrame]").first();
        frame.getByRole(AriaRole.TABLIST, new FrameLocator.GetByRoleOptions().setName("Payment Methods"))
                .getByTestId("card")
                .click();
        frame.locator("#Field-numberInput").fill(cardData.getCardNumber());
        frame.locator("#Field-expiryInput").fill(cardData.getDate());
        frame.locator("#Field-cvcInput").fill(cardData.getCvv());
        frame.locator("#Field-countryInput").selectOption("United States");
        frame.locator("#Field-postalCodeInput").fill("12234");
        page.locator("#pay-now").click();
        return this;
    }

    public MyWorkoutsPage goToTrainings() {
        Locator goToTrainings = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("GO TO TRAININGS"));
        goToTrainings.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        goToTrainings.click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("START")).click();
        return new MyWorkoutsPage();
    }

    public enum PlanEnum {
        Monthly,
        Quarterly,
        Annual
    }

}
