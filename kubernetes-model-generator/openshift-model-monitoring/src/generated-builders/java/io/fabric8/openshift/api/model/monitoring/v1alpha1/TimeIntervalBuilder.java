package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeIntervalBuilder extends TimeIntervalFluent<TimeIntervalBuilder> implements VisitableBuilder<TimeInterval,TimeIntervalBuilder>{

  TimeIntervalFluent<?> fluent;

  public TimeIntervalBuilder() {
    this(new TimeInterval());
  }
  
  public TimeIntervalBuilder(TimeIntervalFluent<?> fluent) {
    this(fluent, new TimeInterval());
  }
  
  public TimeIntervalBuilder(TimeInterval instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeIntervalBuilder(TimeIntervalFluent<?> fluent,TimeInterval instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeInterval build() {
    TimeInterval buildable = new TimeInterval(fluent.buildDaysOfMonth(), fluent.getMonths(), fluent.buildTimes(), fluent.getWeekdays(), fluent.getYears());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}