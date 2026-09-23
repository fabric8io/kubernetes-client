package io.fabric8.kubernetes.api.model.lifecycle.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EvictionRequestBuilder extends EvictionRequestFluent<EvictionRequestBuilder> implements VisitableBuilder<EvictionRequest,EvictionRequestBuilder>{

  EvictionRequestFluent<?> fluent;

  public EvictionRequestBuilder() {
    this(new EvictionRequest());
  }
  
  public EvictionRequestBuilder(EvictionRequestFluent<?> fluent) {
    this(fluent, new EvictionRequest());
  }
  
  public EvictionRequestBuilder(EvictionRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EvictionRequestBuilder(EvictionRequestFluent<?> fluent,EvictionRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EvictionRequest build() {
    EvictionRequest buildable = new EvictionRequest(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}