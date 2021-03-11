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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.camelk.client.dsl.V1APIGroupDSL;
import io.fabric8.camelk.client.internal.v1.BuildOperationsImpl;
import io.fabric8.camelk.client.internal.v1.CamelCatalogOperationsImpl;
import io.fabric8.camelk.client.internal.v1.IntegrationKitOperationsImpl;
import io.fabric8.camelk.client.internal.v1.IntegrationOperationsImpl;
import io.fabric8.camelk.client.internal.v1.IntegrationPlatformOperationsImpl;
import io.fabric8.camelk.v1.Build;
import io.fabric8.camelk.v1.BuildList;
import io.fabric8.camelk.v1.CamelCatalog;
import io.fabric8.camelk.v1.CamelCatalogList;
import io.fabric8.camelk.v1.Integration;
import io.fabric8.camelk.v1.IntegrationKit;
import io.fabric8.camelk.v1.IntegrationKitList;
import io.fabric8.camelk.v1.IntegrationList;
import io.fabric8.camelk.v1.IntegrationPlatform;
import io.fabric8.camelk.v1.IntegrationPlatformList;
import okhttp3.OkHttpClient;

public class V1APIGroupClient extends BaseClient implements V1APIGroupDSL {
  public V1APIGroupClient() {
    super();
  }

  public V1APIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

@Override
public MixedOperation<Build, BuildList, Resource<Build>> builds() {
	return new BuildOperationsImpl(httpClient, getConfiguration());
}

@Override
public MixedOperation<CamelCatalog, CamelCatalogList, Resource<CamelCatalog>> camelCatalogs() {
	return new CamelCatalogOperationsImpl(httpClient, getConfiguration());
}

@Override
public MixedOperation<Integration, IntegrationList, Resource<Integration>> integrations() {
	return new IntegrationOperationsImpl(httpClient, getConfiguration());
}

@Override
public MixedOperation<IntegrationKit, IntegrationKitList, Resource<IntegrationKit>> integrationKits() {
	return new IntegrationKitOperationsImpl(httpClient, getConfiguration());
}

@Override
public MixedOperation<IntegrationPlatform, IntegrationPlatformList, Resource<IntegrationPlatform>> integrationPlatforms() {
  return new IntegrationPlatformOperationsImpl(httpClient, getConfiguration());
}

}
