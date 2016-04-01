package pl.kuranc.fotokonkurs.client.application.register;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class RegisterView extends ViewWithUiHandlers<RegisterUiHandlers> implements RegisterPresenter.MyView {
    interface Binder extends UiBinder<Widget, RegisterView> {
    }

    @UiField
    SimplePanel main;

    @Inject
    RegisterView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == RegisterPresenter.SLOT_Register) {
            main.setWidget(content);
        } else {
            super.setInSlot(slot, content);
        }
    }
}