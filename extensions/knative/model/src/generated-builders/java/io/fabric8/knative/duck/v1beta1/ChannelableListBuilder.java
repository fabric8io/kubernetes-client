package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelableListBuilder extends ChannelableListFluent<ChannelableListBuilder> implements VisitableBuilder<ChannelableList,ChannelableListBuilder>{

  ChannelableListFluent<?> fluent;

  public ChannelableListBuilder() {
    this(new ChannelableList());
  }
  
  public ChannelableListBuilder(ChannelableListFluent<?> fluent) {
    this(fluent, new ChannelableList());
  }
  
  public ChannelableListBuilder(ChannelableList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelableListBuilder(ChannelableListFluent<?> fluent,ChannelableList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelableList build() {
    ChannelableList buildable = new ChannelableList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}