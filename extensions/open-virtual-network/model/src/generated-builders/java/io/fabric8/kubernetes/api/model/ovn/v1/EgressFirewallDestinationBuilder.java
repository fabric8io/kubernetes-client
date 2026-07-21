package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressFirewallDestinationBuilder extends EgressFirewallDestinationFluent<EgressFirewallDestinationBuilder> implements VisitableBuilder<EgressFirewallDestination,EgressFirewallDestinationBuilder>{

  EgressFirewallDestinationFluent<?> fluent;

  public EgressFirewallDestinationBuilder() {
    this(new EgressFirewallDestination());
  }
  
  public EgressFirewallDestinationBuilder(EgressFirewallDestinationFluent<?> fluent) {
    this(fluent, new EgressFirewallDestination());
  }
  
  public EgressFirewallDestinationBuilder(EgressFirewallDestination instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressFirewallDestinationBuilder(EgressFirewallDestinationFluent<?> fluent,EgressFirewallDestination instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressFirewallDestination build() {
    EgressFirewallDestination buildable = new EgressFirewallDestination(fluent.getCidrSelector(), fluent.getDnsName(), fluent.buildNodeSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}