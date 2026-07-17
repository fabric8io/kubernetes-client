package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudLoadBalancerIPsBuilder extends CloudLoadBalancerIPsFluent<CloudLoadBalancerIPsBuilder> implements VisitableBuilder<CloudLoadBalancerIPs,CloudLoadBalancerIPsBuilder>{

  CloudLoadBalancerIPsFluent<?> fluent;

  public CloudLoadBalancerIPsBuilder() {
    this(new CloudLoadBalancerIPs());
  }
  
  public CloudLoadBalancerIPsBuilder(CloudLoadBalancerIPsFluent<?> fluent) {
    this(fluent, new CloudLoadBalancerIPs());
  }
  
  public CloudLoadBalancerIPsBuilder(CloudLoadBalancerIPs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudLoadBalancerIPsBuilder(CloudLoadBalancerIPsFluent<?> fluent,CloudLoadBalancerIPs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudLoadBalancerIPs build() {
    CloudLoadBalancerIPs buildable = new CloudLoadBalancerIPs(fluent.getApiIntLoadBalancerIPs(), fluent.getApiLoadBalancerIPs(), fluent.getIngressLoadBalancerIPs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}