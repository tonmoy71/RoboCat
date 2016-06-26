package co.gobd.gofetch.di.component;

import co.gobd.gofetch.di.module.ApiModule;
import co.gobd.gofetch.di.module.AppModule;
import co.gobd.gofetch.di.module.ServiceModule;
import co.gobd.gofetch.ui.activity.LoginActivity;
import co.gobd.gofetch.ui.activity.SignUpActivity;
import co.gobd.gofetch.ui.activity.SupportedOrderActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by tonmoy on 07-Apr-16.
 */

@Singleton @Component(modules = { ApiModule.class, ServiceModule.class, AppModule.class })
public interface AppComponent {
  void inject(SupportedOrderActivity target);

  void inject(LoginActivity target);

  void inject(SignUpActivity target);
}
