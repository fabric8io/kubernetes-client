package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TelegramConfigBuilder extends TelegramConfigFluent<TelegramConfigBuilder> implements VisitableBuilder<TelegramConfig,TelegramConfigBuilder>{

  TelegramConfigFluent<?> fluent;

  public TelegramConfigBuilder() {
    this(new TelegramConfig());
  }
  
  public TelegramConfigBuilder(TelegramConfigFluent<?> fluent) {
    this(fluent, new TelegramConfig());
  }
  
  public TelegramConfigBuilder(TelegramConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TelegramConfigBuilder(TelegramConfigFluent<?> fluent,TelegramConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TelegramConfig build() {
    TelegramConfig buildable = new TelegramConfig(fluent.getApiURL(), fluent.buildBotToken(), fluent.getBotTokenFile(), fluent.getChatID(), fluent.getDisableNotifications(), fluent.buildHttpConfig(), fluent.getMessage(), fluent.getMessageThreadID(), fluent.getParseMode(), fluent.getSendResolved());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}