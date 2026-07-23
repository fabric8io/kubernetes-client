package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretProjectionBuilder extends SecretProjectionFluent<SecretProjectionBuilder> implements VisitableBuilder<SecretProjection,SecretProjectionBuilder>{

  SecretProjectionFluent<?> fluent;

  public SecretProjectionBuilder() {
    this(new SecretProjection());
  }
  
  public SecretProjectionBuilder(SecretProjectionFluent<?> fluent) {
    this(fluent, new SecretProjection());
  }
  
  public SecretProjectionBuilder(SecretProjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretProjectionBuilder(SecretProjectionFluent<?> fluent,SecretProjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretProjection build() {
    SecretProjection buildable = new SecretProjection(fluent.buildItems(), fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}