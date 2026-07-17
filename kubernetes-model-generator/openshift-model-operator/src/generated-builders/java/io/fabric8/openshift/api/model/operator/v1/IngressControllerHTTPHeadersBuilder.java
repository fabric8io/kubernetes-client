package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerHTTPHeadersBuilder extends IngressControllerHTTPHeadersFluent<IngressControllerHTTPHeadersBuilder> implements VisitableBuilder<IngressControllerHTTPHeaders,IngressControllerHTTPHeadersBuilder>{

  IngressControllerHTTPHeadersFluent<?> fluent;

  public IngressControllerHTTPHeadersBuilder() {
    this(new IngressControllerHTTPHeaders());
  }
  
  public IngressControllerHTTPHeadersBuilder(IngressControllerHTTPHeadersFluent<?> fluent) {
    this(fluent, new IngressControllerHTTPHeaders());
  }
  
  public IngressControllerHTTPHeadersBuilder(IngressControllerHTTPHeaders instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerHTTPHeadersBuilder(IngressControllerHTTPHeadersFluent<?> fluent,IngressControllerHTTPHeaders instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerHTTPHeaders build() {
    IngressControllerHTTPHeaders buildable = new IngressControllerHTTPHeaders(fluent.buildActions(), fluent.getForwardedHeaderPolicy(), fluent.getHeaderNameCaseAdjustments(), fluent.buildUniqueId());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}