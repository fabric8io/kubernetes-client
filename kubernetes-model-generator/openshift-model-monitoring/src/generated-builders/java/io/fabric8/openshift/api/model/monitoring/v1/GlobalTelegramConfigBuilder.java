package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalTelegramConfigBuilder extends GlobalTelegramConfigFluent<GlobalTelegramConfigBuilder> implements VisitableBuilder<GlobalTelegramConfig,GlobalTelegramConfigBuilder>{

  GlobalTelegramConfigFluent<?> fluent;

  public GlobalTelegramConfigBuilder() {
    this(new GlobalTelegramConfig());
  }
  
  public GlobalTelegramConfigBuilder(GlobalTelegramConfigFluent<?> fluent) {
    this(fluent, new GlobalTelegramConfig());
  }
  
  public GlobalTelegramConfigBuilder(GlobalTelegramConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalTelegramConfigBuilder(GlobalTelegramConfigFluent<?> fluent,GlobalTelegramConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalTelegramConfig build() {
    GlobalTelegramConfig buildable = new GlobalTelegramConfig(fluent.getApiURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}