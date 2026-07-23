package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPChaosSpecBuilder extends GCPChaosSpecFluent<GCPChaosSpecBuilder> implements VisitableBuilder<GCPChaosSpec,GCPChaosSpecBuilder>{

  GCPChaosSpecFluent<?> fluent;

  public GCPChaosSpecBuilder() {
    this(new GCPChaosSpec());
  }
  
  public GCPChaosSpecBuilder(GCPChaosSpecFluent<?> fluent) {
    this(fluent, new GCPChaosSpec());
  }
  
  public GCPChaosSpecBuilder(GCPChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPChaosSpecBuilder(GCPChaosSpecFluent<?> fluent,GCPChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPChaosSpec build() {
    GCPChaosSpec buildable = new GCPChaosSpec(fluent.getAction(), fluent.getDeviceNames(), fluent.getDuration(), fluent.getInstance(), fluent.getProject(), fluent.getRemoteCluster(), fluent.getSecretName(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}