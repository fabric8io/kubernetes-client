package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DaemonSetConditionBuilder extends DaemonSetConditionFluent<DaemonSetConditionBuilder> implements VisitableBuilder<DaemonSetCondition,DaemonSetConditionBuilder>{

  DaemonSetConditionFluent<?> fluent;

  public DaemonSetConditionBuilder() {
    this(new DaemonSetCondition());
  }
  
  public DaemonSetConditionBuilder(DaemonSetConditionFluent<?> fluent) {
    this(fluent, new DaemonSetCondition());
  }
  
  public DaemonSetConditionBuilder(DaemonSetCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DaemonSetConditionBuilder(DaemonSetConditionFluent<?> fluent,DaemonSetCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DaemonSetCondition build() {
    DaemonSetCondition buildable = new DaemonSetCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}