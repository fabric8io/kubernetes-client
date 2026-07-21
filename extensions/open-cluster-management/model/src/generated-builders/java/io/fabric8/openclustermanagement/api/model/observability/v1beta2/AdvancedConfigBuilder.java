package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AdvancedConfigBuilder extends AdvancedConfigFluent<AdvancedConfigBuilder> implements VisitableBuilder<AdvancedConfig,AdvancedConfigBuilder>{

  AdvancedConfigFluent<?> fluent;

  public AdvancedConfigBuilder() {
    this(new AdvancedConfig());
  }
  
  public AdvancedConfigBuilder(AdvancedConfigFluent<?> fluent) {
    this(fluent, new AdvancedConfig());
  }
  
  public AdvancedConfigBuilder(AdvancedConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AdvancedConfigBuilder(AdvancedConfigFluent<?> fluent,AdvancedConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AdvancedConfig build() {
    AdvancedConfig buildable = new AdvancedConfig(fluent.buildAlertmanager(), fluent.buildCompact(), fluent.getCustomAlertmanagerHubURL(), fluent.getCustomObservabilityHubURL(), fluent.buildGrafana(), fluent.buildMultiClusterObservabilityAddon(), fluent.buildObservatoriumAPI(), fluent.buildQuery(), fluent.buildQueryFrontend(), fluent.buildQueryFrontendMemcached(), fluent.buildRbacQueryProxy(), fluent.buildReceive(), fluent.buildRetentionConfig(), fluent.buildRule(), fluent.buildStore(), fluent.buildStoreMemcached());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}