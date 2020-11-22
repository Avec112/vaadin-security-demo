package io.avec.securitydemo.component;

import java.io.Serializable;
import java.util.Arrays;

public class MessageFormatter implements Serializable {
    static String getMessage(String text, Object[] params) {
        return org.slf4j.helpers.MessageFormatter.arrayFormat(text, Arrays.stream(params).toArray()).getMessage();
    }
}