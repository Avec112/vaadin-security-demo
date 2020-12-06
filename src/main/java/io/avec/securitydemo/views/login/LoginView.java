package io.avec.securitydemo.views.login;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    LoginForm login = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        login.setAction("login");

        final Div usersDiv = new Div(new UnorderedList(
                new ListItem("guest/guest - No privileges"),
                new ListItem("user/user - Restricted privileges"),
                new ListItem("admin/admin - All privileges")
        ));
        usersDiv.getStyle()
                .set("background", "white")
                .set("background", "var(--lumo-base-color) linear-gradient(var(--lumo-tint-20pct), var(--lumo-tint-20pct))")
                .set("padding", "var(--lumo-space-l)");
        add(
                new H1("Vaadin with Spring Security"),
                usersDiv,
                login
        );

    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}
