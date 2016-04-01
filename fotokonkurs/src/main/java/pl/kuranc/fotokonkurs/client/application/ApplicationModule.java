package pl.kuranc.fotokonkurs.client.application;

import pl.kuranc.fotokonkurs.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import pl.kuranc.fotokonkurs.client.application.login.LoginModule;
import pl.kuranc.fotokonkurs.client.application.register.RegisterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new RegisterModule());
		install(new LoginModule());
		install(new HomeModule());
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}