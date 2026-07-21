package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimeWindowBuilder extends TimeWindowFluent<TimeWindowBuilder> implements VisitableBuilder<TimeWindow,TimeWindowBuilder>{

  TimeWindowFluent<?> fluent;

  public TimeWindowBuilder() {
    this(new TimeWindow());
  }
  
  public TimeWindowBuilder(TimeWindowFluent<?> fluent) {
    this(fluent, new TimeWindow());
  }
  
  public TimeWindowBuilder(TimeWindow instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimeWindowBuilder(TimeWindowFluent<?> fluent,TimeWindow instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TimeWindow build() {
    TimeWindow buildable = new TimeWindow(fluent.getDaysofweek(), fluent.buildHours(), fluent.getLocation(), fluent.getWindowtype());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}