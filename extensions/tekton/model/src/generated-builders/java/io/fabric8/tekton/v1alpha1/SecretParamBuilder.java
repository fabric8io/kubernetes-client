package io.fabric8.tekton.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecretParamBuilder extends SecretParamFluent<SecretParamBuilder> implements VisitableBuilder<SecretParam,SecretParamBuilder>{

  SecretParamFluent<?> fluent;

  public SecretParamBuilder() {
    this(new SecretParam());
  }
  
  public SecretParamBuilder(SecretParamFluent<?> fluent) {
    this(fluent, new SecretParam());
  }
  
  public SecretParamBuilder(SecretParam instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecretParamBuilder(SecretParamFluent<?> fluent,SecretParam instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecretParam build() {
    SecretParam buildable = new SecretParam(fluent.getFieldName(), fluent.getSecretKey(), fluent.getSecretName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}