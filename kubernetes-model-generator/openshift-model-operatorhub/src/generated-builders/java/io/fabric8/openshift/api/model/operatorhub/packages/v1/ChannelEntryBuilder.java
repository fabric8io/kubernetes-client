package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChannelEntryBuilder extends ChannelEntryFluent<ChannelEntryBuilder> implements VisitableBuilder<ChannelEntry,ChannelEntryBuilder>{

  ChannelEntryFluent<?> fluent;

  public ChannelEntryBuilder() {
    this(new ChannelEntry());
  }
  
  public ChannelEntryBuilder(ChannelEntryFluent<?> fluent) {
    this(fluent, new ChannelEntry());
  }
  
  public ChannelEntryBuilder(ChannelEntry instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChannelEntryBuilder(ChannelEntryFluent<?> fluent,ChannelEntry instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChannelEntry build() {
    ChannelEntry buildable = new ChannelEntry(fluent.buildDeprecation(), fluent.getName(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}