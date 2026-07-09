package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VarBuilder extends VarFluent<VarBuilder> implements VisitableBuilder<Var,VarBuilder>{

  VarFluent<?> fluent;

  public VarBuilder() {
    this(new Var());
  }
  
  public VarBuilder(VarFluent<?> fluent) {
    this(fluent, new Var());
  }
  
  public VarBuilder(Var instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VarBuilder(VarFluent<?> fluent,Var instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Var build() {
    Var buildable = new Var(fluent.buildFieldref(), fluent.getName(), fluent.buildObjref());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}