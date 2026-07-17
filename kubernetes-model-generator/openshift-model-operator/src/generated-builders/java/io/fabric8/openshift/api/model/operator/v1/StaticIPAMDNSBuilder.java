package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticIPAMDNSBuilder extends StaticIPAMDNSFluent<StaticIPAMDNSBuilder> implements VisitableBuilder<StaticIPAMDNS,StaticIPAMDNSBuilder>{

  StaticIPAMDNSFluent<?> fluent;

  public StaticIPAMDNSBuilder() {
    this(new StaticIPAMDNS());
  }
  
  public StaticIPAMDNSBuilder(StaticIPAMDNSFluent<?> fluent) {
    this(fluent, new StaticIPAMDNS());
  }
  
  public StaticIPAMDNSBuilder(StaticIPAMDNS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticIPAMDNSBuilder(StaticIPAMDNSFluent<?> fluent,StaticIPAMDNS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticIPAMDNS build() {
    StaticIPAMDNS buildable = new StaticIPAMDNS(fluent.getDomain(), fluent.getNameservers(), fluent.getSearch());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}