package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3DataClaimSpecBuilder extends Metal3DataClaimSpecFluent<Metal3DataClaimSpecBuilder> implements VisitableBuilder<Metal3DataClaimSpec,Metal3DataClaimSpecBuilder>{

  Metal3DataClaimSpecFluent<?> fluent;

  public Metal3DataClaimSpecBuilder() {
    this(new Metal3DataClaimSpec());
  }
  
  public Metal3DataClaimSpecBuilder(Metal3DataClaimSpecFluent<?> fluent) {
    this(fluent, new Metal3DataClaimSpec());
  }
  
  public Metal3DataClaimSpecBuilder(Metal3DataClaimSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3DataClaimSpecBuilder(Metal3DataClaimSpecFluent<?> fluent,Metal3DataClaimSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3DataClaimSpec build() {
    Metal3DataClaimSpec buildable = new Metal3DataClaimSpec(fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}