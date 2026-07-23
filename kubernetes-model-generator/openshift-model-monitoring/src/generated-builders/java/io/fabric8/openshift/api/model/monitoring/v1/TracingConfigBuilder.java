package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TracingConfigBuilder extends TracingConfigFluent<TracingConfigBuilder> implements VisitableBuilder<TracingConfig,TracingConfigBuilder>{

  TracingConfigFluent<?> fluent;

  public TracingConfigBuilder() {
    this(new TracingConfig());
  }
  
  public TracingConfigBuilder(TracingConfigFluent<?> fluent) {
    this(fluent, new TracingConfig());
  }
  
  public TracingConfigBuilder(TracingConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TracingConfigBuilder(TracingConfigFluent<?> fluent,TracingConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TracingConfig build() {
    TracingConfig buildable = new TracingConfig(fluent.getClientType(), fluent.getCompression(), fluent.getEndpoint(), fluent.getHeaders(), fluent.getInsecure(), fluent.getSamplingFraction(), fluent.getTimeout(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}