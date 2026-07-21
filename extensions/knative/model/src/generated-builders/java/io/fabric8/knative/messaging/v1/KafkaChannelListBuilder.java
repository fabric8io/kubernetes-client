package io.fabric8.knative.messaging.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KafkaChannelListBuilder extends KafkaChannelListFluent<KafkaChannelListBuilder> implements VisitableBuilder<KafkaChannelList,KafkaChannelListBuilder>{

  KafkaChannelListFluent<?> fluent;

  public KafkaChannelListBuilder() {
    this(new KafkaChannelList());
  }
  
  public KafkaChannelListBuilder(KafkaChannelListFluent<?> fluent) {
    this(fluent, new KafkaChannelList());
  }
  
  public KafkaChannelListBuilder(KafkaChannelList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KafkaChannelListBuilder(KafkaChannelListFluent<?> fluent,KafkaChannelList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KafkaChannelList build() {
    KafkaChannelList buildable = new KafkaChannelList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}