package io.fabric8.istio.api.api.extensions.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EnvVarBuilder extends EnvVarFluent<EnvVarBuilder> implements VisitableBuilder<EnvVar,EnvVarBuilder>{

  EnvVarFluent<?> fluent;

  public EnvVarBuilder() {
    this(new EnvVar());
  }
  
  public EnvVarBuilder(EnvVarFluent<?> fluent) {
    this(fluent, new EnvVar());
  }
  
  public EnvVarBuilder(EnvVar instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EnvVarBuilder(EnvVarFluent<?> fluent,EnvVar instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EnvVar build() {
    EnvVar buildable = new EnvVar(fluent.getName(), fluent.getValue(), fluent.getValueFrom());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}