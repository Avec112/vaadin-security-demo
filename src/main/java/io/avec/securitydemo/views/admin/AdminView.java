package io.avec.securitydemo.views.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.avec.securitydemo.views.main.MainView;
import org.springframework.security.access.annotation.Secured;

import java.util.HashMap;
import java.util.Map;

@Route(value = "admin", layout = MainView.class)
@PageTitle("Admin Role only")
@CssImport("./styles/views/admin/admin-view.css")
@Secured("ROLE_ADMIN")
public class AdminView extends Div {

    public AdminView() {
        setId("admin-view");

        Tab tab1 = new Tab("Tab 1");
        Tab tab2 = new Tab("Tab 2");
        Tab tab3 = new Tab("Tab 3");
        Tabs tabs = new Tabs(tab1, tab2, tab3);

        Div page1 = new Div();
        page1.add(new Html("<p>Only users with role <b>ADMIN</b> can view this page.</p>"));

        Div page2 = new Div();
        page2.setText("Page#2");
        page2.setVisible(false);

        Div page3 = new Div();
        page3.setText("Page#3");
        page3.setVisible(false);

        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);

        Div pages = new Div(page1, page2, page3);

        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });

        add(tabs, pages);

    }




}
