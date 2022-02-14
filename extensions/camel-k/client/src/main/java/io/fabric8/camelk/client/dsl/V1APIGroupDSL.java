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
package io.fabric8.camelk.client.dsl;

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
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public interface V1APIGroupDSL extends Client {

  /**
   * API entrypoint for Build(camel.apache.org/v1)
   *
   * @return MixedOperation for Build class
   */
  MixedOperation<Build, BuildList, Resource<Build>> builds();

  /**
   * API entrypoint for CamelCatalog(camel.apache.org/v1)
   *
   * @return MixedOperation for CamelCatalog class
   */
  MixedOperation<CamelCatalog, CamelCatalogList, Resource<CamelCatalog>> camelCatalogs();

    /**
     * API entrypoint for Integration(camel.apache.org/v1)
     *
     * @return MixedOperation for Integration class
     */
    MixedOperation<Integration, IntegrationList, Resource<Integration>> integrations();

    /**
     * API entrypoint for IntegrationKit(camel.apache.org/v1)
     *
     * @return MixedOperation for IntegrationKit class
     */
    MixedOperation<IntegrationKit, IntegrationKitList, Resource<IntegrationKit>> integrationKits();

  /**
   * API entrypoint for IntegrationPlatform(camel.apache.org/v1)
   *
   * @return MixedOperation for IntegrationPlatform class
   */
  MixedOperation<IntegrationPlatform, IntegrationPlatformList, Resource<IntegrationPlatform>> integrationPlatforms();
}

