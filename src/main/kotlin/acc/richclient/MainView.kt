package acc.richclient

import acc.richclient.panes.DocumentPaneFragment
import acc.util.Messages
import tornadofx.*


class MainView : View(Messages.Doklady.cm()) {

    override val root = borderpane {

        top<AccMenuBar>()
        center<DocumentPaneFragment>()
    }
}


