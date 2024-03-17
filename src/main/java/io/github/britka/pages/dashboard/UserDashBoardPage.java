package io.github.britka.pages.dashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.PersonalTrainerStartPage;

/**
 * Created by Serhii Bryt
 * 15.03.2024 16:22
 **/
public class UserDashBoardPage {
    Page page = DriverHolder.getInstance().getPage();

    public PersonalTrainerStartPage startPersonalTrainer() {
        startOption(DashboardOptions.PERSONAL_TRAINER);
        return new PersonalTrainerStartPage();
    }



    private void startOption(DashboardOptions option) {
        page.locator(option.getValue())
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("START"))
                .click();
    }

    public enum DashboardOptions {
        PERSONAL_TRAINER("#service_tile_personal-trainer"),
        PHYSIOTHERAPY("#service_tile_physiotherapy"),
        TRAVEL_MEDICINE_CHECKER("#service_tile_travel-medicine-checker"),
        HEALTH_CHECKS_MENU("#service_tile_health-checks-menu");
        private String value;

        DashboardOptions(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
