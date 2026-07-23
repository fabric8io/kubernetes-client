package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerCaptureHTTPCookieUnionBuilder extends IngressControllerCaptureHTTPCookieUnionFluent<IngressControllerCaptureHTTPCookieUnionBuilder> implements VisitableBuilder<IngressControllerCaptureHTTPCookieUnion,IngressControllerCaptureHTTPCookieUnionBuilder>{

  IngressControllerCaptureHTTPCookieUnionFluent<?> fluent;

  public IngressControllerCaptureHTTPCookieUnionBuilder() {
    this(new IngressControllerCaptureHTTPCookieUnion());
  }
  
  public IngressControllerCaptureHTTPCookieUnionBuilder(IngressControllerCaptureHTTPCookieUnionFluent<?> fluent) {
    this(fluent, new IngressControllerCaptureHTTPCookieUnion());
  }
  
  public IngressControllerCaptureHTTPCookieUnionBuilder(IngressControllerCaptureHTTPCookieUnion instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerCaptureHTTPCookieUnionBuilder(IngressControllerCaptureHTTPCookieUnionFluent<?> fluent,IngressControllerCaptureHTTPCookieUnion instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerCaptureHTTPCookieUnion build() {
    IngressControllerCaptureHTTPCookieUnion buildable = new IngressControllerCaptureHTTPCookieUnion(fluent.getMatchType(), fluent.getName(), fluent.getNamePrefix());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}