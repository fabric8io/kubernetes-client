package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSSNSBuilder extends AWSSNSFluent<AWSSNSBuilder> implements VisitableBuilder<AWSSNS,AWSSNSBuilder>{

  AWSSNSFluent<?> fluent;

  public AWSSNSBuilder() {
    this(new AWSSNS());
  }
  
  public AWSSNSBuilder(AWSSNSFluent<?> fluent) {
    this(fluent, new AWSSNS());
  }
  
  public AWSSNSBuilder(AWSSNS instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSSNSBuilder(AWSSNSFluent<?> fluent,AWSSNS instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSSNS build() {
    AWSSNS buildable = new AWSSNS(fluent.getArn(), fluent.getAutoCreateTopic(), fluent.getOverrideEndpoint(), fluent.getRegion(), fluent.getUriEndpointOverride());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}