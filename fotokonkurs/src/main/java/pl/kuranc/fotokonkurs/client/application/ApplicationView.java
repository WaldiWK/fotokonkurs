package pl.kuranc.fotokonkurs.client.application;

import javax.inject.Inject;

import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    SpanElement userAuth;
    
    @UiField
    SimplePanel main;
    
    @UiField
    HTMLPanel htmlPanel;
    
   

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    
    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == ApplicationPresenter.SLOT_SetMainContent) {
            main.setWidget(content);
        } else {
            super.setInSlot(slot, content);
        }
    }

    

	@Override
	public void setUserAuth(String loginHtml) {
		userAuth.setInnerHTML(loginHtml);
		
	}


}