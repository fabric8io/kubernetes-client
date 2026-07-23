package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FailKernRequestBuilder extends FailKernRequestFluent<FailKernRequestBuilder> implements VisitableBuilder<FailKernRequest,FailKernRequestBuilder>{

  FailKernRequestFluent<?> fluent;

  public FailKernRequestBuilder() {
    this(new FailKernRequest());
  }
  
  public FailKernRequestBuilder(FailKernRequestFluent<?> fluent) {
    this(fluent, new FailKernRequest());
  }
  
  public FailKernRequestBuilder(FailKernRequest instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FailKernRequestBuilder(FailKernRequestFluent<?> fluent,FailKernRequest instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FailKernRequest build() {
    FailKernRequest buildable = new FailKernRequest(fluent.buildCallchain(), fluent.getFailtype(), fluent.getHeaders(), fluent.getProbability(), fluent.getTimes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}