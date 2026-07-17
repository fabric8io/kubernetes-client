package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPCompressionPolicyBuilder extends HTTPCompressionPolicyFluent<HTTPCompressionPolicyBuilder> implements VisitableBuilder<HTTPCompressionPolicy,HTTPCompressionPolicyBuilder>{

  HTTPCompressionPolicyFluent<?> fluent;

  public HTTPCompressionPolicyBuilder() {
    this(new HTTPCompressionPolicy());
  }
  
  public HTTPCompressionPolicyBuilder(HTTPCompressionPolicyFluent<?> fluent) {
    this(fluent, new HTTPCompressionPolicy());
  }
  
  public HTTPCompressionPolicyBuilder(HTTPCompressionPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPCompressionPolicyBuilder(HTTPCompressionPolicyFluent<?> fluent,HTTPCompressionPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPCompressionPolicy build() {
    HTTPCompressionPolicy buildable = new HTTPCompressionPolicy(fluent.getMimeTypes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}