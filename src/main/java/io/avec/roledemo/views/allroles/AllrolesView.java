package io.avec.roledemo.views.allroles;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.roledemo.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "all-roles", layout = MainView.class)
@PageTitle("All roles")
@CssImport("./styles/views/allroles/allroles-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class AllrolesView extends Div {

    public AllrolesView() {
        setId("allroles-view");
        add(new Label("Content placeholder"));
    }

}
