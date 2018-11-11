package com.jmlb0003.randomcoapp.app

import com.jmlb0003.randomcoapp.domain.TasksSchedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

object Schedulers : TasksSchedulers {

    private val backgroundThreadInstance: Scheduler by lazy { io.reactivex.schedulers.Schedulers.io() }

    private val uiThreadInstance: Scheduler by lazy { AndroidSchedulers.mainThread() }

    override fun getBackgroundThread(): Scheduler = backgroundThreadInstance

    override fun getUiThread(): Scheduler = uiThreadInstance

}