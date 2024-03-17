package io.github.britka.application;

import io.github.britka.pages.dashboard.UserDashBoardPage;
import io.qameta.allure.Step;

/**
 * Created by Serhii Bryt
 * 16.03.2024 20:38
 **/
public class UserDashBoard {
    @Step("Go to Start personal trainer")
    public PersonalTrainer startPersonalTrainer(){
        new UserDashBoardPage().startPersonalTrainer();
        return new PersonalTrainer();
    }

    public Physiotherapy startPhysiotherapy(){
       return null;
    }

    public TravelMedicineChecker startTravelMedicineChecker(){
       return null;
    }

    public HealthChecksMenu startHealthChecksMenu(){
        return null;
    }
}
