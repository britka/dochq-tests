package io.github.britka.tests;

import io.github.britka.application.Application;
import io.github.britka.listeners.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/**
 * Created by Serhii Bryt
 * 16.03.2024 20:06
 **/
@Listeners(TestListener.class)
public class BaseTest {
    protected Application application;

    @BeforeClass
    public void beforeTest(){
        application = new Application();
    }

}
