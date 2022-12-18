package api.handlers

import api.models.ScriptCreate
import api.models.ScriptId

interface CreateScriptV1Handler {
    operator fun invoke(req: ScriptCreate): ScriptId
}

class CreateScriptV1HandlerImpl : CreateScriptV1Handler {
    override fun invoke(req: ScriptCreate): ScriptId {
        return ScriptId(id=666)
    }
}

