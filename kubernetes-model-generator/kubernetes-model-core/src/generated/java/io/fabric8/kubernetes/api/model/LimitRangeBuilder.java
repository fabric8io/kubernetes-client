package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LimitRangeBuilder extends LimitRangeFluent<LimitRangeBuilder> implements VisitableBuilder<LimitRange,LimitRangeBuilder>{

  LimitRangeFluent<?> fluent;

  public LimitRangeBuilder() {
    this(new LimitRange());
  }
  
  public LimitRangeBuilder(LimitRangeFluent<?> fluent) {
    this(fluent, new LimitRange());
  }
  
  public LimitRangeBuilder(LimitRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LimitRangeBuilder(LimitRangeFluent<?> fluent,LimitRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LimitRange build() {
    LimitRange buildable = new LimitRange(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}