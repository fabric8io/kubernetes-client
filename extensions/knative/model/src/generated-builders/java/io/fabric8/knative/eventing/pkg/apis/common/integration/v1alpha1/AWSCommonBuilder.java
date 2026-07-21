package io.fabric8.knative.eventing.pkg.apis.common.integration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSCommonBuilder extends AWSCommonFluent<AWSCommonBuilder> implements VisitableBuilder<AWSCommon,AWSCommonBuilder>{

  AWSCommonFluent<?> fluent;

  public AWSCommonBuilder() {
    this(new AWSCommon());
  }
  
  public AWSCommonBuilder(AWSCommonFluent<?> fluent) {
    this(fluent, new AWSCommon());
  }
  
  public AWSCommonBuilder(AWSCommon instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSCommonBuilder(AWSCommonFluent<?> fluent,AWSCommon instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSCommon build() {
    AWSCommon buildable = new AWSCommon(fluent.getOverrideEndpoint(), fluent.getRegion(), fluent.getUriEndpointOverride());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}