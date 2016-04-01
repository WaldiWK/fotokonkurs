package pl.kuranc.fotokonkurs.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class LoginResult implements Result {
	private String url;

	public LoginResult() {
	}

	public LoginResult(String url) {
		this.url = url;
	}

	public String getResult() {
		return url;
	}

}
