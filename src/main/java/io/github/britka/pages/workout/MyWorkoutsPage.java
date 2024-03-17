package io.github.britka.pages.workout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.workout.plans.RecommendedWorkoutPlansPage;
import io.qameta.allure.Step;

/**
 * Created by Serhii Bryt
 * 16.03.2024 15:58
 **/
public class MyWorkoutsPage {
    Page page = DriverHolder.getInstance().getPage();

    public MyWorkoutsPage(Page page) {
        this.page = page;
    }

    public MyWorkoutsPage() {
    }

    @Step("Go to recommended training plans")
    public RecommendedWorkoutPlansPage recommendedPlans() {
        page.waitForTimeout(1000);
        Locator recommendedPlans = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("RECOMMENDED PLANS")).first();
        recommendedPlans.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.ATTACHED)
                .setState(WaitForSelectorState.VISIBLE));
        page.waitForTimeout(2000);
        recommendedPlans.click();
        return new RecommendedWorkoutPlansPage();
    }

    public String getWorkoutPlanName() {
        return page.locator("#plan_name").textContent();
    }

    public MyWorkoutTodayPage startWorkout() {
        page.locator("#start_workout_btn").click();
        return new MyWorkoutTodayPage();
    }
}
