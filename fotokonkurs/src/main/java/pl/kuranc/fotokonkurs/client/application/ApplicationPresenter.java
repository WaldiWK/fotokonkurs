package pl.kuranc.fotokonkurs.client.application;

import javax.inject.Inject;

import pl.kuranc.fotokonkurs.shared.dispatch.LoginAction;
import pl.kuranc.fotokonkurs.shared.dispatch.LoginResult;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class ApplicationPresenter extends
		Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
	interface MyView extends View {
		void setUserAuth(String userLabel);
	}

	public static final NestedSlot SLOT_SetMainContent = new NestedSlot();

	@ProxyStandard
	interface MyProxy extends Proxy<ApplicationPresenter> {
	}

	private DispatchAsync dispatcher;

	@Inject
	ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy,
			DispatchAsync dispatcher) {
		super(eventBus, view, proxy, RevealType.Root);
		this.dispatcher = dispatcher;
	}

	@Override
	protected void onBind() {
		super.onBind();
		checkLoginUrl();

	}

	@Override
	protected void onReset(){
		super.onReset();
		checkLoginUrl();
	}
	
	
	
	private void checkLoginUrl(){
		
		LoginAction action = new LoginAction(Window.Location.getHref(),"haslo");
		dispatcher.execute(action, new AsyncCallback<LoginResult>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Communication to the server has failed.");

			}

			@Override
			public void onSuccess(LoginResult result) {
				getView().setUserAuth(result.getResult());

			}
		});
	}
	
}