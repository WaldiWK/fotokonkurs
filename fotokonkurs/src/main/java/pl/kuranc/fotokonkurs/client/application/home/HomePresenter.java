package pl.kuranc.fotokonkurs.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import pl.kuranc.fotokonkurs.client.application.ApplicationPresenter;
import pl.kuranc.fotokonkurs.client.place.NameTokens;

public class HomePresenter extends
		Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements
		HomeUiHandlers {
	interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
	}

	public static final NestedSlot SLOT_Home = new NestedSlot();

	@NameToken(NameTokens.HOME)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	private PlaceManager placeManager;
	
	@Inject
	HomePresenter(EventBus eventBus, 
			MyView view, 
			MyProxy proxy,
			PlaceManager placeManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
		this.placeManager = placeManager;
		getView().setUiHandlers(this);
	}

	@Override
	public void sendToLogin() {
		PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(
				NameTokens.LOGIN).build();
		placeManager.revealPlace(placeRequest);
	}

	@Override
	public void sendToRegister() {
		PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(
				NameTokens.REGISTER).build();
		placeManager.revealPlace(placeRequest);
	}

}