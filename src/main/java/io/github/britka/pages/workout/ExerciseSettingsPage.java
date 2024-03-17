package io.github.britka.pages.workout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.github.britka.driver.DriverHolder;
import io.qameta.allure.Step;

import java.util.regex.Pattern;

/**
 * Created by Serhii Bryt
 * 16.03.2024 16:18
 **/
public class ExerciseSettingsPage {
    Page page = DriverHolder.getInstance().getPage();


    @Step("Set exercise setting: showMeIntroduction: {showMeIntroduction}, showMeScore: {showMeScore}")
    public MyWorkoutTodayPage setExerciseSettings(boolean showMeIntroduction, boolean showMeScore) {
        Locator showMeIntro = page
                .getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions()
                        .setName(Pattern.compile("^.*exercise Introduction.*$")));
        Locator showScore = page
                .getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions()
                        .setName(Pattern.compile("^.*score after each exercise.*$")));
        if (showMeIntroduction) showMeIntro.check();
        else showMeIntro.uncheck();

        if (showMeScore) showScore.check();
        else showScore.uncheck();

        Locator save = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SAVE"));
        save.click();
        save.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
        return new MyWorkoutTodayPage();
    }
}
