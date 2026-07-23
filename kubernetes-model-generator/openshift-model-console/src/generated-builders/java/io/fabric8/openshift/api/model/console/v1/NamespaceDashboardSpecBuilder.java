package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NamespaceDashboardSpecBuilder extends NamespaceDashboardSpecFluent<NamespaceDashboardSpecBuilder> implements VisitableBuilder<NamespaceDashboardSpec,NamespaceDashboardSpecBuilder>{

  NamespaceDashboardSpecFluent<?> fluent;

  public NamespaceDashboardSpecBuilder() {
    this(new NamespaceDashboardSpec());
  }
  
  public NamespaceDashboardSpecBuilder(NamespaceDashboardSpecFluent<?> fluent) {
    this(fluent, new NamespaceDashboardSpec());
  }
  
  public NamespaceDashboardSpecBuilder(NamespaceDashboardSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NamespaceDashboardSpecBuilder(NamespaceDashboardSpecFluent<?> fluent,NamespaceDashboardSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NamespaceDashboardSpec build() {
    NamespaceDashboardSpec buildable = new NamespaceDashboardSpec(fluent.buildNamespaceSelector(), fluent.getNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}