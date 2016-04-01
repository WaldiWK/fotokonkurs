package pl.kuranc.fotokonkurs.server.guice;

import pl.kuranc.fotokonkurs.server.dispatch.LoginHandler;
import pl.kuranc.fotokonkurs.shared.Constants;
import pl.kuranc.fotokonkurs.shared.dispatch.LoginAction;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;
import com.gwtplatform.dispatch.shared.SecurityCookie;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	
    	bindConstant().annotatedWith(SecurityCookie.class).to(
				Constants.GWTP_SECURITY_SAMPLE_SECURITY_COOKIE_NAME);
    	bindHandler(LoginAction.class, LoginHandler.class);
    }
}