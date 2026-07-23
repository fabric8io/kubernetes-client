package io.fabric8.knative.internal.networking.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTP01ChallengeBuilder extends HTTP01ChallengeFluent<HTTP01ChallengeBuilder> implements VisitableBuilder<HTTP01Challenge,HTTP01ChallengeBuilder>{

  HTTP01ChallengeFluent<?> fluent;

  public HTTP01ChallengeBuilder() {
    this(new HTTP01Challenge());
  }
  
  public HTTP01ChallengeBuilder(HTTP01ChallengeFluent<?> fluent) {
    this(fluent, new HTTP01Challenge());
  }
  
  public HTTP01ChallengeBuilder(HTTP01Challenge instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTP01ChallengeBuilder(HTTP01ChallengeFluent<?> fluent,HTTP01Challenge instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTP01Challenge build() {
    HTTP01Challenge buildable = new HTTP01Challenge(fluent.getServiceName(), fluent.getServiceNamespace(), fluent.buildServicePort(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}