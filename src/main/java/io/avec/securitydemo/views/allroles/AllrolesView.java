package io.avec.securitydemo.views.allroles;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.securitydemo.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "home", layout = MainView.class)
@PageTitle("Home")
@CssImport("./styles/views/allroles/allroles-view.css")
@RouteAlias(value = "", layout = MainView.class)
//@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
public class AllrolesView extends Div {

    public AllrolesView() {
        setId("allroles-view");
        add(new Html("<p>All authenticated users can view this page.</p>"));

    }

}
