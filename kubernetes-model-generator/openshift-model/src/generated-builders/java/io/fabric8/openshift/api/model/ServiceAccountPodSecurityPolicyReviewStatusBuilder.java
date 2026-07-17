package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceAccountPodSecurityPolicyReviewStatusBuilder extends ServiceAccountPodSecurityPolicyReviewStatusFluent<ServiceAccountPodSecurityPolicyReviewStatusBuilder> implements VisitableBuilder<ServiceAccountPodSecurityPolicyReviewStatus,ServiceAccountPodSecurityPolicyReviewStatusBuilder>{

  ServiceAccountPodSecurityPolicyReviewStatusFluent<?> fluent;

  public ServiceAccountPodSecurityPolicyReviewStatusBuilder() {
    this(new ServiceAccountPodSecurityPolicyReviewStatus());
  }
  
  public ServiceAccountPodSecurityPolicyReviewStatusBuilder(ServiceAccountPodSecurityPolicyReviewStatusFluent<?> fluent) {
    this(fluent, new ServiceAccountPodSecurityPolicyReviewStatus());
  }
  
  public ServiceAccountPodSecurityPolicyReviewStatusBuilder(ServiceAccountPodSecurityPolicyReviewStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceAccountPodSecurityPolicyReviewStatusBuilder(ServiceAccountPodSecurityPolicyReviewStatusFluent<?> fluent,ServiceAccountPodSecurityPolicyReviewStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceAccountPodSecurityPolicyReviewStatus build() {
    ServiceAccountPodSecurityPolicyReviewStatus buildable = new ServiceAccountPodSecurityPolicyReviewStatus(fluent.buildAllowedBy(), fluent.getName(), fluent.getReason(), fluent.buildTemplate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}