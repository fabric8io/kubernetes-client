package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressRouterListBuilder extends EgressRouterListFluent<EgressRouterListBuilder> implements VisitableBuilder<EgressRouterList,EgressRouterListBuilder>{

  EgressRouterListFluent<?> fluent;

  public EgressRouterListBuilder() {
    this(new EgressRouterList());
  }
  
  public EgressRouterListBuilder(EgressRouterListFluent<?> fluent) {
    this(fluent, new EgressRouterList());
  }
  
  public EgressRouterListBuilder(EgressRouterList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressRouterListBuilder(EgressRouterListFluent<?> fluent,EgressRouterList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressRouterList build() {
    EgressRouterList buildable = new EgressRouterList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}