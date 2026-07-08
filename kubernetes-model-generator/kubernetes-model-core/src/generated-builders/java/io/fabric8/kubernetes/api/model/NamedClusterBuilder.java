package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamedClusterBuilder extends NamedClusterFluent<NamedClusterBuilder> implements VisitableBuilder<NamedCluster,NamedClusterBuilder>{

  NamedClusterFluent<?> fluent;

  public NamedClusterBuilder() {
    this(new NamedCluster());
  }
  
  public NamedClusterBuilder(NamedClusterFluent<?> fluent) {
    this(fluent, new NamedCluster());
  }
  
  public NamedClusterBuilder(NamedCluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamedClusterBuilder(NamedClusterFluent<?> fluent,NamedCluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamedCluster build() {
    NamedCluster buildable = new NamedCluster(fluent.buildCluster(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}