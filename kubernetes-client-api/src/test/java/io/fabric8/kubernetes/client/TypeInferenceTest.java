package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

class TypeInferenceTest {

  @Test
  void test() {
    final ConfigMapDependentResource cdr = new ConfigMapDependentResource();
    final DeploymentDependentResource ddr = new DeploymentDependentResource();
    Arrays.asList(cdr, ddr).forEach(dr -> dr.reconcile());
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
