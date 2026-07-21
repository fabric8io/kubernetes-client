package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QueueStatusBuilder extends QueueStatusFluent<QueueStatusBuilder> implements VisitableBuilder<QueueStatus,QueueStatusBuilder>{

  QueueStatusFluent<?> fluent;

  public QueueStatusBuilder() {
    this(new QueueStatus());
  }
  
  public QueueStatusBuilder(QueueStatusFluent<?> fluent) {
    this(fluent, new QueueStatus());
  }
  
  public QueueStatusBuilder(QueueStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QueueStatusBuilder(QueueStatusFluent<?> fluent,QueueStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QueueStatus build() {
    QueueStatus buildable = new QueueStatus(fluent.getAllocated(), fluent.getCompleted(), fluent.getInqueue(), fluent.getPending(), fluent.buildReservation(), fluent.getRunning(), fluent.getState(), fluent.getUnknown());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}