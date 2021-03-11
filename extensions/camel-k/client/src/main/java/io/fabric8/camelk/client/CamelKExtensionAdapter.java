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
package io.fabric8.camelk.client;

import io.fabric8.kubernetes.client.ExtensionAdapterSupport;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import okhttp3.OkHttpClient;

import java.net.URL;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

public class CamelKExtensionAdapter extends ExtensionAdapterSupport implements ExtensionAdapter<CamelKClient> {

    static final ConcurrentMap<URL, Boolean> IS_CAMELK = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_CAMELK_APIGROUPS = new ConcurrentHashMap<>();
    
	@Override
	public Class<CamelKClient> getExtensionType() {
		return CamelKClient.class;
	}

	@Override
	public Boolean isAdaptable(Client client) {
		return isAdaptable(client, IS_CAMELK, USES_CAMELK_APIGROUPS, "camel.apache.org");
	}

	@Override
	public CamelKClient adapt(Client client) {
            return new DefaultCamelKClient(client.adapt(OkHttpClient.class), client.getConfiguration());
  }
	
}
