package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NICBuilder extends NICFluent<NICBuilder> implements VisitableBuilder<NIC,NICBuilder>{

  NICFluent<?> fluent;

  public NICBuilder() {
    this(new NIC());
  }
  
  public NICBuilder(NICFluent<?> fluent) {
    this(fluent, new NIC());
  }
  
  public NICBuilder(NIC instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NICBuilder(NICFluent<?> fluent,NIC instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NIC build() {
    NIC buildable = new NIC(fluent.getIp(), fluent.buildLldp(), fluent.getMac(), fluent.getModel(), fluent.getName(), fluent.getPciAddress(), fluent.getPxe(), fluent.getSpeedGbps(), fluent.getVlanId(), fluent.buildVlans());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}