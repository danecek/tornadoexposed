package acc.richclient.dialogs

import acc.business.Facade

class DocumentUpdateDialog : DocumentDialogFragment(DialogMode.UPDATE) {
    override val ok = {
        Facade.updateDoc(docModel.id.value, docModel.description.value)
    }
}