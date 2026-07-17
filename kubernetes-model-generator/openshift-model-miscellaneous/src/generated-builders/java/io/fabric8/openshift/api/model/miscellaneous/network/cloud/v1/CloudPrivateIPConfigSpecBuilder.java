package io.fabric8.openshift.api.model.miscellaneous.network.cloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudPrivateIPConfigSpecBuilder extends CloudPrivateIPConfigSpecFluent<CloudPrivateIPConfigSpecBuilder> implements VisitableBuilder<CloudPrivateIPConfigSpec,CloudPrivateIPConfigSpecBuilder>{

  CloudPrivateIPConfigSpecFluent<?> fluent;

  public CloudPrivateIPConfigSpecBuilder() {
    this(new CloudPrivateIPConfigSpec());
  }
  
  public CloudPrivateIPConfigSpecBuilder(CloudPrivateIPConfigSpecFluent<?> fluent) {
    this(fluent, new CloudPrivateIPConfigSpec());
  }
  
  public CloudPrivateIPConfigSpecBuilder(CloudPrivateIPConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudPrivateIPConfigSpecBuilder(CloudPrivateIPConfigSpecFluent<?> fluent,CloudPrivateIPConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudPrivateIPConfigSpec build() {
    CloudPrivateIPConfigSpec buildable = new CloudPrivateIPConfigSpec(fluent.getNode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}