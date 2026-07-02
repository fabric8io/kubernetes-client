package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceSpecBuilder extends NamespaceSpecFluent<NamespaceSpecBuilder> implements VisitableBuilder<NamespaceSpec,NamespaceSpecBuilder>{

  NamespaceSpecFluent<?> fluent;

  public NamespaceSpecBuilder() {
    this(new NamespaceSpec());
  }
  
  public NamespaceSpecBuilder(NamespaceSpecFluent<?> fluent) {
    this(fluent, new NamespaceSpec());
  }
  
  public NamespaceSpecBuilder(NamespaceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceSpecBuilder(NamespaceSpecFluent<?> fluent,NamespaceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceSpec build() {
    NamespaceSpec buildable = new NamespaceSpec(fluent.getFinalizers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}