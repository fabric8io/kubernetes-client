package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelBuilder extends ChannelFluent<ChannelBuilder> implements VisitableBuilder<Channel,ChannelBuilder>{

  ChannelFluent<?> fluent;

  public ChannelBuilder() {
    this(new Channel());
  }
  
  public ChannelBuilder(ChannelFluent<?> fluent) {
    this(fluent, new Channel());
  }
  
  public ChannelBuilder(Channel instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelBuilder(ChannelFluent<?> fluent,Channel instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Channel build() {
    Channel buildable = new Channel(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}