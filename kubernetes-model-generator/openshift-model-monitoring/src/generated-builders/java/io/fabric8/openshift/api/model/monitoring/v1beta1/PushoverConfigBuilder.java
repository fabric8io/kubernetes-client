package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PushoverConfigBuilder extends PushoverConfigFluent<PushoverConfigBuilder> implements VisitableBuilder<PushoverConfig,PushoverConfigBuilder>{

  PushoverConfigFluent<?> fluent;

  public PushoverConfigBuilder() {
    this(new PushoverConfig());
  }
  
  public PushoverConfigBuilder(PushoverConfigFluent<?> fluent) {
    this(fluent, new PushoverConfig());
  }
  
  public PushoverConfigBuilder(PushoverConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PushoverConfigBuilder(PushoverConfigFluent<?> fluent,PushoverConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PushoverConfig build() {
    PushoverConfig buildable = new PushoverConfig(fluent.getDevice(), fluent.getExpire(), fluent.getHtml(), fluent.buildHttpConfig(), fluent.getMessage(), fluent.getMonospace(), fluent.getPriority(), fluent.getRetry(), fluent.getSendResolved(), fluent.getSound(), fluent.getTitle(), fluent.buildToken(), fluent.getTokenFile(), fluent.getTtl(), fluent.getUrl(), fluent.getUrlTitle(), fluent.buildUserKey(), fluent.getUserKeyFile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}