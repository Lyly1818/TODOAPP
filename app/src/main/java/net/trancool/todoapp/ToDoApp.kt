package net.trancool.todoapp

import ToDoRepository
import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import net.trancool.todoapp.repo.ToDoDatabase
import net.trancool.todoapp.repo.ToDoRepository
import net.trancool.todoapp.ui.SingleModelMotor
import net.trancool.todoapp.ui.roster.RosterMotor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

//@ModuleDeclaration
class ToDoApp: Application() {
private val koinModule = module {
    single { ToDoRepository(
        get<ToDoDatabase>().todoStore(),
        get(named("appScope"))
    )
    }
    single (named("appScope") ) {CoroutineScope(SupervisorJob())}
    single {
        ToDoDatabase.newInstance(androidContext())
    }
    viewModel{ RosterMotor(get()) }
    viewModel{ (modelId: String) -> SingleModelMotor(get(), modelId) }
}
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@ToDoApp)
            modules(koinModule)
        }
    }


}