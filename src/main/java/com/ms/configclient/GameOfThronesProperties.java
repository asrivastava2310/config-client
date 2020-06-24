package com.ms.configclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("game-of-thrones")
@Data
public class GameOfThronesProperties {
    private String losers;
    private int noOfKingdoms;
    private String author;
}
