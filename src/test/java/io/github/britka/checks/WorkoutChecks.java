package io.github.britka.checks;

import io.github.britka.pages.workout.MyWorkoutTodayPage;
import org.testng.Assert;

/**
 * Created by Serhii Bryt
 * 17.03.2024 11:10
 **/
public class WorkoutChecks {
    public void checkIfWorkoutStarted(){
        Assert.assertTrue(new MyWorkoutTodayPage().isWorkoutVisible(), "Workout is not started");
    }
}
