package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceDiscoveryBuilder extends NamespaceDiscoveryFluent<NamespaceDiscoveryBuilder> implements VisitableBuilder<NamespaceDiscovery,NamespaceDiscoveryBuilder>{

  NamespaceDiscoveryFluent<?> fluent;

  public NamespaceDiscoveryBuilder() {
    this(new NamespaceDiscovery());
  }
  
  public NamespaceDiscoveryBuilder(NamespaceDiscoveryFluent<?> fluent) {
    this(fluent, new NamespaceDiscovery());
  }
  
  public NamespaceDiscoveryBuilder(NamespaceDiscovery instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceDiscoveryBuilder(NamespaceDiscoveryFluent<?> fluent,NamespaceDiscovery instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceDiscovery build() {
    NamespaceDiscovery buildable = new NamespaceDiscovery(fluent.getNames(), fluent.getOwnNamespace());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}