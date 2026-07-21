package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InMemoryChannelListBuilder extends InMemoryChannelListFluent<InMemoryChannelListBuilder> implements VisitableBuilder<InMemoryChannelList,InMemoryChannelListBuilder>{

  InMemoryChannelListFluent<?> fluent;

  public InMemoryChannelListBuilder() {
    this(new InMemoryChannelList());
  }
  
  public InMemoryChannelListBuilder(InMemoryChannelListFluent<?> fluent) {
    this(fluent, new InMemoryChannelList());
  }
  
  public InMemoryChannelListBuilder(InMemoryChannelList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InMemoryChannelListBuilder(InMemoryChannelListFluent<?> fluent,InMemoryChannelList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InMemoryChannelList build() {
    InMemoryChannelList buildable = new InMemoryChannelList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}