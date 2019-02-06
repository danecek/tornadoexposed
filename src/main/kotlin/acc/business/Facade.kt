package acc.business

import acc.integration.DocDAOH2
import acc.integration.DocumentDAO

object Facade : DocumentDAO by DocDAOH2