package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProbeSpecBuilder extends ProbeSpecFluent<ProbeSpecBuilder> implements VisitableBuilder<ProbeSpec,ProbeSpecBuilder>{

  ProbeSpecFluent<?> fluent;

  public ProbeSpecBuilder() {
    this(new ProbeSpec());
  }
  
  public ProbeSpecBuilder(ProbeSpecFluent<?> fluent) {
    this(fluent, new ProbeSpec());
  }
  
  public ProbeSpecBuilder(ProbeSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProbeSpecBuilder(ProbeSpecFluent<?> fluent,ProbeSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ProbeSpec build() {
    ProbeSpec buildable = new ProbeSpec(fluent.buildAuthorization(), fluent.buildBasicAuth(), fluent.getBearerTokenSecret(), fluent.getConvertClassicHistogramsToNHCB(), fluent.getEnableHttp2(), fluent.getFallbackScrapeProtocol(), fluent.getFollowRedirects(), fluent.getInterval(), fluent.getJobName(), fluent.getKeepDroppedTargets(), fluent.getLabelLimit(), fluent.getLabelNameLengthLimit(), fluent.getLabelValueLengthLimit(), fluent.buildMetricRelabelings(), fluent.getModule(), fluent.getNativeHistogramBucketLimit(), fluent.getNativeHistogramMinBucketFactor(), fluent.buildOauth2(), fluent.buildParams(), fluent.buildProber(), fluent.getSampleLimit(), fluent.getScrapeClass(), fluent.getScrapeClassicHistograms(), fluent.getScrapeNativeHistograms(), fluent.getScrapeProtocols(), fluent.getScrapeTimeout(), fluent.getTargetLimit(), fluent.buildTargets(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}