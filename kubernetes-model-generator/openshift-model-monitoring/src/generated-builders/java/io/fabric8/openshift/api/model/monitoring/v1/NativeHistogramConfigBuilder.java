package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NativeHistogramConfigBuilder extends NativeHistogramConfigFluent<NativeHistogramConfigBuilder> implements VisitableBuilder<NativeHistogramConfig,NativeHistogramConfigBuilder>{

  NativeHistogramConfigFluent<?> fluent;

  public NativeHistogramConfigBuilder() {
    this(new NativeHistogramConfig());
  }
  
  public NativeHistogramConfigBuilder(NativeHistogramConfigFluent<?> fluent) {
    this(fluent, new NativeHistogramConfig());
  }
  
  public NativeHistogramConfigBuilder(NativeHistogramConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NativeHistogramConfigBuilder(NativeHistogramConfigFluent<?> fluent,NativeHistogramConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NativeHistogramConfig build() {
    NativeHistogramConfig buildable = new NativeHistogramConfig(fluent.getConvertClassicHistogramsToNHCB(), fluent.getNativeHistogramBucketLimit(), fluent.getNativeHistogramMinBucketFactor(), fluent.getScrapeClassicHistograms(), fluent.getScrapeNativeHistograms());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}