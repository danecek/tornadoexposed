package acc.richclient.dialogs

import acc.model.Document
import acc.richclient.panes.DocumentPaneFragment
import acc.util.Messages
import acc.util.withColon
import tornadofx.*

abstract class DocumentDialogFragment(private val mode: DialogMode) : Fragment() {

    class DocumentDialogModel(doc: Document?) : ItemViewModel<Document>(doc) {
        val id = bind(Document::id)
        val description = bind(Document::description)
    }

    val docModel = DocumentDialogModel(params["doc"] as? Document)

    init {
        title = when (mode) {
            DialogMode.CREATE -> Messages.Vytvor_doklad.cm()
            DialogMode.UPDATE -> Messages.Zmen_doklad.cm()
            DialogMode.DELETE -> Messages.Zrus_doklad.cm()
        }
    }

    override val root = form {
        fieldset {
            field(acc.util.Messages.Popis.cm().withColon) {
                textfield(docModel.description).isDisable =
                        mode == acc.richclient.dialogs.DialogMode.DELETE
            }
        }
        buttonbar {
            button(acc.util.Messages.Potvrd.cm()) {
                enableWhen(docModel.valid)
                action {
                    runAsync {
                        ok()
                    } fail {
                        error(it)
                    } ui {
                        find<DocumentPaneFragment>().refresh()
                        close()
                    }
                }

            }

            button(acc.util.Messages.Zrus.cm()) {
                action {
                    close()
                }
            }
        }

    }

    abstract val ok: () -> Unit
}



