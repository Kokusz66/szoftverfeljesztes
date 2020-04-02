package hu.tigra.pti.geb

class WrongLogin extends BaseSpec {

    def 'Helytelen bejelentkezés'() {
        given: 'Megérkezünk a főoldalra.'
        MainPage mainPage = waitFor { to MainPage }

        when: 'Rákattintok a Sign in gombra.'
        mainPage.loginButton.click()

        then: 'Megérkezek a bejelentkező felületre.'
        LoginPage loginPage = waitFor { at LoginPage }
        loginPage.loginForm.displayed

        when: 'Kitöltöm a mezőket helytelen e-mail címmel és helyes jelszóval és rányomok a belépés gombra.'
        loginPage.emailAddress = 'tcsaba@tigra.hu'
        loginPage.password = 'Admin'
        loginPage.loginButton.click()

        then: 'Megjelenik a "There is 1 error Authentication failed" '
    }
}
