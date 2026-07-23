package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DNSSpecBuilder extends DNSSpecFluent<DNSSpecBuilder> implements VisitableBuilder<DNSSpec,DNSSpecBuilder>{

  DNSSpecFluent<?> fluent;

  public DNSSpecBuilder() {
    this(new DNSSpec());
  }
  
  public DNSSpecBuilder(DNSSpecFluent<?> fluent) {
    this(fluent, new DNSSpec());
  }
  
  public DNSSpecBuilder(DNSSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DNSSpecBuilder(DNSSpecFluent<?> fluent,DNSSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DNSSpec build() {
    DNSSpec buildable = new DNSSpec(fluent.buildCache(), fluent.getLogLevel(), fluent.getManagementState(), fluent.buildNodePlacement(), fluent.getOperatorLogLevel(), fluent.buildServers(), fluent.buildUpstreamResolvers());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}