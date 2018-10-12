package ar.com.wolox.android.example.di

import ar.com.wolox.android.example.RootActivity
import ar.com.wolox.android.example.ui.example.ExampleActivity
import ar.com.wolox.android.example.ui.example.ExampleFragment
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.android.example.ui.home.HomeFragment
import ar.com.wolox.android.example.ui.logIn.LogInActivity
import ar.com.wolox.android.example.ui.logIn.LogInFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun exampleActivity(): ExampleActivity

    @ContributesAndroidInjector
    internal abstract fun exampleFragment(): ExampleFragment

    @ContributesAndroidInjector
    internal abstract fun logInActivity(): LogInActivity

    @ContributesAndroidInjector
    internal abstract fun logInFragment(): LogInFragment

    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity

    @ContributesAndroidInjector
    internal abstract fun HomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun HomeActivity(): HomeActivity
}
