package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPAuthConfigBuilder extends HTTPAuthConfigFluent<HTTPAuthConfigBuilder> implements VisitableBuilder<HTTPAuthConfig,HTTPAuthConfigBuilder>{

  HTTPAuthConfigFluent<?> fluent;

  public HTTPAuthConfigBuilder() {
    this(new HTTPAuthConfig());
  }
  
  public HTTPAuthConfigBuilder(HTTPAuthConfigFluent<?> fluent) {
    this(fluent, new HTTPAuthConfig());
  }
  
  public HTTPAuthConfigBuilder(HTTPAuthConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPAuthConfigBuilder(HTTPAuthConfigFluent<?> fluent,HTTPAuthConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPAuthConfig build() {
    HTTPAuthConfig buildable = new HTTPAuthConfig(fluent.getAllowedHeaders(), fluent.getAllowedResponseHeaders(), fluent.getPath());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}