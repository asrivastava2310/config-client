package com.ms.configclient.controller;

import com.ms.configclient.GameOfThronesProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Data
public class GotController {

    private List<String> losers; //props
    private int kingdoms;//props

    @Value("${server.port}")
    private int port; //args
    private String profile; //Env
    private String author;//props

    @Value("${game-of-thrones.losers}")
    void setLosers(String losers) {
        this.losers = Arrays.asList(losers.split(","));
    }

    /*@Value("${spring.profiles.active}")
    void setActiveProfile(String profile) {
        this.profile = profile;
    }*/

    @Autowired
    void setProjectProperties(GameOfThronesProperties properties) {
        this.kingdoms = properties.getNoOfKingdoms();
    }

    @Autowired
    void setAuthor(Environment env) {
        this.author = env.getProperty("game-of-thrones.author");
    }

    @GetMapping("/props")
    public GotController props(){
        return this;
    }
}
