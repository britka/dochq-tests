package io.github.britka.listeners;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.github.britka.driver.DriverHolder;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;


@Slf4j
public class TestListener implements ITestListener, StepLifecycleListener, TestLifecycleListener {

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test {} failed. Making screenshot...", result.getName());
    }

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            byte[] screenshot = DriverHolder.getInstance().getPage()
                    .screenshot(new Page.ScreenshotOptions().setFullPage(true).setType(ScreenshotType.PNG));
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(screenshot));
        }
    }

    @Override
    public void beforeStepUpdate(StepResult result) {
        log.info(result.getName());
        StepLifecycleListener.super.beforeStepUpdate(result);
    }
}
