package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RequestAuthenticationBuilder extends RequestAuthenticationFluent<RequestAuthenticationBuilder> implements VisitableBuilder<RequestAuthentication,RequestAuthenticationBuilder>{

  RequestAuthenticationFluent<?> fluent;

  public RequestAuthenticationBuilder() {
    this(new RequestAuthentication());
  }
  
  public RequestAuthenticationBuilder(RequestAuthenticationFluent<?> fluent) {
    this(fluent, new RequestAuthentication());
  }
  
  public RequestAuthenticationBuilder(RequestAuthentication instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RequestAuthenticationBuilder(RequestAuthenticationFluent<?> fluent,RequestAuthentication instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RequestAuthentication build() {
    RequestAuthentication buildable = new RequestAuthentication(fluent.buildJwtRules(), fluent.buildSelector(), fluent.buildTargetRef(), fluent.buildTargetRefs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}