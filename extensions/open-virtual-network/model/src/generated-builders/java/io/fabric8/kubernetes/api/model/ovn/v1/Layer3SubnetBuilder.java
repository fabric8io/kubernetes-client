package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Layer3SubnetBuilder extends Layer3SubnetFluent<Layer3SubnetBuilder> implements VisitableBuilder<Layer3Subnet,Layer3SubnetBuilder>{

  Layer3SubnetFluent<?> fluent;

  public Layer3SubnetBuilder() {
    this(new Layer3Subnet());
  }
  
  public Layer3SubnetBuilder(Layer3SubnetFluent<?> fluent) {
    this(fluent, new Layer3Subnet());
  }
  
  public Layer3SubnetBuilder(Layer3Subnet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Layer3SubnetBuilder(Layer3SubnetFluent<?> fluent,Layer3Subnet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Layer3Subnet build() {
    Layer3Subnet buildable = new Layer3Subnet(fluent.getCidr(), fluent.getHostSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}