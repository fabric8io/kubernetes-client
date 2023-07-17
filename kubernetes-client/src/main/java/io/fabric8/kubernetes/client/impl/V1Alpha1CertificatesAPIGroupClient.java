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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundle;
import io.fabric8.kubernetes.api.model.certificates.v1alpha1.ClusterTrustBundleList;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.V1Alpha1CertificatesAPIGroupDSL;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1Alpha1CertificatesAPIGroupClient extends ClientAdapter<V1Alpha1CertificatesAPIGroupClient>
    implements V1Alpha1CertificatesAPIGroupDSL {
  @Override
  public NonNamespaceOperation<ClusterTrustBundle, ClusterTrustBundleList, Resource<ClusterTrustBundle>> clusterTrustBundles() {
    return resources(ClusterTrustBundle.class, ClusterTrustBundleList.class);
  }

  @Override
  public V1Alpha1CertificatesAPIGroupClient newInstance() {
    return new V1Alpha1CertificatesAPIGroupClient();
  }
}
