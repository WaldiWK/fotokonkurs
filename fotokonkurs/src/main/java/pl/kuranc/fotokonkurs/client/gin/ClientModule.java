package pl.kuranc.fotokonkurs.client.gin;

import pl.kuranc.fotokonkurs.client.application.ApplicationModule;
import pl.kuranc.fotokonkurs.client.place.NameTokens;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;
import com.arcbees.analytics.client.AnalyticsModule;

import pl.kuranc.fotokonkurs.client.place.NavigationTracker;
import pl.kuranc.fotokonkurs.shared.Constants;

/**
 * See more on setting up the PlaceManager on <a
 * href="// See more on: https://github.com/ArcBees/GWTP/wiki/PlaceManager">DefaultModule's > DefaultPlaceManager</a>
 */
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder().tokenFormatter(RouteTokenFormatter.class).build());
        install(new RpcDispatchAsyncModule());
        install(new ApplicationModule());
        

        // DefaultPlaceManager Places
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.HOME);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.HOME);
        
        bindConstant().annotatedWith(SecurityCookie.class).to(
    			Constants.GWTP_SECURITY_SAMPLE_SECURITY_COOKIE_NAME);
        
        install(new AnalyticsModule.Builder("UX-XXXX-Y").build());
        bind(NavigationTracker.class).asEagerSingleton();
    }
}