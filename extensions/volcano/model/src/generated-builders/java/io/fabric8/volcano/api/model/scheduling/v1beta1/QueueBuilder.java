package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QueueBuilder extends QueueFluent<QueueBuilder> implements VisitableBuilder<Queue,QueueBuilder>{

  QueueFluent<?> fluent;

  public QueueBuilder() {
    this(new Queue());
  }
  
  public QueueBuilder(QueueFluent<?> fluent) {
    this(fluent, new Queue());
  }
  
  public QueueBuilder(Queue instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QueueBuilder(QueueFluent<?> fluent,Queue instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Queue build() {
    Queue buildable = new Queue(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}