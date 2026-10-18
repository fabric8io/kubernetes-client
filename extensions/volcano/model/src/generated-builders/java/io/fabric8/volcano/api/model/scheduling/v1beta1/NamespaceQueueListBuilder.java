package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceQueueListBuilder extends NamespaceQueueListFluent<NamespaceQueueListBuilder> implements VisitableBuilder<NamespaceQueueList,NamespaceQueueListBuilder>{

  NamespaceQueueListFluent<?> fluent;

  public NamespaceQueueListBuilder() {
    this(new NamespaceQueueList());
  }
  
  public NamespaceQueueListBuilder(NamespaceQueueListFluent<?> fluent) {
    this(fluent, new NamespaceQueueList());
  }
  
  public NamespaceQueueListBuilder(NamespaceQueueList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceQueueListBuilder(NamespaceQueueListFluent<?> fluent,NamespaceQueueList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceQueueList build() {
    NamespaceQueueList buildable = new NamespaceQueueList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}