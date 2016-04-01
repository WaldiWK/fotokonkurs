package pl.kuranc.fotokonkurs.client.application.home;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements
		HomePresenter.MyView {
	interface Binder extends UiBinder<Widget, HomeView> {
	}

	@UiField
	SimplePanel main;

	@UiField
	Button loginButton;

	@UiField
	Button registerButton;

	@Inject
	HomeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("loginButton")
	void onLoginButtonClick(ClickEvent event) {
		getUiHandlers().sendToLogin();
	}

	@UiHandler("registerButton")
	void onRegisterButtonClick(ClickEvent event) {
		getUiHandlers().sendToRegister();

	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == HomePresenter.SLOT_Home) {
			main.setWidget(content);
		} else {
			super.setInSlot(slot, content);
		}
	}
}