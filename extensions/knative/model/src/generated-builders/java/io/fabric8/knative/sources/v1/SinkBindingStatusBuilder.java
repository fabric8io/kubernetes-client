package io.fabric8.knative.sources.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SinkBindingStatusBuilder extends SinkBindingStatusFluent<SinkBindingStatusBuilder> implements VisitableBuilder<SinkBindingStatus,SinkBindingStatusBuilder>{

  SinkBindingStatusFluent<?> fluent;

  public SinkBindingStatusBuilder() {
    this(new SinkBindingStatus());
  }
  
  public SinkBindingStatusBuilder(SinkBindingStatusFluent<?> fluent) {
    this(fluent, new SinkBindingStatus());
  }
  
  public SinkBindingStatusBuilder(SinkBindingStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SinkBindingStatusBuilder(SinkBindingStatusFluent<?> fluent,SinkBindingStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SinkBindingStatus build() {
    SinkBindingStatus buildable = new SinkBindingStatus(fluent.getAnnotations(), fluent.buildAuth(), fluent.buildCeAttributes(), fluent.buildConditions(), fluent.getObservedGeneration(), fluent.getOidcTokenSecretName(), fluent.getSinkAudience(), fluent.getSinkCACerts(), fluent.getSinkUri());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}