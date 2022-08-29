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
package io.fabric8.chaosmesh.client;

import io.fabric8.chaosmesh.v1alpha1.AWSChaos;
import io.fabric8.chaosmesh.v1alpha1.AWSChaosList;
import io.fabric8.chaosmesh.v1alpha1.DNSChaos;
import io.fabric8.chaosmesh.v1alpha1.DNSChaosList;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaos;
import io.fabric8.chaosmesh.v1alpha1.HTTPChaosList;
import io.fabric8.chaosmesh.v1alpha1.IOChaos;
import io.fabric8.chaosmesh.v1alpha1.IOChaosList;
import io.fabric8.chaosmesh.v1alpha1.JVMChaos;
import io.fabric8.chaosmesh.v1alpha1.JVMChaosList;
import io.fabric8.chaosmesh.v1alpha1.KernelChaos;
import io.fabric8.chaosmesh.v1alpha1.KernelChaosList;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.NetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodChaos;
import io.fabric8.chaosmesh.v1alpha1.PodChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaos;
import io.fabric8.chaosmesh.v1alpha1.PodIOChaosList;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaos;
import io.fabric8.chaosmesh.v1alpha1.PodNetworkChaosList;
import io.fabric8.chaosmesh.v1alpha1.StressChaos;
import io.fabric8.chaosmesh.v1alpha1.StressChaosList;
import io.fabric8.chaosmesh.v1alpha1.TimeChaos;
import io.fabric8.chaosmesh.v1alpha1.TimeChaosList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

/**
 * Main interface for Chaos Mesh Client.
 */
public interface ChaosMeshClient extends Client {

  // Serving
  /**
   * API entrypoint for IOChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for IOChaos class
   */
  MixedOperation<IOChaos, IOChaosList, Resource<IOChaos>> ioChaos();

  /**
   * API entrypoint for KernelChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for KernelChaos class
   */
  MixedOperation<KernelChaos, KernelChaosList, Resource<KernelChaos>> kernelChaos();

  /**
   * API entrypoint for NetworkChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for NetworkChaos class
   */
  MixedOperation<NetworkChaos, NetworkChaosList, Resource<NetworkChaos>> networkChaos();

  /**
   * API entrypoint for PodChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for PodChaos class
   */
  MixedOperation<PodChaos, PodChaosList, Resource<PodChaos>> podChaos();

  /**
   * API entrypoint for PodIOChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for PodIOChaos class
   */
  MixedOperation<PodIOChaos, PodIOChaosList, Resource<PodIOChaos>> podIOChaos();

  /**
   * API entrypoint for PodNetworkChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for PodNetworkChaos class
   */
  MixedOperation<PodNetworkChaos, PodNetworkChaosList, Resource<PodNetworkChaos>> podNetworkChaos();

  /**
   * API entrypoint for StressChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for StressChaos class
   */
  MixedOperation<StressChaos, StressChaosList, Resource<StressChaos>> stressChaos();

  /**
   * API entrypoint for IOChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for IOChaos class
   */
  MixedOperation<TimeChaos, TimeChaosList, Resource<TimeChaos>> timeChaos();

  /**
   * API entrypoint for JVMChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for JVMChaos class
   */
  MixedOperation<JVMChaos, JVMChaosList, Resource<JVMChaos>> jvmChaos();

  /**
   * API entrypoint for HTTPChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for HTTPChaos class
   */
  MixedOperation<HTTPChaos, HTTPChaosList, Resource<HTTPChaos>> httpChaos();

  /**
   * API entrypoint for DNSChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for DNSChaos class
   */
  MixedOperation<DNSChaos, DNSChaosList, Resource<DNSChaos>> dnsChaos();

  /**
   * API entrypoint for AWSChaos(chaos-mesh.org/v1alpha1)
   *
   * @return MixedOperation for AWSChaos class
   */
  MixedOperation<AWSChaos, AWSChaosList, Resource<AWSChaos>> awsChaos();
}
