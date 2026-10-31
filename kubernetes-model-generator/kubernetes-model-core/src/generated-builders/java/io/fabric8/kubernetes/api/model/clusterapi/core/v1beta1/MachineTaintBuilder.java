package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineTaintBuilder extends MachineTaintFluent<MachineTaintBuilder> implements VisitableBuilder<MachineTaint,MachineTaintBuilder>{

  MachineTaintFluent<?> fluent;

  public MachineTaintBuilder() {
    this(new MachineTaint());
  }
  
  public MachineTaintBuilder(MachineTaintFluent<?> fluent) {
    this(fluent, new MachineTaint());
  }
  
  public MachineTaintBuilder(MachineTaint instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineTaintBuilder(MachineTaintFluent<?> fluent,MachineTaint instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineTaint build() {
    MachineTaint buildable = new MachineTaint(fluent.getEffect(), fluent.getKey(), fluent.getPropagation(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}