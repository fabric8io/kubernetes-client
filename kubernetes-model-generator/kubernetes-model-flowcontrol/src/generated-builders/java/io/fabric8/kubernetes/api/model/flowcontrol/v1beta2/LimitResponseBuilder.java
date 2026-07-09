package io.fabric8.kubernetes.api.model.flowcontrol.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LimitResponseBuilder extends LimitResponseFluent<LimitResponseBuilder> implements VisitableBuilder<LimitResponse,LimitResponseBuilder>{

  LimitResponseFluent<?> fluent;

  public LimitResponseBuilder() {
    this(new LimitResponse());
  }
  
  public LimitResponseBuilder(LimitResponseFluent<?> fluent) {
    this(fluent, new LimitResponse());
  }
  
  public LimitResponseBuilder(LimitResponse instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LimitResponseBuilder(LimitResponseFluent<?> fluent,LimitResponse instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LimitResponse build() {
    LimitResponse buildable = new LimitResponse(fluent.buildQueuing(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}