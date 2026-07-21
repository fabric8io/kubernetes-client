package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSChaosStatusBuilder extends DNSChaosStatusFluent<DNSChaosStatusBuilder> implements VisitableBuilder<DNSChaosStatus,DNSChaosStatusBuilder>{

  DNSChaosStatusFluent<?> fluent;

  public DNSChaosStatusBuilder() {
    this(new DNSChaosStatus());
  }
  
  public DNSChaosStatusBuilder(DNSChaosStatusFluent<?> fluent) {
    this(fluent, new DNSChaosStatus());
  }
  
  public DNSChaosStatusBuilder(DNSChaosStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSChaosStatusBuilder(DNSChaosStatusFluent<?> fluent,DNSChaosStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSChaosStatus build() {
    DNSChaosStatus buildable = new DNSChaosStatus(fluent.buildConditions(), fluent.buildExperiment());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}