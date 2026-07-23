package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskParamBuilder extends PipelineTaskParamFluent<PipelineTaskParamBuilder> implements VisitableBuilder<PipelineTaskParam,PipelineTaskParamBuilder>{

  PipelineTaskParamFluent<?> fluent;

  public PipelineTaskParamBuilder() {
    this(new PipelineTaskParam());
  }
  
  public PipelineTaskParamBuilder(PipelineTaskParamFluent<?> fluent) {
    this(fluent, new PipelineTaskParam());
  }
  
  public PipelineTaskParamBuilder(PipelineTaskParam instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskParamBuilder(PipelineTaskParamFluent<?> fluent,PipelineTaskParam instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskParam build() {
    PipelineTaskParam buildable = new PipelineTaskParam(fluent.getName(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}