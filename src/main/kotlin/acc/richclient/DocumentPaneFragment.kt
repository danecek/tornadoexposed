package acc.richclient.panes

import acc.business.Facade
import acc.model.Document
import acc.richclient.dialogs.DocumentDeleteDialog
import acc.richclient.dialogs.DocumentUpdateDialog
import acc.util.Messages
import tornadofx.*

open class DocumentPaneFragment : View() {

    override val root = tableview(Facade.allDocs.observable()) {

        readonlyColumn(Messages.Id.cm(), Document::id)
        readonlyColumn(Messages.Popis.cm(), Document::description)
        contextmenu {
            item(Messages.Zmen_doklad.cm()) {
                action { find<DocumentUpdateDialog>(params = mapOf("doc" to selectedItem)).openModal() }
            }
            item(Messages.Zrus_doklad.cm()) {
                action {
                    find<DocumentDeleteDialog>(params = mapOf("doc" to selectedItem)).openModal()
                }
            }
        }
        smartResize()
    }

    fun refresh() {
        tornadofx.runAsync {
            Facade.allDocs
        } fail {
            error(it)
        } ui {
            println(it)
            root.items.setAll(it)
        }

    }


}