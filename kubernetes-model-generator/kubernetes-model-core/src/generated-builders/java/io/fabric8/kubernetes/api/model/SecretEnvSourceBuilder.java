package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretEnvSourceBuilder extends SecretEnvSourceFluent<SecretEnvSourceBuilder> implements VisitableBuilder<SecretEnvSource,SecretEnvSourceBuilder>{

  SecretEnvSourceFluent<?> fluent;

  public SecretEnvSourceBuilder() {
    this(new SecretEnvSource());
  }
  
  public SecretEnvSourceBuilder(SecretEnvSourceFluent<?> fluent) {
    this(fluent, new SecretEnvSource());
  }
  
  public SecretEnvSourceBuilder(SecretEnvSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretEnvSourceBuilder(SecretEnvSourceFluent<?> fluent,SecretEnvSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretEnvSource build() {
    SecretEnvSource buildable = new SecretEnvSource(fluent.getName(), fluent.getOptional());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}