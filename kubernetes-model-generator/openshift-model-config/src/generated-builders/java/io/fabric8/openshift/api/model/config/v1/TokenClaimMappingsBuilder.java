package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TokenClaimMappingsBuilder extends TokenClaimMappingsFluent<TokenClaimMappingsBuilder> implements VisitableBuilder<TokenClaimMappings,TokenClaimMappingsBuilder>{

  TokenClaimMappingsFluent<?> fluent;

  public TokenClaimMappingsBuilder() {
    this(new TokenClaimMappings());
  }
  
  public TokenClaimMappingsBuilder(TokenClaimMappingsFluent<?> fluent) {
    this(fluent, new TokenClaimMappings());
  }
  
  public TokenClaimMappingsBuilder(TokenClaimMappings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TokenClaimMappingsBuilder(TokenClaimMappingsFluent<?> fluent,TokenClaimMappings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TokenClaimMappings build() {
    TokenClaimMappings buildable = new TokenClaimMappings(fluent.buildExtra(), fluent.buildGroups(), fluent.buildUid(), fluent.buildUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}