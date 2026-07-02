package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LimitRangeListBuilder extends LimitRangeListFluent<LimitRangeListBuilder> implements VisitableBuilder<LimitRangeList,LimitRangeListBuilder>{

  LimitRangeListFluent<?> fluent;

  public LimitRangeListBuilder() {
    this(new LimitRangeList());
  }
  
  public LimitRangeListBuilder(LimitRangeListFluent<?> fluent) {
    this(fluent, new LimitRangeList());
  }
  
  public LimitRangeListBuilder(LimitRangeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LimitRangeListBuilder(LimitRangeListFluent<?> fluent,LimitRangeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LimitRangeList build() {
    LimitRangeList buildable = new LimitRangeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}