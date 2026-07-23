package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPIngressPathBuilder extends HTTPIngressPathFluent<HTTPIngressPathBuilder> implements VisitableBuilder<HTTPIngressPath,HTTPIngressPathBuilder>{

  HTTPIngressPathFluent<?> fluent;

  public HTTPIngressPathBuilder() {
    this(new HTTPIngressPath());
  }
  
  public HTTPIngressPathBuilder(HTTPIngressPathFluent<?> fluent) {
    this(fluent, new HTTPIngressPath());
  }
  
  public HTTPIngressPathBuilder(HTTPIngressPath instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPIngressPathBuilder(HTTPIngressPathFluent<?> fluent,HTTPIngressPath instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPIngressPath build() {
    HTTPIngressPath buildable = new HTTPIngressPath(fluent.getAppendHeaders(), fluent.getHeaders(), fluent.getPath(), fluent.getRewriteHost(), fluent.buildSplits());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}