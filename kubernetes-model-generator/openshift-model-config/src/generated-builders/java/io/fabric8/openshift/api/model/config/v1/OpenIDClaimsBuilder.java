package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OpenIDClaimsBuilder extends OpenIDClaimsFluent<OpenIDClaimsBuilder> implements VisitableBuilder<OpenIDClaims,OpenIDClaimsBuilder>{

  OpenIDClaimsFluent<?> fluent;

  public OpenIDClaimsBuilder() {
    this(new OpenIDClaims());
  }
  
  public OpenIDClaimsBuilder(OpenIDClaimsFluent<?> fluent) {
    this(fluent, new OpenIDClaims());
  }
  
  public OpenIDClaimsBuilder(OpenIDClaims instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OpenIDClaimsBuilder(OpenIDClaimsFluent<?> fluent,OpenIDClaims instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenIDClaims build() {
    OpenIDClaims buildable = new OpenIDClaims(fluent.getEmail(), fluent.getGroups(), fluent.getName(), fluent.getPreferredUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}