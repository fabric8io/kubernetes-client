package io.fabric8.knative.sources.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimerBuilder extends TimerFluent<TimerBuilder> implements VisitableBuilder<Timer,TimerBuilder>{

  TimerFluent<?> fluent;

  public TimerBuilder() {
    this(new Timer());
  }
  
  public TimerBuilder(TimerFluent<?> fluent) {
    this(fluent, new Timer());
  }
  
  public TimerBuilder(Timer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimerBuilder(TimerFluent<?> fluent,Timer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Timer build() {
    Timer buildable = new Timer(fluent.getContentType(), fluent.getMessage(), fluent.getPeriod(), fluent.getRepeatCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}