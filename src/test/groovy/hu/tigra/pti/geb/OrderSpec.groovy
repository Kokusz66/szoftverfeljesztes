package hu.tigra.pti.geb

import hu.tigra.pti.geb.module.ProductRow
import hu.tigra.pti.geb.page.MainPage
import hu.tigra.pti.geb.page.MyAccountPage
import hu.tigra.pti.geb.page.OrderPage
import hu.tigra.pti.geb.page.PopupPage

class OrderSpec extends BaseSpec {

    def 'Legolcsóbb termék megrendelése'() {
        given: 'Bejelentkezek az oldalra'
        login(Constant.USERS.HELYES_FELHASZNALO)
        waitFor { at MyAccountPage }

        when: 'Átnavigálok a főoldalra'
        def mainPage = to MainPage

        then: 'Megjelennek a termékek'
        mainPage.products.size() != 0

        when: 'A kurzort a legolcsóbb fölé viszem és rákattintok az "Add to cart" gombra'
        def cheapestProduct = mainPage.products.min { product -> product.price }
        interact {
            moveToElement(cheapestProduct.navigator)
        }
        cheapestProduct.addToCart.click()

        // Órai feladat
        then: 'Megjelenik a kosár popup és a "Product successfully added to your shopping cart" üzenet'
        def popupPage = waitFor { at PopupPage}
        popupPage.successfullyAdded == 'Product successfully added to your shopping cart'

        when: 'Rákattintok a "Proceed to checkout" gombra'
        popupPage.proceedButton.click()

        then: 'Megjelenik a "SHOPPING-CART SUMMARY" fejlécű oldal'
        def orderPage = waitFor{ at OrderPage}
        orderPage.header.text().startsWith('SHOPPING-CART SUMMARY')

        // 3. Házi feladat
        when: 'Rákattintok a plusz gombra az első sorban'
        orderPage.summaryFirstRow.plusButton.click()

        then: 'A mennyiség 2-re változik'
        orderPage.summaryFirstRow.quantity == 1

        when: 'Rákattintok a "Proceed to checkout" gombra'
        orderPage.nextButton.click()

        then: 'Megjelenik az "ADDRESSES" fejlécű oldal'
        orderPage.header.text() == "ADDRESSES"

        when: 'Rákattintok a "Proceed to checkout" gombra'
        orderPage.nextButton.click()

        then: 'Megjelenik a "SHIPPING" fejlécű oldal'
        orderPage.header.text() == "SHIPPING"

        when: 'Bepipálom a checkboxot és rákattintok a "Proceed to checkout" gombra'
        orderPage.shippingAgreeTerms.check()
        orderPage.nextButton.click()

        then: 'Megjelenik a "PLEASE CHOOSE YOUR PAYMENT METHOD" fejlécű oldal'
        orderPage.header.text() == "PLEASE CHOOSE YOUR PAYMENT METHOD"

        when: 'Kiválasztom a csekk fizetési módot'
        orderPage.paymentCheckButton.click()

        then: 'Megjelenik az "ORDER SUMMARY" fejlécű oldal'
        orderPage.header.text() == "ORDER SUMMARY"

        when: 'Rákattintok az "I confirm my order" gombra'
        orderPage.confirmButton.click()

        then: 'Megjelenik a sikeres rendelés üzenete: "Your order on My Store is complete."'
        orderPage.message.text() == "Your order on My Store is complete."

    }
}
