package io.github.britka.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.pages.signin.SignInPage;

/**
 * Created by Serhii Bryt
 * 15.03.2024 11:16
 **/
public class IndividualsBasePage extends BasePage{
    public SignInPage signIn(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN IN1")).click();
        return new SignInPage();
    }
}
