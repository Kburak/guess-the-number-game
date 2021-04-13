package com.kburakengin.console;


import com.kburakengin.AppConfig;
import com.kburakengin.Game;
import com.kburakengin.MessageGenerator;
import com.kburakengin.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        LOG.info("Guess the number game");

        // create context(container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get the numberGenerator bean
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method
        int number = numberGenerator.next();

        //log generated number
        LOG.info("number = {}", number);

        // get the game bean from context(container)
        Game game = context.getBean(Game.class);

        // get the message bean from context
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        LOG.info("Main Message is {}:", messageGenerator.getMainMessage());
        LOG.info("Result Message is {}", messageGenerator.getResultMessage());;

        //close context
        context.close();

    }
}
