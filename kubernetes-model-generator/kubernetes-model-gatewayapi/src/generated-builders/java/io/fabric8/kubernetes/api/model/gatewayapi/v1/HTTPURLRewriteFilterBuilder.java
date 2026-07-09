package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPURLRewriteFilterBuilder extends HTTPURLRewriteFilterFluent<HTTPURLRewriteFilterBuilder> implements VisitableBuilder<HTTPURLRewriteFilter,HTTPURLRewriteFilterBuilder>{

  HTTPURLRewriteFilterFluent<?> fluent;

  public HTTPURLRewriteFilterBuilder() {
    this(new HTTPURLRewriteFilter());
  }
  
  public HTTPURLRewriteFilterBuilder(HTTPURLRewriteFilterFluent<?> fluent) {
    this(fluent, new HTTPURLRewriteFilter());
  }
  
  public HTTPURLRewriteFilterBuilder(HTTPURLRewriteFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPURLRewriteFilterBuilder(HTTPURLRewriteFilterFluent<?> fluent,HTTPURLRewriteFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPURLRewriteFilter build() {
    HTTPURLRewriteFilter buildable = new HTTPURLRewriteFilter(fluent.getHostname(), fluent.buildPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}