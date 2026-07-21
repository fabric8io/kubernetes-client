package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericStartupBoostBuilder extends GenericStartupBoostFluent<GenericStartupBoostBuilder> implements VisitableBuilder<GenericStartupBoost,GenericStartupBoostBuilder>{

  GenericStartupBoostFluent<?> fluent;

  public GenericStartupBoostBuilder() {
    this(new GenericStartupBoost());
  }
  
  public GenericStartupBoostBuilder(GenericStartupBoostFluent<?> fluent) {
    this(fluent, new GenericStartupBoost());
  }
  
  public GenericStartupBoostBuilder(GenericStartupBoost instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericStartupBoostBuilder(GenericStartupBoostFluent<?> fluent,GenericStartupBoost instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericStartupBoost build() {
    GenericStartupBoost buildable = new GenericStartupBoost(fluent.getDurationSeconds(), fluent.getFactor(), fluent.getQuantity(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}