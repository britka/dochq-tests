package io.github.britka.application;

import io.github.britka.models.CardData;
import io.github.britka.pages.PersonalTrainerStartPage;
import io.github.britka.pages.workout.MyWorkoutsPage;
import io.github.britka.pages.workout.subscriptions.SubscriptionPage;
import io.qameta.allure.Step;
import lombok.Data;

/**
 * Created by Serhii Bryt
 * 17.03.2024 10:49
 **/
public class PersonalTrainer {

    @Step("Start free trail. Subscription plan: {membershipPlan}, card data: {cardData}, training plan: {trainingPlan}")
    public PersonalTrainer startFreeTrial(SubscriptionPage.PlanEnum membershipPlan, CardData cardData, String trainingPlan){
        new PersonalTrainerStartPage()
                .startFreeTrial()
                .selectPlan(membershipPlan)
                .next()
                .enterCardData(cardData)
                .goToTrainings()
                .recommendedPlans()
                .selectPlan(trainingPlan);
        return this;
    }

    @Step("Start work out")
    public void startWorkout(){
        new MyWorkoutsPage()
                .startWorkout()
                .exerciseSettings()
                .setExerciseSettings(false, false);
    }

    public void startWorkout(ExerciseSettings exerciseSettings){
        new MyWorkoutsPage()
                .startWorkout()
                .exerciseSettings()
                .setExerciseSettings(exerciseSettings.isShowMeIntroduction(), exerciseSettings.isShowMwScore());
    }

    @Data
    public static class ExerciseSettings {
         private boolean showMeIntroduction = true;
         private boolean showMwScore = true;
    }
}
