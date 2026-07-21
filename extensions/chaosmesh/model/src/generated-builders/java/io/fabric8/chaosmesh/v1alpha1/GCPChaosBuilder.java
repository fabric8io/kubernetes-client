package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPChaosBuilder extends GCPChaosFluent<GCPChaosBuilder> implements VisitableBuilder<GCPChaos,GCPChaosBuilder>{

  GCPChaosFluent<?> fluent;

  public GCPChaosBuilder() {
    this(new GCPChaos());
  }
  
  public GCPChaosBuilder(GCPChaosFluent<?> fluent) {
    this(fluent, new GCPChaos());
  }
  
  public GCPChaosBuilder(GCPChaos instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPChaosBuilder(GCPChaosFluent<?> fluent,GCPChaos instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPChaos build() {
    GCPChaos buildable = new GCPChaos(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}