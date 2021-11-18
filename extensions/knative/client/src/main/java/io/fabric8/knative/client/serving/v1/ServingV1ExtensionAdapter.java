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
package io.fabric8.knative.client.serving.v1;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import io.fabric8.kubernetes.client.ExtensionAdapterSupport;

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServingV1ExtensionAdapter extends ExtensionAdapterSupport implements ExtensionAdapter<ServingV1Client> {

    static final ConcurrentMap<URL, Boolean> IS_KNATIVE = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_KNATIVE_APIGROUPS = new ConcurrentHashMap<>();

	@Override
	public Class<ServingV1Client> getExtensionType() {
		return ServingV1Client.class;
	}

	@Override
	public Boolean isAdaptable(Client client) {
		return isAdaptable(client, IS_KNATIVE, USES_KNATIVE_APIGROUPS, "knative.dev");
	}

	@Override
	public ServingV1Client adapt(Client client) {
    return new DefaultServingV1Client(client);
	}
}
