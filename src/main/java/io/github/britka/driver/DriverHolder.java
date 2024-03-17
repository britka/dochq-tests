package io.github.britka.driver;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Created by Serhii Bryt
 * 15.03.2024 10:40
 **/
public class DriverHolder {
    private static DriverHolder instance = null;
    private ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private ThreadLocal<Page> page = new ThreadLocal<>();

    private DriverHolder() {
    }
    public synchronized static DriverHolder getInstance() {
        if (instance == null) {
            instance = new DriverHolder();
        }
        return instance;
    }

    public Playwright getPlaywright() {
        if (playwright.get() == null) {
            playwright.set(Playwright.create());
        }
        return playwright.get();
    }

    public BrowserContext getContext() {
        if (context.get() == null) {
            getPlaywright();
            BrowserType browserType = getBrowserType();
            boolean isHeadless = Boolean.parseBoolean(System.getProperty("isHeadless", "false"));
            context.set(browserType.launch(new BrowserType.LaunchOptions().setHeadless(isHeadless).setSlowMo(200)).newContext());
        }
        return context.get();
    }

    private BrowserType getBrowserType() {
        String browserToRun = System.getProperty("browserToRun", "chromium");
        return switch (browserToRun) {
            case "chromium" -> playwright.get().chromium();
            case "firefox" -> playwright.get().firefox();
            case "webkit" -> playwright.get().webkit();
            default -> throw new IllegalArgumentException("This browser is not supported." +
                    "\nPlease use [chromium, firefox, webkit]");
        };
    }

    public Page getPage() {
        if (page.get() == null) {
            page.set(getContext().newPage());
        }
        return page.get();
    }

    public void setPage(Page page){
        this.page.set(page);
    }
}
