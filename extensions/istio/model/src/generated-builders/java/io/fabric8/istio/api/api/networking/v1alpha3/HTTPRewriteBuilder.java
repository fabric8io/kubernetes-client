package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPRewriteBuilder extends HTTPRewriteFluent<HTTPRewriteBuilder> implements VisitableBuilder<HTTPRewrite,HTTPRewriteBuilder>{

  HTTPRewriteFluent<?> fluent;

  public HTTPRewriteBuilder() {
    this(new HTTPRewrite());
  }
  
  public HTTPRewriteBuilder(HTTPRewriteFluent<?> fluent) {
    this(fluent, new HTTPRewrite());
  }
  
  public HTTPRewriteBuilder(HTTPRewrite instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPRewriteBuilder(HTTPRewriteFluent<?> fluent,HTTPRewrite instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPRewrite build() {
    HTTPRewrite buildable = new HTTPRewrite(fluent.getAuthority(), fluent.getUri(), fluent.buildUriRegexRewrite());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}