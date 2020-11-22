package io.avec.securitydemo.views.adminroleonly;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.securitydemo.views.main.MainView;
import org.springframework.security.access.annotation.Secured;

@Route(value = "admin", layout = MainView.class)
@PageTitle("Admin Role only")
@CssImport("./styles/views/adminroleonly/admin-roleonly-view.css")
@Secured("ROLE_ADMIN")
public class AdminRoleonlyView extends Div {

    public AdminRoleonlyView() {
        setId("admin-roleonly-view");
        add(new Html("<p>Only users with role <b>ADMIN</b> can view this page.</p>"));
    }

}
