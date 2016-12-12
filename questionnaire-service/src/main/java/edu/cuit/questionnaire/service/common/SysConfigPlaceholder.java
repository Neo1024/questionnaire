/*
 * 
 *  Copyright © 2014 - 2015 BatS Technology Co., Ltd. All rights reserved.
 *  成都宝诗科技有限公司 版权所有
 *  http://bats.im , http://ixix.im
 * 
 */
package edu.cuit.questionnaire.service.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 系统配置信息<br>
 * 
 * @author Leckie
 * @date May 13, 2015
 */
public class SysConfigPlaceholder extends PropertyPlaceholderConfigurer {

	private static Map<String, String> properties = new HashMap<>();

	@Override
	protected void processProperties(
	        ConfigurableListableBeanFactory beanFactoryToProcess,
	        Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for (Object key : props.keySet()) {
			properties.put(String.valueOf(key), String.valueOf(props.get(key)));
		}
	}

	public static String getProperty(String key) {
		return properties.get(key);
	}
}
