package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimePeriodBuilder extends TimePeriodFluent<TimePeriodBuilder> implements VisitableBuilder<TimePeriod,TimePeriodBuilder>{

  TimePeriodFluent<?> fluent;

  public TimePeriodBuilder() {
    this(new TimePeriod());
  }
  
  public TimePeriodBuilder(TimePeriodFluent<?> fluent) {
    this(fluent, new TimePeriod());
  }
  
  public TimePeriodBuilder(TimePeriod instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimePeriodBuilder(TimePeriodFluent<?> fluent,TimePeriod instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimePeriod build() {
    TimePeriod buildable = new TimePeriod(fluent.buildDaysOfMonth(), fluent.getMonths(), fluent.buildTimes(), fluent.getWeekdays(), fluent.getYears());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}