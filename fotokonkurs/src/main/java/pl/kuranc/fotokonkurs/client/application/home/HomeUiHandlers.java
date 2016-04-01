package pl.kuranc.fotokonkurs.client.application.home;

import com.gwtplatform.mvp.client.UiHandlers;

interface HomeUiHandlers extends UiHandlers {
	void sendToLogin();
	void sendToRegister();
}