package io.github.britka.tests;

import io.github.britka.checks.Checks;
import io.github.britka.driver.DriverHolder;
import io.github.britka.listeners.TestListener;
import io.github.britka.models.CardData;
import io.github.britka.models.UserModel;
import io.github.britka.pages.*;
import io.github.britka.pages.dashboard.UserDashBoardPage;
import io.github.britka.pages.registration.ActivateRequestPage;
import io.github.britka.pages.workout.subscriptions.SubscriptionPage;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Serhii Bryt
 * 15.03.2024 14:55
 **/
@Listeners(TestListener.class)
public class FirstTests extends BaseTest{

    @AfterClass
    public void tearDown() {
        DriverHolder.getInstance().getContext().close();
        DriverHolder.getInstance().getPlaywright().close();
    }

    @Test
    @Description("Start workout for newly registered user")
    public void firstTest() {
        UserModel userModel = new UserModel();

        application
                .openApplication()
                .registration()
                .registerUser(userModel, true);

        application
                .dashBoard()
                .startPersonalTrainer()
                .startFreeTrial(SubscriptionPage.PlanEnum.Monthly, new CardData(), "test")
                .startWorkout();

        Checks.workoutChecks().checkIfWorkoutStarted();
    }
}
