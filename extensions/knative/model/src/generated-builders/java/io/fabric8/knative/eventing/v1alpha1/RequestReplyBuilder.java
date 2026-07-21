package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestReplyBuilder extends RequestReplyFluent<RequestReplyBuilder> implements VisitableBuilder<RequestReply,RequestReplyBuilder>{

  RequestReplyFluent<?> fluent;

  public RequestReplyBuilder() {
    this(new RequestReply());
  }
  
  public RequestReplyBuilder(RequestReplyFluent<?> fluent) {
    this(fluent, new RequestReply());
  }
  
  public RequestReplyBuilder(RequestReply instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestReplyBuilder(RequestReplyFluent<?> fluent,RequestReply instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestReply build() {
    RequestReply buildable = new RequestReply(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}