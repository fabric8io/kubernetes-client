package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceListBuilder extends NamespaceListFluent<NamespaceListBuilder> implements VisitableBuilder<NamespaceList,NamespaceListBuilder>{

  NamespaceListFluent<?> fluent;

  public NamespaceListBuilder() {
    this(new NamespaceList());
  }
  
  public NamespaceListBuilder(NamespaceListFluent<?> fluent) {
    this(fluent, new NamespaceList());
  }
  
  public NamespaceListBuilder(NamespaceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceListBuilder(NamespaceListFluent<?> fluent,NamespaceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceList build() {
    NamespaceList buildable = new NamespaceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}