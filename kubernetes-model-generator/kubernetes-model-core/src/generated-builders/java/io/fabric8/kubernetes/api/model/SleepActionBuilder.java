package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SleepActionBuilder extends SleepActionFluent<SleepActionBuilder> implements VisitableBuilder<SleepAction,SleepActionBuilder>{

  SleepActionFluent<?> fluent;

  public SleepActionBuilder() {
    this(new SleepAction());
  }
  
  public SleepActionBuilder(SleepActionFluent<?> fluent) {
    this(fluent, new SleepAction());
  }
  
  public SleepActionBuilder(SleepAction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SleepActionBuilder(SleepActionFluent<?> fluent,SleepAction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SleepAction build() {
    SleepAction buildable = new SleepAction(fluent.getSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}