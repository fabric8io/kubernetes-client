package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PortOptsBuilder extends PortOptsFluent<PortOptsBuilder> implements VisitableBuilder<PortOpts,PortOptsBuilder>{

  PortOptsFluent<?> fluent;

  public PortOptsBuilder() {
    this(new PortOpts());
  }
  
  public PortOptsBuilder(PortOptsFluent<?> fluent) {
    this(fluent, new PortOpts());
  }
  
  public PortOptsBuilder(PortOpts instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PortOptsBuilder(PortOptsFluent<?> fluent,PortOpts instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PortOpts build() {
    PortOpts buildable = new PortOpts(fluent.getAdminStateUp(), fluent.buildAllowedAddressPairs(), fluent.getDescription(), fluent.buildFixedIPs(), fluent.getHostID(), fluent.getMacAddress(), fluent.getNameSuffix(), fluent.getNetworkID(), fluent.getPortSecurity(), fluent.getProfile(), fluent.getProjectID(), fluent.getSecurityGroups(), fluent.getTags(), fluent.getTenantID(), fluent.getTrunk(), fluent.getVnicType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}