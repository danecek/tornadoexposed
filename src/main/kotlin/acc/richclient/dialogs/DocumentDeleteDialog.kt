package acc.richclient.dialogs

import acc.business.Facade

class DocumentDeleteDialog : DocumentDialogFragment(DialogMode.DELETE) {

    override val ok: () -> Unit = {
        Facade.deleteDoc(docModel.id.value)
    }
}