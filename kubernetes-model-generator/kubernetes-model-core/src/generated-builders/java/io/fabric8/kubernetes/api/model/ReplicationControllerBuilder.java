package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicationControllerBuilder extends ReplicationControllerFluent<ReplicationControllerBuilder> implements VisitableBuilder<ReplicationController,ReplicationControllerBuilder>{

  ReplicationControllerFluent<?> fluent;

  public ReplicationControllerBuilder() {
    this(new ReplicationController());
  }
  
  public ReplicationControllerBuilder(ReplicationControllerFluent<?> fluent) {
    this(fluent, new ReplicationController());
  }
  
  public ReplicationControllerBuilder(ReplicationController instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicationControllerBuilder(ReplicationControllerFluent<?> fluent,ReplicationController instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicationController build() {
    ReplicationController buildable = new ReplicationController(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}