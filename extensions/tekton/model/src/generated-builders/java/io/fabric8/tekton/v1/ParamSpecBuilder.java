package io.fabric8.tekton.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ParamSpecBuilder extends ParamSpecFluent<ParamSpecBuilder> implements VisitableBuilder<ParamSpec,ParamSpecBuilder>{

  ParamSpecFluent<?> fluent;

  public ParamSpecBuilder() {
    this(new ParamSpec());
  }
  
  public ParamSpecBuilder(ParamSpecFluent<?> fluent) {
    this(fluent, new ParamSpec());
  }
  
  public ParamSpecBuilder(ParamSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ParamSpecBuilder(ParamSpecFluent<?> fluent,ParamSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ParamSpec build() {
    ParamSpec buildable = new ParamSpec(fluent.buildDefault(), fluent.getDescription(), fluent.getEnum(), fluent.getName(), fluent.getProperties(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}