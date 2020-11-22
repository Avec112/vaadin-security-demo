package io.avec.securitydemo.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HtmlMessageFormatterTest {

    @Test
    void htmlConstructorText() {
        HtmlMessageFormatter html = new HtmlMessageFormatter("<p><b>Test</b></p>");
        assertEquals("<b>Test</b>", html.getInnerHtml());
    }

    @Test
    void htmlConstructorTextAndParams() {
        HtmlMessageFormatter html = new HtmlMessageFormatter("<p><b>Test {}, {}, {}</b></p>", 1, 2, 3);
        assertEquals("<b>Test 1, 2, 3</b>", html.getInnerHtml());
    }
}