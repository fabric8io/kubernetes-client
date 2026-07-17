package io.fabric8.openshift.api.model.miscellaneous.network.cloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudPrivateIPConfigBuilder extends CloudPrivateIPConfigFluent<CloudPrivateIPConfigBuilder> implements VisitableBuilder<CloudPrivateIPConfig,CloudPrivateIPConfigBuilder>{

  CloudPrivateIPConfigFluent<?> fluent;

  public CloudPrivateIPConfigBuilder() {
    this(new CloudPrivateIPConfig());
  }
  
  public CloudPrivateIPConfigBuilder(CloudPrivateIPConfigFluent<?> fluent) {
    this(fluent, new CloudPrivateIPConfig());
  }
  
  public CloudPrivateIPConfigBuilder(CloudPrivateIPConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudPrivateIPConfigBuilder(CloudPrivateIPConfigFluent<?> fluent,CloudPrivateIPConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudPrivateIPConfig build() {
    CloudPrivateIPConfig buildable = new CloudPrivateIPConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}