package io.github.britka.models;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by Serhii Bryt
 * 15.03.2024 14:58
 **/

@Data
@AllArgsConstructor
public class UserModel {
    private String name;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String password;

    public UserModel() {
        Faker faker = new Faker();
        name = faker.name().firstName();
        lastName = faker.name().lastName();
        dob = faker.date().birthday(18, 60)
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        email = faker.internet().safeEmailAddress();
        password = faker.internet().password(10, 15, true);
    }
}
