package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SingleCompositeDisruptionModeBuilder extends SingleCompositeDisruptionModeFluent<SingleCompositeDisruptionModeBuilder> implements VisitableBuilder<SingleCompositeDisruptionMode,SingleCompositeDisruptionModeBuilder>{

  SingleCompositeDisruptionModeFluent<?> fluent;

  public SingleCompositeDisruptionModeBuilder() {
    this(new SingleCompositeDisruptionMode());
  }
  
  public SingleCompositeDisruptionModeBuilder(SingleCompositeDisruptionModeFluent<?> fluent) {
    this(fluent, new SingleCompositeDisruptionMode());
  }
  
  public SingleCompositeDisruptionModeBuilder(SingleCompositeDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SingleCompositeDisruptionModeBuilder(SingleCompositeDisruptionModeFluent<?> fluent,SingleCompositeDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SingleCompositeDisruptionMode build() {
    SingleCompositeDisruptionMode buildable = new SingleCompositeDisruptionMode();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}