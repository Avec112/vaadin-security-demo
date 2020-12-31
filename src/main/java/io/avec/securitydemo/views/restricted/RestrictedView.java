package io.avec.securitydemo.views.restricted;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.securitydemo.views.main.MainView;
import org.springframework.security.access.annotation.Secured;

@Route(value = "restricted", layout = MainView.class)
@PageTitle("Content differences pr. Role")
@CssImport("./styles/views/restricted/restricted-view.css")
@Secured({
        "ROLE_USER",
        "ROLE_ADMIN"
})
public class RestrictedView extends Div {

    public RestrictedView() {
        setId("restricted-view");
        add(new Html("<p>Users with role <b>USER</b> or <b>ADMIN</b> can view this page.</p>"));
//        add(new Html("<p>Note that user <b>admin</b> have both role <b>USER</b> and <b>ADMIN</b></p>"));
    }

}
