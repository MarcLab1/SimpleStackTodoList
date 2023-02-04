package com.simplestacktodolist

import android.app.Application
import com.simplestacktodolist.data.database.TodoDatabase
import com.simplestacktodolist.data.repository.TodoRepository
import com.zhuinden.simplestack.GlobalServices
import com.zhuinden.simplestackextensions.servicesktx.add

class BaseApplication : Application() {
    lateinit var globalServices: GlobalServices
        private set

    override fun onCreate() {
        super.onCreate()

        globalServices = GlobalServices.builder()
            .add(TodoRepository(TodoDatabase.invoke(this)))
            .build()
    }
}