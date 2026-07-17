package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RocketChatConfigBuilder extends RocketChatConfigFluent<RocketChatConfigBuilder> implements VisitableBuilder<RocketChatConfig,RocketChatConfigBuilder>{

  RocketChatConfigFluent<?> fluent;

  public RocketChatConfigBuilder() {
    this(new RocketChatConfig());
  }
  
  public RocketChatConfigBuilder(RocketChatConfigFluent<?> fluent) {
    this(fluent, new RocketChatConfig());
  }
  
  public RocketChatConfigBuilder(RocketChatConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RocketChatConfigBuilder(RocketChatConfigFluent<?> fluent,RocketChatConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RocketChatConfig build() {
    RocketChatConfig buildable = new RocketChatConfig(fluent.buildActions(), fluent.getApiURL(), fluent.getChannel(), fluent.getColor(), fluent.getEmoji(), fluent.buildFields(), fluent.buildHttpConfig(), fluent.getIconURL(), fluent.getImageURL(), fluent.getLinkNames(), fluent.getSendResolved(), fluent.getShortFields(), fluent.getText(), fluent.getThumbURL(), fluent.getTitle(), fluent.getTitleLink(), fluent.getToken(), fluent.getTokenID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}