package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerCaptureHTTPCookieBuilder extends IngressControllerCaptureHTTPCookieFluent<IngressControllerCaptureHTTPCookieBuilder> implements VisitableBuilder<IngressControllerCaptureHTTPCookie,IngressControllerCaptureHTTPCookieBuilder>{

  IngressControllerCaptureHTTPCookieFluent<?> fluent;

  public IngressControllerCaptureHTTPCookieBuilder() {
    this(new IngressControllerCaptureHTTPCookie());
  }
  
  public IngressControllerCaptureHTTPCookieBuilder(IngressControllerCaptureHTTPCookieFluent<?> fluent) {
    this(fluent, new IngressControllerCaptureHTTPCookie());
  }
  
  public IngressControllerCaptureHTTPCookieBuilder(IngressControllerCaptureHTTPCookie instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerCaptureHTTPCookieBuilder(IngressControllerCaptureHTTPCookieFluent<?> fluent,IngressControllerCaptureHTTPCookie instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerCaptureHTTPCookie build() {
    IngressControllerCaptureHTTPCookie buildable = new IngressControllerCaptureHTTPCookie(fluent.getMatchType(), fluent.getMaxLength(), fluent.getName(), fluent.getNamePrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}