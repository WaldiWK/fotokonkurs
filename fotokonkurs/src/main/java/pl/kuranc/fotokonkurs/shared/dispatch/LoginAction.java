package pl.kuranc.fotokonkurs.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

public class LoginAction extends ActionImpl<LoginResult> {

	private String login;
	private String password;

	public LoginAction() {
	}

	public LoginAction(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
}
