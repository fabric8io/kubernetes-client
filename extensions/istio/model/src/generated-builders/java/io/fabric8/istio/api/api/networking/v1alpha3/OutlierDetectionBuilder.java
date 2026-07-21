package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OutlierDetectionBuilder extends OutlierDetectionFluent<OutlierDetectionBuilder> implements VisitableBuilder<OutlierDetection,OutlierDetectionBuilder>{

  OutlierDetectionFluent<?> fluent;

  public OutlierDetectionBuilder() {
    this(new OutlierDetection());
  }
  
  public OutlierDetectionBuilder(OutlierDetectionFluent<?> fluent) {
    this(fluent, new OutlierDetection());
  }
  
  public OutlierDetectionBuilder(OutlierDetection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OutlierDetectionBuilder(OutlierDetectionFluent<?> fluent,OutlierDetection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OutlierDetection build() {
    OutlierDetection buildable = new OutlierDetection(fluent.getBaseEjectionTime(), fluent.getConsecutive5xxErrors(), fluent.getConsecutiveErrors(), fluent.getConsecutiveGatewayErrors(), fluent.getConsecutiveLocalOriginFailures(), fluent.getInterval(), fluent.getMaxEjectionPercent(), fluent.getMinHealthPercent(), fluent.getSplitExternalLocalOriginErrors());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}