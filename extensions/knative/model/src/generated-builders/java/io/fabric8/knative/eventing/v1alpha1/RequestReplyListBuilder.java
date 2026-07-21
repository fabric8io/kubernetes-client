package io.fabric8.knative.eventing.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestReplyListBuilder extends RequestReplyListFluent<RequestReplyListBuilder> implements VisitableBuilder<RequestReplyList,RequestReplyListBuilder>{

  RequestReplyListFluent<?> fluent;

  public RequestReplyListBuilder() {
    this(new RequestReplyList());
  }
  
  public RequestReplyListBuilder(RequestReplyListFluent<?> fluent) {
    this(fluent, new RequestReplyList());
  }
  
  public RequestReplyListBuilder(RequestReplyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestReplyListBuilder(RequestReplyListFluent<?> fluent,RequestReplyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestReplyList build() {
    RequestReplyList buildable = new RequestReplyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}