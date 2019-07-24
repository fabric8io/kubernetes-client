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
package io.fabric8.knative.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import okhttp3.OkHttpClient;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

public class KnativeExtensionAdapter implements ExtensionAdapter<KnativeClient> {

    static final ConcurrentMap<URL, Boolean> IS_TEKTON = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_TEKTON_APIGROUPS = new ConcurrentHashMap<>();
    
	@Override
	public Class<KnativeClient> getExtensionType() {
		return KnativeClient.class;
	}

	@Override
	public Boolean isAdaptable(Client client) {
		return isKnativeAvailable(client);
	}

	@Override
	public KnativeClient adapt(Client client) {
            return new DefaultKnativeClient(client.adapt(OkHttpClient.class), client.getConfiguration());
	}

	private boolean isKnativeAvailable(Client client) {
        URL masterUrl = client.getMasterUrl();
        if (IS_TEKTON.containsKey(masterUrl)) {
            return IS_TEKTON.get(masterUrl);
        } else {
            RootPaths rootPaths = client.rootPaths();
            if (rootPaths != null) {
                List<String> paths = rootPaths.getPaths();
                if (paths != null) {
                    for (String path : paths) {
                        // lets detect the new API Groups APIs for OpenShift
                        if (path.endsWith("knative.dev") || path.contains("knative.dev/")) {
                            USES_TEKTON_APIGROUPS.putIfAbsent(masterUrl, true);
                            IS_TEKTON.putIfAbsent(masterUrl, true);
                            return true;
                        }
                    }
                }
            }
        }
        IS_TEKTON.putIfAbsent(masterUrl, false);
        return false;
    }
}
