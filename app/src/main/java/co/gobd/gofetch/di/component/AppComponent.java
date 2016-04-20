package co.gobd.gofetch.di.component;

import javax.inject.Singleton;

import co.gobd.gofetch.ui.activity.SupportedOrderActivity;
import co.gobd.gofetch.di.module.ApiModule;
import co.gobd.gofetch.di.module.AppModule;
import co.gobd.gofetch.di.module.ServiceModule;
import dagger.Component;

/**
 * Created by tonmoy on 07-Apr-16.
 */

@Singleton
@Component(modules = {ApiModule.class, ServiceModule.class, AppModule.class})
public interface AppComponent {
    void inject(SupportedOrderActivity target);
}
