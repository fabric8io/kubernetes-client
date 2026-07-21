package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Layer2ConfigBuilder extends Layer2ConfigFluent<Layer2ConfigBuilder> implements VisitableBuilder<Layer2Config,Layer2ConfigBuilder>{

  Layer2ConfigFluent<?> fluent;

  public Layer2ConfigBuilder() {
    this(new Layer2Config());
  }
  
  public Layer2ConfigBuilder(Layer2ConfigFluent<?> fluent) {
    this(fluent, new Layer2Config());
  }
  
  public Layer2ConfigBuilder(Layer2Config instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Layer2ConfigBuilder(Layer2ConfigFluent<?> fluent,Layer2Config instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Layer2Config build() {
    Layer2Config buildable = new Layer2Config(fluent.getIpamLifecycle(), fluent.getJoinSubnets(), fluent.getMtu(), fluent.getRole(), fluent.getSubnets());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}