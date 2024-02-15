package com.jeluchu.monkx.core.exception

open class JikanException(override val message: String?, val code: Int? = null) : Exception()