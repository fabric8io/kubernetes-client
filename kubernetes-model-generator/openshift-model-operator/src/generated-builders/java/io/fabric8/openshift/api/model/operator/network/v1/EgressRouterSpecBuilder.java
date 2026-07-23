package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressRouterSpecBuilder extends EgressRouterSpecFluent<EgressRouterSpecBuilder> implements VisitableBuilder<EgressRouterSpec,EgressRouterSpecBuilder>{

  EgressRouterSpecFluent<?> fluent;

  public EgressRouterSpecBuilder() {
    this(new EgressRouterSpec());
  }
  
  public EgressRouterSpecBuilder(EgressRouterSpecFluent<?> fluent) {
    this(fluent, new EgressRouterSpec());
  }
  
  public EgressRouterSpecBuilder(EgressRouterSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressRouterSpecBuilder(EgressRouterSpecFluent<?> fluent,EgressRouterSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressRouterSpec build() {
    EgressRouterSpec buildable = new EgressRouterSpec(fluent.buildAddresses(), fluent.getMode(), fluent.buildNetworkInterface(), fluent.buildRedirect());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}