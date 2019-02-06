package acc.integration

import acc.model.Document

interface DocumentDAO {
    val allDocs: List<Document>
    fun createDoc(description: String)

    fun updateDoc(id: Int, description: String)

    fun deleteDoc(id: Int)

}