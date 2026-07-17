package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressRouterAddressBuilder extends EgressRouterAddressFluent<EgressRouterAddressBuilder> implements VisitableBuilder<EgressRouterAddress,EgressRouterAddressBuilder>{

  EgressRouterAddressFluent<?> fluent;

  public EgressRouterAddressBuilder() {
    this(new EgressRouterAddress());
  }
  
  public EgressRouterAddressBuilder(EgressRouterAddressFluent<?> fluent) {
    this(fluent, new EgressRouterAddress());
  }
  
  public EgressRouterAddressBuilder(EgressRouterAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressRouterAddressBuilder(EgressRouterAddressFluent<?> fluent,EgressRouterAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressRouterAddress build() {
    EgressRouterAddress buildable = new EgressRouterAddress(fluent.getGateway(), fluent.getIp());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}