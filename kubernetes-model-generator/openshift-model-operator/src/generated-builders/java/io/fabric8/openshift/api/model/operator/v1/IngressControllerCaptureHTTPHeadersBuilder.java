package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerCaptureHTTPHeadersBuilder extends IngressControllerCaptureHTTPHeadersFluent<IngressControllerCaptureHTTPHeadersBuilder> implements VisitableBuilder<IngressControllerCaptureHTTPHeaders,IngressControllerCaptureHTTPHeadersBuilder>{

  IngressControllerCaptureHTTPHeadersFluent<?> fluent;

  public IngressControllerCaptureHTTPHeadersBuilder() {
    this(new IngressControllerCaptureHTTPHeaders());
  }
  
  public IngressControllerCaptureHTTPHeadersBuilder(IngressControllerCaptureHTTPHeadersFluent<?> fluent) {
    this(fluent, new IngressControllerCaptureHTTPHeaders());
  }
  
  public IngressControllerCaptureHTTPHeadersBuilder(IngressControllerCaptureHTTPHeaders instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerCaptureHTTPHeadersBuilder(IngressControllerCaptureHTTPHeadersFluent<?> fluent,IngressControllerCaptureHTTPHeaders instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerCaptureHTTPHeaders build() {
    IngressControllerCaptureHTTPHeaders buildable = new IngressControllerCaptureHTTPHeaders(fluent.buildRequest(), fluent.buildResponse());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}