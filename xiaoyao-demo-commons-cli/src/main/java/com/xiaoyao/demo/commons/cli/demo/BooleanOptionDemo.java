package com.xiaoyao.demo.commons.cli.demo;

import static java.lang.System.currentTimeMillis;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyao
 */
@ConditionalOnProperty(name = "demos.active", havingValue = "booleanOptionDemo")
@Service
public class BooleanOptionDemo implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BooleanOptionDemo.class);

    @Override
    public void run(String... args) throws Exception {
        // 1. Definition Stage
        Options options = new Options();
        options.addOption("d", "demos.active", true, "active demo");
        options.addOption("t", false, "display current time");

        // 2. Parsing Stage
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args, true);

        // 3. Interrogation Stage
        if (commandLine.hasOption("t")) {
            logger.info("option \"t\" found");
            logger.info("timestamp = {}", currentTimeMillis());

        } else {
            logger.info("option \"t\" not found");
        }
    }
}
