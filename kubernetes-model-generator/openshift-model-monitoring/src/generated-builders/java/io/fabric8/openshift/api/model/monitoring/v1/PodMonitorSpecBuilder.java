package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodMonitorSpecBuilder extends PodMonitorSpecFluent<PodMonitorSpecBuilder> implements VisitableBuilder<PodMonitorSpec,PodMonitorSpecBuilder>{

  PodMonitorSpecFluent<?> fluent;

  public PodMonitorSpecBuilder() {
    this(new PodMonitorSpec());
  }
  
  public PodMonitorSpecBuilder(PodMonitorSpecFluent<?> fluent) {
    this(fluent, new PodMonitorSpec());
  }
  
  public PodMonitorSpecBuilder(PodMonitorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodMonitorSpecBuilder(PodMonitorSpecFluent<?> fluent,PodMonitorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodMonitorSpec build() {
    PodMonitorSpec buildable = new PodMonitorSpec(fluent.buildAttachMetadata(), fluent.getBodySizeLimit(), fluent.getConvertClassicHistogramsToNHCB(), fluent.getFallbackScrapeProtocol(), fluent.getJobLabel(), fluent.getKeepDroppedTargets(), fluent.getLabelLimit(), fluent.getLabelNameLengthLimit(), fluent.getLabelValueLengthLimit(), fluent.buildNamespaceSelector(), fluent.getNativeHistogramBucketLimit(), fluent.getNativeHistogramMinBucketFactor(), fluent.buildPodMetricsEndpoints(), fluent.getPodTargetLabels(), fluent.getSampleLimit(), fluent.getScrapeClass(), fluent.getScrapeClassicHistograms(), fluent.getScrapeNativeHistograms(), fluent.getScrapeProtocols(), fluent.buildSelector(), fluent.getSelectorMechanism(), fluent.getTargetLimit());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}