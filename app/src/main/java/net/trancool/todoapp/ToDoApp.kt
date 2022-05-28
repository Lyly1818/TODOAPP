package net.trancool.todoapp

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

//@ModuleDeclaration
class ToDoApp: Application() {
private val koinModule = module {
    single {
        ToDoRepository()
    }
}


    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            modules(koinModule)
        }
    }
}