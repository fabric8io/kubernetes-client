package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QueueSpecBuilder extends QueueSpecFluent<QueueSpecBuilder> implements VisitableBuilder<QueueSpec,QueueSpecBuilder>{

  QueueSpecFluent<?> fluent;

  public QueueSpecBuilder() {
    this(new QueueSpec());
  }
  
  public QueueSpecBuilder(QueueSpecFluent<?> fluent) {
    this(fluent, new QueueSpec());
  }
  
  public QueueSpecBuilder(QueueSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QueueSpecBuilder(QueueSpecFluent<?> fluent,QueueSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QueueSpec build() {
    QueueSpec buildable = new QueueSpec(fluent.buildAffinity(), fluent.getCapability(), fluent.getDeserved(), fluent.buildExtendClusters(), fluent.buildGuarantee(), fluent.getParent(), fluent.getPriority(), fluent.getReclaimable(), fluent.getType(), fluent.getWeight());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}