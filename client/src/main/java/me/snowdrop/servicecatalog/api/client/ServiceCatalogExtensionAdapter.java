/**
  * Copyright (C) 2018 Red Hat, Inc.
  *     
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
  * 
**/
package me.snowdrop.servicecatalog.api.client;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import okhttp3.OkHttpClient;

public class ServiceCatalogExtensionAdapter implements ExtensionAdapter<ServiceCatalogClient> {

	@Override
	public Class<ServiceCatalogClient> getExtensionType() {
		return ServiceCatalogClient.class;
	}

	@Override
	public Boolean isAdaptable(Client client) {
		return null;
	}

	@Override
	public ServiceCatalogClient adapt(Client client) {
            return new DefaultServiceCatalogClient(client.adapt(OkHttpClient.class), client.getConfiguration());
	}

}
