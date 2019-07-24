package com.hazelcast.demo.configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HazelcastConfiguration {

    @Autowired
    HazelcastProperties hazelcastProperties;

    @Bean
    public Config hazelCastConfig() {
        Config config = new XmlConfigBuilder(getClass().getClassLoader().getResourceAsStream("hazelcast.xml")).build();
        return config;
    }

    private Config getByExternalizedProperties() {
        Config config = new XmlConfigBuilder(getClass().getClassLoader().getResourceAsStream("hazelcast.xml")).build();
        if (hazelcastProperties.getIp() != null)
            for (String ip : hazelcastProperties.getIp()) {
                config.getNetworkConfig().getJoin().getTcpIpConfig().addMember(ip);
            }

        //Comprobar que las ips estan en el config
        for (String ips : config.getNetworkConfig().getJoin().getTcpIpConfig().getMembers()) {
            System.out.println("Get ip" + ips);
        }
        return config;
    }
}
