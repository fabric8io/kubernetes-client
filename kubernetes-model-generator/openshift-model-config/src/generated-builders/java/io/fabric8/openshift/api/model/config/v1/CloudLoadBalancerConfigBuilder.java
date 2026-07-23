package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudLoadBalancerConfigBuilder extends CloudLoadBalancerConfigFluent<CloudLoadBalancerConfigBuilder> implements VisitableBuilder<CloudLoadBalancerConfig,CloudLoadBalancerConfigBuilder>{

  CloudLoadBalancerConfigFluent<?> fluent;

  public CloudLoadBalancerConfigBuilder() {
    this(new CloudLoadBalancerConfig());
  }
  
  public CloudLoadBalancerConfigBuilder(CloudLoadBalancerConfigFluent<?> fluent) {
    this(fluent, new CloudLoadBalancerConfig());
  }
  
  public CloudLoadBalancerConfigBuilder(CloudLoadBalancerConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudLoadBalancerConfigBuilder(CloudLoadBalancerConfigFluent<?> fluent,CloudLoadBalancerConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudLoadBalancerConfig build() {
    CloudLoadBalancerConfig buildable = new CloudLoadBalancerConfig(fluent.buildClusterHosted(), fluent.getDnsType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}