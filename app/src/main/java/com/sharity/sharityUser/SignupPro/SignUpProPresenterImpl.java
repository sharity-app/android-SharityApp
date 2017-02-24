package com.sharity.sharityUser.SignupPro;

public class SignUpProPresenterImpl implements SignUpProPresenter, SignUpProInteractor.OnLoginFinishedListener {

    private SignUpProView loginView;
    private SignUpProInteractor loginInteractor;

    public SignUpProPresenterImpl(SignUpProView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new SignUpProInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password,String RC3number,String Businesname,String OwnerName,String Phone,String address,String RIB,String email) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password,RC3number,Businesname,OwnerName,Phone,address,RIB,email, this);
    }

    @Override public void onDestroy() {
        loginView = null;
    }

    @Override public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onRC3Error() {
        if (loginView != null) {
            loginView.setRC3Error();
        }
    }

    @Override
    public void onBusinessNameError() {
        if (loginView != null) {
            loginView.setBusinessNameError();
        }
    }

    @Override
    public void onOwnerNameError() {
        if (loginView != null) {
            loginView.setOwnerNameError();
        }
    }

    @Override
    public void onPhoneError() {
        if (loginView != null) {
            loginView.setPhoneError();
        }
    }

    @Override
    public void onAddressError() {
        if (loginView != null) {
            loginView.setAddressError();
        }
    }

    @Override
    public void onRIBError() {
        if (loginView != null) {
            loginView.setRIBError();
        }
    }

    @Override
    public void onEmailError() {
        if (loginView != null) {
            loginView.setEmailError();
        }
    }

    @Override public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}