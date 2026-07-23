package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LimitRangeSpecBuilder extends LimitRangeSpecFluent<LimitRangeSpecBuilder> implements VisitableBuilder<LimitRangeSpec,LimitRangeSpecBuilder>{

  LimitRangeSpecFluent<?> fluent;

  public LimitRangeSpecBuilder() {
    this(new LimitRangeSpec());
  }
  
  public LimitRangeSpecBuilder(LimitRangeSpecFluent<?> fluent) {
    this(fluent, new LimitRangeSpec());
  }
  
  public LimitRangeSpecBuilder(LimitRangeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LimitRangeSpecBuilder(LimitRangeSpecFluent<?> fluent,LimitRangeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LimitRangeSpec build() {
    LimitRangeSpec buildable = new LimitRangeSpec(fluent.buildLimits());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}