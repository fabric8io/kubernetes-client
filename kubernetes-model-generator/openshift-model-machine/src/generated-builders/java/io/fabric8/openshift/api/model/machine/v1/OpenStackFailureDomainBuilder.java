package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenStackFailureDomainBuilder extends OpenStackFailureDomainFluent<OpenStackFailureDomainBuilder> implements VisitableBuilder<OpenStackFailureDomain,OpenStackFailureDomainBuilder>{

  OpenStackFailureDomainFluent<?> fluent;

  public OpenStackFailureDomainBuilder() {
    this(new OpenStackFailureDomain());
  }
  
  public OpenStackFailureDomainBuilder(OpenStackFailureDomainFluent<?> fluent) {
    this(fluent, new OpenStackFailureDomain());
  }
  
  public OpenStackFailureDomainBuilder(OpenStackFailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenStackFailureDomainBuilder(OpenStackFailureDomainFluent<?> fluent,OpenStackFailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenStackFailureDomain build() {
    OpenStackFailureDomain buildable = new OpenStackFailureDomain(fluent.getAvailabilityZone(), fluent.buildRootVolume());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}