package io.fabric8.knative.bindings.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretValueFromSourceBuilder extends SecretValueFromSourceFluent<SecretValueFromSourceBuilder> implements VisitableBuilder<SecretValueFromSource,SecretValueFromSourceBuilder>{

  SecretValueFromSourceFluent<?> fluent;

  public SecretValueFromSourceBuilder() {
    this(new SecretValueFromSource());
  }
  
  public SecretValueFromSourceBuilder(SecretValueFromSourceFluent<?> fluent) {
    this(fluent, new SecretValueFromSource());
  }
  
  public SecretValueFromSourceBuilder(SecretValueFromSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretValueFromSourceBuilder(SecretValueFromSourceFluent<?> fluent,SecretValueFromSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretValueFromSource build() {
    SecretValueFromSource buildable = new SecretValueFromSource(fluent.getSecretKeyRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}