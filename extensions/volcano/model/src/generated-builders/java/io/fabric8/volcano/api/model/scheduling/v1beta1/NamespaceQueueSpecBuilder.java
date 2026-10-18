package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceQueueSpecBuilder extends NamespaceQueueSpecFluent<NamespaceQueueSpecBuilder> implements VisitableBuilder<NamespaceQueueSpec,NamespaceQueueSpecBuilder>{

  NamespaceQueueSpecFluent<?> fluent;

  public NamespaceQueueSpecBuilder() {
    this(new NamespaceQueueSpec());
  }
  
  public NamespaceQueueSpecBuilder(NamespaceQueueSpecFluent<?> fluent) {
    this(fluent, new NamespaceQueueSpec());
  }
  
  public NamespaceQueueSpecBuilder(NamespaceQueueSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceQueueSpecBuilder(NamespaceQueueSpecFluent<?> fluent,NamespaceQueueSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceQueueSpec build() {
    NamespaceQueueSpec buildable = new NamespaceQueueSpec(fluent.getCapability(), fluent.getDequeueStrategy(), fluent.getDeserved(), fluent.buildGuarantee(), fluent.getParent(), fluent.getPriority(), fluent.getReclaimable());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}