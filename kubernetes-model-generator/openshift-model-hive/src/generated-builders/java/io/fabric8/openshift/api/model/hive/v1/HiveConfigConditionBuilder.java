package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HiveConfigConditionBuilder extends HiveConfigConditionFluent<HiveConfigConditionBuilder> implements VisitableBuilder<HiveConfigCondition,HiveConfigConditionBuilder>{

  HiveConfigConditionFluent<?> fluent;

  public HiveConfigConditionBuilder() {
    this(new HiveConfigCondition());
  }
  
  public HiveConfigConditionBuilder(HiveConfigConditionFluent<?> fluent) {
    this(fluent, new HiveConfigCondition());
  }
  
  public HiveConfigConditionBuilder(HiveConfigCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HiveConfigConditionBuilder(HiveConfigConditionFluent<?> fluent,HiveConfigCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HiveConfigCondition build() {
    HiveConfigCondition buildable = new HiveConfigCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}