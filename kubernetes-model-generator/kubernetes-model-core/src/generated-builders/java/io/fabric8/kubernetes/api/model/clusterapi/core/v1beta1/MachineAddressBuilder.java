package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineAddressBuilder extends MachineAddressFluent<MachineAddressBuilder> implements VisitableBuilder<MachineAddress,MachineAddressBuilder>{

  MachineAddressFluent<?> fluent;

  public MachineAddressBuilder() {
    this(new MachineAddress());
  }
  
  public MachineAddressBuilder(MachineAddressFluent<?> fluent) {
    this(fluent, new MachineAddress());
  }
  
  public MachineAddressBuilder(MachineAddress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineAddressBuilder(MachineAddressFluent<?> fluent,MachineAddress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineAddress build() {
    MachineAddress buildable = new MachineAddress(fluent.getAddress(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}