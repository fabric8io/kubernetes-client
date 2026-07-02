package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceStatusBuilder extends NamespaceStatusFluent<NamespaceStatusBuilder> implements VisitableBuilder<NamespaceStatus,NamespaceStatusBuilder>{

  NamespaceStatusFluent<?> fluent;

  public NamespaceStatusBuilder() {
    this(new NamespaceStatus());
  }
  
  public NamespaceStatusBuilder(NamespaceStatusFluent<?> fluent) {
    this(fluent, new NamespaceStatus());
  }
  
  public NamespaceStatusBuilder(NamespaceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceStatusBuilder(NamespaceStatusFluent<?> fluent,NamespaceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceStatus build() {
    NamespaceStatus buildable = new NamespaceStatus(fluent.buildConditions(), fluent.getPhase());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}