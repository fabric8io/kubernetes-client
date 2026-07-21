package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSS3Builder extends AWSS3Fluent<AWSS3Builder> implements VisitableBuilder<AWSS3,AWSS3Builder>{

  AWSS3Fluent<?> fluent;

  public AWSS3Builder() {
    this(new AWSS3());
  }
  
  public AWSS3Builder(AWSS3Fluent<?> fluent) {
    this(fluent, new AWSS3());
  }
  
  public AWSS3Builder(AWSS3 instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSS3Builder(AWSS3Fluent<?> fluent,AWSS3 instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSS3 build() {
    AWSS3 buildable = new AWSS3(fluent.getArn(), fluent.getAutoCreateBucket(), fluent.getDelay(), fluent.getDeleteAfterRead(), fluent.getDestinationBucket(), fluent.getDestinationBucketPrefix(), fluent.getDestinationBucketSuffix(), fluent.getForcePathStyle(), fluent.getIgnoreBody(), fluent.getMaxMessagesPerPoll(), fluent.getMoveAfterRead(), fluent.getOverrideEndpoint(), fluent.getPrefix(), fluent.getRegion(), fluent.getUriEndpointOverride());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}