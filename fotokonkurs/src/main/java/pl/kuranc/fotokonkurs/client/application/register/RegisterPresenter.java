package pl.kuranc.fotokonkurs.client.application.register;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.HasUiHandlers;

import pl.kuranc.fotokonkurs.client.application.ApplicationPresenter;
import pl.kuranc.fotokonkurs.client.place.NameTokens;
public class RegisterPresenter extends Presenter<RegisterPresenter.MyView, RegisterPresenter.MyProxy> implements RegisterUiHandlers {
    interface MyView extends View , HasUiHandlers<RegisterUiHandlers> {
    }
    
    public static final NestedSlot SLOT_Register = new NestedSlot();

    @NameToken(NameTokens.REGISTER)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<RegisterPresenter> {
    }

    @Inject
    RegisterPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
        
        getView().setUiHandlers(this);
    }
    
    
}