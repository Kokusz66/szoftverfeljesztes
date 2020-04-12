package hu.tigra.pti.geb.page

import geb.Page
import hu.tigra.pti.geb.module.SuccessMessage

class PopupPage  extends Page {

    static at = { popup.displayed }

    static content = {
        popup { $('div[id="layer_cart"]') }
        proceedButton { popup.find('a[title="Proceed to checkout"]') }
        successfullyAdded() { popup.find('div.layer_cart_product').find('h2').text() }
    }
}