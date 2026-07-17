package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RocketChatFieldConfigBuilder extends RocketChatFieldConfigFluent<RocketChatFieldConfigBuilder> implements VisitableBuilder<RocketChatFieldConfig,RocketChatFieldConfigBuilder>{

  RocketChatFieldConfigFluent<?> fluent;

  public RocketChatFieldConfigBuilder() {
    this(new RocketChatFieldConfig());
  }
  
  public RocketChatFieldConfigBuilder(RocketChatFieldConfigFluent<?> fluent) {
    this(fluent, new RocketChatFieldConfig());
  }
  
  public RocketChatFieldConfigBuilder(RocketChatFieldConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RocketChatFieldConfigBuilder(RocketChatFieldConfigFluent<?> fluent,RocketChatFieldConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RocketChatFieldConfig build() {
    RocketChatFieldConfig buildable = new RocketChatFieldConfig(fluent.getShort(), fluent.getTitle(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}