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
package io.fabric8.openclustermanagement.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomization;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchCustomizationList;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperator;
import io.fabric8.openclustermanagement.api.model.searchoperator.v1alpha1.SearchOperatorList;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementSearchAPIGroupDSL;

public class OpenClusterManagementSearchAPIGroupClient extends BaseClient implements OpenClusterManagementSearchAPIGroupDSL {

  public OpenClusterManagementSearchAPIGroupClient() {
    super();
  }

  public OpenClusterManagementSearchAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public MixedOperation<SearchCustomization, SearchCustomizationList, Resource<SearchCustomization>> searchCustomizations() {
    return Handlers.getOperation(SearchCustomization.class, SearchCustomizationList.class, this);
  }

  @Override
  public MixedOperation<SearchOperator, SearchOperatorList, Resource<SearchOperator>> searchOperators() {
    return Handlers.getOperation(SearchOperator.class, SearchOperatorList.class, this);
  }
}
