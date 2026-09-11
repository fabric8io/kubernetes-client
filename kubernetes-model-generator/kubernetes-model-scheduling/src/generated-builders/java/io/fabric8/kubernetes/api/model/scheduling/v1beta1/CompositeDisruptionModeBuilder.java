package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CompositeDisruptionModeBuilder extends CompositeDisruptionModeFluent<CompositeDisruptionModeBuilder> implements VisitableBuilder<CompositeDisruptionMode,CompositeDisruptionModeBuilder>{

  CompositeDisruptionModeFluent<?> fluent;

  public CompositeDisruptionModeBuilder() {
    this(new CompositeDisruptionMode());
  }
  
  public CompositeDisruptionModeBuilder(CompositeDisruptionModeFluent<?> fluent) {
    this(fluent, new CompositeDisruptionMode());
  }
  
  public CompositeDisruptionModeBuilder(CompositeDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CompositeDisruptionModeBuilder(CompositeDisruptionModeFluent<?> fluent,CompositeDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CompositeDisruptionMode build() {
    CompositeDisruptionMode buildable = new CompositeDisruptionMode(fluent.buildAll(), fluent.buildSingle());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}