package com.jmlb0003.randomcoapp.domain

import io.reactivex.Scheduler

interface TasksSchedulers {

    fun getBackgroundThread(): Scheduler

    fun getUiThread(): Scheduler

}