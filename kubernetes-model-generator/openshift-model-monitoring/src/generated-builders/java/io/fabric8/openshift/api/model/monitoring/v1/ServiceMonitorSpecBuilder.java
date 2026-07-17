package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ServiceMonitorSpecBuilder extends ServiceMonitorSpecFluent<ServiceMonitorSpecBuilder> implements VisitableBuilder<ServiceMonitorSpec,ServiceMonitorSpecBuilder>{

  ServiceMonitorSpecFluent<?> fluent;

  public ServiceMonitorSpecBuilder() {
    this(new ServiceMonitorSpec());
  }
  
  public ServiceMonitorSpecBuilder(ServiceMonitorSpecFluent<?> fluent) {
    this(fluent, new ServiceMonitorSpec());
  }
  
  public ServiceMonitorSpecBuilder(ServiceMonitorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ServiceMonitorSpecBuilder(ServiceMonitorSpecFluent<?> fluent,ServiceMonitorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ServiceMonitorSpec build() {
    ServiceMonitorSpec buildable = new ServiceMonitorSpec(fluent.buildAttachMetadata(), fluent.getBodySizeLimit(), fluent.getConvertClassicHistogramsToNHCB(), fluent.buildEndpoints(), fluent.getFallbackScrapeProtocol(), fluent.getJobLabel(), fluent.getKeepDroppedTargets(), fluent.getLabelLimit(), fluent.getLabelNameLengthLimit(), fluent.getLabelValueLengthLimit(), fluent.buildNamespaceSelector(), fluent.getNativeHistogramBucketLimit(), fluent.getNativeHistogramMinBucketFactor(), fluent.getPodTargetLabels(), fluent.getSampleLimit(), fluent.getScrapeClass(), fluent.getScrapeClassicHistograms(), fluent.getScrapeNativeHistograms(), fluent.getScrapeProtocols(), fluent.buildSelector(), fluent.getSelectorMechanism(), fluent.getServiceDiscoveryRole(), fluent.getTargetLabels(), fluent.getTargetLimit());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}