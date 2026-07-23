package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostClaimSpecBuilder extends HostClaimSpecFluent<HostClaimSpecBuilder> implements VisitableBuilder<HostClaimSpec,HostClaimSpecBuilder>{

  HostClaimSpecFluent<?> fluent;

  public HostClaimSpecBuilder() {
    this(new HostClaimSpec());
  }
  
  public HostClaimSpecBuilder(HostClaimSpecFluent<?> fluent) {
    this(fluent, new HostClaimSpec());
  }
  
  public HostClaimSpecBuilder(HostClaimSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostClaimSpecBuilder(HostClaimSpecFluent<?> fluent,HostClaimSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostClaimSpec build() {
    HostClaimSpec buildable = new HostClaimSpec(fluent.buildConsumerRef(), fluent.buildCustomDeploy(), fluent.getFailureDomain(), fluent.buildHostSelector(), fluent.buildImage(), fluent.getMetaData(), fluent.getNetworkData(), fluent.getPoweredOn(), fluent.getUserData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}