package co.gobd.gofetch.di.component;

import javax.inject.Singleton;

import co.gobd.gofetch.di.module.ApiModule;
import dagger.Component;

/**
 * Created by tonmoy on 07-Apr-16.
 */

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {
    //TODO inject methods
}
