package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AllCompositeDisruptionModeBuilder extends AllCompositeDisruptionModeFluent<AllCompositeDisruptionModeBuilder> implements VisitableBuilder<AllCompositeDisruptionMode,AllCompositeDisruptionModeBuilder>{

  AllCompositeDisruptionModeFluent<?> fluent;

  public AllCompositeDisruptionModeBuilder() {
    this(new AllCompositeDisruptionMode());
  }
  
  public AllCompositeDisruptionModeBuilder(AllCompositeDisruptionModeFluent<?> fluent) {
    this(fluent, new AllCompositeDisruptionMode());
  }
  
  public AllCompositeDisruptionModeBuilder(AllCompositeDisruptionMode instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AllCompositeDisruptionModeBuilder(AllCompositeDisruptionModeFluent<?> fluent,AllCompositeDisruptionMode instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AllCompositeDisruptionMode build() {
    AllCompositeDisruptionMode buildable = new AllCompositeDisruptionMode();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}