package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParamKindBuilder extends ParamKindFluent<ParamKindBuilder> implements VisitableBuilder<ParamKind,ParamKindBuilder>{

  ParamKindFluent<?> fluent;

  public ParamKindBuilder() {
    this(new ParamKind());
  }
  
  public ParamKindBuilder(ParamKindFluent<?> fluent) {
    this(fluent, new ParamKind());
  }
  
  public ParamKindBuilder(ParamKind instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParamKindBuilder(ParamKindFluent<?> fluent,ParamKind instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParamKind build() {
    ParamKind buildable = new ParamKind(fluent.getApiVersion(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}