package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalRocketChatConfigBuilder extends GlobalRocketChatConfigFluent<GlobalRocketChatConfigBuilder> implements VisitableBuilder<GlobalRocketChatConfig,GlobalRocketChatConfigBuilder>{

  GlobalRocketChatConfigFluent<?> fluent;

  public GlobalRocketChatConfigBuilder() {
    this(new GlobalRocketChatConfig());
  }
  
  public GlobalRocketChatConfigBuilder(GlobalRocketChatConfigFluent<?> fluent) {
    this(fluent, new GlobalRocketChatConfig());
  }
  
  public GlobalRocketChatConfigBuilder(GlobalRocketChatConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalRocketChatConfigBuilder(GlobalRocketChatConfigFluent<?> fluent,GlobalRocketChatConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalRocketChatConfig build() {
    GlobalRocketChatConfig buildable = new GlobalRocketChatConfig(fluent.getApiURL(), fluent.getToken(), fluent.getTokenID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}