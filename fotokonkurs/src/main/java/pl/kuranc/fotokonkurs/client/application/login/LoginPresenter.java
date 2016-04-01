package pl.kuranc.fotokonkurs.client.application.login;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.HasUiHandlers;

import pl.kuranc.fotokonkurs.client.application.ApplicationPresenter;
import pl.kuranc.fotokonkurs.client.place.NameTokens;
public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> implements LoginUiHandlers {
    interface MyView extends View , HasUiHandlers<LoginUiHandlers> {
    }
   
    public static final NestedSlot SLOT_Login = new NestedSlot();

    @NameToken(NameTokens.LOGIN)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<LoginPresenter> {
    }
    
    private final DispatchAsync dispatcher;


    @Inject
    LoginPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,
            DispatchAsync dispatcher) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
        this.dispatcher = dispatcher;
        getView().setUiHandlers(this);
    }
    
	@Override
	public void loginUser(String login, String password) {
	/*
		LoginAction action = new LoginAction(login,password);

		dispatcher.execute(action, new AsyncCallback<LoginResult>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Communication to the server has failed.");
				
			}

			@Override
			public void onSuccess(LoginResult result) {
				String auth=result.isResult()?"OK":"False";
				
				Window.alert("Communication OK, auth"+auth);
				
			}
			
		});
		*/
	}

}