package co.gobd.gofetch.di.module;

import javax.inject.Singleton;

import co.gobd.gofetch.network.Api;
import co.gobd.gofetch.service.order.OrderService;
import co.gobd.gofetch.service.order.OrderServiceImpl;
import co.gobd.gofetch.service.job.JobService;
import co.gobd.gofetch.service.job.JobServiceImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tonmoy on 19-Apr-16.
 */
@Module
public class ServiceModule {

    @Provides
    @Singleton
    public OrderService providesOrderService(Api api) {
        return new OrderServiceImpl(api);
    }

    @Provides
    @Singleton
    public JobService providesJobService(Api api) {
        return new JobServiceImpl(api);
    }
}
