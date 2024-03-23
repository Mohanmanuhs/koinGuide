package com.example.koinguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.koinguide.ui.theme.KoinGuideTheme
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

//should be added when using scope
class MainActivity : ComponentActivity(), AndroidScopeComponent {

    //to use the view model(xml)
    //private val viewModel by viewModel<MainViewModel>()


    //to inject other dependency in main activity
    //private val myApi = get<MyApi>()

    //for lazy injection(injected when we use it for first time)
    //private val myApi by inject<MyApi>()

    //override val scope:Scope by activityRetainedScope()  it is for retained(means it retains even for recreation of app

    override val scope: Scope by activityScope()
    private val hello by inject<String>(qualifier = named("hello"))
    private val bye by inject<String>(qualifier = named("bye"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(bye)

        setContent {
            KoinGuideTheme {
                // to use the view model (compose)
                val viewModel = getViewModel<MainViewModel>()
                viewModel.doNetworkCall()

            }
        }
    }
}

