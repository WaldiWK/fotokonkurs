package pl.kuranc.fotokonkurs.server.dispatch;

import pl.kuranc.fotokonkurs.shared.dispatch.LoginAction;
import pl.kuranc.fotokonkurs.shared.dispatch.LoginResult;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

public class LoginHandler implements ActionHandler<LoginAction, LoginResult> {

	@Inject
	LoginHandler(){
		
	}
	

	@Override
	public LoginResult execute(LoginAction action, ExecutionContext context)
			throws ActionException {
		UserService userService = UserServiceFactory.getUserService();

		String url = "";

		if (userService.isUserLoggedIn()) {
			url = "<p>Hello, " + userService.getCurrentUser().toString() + "!  You can <a href=\""
					+ userService.createLogoutURL(action.getLogin())
					+ "\">sign out</a>.</p>";
		} else {
			url = "<p>Please <a href=\"" + userService.createLoginURL(action.getLogin())
					+ "\">sign in</a>.</p>";
		}

		return new LoginResult(url);
	}

	@Override
	public Class<LoginAction> getActionType() {
		return LoginAction.class;
	}

	@Override
	public void undo(LoginAction arg0, LoginResult arg1, ExecutionContext arg2)
			throws ActionException {
		// TODO Auto-generated method stub

	}

}
