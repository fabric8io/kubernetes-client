package io.fabric8.openclustermanagement.api.model.cluster.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSpecBuilder extends ManagedClusterSpecFluent<ManagedClusterSpecBuilder> implements VisitableBuilder<ManagedClusterSpec,ManagedClusterSpecBuilder>{

  ManagedClusterSpecFluent<?> fluent;

  public ManagedClusterSpecBuilder() {
    this(new ManagedClusterSpec());
  }
  
  public ManagedClusterSpecBuilder(ManagedClusterSpecFluent<?> fluent) {
    this(fluent, new ManagedClusterSpec());
  }
  
  public ManagedClusterSpecBuilder(ManagedClusterSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSpecBuilder(ManagedClusterSpecFluent<?> fluent,ManagedClusterSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSpec build() {
    ManagedClusterSpec buildable = new ManagedClusterSpec(fluent.getHubAcceptsClient(), fluent.getLeaseDurationSeconds(), fluent.buildManagedClusterClientConfigs(), fluent.buildTaints());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}