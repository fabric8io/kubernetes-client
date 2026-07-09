package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParamRefBuilder extends ParamRefFluent<ParamRefBuilder> implements VisitableBuilder<ParamRef,ParamRefBuilder>{

  ParamRefFluent<?> fluent;

  public ParamRefBuilder() {
    this(new ParamRef());
  }
  
  public ParamRefBuilder(ParamRefFluent<?> fluent) {
    this(fluent, new ParamRef());
  }
  
  public ParamRefBuilder(ParamRef instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParamRefBuilder(ParamRefFluent<?> fluent,ParamRef instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParamRef build() {
    ParamRef buildable = new ParamRef(fluent.getName(), fluent.getNamespace(), fluent.getParameterNotFoundAction(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}