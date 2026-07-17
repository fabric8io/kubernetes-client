package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodDNSConfigOptionBuilder extends PodDNSConfigOptionFluent<PodDNSConfigOptionBuilder> implements VisitableBuilder<PodDNSConfigOption,PodDNSConfigOptionBuilder>{

  PodDNSConfigOptionFluent<?> fluent;

  public PodDNSConfigOptionBuilder() {
    this(new PodDNSConfigOption());
  }
  
  public PodDNSConfigOptionBuilder(PodDNSConfigOptionFluent<?> fluent) {
    this(fluent, new PodDNSConfigOption());
  }
  
  public PodDNSConfigOptionBuilder(PodDNSConfigOption instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodDNSConfigOptionBuilder(PodDNSConfigOptionFluent<?> fluent,PodDNSConfigOption instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodDNSConfigOption build() {
    PodDNSConfigOption buildable = new PodDNSConfigOption(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}