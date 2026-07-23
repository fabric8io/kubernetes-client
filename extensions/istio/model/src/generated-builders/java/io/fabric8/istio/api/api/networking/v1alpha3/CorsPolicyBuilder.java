package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CorsPolicyBuilder extends CorsPolicyFluent<CorsPolicyBuilder> implements VisitableBuilder<CorsPolicy,CorsPolicyBuilder>{

  CorsPolicyFluent<?> fluent;

  public CorsPolicyBuilder() {
    this(new CorsPolicy());
  }
  
  public CorsPolicyBuilder(CorsPolicyFluent<?> fluent) {
    this(fluent, new CorsPolicy());
  }
  
  public CorsPolicyBuilder(CorsPolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CorsPolicyBuilder(CorsPolicyFluent<?> fluent,CorsPolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CorsPolicy build() {
    CorsPolicy buildable = new CorsPolicy(fluent.getAllowCredentials(), fluent.getAllowHeaders(), fluent.getAllowMethods(), fluent.getDeprecatedAllowOrigin(), fluent.buildAllowOrigins(), fluent.getExposeHeaders(), fluent.getMaxAge(), fluent.getUnmatchedPreflights());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}