package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceSelectorBuilder extends NamespaceSelectorFluent<NamespaceSelectorBuilder> implements VisitableBuilder<NamespaceSelector,NamespaceSelectorBuilder>{

  NamespaceSelectorFluent<?> fluent;

  public NamespaceSelectorBuilder() {
    this(new NamespaceSelector());
  }
  
  public NamespaceSelectorBuilder(NamespaceSelectorFluent<?> fluent) {
    this(fluent, new NamespaceSelector());
  }
  
  public NamespaceSelectorBuilder(NamespaceSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceSelectorBuilder(NamespaceSelectorFluent<?> fluent,NamespaceSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceSelector build() {
    NamespaceSelector buildable = new NamespaceSelector(fluent.getMatchNames());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}