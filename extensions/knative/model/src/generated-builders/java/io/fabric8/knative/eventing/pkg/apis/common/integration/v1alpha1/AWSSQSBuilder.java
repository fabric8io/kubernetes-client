package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSSQSBuilder extends AWSSQSFluent<AWSSQSBuilder> implements VisitableBuilder<AWSSQS,AWSSQSBuilder>{

  AWSSQSFluent<?> fluent;

  public AWSSQSBuilder() {
    this(new AWSSQS());
  }
  
  public AWSSQSBuilder(AWSSQSFluent<?> fluent) {
    this(fluent, new AWSSQS());
  }
  
  public AWSSQSBuilder(AWSSQS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSSQSBuilder(AWSSQSFluent<?> fluent,AWSSQS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSSQS build() {
    AWSSQS buildable = new AWSSQS(fluent.getArn(), fluent.getAutoCreateQueue(), fluent.getDelay(), fluent.getDeleteAfterRead(), fluent.getGreedy(), fluent.getHost(), fluent.getMaxMessagesPerPoll(), fluent.getOverrideEndpoint(), fluent.getProtocol(), fluent.getQueueURL(), fluent.getRegion(), fluent.getUriEndpointOverride(), fluent.getVisibilityTimeout(), fluent.getWaitTimeSeconds());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}