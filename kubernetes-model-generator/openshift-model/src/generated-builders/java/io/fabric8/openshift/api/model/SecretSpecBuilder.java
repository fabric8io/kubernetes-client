package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretSpecBuilder extends SecretSpecFluent<SecretSpecBuilder> implements VisitableBuilder<SecretSpec,SecretSpecBuilder>{

  SecretSpecFluent<?> fluent;

  public SecretSpecBuilder() {
    this(new SecretSpec());
  }
  
  public SecretSpecBuilder(SecretSpecFluent<?> fluent) {
    this(fluent, new SecretSpec());
  }
  
  public SecretSpecBuilder(SecretSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretSpecBuilder(SecretSpecFluent<?> fluent,SecretSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretSpec build() {
    SecretSpec buildable = new SecretSpec(fluent.getMountPath(), fluent.buildSecretSource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}