package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QueueListBuilder extends QueueListFluent<QueueListBuilder> implements VisitableBuilder<QueueList,QueueListBuilder>{

  QueueListFluent<?> fluent;

  public QueueListBuilder() {
    this(new QueueList());
  }
  
  public QueueListBuilder(QueueListFluent<?> fluent) {
    this(fluent, new QueueList());
  }
  
  public QueueListBuilder(QueueList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QueueListBuilder(QueueListFluent<?> fluent,QueueList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QueueList build() {
    QueueList buildable = new QueueList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}