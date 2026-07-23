package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelableBuilder extends ChannelableFluent<ChannelableBuilder> implements VisitableBuilder<Channelable,ChannelableBuilder>{

  ChannelableFluent<?> fluent;

  public ChannelableBuilder() {
    this(new Channelable());
  }
  
  public ChannelableBuilder(ChannelableFluent<?> fluent) {
    this(fluent, new Channelable());
  }
  
  public ChannelableBuilder(Channelable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelableBuilder(ChannelableFluent<?> fluent,Channelable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Channelable build() {
    Channelable buildable = new Channelable(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}