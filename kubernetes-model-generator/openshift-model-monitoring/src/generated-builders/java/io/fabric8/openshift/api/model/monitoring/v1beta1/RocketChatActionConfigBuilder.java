package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RocketChatActionConfigBuilder extends RocketChatActionConfigFluent<RocketChatActionConfigBuilder> implements VisitableBuilder<RocketChatActionConfig,RocketChatActionConfigBuilder>{

  RocketChatActionConfigFluent<?> fluent;

  public RocketChatActionConfigBuilder() {
    this(new RocketChatActionConfig());
  }
  
  public RocketChatActionConfigBuilder(RocketChatActionConfigFluent<?> fluent) {
    this(fluent, new RocketChatActionConfig());
  }
  
  public RocketChatActionConfigBuilder(RocketChatActionConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RocketChatActionConfigBuilder(RocketChatActionConfigFluent<?> fluent,RocketChatActionConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RocketChatActionConfig build() {
    RocketChatActionConfig buildable = new RocketChatActionConfig(fluent.getMsg(), fluent.getText(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}