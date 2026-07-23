package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataClaimBuilder extends Metal3DataClaimFluent<Metal3DataClaimBuilder> implements VisitableBuilder<Metal3DataClaim,Metal3DataClaimBuilder>{

  Metal3DataClaimFluent<?> fluent;

  public Metal3DataClaimBuilder() {
    this(new Metal3DataClaim());
  }
  
  public Metal3DataClaimBuilder(Metal3DataClaimFluent<?> fluent) {
    this(fluent, new Metal3DataClaim());
  }
  
  public Metal3DataClaimBuilder(Metal3DataClaim instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataClaimBuilder(Metal3DataClaimFluent<?> fluent,Metal3DataClaim instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataClaim build() {
    Metal3DataClaim buildable = new Metal3DataClaim(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}