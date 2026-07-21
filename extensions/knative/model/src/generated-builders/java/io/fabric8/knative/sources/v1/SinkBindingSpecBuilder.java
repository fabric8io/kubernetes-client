package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SinkBindingSpecBuilder extends SinkBindingSpecFluent<SinkBindingSpecBuilder> implements VisitableBuilder<SinkBindingSpec,SinkBindingSpecBuilder>{

  SinkBindingSpecFluent<?> fluent;

  public SinkBindingSpecBuilder() {
    this(new SinkBindingSpec());
  }
  
  public SinkBindingSpecBuilder(SinkBindingSpecFluent<?> fluent) {
    this(fluent, new SinkBindingSpec());
  }
  
  public SinkBindingSpecBuilder(SinkBindingSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SinkBindingSpecBuilder(SinkBindingSpecFluent<?> fluent,SinkBindingSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SinkBindingSpec build() {
    SinkBindingSpec buildable = new SinkBindingSpec(fluent.buildCeOverrides(), fluent.buildSink(), fluent.buildSubject());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}