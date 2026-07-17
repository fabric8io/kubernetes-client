package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSEFSVolumeMetricsRecursiveWalkConfigBuilder extends AWSEFSVolumeMetricsRecursiveWalkConfigFluent<AWSEFSVolumeMetricsRecursiveWalkConfigBuilder> implements VisitableBuilder<AWSEFSVolumeMetricsRecursiveWalkConfig,AWSEFSVolumeMetricsRecursiveWalkConfigBuilder>{

  AWSEFSVolumeMetricsRecursiveWalkConfigFluent<?> fluent;

  public AWSEFSVolumeMetricsRecursiveWalkConfigBuilder() {
    this(new AWSEFSVolumeMetricsRecursiveWalkConfig());
  }
  
  public AWSEFSVolumeMetricsRecursiveWalkConfigBuilder(AWSEFSVolumeMetricsRecursiveWalkConfigFluent<?> fluent) {
    this(fluent, new AWSEFSVolumeMetricsRecursiveWalkConfig());
  }
  
  public AWSEFSVolumeMetricsRecursiveWalkConfigBuilder(AWSEFSVolumeMetricsRecursiveWalkConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSEFSVolumeMetricsRecursiveWalkConfigBuilder(AWSEFSVolumeMetricsRecursiveWalkConfigFluent<?> fluent,AWSEFSVolumeMetricsRecursiveWalkConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSEFSVolumeMetricsRecursiveWalkConfig build() {
    AWSEFSVolumeMetricsRecursiveWalkConfig buildable = new AWSEFSVolumeMetricsRecursiveWalkConfig(fluent.getFsRateLimit(), fluent.getRefreshPeriodMinutes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}