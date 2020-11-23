package io.avec.securitydemo.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import io.avec.securitydemo.views.login.LoginView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*
	https://vaadin.com/learn/tutorials/securing-your-app-with-spring-security/setting-up-spring-security
	https://www.youtube.com/watch?v=_VLuaavfD20&list=PLcRrh9hGNallPtT2VbUAsrWqvkQ-XE22h&index=14&ab_channel=vaadinofficial

 */

@Slf4j
@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

	@Override
	public void serviceInit(ServiceInitEvent event) {
		event.getSource().addUIInitListener(uiEvent -> {
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::beforeEnter);
		});
	}

	/*
	 * https://vaadin.com/learn/tutorials/securing-your-app-with-spring-security/fine-grained-access-control
	 * Reroutes the user if they're not authorized to access the view.
	 *
	 */
	private void beforeEnter(BeforeEnterEvent event) {
		if(!SecurityUtils.isAccessGranted(event.getNavigationTarget())) { // is user authorized?
			// is user authenticated
			if(SecurityUtils.isUserLoggedIn()) {
//				event.rerouteToError(NotFoundException.class, "Sorry you do not have access to this resource."); //
				event.rerouteTo("access-denied-view", event.getLocation().getPath()); //
			}
			// user is not authenticated
			else {
				event.rerouteTo(LoginView.class); //
			}
		}
		//
	}

	// Authentication only
//	private void beforeEnter(BeforeEnterEvent event) {
//		log.debug("event.getNavigationTarget() = {}", event.getNavigationTarget());
//		log.debug("SecurityUtils.isUserLoggedIn() = {}", SecurityUtils.isUserLoggedIn());
//		if (!LoginView.class.equals(event.getNavigationTarget())
//		    && !SecurityUtils.isUserLoggedIn()) {
//			event.rerouteTo(LoginView.class);
//		}
//	}
}