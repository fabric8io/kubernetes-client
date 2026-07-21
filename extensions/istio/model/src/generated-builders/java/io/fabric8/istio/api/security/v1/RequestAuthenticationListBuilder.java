package io.fabric8.istio.api.security.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestAuthenticationListBuilder extends RequestAuthenticationListFluent<RequestAuthenticationListBuilder> implements VisitableBuilder<RequestAuthenticationList,RequestAuthenticationListBuilder>{

  RequestAuthenticationListFluent<?> fluent;

  public RequestAuthenticationListBuilder() {
    this(new RequestAuthenticationList());
  }
  
  public RequestAuthenticationListBuilder(RequestAuthenticationListFluent<?> fluent) {
    this(fluent, new RequestAuthenticationList());
  }
  
  public RequestAuthenticationListBuilder(RequestAuthenticationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestAuthenticationListBuilder(RequestAuthenticationListFluent<?> fluent,RequestAuthenticationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestAuthenticationList build() {
    RequestAuthenticationList buildable = new RequestAuthenticationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}