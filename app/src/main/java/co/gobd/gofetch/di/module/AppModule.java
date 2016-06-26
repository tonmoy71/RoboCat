package co.gobd.gofetch.di.module;

import android.app.Application;
import android.content.Context;
import co.gobd.gofetch.adapter.SupportedOrderAdapter;
import co.gobd.gofetch.service.order.OrderService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by tonmoy on 19-Apr-16.
 */
@Module public class AppModule {

  private Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton public Context providesContext() {
    return application;
  }

  @Provides @Singleton
  public SupportedOrderAdapter provideSupportedOrderAdapter(Context context, OrderService service) {
    return new SupportedOrderAdapter(context, service);
  }
}
