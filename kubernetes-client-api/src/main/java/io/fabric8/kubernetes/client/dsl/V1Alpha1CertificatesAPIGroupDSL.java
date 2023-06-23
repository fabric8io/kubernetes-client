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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundle;
import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundleList;
import io.fabric8.kubernetes.client.Client;

public interface V1Alpha1CertificatesAPIGroupDSL extends Client {
  /**
   * API entrypoint for certificates.k8s.io/v1alpha1 ClusterTrustBundle
   * <br>
   * ClusterTrustBundle is a cluster-scoped container for X.509 trust anchors
   * (root certificates).
   * <br>
   * ClusterTrustBundle objects are considered to be readable by any authenticated
   * user in the cluster, because they can be mounted by pods using the
   * `clusterTrustBundle` projection. All service accounts have read access to
   * ClusterTrustBundles by default. Users who only have namespace-level access
   * to a cluster can read ClusterTrustBundles by impersonating a serviceaccount
   * that they have access to.
   * <br>
   * It can be optionally associated with a particular assigner, in which case it
   * contains one valid set of trust anchors for that signer. Signers may have
   * multiple associated ClusterTrustBundles; each is an independent set of trust
   * anchors for that signer. Admission control is used to enforce that only users
   * with permissions on the signer can create or modify the corresponding bundle.
   *
   * @return {@link NonNamespaceOperation} for ClusterTrustBundle
   */
  NonNamespaceOperation<ClusterTrustBundle, ClusterTrustBundleList, Resource<ClusterTrustBundle>> clusterTrustBundles();
}
