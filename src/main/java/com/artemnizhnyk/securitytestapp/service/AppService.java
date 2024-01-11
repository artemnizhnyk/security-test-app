package com.artemnizhnyk.securitytestapp.service;

import com.artemnizhnyk.securitytestapp.model.ApplicationEntity;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.stream.IntStream;

public class AppService {
    private List<ApplicationEntity> applications;

    @PostConstruct
    public void loadAppInDb() {
        Faker faker = new Faker();
        applications = IntStream.rangeClosed(1, 100)
                .mapToObj(it -> ApplicationEntity.builder()
                        .id(it)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();
    }

    public List<ApplicationEntity> allApplications() {
        return applications;
    }

    public ApplicationEntity applicationById(int id) {
        return applications.stream()
                .filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
