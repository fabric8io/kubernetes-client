package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScrapeConfigSpecBuilder extends ScrapeConfigSpecFluent<ScrapeConfigSpecBuilder> implements VisitableBuilder<ScrapeConfigSpec,ScrapeConfigSpecBuilder>{

  ScrapeConfigSpecFluent<?> fluent;

  public ScrapeConfigSpecBuilder() {
    this(new ScrapeConfigSpec());
  }
  
  public ScrapeConfigSpecBuilder(ScrapeConfigSpecFluent<?> fluent) {
    this(fluent, new ScrapeConfigSpec());
  }
  
  public ScrapeConfigSpecBuilder(ScrapeConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScrapeConfigSpecBuilder(ScrapeConfigSpecFluent<?> fluent,ScrapeConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScrapeConfigSpec build() {
    ScrapeConfigSpec buildable = new ScrapeConfigSpec(fluent.buildAuthorization(), fluent.buildAzureSDConfigs(), fluent.buildBasicAuth(), fluent.getBodySizeLimit(), fluent.buildConsulSDConfigs(), fluent.getConvertClassicHistogramsToNHCB(), fluent.buildDigitalOceanSDConfigs(), fluent.buildDnsSDConfigs(), fluent.buildDockerSDConfigs(), fluent.buildDockerSwarmSDConfigs(), fluent.buildEc2SDConfigs(), fluent.getEnableCompression(), fluent.getEnableHTTP2(), fluent.buildEurekaSDConfigs(), fluent.getFallbackScrapeProtocol(), fluent.buildFileSDConfigs(), fluent.buildGceSDConfigs(), fluent.buildHetznerSDConfigs(), fluent.getHonorLabels(), fluent.getHonorTimestamps(), fluent.buildHttpSDConfigs(), fluent.buildIonosSDConfigs(), fluent.getJobName(), fluent.getKeepDroppedTargets(), fluent.buildKubernetesSDConfigs(), fluent.buildKumaSDConfigs(), fluent.getLabelLimit(), fluent.getLabelNameLengthLimit(), fluent.getLabelValueLengthLimit(), fluent.buildLightSailSDConfigs(), fluent.buildLinodeSDConfigs(), fluent.buildMetricRelabelings(), fluent.getMetricsPath(), fluent.getNameEscapingScheme(), fluent.getNameValidationScheme(), fluent.getNativeHistogramBucketLimit(), fluent.getNativeHistogramMinBucketFactor(), fluent.getNoProxy(), fluent.buildNomadSDConfigs(), fluent.buildOauth2(), fluent.buildOpenstackSDConfigs(), fluent.buildOvhcloudSDConfigs(), fluent.getParams(), fluent.getProxyConnectHeader(), fluent.getProxyFromEnvironment(), fluent.getProxyUrl(), fluent.buildPuppetDBSDConfigs(), fluent.buildRelabelings(), fluent.getSampleLimit(), fluent.buildScalewaySDConfigs(), fluent.getScheme(), fluent.getScrapeClass(), fluent.getScrapeClassicHistograms(), fluent.getScrapeInterval(), fluent.getScrapeNativeHistograms(), fluent.getScrapeProtocols(), fluent.getScrapeTimeout(), fluent.buildStaticConfigs(), fluent.getTargetLimit(), fluent.buildTlsConfig(), fluent.getTrackTimestampsStaleness());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}