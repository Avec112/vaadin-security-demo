package io.avec.securitydemo.views.accessdenied;


import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import io.avec.securitydemo.component.ParagraphMessageFormatter;
import io.avec.securitydemo.component.SpanMessageFormatter;
import io.avec.securitydemo.views.main.MainView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Displays Access denied message for the user if the required
 * privileges is not met. User does not have the needed role.
 */
@SuppressWarnings("unused")
@Slf4j
@Route(value = "access-denied-view", layout = MainView.class)
@CssImport("./styles/views/access-denied/access-denied-view.css")
@PageTitle("Access Denied")
public class AccessDeniedView extends Div implements HasUrlParameter<String> {

    private final SpanMessageFormatter span = new SpanMessageFormatter();
    public AccessDeniedView() {
        setId("access-denied-view");
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(new H3("Access Denied"));
        final ParagraphMessageFormatter p = new ParagraphMessageFormatter();
        p.setText("You do not have access to requested location ");
        p.add(span);
        p.getStyle().set("margin-bottom", "0");
        verticalLayout.add(p); //
        final Paragraph p2 = new Paragraph(
                "Please contact your Supervisor or the local Administrator if you think " +
                        "there is something wrong with your authorization privileges.");
        p2.getStyle().set("margin-top", "0");
        verticalLayout.add(p2);
        add(verticalLayout);
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if(StringUtils.isNotBlank(parameter)) {
            span.setText("/{}", parameter);
            span.getStyle().set("font-weight", "bold");
        }

    }
}
