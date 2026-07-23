package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SpotVMOptionsBuilder extends SpotVMOptionsFluent<SpotVMOptionsBuilder> implements VisitableBuilder<SpotVMOptions,SpotVMOptionsBuilder>{

  SpotVMOptionsFluent<?> fluent;

  public SpotVMOptionsBuilder() {
    this(new SpotVMOptions());
  }
  
  public SpotVMOptionsBuilder(SpotVMOptionsFluent<?> fluent) {
    this(fluent, new SpotVMOptions());
  }
  
  public SpotVMOptionsBuilder(SpotVMOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SpotVMOptionsBuilder(SpotVMOptionsFluent<?> fluent,SpotVMOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SpotVMOptions build() {
    SpotVMOptions buildable = new SpotVMOptions(fluent.getMaxPrice());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}