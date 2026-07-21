package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretRefBuilder extends SecretRefFluent<SecretRefBuilder> implements VisitableBuilder<SecretRef,SecretRefBuilder>{

  SecretRefFluent<?> fluent;

  public SecretRefBuilder() {
    this(new SecretRef());
  }
  
  public SecretRefBuilder(SecretRefFluent<?> fluent) {
    this(fluent, new SecretRef());
  }
  
  public SecretRefBuilder(SecretRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretRefBuilder(SecretRefFluent<?> fluent,SecretRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretRef build() {
    SecretRef buildable = new SecretRef(fluent.getSecretKey(), fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}