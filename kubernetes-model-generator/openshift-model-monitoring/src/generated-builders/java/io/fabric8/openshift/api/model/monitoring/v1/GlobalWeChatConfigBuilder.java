package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalWeChatConfigBuilder extends GlobalWeChatConfigFluent<GlobalWeChatConfigBuilder> implements VisitableBuilder<GlobalWeChatConfig,GlobalWeChatConfigBuilder>{

  GlobalWeChatConfigFluent<?> fluent;

  public GlobalWeChatConfigBuilder() {
    this(new GlobalWeChatConfig());
  }
  
  public GlobalWeChatConfigBuilder(GlobalWeChatConfigFluent<?> fluent) {
    this(fluent, new GlobalWeChatConfig());
  }
  
  public GlobalWeChatConfigBuilder(GlobalWeChatConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalWeChatConfigBuilder(GlobalWeChatConfigFluent<?> fluent,GlobalWeChatConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalWeChatConfig build() {
    GlobalWeChatConfig buildable = new GlobalWeChatConfig(fluent.getApiCorpID(), fluent.getApiSecret(), fluent.getApiURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}