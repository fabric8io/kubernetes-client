package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusErrorBuilder extends StatusErrorFluent<StatusErrorBuilder> implements VisitableBuilder<StatusError,StatusErrorBuilder>{

  StatusErrorFluent<?> fluent;

  public StatusErrorBuilder() {
    this(new StatusError());
  }
  
  public StatusErrorBuilder(StatusErrorFluent<?> fluent) {
    this(fluent, new StatusError());
  }
  
  public StatusErrorBuilder(StatusError instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusErrorBuilder(StatusErrorFluent<?> fluent,StatusError instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusError build() {
    StatusError buildable = new StatusError();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}