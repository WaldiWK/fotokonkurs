package pl.kuranc.fotokonkurs.client.application.login;

import com.gwtplatform.mvp.client.UiHandlers;

interface LoginUiHandlers extends UiHandlers {
	void loginUser(String login, String password);
}