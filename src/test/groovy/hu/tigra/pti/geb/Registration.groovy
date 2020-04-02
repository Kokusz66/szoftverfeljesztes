package hu.tigra.pti.geb

class Registration extends BaseSpec {

    def 'Regisztráció'() {
        given: 'Megérkezünk a főoldalra.'
        MainPage mainPage = waitFor { to MainPage }

        when: 'Rákattintok a Sign in gombra.'
        mainPage.loginButton.click()

        then: 'Megérkezek a bejelentkező/regisztráció felületre.'
        LoginPage loginPage = waitFor { at LoginPage }
        loginPage.createForm.displayed

        when: 'Regisztrálok, e-mail adress-t kell kötölteni egy nem regisztált email címmel és meg kell nyomni „create an account” funkciógombot'
        loginPage.newEmailAddress = 'tcsaba@gmail.com'
        loginPage.createAccButton.click()

        then: 'Megérkezünk a regisztrációs űrlapra '
        RegistrationPage registrationPage = waitFor { at RegistrationPage}
        registrationPage.accountCreationForm.displayed

        when: 'a regisztrációs űrlap kitöltése helyes adatokkal és meg kell nyomni a „register” funkciógombot'
        registrationPage.firstName = 'Csaba'
        registrationPage.lastName = 'Tóth'
        registrationPage.passwd = 'Admin'
        registrationPage.registerButton.click()


        then: '’Megjelenik egy hibaüzenet: „There are 5 errors”.'

        when: 'Kitöltöm a „Your address” blokkban az összes mezőt és „Register” funkciógombra kattintok.'
        registrationPage.addressFirstName = 'Csaba'
        registrationPage.addressLastName = 'Tóth'
        registrationPage.addresss1 = 'Kossuth street'
        registrationPage.city = 'New York'
        registrationPage.state = 'New York'
        registrationPage.zip = '20200'
        registrationPage.mobile = '+32565325'
        registrationPage.aliasAddress = 'homeAddress'
        registrationPage.registerButton.click()

        then: 'Megjelenik a felhasználó adatai felület: “My account”.'
        MyAccountPage myAccountPage = waitFor { at MyAccountPage }
        myAccountPage.header.text() == "MY ACCOUNT"
    }
}