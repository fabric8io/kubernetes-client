package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WeChatConfigBuilder extends WeChatConfigFluent<WeChatConfigBuilder> implements VisitableBuilder<WeChatConfig,WeChatConfigBuilder>{

  WeChatConfigFluent<?> fluent;

  public WeChatConfigBuilder() {
    this(new WeChatConfig());
  }
  
  public WeChatConfigBuilder(WeChatConfigFluent<?> fluent) {
    this(fluent, new WeChatConfig());
  }
  
  public WeChatConfigBuilder(WeChatConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WeChatConfigBuilder(WeChatConfigFluent<?> fluent,WeChatConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WeChatConfig build() {
    WeChatConfig buildable = new WeChatConfig(fluent.getAgentID(), fluent.getApiSecret(), fluent.getApiURL(), fluent.getCorpID(), fluent.buildHttpConfig(), fluent.getMessage(), fluent.getMessageType(), fluent.getSendResolved(), fluent.getToParty(), fluent.getToTag(), fluent.getToUser());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}