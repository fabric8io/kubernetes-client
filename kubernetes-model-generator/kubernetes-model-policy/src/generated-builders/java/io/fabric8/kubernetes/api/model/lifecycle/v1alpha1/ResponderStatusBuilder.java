package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResponderStatusBuilder extends ResponderStatusFluent<ResponderStatusBuilder> implements VisitableBuilder<ResponderStatus,ResponderStatusBuilder>{

  ResponderStatusFluent<?> fluent;

  public ResponderStatusBuilder() {
    this(new ResponderStatus());
  }
  
  public ResponderStatusBuilder(ResponderStatusFluent<?> fluent) {
    this(fluent, new ResponderStatus());
  }
  
  public ResponderStatusBuilder(ResponderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResponderStatusBuilder(ResponderStatusFluent<?> fluent,ResponderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResponderStatus build() {
    ResponderStatus buildable = new ResponderStatus(fluent.getCompletionTime(), fluent.getExpectedCompletionTime(), fluent.getHeartbeatTime(), fluent.getMessage(), fluent.getName(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}