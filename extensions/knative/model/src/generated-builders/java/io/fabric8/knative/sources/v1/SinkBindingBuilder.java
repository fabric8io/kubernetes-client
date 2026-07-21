package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SinkBindingBuilder extends SinkBindingFluent<SinkBindingBuilder> implements VisitableBuilder<SinkBinding,SinkBindingBuilder>{

  SinkBindingFluent<?> fluent;

  public SinkBindingBuilder() {
    this(new SinkBinding());
  }
  
  public SinkBindingBuilder(SinkBindingFluent<?> fluent) {
    this(fluent, new SinkBinding());
  }
  
  public SinkBindingBuilder(SinkBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SinkBindingBuilder(SinkBindingFluent<?> fluent,SinkBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SinkBinding build() {
    SinkBinding buildable = new SinkBinding(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}