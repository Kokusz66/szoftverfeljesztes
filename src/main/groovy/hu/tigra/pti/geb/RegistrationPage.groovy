package hu.tigra.pti.geb

import geb.Page

class RegistrationPage extends Page {

    static url = "index.php?controller=authentication&back=my-account#account-creation"

    static at = { accountCreationForm.displayed }

    static content = {
        accountCreationForm { $('form[id="account-creation_form"]') }
        firstName { $('form[id="account-creation_form"] input[id="customer_firstname"]') }
        lastName { $('form[id="account-creation_form"] input[id="customer_lastname"]') }
        passwd { $('form[id="account-creation_form"] input[id="passwd"]') }
        addressFirstName { $('form[id="account-creation_form"] input[id="firstname"]') }
        addressLastName { $('form[id="account-creation_form"] input[id="lastname"]') }
        addresss1 { $('form[id="account-creation_form"] input[id="address1"]') }
        city { $('form[id="account-creation_form"] input[id="city"]') }
        state { $('form[id="account-creation_form"] select[id="id_state"]') }
        zip { $('form[id="account-creation_form"] input[id="postcode"]') }
        country { $('form[id="account-creation_form"] select[id="id_country"]') }
        mobile { $('form[id="account-creation_form"] input[id="phone_mobile"]') }
        aliasAddress { $('form[id="account-creation_form"] input[id="alias"]') }
        registerButton { $('form[id="account-creation_form"] button[id="submitAccount"]') }
    }
}
