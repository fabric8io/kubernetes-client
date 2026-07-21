package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelListBuilder extends ChannelListFluent<ChannelListBuilder> implements VisitableBuilder<ChannelList,ChannelListBuilder>{

  ChannelListFluent<?> fluent;

  public ChannelListBuilder() {
    this(new ChannelList());
  }
  
  public ChannelListBuilder(ChannelListFluent<?> fluent) {
    this(fluent, new ChannelList());
  }
  
  public ChannelListBuilder(ChannelList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelListBuilder(ChannelListFluent<?> fluent,ChannelList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelList build() {
    ChannelList buildable = new ChannelList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}