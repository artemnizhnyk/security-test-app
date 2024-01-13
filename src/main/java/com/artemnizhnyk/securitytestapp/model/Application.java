package com.artemnizhnyk.securitytestapp.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    private int id;
    private String name;
    private String author;
    private String version;
}
