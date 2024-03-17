package io.github.britka.listeners;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import io.github.britka.driver.DriverHolder;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Parameter;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


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
                    .screenshot(new Page.ScreenshotOptions().setFullPage(true));
            try {
                Files.createDirectory(Path.of("target/images"));
                Files.write(Path.of("target/images", "fail.png"), screenshot);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(screenshot));
        }
    }

    @Override
    public void beforeStepStart(StepResult result) {
        List<Parameter> parameters = result.getParameters();
        StringBuilder parametersString = new StringBuilder();
        parameters.forEach(parameter -> {
            parametersString.append(parameter.getValue());
            parametersString.append(", ");
        });
        log.info(" {}({})", result.getName(), parametersString);
    }
}
