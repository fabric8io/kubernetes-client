package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HeaderConfigBuilder extends HeaderConfigFluent<HeaderConfigBuilder> implements VisitableBuilder<HeaderConfig,HeaderConfigBuilder>{

  HeaderConfigFluent<?> fluent;

  public HeaderConfigBuilder() {
    this(new HeaderConfig());
  }
  
  public HeaderConfigBuilder(HeaderConfigFluent<?> fluent) {
    this(fluent, new HeaderConfig());
  }
  
  public HeaderConfigBuilder(HeaderConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HeaderConfigBuilder(HeaderConfigFluent<?> fluent,HeaderConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HeaderConfig build() {
    HeaderConfig buildable = new HeaderConfig(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}