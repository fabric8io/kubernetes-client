package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPIngressRuleValueBuilder extends HTTPIngressRuleValueFluent<HTTPIngressRuleValueBuilder> implements VisitableBuilder<HTTPIngressRuleValue,HTTPIngressRuleValueBuilder>{

  HTTPIngressRuleValueFluent<?> fluent;

  public HTTPIngressRuleValueBuilder() {
    this(new HTTPIngressRuleValue());
  }
  
  public HTTPIngressRuleValueBuilder(HTTPIngressRuleValueFluent<?> fluent) {
    this(fluent, new HTTPIngressRuleValue());
  }
  
  public HTTPIngressRuleValueBuilder(HTTPIngressRuleValue instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPIngressRuleValueBuilder(HTTPIngressRuleValueFluent<?> fluent,HTTPIngressRuleValue instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPIngressRuleValue build() {
    HTTPIngressRuleValue buildable = new HTTPIngressRuleValue(fluent.buildPaths());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}