package acc.richclient

import acc.richclient.dialogs.DocumentCreateDialog
import acc.util.Messages
import javafx.application.Platform
import tornadofx.*


class AccMenuBar : View() {

    override val root = menubar {
        menu(Messages.File.cm()) {
            item(Messages.Konec.cm()) {
                action {
                    Platform.exit()
                }
            }
        }
        menu(Messages.Doklady.cm()) {

            item(Messages.Vytvor_doklad.cm()) {
                action {
                    find<DocumentCreateDialog>().openModal()
                }
            }

        }
    }

}

