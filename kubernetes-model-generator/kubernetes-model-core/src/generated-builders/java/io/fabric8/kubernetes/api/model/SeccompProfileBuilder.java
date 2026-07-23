package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SeccompProfileBuilder extends SeccompProfileFluent<SeccompProfileBuilder> implements VisitableBuilder<SeccompProfile,SeccompProfileBuilder>{

  SeccompProfileFluent<?> fluent;

  public SeccompProfileBuilder() {
    this(new SeccompProfile());
  }
  
  public SeccompProfileBuilder(SeccompProfileFluent<?> fluent) {
    this(fluent, new SeccompProfile());
  }
  
  public SeccompProfileBuilder(SeccompProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SeccompProfileBuilder(SeccompProfileFluent<?> fluent,SeccompProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SeccompProfile build() {
    SeccompProfile buildable = new SeccompProfile(fluent.getLocalhostProfile(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}