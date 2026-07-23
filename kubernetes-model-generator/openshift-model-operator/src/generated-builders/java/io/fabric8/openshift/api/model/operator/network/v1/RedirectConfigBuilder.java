package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RedirectConfigBuilder extends RedirectConfigFluent<RedirectConfigBuilder> implements VisitableBuilder<RedirectConfig,RedirectConfigBuilder>{

  RedirectConfigFluent<?> fluent;

  public RedirectConfigBuilder() {
    this(new RedirectConfig());
  }
  
  public RedirectConfigBuilder(RedirectConfigFluent<?> fluent) {
    this(fluent, new RedirectConfig());
  }
  
  public RedirectConfigBuilder(RedirectConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RedirectConfigBuilder(RedirectConfigFluent<?> fluent,RedirectConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RedirectConfig build() {
    RedirectConfig buildable = new RedirectConfig(fluent.getFallbackIP(), fluent.buildRedirectRules());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}