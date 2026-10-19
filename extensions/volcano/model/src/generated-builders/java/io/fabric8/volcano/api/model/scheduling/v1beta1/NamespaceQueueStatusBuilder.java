package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceQueueStatusBuilder extends NamespaceQueueStatusFluent<NamespaceQueueStatusBuilder> implements VisitableBuilder<NamespaceQueueStatus,NamespaceQueueStatusBuilder>{

  NamespaceQueueStatusFluent<?> fluent;

  public NamespaceQueueStatusBuilder() {
    this(new NamespaceQueueStatus());
  }
  
  public NamespaceQueueStatusBuilder(NamespaceQueueStatusFluent<?> fluent) {
    this(fluent, new NamespaceQueueStatus());
  }
  
  public NamespaceQueueStatusBuilder(NamespaceQueueStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceQueueStatusBuilder(NamespaceQueueStatusFluent<?> fluent,NamespaceQueueStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceQueueStatus build() {
    NamespaceQueueStatus buildable = new NamespaceQueueStatus(fluent.getAllocated(), fluent.getCompleted(), fluent.getConditions(), fluent.getInqueue(), fluent.getPending(), fluent.buildReservation(), fluent.getRunning(), fluent.getState(), fluent.getUnknown());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}