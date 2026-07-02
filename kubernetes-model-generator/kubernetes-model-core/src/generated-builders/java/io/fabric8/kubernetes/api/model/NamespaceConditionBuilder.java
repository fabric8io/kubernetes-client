package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceConditionBuilder extends NamespaceConditionFluent<NamespaceConditionBuilder> implements VisitableBuilder<NamespaceCondition,NamespaceConditionBuilder>{

  NamespaceConditionFluent<?> fluent;

  public NamespaceConditionBuilder() {
    this(new NamespaceCondition());
  }
  
  public NamespaceConditionBuilder(NamespaceConditionFluent<?> fluent) {
    this(fluent, new NamespaceCondition());
  }
  
  public NamespaceConditionBuilder(NamespaceCondition instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceConditionBuilder(NamespaceConditionFluent<?> fluent,NamespaceCondition instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceCondition build() {
    NamespaceCondition buildable = new NamespaceCondition(fluent.getLastTransitionTime(), fluent.getMessage(), fluent.getReason(), fluent.getStatus(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}