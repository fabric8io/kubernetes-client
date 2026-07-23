package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IncludeParamsBuilder extends IncludeParamsFluent<IncludeParamsBuilder> implements VisitableBuilder<IncludeParams,IncludeParamsBuilder>{

  IncludeParamsFluent<?> fluent;

  public IncludeParamsBuilder() {
    this(new IncludeParams());
  }
  
  public IncludeParamsBuilder(IncludeParamsFluent<?> fluent) {
    this(fluent, new IncludeParams());
  }
  
  public IncludeParamsBuilder(IncludeParams instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IncludeParamsBuilder(IncludeParamsFluent<?> fluent,IncludeParams instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IncludeParams build() {
    IncludeParams buildable = new IncludeParams(fluent.getName(), fluent.buildParams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}