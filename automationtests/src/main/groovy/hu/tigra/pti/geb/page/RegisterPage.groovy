package hu.tigra.pti.geb.page

import geb.Page
import geb.module.Checkbox
import geb.module.RadioButtons
import hu.tigra.pti.geb.module.Date
import hu.tigra.pti.geb.module.ErrorMessages

class RegisterPage extends Page {

    static url = 'index.php?controller=authentication&back=my-account#account-creation'

    static at = { header.text() == 'CREATE AN ACCOUNT' }

    static content = {
        header { $('h1[class="page-heading"]') }
        gender { $('input[type="radio"][name="id_gender"]').module(RadioButtons) }
        firstName { $('input[id="customer_firstname"]') }
        lastName { $('input[id="customer_lastname"]') }
        password { $('input[id="passwd"]') }
        dateOfBirth { module(Date) }
        newsletter { $('input[id="newsletter"]').module(Checkbox) }
        offers { $('input[id="optin"]').module(Checkbox) }
        addressFirstName { $('input[id="firstname"]')}
        addressLastName { $('input[id="lastname"]')}
        company { $('input[id="company"]')}
        address1 { $('input[id="address1"]')}
        city { $('input[id="city"]')}
        state { $('select[id="id_state"]')}
        zip { $('input[id="postcode"]')}
        country { $('select[id="id_country"]')}
        textArea { $('textarea[id="other"]')}
        homePhone { $('input[id="phone"]')}
        mobilePhone { $('input[id="phone_mobile"]')}
        aliasAddress { $('input[id="alias"]')}
        registerButton { $('button[id="submitAccount"]') }
        errorMessages(required: false) { $('div[class="alert alert-danger"]:first-of-type').module ErrorMessages }
        registerButton { $('button[id="submitAccount"]') }
        errorMessages(required: false) { $('div[class="alert alert-danger"]:first-of-type').module ErrorMessages }
    }
}
