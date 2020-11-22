package io.avec.securitydemo.component;

import com.vaadin.flow.component.Html;

import java.io.InputStream;

public class HtmlMessageFormatter extends Html {
    @SuppressWarnings("unused")
    public HtmlMessageFormatter(InputStream stream) {
        super(stream);
    }

    public HtmlMessageFormatter(String outerHtml) {
        super(outerHtml);
    }

    public HtmlMessageFormatter(String outerHtml, Object... params) {
        super(MessageFormatter.getMessage(outerHtml, params));
    }

}
