package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HourRangeBuilder extends HourRangeFluent<HourRangeBuilder> implements VisitableBuilder<HourRange,HourRangeBuilder>{

  HourRangeFluent<?> fluent;

  public HourRangeBuilder() {
    this(new HourRange());
  }
  
  public HourRangeBuilder(HourRangeFluent<?> fluent) {
    this(fluent, new HourRange());
  }
  
  public HourRangeBuilder(HourRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HourRangeBuilder(HourRangeFluent<?> fluent,HourRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HourRange build() {
    HourRange buildable = new HourRange(fluent.getEnd(), fluent.getStart());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}