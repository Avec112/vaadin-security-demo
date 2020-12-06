package io.avec.securitydemo.views.admin;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.securitydemo.views.main.MainView;
import org.springframework.security.access.annotation.Secured;

@Route(value = "admin", layout = MainView.class)
@PageTitle("Admin Role only")
@CssImport("./styles/views/admin/admin-view.css")
@Secured("ROLE_ADMIN")
public class AdminView extends Div {

    public AdminView() {
        setId("admin-view");
        add(new Html("<p>Only users with role <b>ADMIN</b> can view this page.</p>"));
    }

}
