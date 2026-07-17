package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DayOfMonthRangeBuilder extends DayOfMonthRangeFluent<DayOfMonthRangeBuilder> implements VisitableBuilder<DayOfMonthRange,DayOfMonthRangeBuilder>{

  DayOfMonthRangeFluent<?> fluent;

  public DayOfMonthRangeBuilder() {
    this(new DayOfMonthRange());
  }
  
  public DayOfMonthRangeBuilder(DayOfMonthRangeFluent<?> fluent) {
    this(fluent, new DayOfMonthRange());
  }
  
  public DayOfMonthRangeBuilder(DayOfMonthRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DayOfMonthRangeBuilder(DayOfMonthRangeFluent<?> fluent,DayOfMonthRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DayOfMonthRange build() {
    DayOfMonthRange buildable = new DayOfMonthRange(fluent.getEnd(), fluent.getStart());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}