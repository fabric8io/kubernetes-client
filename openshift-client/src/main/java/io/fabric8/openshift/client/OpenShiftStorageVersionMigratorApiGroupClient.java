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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageState;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageStateList;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigration;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigrationList;
import io.fabric8.openshift.client.dsl.OpenShiftStorageVersionMigratorApiGroupDSL;
import io.fabric8.openshift.client.dsl.internal.core.StorageStateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.StorageVersionMigrationOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftStorageVersionMigratorApiGroupClient extends BaseClient implements OpenShiftStorageVersionMigratorApiGroupDSL {
  public OpenShiftStorageVersionMigratorApiGroupClient() {
    super();
  }

  public OpenShiftStorageVersionMigratorApiGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<StorageState, StorageStateList, Resource<StorageState>> storageStates() {
    return new StorageStateOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<StorageVersionMigration, StorageVersionMigrationList, Resource<StorageVersionMigration>> storageVersionMigrations() {
    return new StorageVersionMigrationOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
