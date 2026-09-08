package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ShareableSummaryStatusBuilder extends ShareableSummaryStatusFluent<ShareableSummaryStatusBuilder> implements VisitableBuilder<ShareableSummaryStatus,ShareableSummaryStatusBuilder>{

  ShareableSummaryStatusFluent<?> fluent;

  public ShareableSummaryStatusBuilder() {
    this(new ShareableSummaryStatus());
  }
  
  public ShareableSummaryStatusBuilder(ShareableSummaryStatusFluent<?> fluent) {
    this(fluent, new ShareableSummaryStatus());
  }
  
  public ShareableSummaryStatusBuilder(ShareableSummaryStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ShareableSummaryStatusBuilder(ShareableSummaryStatusFluent<?> fluent,ShareableSummaryStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ShareableSummaryStatus build() {
    ShareableSummaryStatus buildable = new ShareableSummaryStatus(fluent.buildCapacity(), fluent.getFullyAvailableDevices(), fluent.getPartiallyAvailableDevices());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}