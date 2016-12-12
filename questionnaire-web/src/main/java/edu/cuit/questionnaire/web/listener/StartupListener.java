package edu.cuit.questionnaire.web.listener;

import edu.cuit.questionnaire.web.config.SysConfig;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartupListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("系统初始化开始...");
        try {
            SysConfig.init();
        } catch (IOException e) {
            logger.info("系统初始化出错...");
            e.printStackTrace();
        }
        logger.info("系统初始化完成...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("系统关闭中...");
    }

}
