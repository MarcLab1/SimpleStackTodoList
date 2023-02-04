package com.simplestacktodolist.ui

sealed class Result {
    object Success : Result()
    object Error : Result()
}