package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SourceSpecBuilder extends SourceSpecFluent<SourceSpecBuilder> implements VisitableBuilder<SourceSpec,SourceSpecBuilder>{

  SourceSpecFluent<?> fluent;

  public SourceSpecBuilder() {
    this(new SourceSpec());
  }
  
  public SourceSpecBuilder(SourceSpecFluent<?> fluent) {
    this(fluent, new SourceSpec());
  }
  
  public SourceSpecBuilder(SourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SourceSpecBuilder(SourceSpecFluent<?> fluent,SourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SourceSpec build() {
    SourceSpec buildable = new SourceSpec(fluent.buildCeOverrides(), fluent.buildSink());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}