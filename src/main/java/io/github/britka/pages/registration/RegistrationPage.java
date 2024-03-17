package io.github.britka.pages.registration;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.AriaRole;
import io.github.britka.driver.DriverHolder;
import io.github.britka.models.UserModel;
import io.github.britka.models.UserRegisterResponse;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicReference;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Created by Serhii Bryt
 * 15.03.2024 11:46
 **/
@Slf4j
public class RegistrationPage {
    Page page = DriverHolder.getInstance().getPage();
    public static AtomicReference<String> token = new AtomicReference<>();


    public RegistrationPage() {
        page.onResponse(response -> {
            if (response.url().startsWith("https://identitytoolkit.googleapis.com/v1/accounts:update")) {
                try {
                    log.info("Response url: {}", response.url());
                    String responseBody = new String(response.body());
                    Gson gson = new Gson();
                    UserRegisterResponse userRegisterResponse = gson.fromJson(responseBody, UserRegisterResponse.class);
                    token.set(userRegisterResponse.getLocalId());
                    page.offResponse(response1 -> {
                    });
                } catch (JsonSyntaxException ignore) {
                    log.info("Con not map JSON to object.");
                }
            }
        });
    }


    private  <T> T registerUser(String name, String lastName, LocalDate dob,
                              String email, String password, String confirmPassword,
                              boolean iAgree, boolean receiveEmail,
                              Class<T> pageToReturn) {
        page.locator("#firstName").fill(name);
        page.locator("#lastName").fill(lastName);
        String dobAsString = dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        page.locator("#date_of_birth").fill(dobAsString);
        page.locator("#email").fill(email);
        page.locator("#password").fill(password);
        page.locator("#confirmPassword").fill(confirmPassword);
        if (iAgree) page.locator("#tocAccept").check();
        else page.locator("#tocAccept").uncheck();
        if (receiveEmail) page.locator("[name=marketingAccept]").check();
        else page.locator("[name=marketingAccept]").uncheck();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("REGISTER")).click();
        assertThat(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("REGISTER")))
                .isHidden(new LocatorAssertions.IsHiddenOptions().setTimeout(Duration.ofSeconds(30).toMillis()));
        try {
            return pageToReturn.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Register: {userModel}, agree: {iAgree}")
    public <T> T registerUser(UserModel userModel, boolean iAgree, Class<T> pageToReturn) {
        return registerUser(userModel.getName(), userModel.getLastName(), userModel.getDob(),
                userModel.getEmail(), userModel.getPassword(), userModel.getPassword(), iAgree, true, pageToReturn);
    }

    public <T> T registerUser(UserModel userModel, Class<T> pageToReturn) {
        return registerUser(userModel, true, pageToReturn);
    }
}
