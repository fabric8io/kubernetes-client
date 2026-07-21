package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MultiClusterObservabilitySpecBuilder extends MultiClusterObservabilitySpecFluent<MultiClusterObservabilitySpecBuilder> implements VisitableBuilder<MultiClusterObservabilitySpec,MultiClusterObservabilitySpecBuilder>{

  MultiClusterObservabilitySpecFluent<?> fluent;

  public MultiClusterObservabilitySpecBuilder() {
    this(new MultiClusterObservabilitySpec());
  }
  
  public MultiClusterObservabilitySpecBuilder(MultiClusterObservabilitySpecFluent<?> fluent) {
    this(fluent, new MultiClusterObservabilitySpec());
  }
  
  public MultiClusterObservabilitySpecBuilder(MultiClusterObservabilitySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MultiClusterObservabilitySpecBuilder(MultiClusterObservabilitySpecFluent<?> fluent,MultiClusterObservabilitySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MultiClusterObservabilitySpec build() {
    MultiClusterObservabilitySpec buildable = new MultiClusterObservabilitySpec(fluent.getAvailabilityConfig(), fluent.getEnableDownSampling(), fluent.getImagePullPolicy(), fluent.getImagePullSecret(), fluent.getNodeSelector(), fluent.buildObservabilityAddonSpec(), fluent.getRetentionResolution1h(), fluent.getRetentionResolution5m(), fluent.getRetentionResolutionRaw(), fluent.buildStorageConfigObject(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}