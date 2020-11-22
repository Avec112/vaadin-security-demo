package io.avec.securitydemo.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParagraphMessageFormatterTest {

    @Test
    void paragraphConstructorText() {
        ParagraphMessageFormatter p = new ParagraphMessageFormatter("Test");
        assertEquals("Test", p.getText());
    }

    @Test
    void paragraphConstructorTextAndParams() {
        ParagraphMessageFormatter p = new ParagraphMessageFormatter("Test {}, {}, {}", 1, 2, 3);
        assertEquals("Test 1, 2, 3", p.getText());
    }

    @Test
    void paragraphSetTextAndParams() {
        ParagraphMessageFormatter p = new ParagraphMessageFormatter();
        p.setText("Test {}, {}, {}", 1, 2, 3);
        assertEquals("Test 1, 2, 3", p.getText());
    }
}