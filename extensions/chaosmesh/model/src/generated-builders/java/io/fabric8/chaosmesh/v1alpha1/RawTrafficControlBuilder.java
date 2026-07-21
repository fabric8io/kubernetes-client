package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RawTrafficControlBuilder extends RawTrafficControlFluent<RawTrafficControlBuilder> implements VisitableBuilder<RawTrafficControl,RawTrafficControlBuilder>{

  RawTrafficControlFluent<?> fluent;

  public RawTrafficControlBuilder() {
    this(new RawTrafficControl());
  }
  
  public RawTrafficControlBuilder(RawTrafficControlFluent<?> fluent) {
    this(fluent, new RawTrafficControl());
  }
  
  public RawTrafficControlBuilder(RawTrafficControl instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RawTrafficControlBuilder(RawTrafficControlFluent<?> fluent,RawTrafficControl instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RawTrafficControl build() {
    RawTrafficControl buildable = new RawTrafficControl(fluent.buildBandwidth(), fluent.buildCorrupt(), fluent.buildDelay(), fluent.getDevice(), fluent.buildDuplicate(), fluent.getIpset(), fluent.buildLoss(), fluent.buildRate(), fluent.getSource(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}