package io.avec.roledemo.views.contentdifferencesprrole;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.roledemo.views.main.MainView;

@Route(value = "content-differences-pr-role", layout = MainView.class)
@PageTitle("Content differences pr. Role")
@CssImport("./styles/views/contentdifferencesprrole/contentdifferencespr-role-view.css")
public class ContentdifferencesprRoleView extends Div {

    public ContentdifferencesprRoleView() {
        setId("contentdifferencespr-role-view");
        add(new Label("Content placeholder"));
    }

}
