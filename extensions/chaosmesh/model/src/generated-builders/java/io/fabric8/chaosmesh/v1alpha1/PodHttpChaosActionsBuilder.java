package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodHttpChaosActionsBuilder extends PodHttpChaosActionsFluent<PodHttpChaosActionsBuilder> implements VisitableBuilder<PodHttpChaosActions,PodHttpChaosActionsBuilder>{

  PodHttpChaosActionsFluent<?> fluent;

  public PodHttpChaosActionsBuilder() {
    this(new PodHttpChaosActions());
  }
  
  public PodHttpChaosActionsBuilder(PodHttpChaosActionsFluent<?> fluent) {
    this(fluent, new PodHttpChaosActions());
  }
  
  public PodHttpChaosActionsBuilder(PodHttpChaosActions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodHttpChaosActionsBuilder(PodHttpChaosActionsFluent<?> fluent,PodHttpChaosActions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodHttpChaosActions build() {
    PodHttpChaosActions buildable = new PodHttpChaosActions(fluent.getAbort(), fluent.getDelay(), fluent.buildPatch(), fluent.buildReplace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}