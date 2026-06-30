package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCauseBuilder extends StatusCauseFluent<StatusCauseBuilder> implements VisitableBuilder<StatusCause,StatusCauseBuilder>{

  StatusCauseFluent<?> fluent;

  public StatusCauseBuilder() {
    this(new StatusCause());
  }
  
  public StatusCauseBuilder(StatusCauseFluent<?> fluent) {
    this(fluent, new StatusCause());
  }
  
  public StatusCauseBuilder(StatusCause instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCauseBuilder(StatusCauseFluent<?> fluent,StatusCause instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCause build() {
    StatusCause buildable = new StatusCause(fluent.getField(), fluent.getMessage(), fluent.getReason());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}