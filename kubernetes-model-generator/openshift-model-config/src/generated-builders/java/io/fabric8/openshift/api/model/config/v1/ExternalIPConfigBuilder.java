package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExternalIPConfigBuilder extends ExternalIPConfigFluent<ExternalIPConfigBuilder> implements VisitableBuilder<ExternalIPConfig,ExternalIPConfigBuilder>{

  ExternalIPConfigFluent<?> fluent;

  public ExternalIPConfigBuilder() {
    this(new ExternalIPConfig());
  }
  
  public ExternalIPConfigBuilder(ExternalIPConfigFluent<?> fluent) {
    this(fluent, new ExternalIPConfig());
  }
  
  public ExternalIPConfigBuilder(ExternalIPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExternalIPConfigBuilder(ExternalIPConfigFluent<?> fluent,ExternalIPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExternalIPConfig build() {
    ExternalIPConfig buildable = new ExternalIPConfig(fluent.getAutoAssignCIDRs(), fluent.buildPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}