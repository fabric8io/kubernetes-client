package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SingleDisruptionModeBuilder extends SingleDisruptionModeFluent<SingleDisruptionModeBuilder> implements VisitableBuilder<SingleDisruptionMode,SingleDisruptionModeBuilder>{

  SingleDisruptionModeFluent<?> fluent;

  public SingleDisruptionModeBuilder() {
    this(new SingleDisruptionMode());
  }
  
  public SingleDisruptionModeBuilder(SingleDisruptionModeFluent<?> fluent) {
    this(fluent, new SingleDisruptionMode());
  }
  
  public SingleDisruptionModeBuilder(SingleDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SingleDisruptionModeBuilder(SingleDisruptionModeFluent<?> fluent,SingleDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SingleDisruptionMode build() {
    SingleDisruptionMode buildable = new SingleDisruptionMode();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}