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
package io.fabric8.knative.client.serving.v1beta1;

import io.fabric8.kubernetes.client.ExtensionAdapterSupport;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import okhttp3.OkHttpClient;

import java.net.URL;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

public class ServingV1Beta1ExtensionAdapter extends ExtensionAdapterSupport implements ExtensionAdapter<ServingV1Beta1Client> {

    static final ConcurrentMap<URL, Boolean> IS_KNATIVE = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_KNATIVE_APIGROUPS = new ConcurrentHashMap<>();
    
	@Override
	public Class<ServingV1Beta1Client> getExtensionType() {
		return ServingV1Beta1Client.class;
	}

	@Override
	public Boolean isAdaptable(Client client) {
		return isAdaptable(client, IS_KNATIVE, USES_KNATIVE_APIGROUPS, "knative.dev");
	}

	@Override
	public ServingV1Beta1Client adapt(Client client) {
    return new DefaultServingV1Beta1Client(client.adapt(OkHttpClient.class), client.getConfiguration());
	}
}
