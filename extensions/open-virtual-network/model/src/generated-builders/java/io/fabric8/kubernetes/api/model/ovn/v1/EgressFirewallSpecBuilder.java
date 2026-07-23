package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressFirewallSpecBuilder extends EgressFirewallSpecFluent<EgressFirewallSpecBuilder> implements VisitableBuilder<EgressFirewallSpec,EgressFirewallSpecBuilder>{

  EgressFirewallSpecFluent<?> fluent;

  public EgressFirewallSpecBuilder() {
    this(new EgressFirewallSpec());
  }
  
  public EgressFirewallSpecBuilder(EgressFirewallSpecFluent<?> fluent) {
    this(fluent, new EgressFirewallSpec());
  }
  
  public EgressFirewallSpecBuilder(EgressFirewallSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressFirewallSpecBuilder(EgressFirewallSpecFluent<?> fluent,EgressFirewallSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressFirewallSpec build() {
    EgressFirewallSpec buildable = new EgressFirewallSpec(fluent.buildEgress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}