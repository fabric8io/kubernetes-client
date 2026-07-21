package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestReplyStatusBuilder extends RequestReplyStatusFluent<RequestReplyStatusBuilder> implements VisitableBuilder<RequestReplyStatus,RequestReplyStatusBuilder>{

  RequestReplyStatusFluent<?> fluent;

  public RequestReplyStatusBuilder() {
    this(new RequestReplyStatus());
  }
  
  public RequestReplyStatusBuilder(RequestReplyStatusFluent<?> fluent) {
    this(fluent, new RequestReplyStatus());
  }
  
  public RequestReplyStatusBuilder(RequestReplyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestReplyStatusBuilder(RequestReplyStatusFluent<?> fluent,RequestReplyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestReplyStatus build() {
    RequestReplyStatus buildable = new RequestReplyStatus(fluent.buildAddress(), fluent.buildAddresses(), fluent.getAnnotations(), fluent.buildConditions(), fluent.getDesiredReplicas(), fluent.getObservedGeneration(), fluent.buildPolicies(), fluent.getReadyReplicas());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}