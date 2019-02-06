package acc.integration

import acc.Options
import acc.model.Document
import acc.util.AccException
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction


object DocDAOH2 : DocumentDAO {

    init {
        Database.connect(url = "jdbc:h2:/" + Options.h2File,
                driver = "org.h2.Driver")
        transaction {
            SchemaUtils.create(DocumentTable)
        }
    }

    override val allDocs: List<Document>
        get() =
            transaction {
                DocumentTable.selectAll().map {
                    Document(it[DocumentTable.id].value, it[DocumentTable.description])
                }
            }


    override fun createDoc(description: String) {
        transaction {
            DocumentTable.insert {
                it[this.description] = description
            }
        }
    }

    override fun updateDoc(id: Int, description: String) {
        transaction {
            DocumentTable.update({
                (DocumentTable.id eq id)
            })
            {

                it[this.description] = description
            }

        }
    }

    @Throws(AccException::class)
    override fun deleteDoc(id: Int) {
        transaction {
            DocumentTable.deleteWhere {
                (DocumentTable.id eq id)
            }

        }

    }

}
