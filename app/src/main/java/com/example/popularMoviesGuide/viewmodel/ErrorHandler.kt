package com.example.popularMoviesGuide.viewmodel

open class ErrorHandler<String>(private val errorMessage: String) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): String? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            errorMessage
        }
    }
}