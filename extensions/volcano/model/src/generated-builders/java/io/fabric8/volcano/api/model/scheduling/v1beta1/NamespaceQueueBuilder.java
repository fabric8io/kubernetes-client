package io.fabric8.volcano.api.model.scheduling.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceQueueBuilder extends NamespaceQueueFluent<NamespaceQueueBuilder> implements VisitableBuilder<NamespaceQueue,NamespaceQueueBuilder>{

  NamespaceQueueFluent<?> fluent;

  public NamespaceQueueBuilder() {
    this(new NamespaceQueue());
  }
  
  public NamespaceQueueBuilder(NamespaceQueueFluent<?> fluent) {
    this(fluent, new NamespaceQueue());
  }
  
  public NamespaceQueueBuilder(NamespaceQueue instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceQueueBuilder(NamespaceQueueFluent<?> fluent,NamespaceQueue instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceQueue build() {
    NamespaceQueue buildable = new NamespaceQueue(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}