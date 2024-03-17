package io.github.britka.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.workout.subscriptions.SubscriptionPage;

/**
 * Created by Serhii Bryt
 * 15.03.2024 16:35
 **/
public class PersonalTrainerStartPage {
    Page page = DriverHolder.getInstance().getPage();

    public void startAssessment() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("START ASSESSMENT")).click();
    }

    public SubscriptionPage startFreeTrial() {
        Page startFreeTrail = page.context().waitForPage(() ->
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("START FREE TRIAL")).click()
        );
        DriverHolder.getInstance().setPage(startFreeTrail);
        return new SubscriptionPage();
    }
}
