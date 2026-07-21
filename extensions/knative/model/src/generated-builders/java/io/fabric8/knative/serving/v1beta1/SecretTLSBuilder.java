package io.fabric8.knative.serving.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretTLSBuilder extends SecretTLSFluent<SecretTLSBuilder> implements VisitableBuilder<SecretTLS,SecretTLSBuilder>{

  SecretTLSFluent<?> fluent;

  public SecretTLSBuilder() {
    this(new SecretTLS());
  }
  
  public SecretTLSBuilder(SecretTLSFluent<?> fluent) {
    this(fluent, new SecretTLS());
  }
  
  public SecretTLSBuilder(SecretTLS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretTLSBuilder(SecretTLSFluent<?> fluent,SecretTLS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretTLS build() {
    SecretTLS buildable = new SecretTLS(fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}