package hu.tigra.pti.geb.module

import geb.Module

class ProductRow extends Module {

    static content = {
        firstRow { navigator.find( 'tr[id="product_7_34_0_279051"]')}

        quantity { navigator.find('td.cart_quantity').find('input[name="quantity_7_34_0_279051_hidden"]')
                .value().toString().toInteger() }

        plusButton { navigator.find('td.cart_quantity').find('a.cart_quantity_up.button-plus') }
    }
}
