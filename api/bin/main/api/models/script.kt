package api.models

import org.joda.time.DateTime

data class ScriptCreate (
    val type: String,
    val text: String,
)

data class ScriptId (
    val id: Int,
)

data class ScriptDto (
    val id: Int,
    val text: String,
    val created: DateTime,
    val updated: DateTime,
    val stdout: String,
    val stderr: String,
    val type: String,
)
