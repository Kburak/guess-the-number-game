package com.kburakengin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct
    public void init() {
        LOG.info("game = {}", game);
    }


    @Override
    public String getMainMessage() {
        return "Game started number being guessed";
    }

    @Override
    public String getResultMessage() {
        return "the guessed number";
    }
}