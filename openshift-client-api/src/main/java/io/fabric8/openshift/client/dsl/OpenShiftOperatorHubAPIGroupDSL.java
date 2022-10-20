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
package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.Client;
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

public interface OpenShiftOperatorHubAPIGroupDSL extends Client {
  /**
   * API entrypoint for CatalogSource related operations(operators.coreos.com/v1alpha1)
   *
   * @return MixedOperation object for CatalogSource type
   */
  MixedOperation<CatalogSource, CatalogSourceList, Resource<CatalogSource>> catalogSources();

  /**
   * API entrypoint for OperatorGroup related operations(operators.coreos.com/v1)
   *
   * @return MixedOperation object for OperatorGroup type
   */
  MixedOperation<OperatorGroup, OperatorGroupList, Resource<OperatorGroup>> operatorGroups();

  /**
   * API entrypoint for Subscription related operations(operators.coreos.com/v1alpha1)
   *
   * @return MixedOperation object for Subscription type
   */
  MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions();

  /**
   * API entrypoint for InstallPlan related operations(operators.coreos.com/v1alpha1)
   *
   * @return MixedOperation object for InstallPlan type
   */
  MixedOperation<InstallPlan, InstallPlanList, Resource<InstallPlan>> installPlans();

  /**
   * API entrypoint for CatalogSource related ClusterServiceVersion(operators.coreos.com/v1alpha1)
   *
   * @return MixedOperation object for ClusterServiceVersion type
   */
  MixedOperation<ClusterServiceVersion, ClusterServiceVersionList, Resource<ClusterServiceVersion>> clusterServiceVersions();

  /**
   * API entrypoint for PackageManifest (packages.operators.coreos.com/v1)
   *
   * @return MixedOperation for PackageManifest
   */
  MixedOperation<PackageManifest, PackageManifestList, Resource<PackageManifest>> packageManifests();

  /**
   * API entrypoint for OperatorCondition (operators.coreos.com/v1)
   *
   * @return MixedOperation for OperatorCondition
   */
  MixedOperation<OperatorCondition, OperatorConditionList, Resource<OperatorCondition>> operatorConditions();

  /**
   * API entrypoint for Operator (operators.coreos.com/v1)
   *
   * @return NonNamespaceOperation for Operator
   */
  NonNamespaceOperation<Operator, OperatorList, Resource<Operator>> operators();
}
