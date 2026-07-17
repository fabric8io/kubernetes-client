package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressRouterBuilder extends EgressRouterFluent<EgressRouterBuilder> implements VisitableBuilder<EgressRouter,EgressRouterBuilder>{

  EgressRouterFluent<?> fluent;

  public EgressRouterBuilder() {
    this(new EgressRouter());
  }
  
  public EgressRouterBuilder(EgressRouterFluent<?> fluent) {
    this(fluent, new EgressRouter());
  }
  
  public EgressRouterBuilder(EgressRouter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressRouterBuilder(EgressRouterFluent<?> fluent,EgressRouter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressRouter build() {
    EgressRouter buildable = new EgressRouter(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}