package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClaimToHeaderBuilder extends ClaimToHeaderFluent<ClaimToHeaderBuilder> implements VisitableBuilder<ClaimToHeader,ClaimToHeaderBuilder>{

  ClaimToHeaderFluent<?> fluent;

  public ClaimToHeaderBuilder() {
    this(new ClaimToHeader());
  }
  
  public ClaimToHeaderBuilder(ClaimToHeaderFluent<?> fluent) {
    this(fluent, new ClaimToHeader());
  }
  
  public ClaimToHeaderBuilder(ClaimToHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClaimToHeaderBuilder(ClaimToHeaderFluent<?> fluent,ClaimToHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClaimToHeader build() {
    ClaimToHeader buildable = new ClaimToHeader(fluent.getClaim(), fluent.getHeader());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}