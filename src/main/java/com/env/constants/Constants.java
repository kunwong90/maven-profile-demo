package com.env.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

public class Constants {

    private static final Logger LOGGER = LoggerFactory.getLogger(Constants.class);

    //支付超时时间
    public static Integer PAY_TIMEOUT_TIME = 20 * 60;


    private static final Constants INSTANCE = new Constants();


    public static Constants getInstance() {
        return INSTANCE;
    }

    private Constants() {

    }

    public void refresh(Map<String, String> configValues) {

        for (Field field : Constants.class.getFields()) {
            int modifiers = field.getModifiers();
            if ((!Modifier.isStatic(modifiers)) || (!Modifier.isPublic(modifiers))) {
                continue;
            }
            String configConstName = field.getName();

            if (!configValues.containsKey(configConstName)) {
                continue;
            }
            if (field.getType().getName().equals(String.class.getName())) {
                try {
                    field.set(null, configValues.get(configConstName));
                    LOGGER.info("Set config const: {} with value: {}", configConstName, configValues.get(configConstName));
                } catch (Exception e) {
                    LOGGER.error("[The type of " + configConstName + " is unmatchable.]", e);
                }
            } else if (field.getType().getName().equals(Integer.class.getName())) {
                try {
                    field.set(null, Integer.valueOf(configValues.get(configConstName)));
                    LOGGER.info("Set config const: {} with value: {}", configConstName, configValues.get(configConstName));
                } catch (Exception e) {
                    LOGGER.error("[The type of " + configConstName + " is unmatchable.]", e);
                }
            } else if (field.getType().getName().equals(Long.class.getName())) {
                try {
                    field.set(null, Long.valueOf(configValues.get(configConstName)));
                    LOGGER.info("Set config const: {} with value: {}", configConstName, configValues.get(configConstName));
                } catch (Exception e) {
                    LOGGER.error("[The type of " + configConstName + " is unmatchable.]", e);
                }
            } else if (field.getType().getName().equals(Double.class.getName())) {
                try {
                    field.set(null, Double.valueOf(configValues.get(configConstName)));
                    LOGGER.info("Set config const: {} with value: {}", configConstName, configValues.get(configConstName));
                } catch (Exception e) {
                    LOGGER.error("[The type of " + configConstName + " is unmatchable.]", e);
                }
            } else {
                LOGGER.error("[The type of " + configConstName + " is unmatchable.]");
            }
        }
    }

}
