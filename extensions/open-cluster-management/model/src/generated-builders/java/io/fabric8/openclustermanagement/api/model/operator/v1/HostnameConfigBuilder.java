package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostnameConfigBuilder extends HostnameConfigFluent<HostnameConfigBuilder> implements VisitableBuilder<HostnameConfig,HostnameConfigBuilder>{

  HostnameConfigFluent<?> fluent;

  public HostnameConfigBuilder() {
    this(new HostnameConfig());
  }
  
  public HostnameConfigBuilder(HostnameConfigFluent<?> fluent) {
    this(fluent, new HostnameConfig());
  }
  
  public HostnameConfigBuilder(HostnameConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostnameConfigBuilder(HostnameConfigFluent<?> fluent,HostnameConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostnameConfig build() {
    HostnameConfig buildable = new HostnameConfig(fluent.getCaBundle(), fluent.getHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}