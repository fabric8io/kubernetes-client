package io.fabric8.tekton.triggers.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParamBuilder extends ParamFluent<ParamBuilder> implements VisitableBuilder<Param,ParamBuilder>{

  ParamFluent<?> fluent;

  public ParamBuilder() {
    this(new Param());
  }
  
  public ParamBuilder(ParamFluent<?> fluent) {
    this(fluent, new Param());
  }
  
  public ParamBuilder(Param instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParamBuilder(ParamFluent<?> fluent,Param instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Param build() {
    Param buildable = new Param(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}