package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPMirrorPolicyBuilder extends HTTPMirrorPolicyFluent<HTTPMirrorPolicyBuilder> implements VisitableBuilder<HTTPMirrorPolicy,HTTPMirrorPolicyBuilder>{

  HTTPMirrorPolicyFluent<?> fluent;

  public HTTPMirrorPolicyBuilder() {
    this(new HTTPMirrorPolicy());
  }
  
  public HTTPMirrorPolicyBuilder(HTTPMirrorPolicyFluent<?> fluent) {
    this(fluent, new HTTPMirrorPolicy());
  }
  
  public HTTPMirrorPolicyBuilder(HTTPMirrorPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPMirrorPolicyBuilder(HTTPMirrorPolicyFluent<?> fluent,HTTPMirrorPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPMirrorPolicy build() {
    HTTPMirrorPolicy buildable = new HTTPMirrorPolicy(fluent.buildDestination(), fluent.buildPercentage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}