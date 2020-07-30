package com.hbs.mybrawlstars.domain.remote.api

enum class HttpStatus {
    SUCCESS, INCORRECT_REQUEST, ACCESS_DENIED, NOT_FOUND_RESOURCE,
    EXCEEDED_USAGE, UNKNOWN_ERROR
}

fun Int.convertCodeToStatus(): HttpStatus {
    return when (this) {
        in 200 until 300 -> HttpStatus.SUCCESS
        400 -> HttpStatus.INCORRECT_REQUEST
        403 -> HttpStatus.ACCESS_DENIED
        404 -> HttpStatus.NOT_FOUND_RESOURCE
        429 -> HttpStatus.EXCEEDED_USAGE
        500 -> HttpStatus.UNKNOWN_ERROR
        else -> HttpStatus.UNKNOWN_ERROR
    }
}

fun HttpStatus.convertStatusToLogic(successLogic:()->Unit, failLogic:()->Unit, internalErrorLogic:()->Unit) {
    return when (this) {
        HttpStatus.SUCCESS -> successLogic()
        HttpStatus.INCORRECT_REQUEST -> failLogic()
        HttpStatus.ACCESS_DENIED -> failLogic()
        HttpStatus.NOT_FOUND_RESOURCE -> failLogic()
        HttpStatus.EXCEEDED_USAGE -> failLogic()
        HttpStatus.UNKNOWN_ERROR -> internalErrorLogic()
    }
}