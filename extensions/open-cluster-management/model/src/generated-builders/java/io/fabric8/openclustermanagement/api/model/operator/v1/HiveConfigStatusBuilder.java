package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HiveConfigStatusBuilder extends HiveConfigStatusFluent<HiveConfigStatusBuilder> implements VisitableBuilder<HiveConfigStatus,HiveConfigStatusBuilder>{

  HiveConfigStatusFluent<?> fluent;

  public HiveConfigStatusBuilder() {
    this(new HiveConfigStatus());
  }
  
  public HiveConfigStatusBuilder(HiveConfigStatusFluent<?> fluent) {
    this(fluent, new HiveConfigStatus());
  }
  
  public HiveConfigStatusBuilder(HiveConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HiveConfigStatusBuilder(HiveConfigStatusFluent<?> fluent,HiveConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HiveConfigStatus build() {
    HiveConfigStatus buildable = new HiveConfigStatus(fluent.getAggregatorClientCAHash());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}