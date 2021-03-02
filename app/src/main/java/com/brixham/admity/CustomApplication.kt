package com.brixham.admity

import android.app.Application
import com.brixham.admity.network.ApiService
import com.brixham.admity.network.interceptors.ConnectivityInterceptor
import com.brixham.admity.network.interceptors.ConnectivityInterceptorImpl
import com.brixham.admity.network.interceptors.ResponseInterceptor
import com.brixham.admity.network.interceptors.ResponseInterceptorImpl
import com.brixham.admity.repositories.LoginRepository
import com.brixham.admity.repositories.LoginRepositoryImpl
import com.brixham.admity.viewmodels.LoginViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CustomApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@CustomApplication))

        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind<ResponseInterceptor>() with singleton { ResponseInterceptorImpl() }

        bind() from singleton { ApiService(instance(), instance()) }

        bind<LoginRepository>() with singleton { LoginRepositoryImpl(instance()) }

        bind() from provider {
            LoginViewModelFactory(
                instance()
            )
        }
    }
}