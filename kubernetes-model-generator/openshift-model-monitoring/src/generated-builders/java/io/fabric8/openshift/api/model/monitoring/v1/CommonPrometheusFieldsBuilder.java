package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CommonPrometheusFieldsBuilder extends CommonPrometheusFieldsFluent<CommonPrometheusFieldsBuilder> implements VisitableBuilder<CommonPrometheusFields,CommonPrometheusFieldsBuilder>{

  CommonPrometheusFieldsFluent<?> fluent;

  public CommonPrometheusFieldsBuilder() {
    this(new CommonPrometheusFields());
  }
  
  public CommonPrometheusFieldsBuilder(CommonPrometheusFieldsFluent<?> fluent) {
    this(fluent, new CommonPrometheusFields());
  }
  
  public CommonPrometheusFieldsBuilder(CommonPrometheusFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CommonPrometheusFieldsBuilder(CommonPrometheusFieldsFluent<?> fluent,CommonPrometheusFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CommonPrometheusFields build() {
    CommonPrometheusFields buildable = new CommonPrometheusFields(fluent.buildAdditionalArgs(), fluent.getAdditionalScrapeConfigs(), fluent.getAffinity(), fluent.buildApiserverConfig(), fluent.buildArbitraryFSAccessThroughSMs(), fluent.getAutomountServiceAccountToken(), fluent.getBodySizeLimit(), fluent.getConfigMaps(), fluent.buildContainers(), fluent.getConvertClassicHistogramsToNHCB(), fluent.buildDnsConfig(), fluent.getDnsPolicy(), fluent.getEnableFeatures(), fluent.getEnableOTLPReceiver(), fluent.getEnableRemoteWriteReceiver(), fluent.getEnableServiceLinks(), fluent.getEnforcedBodySizeLimit(), fluent.getEnforcedKeepDroppedTargets(), fluent.getEnforcedLabelLimit(), fluent.getEnforcedLabelNameLengthLimit(), fluent.getEnforcedLabelValueLengthLimit(), fluent.getEnforcedNamespaceLabel(), fluent.getEnforcedSampleLimit(), fluent.getEnforcedTargetLimit(), fluent.buildExcludedFromEnforcement(), fluent.getExternalLabels(), fluent.getExternalUrl(), fluent.buildHostAliases(), fluent.getHostNetwork(), fluent.getHostUsers(), fluent.getIgnoreNamespaceSelectors(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.buildImagePullSecrets(), fluent.buildInitContainers(), fluent.getKeepDroppedTargets(), fluent.getLabelLimit(), fluent.getLabelNameLengthLimit(), fluent.getLabelValueLengthLimit(), fluent.getListenLocal(), fluent.getLogFormat(), fluent.getLogLevel(), fluent.getMaximumStartupDurationSeconds(), fluent.getMinReadySeconds(), fluent.getNameEscapingScheme(), fluent.getNameValidationScheme(), fluent.getNodeSelector(), fluent.buildOtlp(), fluent.getOverrideHonorLabels(), fluent.getOverrideHonorTimestamps(), fluent.getPaused(), fluent.getPersistentVolumeClaimRetentionPolicy(), fluent.getPodManagementPolicy(), fluent.buildPodMetadata(), fluent.buildPodMonitorNamespaceSelector(), fluent.buildPodMonitorSelector(), fluent.getPodTargetLabels(), fluent.getPortName(), fluent.getPriorityClassName(), fluent.buildProbeNamespaceSelector(), fluent.buildProbeSelector(), fluent.getPrometheusExternalLabelName(), fluent.getReloadStrategy(), fluent.buildRemoteWrite(), fluent.getRemoteWriteReceiverMessageVersions(), fluent.getReplicaExternalLabelName(), fluent.getReplicas(), fluent.buildResources(), fluent.getRoutePrefix(), fluent.buildRuntime(), fluent.getSampleLimit(), fluent.getSchedulerName(), fluent.buildScrapeClasses(), fluent.getScrapeClassicHistograms(), fluent.buildScrapeConfigNamespaceSelector(), fluent.buildScrapeConfigSelector(), fluent.getScrapeFailureLogFile(), fluent.getScrapeInterval(), fluent.getScrapeNativeHistograms(), fluent.getScrapeProtocols(), fluent.getScrapeTimeout(), fluent.getSecrets(), fluent.getSecurityContext(), fluent.getServiceAccountName(), fluent.getServiceDiscoveryRole(), fluent.buildServiceMonitorNamespaceSelector(), fluent.buildServiceMonitorSelector(), fluent.getServiceName(), fluent.buildShardingStrategy(), fluent.getShards(), fluent.buildStorage(), fluent.getTargetLimit(), fluent.getTerminationGracePeriodSeconds(), fluent.getTolerations(), fluent.buildTopologySpreadConstraints(), fluent.buildTracingConfig(), fluent.buildTsdb(), fluent.buildUpdateStrategy(), fluent.getVersion(), fluent.buildVolumeMounts(), fluent.buildVolumes(), fluent.getWalCompression(), fluent.buildWeb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}