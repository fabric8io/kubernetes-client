package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceBuilder extends NamespaceFluent<NamespaceBuilder> implements VisitableBuilder<Namespace,NamespaceBuilder>{

  NamespaceFluent<?> fluent;

  public NamespaceBuilder() {
    this(new Namespace());
  }
  
  public NamespaceBuilder(NamespaceFluent<?> fluent) {
    this(fluent, new Namespace());
  }
  
  public NamespaceBuilder(Namespace instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceBuilder(NamespaceFluent<?> fluent,Namespace instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Namespace build() {
    Namespace buildable = new Namespace(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}