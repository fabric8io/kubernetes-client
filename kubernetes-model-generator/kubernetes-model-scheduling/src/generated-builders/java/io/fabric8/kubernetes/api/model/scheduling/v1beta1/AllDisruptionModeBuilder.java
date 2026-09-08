package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllDisruptionModeBuilder extends AllDisruptionModeFluent<AllDisruptionModeBuilder> implements VisitableBuilder<AllDisruptionMode,AllDisruptionModeBuilder>{

  AllDisruptionModeFluent<?> fluent;

  public AllDisruptionModeBuilder() {
    this(new AllDisruptionMode());
  }
  
  public AllDisruptionModeBuilder(AllDisruptionModeFluent<?> fluent) {
    this(fluent, new AllDisruptionMode());
  }
  
  public AllDisruptionModeBuilder(AllDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllDisruptionModeBuilder(AllDisruptionModeFluent<?> fluent,AllDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllDisruptionMode build() {
    AllDisruptionMode buildable = new AllDisruptionMode();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}