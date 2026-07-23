package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrefixedClaimMappingBuilder extends PrefixedClaimMappingFluent<PrefixedClaimMappingBuilder> implements VisitableBuilder<PrefixedClaimMapping,PrefixedClaimMappingBuilder>{

  PrefixedClaimMappingFluent<?> fluent;

  public PrefixedClaimMappingBuilder() {
    this(new PrefixedClaimMapping());
  }
  
  public PrefixedClaimMappingBuilder(PrefixedClaimMappingFluent<?> fluent) {
    this(fluent, new PrefixedClaimMapping());
  }
  
  public PrefixedClaimMappingBuilder(PrefixedClaimMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrefixedClaimMappingBuilder(PrefixedClaimMappingFluent<?> fluent,PrefixedClaimMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrefixedClaimMapping build() {
    PrefixedClaimMapping buildable = new PrefixedClaimMapping(fluent.getClaim(), fluent.getPrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}