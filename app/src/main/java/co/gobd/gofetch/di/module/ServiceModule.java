package co.gobd.gofetch.di.module;

import co.gobd.gofetch.network.AccountApi;
import co.gobd.gofetch.network.OrderApi;
import co.gobd.gofetch.service.account.AccountService;
import co.gobd.gofetch.service.account.AccountServiceImpl;
import co.gobd.gofetch.service.order.OrderService;
import co.gobd.gofetch.service.order.OrderServiceImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by tonmoy on 19-Apr-16.
 */
@Module public class ServiceModule {

  @Provides @Singleton public OrderService providesOrderService(OrderApi api) {
    return new OrderServiceImpl(api);
  }

  @Provides @Singleton public AccountService providesAccountService(AccountApi api) {
    return new AccountServiceImpl(api);
  }
}
