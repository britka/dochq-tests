package io.github.britka.pages.signin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;
import io.github.britka.pages.registration.RegistrationPage;
import io.qameta.allure.Step;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Serhii Bryt
 * 15.03.2024 11:35
 **/
public class SignInPage {
    Page page = DriverHolder.getInstance().getPage();

    @Step("Login with user: {email}, remember me: {rememberMe}")
    public <T> T login(String email, String password, boolean rememberMe, Class<T> classToReturn){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill(email);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
        Locator rememberMeCh = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Remember Me"));
        if (rememberMe){
            rememberMeCh.check();
        } else {
            rememberMeCh.uncheck();
        }
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();

        try {
            return classToReturn.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public RegistrationPage createAnAccount(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account")).click();
        return new RegistrationPage();
    }

}
