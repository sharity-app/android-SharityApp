package com.sharity.sharityUser.LoginPro;

public class LoginProPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginProView loginView;
    private LoginInteractor loginInteractor;

    public LoginProPresenterImpl(LoginProView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginProInteractorImpl();
    }

    @Override public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
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

    @Override public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}