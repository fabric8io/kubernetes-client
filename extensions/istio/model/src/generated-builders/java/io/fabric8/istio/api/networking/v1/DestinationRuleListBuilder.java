package io.fabric8.istio.api.networking.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DestinationRuleListBuilder extends DestinationRuleListFluent<DestinationRuleListBuilder> implements VisitableBuilder<DestinationRuleList,DestinationRuleListBuilder>{

  DestinationRuleListFluent<?> fluent;

  public DestinationRuleListBuilder() {
    this(new DestinationRuleList());
  }
  
  public DestinationRuleListBuilder(DestinationRuleListFluent<?> fluent) {
    this(fluent, new DestinationRuleList());
  }
  
  public DestinationRuleListBuilder(DestinationRuleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DestinationRuleListBuilder(DestinationRuleListFluent<?> fluent,DestinationRuleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DestinationRuleList build() {
    DestinationRuleList buildable = new DestinationRuleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}