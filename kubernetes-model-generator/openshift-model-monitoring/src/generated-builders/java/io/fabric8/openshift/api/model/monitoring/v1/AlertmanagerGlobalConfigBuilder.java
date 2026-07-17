package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerGlobalConfigBuilder extends AlertmanagerGlobalConfigFluent<AlertmanagerGlobalConfigBuilder> implements VisitableBuilder<AlertmanagerGlobalConfig,AlertmanagerGlobalConfigBuilder>{

  AlertmanagerGlobalConfigFluent<?> fluent;

  public AlertmanagerGlobalConfigBuilder() {
    this(new AlertmanagerGlobalConfig());
  }
  
  public AlertmanagerGlobalConfigBuilder(AlertmanagerGlobalConfigFluent<?> fluent) {
    this(fluent, new AlertmanagerGlobalConfig());
  }
  
  public AlertmanagerGlobalConfigBuilder(AlertmanagerGlobalConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerGlobalConfigBuilder(AlertmanagerGlobalConfigFluent<?> fluent,AlertmanagerGlobalConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerGlobalConfig build() {
    AlertmanagerGlobalConfig buildable = new AlertmanagerGlobalConfig(fluent.buildHttpConfig(), fluent.buildJira(), fluent.buildMattermost(), fluent.getOpsGenieApiKey(), fluent.getOpsGenieApiUrl(), fluent.getPagerdutyUrl(), fluent.getResolveTimeout(), fluent.buildRocketChat(), fluent.getSlackApiUrl(), fluent.buildSmtp(), fluent.buildTelegram(), fluent.buildVictorops(), fluent.buildWebex(), fluent.buildWechat());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}