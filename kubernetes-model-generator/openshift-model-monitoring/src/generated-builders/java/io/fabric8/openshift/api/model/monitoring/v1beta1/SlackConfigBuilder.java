package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SlackConfigBuilder extends SlackConfigFluent<SlackConfigBuilder> implements VisitableBuilder<SlackConfig,SlackConfigBuilder>{

  SlackConfigFluent<?> fluent;

  public SlackConfigBuilder() {
    this(new SlackConfig());
  }
  
  public SlackConfigBuilder(SlackConfigFluent<?> fluent) {
    this(fluent, new SlackConfig());
  }
  
  public SlackConfigBuilder(SlackConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SlackConfigBuilder(SlackConfigFluent<?> fluent,SlackConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SlackConfig build() {
    SlackConfig buildable = new SlackConfig(fluent.buildActions(), fluent.buildApiURL(), fluent.getCallbackId(), fluent.getChannel(), fluent.getColor(), fluent.getFallback(), fluent.buildFields(), fluent.getFooter(), fluent.buildHttpConfig(), fluent.getIconEmoji(), fluent.getIconURL(), fluent.getImageURL(), fluent.getLinkNames(), fluent.getMessageText(), fluent.getMrkdwnIn(), fluent.getPretext(), fluent.getSendResolved(), fluent.getShortFields(), fluent.getText(), fluent.getThumbURL(), fluent.getTimeout(), fluent.getTitle(), fluent.getTitleLink(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}