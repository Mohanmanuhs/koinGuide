package com.example.koinguide

import org.koin.core.qualifier.named
import org.koin.dsl.module

val activityModule= module {
    //dependency scope is just inside MainActivity
    scope<MainActivity> {
        scoped(qualifier = named("hello")){ "hello" }
        scoped(qualifier = named("bye")) { "bye" }

    }
}