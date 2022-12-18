package api

import api.handlers.*
import api.models.*
import api.util.ApiJackson.auto
import org.http4k.core.*
import org.http4k.filter.CorsPolicy
import org.http4k.filter.ServerFilters
import org.http4k.lens.*
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes

import org.http4k.filter.DebuggingFilters.PrintRequestAndResponse

class Router(
    val createScriptV1Handler: CreateScriptV1Handler,
) {
    operator fun invoke(): RoutingHttpHandler =
        PrintRequestAndResponse().then(routes(
            "/api/v1" bind routes (
                "script" bind Method.POST to createScriptV1()
            ),
        )
    )
    
    private val scriptCreateRequestLens = Body.auto<ScriptCreateRequest>().toLens()
    private val scriptCreateResponseLens = Body.auto<ScriptCreateResponse>().toLens()
    
    private fun createScriptV1() = { req: Request ->
        val res = createScriptV1Handler(scriptCreateRequestLens(req).script)
        scriptCreateResponseLens(ScriptCreateResponse(scriptId=res), Response(Status.CREATED))
    }
}

data class ScriptCreateRequest(val script: ScriptCreate)
data class ScriptCreateResponse(val scriptId: ScriptId)
