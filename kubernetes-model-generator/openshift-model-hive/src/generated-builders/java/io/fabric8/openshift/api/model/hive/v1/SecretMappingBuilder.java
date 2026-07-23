package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretMappingBuilder extends SecretMappingFluent<SecretMappingBuilder> implements VisitableBuilder<SecretMapping,SecretMappingBuilder>{

  SecretMappingFluent<?> fluent;

  public SecretMappingBuilder() {
    this(new SecretMapping());
  }
  
  public SecretMappingBuilder(SecretMappingFluent<?> fluent) {
    this(fluent, new SecretMapping());
  }
  
  public SecretMappingBuilder(SecretMapping instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretMappingBuilder(SecretMappingFluent<?> fluent,SecretMapping instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretMapping build() {
    SecretMapping buildable = new SecretMapping(fluent.buildSourceRef(), fluent.buildTargetRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}