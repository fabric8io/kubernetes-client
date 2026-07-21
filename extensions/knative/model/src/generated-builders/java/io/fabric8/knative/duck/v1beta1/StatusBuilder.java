package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusBuilder extends StatusFluent<StatusBuilder> implements VisitableBuilder<Status,StatusBuilder>{

  StatusFluent<?> fluent;

  public StatusBuilder() {
    this(new Status());
  }
  
  public StatusBuilder(StatusFluent<?> fluent) {
    this(fluent, new Status());
  }
  
  public StatusBuilder(Status instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusBuilder(StatusFluent<?> fluent,Status instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Status build() {
    Status buildable = new Status(fluent.getAnnotations(), fluent.buildConditions(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}