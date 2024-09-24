package com.jeluchu.monkx.core.exception

open class MonkxException(override val message: String?, val code: Int? = null) : Exception()