package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplicationControllerSpecBuilder extends ReplicationControllerSpecFluent<ReplicationControllerSpecBuilder> implements VisitableBuilder<ReplicationControllerSpec,ReplicationControllerSpecBuilder>{

  ReplicationControllerSpecFluent<?> fluent;

  public ReplicationControllerSpecBuilder() {
    this(new ReplicationControllerSpec());
  }
  
  public ReplicationControllerSpecBuilder(ReplicationControllerSpecFluent<?> fluent) {
    this(fluent, new ReplicationControllerSpec());
  }
  
  public ReplicationControllerSpecBuilder(ReplicationControllerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplicationControllerSpecBuilder(ReplicationControllerSpecFluent<?> fluent,ReplicationControllerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplicationControllerSpec build() {
    ReplicationControllerSpec buildable = new ReplicationControllerSpec(fluent.getMinReadySeconds(), fluent.getReplicas(), fluent.getSelector(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}