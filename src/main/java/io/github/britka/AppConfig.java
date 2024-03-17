package io.github.britka;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Created by Serhii Bryt
 * 16.03.2024 20:19
 **/
public class AppConfig {
    private static AppConfig instance = null;
    private Dotenv dotenv;

    private AppConfig() {
        dotenv = Dotenv.configure().systemProperties().load();
    }

    private synchronized static AppConfig getInstance() {
        if (instance == null){
            instance = new AppConfig();
        }
        return instance;
    }

    public static String getProperty(String property){
        return getInstance().dotenv.get(property);
    }

}
