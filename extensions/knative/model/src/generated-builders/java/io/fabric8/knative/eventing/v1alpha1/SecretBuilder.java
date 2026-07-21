package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretBuilder extends SecretFluent<SecretBuilder> implements VisitableBuilder<Secret,SecretBuilder>{

  SecretFluent<?> fluent;

  public SecretBuilder() {
    this(new Secret());
  }
  
  public SecretBuilder(SecretFluent<?> fluent) {
    this(fluent, new Secret());
  }
  
  public SecretBuilder(Secret instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretBuilder(SecretFluent<?> fluent,Secret instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Secret build() {
    Secret buildable = new Secret(fluent.buildRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}