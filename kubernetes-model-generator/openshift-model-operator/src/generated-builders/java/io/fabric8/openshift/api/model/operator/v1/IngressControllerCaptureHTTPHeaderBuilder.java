package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerCaptureHTTPHeaderBuilder extends IngressControllerCaptureHTTPHeaderFluent<IngressControllerCaptureHTTPHeaderBuilder> implements VisitableBuilder<IngressControllerCaptureHTTPHeader,IngressControllerCaptureHTTPHeaderBuilder>{

  IngressControllerCaptureHTTPHeaderFluent<?> fluent;

  public IngressControllerCaptureHTTPHeaderBuilder() {
    this(new IngressControllerCaptureHTTPHeader());
  }
  
  public IngressControllerCaptureHTTPHeaderBuilder(IngressControllerCaptureHTTPHeaderFluent<?> fluent) {
    this(fluent, new IngressControllerCaptureHTTPHeader());
  }
  
  public IngressControllerCaptureHTTPHeaderBuilder(IngressControllerCaptureHTTPHeader instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerCaptureHTTPHeaderBuilder(IngressControllerCaptureHTTPHeaderFluent<?> fluent,IngressControllerCaptureHTTPHeader instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerCaptureHTTPHeader build() {
    IngressControllerCaptureHTTPHeader buildable = new IngressControllerCaptureHTTPHeader(fluent.getMaxLength(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}