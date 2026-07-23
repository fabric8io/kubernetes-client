package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DiscordConfigBuilder extends DiscordConfigFluent<DiscordConfigBuilder> implements VisitableBuilder<DiscordConfig,DiscordConfigBuilder>{

  DiscordConfigFluent<?> fluent;

  public DiscordConfigBuilder() {
    this(new DiscordConfig());
  }
  
  public DiscordConfigBuilder(DiscordConfigFluent<?> fluent) {
    this(fluent, new DiscordConfig());
  }
  
  public DiscordConfigBuilder(DiscordConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DiscordConfigBuilder(DiscordConfigFluent<?> fluent,DiscordConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DiscordConfig build() {
    DiscordConfig buildable = new DiscordConfig(fluent.getApiURL(), fluent.getAvatarURL(), fluent.getContent(), fluent.buildHttpConfig(), fluent.getMessage(), fluent.getSendResolved(), fluent.getTitle(), fluent.getUsername());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}