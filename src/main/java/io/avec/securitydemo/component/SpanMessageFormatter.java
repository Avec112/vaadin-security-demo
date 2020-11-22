package io.avec.securitydemo.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;

public class SpanMessageFormatter extends Span {

    public SpanMessageFormatter() {
    }

    public SpanMessageFormatter(Component... components) {
        super(components);
    }

    public SpanMessageFormatter(String text) {
        super(text);
    }

    public SpanMessageFormatter(String text, Object... params) {
        super(MessageFormatter.getMessage(text, params));
    }

    public void setText(String text, Object... params) {
        this.setText(MessageFormatter.getMessage(text, params));
    }
}
