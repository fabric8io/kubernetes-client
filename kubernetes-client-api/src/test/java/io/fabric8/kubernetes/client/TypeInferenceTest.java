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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

class TypeInferenceTest {

  // Commented-out due to compilation failure
  // TODO: Enable after #5522 is fixed
  //  @Test
  //  void typeInferenceWithLambda() {
  //    final ConfigMapDependentResource cdr = new ConfigMapDependentResource();
  //    final DeploymentDependentResource ddr = new DeploymentDependentResource();
  //    Arrays.asList(cdr, ddr).forEach(dr -> dr.reconcile());
  //    Assertions.assertTrue(true);
  //  }

  @Test
  void typeInferenceWithMethodReference() {
    final ConfigMapDependentResource cdr = new ConfigMapDependentResource();
    final DeploymentDependentResource ddr = new DeploymentDependentResource();
    Arrays.asList(cdr, ddr).forEach(KubernetesDependentResource::reconcile);
    Assertions.assertTrue(true);
  }

  static abstract class KubernetesDependentResource<R extends HasMetadata, P extends HasMetadata>
      implements DependentResourceConfigurator<KubernetesDependentConfig<R>> {
    void reconcile() {
      // NOOP
    }

    @Override
    public void configureWith(KubernetesDependentConfig<R> config) {

    }

    @Override
    public Optional<KubernetesDependentConfig<R>> configuration() {
      return Optional.empty();
    }
  }

  static class KubernetesDependentConfig<R extends HasMetadata> {

  }

  interface DependentResourceConfigurator<C> {
    void configureWith(C config);

    Optional<C> configuration();
  }

  static final class ConfigMapDependentResource extends KubernetesDependentResource<ConfigMap, Service> {

  }

  static final class DeploymentDependentResource extends KubernetesDependentResource<Deployment, Service> {

  }

}
