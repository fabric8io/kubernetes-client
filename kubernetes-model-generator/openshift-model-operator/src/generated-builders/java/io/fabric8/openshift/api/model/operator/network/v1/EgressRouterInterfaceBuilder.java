package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressRouterInterfaceBuilder extends EgressRouterInterfaceFluent<EgressRouterInterfaceBuilder> implements VisitableBuilder<EgressRouterInterface,EgressRouterInterfaceBuilder>{

  EgressRouterInterfaceFluent<?> fluent;

  public EgressRouterInterfaceBuilder() {
    this(new EgressRouterInterface());
  }
  
  public EgressRouterInterfaceBuilder(EgressRouterInterfaceFluent<?> fluent) {
    this(fluent, new EgressRouterInterface());
  }
  
  public EgressRouterInterfaceBuilder(EgressRouterInterface instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressRouterInterfaceBuilder(EgressRouterInterfaceFluent<?> fluent,EgressRouterInterface instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressRouterInterface build() {
    EgressRouterInterface buildable = new EgressRouterInterface(fluent.buildMacvlan());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}