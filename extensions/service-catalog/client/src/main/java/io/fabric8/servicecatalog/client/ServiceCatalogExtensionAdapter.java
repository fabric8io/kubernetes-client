/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.servicecatalog.client;

import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import okhttp3.OkHttpClient;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServiceCatalogExtensionAdapter implements ExtensionAdapter<ServiceCatalogClient> {

    static final ConcurrentMap<URL, Boolean> IS_SERVICE_CATALOG = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_SERVICE_CATALOG_APIGROUPS = new ConcurrentHashMap<>();

	@Override
	public Class<ServiceCatalogClient> getExtensionType() {
		return ServiceCatalogClient.class;
	}

	@Override
	public Boolean isAdaptable(Client client) {
		return isServiceCatalogAvailable(client);
	}

	@Override
	public ServiceCatalogClient adapt(Client client) {
            return new DefaultServiceCatalogClient(client.adapt(OkHttpClient.class), client.getConfiguration());
	}

	private boolean isServiceCatalogAvailable(Client client) {
        URL masterUrl = client.getMasterUrl();
        if (IS_SERVICE_CATALOG.containsKey(masterUrl)) {
            return IS_SERVICE_CATALOG.get(masterUrl);
        } else {
            RootPaths rootPaths = client.rootPaths();
            if (rootPaths != null) {
                List<String> paths = rootPaths.getPaths();
                if (paths != null) {
                    for (String path : paths) {
                        // lets detect the new API Groups APIs for OpenShift
                        if (path.endsWith("servicecatalog.k8s.io") || path.contains("servicecatalog.k8s.io/")) {
                            USES_SERVICE_CATALOG_APIGROUPS.putIfAbsent(masterUrl, true);
                            IS_SERVICE_CATALOG.putIfAbsent(masterUrl, true);
                            return true;
                        }
                    }
                }
            }
        }
        IS_SERVICE_CATALOG.putIfAbsent(masterUrl, false);
        return false;
    }
}
