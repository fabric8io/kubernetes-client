package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Layer3ConfigBuilder extends Layer3ConfigFluent<Layer3ConfigBuilder> implements VisitableBuilder<Layer3Config,Layer3ConfigBuilder>{

  Layer3ConfigFluent<?> fluent;

  public Layer3ConfigBuilder() {
    this(new Layer3Config());
  }
  
  public Layer3ConfigBuilder(Layer3ConfigFluent<?> fluent) {
    this(fluent, new Layer3Config());
  }
  
  public Layer3ConfigBuilder(Layer3Config instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Layer3ConfigBuilder(Layer3ConfigFluent<?> fluent,Layer3Config instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Layer3Config build() {
    Layer3Config buildable = new Layer3Config(fluent.getJoinSubnets(), fluent.getMtu(), fluent.getRole(), fluent.buildSubnets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}