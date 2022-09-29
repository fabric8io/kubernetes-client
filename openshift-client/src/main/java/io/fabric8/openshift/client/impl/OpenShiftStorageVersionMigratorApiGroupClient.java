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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageState;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageStateList;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigration;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigrationList;
import io.fabric8.openshift.client.dsl.OpenShiftStorageVersionMigratorApiGroupDSL;

public class OpenShiftStorageVersionMigratorApiGroupClient extends ClientAdapter<OpenShiftStorageVersionMigratorApiGroupClient>
    implements OpenShiftStorageVersionMigratorApiGroupDSL {

  @Override
  public NonNamespaceOperation<StorageState, StorageStateList, Resource<StorageState>> storageStates() {
    return resources(StorageState.class, StorageStateList.class);
  }

  @Override
  public NonNamespaceOperation<StorageVersionMigration, StorageVersionMigrationList, Resource<StorageVersionMigration>> storageVersionMigrations() {
    return resources(StorageVersionMigration.class, StorageVersionMigrationList.class);
  }

  @Override
  public OpenShiftStorageVersionMigratorApiGroupClient newInstance() {
    return new OpenShiftStorageVersionMigratorApiGroupClient();
  }
}
