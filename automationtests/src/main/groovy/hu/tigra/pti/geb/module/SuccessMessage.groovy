package hu.tigra.pti.geb.module

import geb.Module

class SuccessMessage extends Module {

    static content = {
        values { navigator.find('h2').collect{ h2 -> h2.text() } }
    }
}
