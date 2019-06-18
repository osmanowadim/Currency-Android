package osmanowadim.currency.presentation.di.modules.binding

import dagger.Module
import dagger.android.ContributesAndroidInjector
import osmanowadim.currency.domain.scopes.PerActivity
import osmanowadim.currency.presentation.di.modules.activity.DetailActivityModule
import osmanowadim.currency.presentation.di.modules.activity.MainActivityModule
import osmanowadim.currency.presentation.ui.detail.DetailActivity
import osmanowadim.currency.presentation.ui.main.MainActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    abstract fun bindDetailActivity(): DetailActivity

}
