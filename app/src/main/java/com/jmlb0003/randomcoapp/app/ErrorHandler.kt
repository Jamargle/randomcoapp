package com.jmlb0003.randomcoapp.app

import android.util.Log

object ErrorHandler {

    fun handleViewNullError(tag: String) {
        // TODO
        // This should be only in the debug flavor
        Log.d(tag, "$tag: View not available")
    }

    fun handleError(error: Throwable) {
        // TODO send error through Fabric or any other log tool
    }

}