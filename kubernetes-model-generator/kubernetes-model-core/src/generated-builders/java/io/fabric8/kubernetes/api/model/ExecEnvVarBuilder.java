package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExecEnvVarBuilder extends ExecEnvVarFluent<ExecEnvVarBuilder> implements VisitableBuilder<ExecEnvVar,ExecEnvVarBuilder>{

  ExecEnvVarFluent<?> fluent;

  public ExecEnvVarBuilder() {
    this(new ExecEnvVar());
  }
  
  public ExecEnvVarBuilder(ExecEnvVarFluent<?> fluent) {
    this(fluent, new ExecEnvVar());
  }
  
  public ExecEnvVarBuilder(ExecEnvVar instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExecEnvVarBuilder(ExecEnvVarFluent<?> fluent,ExecEnvVar instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExecEnvVar build() {
    ExecEnvVar buildable = new ExecEnvVar(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}