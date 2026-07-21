package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TimespecBuilder extends TimespecFluent<TimespecBuilder> implements VisitableBuilder<Timespec,TimespecBuilder>{

  TimespecFluent<?> fluent;

  public TimespecBuilder() {
    this(new Timespec());
  }
  
  public TimespecBuilder(TimespecFluent<?> fluent) {
    this(fluent, new Timespec());
  }
  
  public TimespecBuilder(Timespec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TimespecBuilder(TimespecFluent<?> fluent,Timespec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Timespec build() {
    Timespec buildable = new Timespec(fluent.getNsec(), fluent.getSec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}