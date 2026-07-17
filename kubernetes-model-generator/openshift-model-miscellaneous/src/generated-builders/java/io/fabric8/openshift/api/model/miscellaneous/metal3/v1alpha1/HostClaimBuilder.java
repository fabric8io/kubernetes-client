package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostClaimBuilder extends HostClaimFluent<HostClaimBuilder> implements VisitableBuilder<HostClaim,HostClaimBuilder>{

  HostClaimFluent<?> fluent;

  public HostClaimBuilder() {
    this(new HostClaim());
  }
  
  public HostClaimBuilder(HostClaimFluent<?> fluent) {
    this(fluent, new HostClaim());
  }
  
  public HostClaimBuilder(HostClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostClaimBuilder(HostClaimFluent<?> fluent,HostClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostClaim build() {
    HostClaim buildable = new HostClaim(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}