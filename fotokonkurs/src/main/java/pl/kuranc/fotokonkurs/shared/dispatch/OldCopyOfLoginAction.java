package pl.kuranc.fotokonkurs.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

public class OldCopyOfLoginAction extends ActionImpl<LoginResult> {

	private String login;
	private String password;

	public OldCopyOfLoginAction(String login, String password) {
		this.login = login;
		this.password = password;
		System.out.print("Action User :" + login + "Password" + password);
	}

	public OldCopyOfLoginAction() {

	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean isSecured() {
		return false;
	}

}
