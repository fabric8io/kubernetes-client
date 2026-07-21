package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelTemplateSpecBuilder extends ChannelTemplateSpecFluent<ChannelTemplateSpecBuilder> implements VisitableBuilder<ChannelTemplateSpec,ChannelTemplateSpecBuilder>{

  ChannelTemplateSpecFluent<?> fluent;

  public ChannelTemplateSpecBuilder() {
    this(new ChannelTemplateSpec());
  }
  
  public ChannelTemplateSpecBuilder(ChannelTemplateSpecFluent<?> fluent) {
    this(fluent, new ChannelTemplateSpec());
  }
  
  public ChannelTemplateSpecBuilder(ChannelTemplateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelTemplateSpecBuilder(ChannelTemplateSpecFluent<?> fluent,ChannelTemplateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelTemplateSpec build() {
    ChannelTemplateSpec buildable = new ChannelTemplateSpec(fluent.getApiVersion(), fluent.getKind(), fluent.getSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}