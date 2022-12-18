package api

import api.handlers.*
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer


val app: HttpHandler = routes(
    "/ping" bind GET to {
        Response(OK).body("pong")
    },

)

fun main() {

    val app = Router(
        createScriptV1Handler=CreateScriptV1HandlerImpl(),
    )()
    val server = app.asServer(SunHttp(9000))
    server.start()
    println("Server started on " + server.port())
}
