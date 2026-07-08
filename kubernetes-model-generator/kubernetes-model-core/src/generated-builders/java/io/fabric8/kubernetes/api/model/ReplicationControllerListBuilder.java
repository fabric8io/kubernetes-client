package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicationControllerListBuilder extends ReplicationControllerListFluent<ReplicationControllerListBuilder> implements VisitableBuilder<ReplicationControllerList,ReplicationControllerListBuilder>{

  ReplicationControllerListFluent<?> fluent;

  public ReplicationControllerListBuilder() {
    this(new ReplicationControllerList());
  }
  
  public ReplicationControllerListBuilder(ReplicationControllerListFluent<?> fluent) {
    this(fluent, new ReplicationControllerList());
  }
  
  public ReplicationControllerListBuilder(ReplicationControllerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicationControllerListBuilder(ReplicationControllerListFluent<?> fluent,ReplicationControllerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicationControllerList build() {
    ReplicationControllerList buildable = new ReplicationControllerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}