package hu.tigra.pti.geb.page

import geb.Page
import hu.tigra.pti.geb.module.SuccessMessage

class PopupPage  extends Page{

    static url = "/index.php"

    static at = { title == 'My Store' }

    static content = {
        proceedButton { $( 'a[class="btn btn-default button button-medium"]')}
        successfullyAdded { $('div[class="layer_cart_product col-xs-12 col-md-6"]:first-of-type').module SuccessMessage}
    }
}
