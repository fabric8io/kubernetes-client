package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ThanosRulerSpecBuilder extends ThanosRulerSpecFluent<ThanosRulerSpecBuilder> implements VisitableBuilder<ThanosRulerSpec,ThanosRulerSpecBuilder>{

  ThanosRulerSpecFluent<?> fluent;

  public ThanosRulerSpecBuilder() {
    this(new ThanosRulerSpec());
  }
  
  public ThanosRulerSpecBuilder(ThanosRulerSpecFluent<?> fluent) {
    this(fluent, new ThanosRulerSpec());
  }
  
  public ThanosRulerSpecBuilder(ThanosRulerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ThanosRulerSpecBuilder(ThanosRulerSpecFluent<?> fluent,ThanosRulerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ThanosRulerSpec build() {
    ThanosRulerSpec buildable = new ThanosRulerSpec(fluent.buildAdditionalArgs(), fluent.getAffinity(), fluent.getAlertDropLabels(), fluent.getAlertQueryUrl(), fluent.getAlertRelabelConfigFile(), fluent.getAlertRelabelConfigs(), fluent.getAlertmanagersConfig(), fluent.getAlertmanagersUrl(), fluent.buildContainers(), fluent.buildDnsConfig(), fluent.getDnsPolicy(), fluent.getEnableFeatures(), fluent.getEnableServiceLinks(), fluent.getEnforcedNamespaceLabel(), fluent.getEvaluationInterval(), fluent.buildExcludedFromEnforcement(), fluent.getExternalPrefix(), fluent.buildGrpcServerTlsConfig(), fluent.buildHostAliases(), fluent.getHostUsers(), fluent.getImage(), fluent.getImagePullPolicy(), fluent.buildImagePullSecrets(), fluent.buildInitContainers(), fluent.getLabels(), fluent.getListenLocal(), fluent.getLogFormat(), fluent.getLogLevel(), fluent.getMinReadySeconds(), fluent.getNodeSelector(), fluent.getObjectStorageConfig(), fluent.getObjectStorageConfigFile(), fluent.getPaused(), fluent.getPodManagementPolicy(), fluent.buildPodMetadata(), fluent.getPortName(), fluent.getPriorityClassName(), fluent.buildPrometheusRulesExcludedFromEnforce(), fluent.getQueryConfig(), fluent.getQueryEndpoints(), fluent.buildRemoteWrite(), fluent.getReplicas(), fluent.getResendDelay(), fluent.buildResources(), fluent.getRetention(), fluent.getRoutePrefix(), fluent.getRuleConcurrentEval(), fluent.getRuleGracePeriod(), fluent.buildRuleNamespaceSelector(), fluent.getRuleOutageTolerance(), fluent.getRuleQueryOffset(), fluent.buildRuleSelector(), fluent.getSchedulerName(), fluent.getSecurityContext(), fluent.getServiceAccountName(), fluent.getServiceName(), fluent.buildStorage(), fluent.getTerminationGracePeriodSeconds(), fluent.getTolerations(), fluent.getTopologySpreadConstraints(), fluent.getTracingConfig(), fluent.getTracingConfigFile(), fluent.buildUpdateStrategy(), fluent.getVersion(), fluent.buildVolumeMounts(), fluent.buildVolumes(), fluent.buildWeb());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}