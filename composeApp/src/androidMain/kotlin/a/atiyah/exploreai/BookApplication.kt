package a.atiyah.exploreai

import android.app.Application
import a.atiyah.exploreai.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }
    }
}