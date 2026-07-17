package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureFailureDomainBuilder extends AzureFailureDomainFluent<AzureFailureDomainBuilder> implements VisitableBuilder<AzureFailureDomain,AzureFailureDomainBuilder>{

  AzureFailureDomainFluent<?> fluent;

  public AzureFailureDomainBuilder() {
    this(new AzureFailureDomain());
  }
  
  public AzureFailureDomainBuilder(AzureFailureDomainFluent<?> fluent) {
    this(fluent, new AzureFailureDomain());
  }
  
  public AzureFailureDomainBuilder(AzureFailureDomain instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureFailureDomainBuilder(AzureFailureDomainFluent<?> fluent,AzureFailureDomain instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureFailureDomain build() {
    AzureFailureDomain buildable = new AzureFailureDomain(fluent.getSubnet(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}