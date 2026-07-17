package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IngressControllerHTTPUniqueIdHeaderPolicyBuilder extends IngressControllerHTTPUniqueIdHeaderPolicyFluent<IngressControllerHTTPUniqueIdHeaderPolicyBuilder> implements VisitableBuilder<IngressControllerHTTPUniqueIdHeaderPolicy,IngressControllerHTTPUniqueIdHeaderPolicyBuilder>{

  IngressControllerHTTPUniqueIdHeaderPolicyFluent<?> fluent;

  public IngressControllerHTTPUniqueIdHeaderPolicyBuilder() {
    this(new IngressControllerHTTPUniqueIdHeaderPolicy());
  }
  
  public IngressControllerHTTPUniqueIdHeaderPolicyBuilder(IngressControllerHTTPUniqueIdHeaderPolicyFluent<?> fluent) {
    this(fluent, new IngressControllerHTTPUniqueIdHeaderPolicy());
  }
  
  public IngressControllerHTTPUniqueIdHeaderPolicyBuilder(IngressControllerHTTPUniqueIdHeaderPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IngressControllerHTTPUniqueIdHeaderPolicyBuilder(IngressControllerHTTPUniqueIdHeaderPolicyFluent<?> fluent,IngressControllerHTTPUniqueIdHeaderPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IngressControllerHTTPUniqueIdHeaderPolicy build() {
    IngressControllerHTTPUniqueIdHeaderPolicy buildable = new IngressControllerHTTPUniqueIdHeaderPolicy(fluent.getFormat(), fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}