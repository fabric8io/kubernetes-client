package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MicroTimeBuilder extends MicroTimeFluent<MicroTimeBuilder> implements VisitableBuilder<MicroTime,MicroTimeBuilder>{

  MicroTimeFluent<?> fluent;

  public MicroTimeBuilder() {
    this(new MicroTime());
  }
  
  public MicroTimeBuilder(MicroTimeFluent<?> fluent) {
    this(fluent, new MicroTime());
  }
  
  public MicroTimeBuilder(MicroTime instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MicroTimeBuilder(MicroTimeFluent<?> fluent,MicroTime instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MicroTime build() {
    MicroTime buildable = new MicroTime(fluent.getTime());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}