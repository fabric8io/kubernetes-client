package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPChaosListBuilder extends GCPChaosListFluent<GCPChaosListBuilder> implements VisitableBuilder<GCPChaosList,GCPChaosListBuilder>{

  GCPChaosListFluent<?> fluent;

  public GCPChaosListBuilder() {
    this(new GCPChaosList());
  }
  
  public GCPChaosListBuilder(GCPChaosListFluent<?> fluent) {
    this(fluent, new GCPChaosList());
  }
  
  public GCPChaosListBuilder(GCPChaosList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPChaosListBuilder(GCPChaosListFluent<?> fluent,GCPChaosList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPChaosList build() {
    GCPChaosList buildable = new GCPChaosList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}