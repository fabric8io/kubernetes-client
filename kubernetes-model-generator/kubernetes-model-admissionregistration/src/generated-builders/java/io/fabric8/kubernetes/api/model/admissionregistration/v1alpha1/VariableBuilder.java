package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VariableBuilder extends VariableFluent<VariableBuilder> implements VisitableBuilder<Variable,VariableBuilder>{

  VariableFluent<?> fluent;

  public VariableBuilder() {
    this(new Variable());
  }
  
  public VariableBuilder(VariableFluent<?> fluent) {
    this(fluent, new Variable());
  }
  
  public VariableBuilder(Variable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VariableBuilder(VariableFluent<?> fluent,Variable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Variable build() {
    Variable buildable = new Variable(fluent.getExpression(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}