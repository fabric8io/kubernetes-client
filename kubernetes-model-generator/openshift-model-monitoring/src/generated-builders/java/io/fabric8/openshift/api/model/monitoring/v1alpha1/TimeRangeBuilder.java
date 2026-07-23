package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeRangeBuilder extends TimeRangeFluent<TimeRangeBuilder> implements VisitableBuilder<TimeRange,TimeRangeBuilder>{

  TimeRangeFluent<?> fluent;

  public TimeRangeBuilder() {
    this(new TimeRange());
  }
  
  public TimeRangeBuilder(TimeRangeFluent<?> fluent) {
    this(fluent, new TimeRange());
  }
  
  public TimeRangeBuilder(TimeRange instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeRangeBuilder(TimeRangeFluent<?> fluent,TimeRange instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeRange build() {
    TimeRange buildable = new TimeRange(fluent.getEndTime(), fluent.getStartTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}