package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereFailureDomainHostGroupBuilder extends VSphereFailureDomainHostGroupFluent<VSphereFailureDomainHostGroupBuilder> implements VisitableBuilder<VSphereFailureDomainHostGroup,VSphereFailureDomainHostGroupBuilder>{

  VSphereFailureDomainHostGroupFluent<?> fluent;

  public VSphereFailureDomainHostGroupBuilder() {
    this(new VSphereFailureDomainHostGroup());
  }
  
  public VSphereFailureDomainHostGroupBuilder(VSphereFailureDomainHostGroupFluent<?> fluent) {
    this(fluent, new VSphereFailureDomainHostGroup());
  }
  
  public VSphereFailureDomainHostGroupBuilder(VSphereFailureDomainHostGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereFailureDomainHostGroupBuilder(VSphereFailureDomainHostGroupFluent<?> fluent,VSphereFailureDomainHostGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereFailureDomainHostGroup build() {
    VSphereFailureDomainHostGroup buildable = new VSphereFailureDomainHostGroup(fluent.getHostGroup(), fluent.getVmGroup(), fluent.getVmHostRule());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}