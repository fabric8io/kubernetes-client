package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParamValueBuilder extends ParamValueFluent<ParamValueBuilder> implements VisitableBuilder<ParamValue,ParamValueBuilder>{

  ParamValueFluent<?> fluent;

  public ParamValueBuilder() {
    this(new ParamValue());
  }
  
  public ParamValueBuilder(ParamValueFluent<?> fluent) {
    this(fluent, new ParamValue());
  }
  
  public ParamValueBuilder(ParamValue instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParamValueBuilder(ParamValueFluent<?> fluent,ParamValue instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParamValue build() {
    ParamValue buildable = new ParamValue(fluent.getArrayVal(), fluent.getObjectVal(), fluent.getStringVal(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}