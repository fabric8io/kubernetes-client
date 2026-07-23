package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPHealthCheckConfigBuilder extends HTTPHealthCheckConfigFluent<HTTPHealthCheckConfigBuilder> implements VisitableBuilder<HTTPHealthCheckConfig,HTTPHealthCheckConfigBuilder>{

  HTTPHealthCheckConfigFluent<?> fluent;

  public HTTPHealthCheckConfigBuilder() {
    this(new HTTPHealthCheckConfig());
  }
  
  public HTTPHealthCheckConfigBuilder(HTTPHealthCheckConfigFluent<?> fluent) {
    this(fluent, new HTTPHealthCheckConfig());
  }
  
  public HTTPHealthCheckConfigBuilder(HTTPHealthCheckConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPHealthCheckConfigBuilder(HTTPHealthCheckConfigFluent<?> fluent,HTTPHealthCheckConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPHealthCheckConfig build() {
    HTTPHealthCheckConfig buildable = new HTTPHealthCheckConfig(fluent.getHost(), fluent.buildHttpHeaders(), fluent.getPath(), fluent.getPort(), fluent.getScheme());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}