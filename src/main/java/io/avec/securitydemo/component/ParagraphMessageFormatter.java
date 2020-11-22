package io.avec.securitydemo.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;

public class ParagraphMessageFormatter extends Paragraph {

    public ParagraphMessageFormatter() {
        super();
    }

    public ParagraphMessageFormatter(String text) {
        super(text);
    }

    @SuppressWarnings("unused")
    public ParagraphMessageFormatter(Component... components) {
        super(components);
    }

    public ParagraphMessageFormatter(String text, Object... params) {
        super(MessageFormatter.getMessage(text, params));
    }

    public void setText(String text, Object... params) {
        this.setText(MessageFormatter.getMessage(text, params));
    }

}
