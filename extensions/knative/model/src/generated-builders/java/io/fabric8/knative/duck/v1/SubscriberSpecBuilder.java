package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SubscriberSpecBuilder extends SubscriberSpecFluent<SubscriberSpecBuilder> implements VisitableBuilder<SubscriberSpec,SubscriberSpecBuilder>{

  SubscriberSpecFluent<?> fluent;

  public SubscriberSpecBuilder() {
    this(new SubscriberSpec());
  }
  
  public SubscriberSpecBuilder(SubscriberSpecFluent<?> fluent) {
    this(fluent, new SubscriberSpec());
  }
  
  public SubscriberSpecBuilder(SubscriberSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SubscriberSpecBuilder(SubscriberSpecFluent<?> fluent,SubscriberSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SubscriberSpec build() {
    SubscriberSpec buildable = new SubscriberSpec(fluent.buildAuth(), fluent.buildDelivery(), fluent.getGeneration(), fluent.getName(), fluent.getReplyAudience(), fluent.getReplyCACerts(), fluent.getReplyUri(), fluent.getSubscriberAudience(), fluent.getSubscriberCACerts(), fluent.getSubscriberUri(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}