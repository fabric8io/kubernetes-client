package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CookieConfigBuilder extends CookieConfigFluent<CookieConfigBuilder> implements VisitableBuilder<CookieConfig,CookieConfigBuilder>{

  CookieConfigFluent<?> fluent;

  public CookieConfigBuilder() {
    this(new CookieConfig());
  }
  
  public CookieConfigBuilder(CookieConfigFluent<?> fluent) {
    this(fluent, new CookieConfig());
  }
  
  public CookieConfigBuilder(CookieConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CookieConfigBuilder(CookieConfigFluent<?> fluent,CookieConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CookieConfig build() {
    CookieConfig buildable = new CookieConfig(fluent.getLifetimeType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}