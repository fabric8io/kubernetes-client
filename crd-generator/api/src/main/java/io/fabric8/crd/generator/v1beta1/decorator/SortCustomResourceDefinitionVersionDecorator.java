package io.fabric8.crd.generator.v1beta1.decorator;

import io.fabric8.crd.generator.decorator.Decorator;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpecFluent;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.client.utils.KubernetesVersionPriority;

public class SortCustomResourceDefinitionVersionDecorator
    extends CustomResourceDefinitionDecorator<CustomResourceDefinitionSpecFluent<?>> {
  public SortCustomResourceDefinitionVersionDecorator(String name) {
    super(name);
  }

  @Override
  public void andThenVisit(CustomResourceDefinitionSpecFluent<?> spec, ObjectMeta resourceMeta) {
    spec.withVersions(KubernetesVersionPriority.sortByPriority(spec.buildVersions(), CustomResourceDefinitionVersion::getName));
  }

  @Override
  public Class<? extends Decorator>[] after() {
    return new Class[] { EnsureSingleStorageVersionDecorator.class };
  }

  @Override
  public String toString() {
    return getClass().getName() + " [name:" + getName() + "]";
  }

}
