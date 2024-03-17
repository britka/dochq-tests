package io.github.britka.pages;

import io.github.britka.AppConfig;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.registration.AfterActivationPage;
import io.github.britka.pages.registration.RegistrationPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Serhii Bryt
 * 15.03.2024 14:47
 **/

public class Utils {
    @Step("Activate user")
    public static AfterActivationPage activateAccount() {
        String token = RegistrationPage.token.get();
        String activationUrl = AppConfig.getProperty("BASE_URL") + "/user/activate/" + token;
        DriverHolder.getInstance().getPage().navigate(activationUrl);
        return new AfterActivationPage();
    }
}
