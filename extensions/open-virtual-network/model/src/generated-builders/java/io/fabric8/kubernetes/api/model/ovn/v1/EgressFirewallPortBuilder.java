package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressFirewallPortBuilder extends EgressFirewallPortFluent<EgressFirewallPortBuilder> implements VisitableBuilder<EgressFirewallPort,EgressFirewallPortBuilder>{

  EgressFirewallPortFluent<?> fluent;

  public EgressFirewallPortBuilder() {
    this(new EgressFirewallPort());
  }
  
  public EgressFirewallPortBuilder(EgressFirewallPortFluent<?> fluent) {
    this(fluent, new EgressFirewallPort());
  }
  
  public EgressFirewallPortBuilder(EgressFirewallPort instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressFirewallPortBuilder(EgressFirewallPortFluent<?> fluent,EgressFirewallPort instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressFirewallPort build() {
    EgressFirewallPort buildable = new EgressFirewallPort(fluent.getPort(), fluent.getProtocol());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}