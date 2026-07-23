package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UsernameClaimMappingBuilder extends UsernameClaimMappingFluent<UsernameClaimMappingBuilder> implements VisitableBuilder<UsernameClaimMapping,UsernameClaimMappingBuilder>{

  UsernameClaimMappingFluent<?> fluent;

  public UsernameClaimMappingBuilder() {
    this(new UsernameClaimMapping());
  }
  
  public UsernameClaimMappingBuilder(UsernameClaimMappingFluent<?> fluent) {
    this(fluent, new UsernameClaimMapping());
  }
  
  public UsernameClaimMappingBuilder(UsernameClaimMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UsernameClaimMappingBuilder(UsernameClaimMappingFluent<?> fluent,UsernameClaimMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UsernameClaimMapping build() {
    UsernameClaimMapping buildable = new UsernameClaimMapping(fluent.getClaim(), fluent.buildPrefix(), fluent.getPrefixPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}