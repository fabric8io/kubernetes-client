package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FailureDomainsBuilder extends FailureDomainsFluent<FailureDomainsBuilder> implements VisitableBuilder<FailureDomains,FailureDomainsBuilder>{

  FailureDomainsFluent<?> fluent;

  public FailureDomainsBuilder() {
    this(new FailureDomains());
  }
  
  public FailureDomainsBuilder(FailureDomainsFluent<?> fluent) {
    this(fluent, new FailureDomains());
  }
  
  public FailureDomainsBuilder(FailureDomains instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FailureDomainsBuilder(FailureDomainsFluent<?> fluent,FailureDomains instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FailureDomains build() {
    FailureDomains buildable = new FailureDomains(fluent.buildAws(), fluent.buildAzure(), fluent.buildGcp(), fluent.buildNutanix(), fluent.buildOpenstack(), fluent.getPlatform(), fluent.buildVsphere());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}