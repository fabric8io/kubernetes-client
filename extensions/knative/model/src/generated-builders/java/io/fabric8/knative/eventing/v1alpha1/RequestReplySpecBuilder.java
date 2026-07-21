package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestReplySpecBuilder extends RequestReplySpecFluent<RequestReplySpecBuilder> implements VisitableBuilder<RequestReplySpec,RequestReplySpecBuilder>{

  RequestReplySpecFluent<?> fluent;

  public RequestReplySpecBuilder() {
    this(new RequestReplySpec());
  }
  
  public RequestReplySpecBuilder(RequestReplySpecFluent<?> fluent) {
    this(fluent, new RequestReplySpec());
  }
  
  public RequestReplySpecBuilder(RequestReplySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestReplySpecBuilder(RequestReplySpecFluent<?> fluent,RequestReplySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestReplySpec build() {
    RequestReplySpec buildable = new RequestReplySpec(fluent.buildBrokerRef(), fluent.getCorrelationAttribute(), fluent.buildDelivery(), fluent.getReplyAttribute(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}