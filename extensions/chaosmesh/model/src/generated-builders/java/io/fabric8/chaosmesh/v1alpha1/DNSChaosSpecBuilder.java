package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSChaosSpecBuilder extends DNSChaosSpecFluent<DNSChaosSpecBuilder> implements VisitableBuilder<DNSChaosSpec,DNSChaosSpecBuilder>{

  DNSChaosSpecFluent<?> fluent;

  public DNSChaosSpecBuilder() {
    this(new DNSChaosSpec());
  }
  
  public DNSChaosSpecBuilder(DNSChaosSpecFluent<?> fluent) {
    this(fluent, new DNSChaosSpec());
  }
  
  public DNSChaosSpecBuilder(DNSChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSChaosSpecBuilder(DNSChaosSpecFluent<?> fluent,DNSChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSChaosSpec build() {
    DNSChaosSpec buildable = new DNSChaosSpec(fluent.getAction(), fluent.getContainerNames(), fluent.getDuration(), fluent.getMode(), fluent.getPatterns(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}