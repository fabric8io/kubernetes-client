package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TCPHealthCheckConfigBuilder extends TCPHealthCheckConfigFluent<TCPHealthCheckConfigBuilder> implements VisitableBuilder<TCPHealthCheckConfig,TCPHealthCheckConfigBuilder>{

  TCPHealthCheckConfigFluent<?> fluent;

  public TCPHealthCheckConfigBuilder() {
    this(new TCPHealthCheckConfig());
  }
  
  public TCPHealthCheckConfigBuilder(TCPHealthCheckConfigFluent<?> fluent) {
    this(fluent, new TCPHealthCheckConfig());
  }
  
  public TCPHealthCheckConfigBuilder(TCPHealthCheckConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TCPHealthCheckConfigBuilder(TCPHealthCheckConfigFluent<?> fluent,TCPHealthCheckConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TCPHealthCheckConfig build() {
    TCPHealthCheckConfig buildable = new TCPHealthCheckConfig(fluent.getHost(), fluent.getPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}