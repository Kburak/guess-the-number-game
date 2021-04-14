package com.kburakengin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private final Game game;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void init() {
        LOG.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it. The number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range";
        } else if (game.getRemaining() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemaining() + " guesses left.";
        }
    }
}