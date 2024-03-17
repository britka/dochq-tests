package io.github.britka.application;

import io.github.britka.models.UserModel;
import io.github.britka.pages.BasePage;
import io.github.britka.pages.Utils;
import io.github.britka.pages.registration.ActivateRequestPage;
import io.github.britka.pages.registration.AfterActivationPage;
import io.qameta.allure.Step;

/**
 * Created by Serhii Bryt
 * 16.03.2024 20:28
 **/
public class Registration {
    @Step("Register user with {user} data. Login after registration: {loginAfterRegistration}")
    public Application registerUser(UserModel user, boolean loginAfterRegistration) {
        new BasePage()
                .switchToIndividualsAndFamilies()
                .signIn()
                .createAnAccount()
                .registerUser(user, ActivateRequestPage.class);
        AfterActivationPage afterActivationPage = Utils.activateAccount();
        if (loginAfterRegistration) {
            afterActivationPage
                    .pressLogin()
                    .login(user.getEmail(), user.getPassword(), true, BasePage.class);
        }
        return new Application();
    }
}
