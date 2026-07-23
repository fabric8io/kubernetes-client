package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReplySpecBuilder extends ReplySpecFluent<ReplySpecBuilder> implements VisitableBuilder<ReplySpec,ReplySpecBuilder>{

  ReplySpecFluent<?> fluent;

  public ReplySpecBuilder() {
    this(new ReplySpec());
  }
  
  public ReplySpecBuilder(ReplySpecFluent<?> fluent) {
    this(fluent, new ReplySpec());
  }
  
  public ReplySpecBuilder(ReplySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReplySpecBuilder(ReplySpecFluent<?> fluent,ReplySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReplySpec build() {
    ReplySpec buildable = new ReplySpec(fluent.getDiscard(), fluent.buildJsonata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}