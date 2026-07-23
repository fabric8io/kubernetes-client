package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCheckStatusBuilder extends StatusCheckStatusFluent<StatusCheckStatusBuilder> implements VisitableBuilder<StatusCheckStatus,StatusCheckStatusBuilder>{

  StatusCheckStatusFluent<?> fluent;

  public StatusCheckStatusBuilder() {
    this(new StatusCheckStatus());
  }
  
  public StatusCheckStatusBuilder(StatusCheckStatusFluent<?> fluent) {
    this(fluent, new StatusCheckStatus());
  }
  
  public StatusCheckStatusBuilder(StatusCheckStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCheckStatusBuilder(StatusCheckStatusFluent<?> fluent,StatusCheckStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCheckStatus build() {
    StatusCheckStatus buildable = new StatusCheckStatus(fluent.getCompletionTime(), fluent.buildConditions(), fluent.getCount(), fluent.buildRecords(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}