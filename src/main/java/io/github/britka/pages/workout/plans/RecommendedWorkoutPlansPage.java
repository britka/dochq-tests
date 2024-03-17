package io.github.britka.pages.workout.plans;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.workout.MyWorkoutsPage;
import io.qameta.allure.Step;

/**
 * Created by Serhii Bryt
 * 16.03.2024 16:00
 **/
public class RecommendedWorkoutPlansPage {
    Page page = DriverHolder.getInstance().getPage();

    public RecommendedWorkoutPlansPage(Page page) {
        this.page = page;
    }

    public RecommendedWorkoutPlansPage() {
    }

    @Step("Select recommended plan: {planName}")
    public MyWorkoutsPage selectPlan(String planName){
        page.waitForTimeout(3000);
        Locator select = page.getByText(planName)
                .locator("..")
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("SELECT"));
        select.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        select.click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("NEXT")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("START")).click();
        return new MyWorkoutsPage();
    }
}
