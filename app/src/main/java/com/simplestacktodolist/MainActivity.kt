package com.simplestacktodolist

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.simplestacktodolist.ui.todolist.TodoListKey
import com.zhuinden.simplestack.AsyncStateChanger
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackcomposeintegration.core.BackstackProvider
import com.zhuinden.simplestackcomposeintegration.core.ComposeStateChanger
import com.zhuinden.simplestackextensions.navigatorktx.androidContentFrame
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider

class MainActivity : AppCompatActivity() {
    private val composeStateChanger = ComposeStateChanger()


    private val backPressedCallback = object: OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!Navigator.onBackPressed(this@MainActivity)) {
                this.remove() // this is the only safe way to invoke onBackPressed while cancelling the execution of this callback
                onBackPressed() // this is the only safe way to invoke onBackPressed while cancelling the execution of this callback
                this@MainActivity.onBackPressedDispatcher.addCallback(this) // this is the only safe way to invoke onBackPressed while cancelling the execution of this callback
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBackPressedDispatcher.addCallback(backPressedCallback)

        val app = application as BaseApplication

        val backstack = Navigator.configure()
            .setGlobalServices(app.globalServices)
            .setScopedServices(DefaultServiceProvider())
            .setStateChanger(AsyncStateChanger(composeStateChanger))
            .install(this, androidContentFrame, History.of(TodoListKey()))

        setContent {
            BackstackProvider(backstack) {
                MaterialTheme {
                    Box(Modifier.fillMaxSize()) {
                        composeStateChanger.RenderScreen()
                    }
                }
            }
        }
    }

    override final fun onBackPressed() {
        super.onBackPressed()
    }
}