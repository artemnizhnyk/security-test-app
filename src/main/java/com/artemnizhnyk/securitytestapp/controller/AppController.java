package com.artemnizhnyk.securitytestapp.controller;

import com.artemnizhnyk.securitytestapp.model.Application;
import com.artemnizhnyk.securitytestapp.model.MyUser;
import com.artemnizhnyk.securitytestapp.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apps")
@RequiredArgsConstructor
public class AppController {

    private final AppService appService;

        @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the unprotected page";
    }

    @GetMapping("/all-app")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> allApplication() {
        return appService.allApplications();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Application applicationById(@PathVariable final int id) {
        return appService.applicationById(id);
    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
            appService.addUser(user);
            return "User is saved";
    }
}
