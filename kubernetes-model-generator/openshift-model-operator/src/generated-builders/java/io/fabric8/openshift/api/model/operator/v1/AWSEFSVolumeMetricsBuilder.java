package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSEFSVolumeMetricsBuilder extends AWSEFSVolumeMetricsFluent<AWSEFSVolumeMetricsBuilder> implements VisitableBuilder<AWSEFSVolumeMetrics,AWSEFSVolumeMetricsBuilder>{

  AWSEFSVolumeMetricsFluent<?> fluent;

  public AWSEFSVolumeMetricsBuilder() {
    this(new AWSEFSVolumeMetrics());
  }
  
  public AWSEFSVolumeMetricsBuilder(AWSEFSVolumeMetricsFluent<?> fluent) {
    this(fluent, new AWSEFSVolumeMetrics());
  }
  
  public AWSEFSVolumeMetricsBuilder(AWSEFSVolumeMetrics instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSEFSVolumeMetricsBuilder(AWSEFSVolumeMetricsFluent<?> fluent,AWSEFSVolumeMetrics instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSEFSVolumeMetrics build() {
    AWSEFSVolumeMetrics buildable = new AWSEFSVolumeMetrics(fluent.buildRecursiveWalk(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}