package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OVHCloudSDConfigBuilder extends OVHCloudSDConfigFluent<OVHCloudSDConfigBuilder> implements VisitableBuilder<OVHCloudSDConfig,OVHCloudSDConfigBuilder>{

  OVHCloudSDConfigFluent<?> fluent;

  public OVHCloudSDConfigBuilder() {
    this(new OVHCloudSDConfig());
  }
  
  public OVHCloudSDConfigBuilder(OVHCloudSDConfigFluent<?> fluent) {
    this(fluent, new OVHCloudSDConfig());
  }
  
  public OVHCloudSDConfigBuilder(OVHCloudSDConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OVHCloudSDConfigBuilder(OVHCloudSDConfigFluent<?> fluent,OVHCloudSDConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OVHCloudSDConfig build() {
    OVHCloudSDConfig buildable = new OVHCloudSDConfig(fluent.getApplicationKey(), fluent.getApplicationSecret(), fluent.getConsumerKey(), fluent.getEndpoint(), fluent.getRefreshInterval(), fluent.getService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}