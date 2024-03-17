package io.github.britka.pages.workout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.github.britka.driver.DriverHolder;

/**
 * Created by Serhii Bryt
 * 16.03.2024 16:17
 **/
public class MyWorkoutTodayPage {
    Page page = DriverHolder.getInstance().getPage();

    public boolean isWorkoutVisible() {
        page.locator("#workout-iframe").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return page.locator("#workout-iframe").isVisible();
    }

    public ExerciseSettingsPage exerciseSettings() {
        return new ExerciseSettingsPage();
    }


}
