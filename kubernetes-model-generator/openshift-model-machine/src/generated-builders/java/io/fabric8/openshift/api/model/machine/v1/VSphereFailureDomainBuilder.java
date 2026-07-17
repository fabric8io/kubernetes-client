package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereFailureDomainBuilder extends VSphereFailureDomainFluent<VSphereFailureDomainBuilder> implements VisitableBuilder<VSphereFailureDomain,VSphereFailureDomainBuilder>{

  VSphereFailureDomainFluent<?> fluent;

  public VSphereFailureDomainBuilder() {
    this(new VSphereFailureDomain());
  }
  
  public VSphereFailureDomainBuilder(VSphereFailureDomainFluent<?> fluent) {
    this(fluent, new VSphereFailureDomain());
  }
  
  public VSphereFailureDomainBuilder(VSphereFailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereFailureDomainBuilder(VSphereFailureDomainFluent<?> fluent,VSphereFailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereFailureDomain build() {
    VSphereFailureDomain buildable = new VSphereFailureDomain(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}