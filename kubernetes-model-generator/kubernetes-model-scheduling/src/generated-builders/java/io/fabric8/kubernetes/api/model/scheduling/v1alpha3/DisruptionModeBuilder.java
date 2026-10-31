package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DisruptionModeBuilder extends DisruptionModeFluent<DisruptionModeBuilder> implements VisitableBuilder<DisruptionMode,DisruptionModeBuilder>{

  DisruptionModeFluent<?> fluent;

  public DisruptionModeBuilder() {
    this(new DisruptionMode());
  }
  
  public DisruptionModeBuilder(DisruptionModeFluent<?> fluent) {
    this(fluent, new DisruptionMode());
  }
  
  public DisruptionModeBuilder(DisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DisruptionModeBuilder(DisruptionModeFluent<?> fluent,DisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DisruptionMode build() {
    DisruptionMode buildable = new DisruptionMode(fluent.buildAll(), fluent.buildSingle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}