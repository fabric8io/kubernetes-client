package io.fabric8.openshift.api.model.miscellaneous.network.cloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudPrivateIPConfigListBuilder extends CloudPrivateIPConfigListFluent<CloudPrivateIPConfigListBuilder> implements VisitableBuilder<CloudPrivateIPConfigList,CloudPrivateIPConfigListBuilder>{

  CloudPrivateIPConfigListFluent<?> fluent;

  public CloudPrivateIPConfigListBuilder() {
    this(new CloudPrivateIPConfigList());
  }
  
  public CloudPrivateIPConfigListBuilder(CloudPrivateIPConfigListFluent<?> fluent) {
    this(fluent, new CloudPrivateIPConfigList());
  }
  
  public CloudPrivateIPConfigListBuilder(CloudPrivateIPConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudPrivateIPConfigListBuilder(CloudPrivateIPConfigListFluent<?> fluent,CloudPrivateIPConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudPrivateIPConfigList build() {
    CloudPrivateIPConfigList buildable = new CloudPrivateIPConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}