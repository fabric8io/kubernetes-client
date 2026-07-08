package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LimitRangeItemBuilder extends LimitRangeItemFluent<LimitRangeItemBuilder> implements VisitableBuilder<LimitRangeItem,LimitRangeItemBuilder>{

  LimitRangeItemFluent<?> fluent;

  public LimitRangeItemBuilder() {
    this(new LimitRangeItem());
  }
  
  public LimitRangeItemBuilder(LimitRangeItemFluent<?> fluent) {
    this(fluent, new LimitRangeItem());
  }
  
  public LimitRangeItemBuilder(LimitRangeItem instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LimitRangeItemBuilder(LimitRangeItemFluent<?> fluent,LimitRangeItem instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LimitRangeItem build() {
    LimitRangeItem buildable = new LimitRangeItem(fluent.getDefault(), fluent.getDefaultRequest(), fluent.getMax(), fluent.getMaxLimitRequestRatio(), fluent.getMin(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}