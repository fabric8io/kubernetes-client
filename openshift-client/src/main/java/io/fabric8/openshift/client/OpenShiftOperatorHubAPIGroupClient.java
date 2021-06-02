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
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifest;
import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifestList;
import io.fabric8.openshift.api.model.operatorhub.v1.Operator;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorCondition;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorConditionList;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorGroup;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorGroupList;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSource;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSourceList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersion;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersionList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallPlan;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallPlanList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.Subscription;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.SubscriptionList;
import io.fabric8.openshift.client.dsl.OpenShiftOperatorHubAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.operators.coreos.CatalogSourceOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operators.coreos.ClusterServiceVersionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operators.coreos.InstallPlanOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operators.coreos.OperatorConditionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operators.coreos.OperatorGroupOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operators.coreos.OperatorOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.operators.coreos.SubscriptionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.packages.operators.coreos.PackageManifestOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftOperatorHubAPIGroupClient extends BaseClient implements OpenShiftOperatorHubAPIGroupDSL {
  public OpenShiftOperatorHubAPIGroupClient() {
    super();
  }

  public OpenShiftOperatorHubAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<CatalogSource, CatalogSourceList, Resource<CatalogSource>> catalogSources() {
    return new CatalogSourceOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<OperatorGroup, OperatorGroupList, Resource<OperatorGroup>> operatorGroups() {
    return new OperatorGroupOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions() {
    return new SubscriptionOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<InstallPlan, InstallPlanList, Resource<InstallPlan>> installPlans() {
    return new InstallPlanOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<ClusterServiceVersion, ClusterServiceVersionList, Resource<ClusterServiceVersion>> clusterServiceVersions() {
    return new ClusterServiceVersionOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<PackageManifest, PackageManifestList, Resource<PackageManifest>> packageManifests() {
    return new PackageManifestOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<OperatorCondition, OperatorConditionList, Resource<OperatorCondition>> operatorConditions() {
    return new OperatorConditionOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Operator, OperatorList, Resource<Operator>> operators() {
    return new OperatorOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
