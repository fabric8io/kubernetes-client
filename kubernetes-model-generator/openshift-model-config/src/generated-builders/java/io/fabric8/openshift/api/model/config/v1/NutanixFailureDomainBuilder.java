package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixFailureDomainBuilder extends NutanixFailureDomainFluent<NutanixFailureDomainBuilder> implements VisitableBuilder<NutanixFailureDomain,NutanixFailureDomainBuilder>{

  NutanixFailureDomainFluent<?> fluent;

  public NutanixFailureDomainBuilder() {
    this(new NutanixFailureDomain());
  }
  
  public NutanixFailureDomainBuilder(NutanixFailureDomainFluent<?> fluent) {
    this(fluent, new NutanixFailureDomain());
  }
  
  public NutanixFailureDomainBuilder(NutanixFailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixFailureDomainBuilder(NutanixFailureDomainFluent<?> fluent,NutanixFailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixFailureDomain build() {
    NutanixFailureDomain buildable = new NutanixFailureDomain(fluent.buildCluster(), fluent.getName(), fluent.buildSubnets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}