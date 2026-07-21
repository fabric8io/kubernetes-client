package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ContainerNodeVolumePathSelectorBuilder extends ContainerNodeVolumePathSelectorFluent<ContainerNodeVolumePathSelectorBuilder> implements VisitableBuilder<ContainerNodeVolumePathSelector,ContainerNodeVolumePathSelectorBuilder>{

  ContainerNodeVolumePathSelectorFluent<?> fluent;

  public ContainerNodeVolumePathSelectorBuilder() {
    this(new ContainerNodeVolumePathSelector());
  }
  
  public ContainerNodeVolumePathSelectorBuilder(ContainerNodeVolumePathSelectorFluent<?> fluent) {
    this(fluent, new ContainerNodeVolumePathSelector());
  }
  
  public ContainerNodeVolumePathSelectorBuilder(ContainerNodeVolumePathSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ContainerNodeVolumePathSelectorBuilder(ContainerNodeVolumePathSelectorFluent<?> fluent,ContainerNodeVolumePathSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ContainerNodeVolumePathSelector build() {
    ContainerNodeVolumePathSelector buildable = new ContainerNodeVolumePathSelector(fluent.getContainerNames(), fluent.getMode(), fluent.buildSelector(), fluent.getValue(), fluent.getVolumeName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}