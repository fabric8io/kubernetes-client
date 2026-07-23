package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretKeySelectorBuilder extends SecretKeySelectorFluent<SecretKeySelectorBuilder> implements VisitableBuilder<SecretKeySelector,SecretKeySelectorBuilder>{

  SecretKeySelectorFluent<?> fluent;

  public SecretKeySelectorBuilder() {
    this(new SecretKeySelector());
  }
  
  public SecretKeySelectorBuilder(SecretKeySelectorFluent<?> fluent) {
    this(fluent, new SecretKeySelector());
  }
  
  public SecretKeySelectorBuilder(SecretKeySelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretKeySelectorBuilder(SecretKeySelectorFluent<?> fluent,SecretKeySelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretKeySelector build() {
    SecretKeySelector buildable = new SecretKeySelector(fluent.getKey(), fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}