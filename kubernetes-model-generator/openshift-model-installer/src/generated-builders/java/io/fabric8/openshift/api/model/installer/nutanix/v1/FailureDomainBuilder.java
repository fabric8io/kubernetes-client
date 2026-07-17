package io.fabric8.openshift.api.model.installer.nutanix.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FailureDomainBuilder extends FailureDomainFluent<FailureDomainBuilder> implements VisitableBuilder<FailureDomain,FailureDomainBuilder>{

  FailureDomainFluent<?> fluent;

  public FailureDomainBuilder() {
    this(new FailureDomain());
  }
  
  public FailureDomainBuilder(FailureDomainFluent<?> fluent) {
    this(fluent, new FailureDomain());
  }
  
  public FailureDomainBuilder(FailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FailureDomainBuilder(FailureDomainFluent<?> fluent,FailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FailureDomain build() {
    FailureDomain buildable = new FailureDomain(fluent.buildDataSourceImages(), fluent.getName(), fluent.buildPrismElement(), fluent.buildStorageContainers(), fluent.getSubnetUUIDs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}