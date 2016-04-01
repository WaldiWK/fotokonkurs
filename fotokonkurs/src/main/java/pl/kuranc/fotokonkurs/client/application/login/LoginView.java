package pl.kuranc.fotokonkurs.client.application.login;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

class LoginView extends ViewWithUiHandlers<LoginUiHandlers> implements LoginPresenter.MyView {
    interface Binder extends UiBinder<Widget, LoginView> {
    }

    @UiField
    SimplePanel main;

    @UiField
    TextBox tbLogin;
    
    @UiField
    PasswordTextBox ptbPassword;
    
    @UiField
    Button btnLogin;
    
    @Inject
    LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler ("btnLogin")
    void onBtnLogin(ClickEvent event){
 	   getUiHandlers().loginUser(tbLogin.getText(), ptbPassword.getText());
 	   System.out.print("Presenter User :"+tbLogin.getText()+"Password"+ptbPassword.getText());
    }
    
    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == LoginPresenter.SLOT_Login) {
            main.setWidget(content);
        } else {
            super.setInSlot(slot, content);
        }
    }
}