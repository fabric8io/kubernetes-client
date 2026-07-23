package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineRunBuilder extends PipelineRunFluent<PipelineRunBuilder> implements VisitableBuilder<PipelineRun,PipelineRunBuilder>{

  PipelineRunFluent<?> fluent;

  public PipelineRunBuilder() {
    this(new PipelineRun());
  }
  
  public PipelineRunBuilder(PipelineRunFluent<?> fluent) {
    this(fluent, new PipelineRun());
  }
  
  public PipelineRunBuilder(PipelineRun instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineRunBuilder(PipelineRunFluent<?> fluent,PipelineRun instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineRun build() {
    PipelineRun buildable = new PipelineRun(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}