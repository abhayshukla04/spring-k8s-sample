package spring.kube;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Created by abhay shukla .
 */
@Configuration
public class HazelcastConfiguration {
    @Bean
    public Config hazelCastConfig(){
        Config config = new Config();
        config.setInstanceName("controller-instance")        // hazel case instance name
                .addMapConfig(
                        new MapConfig()                     // create map
                                .setName("configuration")
                                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                                .setEvictionPolicy(EvictionPolicy.LRU)
                                .setTimeToLiveSeconds(-1));     // cache will be available until it will remove manually. less then 0 means never expired.
        return config;
    }
}