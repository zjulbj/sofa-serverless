/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.sofa.rpc.dubbo26.base;

import java.io.File;

import com.alipay.sofa.ark.api.ArkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author syd
 * @version BaseApplication.java, v 0.1 2023年10月31日 19:27 syd
 */

@SpringBootApplication
public class BaseApplication implements CommandLineRunner {
    private static Logger LOGGER = LoggerFactory.getLogger(BaseApplication.class);

    public static void main(String[] args) {

        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");

        // 设置内嵌方式启动多模块运行容器, 也可以放在启动参数中
        System.setProperty("sofa.ark.embed.enable", "true");
        System.setProperty("sofa.ark.plugin.export.class.enable", "true");

        SpringApplication.run(BaseApplication.class, args);
    }

    /**
     * Install biz when base started
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        File biz1 = new File("./rpc/dubbo26/dubbo26biz/target/dubbo26biz-0.0.1-SNAPSHOT-ark-biz.jar");
        File biz2 = new File("./rpc/dubbo26/dubbo26biz2/target/dubbo26biz2-0.0.1-SNAPSHOT-ark-biz.jar");
        try {
            if (biz1.exists()) {
                ArkClient.installBiz(biz1);
            } else {
                LOGGER.warn(biz1.getAbsolutePath() + " do not exist");
            }
            if (biz2.exists()) {
                ArkClient.installBiz(biz2);
            } else {
                LOGGER.warn(biz2.getAbsolutePath() + " do not exist");
            }
        } catch (Throwable e) {
            LOGGER.error("Install biz failed", e);
        }
    }
}