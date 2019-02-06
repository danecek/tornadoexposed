package acc.richclient.dialogs

import acc.business.Facade

class DocumentCreateDialog : DocumentDialogFragment(DialogMode.CREATE) {

    override val ok: () -> Unit = {
        Facade.createDoc(docModel.description.value ?: "")
    }
}