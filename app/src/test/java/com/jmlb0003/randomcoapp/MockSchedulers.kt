package com.jmlb0003.randomcoapp

import com.jmlb0003.randomcoapp.domain.TasksSchedulers
import io.reactivex.Scheduler
import io.reactivex.internal.schedulers.ExecutorScheduler
import java.util.concurrent.Executor

object MockSchedulers : TasksSchedulers {

    private val immediateScheduler = object : Scheduler() {
        override fun createWorker(): Worker = ExecutorScheduler.ExecutorWorker(Executor { it.run() })
    }

    override fun getBackgroundThread(): Scheduler = immediateScheduler

    override fun getUiThread(): Scheduler = immediateScheduler

}