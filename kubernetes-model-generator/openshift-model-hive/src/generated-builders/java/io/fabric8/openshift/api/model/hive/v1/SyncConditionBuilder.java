package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SyncConditionBuilder extends SyncConditionFluent<SyncConditionBuilder> implements VisitableBuilder<SyncCondition,SyncConditionBuilder>{

  SyncConditionFluent<?> fluent;

  public SyncConditionBuilder() {
    this(new SyncCondition());
  }
  
  public SyncConditionBuilder(SyncConditionFluent<?> fluent) {
    this(fluent, new SyncCondition());
  }
  
  public SyncConditionBuilder(SyncCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SyncConditionBuilder(SyncConditionFluent<?> fluent,SyncCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SyncCondition build() {
    SyncCondition buildable = new SyncCondition(fluent.getLastProbeTime(), fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}