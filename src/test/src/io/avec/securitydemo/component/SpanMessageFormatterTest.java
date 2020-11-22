package io.avec.securitydemo.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpanMessageFormatterTest {

    @Test
    void spanConstructorText() {
        SpanMessageFormatter e = new SpanMessageFormatter("Test");
        assertEquals("Test", e.getText());
    }

    @Test
    void spanConstructorTextAndParams() {
        SpanMessageFormatter e = new SpanMessageFormatter("Test {}, {}, {}", 1, 2, 3);
        assertEquals("Test 1, 2, 3", e.getText());
    }

    @Test
    void spanSetTextAndParams() {
        SpanMessageFormatter e = new SpanMessageFormatter();
        e.setText("Test {}, {}, {}", 1, 2, 3);
        assertEquals("Test 1, 2, 3", e.getText());
    }
}