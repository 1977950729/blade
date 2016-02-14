/**
 * Copyright (c) 2015, biezhi 王爵 (biezhi.me@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blade.loader;

import java.util.Map;

import com.blade.Const;

import blade.kit.StringKit;

/**
 * Blade configuration
 * 
 * @author <a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since 1.0
 */
public class Configurator {

	// Configuration object
	private BladeConfig bladeConfig;

	// Configuration Map
	private Map<String, String> configMap;

	public Configurator(BladeConfig bladeConfig, Map<String, String> configMap) {
		this.bladeConfig = bladeConfig;
		this.configMap = configMap;
	}

	public void run() {

		if (null != configMap && configMap.size() > 0) {

			bladeConfig.setConfigMap(configMap);
			
			String route = configMap.get(Const.BLADE_ROUTE);
			String ioc = configMap.get(Const.BLADE_IOC);
			String filter_folder = configMap.get(Const.BLADE_FILTER_FOLDER);
			String encoding = configMap.get(Const.BLADE_ENCODING);
			String view404 = configMap.get(Const.BLADE_VIEW_404);
			String view500 = configMap.get(Const.BLADE_VIEW_500);
			String dev = configMap.get(Const.BLADE_DEV);
			String xss = configMap.get(Const.BLADE_ENABLE_XSS);

			if (StringKit.isNotBlank(route)) {
				String[] blade_routes = StringKit.split(route, ",");
				bladeConfig.setRoutePackages(blade_routes);
			}

			if (StringKit.isNotBlank(filter_folder)) {
				String[] blade_filter_folders = StringKit.split(filter_folder, ",");
				bladeConfig.setStaticFolders(blade_filter_folders);
			}
			
			if (StringKit.isNotBlank(ioc)) {
				String[] blade_iocs = StringKit.split(ioc, ",");
				bladeConfig.setIocPackages(blade_iocs);
			}
			
			if (StringKit.isNotBlank(encoding)) {
				bladeConfig.setEncoding(encoding);
			}

			if (StringKit.isNotBlank(view404)) {
				bladeConfig.setView404(view404);
			}

			if (StringKit.isNotBlank(view500)) {
				bladeConfig.setView500(view500);
			}

			if (StringKit.isNotBlank(dev)) {
				Boolean isDev = Boolean.parseBoolean(dev);
				bladeConfig.setDev(isDev);
			}
			
			if (StringKit.isNotBlank(xss)) {
				Boolean enableXssBool = Boolean.valueOf(xss);
				bladeConfig.setEnableXSS(enableXssBool);
			}
		}
	}
}