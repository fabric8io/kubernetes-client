package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSPlatformSpecBuilder extends DNSPlatformSpecFluent<DNSPlatformSpecBuilder> implements VisitableBuilder<DNSPlatformSpec,DNSPlatformSpecBuilder>{

  DNSPlatformSpecFluent<?> fluent;

  public DNSPlatformSpecBuilder() {
    this(new DNSPlatformSpec());
  }
  
  public DNSPlatformSpecBuilder(DNSPlatformSpecFluent<?> fluent) {
    this(fluent, new DNSPlatformSpec());
  }
  
  public DNSPlatformSpecBuilder(DNSPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSPlatformSpecBuilder(DNSPlatformSpecFluent<?> fluent,DNSPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSPlatformSpec build() {
    DNSPlatformSpec buildable = new DNSPlatformSpec(fluent.buildAws(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}