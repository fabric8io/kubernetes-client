package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LDAPAttributeMappingBuilder extends LDAPAttributeMappingFluent<LDAPAttributeMappingBuilder> implements VisitableBuilder<LDAPAttributeMapping,LDAPAttributeMappingBuilder>{

  LDAPAttributeMappingFluent<?> fluent;

  public LDAPAttributeMappingBuilder() {
    this(new LDAPAttributeMapping());
  }
  
  public LDAPAttributeMappingBuilder(LDAPAttributeMappingFluent<?> fluent) {
    this(fluent, new LDAPAttributeMapping());
  }
  
  public LDAPAttributeMappingBuilder(LDAPAttributeMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LDAPAttributeMappingBuilder(LDAPAttributeMappingFluent<?> fluent,LDAPAttributeMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LDAPAttributeMapping build() {
    LDAPAttributeMapping buildable = new LDAPAttributeMapping(fluent.getEmail(), fluent.getId(), fluent.getName(), fluent.getPreferredUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}