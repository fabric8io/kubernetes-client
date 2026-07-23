package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MuteTimeIntervalBuilder extends MuteTimeIntervalFluent<MuteTimeIntervalBuilder> implements VisitableBuilder<MuteTimeInterval,MuteTimeIntervalBuilder>{

  MuteTimeIntervalFluent<?> fluent;

  public MuteTimeIntervalBuilder() {
    this(new MuteTimeInterval());
  }
  
  public MuteTimeIntervalBuilder(MuteTimeIntervalFluent<?> fluent) {
    this(fluent, new MuteTimeInterval());
  }
  
  public MuteTimeIntervalBuilder(MuteTimeInterval instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MuteTimeIntervalBuilder(MuteTimeIntervalFluent<?> fluent,MuteTimeInterval instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MuteTimeInterval build() {
    MuteTimeInterval buildable = new MuteTimeInterval(fluent.getName(), fluent.buildTimeIntervals());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}