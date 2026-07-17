package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UserIdentityMappingBuilder extends UserIdentityMappingFluent<UserIdentityMappingBuilder> implements VisitableBuilder<UserIdentityMapping,UserIdentityMappingBuilder>{

  UserIdentityMappingFluent<?> fluent;

  public UserIdentityMappingBuilder() {
    this(new UserIdentityMapping());
  }
  
  public UserIdentityMappingBuilder(UserIdentityMappingFluent<?> fluent) {
    this(fluent, new UserIdentityMapping());
  }
  
  public UserIdentityMappingBuilder(UserIdentityMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UserIdentityMappingBuilder(UserIdentityMappingFluent<?> fluent,UserIdentityMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UserIdentityMapping build() {
    UserIdentityMapping buildable = new UserIdentityMapping(fluent.getApiVersion(), fluent.buildIdentity(), fluent.getKind(), fluent.buildMetadata(), fluent.buildUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}