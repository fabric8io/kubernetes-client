package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ShareableCapacityStatusBuilder extends ShareableCapacityStatusFluent<ShareableCapacityStatusBuilder> implements VisitableBuilder<ShareableCapacityStatus,ShareableCapacityStatusBuilder>{

  ShareableCapacityStatusFluent<?> fluent;

  public ShareableCapacityStatusBuilder() {
    this(new ShareableCapacityStatus());
  }
  
  public ShareableCapacityStatusBuilder(ShareableCapacityStatusFluent<?> fluent) {
    this(fluent, new ShareableCapacityStatus());
  }
  
  public ShareableCapacityStatusBuilder(ShareableCapacityStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ShareableCapacityStatusBuilder(ShareableCapacityStatusFluent<?> fluent,ShareableCapacityStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ShareableCapacityStatus build() {
    ShareableCapacityStatus buildable = new ShareableCapacityStatus(fluent.getAvailable(), fluent.getConsumed(), fluent.getName(), fluent.getTotal());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}