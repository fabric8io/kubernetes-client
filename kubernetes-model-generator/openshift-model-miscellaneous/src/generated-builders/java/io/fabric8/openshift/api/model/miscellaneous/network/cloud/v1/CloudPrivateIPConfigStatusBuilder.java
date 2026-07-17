package io.fabric8.openshift.api.model.miscellaneous.network.cloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudPrivateIPConfigStatusBuilder extends CloudPrivateIPConfigStatusFluent<CloudPrivateIPConfigStatusBuilder> implements VisitableBuilder<CloudPrivateIPConfigStatus,CloudPrivateIPConfigStatusBuilder>{

  CloudPrivateIPConfigStatusFluent<?> fluent;

  public CloudPrivateIPConfigStatusBuilder() {
    this(new CloudPrivateIPConfigStatus());
  }
  
  public CloudPrivateIPConfigStatusBuilder(CloudPrivateIPConfigStatusFluent<?> fluent) {
    this(fluent, new CloudPrivateIPConfigStatus());
  }
  
  public CloudPrivateIPConfigStatusBuilder(CloudPrivateIPConfigStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudPrivateIPConfigStatusBuilder(CloudPrivateIPConfigStatusFluent<?> fluent,CloudPrivateIPConfigStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudPrivateIPConfigStatus build() {
    CloudPrivateIPConfigStatus buildable = new CloudPrivateIPConfigStatus(fluent.getConditions(), fluent.getNode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}