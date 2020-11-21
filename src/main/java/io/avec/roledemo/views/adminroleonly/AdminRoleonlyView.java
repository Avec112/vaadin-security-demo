package io.avec.roledemo.views.adminroleonly;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.roledemo.views.main.MainView;

@Route(value = "admin-role", layout = MainView.class)
@PageTitle("Admin Role only")
@CssImport("./styles/views/adminroleonly/admin-roleonly-view.css")
public class AdminRoleonlyView extends Div {

    public AdminRoleonlyView() {
        setId("admin-roleonly-view");
        add(new Label("Content placeholder"));
    }

}
