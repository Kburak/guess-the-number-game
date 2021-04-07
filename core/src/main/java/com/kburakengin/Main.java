package com.kburakengin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        LOG.info("Guess the number game");

        // create context(container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get the numberGenerator bean
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // call method
        int number = numberGenerator.next();

        //log generated number
        LOG.info("number = {}", number);

        // get the game bean from context(container)
        Game game = context.getBean("game", Game.class);

        //close context
        context.close();

    }
}
