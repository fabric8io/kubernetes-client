package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParameterBuilder extends ParameterFluent<ParameterBuilder> implements VisitableBuilder<Parameter,ParameterBuilder>{

  ParameterFluent<?> fluent;

  public ParameterBuilder() {
    this(new Parameter());
  }
  
  public ParameterBuilder(ParameterFluent<?> fluent) {
    this(fluent, new Parameter());
  }
  
  public ParameterBuilder(Parameter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParameterBuilder(ParameterFluent<?> fluent,Parameter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Parameter build() {
    Parameter buildable = new Parameter(fluent.getDescription(), fluent.getDisplayName(), fluent.getFrom(), fluent.getGenerate(), fluent.getName(), fluent.getRequired(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}