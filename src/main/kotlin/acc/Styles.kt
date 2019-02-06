package acc

import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val root by cssclass()
    }

    init {

        root {
            fontSize = 30.px
        }
    }
}
