package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PipelineTaskMetadataBuilder extends PipelineTaskMetadataFluent<PipelineTaskMetadataBuilder> implements VisitableBuilder<PipelineTaskMetadata,PipelineTaskMetadataBuilder>{

  PipelineTaskMetadataFluent<?> fluent;

  public PipelineTaskMetadataBuilder() {
    this(new PipelineTaskMetadata());
  }
  
  public PipelineTaskMetadataBuilder(PipelineTaskMetadataFluent<?> fluent) {
    this(fluent, new PipelineTaskMetadata());
  }
  
  public PipelineTaskMetadataBuilder(PipelineTaskMetadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PipelineTaskMetadataBuilder(PipelineTaskMetadataFluent<?> fluent,PipelineTaskMetadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PipelineTaskMetadata build() {
    PipelineTaskMetadata buildable = new PipelineTaskMetadata(fluent.getAnnotations(), fluent.getLabels());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}