package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistrySourcesBuilder extends RegistrySourcesFluent<RegistrySourcesBuilder> implements VisitableBuilder<RegistrySources,RegistrySourcesBuilder>{

  RegistrySourcesFluent<?> fluent;

  public RegistrySourcesBuilder() {
    this(new RegistrySources());
  }
  
  public RegistrySourcesBuilder(RegistrySourcesFluent<?> fluent) {
    this(fluent, new RegistrySources());
  }
  
  public RegistrySourcesBuilder(RegistrySources instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistrySourcesBuilder(RegistrySourcesFluent<?> fluent,RegistrySources instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistrySources build() {
    RegistrySources buildable = new RegistrySources(fluent.getAllowedRegistries(), fluent.getBlockedRegistries(), fluent.getContainerRuntimeSearchRegistries(), fluent.getInsecureRegistries());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}