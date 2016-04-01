package pl.kuranc.fotokonkurs.server.guice;

import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.server.guice.RandomSecurityCookieFilter;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.googlecode.objectify.ObjectifyFilter;

import javax.inject.Singleton;

import pl.kuranc.fotokonkurs.shared.Constants;

public class DispatchServletModule extends ServletModule {
    @Override
    public void configureServlets() {
    	
    	bindConstant().annotatedWith(SecurityCookie.class).to(
				Constants.GWTP_SECURITY_SAMPLE_SECURITY_COOKIE_NAME);
    	
    	filter("*").through(RandomSecurityCookieFilter.class);
    	
        serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);
        
        filter("/*").through(ObjectifyFilter.class);
        bind(ObjectifyFilter.class).in(Singleton.class);
    }
}