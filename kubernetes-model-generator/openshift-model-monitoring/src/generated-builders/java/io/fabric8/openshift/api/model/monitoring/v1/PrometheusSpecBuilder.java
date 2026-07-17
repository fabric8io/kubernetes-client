package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PrometheusSpecBuilder extends PrometheusSpecFluent<PrometheusSpecBuilder> implements VisitableBuilder<PrometheusSpec,PrometheusSpecBuilder>{

  PrometheusSpecFluent<?> fluent;

  public PrometheusSpecBuilder() {
    this(new PrometheusSpec());
  }
  
  public PrometheusSpecBuilder(PrometheusSpecFluent<?> fluent) {
    this(fluent, new PrometheusSpec());
  }
  
  public PrometheusSpecBuilder(PrometheusSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PrometheusSpecBuilder(PrometheusSpecFluent<?> fluent,PrometheusSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PrometheusSpec build() {
    PrometheusSpec buildable = new PrometheusSpec(fluent.getAdditionalAlertManagerConfigs(), fluent.getAdditionalAlertRelabelConfigs(), fluent.buildAdditionalArgs(), fluent.getAdditionalScrapeConfigs(), fluent.getAffinity(), fluent.buildAlerting(), fluent.getAllowOverlappingBlocks(), fluent.buildApiserverConfig(), fluent.buildArbitraryFSAccessThroughSMs(), fluent.getAutomountServiceAccountToken(), fluent.getBaseImage(), fluent.getBodySizeLimit(), fluent.getConfigMaps(), fluent.buildContainers(), fluent.getConvertClassicHistogramsToNHCB(), fluent.getDisableCompaction(), fluent.buildDnsConfig(), fluent.getDnsPolicy(), fluent.getEnableAdminAPI(), fluent.getEnableFeatures(), fluent.getEnableOTLPReceiver(), fluent.getEnableRemoteWriteReceiver(), fluent.getEnableServiceLinks(), fluent.getEnforcedBodySizeLimit(), fluent.getEnforcedKeepDroppedTargets(), fluent.getEnforcedLabelLimit(), fluent.getEnforcedLabelNameLengthLimit(), fluent.getEnforcedLabelValueLengthLimit(), fluent.getEnforcedNamespaceLabel(), fluent.getEnforcedSampleLimit(), fluent.getEnforcedTargetLimit(), fluent.getEvaluationInterval(), fluent.buildExcludedFromEnforcement(), fluent.buildExemplars(), fluent.getExternalLabels(), fluent.getExternalUrl(), fluent.buildHostAliases(), fluent.getHostNetwork(), fluent.getHostUsers(), fluent.getIgnoreNamespaceSelectors(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.buildImagePullSecrets(), fluent.buildInitContainers(), fluent.getKeepDroppedTargets(), fluent.getLabelLimit(), fluent.getLabelNameLengthLimit(), fluent.getLabelValueLengthLimit(), fluent.getListenLocal(), fluent.getLogFormat(), fluent.getLogLevel(), fluent.getMaximumStartupDurationSeconds(), fluent.getMinReadySeconds(), fluent.getNameEscapingScheme(), fluent.getNameValidationScheme(), fluent.getNodeSelector(), fluent.buildOtlp(), fluent.getOverrideHonorLabels(), fluent.getOverrideHonorTimestamps(), fluent.getPaused(), fluent.getPersistentVolumeClaimRetentionPolicy(), fluent.getPodManagementPolicy(), fluent.buildPodMetadata(), fluent.buildPodMonitorNamespaceSelector(), fluent.buildPodMonitorSelector(), fluent.getPodTargetLabels(), fluent.getPortName(), fluent.getPriorityClassName(), fluent.buildProbeNamespaceSelector(), fluent.buildProbeSelector(), fluent.getPrometheusExternalLabelName(), fluent.buildPrometheusRulesExcludedFromEnforce(), fluent.buildQuery(), fluent.getQueryLogFile(), fluent.getReloadStrategy(), fluent.buildRemoteRead(), fluent.buildRemoteWrite(), fluent.getRemoteWriteReceiverMessageVersions(), fluent.getReplicaExternalLabelName(), fluent.getReplicas(), fluent.buildResources(), fluent.getRetention(), fluent.getRetentionSize(), fluent.getRoutePrefix(), fluent.buildRuleNamespaceSelector(), fluent.getRuleQueryOffset(), fluent.buildRuleSelector(), fluent.buildRules(), fluent.buildRuntime(), fluent.getSampleLimit(), fluent.getSchedulerName(), fluent.buildScrapeClasses(), fluent.getScrapeClassicHistograms(), fluent.buildScrapeConfigNamespaceSelector(), fluent.buildScrapeConfigSelector(), fluent.getScrapeFailureLogFile(), fluent.getScrapeInterval(), fluent.getScrapeNativeHistograms(), fluent.getScrapeProtocols(), fluent.getScrapeTimeout(), fluent.getSecrets(), fluent.getSecurityContext(), fluent.getServiceAccountName(), fluent.getServiceDiscoveryRole(), fluent.buildServiceMonitorNamespaceSelector(), fluent.buildServiceMonitorSelector(), fluent.getServiceName(), fluent.getSha(), fluent.buildShardRetentionPolicy(), fluent.buildShardingStrategy(), fluent.getShards(), fluent.buildStorage(), fluent.getTag(), fluent.getTargetLimit(), fluent.getTerminationGracePeriodSeconds(), fluent.buildThanos(), fluent.getTolerations(), fluent.buildTopologySpreadConstraints(), fluent.buildTracingConfig(), fluent.buildTsdb(), fluent.buildUpdateStrategy(), fluent.getVersion(), fluent.buildVolumeMounts(), fluent.buildVolumes(), fluent.getWalCompression(), fluent.buildWeb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}