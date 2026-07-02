package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodTemplateSpecBuilder extends PodTemplateSpecFluent<PodTemplateSpecBuilder> implements VisitableBuilder<PodTemplateSpec,PodTemplateSpecBuilder>{

  PodTemplateSpecFluent<?> fluent;

  public PodTemplateSpecBuilder() {
    this(new PodTemplateSpec());
  }
  
  public PodTemplateSpecBuilder(PodTemplateSpecFluent<?> fluent) {
    this(fluent, new PodTemplateSpec());
  }
  
  public PodTemplateSpecBuilder(PodTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodTemplateSpecBuilder(PodTemplateSpecFluent<?> fluent,PodTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodTemplateSpec build() {
    PodTemplateSpec buildable = new PodTemplateSpec(fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}