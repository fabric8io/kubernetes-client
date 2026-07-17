package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerFluent;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeFluent;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.VolumeMountBuilder;
import io.fabric8.kubernetes.api.model.VolumeMountFluent;
import io.fabric8.kubernetes.api.model.apps.StatefulSetPersistentVolumeClaimRetentionPolicy;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PrometheusSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.PrometheusSpecFluent<A>> extends BaseFluent<A>{

  private SecretKeySelector additionalAlertManagerConfigs;
  private SecretKeySelector additionalAlertRelabelConfigs;
  private ArrayList<ArgumentBuilder> additionalArgs = new ArrayList<ArgumentBuilder>();
  private Map<String,Object> additionalProperties;
  private SecretKeySelector additionalScrapeConfigs;
  private Affinity affinity;
  private AlertingSpecBuilder alerting;
  private Boolean allowOverlappingBlocks;
  private APIServerConfigBuilder apiserverConfig;
  private ArbitraryFSAccessThroughSMsConfigBuilder arbitraryFSAccessThroughSMs;
  private Boolean automountServiceAccountToken;
  private String baseImage;
  private String bodySizeLimit;
  private List<String> configMaps = new ArrayList<String>();
  private ArrayList<ContainerBuilder> containers = new ArrayList<ContainerBuilder>();
  private Boolean convertClassicHistogramsToNHCB;
  private Boolean disableCompaction;
  private PodDNSConfigBuilder dnsConfig;
  private String dnsPolicy;
  private Boolean enableAdminAPI;
  private List<String> enableFeatures = new ArrayList<String>();
  private Boolean enableOTLPReceiver;
  private Boolean enableRemoteWriteReceiver;
  private Boolean enableServiceLinks;
  private String enforcedBodySizeLimit;
  private Long enforcedKeepDroppedTargets;
  private Long enforcedLabelLimit;
  private Long enforcedLabelNameLengthLimit;
  private Long enforcedLabelValueLengthLimit;
  private String enforcedNamespaceLabel;
  private Long enforcedSampleLimit;
  private Long enforcedTargetLimit;
  private String evaluationInterval;
  private ArrayList<ObjectReferenceBuilder> excludedFromEnforcement = new ArrayList<ObjectReferenceBuilder>();
  private ExemplarsBuilder exemplars;
  private Map<String,String> externalLabels;
  private String externalUrl;
  private ArrayList<HostAliasBuilder> hostAliases = new ArrayList<HostAliasBuilder>();
  private Boolean hostNetwork;
  private Boolean hostUsers;
  private Boolean ignoreNamespaceSelectors;
  private String image;
  private String imagePullPolicy;
  private ArrayList<LocalObjectReferenceBuilder> imagePullSecrets = new ArrayList<LocalObjectReferenceBuilder>();
  private ArrayList<ContainerBuilder> initContainers = new ArrayList<ContainerBuilder>();
  private Long keepDroppedTargets;
  private Long labelLimit;
  private Long labelNameLengthLimit;
  private Long labelValueLengthLimit;
  private Boolean listenLocal;
  private String logFormat;
  private String logLevel;
  private Integer maximumStartupDurationSeconds;
  private Integer minReadySeconds;
  private String nameEscapingScheme;
  private String nameValidationScheme;
  private Map<String,String> nodeSelector;
  private OTLPConfigBuilder otlp;
  private Boolean overrideHonorLabels;
  private Boolean overrideHonorTimestamps;
  private Boolean paused;
  private StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy;
  private String podManagementPolicy;
  private EmbeddedObjectMetadataBuilder podMetadata;
  private LabelSelectorBuilder podMonitorNamespaceSelector;
  private LabelSelectorBuilder podMonitorSelector;
  private List<String> podTargetLabels = new ArrayList<String>();
  private String portName;
  private String priorityClassName;
  private LabelSelectorBuilder probeNamespaceSelector;
  private LabelSelectorBuilder probeSelector;
  private String prometheusExternalLabelName;
  private ArrayList<PrometheusRuleExcludeConfigBuilder> prometheusRulesExcludedFromEnforce = new ArrayList<PrometheusRuleExcludeConfigBuilder>();
  private QuerySpecBuilder query;
  private String queryLogFile;
  private String reloadStrategy;
  private ArrayList<RemoteReadSpecBuilder> remoteRead = new ArrayList<RemoteReadSpecBuilder>();
  private ArrayList<RemoteWriteSpecBuilder> remoteWrite = new ArrayList<RemoteWriteSpecBuilder>();
  private List<String> remoteWriteReceiverMessageVersions = new ArrayList<String>();
  private String replicaExternalLabelName;
  private Integer replicas;
  private ResourceRequirementsBuilder resources;
  private String retention;
  private String retentionSize;
  private String routePrefix;
  private LabelSelectorBuilder ruleNamespaceSelector;
  private String ruleQueryOffset;
  private LabelSelectorBuilder ruleSelector;
  private RulesBuilder rules;
  private RuntimeConfigBuilder runtime;
  private Long sampleLimit;
  private String schedulerName;
  private ArrayList<ScrapeClassBuilder> scrapeClasses = new ArrayList<ScrapeClassBuilder>();
  private Boolean scrapeClassicHistograms;
  private LabelSelectorBuilder scrapeConfigNamespaceSelector;
  private LabelSelectorBuilder scrapeConfigSelector;
  private String scrapeFailureLogFile;
  private String scrapeInterval;
  private Boolean scrapeNativeHistograms;
  private List<String> scrapeProtocols = new ArrayList<String>();
  private String scrapeTimeout;
  private List<String> secrets = new ArrayList<String>();
  private PodSecurityContext securityContext;
  private String serviceAccountName;
  private String serviceDiscoveryRole;
  private LabelSelectorBuilder serviceMonitorNamespaceSelector;
  private LabelSelectorBuilder serviceMonitorSelector;
  private String serviceName;
  private String sha;
  private ShardRetentionPolicyBuilder shardRetentionPolicy;
  private ShardingStrategyBuilder shardingStrategy;
  private Integer shards;
  private StorageSpecBuilder storage;
  private String tag;
  private Long targetLimit;
  private Long terminationGracePeriodSeconds;
  private ThanosSpecBuilder thanos;
  private List<Toleration> tolerations = new ArrayList<Toleration>();
  private ArrayList<TopologySpreadConstraintBuilder> topologySpreadConstraints = new ArrayList<TopologySpreadConstraintBuilder>();
  private TracingConfigBuilder tracingConfig;
  private TSDBSpecBuilder tsdb;
  private StatefulSetUpdateStrategyBuilder updateStrategy;
  private String version;
  private ArrayList<VolumeMountBuilder> volumeMounts = new ArrayList<VolumeMountBuilder>();
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();
  private Boolean walCompression;
  private PrometheusWebSpecBuilder web;

  public PrometheusSpecFluent() {
  }
  
  public PrometheusSpecFluent(PrometheusSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalArgs(Collection<Argument> items) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").add(builder);
        this.additionalArgs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConfigMaps(Collection<String> items) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    for (String item : items) {
      this.configMaps.add(item);
    }
    return (A) this;
  }
  
  public A addAllToContainers(Collection<Container> items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("containers").add(builder);
        this.containers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEnableFeatures(Collection<String> items) {
    if (this.enableFeatures == null) {
      this.enableFeatures = new ArrayList();
    }
    for (String item : items) {
      this.enableFeatures.add(item);
    }
    return (A) this;
  }
  
  public A addAllToExcludedFromEnforcement(Collection<ObjectReference> items) {
    if (this.excludedFromEnforcement == null) {
      this.excludedFromEnforcement = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("excludedFromEnforcement").add(builder);
        this.excludedFromEnforcement.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHostAliases(Collection<HostAlias> items) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    for (HostAlias item : items) {
        HostAliasBuilder builder = new HostAliasBuilder(item);
        _visitables.get("hostAliases").add(builder);
        this.hostAliases.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToImagePullSecrets(Collection<LocalObjectReference> items) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").add(builder);
        this.imagePullSecrets.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToInitContainers(Collection<Container> items) {
    if (this.initContainers == null) {
      this.initContainers = new ArrayList();
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("initContainers").add(builder);
        this.initContainers.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPodTargetLabels(Collection<String> items) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    for (String item : items) {
      this.podTargetLabels.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPrometheusRulesExcludedFromEnforce(Collection<PrometheusRuleExcludeConfig> items) {
    if (this.prometheusRulesExcludedFromEnforce == null) {
      this.prometheusRulesExcludedFromEnforce = new ArrayList();
    }
    for (PrometheusRuleExcludeConfig item : items) {
        PrometheusRuleExcludeConfigBuilder builder = new PrometheusRuleExcludeConfigBuilder(item);
        _visitables.get("prometheusRulesExcludedFromEnforce").add(builder);
        this.prometheusRulesExcludedFromEnforce.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRemoteRead(Collection<RemoteReadSpec> items) {
    if (this.remoteRead == null) {
      this.remoteRead = new ArrayList();
    }
    for (RemoteReadSpec item : items) {
        RemoteReadSpecBuilder builder = new RemoteReadSpecBuilder(item);
        _visitables.get("remoteRead").add(builder);
        this.remoteRead.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRemoteWrite(Collection<RemoteWriteSpec> items) {
    if (this.remoteWrite == null) {
      this.remoteWrite = new ArrayList();
    }
    for (RemoteWriteSpec item : items) {
        RemoteWriteSpecBuilder builder = new RemoteWriteSpecBuilder(item);
        _visitables.get("remoteWrite").add(builder);
        this.remoteWrite.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRemoteWriteReceiverMessageVersions(Collection<String> items) {
    if (this.remoteWriteReceiverMessageVersions == null) {
      this.remoteWriteReceiverMessageVersions = new ArrayList();
    }
    for (String item : items) {
      this.remoteWriteReceiverMessageVersions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToScrapeClasses(Collection<ScrapeClass> items) {
    if (this.scrapeClasses == null) {
      this.scrapeClasses = new ArrayList();
    }
    for (ScrapeClass item : items) {
        ScrapeClassBuilder builder = new ScrapeClassBuilder(item);
        _visitables.get("scrapeClasses").add(builder);
        this.scrapeClasses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSecrets(Collection<String> items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (String item : items) {
      this.secrets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTopologySpreadConstraints(Collection<TopologySpreadConstraint> items) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    for (TopologySpreadConstraint item : items) {
        TopologySpreadConstraintBuilder builder = new TopologySpreadConstraintBuilder(item);
        _visitables.get("topologySpreadConstraints").add(builder);
        this.topologySpreadConstraints.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumeMounts(Collection<VolumeMount> items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVolumes(Collection<Volume> items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalArgsNested<A> addNewAdditionalArg() {
    return new AdditionalArgsNested(-1, null);
  }
  
  public A addNewAdditionalArg(String name,String value) {
    return (A) this.addToAdditionalArgs(new Argument(name, value));
  }
  
  public AdditionalArgsNested<A> addNewAdditionalArgLike(Argument item) {
    return new AdditionalArgsNested(-1, item);
  }
  
  public ContainersNested<A> addNewContainer() {
    return new ContainersNested(-1, null);
  }
  
  public ContainersNested<A> addNewContainerLike(Container item) {
    return new ContainersNested(-1, item);
  }
  
  public ExcludedFromEnforcementNested<A> addNewExcludedFromEnforcement() {
    return new ExcludedFromEnforcementNested(-1, null);
  }
  
  public A addNewExcludedFromEnforcement(String group,String name,String namespace,String resource) {
    return (A) this.addToExcludedFromEnforcement(new ObjectReference(group, name, namespace, resource));
  }
  
  public ExcludedFromEnforcementNested<A> addNewExcludedFromEnforcementLike(ObjectReference item) {
    return new ExcludedFromEnforcementNested(-1, item);
  }
  
  public HostAliasesNested<A> addNewHostAlias() {
    return new HostAliasesNested(-1, null);
  }
  
  public HostAliasesNested<A> addNewHostAliasLike(HostAlias item) {
    return new HostAliasesNested(-1, item);
  }
  
  public ImagePullSecretsNested<A> addNewImagePullSecret() {
    return new ImagePullSecretsNested(-1, null);
  }
  
  public A addNewImagePullSecret(String name) {
    return (A) this.addToImagePullSecrets(new LocalObjectReference(name));
  }
  
  public ImagePullSecretsNested<A> addNewImagePullSecretLike(LocalObjectReference item) {
    return new ImagePullSecretsNested(-1, item);
  }
  
  public InitContainersNested<A> addNewInitContainer() {
    return new InitContainersNested(-1, null);
  }
  
  public InitContainersNested<A> addNewInitContainerLike(Container item) {
    return new InitContainersNested(-1, item);
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> addNewPrometheusRulesExcludedFromEnforce() {
    return new PrometheusRulesExcludedFromEnforceNested(-1, null);
  }
  
  public A addNewPrometheusRulesExcludedFromEnforce(String ruleName,String ruleNamespace) {
    return (A) this.addToPrometheusRulesExcludedFromEnforce(new PrometheusRuleExcludeConfig(ruleName, ruleNamespace));
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> addNewPrometheusRulesExcludedFromEnforceLike(PrometheusRuleExcludeConfig item) {
    return new PrometheusRulesExcludedFromEnforceNested(-1, item);
  }
  
  public RemoteReadNested<A> addNewRemoteRead() {
    return new RemoteReadNested(-1, null);
  }
  
  public RemoteReadNested<A> addNewRemoteReadLike(RemoteReadSpec item) {
    return new RemoteReadNested(-1, item);
  }
  
  public RemoteWriteNested<A> addNewRemoteWrite() {
    return new RemoteWriteNested(-1, null);
  }
  
  public RemoteWriteNested<A> addNewRemoteWriteLike(RemoteWriteSpec item) {
    return new RemoteWriteNested(-1, item);
  }
  
  public ScrapeClassesNested<A> addNewScrapeClass() {
    return new ScrapeClassesNested(-1, null);
  }
  
  public ScrapeClassesNested<A> addNewScrapeClassLike(ScrapeClass item) {
    return new ScrapeClassesNested(-1, item);
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
  }
  
  public TopologySpreadConstraintsNested<A> addNewTopologySpreadConstraint() {
    return new TopologySpreadConstraintsNested(-1, null);
  }
  
  public TopologySpreadConstraintsNested<A> addNewTopologySpreadConstraintLike(TopologySpreadConstraint item) {
    return new TopologySpreadConstraintsNested(-1, item);
  }
  
  public VolumesNested<A> addNewVolume() {
    return new VolumesNested(-1, null);
  }
  
  public VolumesNested<A> addNewVolumeLike(Volume item) {
    return new VolumesNested(-1, item);
  }
  
  public VolumeMountsNested<A> addNewVolumeMount() {
    return new VolumeMountsNested(-1, null);
  }
  
  public VolumeMountsNested<A> addNewVolumeMountLike(VolumeMount item) {
    return new VolumeMountsNested(-1, item);
  }
  
  public A addToAdditionalArgs(Argument... items) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").add(builder);
        this.additionalArgs.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalArgs(int index,Argument item) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    ArgumentBuilder builder = new ArgumentBuilder(item);
    if (index < 0 || index >= additionalArgs.size()) {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.add(builder);
    } else {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConfigMaps(String... items) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    for (String item : items) {
      this.configMaps.add(item);
    }
    return (A) this;
  }
  
  public A addToConfigMaps(int index,String item) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    this.configMaps.add(index, item);
    return (A) this;
  }
  
  public A addToContainers(Container... items) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("containers").add(builder);
        this.containers.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainers(int index,Container item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    ContainerBuilder builder = new ContainerBuilder(item);
    if (index < 0 || index >= containers.size()) {
        _visitables.get("containers").add(builder);
        containers.add(builder);
    } else {
        _visitables.get("containers").add(builder);
        containers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEnableFeatures(String... items) {
    if (this.enableFeatures == null) {
      this.enableFeatures = new ArrayList();
    }
    for (String item : items) {
      this.enableFeatures.add(item);
    }
    return (A) this;
  }
  
  public A addToEnableFeatures(int index,String item) {
    if (this.enableFeatures == null) {
      this.enableFeatures = new ArrayList();
    }
    this.enableFeatures.add(index, item);
    return (A) this;
  }
  
  public A addToExcludedFromEnforcement(ObjectReference... items) {
    if (this.excludedFromEnforcement == null) {
      this.excludedFromEnforcement = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("excludedFromEnforcement").add(builder);
        this.excludedFromEnforcement.add(builder);
    }
    return (A) this;
  }
  
  public A addToExcludedFromEnforcement(int index,ObjectReference item) {
    if (this.excludedFromEnforcement == null) {
      this.excludedFromEnforcement = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= excludedFromEnforcement.size()) {
        _visitables.get("excludedFromEnforcement").add(builder);
        excludedFromEnforcement.add(builder);
    } else {
        _visitables.get("excludedFromEnforcement").add(builder);
        excludedFromEnforcement.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToExternalLabels(Map<String,String> map) {
    if (this.externalLabels == null && map != null) {
      this.externalLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.externalLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExternalLabels(String key,String value) {
    if (this.externalLabels == null && key != null && value != null) {
      this.externalLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.externalLabels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToHostAliases(HostAlias... items) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    for (HostAlias item : items) {
        HostAliasBuilder builder = new HostAliasBuilder(item);
        _visitables.get("hostAliases").add(builder);
        this.hostAliases.add(builder);
    }
    return (A) this;
  }
  
  public A addToHostAliases(int index,HostAlias item) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    HostAliasBuilder builder = new HostAliasBuilder(item);
    if (index < 0 || index >= hostAliases.size()) {
        _visitables.get("hostAliases").add(builder);
        hostAliases.add(builder);
    } else {
        _visitables.get("hostAliases").add(builder);
        hostAliases.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToImagePullSecrets(LocalObjectReference... items) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").add(builder);
        this.imagePullSecrets.add(builder);
    }
    return (A) this;
  }
  
  public A addToImagePullSecrets(int index,LocalObjectReference item) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= imagePullSecrets.size()) {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.add(builder);
    } else {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToInitContainers(Container... items) {
    if (this.initContainers == null) {
      this.initContainers = new ArrayList();
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("initContainers").add(builder);
        this.initContainers.add(builder);
    }
    return (A) this;
  }
  
  public A addToInitContainers(int index,Container item) {
    if (this.initContainers == null) {
      this.initContainers = new ArrayList();
    }
    ContainerBuilder builder = new ContainerBuilder(item);
    if (index < 0 || index >= initContainers.size()) {
        _visitables.get("initContainers").add(builder);
        initContainers.add(builder);
    } else {
        _visitables.get("initContainers").add(builder);
        initContainers.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null && map != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (map != null) {
      this.nodeSelector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToNodeSelector(String key,String value) {
    if (this.nodeSelector == null && key != null && value != null) {
      this.nodeSelector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.nodeSelector.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPodTargetLabels(String... items) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    for (String item : items) {
      this.podTargetLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToPodTargetLabels(int index,String item) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    this.podTargetLabels.add(index, item);
    return (A) this;
  }
  
  public A addToPrometheusRulesExcludedFromEnforce(PrometheusRuleExcludeConfig... items) {
    if (this.prometheusRulesExcludedFromEnforce == null) {
      this.prometheusRulesExcludedFromEnforce = new ArrayList();
    }
    for (PrometheusRuleExcludeConfig item : items) {
        PrometheusRuleExcludeConfigBuilder builder = new PrometheusRuleExcludeConfigBuilder(item);
        _visitables.get("prometheusRulesExcludedFromEnforce").add(builder);
        this.prometheusRulesExcludedFromEnforce.add(builder);
    }
    return (A) this;
  }
  
  public A addToPrometheusRulesExcludedFromEnforce(int index,PrometheusRuleExcludeConfig item) {
    if (this.prometheusRulesExcludedFromEnforce == null) {
      this.prometheusRulesExcludedFromEnforce = new ArrayList();
    }
    PrometheusRuleExcludeConfigBuilder builder = new PrometheusRuleExcludeConfigBuilder(item);
    if (index < 0 || index >= prometheusRulesExcludedFromEnforce.size()) {
        _visitables.get("prometheusRulesExcludedFromEnforce").add(builder);
        prometheusRulesExcludedFromEnforce.add(builder);
    } else {
        _visitables.get("prometheusRulesExcludedFromEnforce").add(builder);
        prometheusRulesExcludedFromEnforce.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRemoteRead(RemoteReadSpec... items) {
    if (this.remoteRead == null) {
      this.remoteRead = new ArrayList();
    }
    for (RemoteReadSpec item : items) {
        RemoteReadSpecBuilder builder = new RemoteReadSpecBuilder(item);
        _visitables.get("remoteRead").add(builder);
        this.remoteRead.add(builder);
    }
    return (A) this;
  }
  
  public A addToRemoteRead(int index,RemoteReadSpec item) {
    if (this.remoteRead == null) {
      this.remoteRead = new ArrayList();
    }
    RemoteReadSpecBuilder builder = new RemoteReadSpecBuilder(item);
    if (index < 0 || index >= remoteRead.size()) {
        _visitables.get("remoteRead").add(builder);
        remoteRead.add(builder);
    } else {
        _visitables.get("remoteRead").add(builder);
        remoteRead.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRemoteWrite(RemoteWriteSpec... items) {
    if (this.remoteWrite == null) {
      this.remoteWrite = new ArrayList();
    }
    for (RemoteWriteSpec item : items) {
        RemoteWriteSpecBuilder builder = new RemoteWriteSpecBuilder(item);
        _visitables.get("remoteWrite").add(builder);
        this.remoteWrite.add(builder);
    }
    return (A) this;
  }
  
  public A addToRemoteWrite(int index,RemoteWriteSpec item) {
    if (this.remoteWrite == null) {
      this.remoteWrite = new ArrayList();
    }
    RemoteWriteSpecBuilder builder = new RemoteWriteSpecBuilder(item);
    if (index < 0 || index >= remoteWrite.size()) {
        _visitables.get("remoteWrite").add(builder);
        remoteWrite.add(builder);
    } else {
        _visitables.get("remoteWrite").add(builder);
        remoteWrite.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRemoteWriteReceiverMessageVersions(String... items) {
    if (this.remoteWriteReceiverMessageVersions == null) {
      this.remoteWriteReceiverMessageVersions = new ArrayList();
    }
    for (String item : items) {
      this.remoteWriteReceiverMessageVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToRemoteWriteReceiverMessageVersions(int index,String item) {
    if (this.remoteWriteReceiverMessageVersions == null) {
      this.remoteWriteReceiverMessageVersions = new ArrayList();
    }
    this.remoteWriteReceiverMessageVersions.add(index, item);
    return (A) this;
  }
  
  public A addToScrapeClasses(ScrapeClass... items) {
    if (this.scrapeClasses == null) {
      this.scrapeClasses = new ArrayList();
    }
    for (ScrapeClass item : items) {
        ScrapeClassBuilder builder = new ScrapeClassBuilder(item);
        _visitables.get("scrapeClasses").add(builder);
        this.scrapeClasses.add(builder);
    }
    return (A) this;
  }
  
  public A addToScrapeClasses(int index,ScrapeClass item) {
    if (this.scrapeClasses == null) {
      this.scrapeClasses = new ArrayList();
    }
    ScrapeClassBuilder builder = new ScrapeClassBuilder(item);
    if (index < 0 || index >= scrapeClasses.size()) {
        _visitables.get("scrapeClasses").add(builder);
        scrapeClasses.add(builder);
    } else {
        _visitables.get("scrapeClasses").add(builder);
        scrapeClasses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    for (String item : items) {
      this.scrapeProtocols.add(item);
    }
    return (A) this;
  }
  
  public A addToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.add(index, item);
    return (A) this;
  }
  
  public A addToSecrets(String... items) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    for (String item : items) {
      this.secrets.add(item);
    }
    return (A) this;
  }
  
  public A addToSecrets(int index,String item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    this.secrets.add(index, item);
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
      this.tolerations.add(item);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.add(index, item);
    return (A) this;
  }
  
  public A addToTopologySpreadConstraints(TopologySpreadConstraint... items) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    for (TopologySpreadConstraint item : items) {
        TopologySpreadConstraintBuilder builder = new TopologySpreadConstraintBuilder(item);
        _visitables.get("topologySpreadConstraints").add(builder);
        this.topologySpreadConstraints.add(builder);
    }
    return (A) this;
  }
  
  public A addToTopologySpreadConstraints(int index,TopologySpreadConstraint item) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    TopologySpreadConstraintBuilder builder = new TopologySpreadConstraintBuilder(item);
    if (index < 0 || index >= topologySpreadConstraints.size()) {
        _visitables.get("topologySpreadConstraints").add(builder);
        topologySpreadConstraints.add(builder);
    } else {
        _visitables.get("topologySpreadConstraints").add(builder);
        topologySpreadConstraints.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVolumeMounts(VolumeMount... items) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").add(builder);
        this.volumeMounts.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumeMounts(int index,VolumeMount item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountBuilder builder = new VolumeMountBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(Volume... items) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").add(builder);
        this.volumes.add(builder);
    }
    return (A) this;
  }
  
  public A addToVolumes(int index,Volume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeBuilder builder = new VolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.add(index, builder);
    }
    return (A) this;
  }
  
  public Argument buildAdditionalArg(int index) {
    return this.additionalArgs.get(index).build();
  }
  
  public List<Argument> buildAdditionalArgs() {
    return this.additionalArgs != null ? build(additionalArgs) : null;
  }
  
  public AlertingSpec buildAlerting() {
    return this.alerting != null ? this.alerting.build() : null;
  }
  
  public APIServerConfig buildApiserverConfig() {
    return this.apiserverConfig != null ? this.apiserverConfig.build() : null;
  }
  
  public ArbitraryFSAccessThroughSMsConfig buildArbitraryFSAccessThroughSMs() {
    return this.arbitraryFSAccessThroughSMs != null ? this.arbitraryFSAccessThroughSMs.build() : null;
  }
  
  public Container buildContainer(int index) {
    return this.containers.get(index).build();
  }
  
  public List<Container> buildContainers() {
    return this.containers != null ? build(containers) : null;
  }
  
  public PodDNSConfig buildDnsConfig() {
    return this.dnsConfig != null ? this.dnsConfig.build() : null;
  }
  
  public List<ObjectReference> buildExcludedFromEnforcement() {
    return this.excludedFromEnforcement != null ? build(excludedFromEnforcement) : null;
  }
  
  public ObjectReference buildExcludedFromEnforcement(int index) {
    return this.excludedFromEnforcement.get(index).build();
  }
  
  public Exemplars buildExemplars() {
    return this.exemplars != null ? this.exemplars.build() : null;
  }
  
  public Argument buildFirstAdditionalArg() {
    return this.additionalArgs.get(0).build();
  }
  
  public Container buildFirstContainer() {
    return this.containers.get(0).build();
  }
  
  public ObjectReference buildFirstExcludedFromEnforcement() {
    return this.excludedFromEnforcement.get(0).build();
  }
  
  public HostAlias buildFirstHostAlias() {
    return this.hostAliases.get(0).build();
  }
  
  public LocalObjectReference buildFirstImagePullSecret() {
    return this.imagePullSecrets.get(0).build();
  }
  
  public Container buildFirstInitContainer() {
    return this.initContainers.get(0).build();
  }
  
  public PrometheusRuleExcludeConfig buildFirstPrometheusRulesExcludedFromEnforce() {
    return this.prometheusRulesExcludedFromEnforce.get(0).build();
  }
  
  public RemoteReadSpec buildFirstRemoteRead() {
    return this.remoteRead.get(0).build();
  }
  
  public RemoteWriteSpec buildFirstRemoteWrite() {
    return this.remoteWrite.get(0).build();
  }
  
  public ScrapeClass buildFirstScrapeClass() {
    return this.scrapeClasses.get(0).build();
  }
  
  public TopologySpreadConstraint buildFirstTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(0).build();
  }
  
  public Volume buildFirstVolume() {
    return this.volumes.get(0).build();
  }
  
  public VolumeMount buildFirstVolumeMount() {
    return this.volumeMounts.get(0).build();
  }
  
  public HostAlias buildHostAlias(int index) {
    return this.hostAliases.get(index).build();
  }
  
  public List<HostAlias> buildHostAliases() {
    return this.hostAliases != null ? build(hostAliases) : null;
  }
  
  public LocalObjectReference buildImagePullSecret(int index) {
    return this.imagePullSecrets.get(index).build();
  }
  
  public List<LocalObjectReference> buildImagePullSecrets() {
    return this.imagePullSecrets != null ? build(imagePullSecrets) : null;
  }
  
  public Container buildInitContainer(int index) {
    return this.initContainers.get(index).build();
  }
  
  public List<Container> buildInitContainers() {
    return this.initContainers != null ? build(initContainers) : null;
  }
  
  public Argument buildLastAdditionalArg() {
    return this.additionalArgs.get(additionalArgs.size() - 1).build();
  }
  
  public Container buildLastContainer() {
    return this.containers.get(containers.size() - 1).build();
  }
  
  public ObjectReference buildLastExcludedFromEnforcement() {
    return this.excludedFromEnforcement.get(excludedFromEnforcement.size() - 1).build();
  }
  
  public HostAlias buildLastHostAlias() {
    return this.hostAliases.get(hostAliases.size() - 1).build();
  }
  
  public LocalObjectReference buildLastImagePullSecret() {
    return this.imagePullSecrets.get(imagePullSecrets.size() - 1).build();
  }
  
  public Container buildLastInitContainer() {
    return this.initContainers.get(initContainers.size() - 1).build();
  }
  
  public PrometheusRuleExcludeConfig buildLastPrometheusRulesExcludedFromEnforce() {
    return this.prometheusRulesExcludedFromEnforce.get(prometheusRulesExcludedFromEnforce.size() - 1).build();
  }
  
  public RemoteReadSpec buildLastRemoteRead() {
    return this.remoteRead.get(remoteRead.size() - 1).build();
  }
  
  public RemoteWriteSpec buildLastRemoteWrite() {
    return this.remoteWrite.get(remoteWrite.size() - 1).build();
  }
  
  public ScrapeClass buildLastScrapeClass() {
    return this.scrapeClasses.get(scrapeClasses.size() - 1).build();
  }
  
  public TopologySpreadConstraint buildLastTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(topologySpreadConstraints.size() - 1).build();
  }
  
  public Volume buildLastVolume() {
    return this.volumes.get(volumes.size() - 1).build();
  }
  
  public VolumeMount buildLastVolumeMount() {
    return this.volumeMounts.get(volumeMounts.size() - 1).build();
  }
  
  public Argument buildMatchingAdditionalArg(Predicate<ArgumentBuilder> predicate) {
      for (ArgumentBuilder item : additionalArgs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Container buildMatchingContainer(Predicate<ContainerBuilder> predicate) {
      for (ContainerBuilder item : containers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildMatchingExcludedFromEnforcement(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : excludedFromEnforcement) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HostAlias buildMatchingHostAlias(Predicate<HostAliasBuilder> predicate) {
      for (HostAliasBuilder item : hostAliases) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalObjectReference buildMatchingImagePullSecret(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : imagePullSecrets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Container buildMatchingInitContainer(Predicate<ContainerBuilder> predicate) {
      for (ContainerBuilder item : initContainers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PrometheusRuleExcludeConfig buildMatchingPrometheusRulesExcludedFromEnforce(Predicate<PrometheusRuleExcludeConfigBuilder> predicate) {
      for (PrometheusRuleExcludeConfigBuilder item : prometheusRulesExcludedFromEnforce) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RemoteReadSpec buildMatchingRemoteRead(Predicate<RemoteReadSpecBuilder> predicate) {
      for (RemoteReadSpecBuilder item : remoteRead) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RemoteWriteSpec buildMatchingRemoteWrite(Predicate<RemoteWriteSpecBuilder> predicate) {
      for (RemoteWriteSpecBuilder item : remoteWrite) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ScrapeClass buildMatchingScrapeClass(Predicate<ScrapeClassBuilder> predicate) {
      for (ScrapeClassBuilder item : scrapeClasses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TopologySpreadConstraint buildMatchingTopologySpreadConstraint(Predicate<TopologySpreadConstraintBuilder> predicate) {
      for (TopologySpreadConstraintBuilder item : topologySpreadConstraints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Volume buildMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VolumeMount buildMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
      for (VolumeMountBuilder item : volumeMounts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OTLPConfig buildOtlp() {
    return this.otlp != null ? this.otlp.build() : null;
  }
  
  public EmbeddedObjectMetadata buildPodMetadata() {
    return this.podMetadata != null ? this.podMetadata.build() : null;
  }
  
  public LabelSelector buildPodMonitorNamespaceSelector() {
    return this.podMonitorNamespaceSelector != null ? this.podMonitorNamespaceSelector.build() : null;
  }
  
  public LabelSelector buildPodMonitorSelector() {
    return this.podMonitorSelector != null ? this.podMonitorSelector.build() : null;
  }
  
  public LabelSelector buildProbeNamespaceSelector() {
    return this.probeNamespaceSelector != null ? this.probeNamespaceSelector.build() : null;
  }
  
  public LabelSelector buildProbeSelector() {
    return this.probeSelector != null ? this.probeSelector.build() : null;
  }
  
  public List<PrometheusRuleExcludeConfig> buildPrometheusRulesExcludedFromEnforce() {
    return this.prometheusRulesExcludedFromEnforce != null ? build(prometheusRulesExcludedFromEnforce) : null;
  }
  
  public PrometheusRuleExcludeConfig buildPrometheusRulesExcludedFromEnforce(int index) {
    return this.prometheusRulesExcludedFromEnforce.get(index).build();
  }
  
  public QuerySpec buildQuery() {
    return this.query != null ? this.query.build() : null;
  }
  
  public List<RemoteReadSpec> buildRemoteRead() {
    return this.remoteRead != null ? build(remoteRead) : null;
  }
  
  public RemoteReadSpec buildRemoteRead(int index) {
    return this.remoteRead.get(index).build();
  }
  
  public List<RemoteWriteSpec> buildRemoteWrite() {
    return this.remoteWrite != null ? build(remoteWrite) : null;
  }
  
  public RemoteWriteSpec buildRemoteWrite(int index) {
    return this.remoteWrite.get(index).build();
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public LabelSelector buildRuleNamespaceSelector() {
    return this.ruleNamespaceSelector != null ? this.ruleNamespaceSelector.build() : null;
  }
  
  public LabelSelector buildRuleSelector() {
    return this.ruleSelector != null ? this.ruleSelector.build() : null;
  }
  
  public Rules buildRules() {
    return this.rules != null ? this.rules.build() : null;
  }
  
  public RuntimeConfig buildRuntime() {
    return this.runtime != null ? this.runtime.build() : null;
  }
  
  public ScrapeClass buildScrapeClass(int index) {
    return this.scrapeClasses.get(index).build();
  }
  
  public List<ScrapeClass> buildScrapeClasses() {
    return this.scrapeClasses != null ? build(scrapeClasses) : null;
  }
  
  public LabelSelector buildScrapeConfigNamespaceSelector() {
    return this.scrapeConfigNamespaceSelector != null ? this.scrapeConfigNamespaceSelector.build() : null;
  }
  
  public LabelSelector buildScrapeConfigSelector() {
    return this.scrapeConfigSelector != null ? this.scrapeConfigSelector.build() : null;
  }
  
  public LabelSelector buildServiceMonitorNamespaceSelector() {
    return this.serviceMonitorNamespaceSelector != null ? this.serviceMonitorNamespaceSelector.build() : null;
  }
  
  public LabelSelector buildServiceMonitorSelector() {
    return this.serviceMonitorSelector != null ? this.serviceMonitorSelector.build() : null;
  }
  
  public ShardRetentionPolicy buildShardRetentionPolicy() {
    return this.shardRetentionPolicy != null ? this.shardRetentionPolicy.build() : null;
  }
  
  public ShardingStrategy buildShardingStrategy() {
    return this.shardingStrategy != null ? this.shardingStrategy.build() : null;
  }
  
  public StorageSpec buildStorage() {
    return this.storage != null ? this.storage.build() : null;
  }
  
  public ThanosSpec buildThanos() {
    return this.thanos != null ? this.thanos.build() : null;
  }
  
  public TopologySpreadConstraint buildTopologySpreadConstraint(int index) {
    return this.topologySpreadConstraints.get(index).build();
  }
  
  public List<TopologySpreadConstraint> buildTopologySpreadConstraints() {
    return this.topologySpreadConstraints != null ? build(topologySpreadConstraints) : null;
  }
  
  public TracingConfig buildTracingConfig() {
    return this.tracingConfig != null ? this.tracingConfig.build() : null;
  }
  
  public TSDBSpec buildTsdb() {
    return this.tsdb != null ? this.tsdb.build() : null;
  }
  
  public StatefulSetUpdateStrategy buildUpdateStrategy() {
    return this.updateStrategy != null ? this.updateStrategy.build() : null;
  }
  
  public Volume buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public VolumeMount buildVolumeMount(int index) {
    return this.volumeMounts.get(index).build();
  }
  
  public List<VolumeMount> buildVolumeMounts() {
    return this.volumeMounts != null ? build(volumeMounts) : null;
  }
  
  public List<Volume> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  public PrometheusWebSpec buildWeb() {
    return this.web != null ? this.web.build() : null;
  }
  
  protected void copyInstance(PrometheusSpec instance) {
    instance = instance != null ? instance : new PrometheusSpec();
    if (instance != null) {
        this.withAdditionalAlertManagerConfigs(instance.getAdditionalAlertManagerConfigs());
        this.withAdditionalAlertRelabelConfigs(instance.getAdditionalAlertRelabelConfigs());
        this.withAdditionalArgs(instance.getAdditionalArgs());
        this.withAdditionalScrapeConfigs(instance.getAdditionalScrapeConfigs());
        this.withAffinity(instance.getAffinity());
        this.withAlerting(instance.getAlerting());
        this.withAllowOverlappingBlocks(instance.getAllowOverlappingBlocks());
        this.withApiserverConfig(instance.getApiserverConfig());
        this.withArbitraryFSAccessThroughSMs(instance.getArbitraryFSAccessThroughSMs());
        this.withAutomountServiceAccountToken(instance.getAutomountServiceAccountToken());
        this.withBaseImage(instance.getBaseImage());
        this.withBodySizeLimit(instance.getBodySizeLimit());
        this.withConfigMaps(instance.getConfigMaps());
        this.withContainers(instance.getContainers());
        this.withConvertClassicHistogramsToNHCB(instance.getConvertClassicHistogramsToNHCB());
        this.withDisableCompaction(instance.getDisableCompaction());
        this.withDnsConfig(instance.getDnsConfig());
        this.withDnsPolicy(instance.getDnsPolicy());
        this.withEnableAdminAPI(instance.getEnableAdminAPI());
        this.withEnableFeatures(instance.getEnableFeatures());
        this.withEnableOTLPReceiver(instance.getEnableOTLPReceiver());
        this.withEnableRemoteWriteReceiver(instance.getEnableRemoteWriteReceiver());
        this.withEnableServiceLinks(instance.getEnableServiceLinks());
        this.withEnforcedBodySizeLimit(instance.getEnforcedBodySizeLimit());
        this.withEnforcedKeepDroppedTargets(instance.getEnforcedKeepDroppedTargets());
        this.withEnforcedLabelLimit(instance.getEnforcedLabelLimit());
        this.withEnforcedLabelNameLengthLimit(instance.getEnforcedLabelNameLengthLimit());
        this.withEnforcedLabelValueLengthLimit(instance.getEnforcedLabelValueLengthLimit());
        this.withEnforcedNamespaceLabel(instance.getEnforcedNamespaceLabel());
        this.withEnforcedSampleLimit(instance.getEnforcedSampleLimit());
        this.withEnforcedTargetLimit(instance.getEnforcedTargetLimit());
        this.withEvaluationInterval(instance.getEvaluationInterval());
        this.withExcludedFromEnforcement(instance.getExcludedFromEnforcement());
        this.withExemplars(instance.getExemplars());
        this.withExternalLabels(instance.getExternalLabels());
        this.withExternalUrl(instance.getExternalUrl());
        this.withHostAliases(instance.getHostAliases());
        this.withHostNetwork(instance.getHostNetwork());
        this.withHostUsers(instance.getHostUsers());
        this.withIgnoreNamespaceSelectors(instance.getIgnoreNamespaceSelectors());
        this.withImage(instance.getImage());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecrets(instance.getImagePullSecrets());
        this.withInitContainers(instance.getInitContainers());
        this.withKeepDroppedTargets(instance.getKeepDroppedTargets());
        this.withLabelLimit(instance.getLabelLimit());
        this.withLabelNameLengthLimit(instance.getLabelNameLengthLimit());
        this.withLabelValueLengthLimit(instance.getLabelValueLengthLimit());
        this.withListenLocal(instance.getListenLocal());
        this.withLogFormat(instance.getLogFormat());
        this.withLogLevel(instance.getLogLevel());
        this.withMaximumStartupDurationSeconds(instance.getMaximumStartupDurationSeconds());
        this.withMinReadySeconds(instance.getMinReadySeconds());
        this.withNameEscapingScheme(instance.getNameEscapingScheme());
        this.withNameValidationScheme(instance.getNameValidationScheme());
        this.withNodeSelector(instance.getNodeSelector());
        this.withOtlp(instance.getOtlp());
        this.withOverrideHonorLabels(instance.getOverrideHonorLabels());
        this.withOverrideHonorTimestamps(instance.getOverrideHonorTimestamps());
        this.withPaused(instance.getPaused());
        this.withPersistentVolumeClaimRetentionPolicy(instance.getPersistentVolumeClaimRetentionPolicy());
        this.withPodManagementPolicy(instance.getPodManagementPolicy());
        this.withPodMetadata(instance.getPodMetadata());
        this.withPodMonitorNamespaceSelector(instance.getPodMonitorNamespaceSelector());
        this.withPodMonitorSelector(instance.getPodMonitorSelector());
        this.withPodTargetLabels(instance.getPodTargetLabels());
        this.withPortName(instance.getPortName());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withProbeNamespaceSelector(instance.getProbeNamespaceSelector());
        this.withProbeSelector(instance.getProbeSelector());
        this.withPrometheusExternalLabelName(instance.getPrometheusExternalLabelName());
        this.withPrometheusRulesExcludedFromEnforce(instance.getPrometheusRulesExcludedFromEnforce());
        this.withQuery(instance.getQuery());
        this.withQueryLogFile(instance.getQueryLogFile());
        this.withReloadStrategy(instance.getReloadStrategy());
        this.withRemoteRead(instance.getRemoteRead());
        this.withRemoteWrite(instance.getRemoteWrite());
        this.withRemoteWriteReceiverMessageVersions(instance.getRemoteWriteReceiverMessageVersions());
        this.withReplicaExternalLabelName(instance.getReplicaExternalLabelName());
        this.withReplicas(instance.getReplicas());
        this.withResources(instance.getResources());
        this.withRetention(instance.getRetention());
        this.withRetentionSize(instance.getRetentionSize());
        this.withRoutePrefix(instance.getRoutePrefix());
        this.withRuleNamespaceSelector(instance.getRuleNamespaceSelector());
        this.withRuleQueryOffset(instance.getRuleQueryOffset());
        this.withRuleSelector(instance.getRuleSelector());
        this.withRules(instance.getRules());
        this.withRuntime(instance.getRuntime());
        this.withSampleLimit(instance.getSampleLimit());
        this.withSchedulerName(instance.getSchedulerName());
        this.withScrapeClasses(instance.getScrapeClasses());
        this.withScrapeClassicHistograms(instance.getScrapeClassicHistograms());
        this.withScrapeConfigNamespaceSelector(instance.getScrapeConfigNamespaceSelector());
        this.withScrapeConfigSelector(instance.getScrapeConfigSelector());
        this.withScrapeFailureLogFile(instance.getScrapeFailureLogFile());
        this.withScrapeInterval(instance.getScrapeInterval());
        this.withScrapeNativeHistograms(instance.getScrapeNativeHistograms());
        this.withScrapeProtocols(instance.getScrapeProtocols());
        this.withScrapeTimeout(instance.getScrapeTimeout());
        this.withSecrets(instance.getSecrets());
        this.withSecurityContext(instance.getSecurityContext());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withServiceDiscoveryRole(instance.getServiceDiscoveryRole());
        this.withServiceMonitorNamespaceSelector(instance.getServiceMonitorNamespaceSelector());
        this.withServiceMonitorSelector(instance.getServiceMonitorSelector());
        this.withServiceName(instance.getServiceName());
        this.withSha(instance.getSha());
        this.withShardRetentionPolicy(instance.getShardRetentionPolicy());
        this.withShardingStrategy(instance.getShardingStrategy());
        this.withShards(instance.getShards());
        this.withStorage(instance.getStorage());
        this.withTag(instance.getTag());
        this.withTargetLimit(instance.getTargetLimit());
        this.withTerminationGracePeriodSeconds(instance.getTerminationGracePeriodSeconds());
        this.withThanos(instance.getThanos());
        this.withTolerations(instance.getTolerations());
        this.withTopologySpreadConstraints(instance.getTopologySpreadConstraints());
        this.withTracingConfig(instance.getTracingConfig());
        this.withTsdb(instance.getTsdb());
        this.withUpdateStrategy(instance.getUpdateStrategy());
        this.withVersion(instance.getVersion());
        this.withVolumeMounts(instance.getVolumeMounts());
        this.withVolumes(instance.getVolumes());
        this.withWalCompression(instance.getWalCompression());
        this.withWeb(instance.getWeb());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalArgsNested<A> editAdditionalArg(int index) {
    if (additionalArgs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(index, this.buildAdditionalArg(index));
  }
  
  public AlertingNested<A> editAlerting() {
    return this.withNewAlertingLike(Optional.ofNullable(this.buildAlerting()).orElse(null));
  }
  
  public ApiserverConfigNested<A> editApiserverConfig() {
    return this.withNewApiserverConfigLike(Optional.ofNullable(this.buildApiserverConfig()).orElse(null));
  }
  
  public ArbitraryFSAccessThroughSMsNested<A> editArbitraryFSAccessThroughSMs() {
    return this.withNewArbitraryFSAccessThroughSMsLike(Optional.ofNullable(this.buildArbitraryFSAccessThroughSMs()).orElse(null));
  }
  
  public ContainersNested<A> editContainer(int index) {
    if (containers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public DnsConfigNested<A> editDnsConfig() {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(null));
  }
  
  public ExcludedFromEnforcementNested<A> editExcludedFromEnforcement(int index) {
    if (excludedFromEnforcement.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "excludedFromEnforcement"));
    }
    return this.setNewExcludedFromEnforcementLike(index, this.buildExcludedFromEnforcement(index));
  }
  
  public ExemplarsNested<A> editExemplars() {
    return this.withNewExemplarsLike(Optional.ofNullable(this.buildExemplars()).orElse(null));
  }
  
  public AdditionalArgsNested<A> editFirstAdditionalArg() {
    if (additionalArgs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(0, this.buildAdditionalArg(0));
  }
  
  public ContainersNested<A> editFirstContainer() {
    if (containers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(0, this.buildContainer(0));
  }
  
  public ExcludedFromEnforcementNested<A> editFirstExcludedFromEnforcement() {
    if (excludedFromEnforcement.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "excludedFromEnforcement"));
    }
    return this.setNewExcludedFromEnforcementLike(0, this.buildExcludedFromEnforcement(0));
  }
  
  public HostAliasesNested<A> editFirstHostAlias() {
    if (hostAliases.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "hostAliases"));
    }
    return this.setNewHostAliasLike(0, this.buildHostAlias(0));
  }
  
  public ImagePullSecretsNested<A> editFirstImagePullSecret() {
    if (imagePullSecrets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(0, this.buildImagePullSecret(0));
  }
  
  public InitContainersNested<A> editFirstInitContainer() {
    if (initContainers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "initContainers"));
    }
    return this.setNewInitContainerLike(0, this.buildInitContainer(0));
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> editFirstPrometheusRulesExcludedFromEnforce() {
    if (prometheusRulesExcludedFromEnforce.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "prometheusRulesExcludedFromEnforce"));
    }
    return this.setNewPrometheusRulesExcludedFromEnforceLike(0, this.buildPrometheusRulesExcludedFromEnforce(0));
  }
  
  public RemoteReadNested<A> editFirstRemoteRead() {
    if (remoteRead.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "remoteRead"));
    }
    return this.setNewRemoteReadLike(0, this.buildRemoteRead(0));
  }
  
  public RemoteWriteNested<A> editFirstRemoteWrite() {
    if (remoteWrite.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "remoteWrite"));
    }
    return this.setNewRemoteWriteLike(0, this.buildRemoteWrite(0));
  }
  
  public ScrapeClassesNested<A> editFirstScrapeClass() {
    if (scrapeClasses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "scrapeClasses"));
    }
    return this.setNewScrapeClassLike(0, this.buildScrapeClass(0));
  }
  
  public TopologySpreadConstraintsNested<A> editFirstTopologySpreadConstraint() {
    if (topologySpreadConstraints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "topologySpreadConstraints"));
    }
    return this.setNewTopologySpreadConstraintLike(0, this.buildTopologySpreadConstraint(0));
  }
  
  public VolumesNested<A> editFirstVolume() {
    if (volumes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(0, this.buildVolume(0));
  }
  
  public VolumeMountsNested<A> editFirstVolumeMount() {
    if (volumeMounts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(0, this.buildVolumeMount(0));
  }
  
  public HostAliasesNested<A> editHostAlias(int index) {
    if (hostAliases.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "hostAliases"));
    }
    return this.setNewHostAliasLike(index, this.buildHostAlias(index));
  }
  
  public ImagePullSecretsNested<A> editImagePullSecret(int index) {
    if (imagePullSecrets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(index, this.buildImagePullSecret(index));
  }
  
  public InitContainersNested<A> editInitContainer(int index) {
    if (initContainers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "initContainers"));
    }
    return this.setNewInitContainerLike(index, this.buildInitContainer(index));
  }
  
  public AdditionalArgsNested<A> editLastAdditionalArg() {
    int index = additionalArgs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(index, this.buildAdditionalArg(index));
  }
  
  public ContainersNested<A> editLastContainer() {
    int index = containers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public ExcludedFromEnforcementNested<A> editLastExcludedFromEnforcement() {
    int index = excludedFromEnforcement.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "excludedFromEnforcement"));
    }
    return this.setNewExcludedFromEnforcementLike(index, this.buildExcludedFromEnforcement(index));
  }
  
  public HostAliasesNested<A> editLastHostAlias() {
    int index = hostAliases.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "hostAliases"));
    }
    return this.setNewHostAliasLike(index, this.buildHostAlias(index));
  }
  
  public ImagePullSecretsNested<A> editLastImagePullSecret() {
    int index = imagePullSecrets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(index, this.buildImagePullSecret(index));
  }
  
  public InitContainersNested<A> editLastInitContainer() {
    int index = initContainers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "initContainers"));
    }
    return this.setNewInitContainerLike(index, this.buildInitContainer(index));
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> editLastPrometheusRulesExcludedFromEnforce() {
    int index = prometheusRulesExcludedFromEnforce.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "prometheusRulesExcludedFromEnforce"));
    }
    return this.setNewPrometheusRulesExcludedFromEnforceLike(index, this.buildPrometheusRulesExcludedFromEnforce(index));
  }
  
  public RemoteReadNested<A> editLastRemoteRead() {
    int index = remoteRead.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "remoteRead"));
    }
    return this.setNewRemoteReadLike(index, this.buildRemoteRead(index));
  }
  
  public RemoteWriteNested<A> editLastRemoteWrite() {
    int index = remoteWrite.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "remoteWrite"));
    }
    return this.setNewRemoteWriteLike(index, this.buildRemoteWrite(index));
  }
  
  public ScrapeClassesNested<A> editLastScrapeClass() {
    int index = scrapeClasses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "scrapeClasses"));
    }
    return this.setNewScrapeClassLike(index, this.buildScrapeClass(index));
  }
  
  public TopologySpreadConstraintsNested<A> editLastTopologySpreadConstraint() {
    int index = topologySpreadConstraints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "topologySpreadConstraints"));
    }
    return this.setNewTopologySpreadConstraintLike(index, this.buildTopologySpreadConstraint(index));
  }
  
  public VolumesNested<A> editLastVolume() {
    int index = volumes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public VolumeMountsNested<A> editLastVolumeMount() {
    int index = volumeMounts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
  }
  
  public AdditionalArgsNested<A> editMatchingAdditionalArg(Predicate<ArgumentBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalArgs.size();i++) {
      if (predicate.test(additionalArgs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalArgs"));
    }
    return this.setNewAdditionalArgLike(index, this.buildAdditionalArg(index));
  }
  
  public ContainersNested<A> editMatchingContainer(Predicate<ContainerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containers.size();i++) {
      if (predicate.test(containers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public ExcludedFromEnforcementNested<A> editMatchingExcludedFromEnforcement(Predicate<ObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < excludedFromEnforcement.size();i++) {
      if (predicate.test(excludedFromEnforcement.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "excludedFromEnforcement"));
    }
    return this.setNewExcludedFromEnforcementLike(index, this.buildExcludedFromEnforcement(index));
  }
  
  public HostAliasesNested<A> editMatchingHostAlias(Predicate<HostAliasBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < hostAliases.size();i++) {
      if (predicate.test(hostAliases.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "hostAliases"));
    }
    return this.setNewHostAliasLike(index, this.buildHostAlias(index));
  }
  
  public ImagePullSecretsNested<A> editMatchingImagePullSecret(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imagePullSecrets.size();i++) {
      if (predicate.test(imagePullSecrets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imagePullSecrets"));
    }
    return this.setNewImagePullSecretLike(index, this.buildImagePullSecret(index));
  }
  
  public InitContainersNested<A> editMatchingInitContainer(Predicate<ContainerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < initContainers.size();i++) {
      if (predicate.test(initContainers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "initContainers"));
    }
    return this.setNewInitContainerLike(index, this.buildInitContainer(index));
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> editMatchingPrometheusRulesExcludedFromEnforce(Predicate<PrometheusRuleExcludeConfigBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < prometheusRulesExcludedFromEnforce.size();i++) {
      if (predicate.test(prometheusRulesExcludedFromEnforce.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "prometheusRulesExcludedFromEnforce"));
    }
    return this.setNewPrometheusRulesExcludedFromEnforceLike(index, this.buildPrometheusRulesExcludedFromEnforce(index));
  }
  
  public RemoteReadNested<A> editMatchingRemoteRead(Predicate<RemoteReadSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < remoteRead.size();i++) {
      if (predicate.test(remoteRead.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "remoteRead"));
    }
    return this.setNewRemoteReadLike(index, this.buildRemoteRead(index));
  }
  
  public RemoteWriteNested<A> editMatchingRemoteWrite(Predicate<RemoteWriteSpecBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < remoteWrite.size();i++) {
      if (predicate.test(remoteWrite.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "remoteWrite"));
    }
    return this.setNewRemoteWriteLike(index, this.buildRemoteWrite(index));
  }
  
  public ScrapeClassesNested<A> editMatchingScrapeClass(Predicate<ScrapeClassBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < scrapeClasses.size();i++) {
      if (predicate.test(scrapeClasses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "scrapeClasses"));
    }
    return this.setNewScrapeClassLike(index, this.buildScrapeClass(index));
  }
  
  public TopologySpreadConstraintsNested<A> editMatchingTopologySpreadConstraint(Predicate<TopologySpreadConstraintBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < topologySpreadConstraints.size();i++) {
      if (predicate.test(topologySpreadConstraints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "topologySpreadConstraints"));
    }
    return this.setNewTopologySpreadConstraintLike(index, this.buildTopologySpreadConstraint(index));
  }
  
  public VolumesNested<A> editMatchingVolume(Predicate<VolumeBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumes.size();i++) {
      if (predicate.test(volumes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public VolumeMountsNested<A> editMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < volumeMounts.size();i++) {
      if (predicate.test(volumeMounts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
  }
  
  public AlertingNested<A> editOrNewAlerting() {
    return this.withNewAlertingLike(Optional.ofNullable(this.buildAlerting()).orElse(new AlertingSpecBuilder().build()));
  }
  
  public AlertingNested<A> editOrNewAlertingLike(AlertingSpec item) {
    return this.withNewAlertingLike(Optional.ofNullable(this.buildAlerting()).orElse(item));
  }
  
  public ApiserverConfigNested<A> editOrNewApiserverConfig() {
    return this.withNewApiserverConfigLike(Optional.ofNullable(this.buildApiserverConfig()).orElse(new APIServerConfigBuilder().build()));
  }
  
  public ApiserverConfigNested<A> editOrNewApiserverConfigLike(APIServerConfig item) {
    return this.withNewApiserverConfigLike(Optional.ofNullable(this.buildApiserverConfig()).orElse(item));
  }
  
  public ArbitraryFSAccessThroughSMsNested<A> editOrNewArbitraryFSAccessThroughSMs() {
    return this.withNewArbitraryFSAccessThroughSMsLike(Optional.ofNullable(this.buildArbitraryFSAccessThroughSMs()).orElse(new ArbitraryFSAccessThroughSMsConfigBuilder().build()));
  }
  
  public ArbitraryFSAccessThroughSMsNested<A> editOrNewArbitraryFSAccessThroughSMsLike(ArbitraryFSAccessThroughSMsConfig item) {
    return this.withNewArbitraryFSAccessThroughSMsLike(Optional.ofNullable(this.buildArbitraryFSAccessThroughSMs()).orElse(item));
  }
  
  public DnsConfigNested<A> editOrNewDnsConfig() {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(new PodDNSConfigBuilder().build()));
  }
  
  public DnsConfigNested<A> editOrNewDnsConfigLike(PodDNSConfig item) {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(item));
  }
  
  public ExemplarsNested<A> editOrNewExemplars() {
    return this.withNewExemplarsLike(Optional.ofNullable(this.buildExemplars()).orElse(new ExemplarsBuilder().build()));
  }
  
  public ExemplarsNested<A> editOrNewExemplarsLike(Exemplars item) {
    return this.withNewExemplarsLike(Optional.ofNullable(this.buildExemplars()).orElse(item));
  }
  
  public OtlpNested<A> editOrNewOtlp() {
    return this.withNewOtlpLike(Optional.ofNullable(this.buildOtlp()).orElse(new OTLPConfigBuilder().build()));
  }
  
  public OtlpNested<A> editOrNewOtlpLike(OTLPConfig item) {
    return this.withNewOtlpLike(Optional.ofNullable(this.buildOtlp()).orElse(item));
  }
  
  public PodMetadataNested<A> editOrNewPodMetadata() {
    return this.withNewPodMetadataLike(Optional.ofNullable(this.buildPodMetadata()).orElse(new EmbeddedObjectMetadataBuilder().build()));
  }
  
  public PodMetadataNested<A> editOrNewPodMetadataLike(EmbeddedObjectMetadata item) {
    return this.withNewPodMetadataLike(Optional.ofNullable(this.buildPodMetadata()).orElse(item));
  }
  
  public PodMonitorNamespaceSelectorNested<A> editOrNewPodMonitorNamespaceSelector() {
    return this.withNewPodMonitorNamespaceSelectorLike(Optional.ofNullable(this.buildPodMonitorNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public PodMonitorNamespaceSelectorNested<A> editOrNewPodMonitorNamespaceSelectorLike(LabelSelector item) {
    return this.withNewPodMonitorNamespaceSelectorLike(Optional.ofNullable(this.buildPodMonitorNamespaceSelector()).orElse(item));
  }
  
  public PodMonitorSelectorNested<A> editOrNewPodMonitorSelector() {
    return this.withNewPodMonitorSelectorLike(Optional.ofNullable(this.buildPodMonitorSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public PodMonitorSelectorNested<A> editOrNewPodMonitorSelectorLike(LabelSelector item) {
    return this.withNewPodMonitorSelectorLike(Optional.ofNullable(this.buildPodMonitorSelector()).orElse(item));
  }
  
  public ProbeNamespaceSelectorNested<A> editOrNewProbeNamespaceSelector() {
    return this.withNewProbeNamespaceSelectorLike(Optional.ofNullable(this.buildProbeNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ProbeNamespaceSelectorNested<A> editOrNewProbeNamespaceSelectorLike(LabelSelector item) {
    return this.withNewProbeNamespaceSelectorLike(Optional.ofNullable(this.buildProbeNamespaceSelector()).orElse(item));
  }
  
  public ProbeSelectorNested<A> editOrNewProbeSelector() {
    return this.withNewProbeSelectorLike(Optional.ofNullable(this.buildProbeSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ProbeSelectorNested<A> editOrNewProbeSelectorLike(LabelSelector item) {
    return this.withNewProbeSelectorLike(Optional.ofNullable(this.buildProbeSelector()).orElse(item));
  }
  
  public QueryNested<A> editOrNewQuery() {
    return this.withNewQueryLike(Optional.ofNullable(this.buildQuery()).orElse(new QuerySpecBuilder().build()));
  }
  
  public QueryNested<A> editOrNewQueryLike(QuerySpec item) {
    return this.withNewQueryLike(Optional.ofNullable(this.buildQuery()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public RuleNamespaceSelectorNested<A> editOrNewRuleNamespaceSelector() {
    return this.withNewRuleNamespaceSelectorLike(Optional.ofNullable(this.buildRuleNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public RuleNamespaceSelectorNested<A> editOrNewRuleNamespaceSelectorLike(LabelSelector item) {
    return this.withNewRuleNamespaceSelectorLike(Optional.ofNullable(this.buildRuleNamespaceSelector()).orElse(item));
  }
  
  public RuleSelectorNested<A> editOrNewRuleSelector() {
    return this.withNewRuleSelectorLike(Optional.ofNullable(this.buildRuleSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public RuleSelectorNested<A> editOrNewRuleSelectorLike(LabelSelector item) {
    return this.withNewRuleSelectorLike(Optional.ofNullable(this.buildRuleSelector()).orElse(item));
  }
  
  public RulesNested<A> editOrNewRules() {
    return this.withNewRulesLike(Optional.ofNullable(this.buildRules()).orElse(new RulesBuilder().build()));
  }
  
  public RulesNested<A> editOrNewRulesLike(Rules item) {
    return this.withNewRulesLike(Optional.ofNullable(this.buildRules()).orElse(item));
  }
  
  public RuntimeNested<A> editOrNewRuntime() {
    return this.withNewRuntimeLike(Optional.ofNullable(this.buildRuntime()).orElse(new RuntimeConfigBuilder().build()));
  }
  
  public RuntimeNested<A> editOrNewRuntimeLike(RuntimeConfig item) {
    return this.withNewRuntimeLike(Optional.ofNullable(this.buildRuntime()).orElse(item));
  }
  
  public ScrapeConfigNamespaceSelectorNested<A> editOrNewScrapeConfigNamespaceSelector() {
    return this.withNewScrapeConfigNamespaceSelectorLike(Optional.ofNullable(this.buildScrapeConfigNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ScrapeConfigNamespaceSelectorNested<A> editOrNewScrapeConfigNamespaceSelectorLike(LabelSelector item) {
    return this.withNewScrapeConfigNamespaceSelectorLike(Optional.ofNullable(this.buildScrapeConfigNamespaceSelector()).orElse(item));
  }
  
  public ScrapeConfigSelectorNested<A> editOrNewScrapeConfigSelector() {
    return this.withNewScrapeConfigSelectorLike(Optional.ofNullable(this.buildScrapeConfigSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ScrapeConfigSelectorNested<A> editOrNewScrapeConfigSelectorLike(LabelSelector item) {
    return this.withNewScrapeConfigSelectorLike(Optional.ofNullable(this.buildScrapeConfigSelector()).orElse(item));
  }
  
  public ServiceMonitorNamespaceSelectorNested<A> editOrNewServiceMonitorNamespaceSelector() {
    return this.withNewServiceMonitorNamespaceSelectorLike(Optional.ofNullable(this.buildServiceMonitorNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ServiceMonitorNamespaceSelectorNested<A> editOrNewServiceMonitorNamespaceSelectorLike(LabelSelector item) {
    return this.withNewServiceMonitorNamespaceSelectorLike(Optional.ofNullable(this.buildServiceMonitorNamespaceSelector()).orElse(item));
  }
  
  public ServiceMonitorSelectorNested<A> editOrNewServiceMonitorSelector() {
    return this.withNewServiceMonitorSelectorLike(Optional.ofNullable(this.buildServiceMonitorSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ServiceMonitorSelectorNested<A> editOrNewServiceMonitorSelectorLike(LabelSelector item) {
    return this.withNewServiceMonitorSelectorLike(Optional.ofNullable(this.buildServiceMonitorSelector()).orElse(item));
  }
  
  public ShardRetentionPolicyNested<A> editOrNewShardRetentionPolicy() {
    return this.withNewShardRetentionPolicyLike(Optional.ofNullable(this.buildShardRetentionPolicy()).orElse(new ShardRetentionPolicyBuilder().build()));
  }
  
  public ShardRetentionPolicyNested<A> editOrNewShardRetentionPolicyLike(ShardRetentionPolicy item) {
    return this.withNewShardRetentionPolicyLike(Optional.ofNullable(this.buildShardRetentionPolicy()).orElse(item));
  }
  
  public ShardingStrategyNested<A> editOrNewShardingStrategy() {
    return this.withNewShardingStrategyLike(Optional.ofNullable(this.buildShardingStrategy()).orElse(new ShardingStrategyBuilder().build()));
  }
  
  public ShardingStrategyNested<A> editOrNewShardingStrategyLike(ShardingStrategy item) {
    return this.withNewShardingStrategyLike(Optional.ofNullable(this.buildShardingStrategy()).orElse(item));
  }
  
  public StorageNested<A> editOrNewStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(new StorageSpecBuilder().build()));
  }
  
  public StorageNested<A> editOrNewStorageLike(StorageSpec item) {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(item));
  }
  
  public ThanosNested<A> editOrNewThanos() {
    return this.withNewThanosLike(Optional.ofNullable(this.buildThanos()).orElse(new ThanosSpecBuilder().build()));
  }
  
  public ThanosNested<A> editOrNewThanosLike(ThanosSpec item) {
    return this.withNewThanosLike(Optional.ofNullable(this.buildThanos()).orElse(item));
  }
  
  public TracingConfigNested<A> editOrNewTracingConfig() {
    return this.withNewTracingConfigLike(Optional.ofNullable(this.buildTracingConfig()).orElse(new TracingConfigBuilder().build()));
  }
  
  public TracingConfigNested<A> editOrNewTracingConfigLike(TracingConfig item) {
    return this.withNewTracingConfigLike(Optional.ofNullable(this.buildTracingConfig()).orElse(item));
  }
  
  public TsdbNested<A> editOrNewTsdb() {
    return this.withNewTsdbLike(Optional.ofNullable(this.buildTsdb()).orElse(new TSDBSpecBuilder().build()));
  }
  
  public TsdbNested<A> editOrNewTsdbLike(TSDBSpec item) {
    return this.withNewTsdbLike(Optional.ofNullable(this.buildTsdb()).orElse(item));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategy() {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(new StatefulSetUpdateStrategyBuilder().build()));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategyLike(StatefulSetUpdateStrategy item) {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(item));
  }
  
  public WebNested<A> editOrNewWeb() {
    return this.withNewWebLike(Optional.ofNullable(this.buildWeb()).orElse(new PrometheusWebSpecBuilder().build()));
  }
  
  public WebNested<A> editOrNewWebLike(PrometheusWebSpec item) {
    return this.withNewWebLike(Optional.ofNullable(this.buildWeb()).orElse(item));
  }
  
  public OtlpNested<A> editOtlp() {
    return this.withNewOtlpLike(Optional.ofNullable(this.buildOtlp()).orElse(null));
  }
  
  public PodMetadataNested<A> editPodMetadata() {
    return this.withNewPodMetadataLike(Optional.ofNullable(this.buildPodMetadata()).orElse(null));
  }
  
  public PodMonitorNamespaceSelectorNested<A> editPodMonitorNamespaceSelector() {
    return this.withNewPodMonitorNamespaceSelectorLike(Optional.ofNullable(this.buildPodMonitorNamespaceSelector()).orElse(null));
  }
  
  public PodMonitorSelectorNested<A> editPodMonitorSelector() {
    return this.withNewPodMonitorSelectorLike(Optional.ofNullable(this.buildPodMonitorSelector()).orElse(null));
  }
  
  public ProbeNamespaceSelectorNested<A> editProbeNamespaceSelector() {
    return this.withNewProbeNamespaceSelectorLike(Optional.ofNullable(this.buildProbeNamespaceSelector()).orElse(null));
  }
  
  public ProbeSelectorNested<A> editProbeSelector() {
    return this.withNewProbeSelectorLike(Optional.ofNullable(this.buildProbeSelector()).orElse(null));
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> editPrometheusRulesExcludedFromEnforce(int index) {
    if (prometheusRulesExcludedFromEnforce.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "prometheusRulesExcludedFromEnforce"));
    }
    return this.setNewPrometheusRulesExcludedFromEnforceLike(index, this.buildPrometheusRulesExcludedFromEnforce(index));
  }
  
  public QueryNested<A> editQuery() {
    return this.withNewQueryLike(Optional.ofNullable(this.buildQuery()).orElse(null));
  }
  
  public RemoteReadNested<A> editRemoteRead(int index) {
    if (remoteRead.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "remoteRead"));
    }
    return this.setNewRemoteReadLike(index, this.buildRemoteRead(index));
  }
  
  public RemoteWriteNested<A> editRemoteWrite(int index) {
    if (remoteWrite.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "remoteWrite"));
    }
    return this.setNewRemoteWriteLike(index, this.buildRemoteWrite(index));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public RuleNamespaceSelectorNested<A> editRuleNamespaceSelector() {
    return this.withNewRuleNamespaceSelectorLike(Optional.ofNullable(this.buildRuleNamespaceSelector()).orElse(null));
  }
  
  public RuleSelectorNested<A> editRuleSelector() {
    return this.withNewRuleSelectorLike(Optional.ofNullable(this.buildRuleSelector()).orElse(null));
  }
  
  public RulesNested<A> editRules() {
    return this.withNewRulesLike(Optional.ofNullable(this.buildRules()).orElse(null));
  }
  
  public RuntimeNested<A> editRuntime() {
    return this.withNewRuntimeLike(Optional.ofNullable(this.buildRuntime()).orElse(null));
  }
  
  public ScrapeClassesNested<A> editScrapeClass(int index) {
    if (scrapeClasses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "scrapeClasses"));
    }
    return this.setNewScrapeClassLike(index, this.buildScrapeClass(index));
  }
  
  public ScrapeConfigNamespaceSelectorNested<A> editScrapeConfigNamespaceSelector() {
    return this.withNewScrapeConfigNamespaceSelectorLike(Optional.ofNullable(this.buildScrapeConfigNamespaceSelector()).orElse(null));
  }
  
  public ScrapeConfigSelectorNested<A> editScrapeConfigSelector() {
    return this.withNewScrapeConfigSelectorLike(Optional.ofNullable(this.buildScrapeConfigSelector()).orElse(null));
  }
  
  public ServiceMonitorNamespaceSelectorNested<A> editServiceMonitorNamespaceSelector() {
    return this.withNewServiceMonitorNamespaceSelectorLike(Optional.ofNullable(this.buildServiceMonitorNamespaceSelector()).orElse(null));
  }
  
  public ServiceMonitorSelectorNested<A> editServiceMonitorSelector() {
    return this.withNewServiceMonitorSelectorLike(Optional.ofNullable(this.buildServiceMonitorSelector()).orElse(null));
  }
  
  public ShardRetentionPolicyNested<A> editShardRetentionPolicy() {
    return this.withNewShardRetentionPolicyLike(Optional.ofNullable(this.buildShardRetentionPolicy()).orElse(null));
  }
  
  public ShardingStrategyNested<A> editShardingStrategy() {
    return this.withNewShardingStrategyLike(Optional.ofNullable(this.buildShardingStrategy()).orElse(null));
  }
  
  public StorageNested<A> editStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(null));
  }
  
  public ThanosNested<A> editThanos() {
    return this.withNewThanosLike(Optional.ofNullable(this.buildThanos()).orElse(null));
  }
  
  public TopologySpreadConstraintsNested<A> editTopologySpreadConstraint(int index) {
    if (topologySpreadConstraints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "topologySpreadConstraints"));
    }
    return this.setNewTopologySpreadConstraintLike(index, this.buildTopologySpreadConstraint(index));
  }
  
  public TracingConfigNested<A> editTracingConfig() {
    return this.withNewTracingConfigLike(Optional.ofNullable(this.buildTracingConfig()).orElse(null));
  }
  
  public TsdbNested<A> editTsdb() {
    return this.withNewTsdbLike(Optional.ofNullable(this.buildTsdb()).orElse(null));
  }
  
  public UpdateStrategyNested<A> editUpdateStrategy() {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(null));
  }
  
  public VolumesNested<A> editVolume(int index) {
    if (volumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
  }
  
  public VolumeMountsNested<A> editVolumeMount(int index) {
    if (volumeMounts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumeMounts"));
    }
    return this.setNewVolumeMountLike(index, this.buildVolumeMount(index));
  }
  
  public WebNested<A> editWeb() {
    return this.withNewWebLike(Optional.ofNullable(this.buildWeb()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    PrometheusSpecFluent that = (PrometheusSpecFluent) o;
    if (!(Objects.equals(additionalAlertManagerConfigs, that.additionalAlertManagerConfigs))) {
      return false;
    }
    if (!(Objects.equals(additionalAlertRelabelConfigs, that.additionalAlertRelabelConfigs))) {
      return false;
    }
    if (!(Objects.equals(additionalArgs, that.additionalArgs))) {
      return false;
    }
    if (!(Objects.equals(additionalScrapeConfigs, that.additionalScrapeConfigs))) {
      return false;
    }
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(alerting, that.alerting))) {
      return false;
    }
    if (!(Objects.equals(allowOverlappingBlocks, that.allowOverlappingBlocks))) {
      return false;
    }
    if (!(Objects.equals(apiserverConfig, that.apiserverConfig))) {
      return false;
    }
    if (!(Objects.equals(arbitraryFSAccessThroughSMs, that.arbitraryFSAccessThroughSMs))) {
      return false;
    }
    if (!(Objects.equals(automountServiceAccountToken, that.automountServiceAccountToken))) {
      return false;
    }
    if (!(Objects.equals(baseImage, that.baseImage))) {
      return false;
    }
    if (!(Objects.equals(bodySizeLimit, that.bodySizeLimit))) {
      return false;
    }
    if (!(Objects.equals(configMaps, that.configMaps))) {
      return false;
    }
    if (!(Objects.equals(containers, that.containers))) {
      return false;
    }
    if (!(Objects.equals(convertClassicHistogramsToNHCB, that.convertClassicHistogramsToNHCB))) {
      return false;
    }
    if (!(Objects.equals(disableCompaction, that.disableCompaction))) {
      return false;
    }
    if (!(Objects.equals(dnsConfig, that.dnsConfig))) {
      return false;
    }
    if (!(Objects.equals(dnsPolicy, that.dnsPolicy))) {
      return false;
    }
    if (!(Objects.equals(enableAdminAPI, that.enableAdminAPI))) {
      return false;
    }
    if (!(Objects.equals(enableFeatures, that.enableFeatures))) {
      return false;
    }
    if (!(Objects.equals(enableOTLPReceiver, that.enableOTLPReceiver))) {
      return false;
    }
    if (!(Objects.equals(enableRemoteWriteReceiver, that.enableRemoteWriteReceiver))) {
      return false;
    }
    if (!(Objects.equals(enableServiceLinks, that.enableServiceLinks))) {
      return false;
    }
    if (!(Objects.equals(enforcedBodySizeLimit, that.enforcedBodySizeLimit))) {
      return false;
    }
    if (!(Objects.equals(enforcedKeepDroppedTargets, that.enforcedKeepDroppedTargets))) {
      return false;
    }
    if (!(Objects.equals(enforcedLabelLimit, that.enforcedLabelLimit))) {
      return false;
    }
    if (!(Objects.equals(enforcedLabelNameLengthLimit, that.enforcedLabelNameLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(enforcedLabelValueLengthLimit, that.enforcedLabelValueLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(enforcedNamespaceLabel, that.enforcedNamespaceLabel))) {
      return false;
    }
    if (!(Objects.equals(enforcedSampleLimit, that.enforcedSampleLimit))) {
      return false;
    }
    if (!(Objects.equals(enforcedTargetLimit, that.enforcedTargetLimit))) {
      return false;
    }
    if (!(Objects.equals(evaluationInterval, that.evaluationInterval))) {
      return false;
    }
    if (!(Objects.equals(excludedFromEnforcement, that.excludedFromEnforcement))) {
      return false;
    }
    if (!(Objects.equals(exemplars, that.exemplars))) {
      return false;
    }
    if (!(Objects.equals(externalLabels, that.externalLabels))) {
      return false;
    }
    if (!(Objects.equals(externalUrl, that.externalUrl))) {
      return false;
    }
    if (!(Objects.equals(hostAliases, that.hostAliases))) {
      return false;
    }
    if (!(Objects.equals(hostNetwork, that.hostNetwork))) {
      return false;
    }
    if (!(Objects.equals(hostUsers, that.hostUsers))) {
      return false;
    }
    if (!(Objects.equals(ignoreNamespaceSelectors, that.ignoreNamespaceSelectors))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(imagePullPolicy, that.imagePullPolicy))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecrets, that.imagePullSecrets))) {
      return false;
    }
    if (!(Objects.equals(initContainers, that.initContainers))) {
      return false;
    }
    if (!(Objects.equals(keepDroppedTargets, that.keepDroppedTargets))) {
      return false;
    }
    if (!(Objects.equals(labelLimit, that.labelLimit))) {
      return false;
    }
    if (!(Objects.equals(labelNameLengthLimit, that.labelNameLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(labelValueLengthLimit, that.labelValueLengthLimit))) {
      return false;
    }
    if (!(Objects.equals(listenLocal, that.listenLocal))) {
      return false;
    }
    if (!(Objects.equals(logFormat, that.logFormat))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(maximumStartupDurationSeconds, that.maximumStartupDurationSeconds))) {
      return false;
    }
    if (!(Objects.equals(minReadySeconds, that.minReadySeconds))) {
      return false;
    }
    if (!(Objects.equals(nameEscapingScheme, that.nameEscapingScheme))) {
      return false;
    }
    if (!(Objects.equals(nameValidationScheme, that.nameValidationScheme))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(otlp, that.otlp))) {
      return false;
    }
    if (!(Objects.equals(overrideHonorLabels, that.overrideHonorLabels))) {
      return false;
    }
    if (!(Objects.equals(overrideHonorTimestamps, that.overrideHonorTimestamps))) {
      return false;
    }
    if (!(Objects.equals(paused, that.paused))) {
      return false;
    }
    if (!(Objects.equals(persistentVolumeClaimRetentionPolicy, that.persistentVolumeClaimRetentionPolicy))) {
      return false;
    }
    if (!(Objects.equals(podManagementPolicy, that.podManagementPolicy))) {
      return false;
    }
    if (!(Objects.equals(podMetadata, that.podMetadata))) {
      return false;
    }
    if (!(Objects.equals(podMonitorNamespaceSelector, that.podMonitorNamespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(podMonitorSelector, that.podMonitorSelector))) {
      return false;
    }
    if (!(Objects.equals(podTargetLabels, that.podTargetLabels))) {
      return false;
    }
    if (!(Objects.equals(portName, that.portName))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(probeNamespaceSelector, that.probeNamespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(probeSelector, that.probeSelector))) {
      return false;
    }
    if (!(Objects.equals(prometheusExternalLabelName, that.prometheusExternalLabelName))) {
      return false;
    }
    if (!(Objects.equals(prometheusRulesExcludedFromEnforce, that.prometheusRulesExcludedFromEnforce))) {
      return false;
    }
    if (!(Objects.equals(query, that.query))) {
      return false;
    }
    if (!(Objects.equals(queryLogFile, that.queryLogFile))) {
      return false;
    }
    if (!(Objects.equals(reloadStrategy, that.reloadStrategy))) {
      return false;
    }
    if (!(Objects.equals(remoteRead, that.remoteRead))) {
      return false;
    }
    if (!(Objects.equals(remoteWrite, that.remoteWrite))) {
      return false;
    }
    if (!(Objects.equals(remoteWriteReceiverMessageVersions, that.remoteWriteReceiverMessageVersions))) {
      return false;
    }
    if (!(Objects.equals(replicaExternalLabelName, that.replicaExternalLabelName))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(retention, that.retention))) {
      return false;
    }
    if (!(Objects.equals(retentionSize, that.retentionSize))) {
      return false;
    }
    if (!(Objects.equals(routePrefix, that.routePrefix))) {
      return false;
    }
    if (!(Objects.equals(ruleNamespaceSelector, that.ruleNamespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(ruleQueryOffset, that.ruleQueryOffset))) {
      return false;
    }
    if (!(Objects.equals(ruleSelector, that.ruleSelector))) {
      return false;
    }
    if (!(Objects.equals(rules, that.rules))) {
      return false;
    }
    if (!(Objects.equals(runtime, that.runtime))) {
      return false;
    }
    if (!(Objects.equals(sampleLimit, that.sampleLimit))) {
      return false;
    }
    if (!(Objects.equals(schedulerName, that.schedulerName))) {
      return false;
    }
    if (!(Objects.equals(scrapeClasses, that.scrapeClasses))) {
      return false;
    }
    if (!(Objects.equals(scrapeClassicHistograms, that.scrapeClassicHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeConfigNamespaceSelector, that.scrapeConfigNamespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(scrapeConfigSelector, that.scrapeConfigSelector))) {
      return false;
    }
    if (!(Objects.equals(scrapeFailureLogFile, that.scrapeFailureLogFile))) {
      return false;
    }
    if (!(Objects.equals(scrapeInterval, that.scrapeInterval))) {
      return false;
    }
    if (!(Objects.equals(scrapeNativeHistograms, that.scrapeNativeHistograms))) {
      return false;
    }
    if (!(Objects.equals(scrapeProtocols, that.scrapeProtocols))) {
      return false;
    }
    if (!(Objects.equals(scrapeTimeout, that.scrapeTimeout))) {
      return false;
    }
    if (!(Objects.equals(secrets, that.secrets))) {
      return false;
    }
    if (!(Objects.equals(securityContext, that.securityContext))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(serviceDiscoveryRole, that.serviceDiscoveryRole))) {
      return false;
    }
    if (!(Objects.equals(serviceMonitorNamespaceSelector, that.serviceMonitorNamespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(serviceMonitorSelector, that.serviceMonitorSelector))) {
      return false;
    }
    if (!(Objects.equals(serviceName, that.serviceName))) {
      return false;
    }
    if (!(Objects.equals(sha, that.sha))) {
      return false;
    }
    if (!(Objects.equals(shardRetentionPolicy, that.shardRetentionPolicy))) {
      return false;
    }
    if (!(Objects.equals(shardingStrategy, that.shardingStrategy))) {
      return false;
    }
    if (!(Objects.equals(shards, that.shards))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
      return false;
    }
    if (!(Objects.equals(tag, that.tag))) {
      return false;
    }
    if (!(Objects.equals(targetLimit, that.targetLimit))) {
      return false;
    }
    if (!(Objects.equals(terminationGracePeriodSeconds, that.terminationGracePeriodSeconds))) {
      return false;
    }
    if (!(Objects.equals(thanos, that.thanos))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
      return false;
    }
    if (!(Objects.equals(topologySpreadConstraints, that.topologySpreadConstraints))) {
      return false;
    }
    if (!(Objects.equals(tracingConfig, that.tracingConfig))) {
      return false;
    }
    if (!(Objects.equals(tsdb, that.tsdb))) {
      return false;
    }
    if (!(Objects.equals(updateStrategy, that.updateStrategy))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
      return false;
    }
    if (!(Objects.equals(volumeMounts, that.volumeMounts))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
      return false;
    }
    if (!(Objects.equals(walCompression, that.walCompression))) {
      return false;
    }
    if (!(Objects.equals(web, that.web))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public SecretKeySelector getAdditionalAlertManagerConfigs() {
    return this.additionalAlertManagerConfigs;
  }
  
  public SecretKeySelector getAdditionalAlertRelabelConfigs() {
    return this.additionalAlertRelabelConfigs;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public SecretKeySelector getAdditionalScrapeConfigs() {
    return this.additionalScrapeConfigs;
  }
  
  public Affinity getAffinity() {
    return this.affinity;
  }
  
  public Boolean getAllowOverlappingBlocks() {
    return this.allowOverlappingBlocks;
  }
  
  public Boolean getAutomountServiceAccountToken() {
    return this.automountServiceAccountToken;
  }
  
  public String getBaseImage() {
    return this.baseImage;
  }
  
  public String getBodySizeLimit() {
    return this.bodySizeLimit;
  }
  
  public String getConfigMap(int index) {
    return this.configMaps.get(index);
  }
  
  public List<String> getConfigMaps() {
    return this.configMaps;
  }
  
  public Boolean getConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB;
  }
  
  public Boolean getDisableCompaction() {
    return this.disableCompaction;
  }
  
  public String getDnsPolicy() {
    return this.dnsPolicy;
  }
  
  public Boolean getEnableAdminAPI() {
    return this.enableAdminAPI;
  }
  
  public String getEnableFeature(int index) {
    return this.enableFeatures.get(index);
  }
  
  public List<String> getEnableFeatures() {
    return this.enableFeatures;
  }
  
  public Boolean getEnableOTLPReceiver() {
    return this.enableOTLPReceiver;
  }
  
  public Boolean getEnableRemoteWriteReceiver() {
    return this.enableRemoteWriteReceiver;
  }
  
  public Boolean getEnableServiceLinks() {
    return this.enableServiceLinks;
  }
  
  public String getEnforcedBodySizeLimit() {
    return this.enforcedBodySizeLimit;
  }
  
  public Long getEnforcedKeepDroppedTargets() {
    return this.enforcedKeepDroppedTargets;
  }
  
  public Long getEnforcedLabelLimit() {
    return this.enforcedLabelLimit;
  }
  
  public Long getEnforcedLabelNameLengthLimit() {
    return this.enforcedLabelNameLengthLimit;
  }
  
  public Long getEnforcedLabelValueLengthLimit() {
    return this.enforcedLabelValueLengthLimit;
  }
  
  public String getEnforcedNamespaceLabel() {
    return this.enforcedNamespaceLabel;
  }
  
  public Long getEnforcedSampleLimit() {
    return this.enforcedSampleLimit;
  }
  
  public Long getEnforcedTargetLimit() {
    return this.enforcedTargetLimit;
  }
  
  public String getEvaluationInterval() {
    return this.evaluationInterval;
  }
  
  public Map<String,String> getExternalLabels() {
    return this.externalLabels;
  }
  
  public String getExternalUrl() {
    return this.externalUrl;
  }
  
  public String getFirstConfigMap() {
    return this.configMaps.get(0);
  }
  
  public String getFirstEnableFeature() {
    return this.enableFeatures.get(0);
  }
  
  public String getFirstPodTargetLabel() {
    return this.podTargetLabels.get(0);
  }
  
  public String getFirstRemoteWriteReceiverMessageVersion() {
    return this.remoteWriteReceiverMessageVersions.get(0);
  }
  
  public String getFirstScrapeProtocol() {
    return this.scrapeProtocols.get(0);
  }
  
  public String getFirstSecret() {
    return this.secrets.get(0);
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public Boolean getHostNetwork() {
    return this.hostNetwork;
  }
  
  public Boolean getHostUsers() {
    return this.hostUsers;
  }
  
  public Boolean getIgnoreNamespaceSelectors() {
    return this.ignoreNamespaceSelectors;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public Long getKeepDroppedTargets() {
    return this.keepDroppedTargets;
  }
  
  public Long getLabelLimit() {
    return this.labelLimit;
  }
  
  public Long getLabelNameLengthLimit() {
    return this.labelNameLengthLimit;
  }
  
  public Long getLabelValueLengthLimit() {
    return this.labelValueLengthLimit;
  }
  
  public String getLastConfigMap() {
    return this.configMaps.get(configMaps.size() - 1);
  }
  
  public String getLastEnableFeature() {
    return this.enableFeatures.get(enableFeatures.size() - 1);
  }
  
  public String getLastPodTargetLabel() {
    return this.podTargetLabels.get(podTargetLabels.size() - 1);
  }
  
  public String getLastRemoteWriteReceiverMessageVersion() {
    return this.remoteWriteReceiverMessageVersions.get(remoteWriteReceiverMessageVersions.size() - 1);
  }
  
  public String getLastScrapeProtocol() {
    return this.scrapeProtocols.get(scrapeProtocols.size() - 1);
  }
  
  public String getLastSecret() {
    return this.secrets.get(secrets.size() - 1);
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public Boolean getListenLocal() {
    return this.listenLocal;
  }
  
  public String getLogFormat() {
    return this.logFormat;
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getMatchingConfigMap(Predicate<String> predicate) {
      for (String item : configMaps) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingEnableFeature(Predicate<String> predicate) {
      for (String item : enableFeatures) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPodTargetLabel(Predicate<String> predicate) {
      for (String item : podTargetLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingRemoteWriteReceiverMessageVersion(Predicate<String> predicate) {
      for (String item : remoteWriteReceiverMessageVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSecret(Predicate<String> predicate) {
      for (String item : secrets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Toleration getMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMaximumStartupDurationSeconds() {
    return this.maximumStartupDurationSeconds;
  }
  
  public Integer getMinReadySeconds() {
    return this.minReadySeconds;
  }
  
  public String getNameEscapingScheme() {
    return this.nameEscapingScheme;
  }
  
  public String getNameValidationScheme() {
    return this.nameValidationScheme;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public Boolean getOverrideHonorLabels() {
    return this.overrideHonorLabels;
  }
  
  public Boolean getOverrideHonorTimestamps() {
    return this.overrideHonorTimestamps;
  }
  
  public Boolean getPaused() {
    return this.paused;
  }
  
  public StatefulSetPersistentVolumeClaimRetentionPolicy getPersistentVolumeClaimRetentionPolicy() {
    return this.persistentVolumeClaimRetentionPolicy;
  }
  
  public String getPodManagementPolicy() {
    return this.podManagementPolicy;
  }
  
  public String getPodTargetLabel(int index) {
    return this.podTargetLabels.get(index);
  }
  
  public List<String> getPodTargetLabels() {
    return this.podTargetLabels;
  }
  
  public String getPortName() {
    return this.portName;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public String getPrometheusExternalLabelName() {
    return this.prometheusExternalLabelName;
  }
  
  public String getQueryLogFile() {
    return this.queryLogFile;
  }
  
  public String getReloadStrategy() {
    return this.reloadStrategy;
  }
  
  public String getRemoteWriteReceiverMessageVersion(int index) {
    return this.remoteWriteReceiverMessageVersions.get(index);
  }
  
  public List<String> getRemoteWriteReceiverMessageVersions() {
    return this.remoteWriteReceiverMessageVersions;
  }
  
  public String getReplicaExternalLabelName() {
    return this.replicaExternalLabelName;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getRetention() {
    return this.retention;
  }
  
  public String getRetentionSize() {
    return this.retentionSize;
  }
  
  public String getRoutePrefix() {
    return this.routePrefix;
  }
  
  public String getRuleQueryOffset() {
    return this.ruleQueryOffset;
  }
  
  public Long getSampleLimit() {
    return this.sampleLimit;
  }
  
  public String getSchedulerName() {
    return this.schedulerName;
  }
  
  public Boolean getScrapeClassicHistograms() {
    return this.scrapeClassicHistograms;
  }
  
  public String getScrapeFailureLogFile() {
    return this.scrapeFailureLogFile;
  }
  
  public String getScrapeInterval() {
    return this.scrapeInterval;
  }
  
  public Boolean getScrapeNativeHistograms() {
    return this.scrapeNativeHistograms;
  }
  
  public String getScrapeProtocol(int index) {
    return this.scrapeProtocols.get(index);
  }
  
  public List<String> getScrapeProtocols() {
    return this.scrapeProtocols;
  }
  
  public String getScrapeTimeout() {
    return this.scrapeTimeout;
  }
  
  public String getSecret(int index) {
    return this.secrets.get(index);
  }
  
  public List<String> getSecrets() {
    return this.secrets;
  }
  
  public PodSecurityContext getSecurityContext() {
    return this.securityContext;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public String getServiceDiscoveryRole() {
    return this.serviceDiscoveryRole;
  }
  
  public String getServiceName() {
    return this.serviceName;
  }
  
  public String getSha() {
    return this.sha;
  }
  
  public Integer getShards() {
    return this.shards;
  }
  
  public String getTag() {
    return this.tag;
  }
  
  public Long getTargetLimit() {
    return this.targetLimit;
  }
  
  public Long getTerminationGracePeriodSeconds() {
    return this.terminationGracePeriodSeconds;
  }
  
  public Toleration getToleration(int index) {
    return this.tolerations.get(index);
  }
  
  public List<Toleration> getTolerations() {
    return this.tolerations;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public Boolean getWalCompression() {
    return this.walCompression;
  }
  
  public boolean hasAdditionalAlertManagerConfigs() {
    return this.additionalAlertManagerConfigs != null;
  }
  
  public boolean hasAdditionalAlertRelabelConfigs() {
    return this.additionalAlertRelabelConfigs != null;
  }
  
  public boolean hasAdditionalArgs() {
    return this.additionalArgs != null && !(this.additionalArgs.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalScrapeConfigs() {
    return this.additionalScrapeConfigs != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasAlerting() {
    return this.alerting != null;
  }
  
  public boolean hasAllowOverlappingBlocks() {
    return this.allowOverlappingBlocks != null;
  }
  
  public boolean hasApiserverConfig() {
    return this.apiserverConfig != null;
  }
  
  public boolean hasArbitraryFSAccessThroughSMs() {
    return this.arbitraryFSAccessThroughSMs != null;
  }
  
  public boolean hasAutomountServiceAccountToken() {
    return this.automountServiceAccountToken != null;
  }
  
  public boolean hasBaseImage() {
    return this.baseImage != null;
  }
  
  public boolean hasBodySizeLimit() {
    return this.bodySizeLimit != null;
  }
  
  public boolean hasConfigMaps() {
    return this.configMaps != null && !(this.configMaps.isEmpty());
  }
  
  public boolean hasContainers() {
    return this.containers != null && !(this.containers.isEmpty());
  }
  
  public boolean hasConvertClassicHistogramsToNHCB() {
    return this.convertClassicHistogramsToNHCB != null;
  }
  
  public boolean hasDisableCompaction() {
    return this.disableCompaction != null;
  }
  
  public boolean hasDnsConfig() {
    return this.dnsConfig != null;
  }
  
  public boolean hasDnsPolicy() {
    return this.dnsPolicy != null;
  }
  
  public boolean hasEnableAdminAPI() {
    return this.enableAdminAPI != null;
  }
  
  public boolean hasEnableFeatures() {
    return this.enableFeatures != null && !(this.enableFeatures.isEmpty());
  }
  
  public boolean hasEnableOTLPReceiver() {
    return this.enableOTLPReceiver != null;
  }
  
  public boolean hasEnableRemoteWriteReceiver() {
    return this.enableRemoteWriteReceiver != null;
  }
  
  public boolean hasEnableServiceLinks() {
    return this.enableServiceLinks != null;
  }
  
  public boolean hasEnforcedBodySizeLimit() {
    return this.enforcedBodySizeLimit != null;
  }
  
  public boolean hasEnforcedKeepDroppedTargets() {
    return this.enforcedKeepDroppedTargets != null;
  }
  
  public boolean hasEnforcedLabelLimit() {
    return this.enforcedLabelLimit != null;
  }
  
  public boolean hasEnforcedLabelNameLengthLimit() {
    return this.enforcedLabelNameLengthLimit != null;
  }
  
  public boolean hasEnforcedLabelValueLengthLimit() {
    return this.enforcedLabelValueLengthLimit != null;
  }
  
  public boolean hasEnforcedNamespaceLabel() {
    return this.enforcedNamespaceLabel != null;
  }
  
  public boolean hasEnforcedSampleLimit() {
    return this.enforcedSampleLimit != null;
  }
  
  public boolean hasEnforcedTargetLimit() {
    return this.enforcedTargetLimit != null;
  }
  
  public boolean hasEvaluationInterval() {
    return this.evaluationInterval != null;
  }
  
  public boolean hasExcludedFromEnforcement() {
    return this.excludedFromEnforcement != null && !(this.excludedFromEnforcement.isEmpty());
  }
  
  public boolean hasExemplars() {
    return this.exemplars != null;
  }
  
  public boolean hasExternalLabels() {
    return this.externalLabels != null;
  }
  
  public boolean hasExternalUrl() {
    return this.externalUrl != null;
  }
  
  public boolean hasHostAliases() {
    return this.hostAliases != null && !(this.hostAliases.isEmpty());
  }
  
  public boolean hasHostNetwork() {
    return this.hostNetwork != null;
  }
  
  public boolean hasHostUsers() {
    return this.hostUsers != null;
  }
  
  public boolean hasIgnoreNamespaceSelectors() {
    return this.ignoreNamespaceSelectors != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasImagePullPolicy() {
    return this.imagePullPolicy != null;
  }
  
  public boolean hasImagePullSecrets() {
    return this.imagePullSecrets != null && !(this.imagePullSecrets.isEmpty());
  }
  
  public boolean hasInitContainers() {
    return this.initContainers != null && !(this.initContainers.isEmpty());
  }
  
  public boolean hasKeepDroppedTargets() {
    return this.keepDroppedTargets != null;
  }
  
  public boolean hasLabelLimit() {
    return this.labelLimit != null;
  }
  
  public boolean hasLabelNameLengthLimit() {
    return this.labelNameLengthLimit != null;
  }
  
  public boolean hasLabelValueLengthLimit() {
    return this.labelValueLengthLimit != null;
  }
  
  public boolean hasListenLocal() {
    return this.listenLocal != null;
  }
  
  public boolean hasLogFormat() {
    return this.logFormat != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasMatchingAdditionalArg(Predicate<ArgumentBuilder> predicate) {
      for (ArgumentBuilder item : additionalArgs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConfigMap(Predicate<String> predicate) {
      for (String item : configMaps) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingContainer(Predicate<ContainerBuilder> predicate) {
      for (ContainerBuilder item : containers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEnableFeature(Predicate<String> predicate) {
      for (String item : enableFeatures) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingExcludedFromEnforcement(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : excludedFromEnforcement) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHostAlias(Predicate<HostAliasBuilder> predicate) {
      for (HostAliasBuilder item : hostAliases) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImagePullSecret(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : imagePullSecrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInitContainer(Predicate<ContainerBuilder> predicate) {
      for (ContainerBuilder item : initContainers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPodTargetLabel(Predicate<String> predicate) {
      for (String item : podTargetLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPrometheusRulesExcludedFromEnforce(Predicate<PrometheusRuleExcludeConfigBuilder> predicate) {
      for (PrometheusRuleExcludeConfigBuilder item : prometheusRulesExcludedFromEnforce) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRemoteRead(Predicate<RemoteReadSpecBuilder> predicate) {
      for (RemoteReadSpecBuilder item : remoteRead) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRemoteWrite(Predicate<RemoteWriteSpecBuilder> predicate) {
      for (RemoteWriteSpecBuilder item : remoteWrite) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRemoteWriteReceiverMessageVersion(Predicate<String> predicate) {
      for (String item : remoteWriteReceiverMessageVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScrapeClass(Predicate<ScrapeClassBuilder> predicate) {
      for (ScrapeClassBuilder item : scrapeClasses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingScrapeProtocol(Predicate<String> predicate) {
      for (String item : scrapeProtocols) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecret(Predicate<String> predicate) {
      for (String item : secrets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTopologySpreadConstraint(Predicate<TopologySpreadConstraintBuilder> predicate) {
      for (TopologySpreadConstraintBuilder item : topologySpreadConstraints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolume(Predicate<VolumeBuilder> predicate) {
      for (VolumeBuilder item : volumes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVolumeMount(Predicate<VolumeMountBuilder> predicate) {
      for (VolumeMountBuilder item : volumeMounts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaximumStartupDurationSeconds() {
    return this.maximumStartupDurationSeconds != null;
  }
  
  public boolean hasMinReadySeconds() {
    return this.minReadySeconds != null;
  }
  
  public boolean hasNameEscapingScheme() {
    return this.nameEscapingScheme != null;
  }
  
  public boolean hasNameValidationScheme() {
    return this.nameValidationScheme != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasOtlp() {
    return this.otlp != null;
  }
  
  public boolean hasOverrideHonorLabels() {
    return this.overrideHonorLabels != null;
  }
  
  public boolean hasOverrideHonorTimestamps() {
    return this.overrideHonorTimestamps != null;
  }
  
  public boolean hasPaused() {
    return this.paused != null;
  }
  
  public boolean hasPersistentVolumeClaimRetentionPolicy() {
    return this.persistentVolumeClaimRetentionPolicy != null;
  }
  
  public boolean hasPodManagementPolicy() {
    return this.podManagementPolicy != null;
  }
  
  public boolean hasPodMetadata() {
    return this.podMetadata != null;
  }
  
  public boolean hasPodMonitorNamespaceSelector() {
    return this.podMonitorNamespaceSelector != null;
  }
  
  public boolean hasPodMonitorSelector() {
    return this.podMonitorSelector != null;
  }
  
  public boolean hasPodTargetLabels() {
    return this.podTargetLabels != null && !(this.podTargetLabels.isEmpty());
  }
  
  public boolean hasPortName() {
    return this.portName != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasProbeNamespaceSelector() {
    return this.probeNamespaceSelector != null;
  }
  
  public boolean hasProbeSelector() {
    return this.probeSelector != null;
  }
  
  public boolean hasPrometheusExternalLabelName() {
    return this.prometheusExternalLabelName != null;
  }
  
  public boolean hasPrometheusRulesExcludedFromEnforce() {
    return this.prometheusRulesExcludedFromEnforce != null && !(this.prometheusRulesExcludedFromEnforce.isEmpty());
  }
  
  public boolean hasQuery() {
    return this.query != null;
  }
  
  public boolean hasQueryLogFile() {
    return this.queryLogFile != null;
  }
  
  public boolean hasReloadStrategy() {
    return this.reloadStrategy != null;
  }
  
  public boolean hasRemoteRead() {
    return this.remoteRead != null && !(this.remoteRead.isEmpty());
  }
  
  public boolean hasRemoteWrite() {
    return this.remoteWrite != null && !(this.remoteWrite.isEmpty());
  }
  
  public boolean hasRemoteWriteReceiverMessageVersions() {
    return this.remoteWriteReceiverMessageVersions != null && !(this.remoteWriteReceiverMessageVersions.isEmpty());
  }
  
  public boolean hasReplicaExternalLabelName() {
    return this.replicaExternalLabelName != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRetention() {
    return this.retention != null;
  }
  
  public boolean hasRetentionSize() {
    return this.retentionSize != null;
  }
  
  public boolean hasRoutePrefix() {
    return this.routePrefix != null;
  }
  
  public boolean hasRuleNamespaceSelector() {
    return this.ruleNamespaceSelector != null;
  }
  
  public boolean hasRuleQueryOffset() {
    return this.ruleQueryOffset != null;
  }
  
  public boolean hasRuleSelector() {
    return this.ruleSelector != null;
  }
  
  public boolean hasRules() {
    return this.rules != null;
  }
  
  public boolean hasRuntime() {
    return this.runtime != null;
  }
  
  public boolean hasSampleLimit() {
    return this.sampleLimit != null;
  }
  
  public boolean hasSchedulerName() {
    return this.schedulerName != null;
  }
  
  public boolean hasScrapeClasses() {
    return this.scrapeClasses != null && !(this.scrapeClasses.isEmpty());
  }
  
  public boolean hasScrapeClassicHistograms() {
    return this.scrapeClassicHistograms != null;
  }
  
  public boolean hasScrapeConfigNamespaceSelector() {
    return this.scrapeConfigNamespaceSelector != null;
  }
  
  public boolean hasScrapeConfigSelector() {
    return this.scrapeConfigSelector != null;
  }
  
  public boolean hasScrapeFailureLogFile() {
    return this.scrapeFailureLogFile != null;
  }
  
  public boolean hasScrapeInterval() {
    return this.scrapeInterval != null;
  }
  
  public boolean hasScrapeNativeHistograms() {
    return this.scrapeNativeHistograms != null;
  }
  
  public boolean hasScrapeProtocols() {
    return this.scrapeProtocols != null && !(this.scrapeProtocols.isEmpty());
  }
  
  public boolean hasScrapeTimeout() {
    return this.scrapeTimeout != null;
  }
  
  public boolean hasSecrets() {
    return this.secrets != null && !(this.secrets.isEmpty());
  }
  
  public boolean hasSecurityContext() {
    return this.securityContext != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasServiceDiscoveryRole() {
    return this.serviceDiscoveryRole != null;
  }
  
  public boolean hasServiceMonitorNamespaceSelector() {
    return this.serviceMonitorNamespaceSelector != null;
  }
  
  public boolean hasServiceMonitorSelector() {
    return this.serviceMonitorSelector != null;
  }
  
  public boolean hasServiceName() {
    return this.serviceName != null;
  }
  
  public boolean hasSha() {
    return this.sha != null;
  }
  
  public boolean hasShardRetentionPolicy() {
    return this.shardRetentionPolicy != null;
  }
  
  public boolean hasShardingStrategy() {
    return this.shardingStrategy != null;
  }
  
  public boolean hasShards() {
    return this.shards != null;
  }
  
  public boolean hasStorage() {
    return this.storage != null;
  }
  
  public boolean hasTag() {
    return this.tag != null;
  }
  
  public boolean hasTargetLimit() {
    return this.targetLimit != null;
  }
  
  public boolean hasTerminationGracePeriodSeconds() {
    return this.terminationGracePeriodSeconds != null;
  }
  
  public boolean hasThanos() {
    return this.thanos != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public boolean hasTopologySpreadConstraints() {
    return this.topologySpreadConstraints != null && !(this.topologySpreadConstraints.isEmpty());
  }
  
  public boolean hasTracingConfig() {
    return this.tracingConfig != null;
  }
  
  public boolean hasTsdb() {
    return this.tsdb != null;
  }
  
  public boolean hasUpdateStrategy() {
    return this.updateStrategy != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public boolean hasVolumeMounts() {
    return this.volumeMounts != null && !(this.volumeMounts.isEmpty());
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public boolean hasWalCompression() {
    return this.walCompression != null;
  }
  
  public boolean hasWeb() {
    return this.web != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalAlertManagerConfigs, additionalAlertRelabelConfigs, additionalArgs, additionalScrapeConfigs, affinity, alerting, allowOverlappingBlocks, apiserverConfig, arbitraryFSAccessThroughSMs, automountServiceAccountToken, baseImage, bodySizeLimit, configMaps, containers, convertClassicHistogramsToNHCB, disableCompaction, dnsConfig, dnsPolicy, enableAdminAPI, enableFeatures, enableOTLPReceiver, enableRemoteWriteReceiver, enableServiceLinks, enforcedBodySizeLimit, enforcedKeepDroppedTargets, enforcedLabelLimit, enforcedLabelNameLengthLimit, enforcedLabelValueLengthLimit, enforcedNamespaceLabel, enforcedSampleLimit, enforcedTargetLimit, evaluationInterval, excludedFromEnforcement, exemplars, externalLabels, externalUrl, hostAliases, hostNetwork, hostUsers, ignoreNamespaceSelectors, image, imagePullPolicy, imagePullSecrets, initContainers, keepDroppedTargets, labelLimit, labelNameLengthLimit, labelValueLengthLimit, listenLocal, logFormat, logLevel, maximumStartupDurationSeconds, minReadySeconds, nameEscapingScheme, nameValidationScheme, nodeSelector, otlp, overrideHonorLabels, overrideHonorTimestamps, paused, persistentVolumeClaimRetentionPolicy, podManagementPolicy, podMetadata, podMonitorNamespaceSelector, podMonitorSelector, podTargetLabels, portName, priorityClassName, probeNamespaceSelector, probeSelector, prometheusExternalLabelName, prometheusRulesExcludedFromEnforce, query, queryLogFile, reloadStrategy, remoteRead, remoteWrite, remoteWriteReceiverMessageVersions, replicaExternalLabelName, replicas, resources, retention, retentionSize, routePrefix, ruleNamespaceSelector, ruleQueryOffset, ruleSelector, rules, runtime, sampleLimit, schedulerName, scrapeClasses, scrapeClassicHistograms, scrapeConfigNamespaceSelector, scrapeConfigSelector, scrapeFailureLogFile, scrapeInterval, scrapeNativeHistograms, scrapeProtocols, scrapeTimeout, secrets, securityContext, serviceAccountName, serviceDiscoveryRole, serviceMonitorNamespaceSelector, serviceMonitorSelector, serviceName, sha, shardRetentionPolicy, shardingStrategy, shards, storage, tag, targetLimit, terminationGracePeriodSeconds, thanos, tolerations, topologySpreadConstraints, tracingConfig, tsdb, updateStrategy, version, volumeMounts, volumes, walCompression, web, additionalProperties);
  }
  
  public A removeAllFromAdditionalArgs(Collection<Argument> items) {
    if (this.additionalArgs == null) {
      return (A) this;
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").remove(builder);
        this.additionalArgs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConfigMaps(Collection<String> items) {
    if (this.configMaps == null) {
      return (A) this;
    }
    for (String item : items) {
      this.configMaps.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromContainers(Collection<Container> items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("containers").remove(builder);
        this.containers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEnableFeatures(Collection<String> items) {
    if (this.enableFeatures == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enableFeatures.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromExcludedFromEnforcement(Collection<ObjectReference> items) {
    if (this.excludedFromEnforcement == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("excludedFromEnforcement").remove(builder);
        this.excludedFromEnforcement.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHostAliases(Collection<HostAlias> items) {
    if (this.hostAliases == null) {
      return (A) this;
    }
    for (HostAlias item : items) {
        HostAliasBuilder builder = new HostAliasBuilder(item);
        _visitables.get("hostAliases").remove(builder);
        this.hostAliases.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromImagePullSecrets(Collection<LocalObjectReference> items) {
    if (this.imagePullSecrets == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").remove(builder);
        this.imagePullSecrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromInitContainers(Collection<Container> items) {
    if (this.initContainers == null) {
      return (A) this;
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("initContainers").remove(builder);
        this.initContainers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPodTargetLabels(Collection<String> items) {
    if (this.podTargetLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podTargetLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPrometheusRulesExcludedFromEnforce(Collection<PrometheusRuleExcludeConfig> items) {
    if (this.prometheusRulesExcludedFromEnforce == null) {
      return (A) this;
    }
    for (PrometheusRuleExcludeConfig item : items) {
        PrometheusRuleExcludeConfigBuilder builder = new PrometheusRuleExcludeConfigBuilder(item);
        _visitables.get("prometheusRulesExcludedFromEnforce").remove(builder);
        this.prometheusRulesExcludedFromEnforce.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRemoteRead(Collection<RemoteReadSpec> items) {
    if (this.remoteRead == null) {
      return (A) this;
    }
    for (RemoteReadSpec item : items) {
        RemoteReadSpecBuilder builder = new RemoteReadSpecBuilder(item);
        _visitables.get("remoteRead").remove(builder);
        this.remoteRead.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRemoteWrite(Collection<RemoteWriteSpec> items) {
    if (this.remoteWrite == null) {
      return (A) this;
    }
    for (RemoteWriteSpec item : items) {
        RemoteWriteSpecBuilder builder = new RemoteWriteSpecBuilder(item);
        _visitables.get("remoteWrite").remove(builder);
        this.remoteWrite.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRemoteWriteReceiverMessageVersions(Collection<String> items) {
    if (this.remoteWriteReceiverMessageVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remoteWriteReceiverMessageVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromScrapeClasses(Collection<ScrapeClass> items) {
    if (this.scrapeClasses == null) {
      return (A) this;
    }
    for (ScrapeClass item : items) {
        ScrapeClassBuilder builder = new ScrapeClassBuilder(item);
        _visitables.get("scrapeClasses").remove(builder);
        this.scrapeClasses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromScrapeProtocols(Collection<String> items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSecrets(Collection<String> items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.secrets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTopologySpreadConstraints(Collection<TopologySpreadConstraint> items) {
    if (this.topologySpreadConstraints == null) {
      return (A) this;
    }
    for (TopologySpreadConstraint item : items) {
        TopologySpreadConstraintBuilder builder = new TopologySpreadConstraintBuilder(item);
        _visitables.get("topologySpreadConstraints").remove(builder);
        this.topologySpreadConstraints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumeMounts(Collection<VolumeMount> items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVolumes(Collection<Volume> items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalArgs(Argument... items) {
    if (this.additionalArgs == null) {
      return (A) this;
    }
    for (Argument item : items) {
        ArgumentBuilder builder = new ArgumentBuilder(item);
        _visitables.get("additionalArgs").remove(builder);
        this.additionalArgs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConfigMaps(String... items) {
    if (this.configMaps == null) {
      return (A) this;
    }
    for (String item : items) {
      this.configMaps.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromContainers(Container... items) {
    if (this.containers == null) {
      return (A) this;
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("containers").remove(builder);
        this.containers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEnableFeatures(String... items) {
    if (this.enableFeatures == null) {
      return (A) this;
    }
    for (String item : items) {
      this.enableFeatures.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromExcludedFromEnforcement(ObjectReference... items) {
    if (this.excludedFromEnforcement == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("excludedFromEnforcement").remove(builder);
        this.excludedFromEnforcement.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromExternalLabels(String key) {
    if (this.externalLabels == null) {
      return (A) this;
    }
    if (key != null && this.externalLabels != null) {
      this.externalLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExternalLabels(Map<String,String> map) {
    if (this.externalLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.externalLabels != null) {
          this.externalLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromHostAliases(HostAlias... items) {
    if (this.hostAliases == null) {
      return (A) this;
    }
    for (HostAlias item : items) {
        HostAliasBuilder builder = new HostAliasBuilder(item);
        _visitables.get("hostAliases").remove(builder);
        this.hostAliases.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromImagePullSecrets(LocalObjectReference... items) {
    if (this.imagePullSecrets == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("imagePullSecrets").remove(builder);
        this.imagePullSecrets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromInitContainers(Container... items) {
    if (this.initContainers == null) {
      return (A) this;
    }
    for (Container item : items) {
        ContainerBuilder builder = new ContainerBuilder(item);
        _visitables.get("initContainers").remove(builder);
        this.initContainers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(String key) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (key != null && this.nodeSelector != null) {
      this.nodeSelector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromNodeSelector(Map<String,String> map) {
    if (this.nodeSelector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.nodeSelector != null) {
          this.nodeSelector.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPodTargetLabels(String... items) {
    if (this.podTargetLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.podTargetLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPrometheusRulesExcludedFromEnforce(PrometheusRuleExcludeConfig... items) {
    if (this.prometheusRulesExcludedFromEnforce == null) {
      return (A) this;
    }
    for (PrometheusRuleExcludeConfig item : items) {
        PrometheusRuleExcludeConfigBuilder builder = new PrometheusRuleExcludeConfigBuilder(item);
        _visitables.get("prometheusRulesExcludedFromEnforce").remove(builder);
        this.prometheusRulesExcludedFromEnforce.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRemoteRead(RemoteReadSpec... items) {
    if (this.remoteRead == null) {
      return (A) this;
    }
    for (RemoteReadSpec item : items) {
        RemoteReadSpecBuilder builder = new RemoteReadSpecBuilder(item);
        _visitables.get("remoteRead").remove(builder);
        this.remoteRead.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRemoteWrite(RemoteWriteSpec... items) {
    if (this.remoteWrite == null) {
      return (A) this;
    }
    for (RemoteWriteSpec item : items) {
        RemoteWriteSpecBuilder builder = new RemoteWriteSpecBuilder(item);
        _visitables.get("remoteWrite").remove(builder);
        this.remoteWrite.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRemoteWriteReceiverMessageVersions(String... items) {
    if (this.remoteWriteReceiverMessageVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remoteWriteReceiverMessageVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromScrapeClasses(ScrapeClass... items) {
    if (this.scrapeClasses == null) {
      return (A) this;
    }
    for (ScrapeClass item : items) {
        ScrapeClassBuilder builder = new ScrapeClassBuilder(item);
        _visitables.get("scrapeClasses").remove(builder);
        this.scrapeClasses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromScrapeProtocols(String... items) {
    if (this.scrapeProtocols == null) {
      return (A) this;
    }
    for (String item : items) {
      this.scrapeProtocols.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSecrets(String... items) {
    if (this.secrets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.secrets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
      this.tolerations.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTopologySpreadConstraints(TopologySpreadConstraint... items) {
    if (this.topologySpreadConstraints == null) {
      return (A) this;
    }
    for (TopologySpreadConstraint item : items) {
        TopologySpreadConstraintBuilder builder = new TopologySpreadConstraintBuilder(item);
        _visitables.get("topologySpreadConstraints").remove(builder);
        this.topologySpreadConstraints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVolumeMounts(VolumeMount... items) {
    if (this.volumeMounts == null) {
      return (A) this;
    }
    for (VolumeMount item : items) {
        VolumeMountBuilder builder = new VolumeMountBuilder(item);
        _visitables.get("volumeMounts").remove(builder);
        this.volumeMounts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVolumes(Volume... items) {
    if (this.volumes == null) {
      return (A) this;
    }
    for (Volume item : items) {
        VolumeBuilder builder = new VolumeBuilder(item);
        _visitables.get("volumes").remove(builder);
        this.volumes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalArgs(Predicate<ArgumentBuilder> predicate) {
    if (additionalArgs == null) {
      return (A) this;
    }
    Iterator<ArgumentBuilder> each = additionalArgs.iterator();
    List visitables = _visitables.get("additionalArgs");
    while (each.hasNext()) {
        ArgumentBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainers(Predicate<ContainerBuilder> predicate) {
    if (containers == null) {
      return (A) this;
    }
    Iterator<ContainerBuilder> each = containers.iterator();
    List visitables = _visitables.get("containers");
    while (each.hasNext()) {
        ContainerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromExcludedFromEnforcement(Predicate<ObjectReferenceBuilder> predicate) {
    if (excludedFromEnforcement == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = excludedFromEnforcement.iterator();
    List visitables = _visitables.get("excludedFromEnforcement");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHostAliases(Predicate<HostAliasBuilder> predicate) {
    if (hostAliases == null) {
      return (A) this;
    }
    Iterator<HostAliasBuilder> each = hostAliases.iterator();
    List visitables = _visitables.get("hostAliases");
    while (each.hasNext()) {
        HostAliasBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImagePullSecrets(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (imagePullSecrets == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = imagePullSecrets.iterator();
    List visitables = _visitables.get("imagePullSecrets");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromInitContainers(Predicate<ContainerBuilder> predicate) {
    if (initContainers == null) {
      return (A) this;
    }
    Iterator<ContainerBuilder> each = initContainers.iterator();
    List visitables = _visitables.get("initContainers");
    while (each.hasNext()) {
        ContainerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPrometheusRulesExcludedFromEnforce(Predicate<PrometheusRuleExcludeConfigBuilder> predicate) {
    if (prometheusRulesExcludedFromEnforce == null) {
      return (A) this;
    }
    Iterator<PrometheusRuleExcludeConfigBuilder> each = prometheusRulesExcludedFromEnforce.iterator();
    List visitables = _visitables.get("prometheusRulesExcludedFromEnforce");
    while (each.hasNext()) {
        PrometheusRuleExcludeConfigBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRemoteRead(Predicate<RemoteReadSpecBuilder> predicate) {
    if (remoteRead == null) {
      return (A) this;
    }
    Iterator<RemoteReadSpecBuilder> each = remoteRead.iterator();
    List visitables = _visitables.get("remoteRead");
    while (each.hasNext()) {
        RemoteReadSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRemoteWrite(Predicate<RemoteWriteSpecBuilder> predicate) {
    if (remoteWrite == null) {
      return (A) this;
    }
    Iterator<RemoteWriteSpecBuilder> each = remoteWrite.iterator();
    List visitables = _visitables.get("remoteWrite");
    while (each.hasNext()) {
        RemoteWriteSpecBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromScrapeClasses(Predicate<ScrapeClassBuilder> predicate) {
    if (scrapeClasses == null) {
      return (A) this;
    }
    Iterator<ScrapeClassBuilder> each = scrapeClasses.iterator();
    List visitables = _visitables.get("scrapeClasses");
    while (each.hasNext()) {
        ScrapeClassBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTopologySpreadConstraints(Predicate<TopologySpreadConstraintBuilder> predicate) {
    if (topologySpreadConstraints == null) {
      return (A) this;
    }
    Iterator<TopologySpreadConstraintBuilder> each = topologySpreadConstraints.iterator();
    List visitables = _visitables.get("topologySpreadConstraints");
    while (each.hasNext()) {
        TopologySpreadConstraintBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumeMounts(Predicate<VolumeMountBuilder> predicate) {
    if (volumeMounts == null) {
      return (A) this;
    }
    Iterator<VolumeMountBuilder> each = volumeMounts.iterator();
    List visitables = _visitables.get("volumeMounts");
    while (each.hasNext()) {
        VolumeMountBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVolumes(Predicate<VolumeBuilder> predicate) {
    if (volumes == null) {
      return (A) this;
    }
    Iterator<VolumeBuilder> each = volumes.iterator();
    List visitables = _visitables.get("volumes");
    while (each.hasNext()) {
        VolumeBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalArgsNested<A> setNewAdditionalArgLike(int index,Argument item) {
    return new AdditionalArgsNested(index, item);
  }
  
  public ContainersNested<A> setNewContainerLike(int index,Container item) {
    return new ContainersNested(index, item);
  }
  
  public ExcludedFromEnforcementNested<A> setNewExcludedFromEnforcementLike(int index,ObjectReference item) {
    return new ExcludedFromEnforcementNested(index, item);
  }
  
  public HostAliasesNested<A> setNewHostAliasLike(int index,HostAlias item) {
    return new HostAliasesNested(index, item);
  }
  
  public ImagePullSecretsNested<A> setNewImagePullSecretLike(int index,LocalObjectReference item) {
    return new ImagePullSecretsNested(index, item);
  }
  
  public InitContainersNested<A> setNewInitContainerLike(int index,Container item) {
    return new InitContainersNested(index, item);
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> setNewPrometheusRulesExcludedFromEnforceLike(int index,PrometheusRuleExcludeConfig item) {
    return new PrometheusRulesExcludedFromEnforceNested(index, item);
  }
  
  public RemoteReadNested<A> setNewRemoteReadLike(int index,RemoteReadSpec item) {
    return new RemoteReadNested(index, item);
  }
  
  public RemoteWriteNested<A> setNewRemoteWriteLike(int index,RemoteWriteSpec item) {
    return new RemoteWriteNested(index, item);
  }
  
  public ScrapeClassesNested<A> setNewScrapeClassLike(int index,ScrapeClass item) {
    return new ScrapeClassesNested(index, item);
  }
  
  public TopologySpreadConstraintsNested<A> setNewTopologySpreadConstraintLike(int index,TopologySpreadConstraint item) {
    return new TopologySpreadConstraintsNested(index, item);
  }
  
  public VolumesNested<A> setNewVolumeLike(int index,Volume item) {
    return new VolumesNested(index, item);
  }
  
  public VolumeMountsNested<A> setNewVolumeMountLike(int index,VolumeMount item) {
    return new VolumeMountsNested(index, item);
  }
  
  public A setToAdditionalArgs(int index,Argument item) {
    if (this.additionalArgs == null) {
      this.additionalArgs = new ArrayList();
    }
    ArgumentBuilder builder = new ArgumentBuilder(item);
    if (index < 0 || index >= additionalArgs.size()) {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.add(builder);
    } else {
        _visitables.get("additionalArgs").add(builder);
        additionalArgs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConfigMaps(int index,String item) {
    if (this.configMaps == null) {
      this.configMaps = new ArrayList();
    }
    this.configMaps.set(index, item);
    return (A) this;
  }
  
  public A setToContainers(int index,Container item) {
    if (this.containers == null) {
      this.containers = new ArrayList();
    }
    ContainerBuilder builder = new ContainerBuilder(item);
    if (index < 0 || index >= containers.size()) {
        _visitables.get("containers").add(builder);
        containers.add(builder);
    } else {
        _visitables.get("containers").add(builder);
        containers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEnableFeatures(int index,String item) {
    if (this.enableFeatures == null) {
      this.enableFeatures = new ArrayList();
    }
    this.enableFeatures.set(index, item);
    return (A) this;
  }
  
  public A setToExcludedFromEnforcement(int index,ObjectReference item) {
    if (this.excludedFromEnforcement == null) {
      this.excludedFromEnforcement = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= excludedFromEnforcement.size()) {
        _visitables.get("excludedFromEnforcement").add(builder);
        excludedFromEnforcement.add(builder);
    } else {
        _visitables.get("excludedFromEnforcement").add(builder);
        excludedFromEnforcement.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHostAliases(int index,HostAlias item) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    HostAliasBuilder builder = new HostAliasBuilder(item);
    if (index < 0 || index >= hostAliases.size()) {
        _visitables.get("hostAliases").add(builder);
        hostAliases.add(builder);
    } else {
        _visitables.get("hostAliases").add(builder);
        hostAliases.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToImagePullSecrets(int index,LocalObjectReference item) {
    if (this.imagePullSecrets == null) {
      this.imagePullSecrets = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= imagePullSecrets.size()) {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.add(builder);
    } else {
        _visitables.get("imagePullSecrets").add(builder);
        imagePullSecrets.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToInitContainers(int index,Container item) {
    if (this.initContainers == null) {
      this.initContainers = new ArrayList();
    }
    ContainerBuilder builder = new ContainerBuilder(item);
    if (index < 0 || index >= initContainers.size()) {
        _visitables.get("initContainers").add(builder);
        initContainers.add(builder);
    } else {
        _visitables.get("initContainers").add(builder);
        initContainers.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPodTargetLabels(int index,String item) {
    if (this.podTargetLabels == null) {
      this.podTargetLabels = new ArrayList();
    }
    this.podTargetLabels.set(index, item);
    return (A) this;
  }
  
  public A setToPrometheusRulesExcludedFromEnforce(int index,PrometheusRuleExcludeConfig item) {
    if (this.prometheusRulesExcludedFromEnforce == null) {
      this.prometheusRulesExcludedFromEnforce = new ArrayList();
    }
    PrometheusRuleExcludeConfigBuilder builder = new PrometheusRuleExcludeConfigBuilder(item);
    if (index < 0 || index >= prometheusRulesExcludedFromEnforce.size()) {
        _visitables.get("prometheusRulesExcludedFromEnforce").add(builder);
        prometheusRulesExcludedFromEnforce.add(builder);
    } else {
        _visitables.get("prometheusRulesExcludedFromEnforce").add(builder);
        prometheusRulesExcludedFromEnforce.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRemoteRead(int index,RemoteReadSpec item) {
    if (this.remoteRead == null) {
      this.remoteRead = new ArrayList();
    }
    RemoteReadSpecBuilder builder = new RemoteReadSpecBuilder(item);
    if (index < 0 || index >= remoteRead.size()) {
        _visitables.get("remoteRead").add(builder);
        remoteRead.add(builder);
    } else {
        _visitables.get("remoteRead").add(builder);
        remoteRead.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRemoteWrite(int index,RemoteWriteSpec item) {
    if (this.remoteWrite == null) {
      this.remoteWrite = new ArrayList();
    }
    RemoteWriteSpecBuilder builder = new RemoteWriteSpecBuilder(item);
    if (index < 0 || index >= remoteWrite.size()) {
        _visitables.get("remoteWrite").add(builder);
        remoteWrite.add(builder);
    } else {
        _visitables.get("remoteWrite").add(builder);
        remoteWrite.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRemoteWriteReceiverMessageVersions(int index,String item) {
    if (this.remoteWriteReceiverMessageVersions == null) {
      this.remoteWriteReceiverMessageVersions = new ArrayList();
    }
    this.remoteWriteReceiverMessageVersions.set(index, item);
    return (A) this;
  }
  
  public A setToScrapeClasses(int index,ScrapeClass item) {
    if (this.scrapeClasses == null) {
      this.scrapeClasses = new ArrayList();
    }
    ScrapeClassBuilder builder = new ScrapeClassBuilder(item);
    if (index < 0 || index >= scrapeClasses.size()) {
        _visitables.get("scrapeClasses").add(builder);
        scrapeClasses.add(builder);
    } else {
        _visitables.get("scrapeClasses").add(builder);
        scrapeClasses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToScrapeProtocols(int index,String item) {
    if (this.scrapeProtocols == null) {
      this.scrapeProtocols = new ArrayList();
    }
    this.scrapeProtocols.set(index, item);
    return (A) this;
  }
  
  public A setToSecrets(int index,String item) {
    if (this.secrets == null) {
      this.secrets = new ArrayList();
    }
    this.secrets.set(index, item);
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    this.tolerations.set(index, item);
    return (A) this;
  }
  
  public A setToTopologySpreadConstraints(int index,TopologySpreadConstraint item) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    TopologySpreadConstraintBuilder builder = new TopologySpreadConstraintBuilder(item);
    if (index < 0 || index >= topologySpreadConstraints.size()) {
        _visitables.get("topologySpreadConstraints").add(builder);
        topologySpreadConstraints.add(builder);
    } else {
        _visitables.get("topologySpreadConstraints").add(builder);
        topologySpreadConstraints.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumeMounts(int index,VolumeMount item) {
    if (this.volumeMounts == null) {
      this.volumeMounts = new ArrayList();
    }
    VolumeMountBuilder builder = new VolumeMountBuilder(item);
    if (index < 0 || index >= volumeMounts.size()) {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.add(builder);
    } else {
        _visitables.get("volumeMounts").add(builder);
        volumeMounts.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVolumes(int index,Volume item) {
    if (this.volumes == null) {
      this.volumes = new ArrayList();
    }
    VolumeBuilder builder = new VolumeBuilder(item);
    if (index < 0 || index >= volumes.size()) {
        _visitables.get("volumes").add(builder);
        volumes.add(builder);
    } else {
        _visitables.get("volumes").add(builder);
        volumes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalAlertManagerConfigs == null)) {
        sb.append("additionalAlertManagerConfigs:");
        sb.append(additionalAlertManagerConfigs);
        sb.append(",");
    }
    if (!(additionalAlertRelabelConfigs == null)) {
        sb.append("additionalAlertRelabelConfigs:");
        sb.append(additionalAlertRelabelConfigs);
        sb.append(",");
    }
    if (!(additionalArgs == null) && !(additionalArgs.isEmpty())) {
        sb.append("additionalArgs:");
        sb.append(additionalArgs);
        sb.append(",");
    }
    if (!(additionalScrapeConfigs == null)) {
        sb.append("additionalScrapeConfigs:");
        sb.append(additionalScrapeConfigs);
        sb.append(",");
    }
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(alerting == null)) {
        sb.append("alerting:");
        sb.append(alerting);
        sb.append(",");
    }
    if (!(allowOverlappingBlocks == null)) {
        sb.append("allowOverlappingBlocks:");
        sb.append(allowOverlappingBlocks);
        sb.append(",");
    }
    if (!(apiserverConfig == null)) {
        sb.append("apiserverConfig:");
        sb.append(apiserverConfig);
        sb.append(",");
    }
    if (!(arbitraryFSAccessThroughSMs == null)) {
        sb.append("arbitraryFSAccessThroughSMs:");
        sb.append(arbitraryFSAccessThroughSMs);
        sb.append(",");
    }
    if (!(automountServiceAccountToken == null)) {
        sb.append("automountServiceAccountToken:");
        sb.append(automountServiceAccountToken);
        sb.append(",");
    }
    if (!(baseImage == null)) {
        sb.append("baseImage:");
        sb.append(baseImage);
        sb.append(",");
    }
    if (!(bodySizeLimit == null)) {
        sb.append("bodySizeLimit:");
        sb.append(bodySizeLimit);
        sb.append(",");
    }
    if (!(configMaps == null) && !(configMaps.isEmpty())) {
        sb.append("configMaps:");
        sb.append(configMaps);
        sb.append(",");
    }
    if (!(containers == null) && !(containers.isEmpty())) {
        sb.append("containers:");
        sb.append(containers);
        sb.append(",");
    }
    if (!(convertClassicHistogramsToNHCB == null)) {
        sb.append("convertClassicHistogramsToNHCB:");
        sb.append(convertClassicHistogramsToNHCB);
        sb.append(",");
    }
    if (!(disableCompaction == null)) {
        sb.append("disableCompaction:");
        sb.append(disableCompaction);
        sb.append(",");
    }
    if (!(dnsConfig == null)) {
        sb.append("dnsConfig:");
        sb.append(dnsConfig);
        sb.append(",");
    }
    if (!(dnsPolicy == null)) {
        sb.append("dnsPolicy:");
        sb.append(dnsPolicy);
        sb.append(",");
    }
    if (!(enableAdminAPI == null)) {
        sb.append("enableAdminAPI:");
        sb.append(enableAdminAPI);
        sb.append(",");
    }
    if (!(enableFeatures == null) && !(enableFeatures.isEmpty())) {
        sb.append("enableFeatures:");
        sb.append(enableFeatures);
        sb.append(",");
    }
    if (!(enableOTLPReceiver == null)) {
        sb.append("enableOTLPReceiver:");
        sb.append(enableOTLPReceiver);
        sb.append(",");
    }
    if (!(enableRemoteWriteReceiver == null)) {
        sb.append("enableRemoteWriteReceiver:");
        sb.append(enableRemoteWriteReceiver);
        sb.append(",");
    }
    if (!(enableServiceLinks == null)) {
        sb.append("enableServiceLinks:");
        sb.append(enableServiceLinks);
        sb.append(",");
    }
    if (!(enforcedBodySizeLimit == null)) {
        sb.append("enforcedBodySizeLimit:");
        sb.append(enforcedBodySizeLimit);
        sb.append(",");
    }
    if (!(enforcedKeepDroppedTargets == null)) {
        sb.append("enforcedKeepDroppedTargets:");
        sb.append(enforcedKeepDroppedTargets);
        sb.append(",");
    }
    if (!(enforcedLabelLimit == null)) {
        sb.append("enforcedLabelLimit:");
        sb.append(enforcedLabelLimit);
        sb.append(",");
    }
    if (!(enforcedLabelNameLengthLimit == null)) {
        sb.append("enforcedLabelNameLengthLimit:");
        sb.append(enforcedLabelNameLengthLimit);
        sb.append(",");
    }
    if (!(enforcedLabelValueLengthLimit == null)) {
        sb.append("enforcedLabelValueLengthLimit:");
        sb.append(enforcedLabelValueLengthLimit);
        sb.append(",");
    }
    if (!(enforcedNamespaceLabel == null)) {
        sb.append("enforcedNamespaceLabel:");
        sb.append(enforcedNamespaceLabel);
        sb.append(",");
    }
    if (!(enforcedSampleLimit == null)) {
        sb.append("enforcedSampleLimit:");
        sb.append(enforcedSampleLimit);
        sb.append(",");
    }
    if (!(enforcedTargetLimit == null)) {
        sb.append("enforcedTargetLimit:");
        sb.append(enforcedTargetLimit);
        sb.append(",");
    }
    if (!(evaluationInterval == null)) {
        sb.append("evaluationInterval:");
        sb.append(evaluationInterval);
        sb.append(",");
    }
    if (!(excludedFromEnforcement == null) && !(excludedFromEnforcement.isEmpty())) {
        sb.append("excludedFromEnforcement:");
        sb.append(excludedFromEnforcement);
        sb.append(",");
    }
    if (!(exemplars == null)) {
        sb.append("exemplars:");
        sb.append(exemplars);
        sb.append(",");
    }
    if (!(externalLabels == null) && !(externalLabels.isEmpty())) {
        sb.append("externalLabels:");
        sb.append(externalLabels);
        sb.append(",");
    }
    if (!(externalUrl == null)) {
        sb.append("externalUrl:");
        sb.append(externalUrl);
        sb.append(",");
    }
    if (!(hostAliases == null) && !(hostAliases.isEmpty())) {
        sb.append("hostAliases:");
        sb.append(hostAliases);
        sb.append(",");
    }
    if (!(hostNetwork == null)) {
        sb.append("hostNetwork:");
        sb.append(hostNetwork);
        sb.append(",");
    }
    if (!(hostUsers == null)) {
        sb.append("hostUsers:");
        sb.append(hostUsers);
        sb.append(",");
    }
    if (!(ignoreNamespaceSelectors == null)) {
        sb.append("ignoreNamespaceSelectors:");
        sb.append(ignoreNamespaceSelectors);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(imagePullPolicy == null)) {
        sb.append("imagePullPolicy:");
        sb.append(imagePullPolicy);
        sb.append(",");
    }
    if (!(imagePullSecrets == null) && !(imagePullSecrets.isEmpty())) {
        sb.append("imagePullSecrets:");
        sb.append(imagePullSecrets);
        sb.append(",");
    }
    if (!(initContainers == null) && !(initContainers.isEmpty())) {
        sb.append("initContainers:");
        sb.append(initContainers);
        sb.append(",");
    }
    if (!(keepDroppedTargets == null)) {
        sb.append("keepDroppedTargets:");
        sb.append(keepDroppedTargets);
        sb.append(",");
    }
    if (!(labelLimit == null)) {
        sb.append("labelLimit:");
        sb.append(labelLimit);
        sb.append(",");
    }
    if (!(labelNameLengthLimit == null)) {
        sb.append("labelNameLengthLimit:");
        sb.append(labelNameLengthLimit);
        sb.append(",");
    }
    if (!(labelValueLengthLimit == null)) {
        sb.append("labelValueLengthLimit:");
        sb.append(labelValueLengthLimit);
        sb.append(",");
    }
    if (!(listenLocal == null)) {
        sb.append("listenLocal:");
        sb.append(listenLocal);
        sb.append(",");
    }
    if (!(logFormat == null)) {
        sb.append("logFormat:");
        sb.append(logFormat);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(maximumStartupDurationSeconds == null)) {
        sb.append("maximumStartupDurationSeconds:");
        sb.append(maximumStartupDurationSeconds);
        sb.append(",");
    }
    if (!(minReadySeconds == null)) {
        sb.append("minReadySeconds:");
        sb.append(minReadySeconds);
        sb.append(",");
    }
    if (!(nameEscapingScheme == null)) {
        sb.append("nameEscapingScheme:");
        sb.append(nameEscapingScheme);
        sb.append(",");
    }
    if (!(nameValidationScheme == null)) {
        sb.append("nameValidationScheme:");
        sb.append(nameValidationScheme);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(otlp == null)) {
        sb.append("otlp:");
        sb.append(otlp);
        sb.append(",");
    }
    if (!(overrideHonorLabels == null)) {
        sb.append("overrideHonorLabels:");
        sb.append(overrideHonorLabels);
        sb.append(",");
    }
    if (!(overrideHonorTimestamps == null)) {
        sb.append("overrideHonorTimestamps:");
        sb.append(overrideHonorTimestamps);
        sb.append(",");
    }
    if (!(paused == null)) {
        sb.append("paused:");
        sb.append(paused);
        sb.append(",");
    }
    if (!(persistentVolumeClaimRetentionPolicy == null)) {
        sb.append("persistentVolumeClaimRetentionPolicy:");
        sb.append(persistentVolumeClaimRetentionPolicy);
        sb.append(",");
    }
    if (!(podManagementPolicy == null)) {
        sb.append("podManagementPolicy:");
        sb.append(podManagementPolicy);
        sb.append(",");
    }
    if (!(podMetadata == null)) {
        sb.append("podMetadata:");
        sb.append(podMetadata);
        sb.append(",");
    }
    if (!(podMonitorNamespaceSelector == null)) {
        sb.append("podMonitorNamespaceSelector:");
        sb.append(podMonitorNamespaceSelector);
        sb.append(",");
    }
    if (!(podMonitorSelector == null)) {
        sb.append("podMonitorSelector:");
        sb.append(podMonitorSelector);
        sb.append(",");
    }
    if (!(podTargetLabels == null) && !(podTargetLabels.isEmpty())) {
        sb.append("podTargetLabels:");
        sb.append(podTargetLabels);
        sb.append(",");
    }
    if (!(portName == null)) {
        sb.append("portName:");
        sb.append(portName);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(probeNamespaceSelector == null)) {
        sb.append("probeNamespaceSelector:");
        sb.append(probeNamespaceSelector);
        sb.append(",");
    }
    if (!(probeSelector == null)) {
        sb.append("probeSelector:");
        sb.append(probeSelector);
        sb.append(",");
    }
    if (!(prometheusExternalLabelName == null)) {
        sb.append("prometheusExternalLabelName:");
        sb.append(prometheusExternalLabelName);
        sb.append(",");
    }
    if (!(prometheusRulesExcludedFromEnforce == null) && !(prometheusRulesExcludedFromEnforce.isEmpty())) {
        sb.append("prometheusRulesExcludedFromEnforce:");
        sb.append(prometheusRulesExcludedFromEnforce);
        sb.append(",");
    }
    if (!(query == null)) {
        sb.append("query:");
        sb.append(query);
        sb.append(",");
    }
    if (!(queryLogFile == null)) {
        sb.append("queryLogFile:");
        sb.append(queryLogFile);
        sb.append(",");
    }
    if (!(reloadStrategy == null)) {
        sb.append("reloadStrategy:");
        sb.append(reloadStrategy);
        sb.append(",");
    }
    if (!(remoteRead == null) && !(remoteRead.isEmpty())) {
        sb.append("remoteRead:");
        sb.append(remoteRead);
        sb.append(",");
    }
    if (!(remoteWrite == null) && !(remoteWrite.isEmpty())) {
        sb.append("remoteWrite:");
        sb.append(remoteWrite);
        sb.append(",");
    }
    if (!(remoteWriteReceiverMessageVersions == null) && !(remoteWriteReceiverMessageVersions.isEmpty())) {
        sb.append("remoteWriteReceiverMessageVersions:");
        sb.append(remoteWriteReceiverMessageVersions);
        sb.append(",");
    }
    if (!(replicaExternalLabelName == null)) {
        sb.append("replicaExternalLabelName:");
        sb.append(replicaExternalLabelName);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(retention == null)) {
        sb.append("retention:");
        sb.append(retention);
        sb.append(",");
    }
    if (!(retentionSize == null)) {
        sb.append("retentionSize:");
        sb.append(retentionSize);
        sb.append(",");
    }
    if (!(routePrefix == null)) {
        sb.append("routePrefix:");
        sb.append(routePrefix);
        sb.append(",");
    }
    if (!(ruleNamespaceSelector == null)) {
        sb.append("ruleNamespaceSelector:");
        sb.append(ruleNamespaceSelector);
        sb.append(",");
    }
    if (!(ruleQueryOffset == null)) {
        sb.append("ruleQueryOffset:");
        sb.append(ruleQueryOffset);
        sb.append(",");
    }
    if (!(ruleSelector == null)) {
        sb.append("ruleSelector:");
        sb.append(ruleSelector);
        sb.append(",");
    }
    if (!(rules == null)) {
        sb.append("rules:");
        sb.append(rules);
        sb.append(",");
    }
    if (!(runtime == null)) {
        sb.append("runtime:");
        sb.append(runtime);
        sb.append(",");
    }
    if (!(sampleLimit == null)) {
        sb.append("sampleLimit:");
        sb.append(sampleLimit);
        sb.append(",");
    }
    if (!(schedulerName == null)) {
        sb.append("schedulerName:");
        sb.append(schedulerName);
        sb.append(",");
    }
    if (!(scrapeClasses == null) && !(scrapeClasses.isEmpty())) {
        sb.append("scrapeClasses:");
        sb.append(scrapeClasses);
        sb.append(",");
    }
    if (!(scrapeClassicHistograms == null)) {
        sb.append("scrapeClassicHistograms:");
        sb.append(scrapeClassicHistograms);
        sb.append(",");
    }
    if (!(scrapeConfigNamespaceSelector == null)) {
        sb.append("scrapeConfigNamespaceSelector:");
        sb.append(scrapeConfigNamespaceSelector);
        sb.append(",");
    }
    if (!(scrapeConfigSelector == null)) {
        sb.append("scrapeConfigSelector:");
        sb.append(scrapeConfigSelector);
        sb.append(",");
    }
    if (!(scrapeFailureLogFile == null)) {
        sb.append("scrapeFailureLogFile:");
        sb.append(scrapeFailureLogFile);
        sb.append(",");
    }
    if (!(scrapeInterval == null)) {
        sb.append("scrapeInterval:");
        sb.append(scrapeInterval);
        sb.append(",");
    }
    if (!(scrapeNativeHistograms == null)) {
        sb.append("scrapeNativeHistograms:");
        sb.append(scrapeNativeHistograms);
        sb.append(",");
    }
    if (!(scrapeProtocols == null) && !(scrapeProtocols.isEmpty())) {
        sb.append("scrapeProtocols:");
        sb.append(scrapeProtocols);
        sb.append(",");
    }
    if (!(scrapeTimeout == null)) {
        sb.append("scrapeTimeout:");
        sb.append(scrapeTimeout);
        sb.append(",");
    }
    if (!(secrets == null) && !(secrets.isEmpty())) {
        sb.append("secrets:");
        sb.append(secrets);
        sb.append(",");
    }
    if (!(securityContext == null)) {
        sb.append("securityContext:");
        sb.append(securityContext);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(serviceDiscoveryRole == null)) {
        sb.append("serviceDiscoveryRole:");
        sb.append(serviceDiscoveryRole);
        sb.append(",");
    }
    if (!(serviceMonitorNamespaceSelector == null)) {
        sb.append("serviceMonitorNamespaceSelector:");
        sb.append(serviceMonitorNamespaceSelector);
        sb.append(",");
    }
    if (!(serviceMonitorSelector == null)) {
        sb.append("serviceMonitorSelector:");
        sb.append(serviceMonitorSelector);
        sb.append(",");
    }
    if (!(serviceName == null)) {
        sb.append("serviceName:");
        sb.append(serviceName);
        sb.append(",");
    }
    if (!(sha == null)) {
        sb.append("sha:");
        sb.append(sha);
        sb.append(",");
    }
    if (!(shardRetentionPolicy == null)) {
        sb.append("shardRetentionPolicy:");
        sb.append(shardRetentionPolicy);
        sb.append(",");
    }
    if (!(shardingStrategy == null)) {
        sb.append("shardingStrategy:");
        sb.append(shardingStrategy);
        sb.append(",");
    }
    if (!(shards == null)) {
        sb.append("shards:");
        sb.append(shards);
        sb.append(",");
    }
    if (!(storage == null)) {
        sb.append("storage:");
        sb.append(storage);
        sb.append(",");
    }
    if (!(tag == null)) {
        sb.append("tag:");
        sb.append(tag);
        sb.append(",");
    }
    if (!(targetLimit == null)) {
        sb.append("targetLimit:");
        sb.append(targetLimit);
        sb.append(",");
    }
    if (!(terminationGracePeriodSeconds == null)) {
        sb.append("terminationGracePeriodSeconds:");
        sb.append(terminationGracePeriodSeconds);
        sb.append(",");
    }
    if (!(thanos == null)) {
        sb.append("thanos:");
        sb.append(thanos);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
        sb.append(",");
    }
    if (!(topologySpreadConstraints == null) && !(topologySpreadConstraints.isEmpty())) {
        sb.append("topologySpreadConstraints:");
        sb.append(topologySpreadConstraints);
        sb.append(",");
    }
    if (!(tracingConfig == null)) {
        sb.append("tracingConfig:");
        sb.append(tracingConfig);
        sb.append(",");
    }
    if (!(tsdb == null)) {
        sb.append("tsdb:");
        sb.append(tsdb);
        sb.append(",");
    }
    if (!(updateStrategy == null)) {
        sb.append("updateStrategy:");
        sb.append(updateStrategy);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(volumeMounts == null) && !(volumeMounts.isEmpty())) {
        sb.append("volumeMounts:");
        sb.append(volumeMounts);
        sb.append(",");
    }
    if (!(volumes == null) && !(volumes.isEmpty())) {
        sb.append("volumes:");
        sb.append(volumes);
        sb.append(",");
    }
    if (!(walCompression == null)) {
        sb.append("walCompression:");
        sb.append(walCompression);
        sb.append(",");
    }
    if (!(web == null)) {
        sb.append("web:");
        sb.append(web);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalAlertManagerConfigs(SecretKeySelector additionalAlertManagerConfigs) {
    this.additionalAlertManagerConfigs = additionalAlertManagerConfigs;
    return (A) this;
  }
  
  public A withAdditionalAlertRelabelConfigs(SecretKeySelector additionalAlertRelabelConfigs) {
    this.additionalAlertRelabelConfigs = additionalAlertRelabelConfigs;
    return (A) this;
  }
  
  public A withAdditionalArgs(List<Argument> additionalArgs) {
    if (this.additionalArgs != null) {
      this._visitables.get("additionalArgs").clear();
    }
    if (additionalArgs != null) {
        this.additionalArgs = new ArrayList();
        for (Argument item : additionalArgs) {
          this.addToAdditionalArgs(item);
        }
    } else {
      this.additionalArgs = null;
    }
    return (A) this;
  }
  
  public A withAdditionalArgs(Argument... additionalArgs) {
    if (this.additionalArgs != null) {
        this.additionalArgs.clear();
        _visitables.remove("additionalArgs");
    }
    if (additionalArgs != null) {
      for (Argument item : additionalArgs) {
        this.addToAdditionalArgs(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAdditionalScrapeConfigs(SecretKeySelector additionalScrapeConfigs) {
    this.additionalScrapeConfigs = additionalScrapeConfigs;
    return (A) this;
  }
  
  public A withAffinity(Affinity affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withAlerting(AlertingSpec alerting) {
    this._visitables.remove("alerting");
    if (alerting != null) {
        this.alerting = new AlertingSpecBuilder(alerting);
        this._visitables.get("alerting").add(this.alerting);
    } else {
        this.alerting = null;
        this._visitables.get("alerting").remove(this.alerting);
    }
    return (A) this;
  }
  
  public A withAllowOverlappingBlocks() {
    return withAllowOverlappingBlocks(true);
  }
  
  public A withAllowOverlappingBlocks(Boolean allowOverlappingBlocks) {
    this.allowOverlappingBlocks = allowOverlappingBlocks;
    return (A) this;
  }
  
  public A withApiserverConfig(APIServerConfig apiserverConfig) {
    this._visitables.remove("apiserverConfig");
    if (apiserverConfig != null) {
        this.apiserverConfig = new APIServerConfigBuilder(apiserverConfig);
        this._visitables.get("apiserverConfig").add(this.apiserverConfig);
    } else {
        this.apiserverConfig = null;
        this._visitables.get("apiserverConfig").remove(this.apiserverConfig);
    }
    return (A) this;
  }
  
  public A withArbitraryFSAccessThroughSMs(ArbitraryFSAccessThroughSMsConfig arbitraryFSAccessThroughSMs) {
    this._visitables.remove("arbitraryFSAccessThroughSMs");
    if (arbitraryFSAccessThroughSMs != null) {
        this.arbitraryFSAccessThroughSMs = new ArbitraryFSAccessThroughSMsConfigBuilder(arbitraryFSAccessThroughSMs);
        this._visitables.get("arbitraryFSAccessThroughSMs").add(this.arbitraryFSAccessThroughSMs);
    } else {
        this.arbitraryFSAccessThroughSMs = null;
        this._visitables.get("arbitraryFSAccessThroughSMs").remove(this.arbitraryFSAccessThroughSMs);
    }
    return (A) this;
  }
  
  public A withAutomountServiceAccountToken() {
    return withAutomountServiceAccountToken(true);
  }
  
  public A withAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
    this.automountServiceAccountToken = automountServiceAccountToken;
    return (A) this;
  }
  
  public A withBaseImage(String baseImage) {
    this.baseImage = baseImage;
    return (A) this;
  }
  
  public A withBodySizeLimit(String bodySizeLimit) {
    this.bodySizeLimit = bodySizeLimit;
    return (A) this;
  }
  
  public A withConfigMaps(List<String> configMaps) {
    if (configMaps != null) {
        this.configMaps = new ArrayList();
        for (String item : configMaps) {
          this.addToConfigMaps(item);
        }
    } else {
      this.configMaps = null;
    }
    return (A) this;
  }
  
  public A withConfigMaps(String... configMaps) {
    if (this.configMaps != null) {
        this.configMaps.clear();
        _visitables.remove("configMaps");
    }
    if (configMaps != null) {
      for (String item : configMaps) {
        this.addToConfigMaps(item);
      }
    }
    return (A) this;
  }
  
  public A withContainers(List<Container> containers) {
    if (this.containers != null) {
      this._visitables.get("containers").clear();
    }
    if (containers != null) {
        this.containers = new ArrayList();
        for (Container item : containers) {
          this.addToContainers(item);
        }
    } else {
      this.containers = null;
    }
    return (A) this;
  }
  
  public A withContainers(Container... containers) {
    if (this.containers != null) {
        this.containers.clear();
        _visitables.remove("containers");
    }
    if (containers != null) {
      for (Container item : containers) {
        this.addToContainers(item);
      }
    }
    return (A) this;
  }
  
  public A withConvertClassicHistogramsToNHCB() {
    return withConvertClassicHistogramsToNHCB(true);
  }
  
  public A withConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
    this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    return (A) this;
  }
  
  public A withDisableCompaction() {
    return withDisableCompaction(true);
  }
  
  public A withDisableCompaction(Boolean disableCompaction) {
    this.disableCompaction = disableCompaction;
    return (A) this;
  }
  
  public A withDnsConfig(PodDNSConfig dnsConfig) {
    this._visitables.remove("dnsConfig");
    if (dnsConfig != null) {
        this.dnsConfig = new PodDNSConfigBuilder(dnsConfig);
        this._visitables.get("dnsConfig").add(this.dnsConfig);
    } else {
        this.dnsConfig = null;
        this._visitables.get("dnsConfig").remove(this.dnsConfig);
    }
    return (A) this;
  }
  
  public A withDnsPolicy(String dnsPolicy) {
    this.dnsPolicy = dnsPolicy;
    return (A) this;
  }
  
  public A withEnableAdminAPI() {
    return withEnableAdminAPI(true);
  }
  
  public A withEnableAdminAPI(Boolean enableAdminAPI) {
    this.enableAdminAPI = enableAdminAPI;
    return (A) this;
  }
  
  public A withEnableFeatures(List<String> enableFeatures) {
    if (enableFeatures != null) {
        this.enableFeatures = new ArrayList();
        for (String item : enableFeatures) {
          this.addToEnableFeatures(item);
        }
    } else {
      this.enableFeatures = null;
    }
    return (A) this;
  }
  
  public A withEnableFeatures(String... enableFeatures) {
    if (this.enableFeatures != null) {
        this.enableFeatures.clear();
        _visitables.remove("enableFeatures");
    }
    if (enableFeatures != null) {
      for (String item : enableFeatures) {
        this.addToEnableFeatures(item);
      }
    }
    return (A) this;
  }
  
  public A withEnableOTLPReceiver() {
    return withEnableOTLPReceiver(true);
  }
  
  public A withEnableOTLPReceiver(Boolean enableOTLPReceiver) {
    this.enableOTLPReceiver = enableOTLPReceiver;
    return (A) this;
  }
  
  public A withEnableRemoteWriteReceiver() {
    return withEnableRemoteWriteReceiver(true);
  }
  
  public A withEnableRemoteWriteReceiver(Boolean enableRemoteWriteReceiver) {
    this.enableRemoteWriteReceiver = enableRemoteWriteReceiver;
    return (A) this;
  }
  
  public A withEnableServiceLinks() {
    return withEnableServiceLinks(true);
  }
  
  public A withEnableServiceLinks(Boolean enableServiceLinks) {
    this.enableServiceLinks = enableServiceLinks;
    return (A) this;
  }
  
  public A withEnforcedBodySizeLimit(String enforcedBodySizeLimit) {
    this.enforcedBodySizeLimit = enforcedBodySizeLimit;
    return (A) this;
  }
  
  public A withEnforcedKeepDroppedTargets(Long enforcedKeepDroppedTargets) {
    this.enforcedKeepDroppedTargets = enforcedKeepDroppedTargets;
    return (A) this;
  }
  
  public A withEnforcedLabelLimit(Long enforcedLabelLimit) {
    this.enforcedLabelLimit = enforcedLabelLimit;
    return (A) this;
  }
  
  public A withEnforcedLabelNameLengthLimit(Long enforcedLabelNameLengthLimit) {
    this.enforcedLabelNameLengthLimit = enforcedLabelNameLengthLimit;
    return (A) this;
  }
  
  public A withEnforcedLabelValueLengthLimit(Long enforcedLabelValueLengthLimit) {
    this.enforcedLabelValueLengthLimit = enforcedLabelValueLengthLimit;
    return (A) this;
  }
  
  public A withEnforcedNamespaceLabel(String enforcedNamespaceLabel) {
    this.enforcedNamespaceLabel = enforcedNamespaceLabel;
    return (A) this;
  }
  
  public A withEnforcedSampleLimit(Long enforcedSampleLimit) {
    this.enforcedSampleLimit = enforcedSampleLimit;
    return (A) this;
  }
  
  public A withEnforcedTargetLimit(Long enforcedTargetLimit) {
    this.enforcedTargetLimit = enforcedTargetLimit;
    return (A) this;
  }
  
  public A withEvaluationInterval(String evaluationInterval) {
    this.evaluationInterval = evaluationInterval;
    return (A) this;
  }
  
  public A withExcludedFromEnforcement(List<ObjectReference> excludedFromEnforcement) {
    if (this.excludedFromEnforcement != null) {
      this._visitables.get("excludedFromEnforcement").clear();
    }
    if (excludedFromEnforcement != null) {
        this.excludedFromEnforcement = new ArrayList();
        for (ObjectReference item : excludedFromEnforcement) {
          this.addToExcludedFromEnforcement(item);
        }
    } else {
      this.excludedFromEnforcement = null;
    }
    return (A) this;
  }
  
  public A withExcludedFromEnforcement(ObjectReference... excludedFromEnforcement) {
    if (this.excludedFromEnforcement != null) {
        this.excludedFromEnforcement.clear();
        _visitables.remove("excludedFromEnforcement");
    }
    if (excludedFromEnforcement != null) {
      for (ObjectReference item : excludedFromEnforcement) {
        this.addToExcludedFromEnforcement(item);
      }
    }
    return (A) this;
  }
  
  public A withExemplars(Exemplars exemplars) {
    this._visitables.remove("exemplars");
    if (exemplars != null) {
        this.exemplars = new ExemplarsBuilder(exemplars);
        this._visitables.get("exemplars").add(this.exemplars);
    } else {
        this.exemplars = null;
        this._visitables.get("exemplars").remove(this.exemplars);
    }
    return (A) this;
  }
  
  public <K,V>A withExternalLabels(Map<String,String> externalLabels) {
    if (externalLabels == null) {
      this.externalLabels = null;
    } else {
      this.externalLabels = new LinkedHashMap(externalLabels);
    }
    return (A) this;
  }
  
  public A withExternalUrl(String externalUrl) {
    this.externalUrl = externalUrl;
    return (A) this;
  }
  
  public A withHostAliases(List<HostAlias> hostAliases) {
    if (this.hostAliases != null) {
      this._visitables.get("hostAliases").clear();
    }
    if (hostAliases != null) {
        this.hostAliases = new ArrayList();
        for (HostAlias item : hostAliases) {
          this.addToHostAliases(item);
        }
    } else {
      this.hostAliases = null;
    }
    return (A) this;
  }
  
  public A withHostAliases(HostAlias... hostAliases) {
    if (this.hostAliases != null) {
        this.hostAliases.clear();
        _visitables.remove("hostAliases");
    }
    if (hostAliases != null) {
      for (HostAlias item : hostAliases) {
        this.addToHostAliases(item);
      }
    }
    return (A) this;
  }
  
  public A withHostNetwork() {
    return withHostNetwork(true);
  }
  
  public A withHostNetwork(Boolean hostNetwork) {
    this.hostNetwork = hostNetwork;
    return (A) this;
  }
  
  public A withHostUsers() {
    return withHostUsers(true);
  }
  
  public A withHostUsers(Boolean hostUsers) {
    this.hostUsers = hostUsers;
    return (A) this;
  }
  
  public A withIgnoreNamespaceSelectors() {
    return withIgnoreNamespaceSelectors(true);
  }
  
  public A withIgnoreNamespaceSelectors(Boolean ignoreNamespaceSelectors) {
    this.ignoreNamespaceSelectors = ignoreNamespaceSelectors;
    return (A) this;
  }
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public A withImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return (A) this;
  }
  
  public A withImagePullSecrets(List<LocalObjectReference> imagePullSecrets) {
    if (this.imagePullSecrets != null) {
      this._visitables.get("imagePullSecrets").clear();
    }
    if (imagePullSecrets != null) {
        this.imagePullSecrets = new ArrayList();
        for (LocalObjectReference item : imagePullSecrets) {
          this.addToImagePullSecrets(item);
        }
    } else {
      this.imagePullSecrets = null;
    }
    return (A) this;
  }
  
  public A withImagePullSecrets(LocalObjectReference... imagePullSecrets) {
    if (this.imagePullSecrets != null) {
        this.imagePullSecrets.clear();
        _visitables.remove("imagePullSecrets");
    }
    if (imagePullSecrets != null) {
      for (LocalObjectReference item : imagePullSecrets) {
        this.addToImagePullSecrets(item);
      }
    }
    return (A) this;
  }
  
  public A withInitContainers(List<Container> initContainers) {
    if (this.initContainers != null) {
      this._visitables.get("initContainers").clear();
    }
    if (initContainers != null) {
        this.initContainers = new ArrayList();
        for (Container item : initContainers) {
          this.addToInitContainers(item);
        }
    } else {
      this.initContainers = null;
    }
    return (A) this;
  }
  
  public A withInitContainers(Container... initContainers) {
    if (this.initContainers != null) {
        this.initContainers.clear();
        _visitables.remove("initContainers");
    }
    if (initContainers != null) {
      for (Container item : initContainers) {
        this.addToInitContainers(item);
      }
    }
    return (A) this;
  }
  
  public A withKeepDroppedTargets(Long keepDroppedTargets) {
    this.keepDroppedTargets = keepDroppedTargets;
    return (A) this;
  }
  
  public A withLabelLimit(Long labelLimit) {
    this.labelLimit = labelLimit;
    return (A) this;
  }
  
  public A withLabelNameLengthLimit(Long labelNameLengthLimit) {
    this.labelNameLengthLimit = labelNameLengthLimit;
    return (A) this;
  }
  
  public A withLabelValueLengthLimit(Long labelValueLengthLimit) {
    this.labelValueLengthLimit = labelValueLengthLimit;
    return (A) this;
  }
  
  public A withListenLocal() {
    return withListenLocal(true);
  }
  
  public A withListenLocal(Boolean listenLocal) {
    this.listenLocal = listenLocal;
    return (A) this;
  }
  
  public A withLogFormat(String logFormat) {
    this.logFormat = logFormat;
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withMaximumStartupDurationSeconds(Integer maximumStartupDurationSeconds) {
    this.maximumStartupDurationSeconds = maximumStartupDurationSeconds;
    return (A) this;
  }
  
  public A withMinReadySeconds(Integer minReadySeconds) {
    this.minReadySeconds = minReadySeconds;
    return (A) this;
  }
  
  public A withNameEscapingScheme(String nameEscapingScheme) {
    this.nameEscapingScheme = nameEscapingScheme;
    return (A) this;
  }
  
  public A withNameValidationScheme(String nameValidationScheme) {
    this.nameValidationScheme = nameValidationScheme;
    return (A) this;
  }
  
  public A withNewAdditionalAlertManagerConfigs(String key,String name,Boolean optional) {
    return (A) this.withAdditionalAlertManagerConfigs(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewAdditionalAlertRelabelConfigs(String key,String name,Boolean optional) {
    return (A) this.withAdditionalAlertRelabelConfigs(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewAdditionalScrapeConfigs(String key,String name,Boolean optional) {
    return (A) this.withAdditionalScrapeConfigs(new SecretKeySelector(key, name, optional));
  }
  
  public AlertingNested<A> withNewAlerting() {
    return new AlertingNested(null);
  }
  
  public AlertingNested<A> withNewAlertingLike(AlertingSpec item) {
    return new AlertingNested(item);
  }
  
  public ApiserverConfigNested<A> withNewApiserverConfig() {
    return new ApiserverConfigNested(null);
  }
  
  public ApiserverConfigNested<A> withNewApiserverConfigLike(APIServerConfig item) {
    return new ApiserverConfigNested(item);
  }
  
  public ArbitraryFSAccessThroughSMsNested<A> withNewArbitraryFSAccessThroughSMs() {
    return new ArbitraryFSAccessThroughSMsNested(null);
  }
  
  public A withNewArbitraryFSAccessThroughSMs(Boolean deny) {
    return (A) this.withArbitraryFSAccessThroughSMs(new ArbitraryFSAccessThroughSMsConfig(deny));
  }
  
  public ArbitraryFSAccessThroughSMsNested<A> withNewArbitraryFSAccessThroughSMsLike(ArbitraryFSAccessThroughSMsConfig item) {
    return new ArbitraryFSAccessThroughSMsNested(item);
  }
  
  public DnsConfigNested<A> withNewDnsConfig() {
    return new DnsConfigNested(null);
  }
  
  public DnsConfigNested<A> withNewDnsConfigLike(PodDNSConfig item) {
    return new DnsConfigNested(item);
  }
  
  public ExemplarsNested<A> withNewExemplars() {
    return new ExemplarsNested(null);
  }
  
  public A withNewExemplars(Long maxSize) {
    return (A) this.withExemplars(new Exemplars(maxSize));
  }
  
  public ExemplarsNested<A> withNewExemplarsLike(Exemplars item) {
    return new ExemplarsNested(item);
  }
  
  public OtlpNested<A> withNewOtlp() {
    return new OtlpNested(null);
  }
  
  public OtlpNested<A> withNewOtlpLike(OTLPConfig item) {
    return new OtlpNested(item);
  }
  
  public A withNewPersistentVolumeClaimRetentionPolicy(String whenDeleted,String whenScaled) {
    return (A) this.withPersistentVolumeClaimRetentionPolicy(new StatefulSetPersistentVolumeClaimRetentionPolicy(whenDeleted, whenScaled));
  }
  
  public PodMetadataNested<A> withNewPodMetadata() {
    return new PodMetadataNested(null);
  }
  
  public PodMetadataNested<A> withNewPodMetadataLike(EmbeddedObjectMetadata item) {
    return new PodMetadataNested(item);
  }
  
  public PodMonitorNamespaceSelectorNested<A> withNewPodMonitorNamespaceSelector() {
    return new PodMonitorNamespaceSelectorNested(null);
  }
  
  public PodMonitorNamespaceSelectorNested<A> withNewPodMonitorNamespaceSelectorLike(LabelSelector item) {
    return new PodMonitorNamespaceSelectorNested(item);
  }
  
  public PodMonitorSelectorNested<A> withNewPodMonitorSelector() {
    return new PodMonitorSelectorNested(null);
  }
  
  public PodMonitorSelectorNested<A> withNewPodMonitorSelectorLike(LabelSelector item) {
    return new PodMonitorSelectorNested(item);
  }
  
  public ProbeNamespaceSelectorNested<A> withNewProbeNamespaceSelector() {
    return new ProbeNamespaceSelectorNested(null);
  }
  
  public ProbeNamespaceSelectorNested<A> withNewProbeNamespaceSelectorLike(LabelSelector item) {
    return new ProbeNamespaceSelectorNested(item);
  }
  
  public ProbeSelectorNested<A> withNewProbeSelector() {
    return new ProbeSelectorNested(null);
  }
  
  public ProbeSelectorNested<A> withNewProbeSelectorLike(LabelSelector item) {
    return new ProbeSelectorNested(item);
  }
  
  public QueryNested<A> withNewQuery() {
    return new QueryNested(null);
  }
  
  public A withNewQuery(String lookbackDelta,Integer maxConcurrency,Integer maxSamples,String timeout) {
    return (A) this.withQuery(new QuerySpec(lookbackDelta, maxConcurrency, maxSamples, timeout));
  }
  
  public QueryNested<A> withNewQueryLike(QuerySpec item) {
    return new QueryNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public RuleNamespaceSelectorNested<A> withNewRuleNamespaceSelector() {
    return new RuleNamespaceSelectorNested(null);
  }
  
  public RuleNamespaceSelectorNested<A> withNewRuleNamespaceSelectorLike(LabelSelector item) {
    return new RuleNamespaceSelectorNested(item);
  }
  
  public RuleSelectorNested<A> withNewRuleSelector() {
    return new RuleSelectorNested(null);
  }
  
  public RuleSelectorNested<A> withNewRuleSelectorLike(LabelSelector item) {
    return new RuleSelectorNested(item);
  }
  
  public RulesNested<A> withNewRules() {
    return new RulesNested(null);
  }
  
  public RulesNested<A> withNewRulesLike(Rules item) {
    return new RulesNested(item);
  }
  
  public RuntimeNested<A> withNewRuntime() {
    return new RuntimeNested(null);
  }
  
  public A withNewRuntime(Integer goGC) {
    return (A) this.withRuntime(new RuntimeConfig(goGC));
  }
  
  public RuntimeNested<A> withNewRuntimeLike(RuntimeConfig item) {
    return new RuntimeNested(item);
  }
  
  public ScrapeConfigNamespaceSelectorNested<A> withNewScrapeConfigNamespaceSelector() {
    return new ScrapeConfigNamespaceSelectorNested(null);
  }
  
  public ScrapeConfigNamespaceSelectorNested<A> withNewScrapeConfigNamespaceSelectorLike(LabelSelector item) {
    return new ScrapeConfigNamespaceSelectorNested(item);
  }
  
  public ScrapeConfigSelectorNested<A> withNewScrapeConfigSelector() {
    return new ScrapeConfigSelectorNested(null);
  }
  
  public ScrapeConfigSelectorNested<A> withNewScrapeConfigSelectorLike(LabelSelector item) {
    return new ScrapeConfigSelectorNested(item);
  }
  
  public ServiceMonitorNamespaceSelectorNested<A> withNewServiceMonitorNamespaceSelector() {
    return new ServiceMonitorNamespaceSelectorNested(null);
  }
  
  public ServiceMonitorNamespaceSelectorNested<A> withNewServiceMonitorNamespaceSelectorLike(LabelSelector item) {
    return new ServiceMonitorNamespaceSelectorNested(item);
  }
  
  public ServiceMonitorSelectorNested<A> withNewServiceMonitorSelector() {
    return new ServiceMonitorSelectorNested(null);
  }
  
  public ServiceMonitorSelectorNested<A> withNewServiceMonitorSelectorLike(LabelSelector item) {
    return new ServiceMonitorSelectorNested(item);
  }
  
  public ShardRetentionPolicyNested<A> withNewShardRetentionPolicy() {
    return new ShardRetentionPolicyNested(null);
  }
  
  public ShardRetentionPolicyNested<A> withNewShardRetentionPolicyLike(ShardRetentionPolicy item) {
    return new ShardRetentionPolicyNested(item);
  }
  
  public ShardingStrategyNested<A> withNewShardingStrategy() {
    return new ShardingStrategyNested(null);
  }
  
  public ShardingStrategyNested<A> withNewShardingStrategyLike(ShardingStrategy item) {
    return new ShardingStrategyNested(item);
  }
  
  public StorageNested<A> withNewStorage() {
    return new StorageNested(null);
  }
  
  public StorageNested<A> withNewStorageLike(StorageSpec item) {
    return new StorageNested(item);
  }
  
  public ThanosNested<A> withNewThanos() {
    return new ThanosNested(null);
  }
  
  public ThanosNested<A> withNewThanosLike(ThanosSpec item) {
    return new ThanosNested(item);
  }
  
  public TracingConfigNested<A> withNewTracingConfig() {
    return new TracingConfigNested(null);
  }
  
  public TracingConfigNested<A> withNewTracingConfigLike(TracingConfig item) {
    return new TracingConfigNested(item);
  }
  
  public TsdbNested<A> withNewTsdb() {
    return new TsdbNested(null);
  }
  
  public A withNewTsdb(String outOfOrderTimeWindow) {
    return (A) this.withTsdb(new TSDBSpec(outOfOrderTimeWindow));
  }
  
  public TsdbNested<A> withNewTsdbLike(TSDBSpec item) {
    return new TsdbNested(item);
  }
  
  public UpdateStrategyNested<A> withNewUpdateStrategy() {
    return new UpdateStrategyNested(null);
  }
  
  public UpdateStrategyNested<A> withNewUpdateStrategyLike(StatefulSetUpdateStrategy item) {
    return new UpdateStrategyNested(item);
  }
  
  public WebNested<A> withNewWeb() {
    return new WebNested(null);
  }
  
  public WebNested<A> withNewWebLike(PrometheusWebSpec item) {
    return new WebNested(item);
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withOtlp(OTLPConfig otlp) {
    this._visitables.remove("otlp");
    if (otlp != null) {
        this.otlp = new OTLPConfigBuilder(otlp);
        this._visitables.get("otlp").add(this.otlp);
    } else {
        this.otlp = null;
        this._visitables.get("otlp").remove(this.otlp);
    }
    return (A) this;
  }
  
  public A withOverrideHonorLabels() {
    return withOverrideHonorLabels(true);
  }
  
  public A withOverrideHonorLabels(Boolean overrideHonorLabels) {
    this.overrideHonorLabels = overrideHonorLabels;
    return (A) this;
  }
  
  public A withOverrideHonorTimestamps() {
    return withOverrideHonorTimestamps(true);
  }
  
  public A withOverrideHonorTimestamps(Boolean overrideHonorTimestamps) {
    this.overrideHonorTimestamps = overrideHonorTimestamps;
    return (A) this;
  }
  
  public A withPaused() {
    return withPaused(true);
  }
  
  public A withPaused(Boolean paused) {
    this.paused = paused;
    return (A) this;
  }
  
  public A withPersistentVolumeClaimRetentionPolicy(StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy) {
    this.persistentVolumeClaimRetentionPolicy = persistentVolumeClaimRetentionPolicy;
    return (A) this;
  }
  
  public A withPodManagementPolicy(String podManagementPolicy) {
    this.podManagementPolicy = podManagementPolicy;
    return (A) this;
  }
  
  public A withPodMetadata(EmbeddedObjectMetadata podMetadata) {
    this._visitables.remove("podMetadata");
    if (podMetadata != null) {
        this.podMetadata = new EmbeddedObjectMetadataBuilder(podMetadata);
        this._visitables.get("podMetadata").add(this.podMetadata);
    } else {
        this.podMetadata = null;
        this._visitables.get("podMetadata").remove(this.podMetadata);
    }
    return (A) this;
  }
  
  public A withPodMonitorNamespaceSelector(LabelSelector podMonitorNamespaceSelector) {
    this._visitables.remove("podMonitorNamespaceSelector");
    if (podMonitorNamespaceSelector != null) {
        this.podMonitorNamespaceSelector = new LabelSelectorBuilder(podMonitorNamespaceSelector);
        this._visitables.get("podMonitorNamespaceSelector").add(this.podMonitorNamespaceSelector);
    } else {
        this.podMonitorNamespaceSelector = null;
        this._visitables.get("podMonitorNamespaceSelector").remove(this.podMonitorNamespaceSelector);
    }
    return (A) this;
  }
  
  public A withPodMonitorSelector(LabelSelector podMonitorSelector) {
    this._visitables.remove("podMonitorSelector");
    if (podMonitorSelector != null) {
        this.podMonitorSelector = new LabelSelectorBuilder(podMonitorSelector);
        this._visitables.get("podMonitorSelector").add(this.podMonitorSelector);
    } else {
        this.podMonitorSelector = null;
        this._visitables.get("podMonitorSelector").remove(this.podMonitorSelector);
    }
    return (A) this;
  }
  
  public A withPodTargetLabels(List<String> podTargetLabels) {
    if (podTargetLabels != null) {
        this.podTargetLabels = new ArrayList();
        for (String item : podTargetLabels) {
          this.addToPodTargetLabels(item);
        }
    } else {
      this.podTargetLabels = null;
    }
    return (A) this;
  }
  
  public A withPodTargetLabels(String... podTargetLabels) {
    if (this.podTargetLabels != null) {
        this.podTargetLabels.clear();
        _visitables.remove("podTargetLabels");
    }
    if (podTargetLabels != null) {
      for (String item : podTargetLabels) {
        this.addToPodTargetLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withPortName(String portName) {
    this.portName = portName;
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withProbeNamespaceSelector(LabelSelector probeNamespaceSelector) {
    this._visitables.remove("probeNamespaceSelector");
    if (probeNamespaceSelector != null) {
        this.probeNamespaceSelector = new LabelSelectorBuilder(probeNamespaceSelector);
        this._visitables.get("probeNamespaceSelector").add(this.probeNamespaceSelector);
    } else {
        this.probeNamespaceSelector = null;
        this._visitables.get("probeNamespaceSelector").remove(this.probeNamespaceSelector);
    }
    return (A) this;
  }
  
  public A withProbeSelector(LabelSelector probeSelector) {
    this._visitables.remove("probeSelector");
    if (probeSelector != null) {
        this.probeSelector = new LabelSelectorBuilder(probeSelector);
        this._visitables.get("probeSelector").add(this.probeSelector);
    } else {
        this.probeSelector = null;
        this._visitables.get("probeSelector").remove(this.probeSelector);
    }
    return (A) this;
  }
  
  public A withPrometheusExternalLabelName(String prometheusExternalLabelName) {
    this.prometheusExternalLabelName = prometheusExternalLabelName;
    return (A) this;
  }
  
  public A withPrometheusRulesExcludedFromEnforce(List<PrometheusRuleExcludeConfig> prometheusRulesExcludedFromEnforce) {
    if (this.prometheusRulesExcludedFromEnforce != null) {
      this._visitables.get("prometheusRulesExcludedFromEnforce").clear();
    }
    if (prometheusRulesExcludedFromEnforce != null) {
        this.prometheusRulesExcludedFromEnforce = new ArrayList();
        for (PrometheusRuleExcludeConfig item : prometheusRulesExcludedFromEnforce) {
          this.addToPrometheusRulesExcludedFromEnforce(item);
        }
    } else {
      this.prometheusRulesExcludedFromEnforce = null;
    }
    return (A) this;
  }
  
  public A withPrometheusRulesExcludedFromEnforce(PrometheusRuleExcludeConfig... prometheusRulesExcludedFromEnforce) {
    if (this.prometheusRulesExcludedFromEnforce != null) {
        this.prometheusRulesExcludedFromEnforce.clear();
        _visitables.remove("prometheusRulesExcludedFromEnforce");
    }
    if (prometheusRulesExcludedFromEnforce != null) {
      for (PrometheusRuleExcludeConfig item : prometheusRulesExcludedFromEnforce) {
        this.addToPrometheusRulesExcludedFromEnforce(item);
      }
    }
    return (A) this;
  }
  
  public A withQuery(QuerySpec query) {
    this._visitables.remove("query");
    if (query != null) {
        this.query = new QuerySpecBuilder(query);
        this._visitables.get("query").add(this.query);
    } else {
        this.query = null;
        this._visitables.get("query").remove(this.query);
    }
    return (A) this;
  }
  
  public A withQueryLogFile(String queryLogFile) {
    this.queryLogFile = queryLogFile;
    return (A) this;
  }
  
  public A withReloadStrategy(String reloadStrategy) {
    this.reloadStrategy = reloadStrategy;
    return (A) this;
  }
  
  public A withRemoteRead(List<RemoteReadSpec> remoteRead) {
    if (this.remoteRead != null) {
      this._visitables.get("remoteRead").clear();
    }
    if (remoteRead != null) {
        this.remoteRead = new ArrayList();
        for (RemoteReadSpec item : remoteRead) {
          this.addToRemoteRead(item);
        }
    } else {
      this.remoteRead = null;
    }
    return (A) this;
  }
  
  public A withRemoteRead(RemoteReadSpec... remoteRead) {
    if (this.remoteRead != null) {
        this.remoteRead.clear();
        _visitables.remove("remoteRead");
    }
    if (remoteRead != null) {
      for (RemoteReadSpec item : remoteRead) {
        this.addToRemoteRead(item);
      }
    }
    return (A) this;
  }
  
  public A withRemoteWrite(List<RemoteWriteSpec> remoteWrite) {
    if (this.remoteWrite != null) {
      this._visitables.get("remoteWrite").clear();
    }
    if (remoteWrite != null) {
        this.remoteWrite = new ArrayList();
        for (RemoteWriteSpec item : remoteWrite) {
          this.addToRemoteWrite(item);
        }
    } else {
      this.remoteWrite = null;
    }
    return (A) this;
  }
  
  public A withRemoteWrite(RemoteWriteSpec... remoteWrite) {
    if (this.remoteWrite != null) {
        this.remoteWrite.clear();
        _visitables.remove("remoteWrite");
    }
    if (remoteWrite != null) {
      for (RemoteWriteSpec item : remoteWrite) {
        this.addToRemoteWrite(item);
      }
    }
    return (A) this;
  }
  
  public A withRemoteWriteReceiverMessageVersions(List<String> remoteWriteReceiverMessageVersions) {
    if (remoteWriteReceiverMessageVersions != null) {
        this.remoteWriteReceiverMessageVersions = new ArrayList();
        for (String item : remoteWriteReceiverMessageVersions) {
          this.addToRemoteWriteReceiverMessageVersions(item);
        }
    } else {
      this.remoteWriteReceiverMessageVersions = null;
    }
    return (A) this;
  }
  
  public A withRemoteWriteReceiverMessageVersions(String... remoteWriteReceiverMessageVersions) {
    if (this.remoteWriteReceiverMessageVersions != null) {
        this.remoteWriteReceiverMessageVersions.clear();
        _visitables.remove("remoteWriteReceiverMessageVersions");
    }
    if (remoteWriteReceiverMessageVersions != null) {
      for (String item : remoteWriteReceiverMessageVersions) {
        this.addToRemoteWriteReceiverMessageVersions(item);
      }
    }
    return (A) this;
  }
  
  public A withReplicaExternalLabelName(String replicaExternalLabelName) {
    this.replicaExternalLabelName = replicaExternalLabelName;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withResources(ResourceRequirements resources) {
    this._visitables.remove("resources");
    if (resources != null) {
        this.resources = new ResourceRequirementsBuilder(resources);
        this._visitables.get("resources").add(this.resources);
    } else {
        this.resources = null;
        this._visitables.get("resources").remove(this.resources);
    }
    return (A) this;
  }
  
  public A withRetention(String retention) {
    this.retention = retention;
    return (A) this;
  }
  
  public A withRetentionSize(String retentionSize) {
    this.retentionSize = retentionSize;
    return (A) this;
  }
  
  public A withRoutePrefix(String routePrefix) {
    this.routePrefix = routePrefix;
    return (A) this;
  }
  
  public A withRuleNamespaceSelector(LabelSelector ruleNamespaceSelector) {
    this._visitables.remove("ruleNamespaceSelector");
    if (ruleNamespaceSelector != null) {
        this.ruleNamespaceSelector = new LabelSelectorBuilder(ruleNamespaceSelector);
        this._visitables.get("ruleNamespaceSelector").add(this.ruleNamespaceSelector);
    } else {
        this.ruleNamespaceSelector = null;
        this._visitables.get("ruleNamespaceSelector").remove(this.ruleNamespaceSelector);
    }
    return (A) this;
  }
  
  public A withRuleQueryOffset(String ruleQueryOffset) {
    this.ruleQueryOffset = ruleQueryOffset;
    return (A) this;
  }
  
  public A withRuleSelector(LabelSelector ruleSelector) {
    this._visitables.remove("ruleSelector");
    if (ruleSelector != null) {
        this.ruleSelector = new LabelSelectorBuilder(ruleSelector);
        this._visitables.get("ruleSelector").add(this.ruleSelector);
    } else {
        this.ruleSelector = null;
        this._visitables.get("ruleSelector").remove(this.ruleSelector);
    }
    return (A) this;
  }
  
  public A withRules(Rules rules) {
    this._visitables.remove("rules");
    if (rules != null) {
        this.rules = new RulesBuilder(rules);
        this._visitables.get("rules").add(this.rules);
    } else {
        this.rules = null;
        this._visitables.get("rules").remove(this.rules);
    }
    return (A) this;
  }
  
  public A withRuntime(RuntimeConfig runtime) {
    this._visitables.remove("runtime");
    if (runtime != null) {
        this.runtime = new RuntimeConfigBuilder(runtime);
        this._visitables.get("runtime").add(this.runtime);
    } else {
        this.runtime = null;
        this._visitables.get("runtime").remove(this.runtime);
    }
    return (A) this;
  }
  
  public A withSampleLimit(Long sampleLimit) {
    this.sampleLimit = sampleLimit;
    return (A) this;
  }
  
  public A withSchedulerName(String schedulerName) {
    this.schedulerName = schedulerName;
    return (A) this;
  }
  
  public A withScrapeClasses(List<ScrapeClass> scrapeClasses) {
    if (this.scrapeClasses != null) {
      this._visitables.get("scrapeClasses").clear();
    }
    if (scrapeClasses != null) {
        this.scrapeClasses = new ArrayList();
        for (ScrapeClass item : scrapeClasses) {
          this.addToScrapeClasses(item);
        }
    } else {
      this.scrapeClasses = null;
    }
    return (A) this;
  }
  
  public A withScrapeClasses(ScrapeClass... scrapeClasses) {
    if (this.scrapeClasses != null) {
        this.scrapeClasses.clear();
        _visitables.remove("scrapeClasses");
    }
    if (scrapeClasses != null) {
      for (ScrapeClass item : scrapeClasses) {
        this.addToScrapeClasses(item);
      }
    }
    return (A) this;
  }
  
  public A withScrapeClassicHistograms() {
    return withScrapeClassicHistograms(true);
  }
  
  public A withScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
    this.scrapeClassicHistograms = scrapeClassicHistograms;
    return (A) this;
  }
  
  public A withScrapeConfigNamespaceSelector(LabelSelector scrapeConfigNamespaceSelector) {
    this._visitables.remove("scrapeConfigNamespaceSelector");
    if (scrapeConfigNamespaceSelector != null) {
        this.scrapeConfigNamespaceSelector = new LabelSelectorBuilder(scrapeConfigNamespaceSelector);
        this._visitables.get("scrapeConfigNamespaceSelector").add(this.scrapeConfigNamespaceSelector);
    } else {
        this.scrapeConfigNamespaceSelector = null;
        this._visitables.get("scrapeConfigNamespaceSelector").remove(this.scrapeConfigNamespaceSelector);
    }
    return (A) this;
  }
  
  public A withScrapeConfigSelector(LabelSelector scrapeConfigSelector) {
    this._visitables.remove("scrapeConfigSelector");
    if (scrapeConfigSelector != null) {
        this.scrapeConfigSelector = new LabelSelectorBuilder(scrapeConfigSelector);
        this._visitables.get("scrapeConfigSelector").add(this.scrapeConfigSelector);
    } else {
        this.scrapeConfigSelector = null;
        this._visitables.get("scrapeConfigSelector").remove(this.scrapeConfigSelector);
    }
    return (A) this;
  }
  
  public A withScrapeFailureLogFile(String scrapeFailureLogFile) {
    this.scrapeFailureLogFile = scrapeFailureLogFile;
    return (A) this;
  }
  
  public A withScrapeInterval(String scrapeInterval) {
    this.scrapeInterval = scrapeInterval;
    return (A) this;
  }
  
  public A withScrapeNativeHistograms() {
    return withScrapeNativeHistograms(true);
  }
  
  public A withScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
    this.scrapeNativeHistograms = scrapeNativeHistograms;
    return (A) this;
  }
  
  public A withScrapeProtocols(List<String> scrapeProtocols) {
    if (scrapeProtocols != null) {
        this.scrapeProtocols = new ArrayList();
        for (String item : scrapeProtocols) {
          this.addToScrapeProtocols(item);
        }
    } else {
      this.scrapeProtocols = null;
    }
    return (A) this;
  }
  
  public A withScrapeProtocols(String... scrapeProtocols) {
    if (this.scrapeProtocols != null) {
        this.scrapeProtocols.clear();
        _visitables.remove("scrapeProtocols");
    }
    if (scrapeProtocols != null) {
      for (String item : scrapeProtocols) {
        this.addToScrapeProtocols(item);
      }
    }
    return (A) this;
  }
  
  public A withScrapeTimeout(String scrapeTimeout) {
    this.scrapeTimeout = scrapeTimeout;
    return (A) this;
  }
  
  public A withSecrets(List<String> secrets) {
    if (secrets != null) {
        this.secrets = new ArrayList();
        for (String item : secrets) {
          this.addToSecrets(item);
        }
    } else {
      this.secrets = null;
    }
    return (A) this;
  }
  
  public A withSecrets(String... secrets) {
    if (this.secrets != null) {
        this.secrets.clear();
        _visitables.remove("secrets");
    }
    if (secrets != null) {
      for (String item : secrets) {
        this.addToSecrets(item);
      }
    }
    return (A) this;
  }
  
  public A withSecurityContext(PodSecurityContext securityContext) {
    this.securityContext = securityContext;
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withServiceDiscoveryRole(String serviceDiscoveryRole) {
    this.serviceDiscoveryRole = serviceDiscoveryRole;
    return (A) this;
  }
  
  public A withServiceMonitorNamespaceSelector(LabelSelector serviceMonitorNamespaceSelector) {
    this._visitables.remove("serviceMonitorNamespaceSelector");
    if (serviceMonitorNamespaceSelector != null) {
        this.serviceMonitorNamespaceSelector = new LabelSelectorBuilder(serviceMonitorNamespaceSelector);
        this._visitables.get("serviceMonitorNamespaceSelector").add(this.serviceMonitorNamespaceSelector);
    } else {
        this.serviceMonitorNamespaceSelector = null;
        this._visitables.get("serviceMonitorNamespaceSelector").remove(this.serviceMonitorNamespaceSelector);
    }
    return (A) this;
  }
  
  public A withServiceMonitorSelector(LabelSelector serviceMonitorSelector) {
    this._visitables.remove("serviceMonitorSelector");
    if (serviceMonitorSelector != null) {
        this.serviceMonitorSelector = new LabelSelectorBuilder(serviceMonitorSelector);
        this._visitables.get("serviceMonitorSelector").add(this.serviceMonitorSelector);
    } else {
        this.serviceMonitorSelector = null;
        this._visitables.get("serviceMonitorSelector").remove(this.serviceMonitorSelector);
    }
    return (A) this;
  }
  
  public A withServiceName(String serviceName) {
    this.serviceName = serviceName;
    return (A) this;
  }
  
  public A withSha(String sha) {
    this.sha = sha;
    return (A) this;
  }
  
  public A withShardRetentionPolicy(ShardRetentionPolicy shardRetentionPolicy) {
    this._visitables.remove("shardRetentionPolicy");
    if (shardRetentionPolicy != null) {
        this.shardRetentionPolicy = new ShardRetentionPolicyBuilder(shardRetentionPolicy);
        this._visitables.get("shardRetentionPolicy").add(this.shardRetentionPolicy);
    } else {
        this.shardRetentionPolicy = null;
        this._visitables.get("shardRetentionPolicy").remove(this.shardRetentionPolicy);
    }
    return (A) this;
  }
  
  public A withShardingStrategy(ShardingStrategy shardingStrategy) {
    this._visitables.remove("shardingStrategy");
    if (shardingStrategy != null) {
        this.shardingStrategy = new ShardingStrategyBuilder(shardingStrategy);
        this._visitables.get("shardingStrategy").add(this.shardingStrategy);
    } else {
        this.shardingStrategy = null;
        this._visitables.get("shardingStrategy").remove(this.shardingStrategy);
    }
    return (A) this;
  }
  
  public A withShards(Integer shards) {
    this.shards = shards;
    return (A) this;
  }
  
  public A withStorage(StorageSpec storage) {
    this._visitables.remove("storage");
    if (storage != null) {
        this.storage = new StorageSpecBuilder(storage);
        this._visitables.get("storage").add(this.storage);
    } else {
        this.storage = null;
        this._visitables.get("storage").remove(this.storage);
    }
    return (A) this;
  }
  
  public A withTag(String tag) {
    this.tag = tag;
    return (A) this;
  }
  
  public A withTargetLimit(Long targetLimit) {
    this.targetLimit = targetLimit;
    return (A) this;
  }
  
  public A withTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
    this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    return (A) this;
  }
  
  public A withThanos(ThanosSpec thanos) {
    this._visitables.remove("thanos");
    if (thanos != null) {
        this.thanos = new ThanosSpecBuilder(thanos);
        this._visitables.get("thanos").add(this.thanos);
    } else {
        this.thanos = null;
        this._visitables.get("thanos").remove(this.thanos);
    }
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  
  public A withTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
    if (this.topologySpreadConstraints != null) {
      this._visitables.get("topologySpreadConstraints").clear();
    }
    if (topologySpreadConstraints != null) {
        this.topologySpreadConstraints = new ArrayList();
        for (TopologySpreadConstraint item : topologySpreadConstraints) {
          this.addToTopologySpreadConstraints(item);
        }
    } else {
      this.topologySpreadConstraints = null;
    }
    return (A) this;
  }
  
  public A withTopologySpreadConstraints(TopologySpreadConstraint... topologySpreadConstraints) {
    if (this.topologySpreadConstraints != null) {
        this.topologySpreadConstraints.clear();
        _visitables.remove("topologySpreadConstraints");
    }
    if (topologySpreadConstraints != null) {
      for (TopologySpreadConstraint item : topologySpreadConstraints) {
        this.addToTopologySpreadConstraints(item);
      }
    }
    return (A) this;
  }
  
  public A withTracingConfig(TracingConfig tracingConfig) {
    this._visitables.remove("tracingConfig");
    if (tracingConfig != null) {
        this.tracingConfig = new TracingConfigBuilder(tracingConfig);
        this._visitables.get("tracingConfig").add(this.tracingConfig);
    } else {
        this.tracingConfig = null;
        this._visitables.get("tracingConfig").remove(this.tracingConfig);
    }
    return (A) this;
  }
  
  public A withTsdb(TSDBSpec tsdb) {
    this._visitables.remove("tsdb");
    if (tsdb != null) {
        this.tsdb = new TSDBSpecBuilder(tsdb);
        this._visitables.get("tsdb").add(this.tsdb);
    } else {
        this.tsdb = null;
        this._visitables.get("tsdb").remove(this.tsdb);
    }
    return (A) this;
  }
  
  public A withUpdateStrategy(StatefulSetUpdateStrategy updateStrategy) {
    this._visitables.remove("updateStrategy");
    if (updateStrategy != null) {
        this.updateStrategy = new StatefulSetUpdateStrategyBuilder(updateStrategy);
        this._visitables.get("updateStrategy").add(this.updateStrategy);
    } else {
        this.updateStrategy = null;
        this._visitables.get("updateStrategy").remove(this.updateStrategy);
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
  public A withVolumeMounts(List<VolumeMount> volumeMounts) {
    if (this.volumeMounts != null) {
      this._visitables.get("volumeMounts").clear();
    }
    if (volumeMounts != null) {
        this.volumeMounts = new ArrayList();
        for (VolumeMount item : volumeMounts) {
          this.addToVolumeMounts(item);
        }
    } else {
      this.volumeMounts = null;
    }
    return (A) this;
  }
  
  public A withVolumeMounts(VolumeMount... volumeMounts) {
    if (this.volumeMounts != null) {
        this.volumeMounts.clear();
        _visitables.remove("volumeMounts");
    }
    if (volumeMounts != null) {
      for (VolumeMount item : volumeMounts) {
        this.addToVolumeMounts(item);
      }
    }
    return (A) this;
  }
  
  public A withVolumes(List<Volume> volumes) {
    if (this.volumes != null) {
      this._visitables.get("volumes").clear();
    }
    if (volumes != null) {
        this.volumes = new ArrayList();
        for (Volume item : volumes) {
          this.addToVolumes(item);
        }
    } else {
      this.volumes = null;
    }
    return (A) this;
  }
  
  public A withVolumes(Volume... volumes) {
    if (this.volumes != null) {
        this.volumes.clear();
        _visitables.remove("volumes");
    }
    if (volumes != null) {
      for (Volume item : volumes) {
        this.addToVolumes(item);
      }
    }
    return (A) this;
  }
  
  public A withWalCompression() {
    return withWalCompression(true);
  }
  
  public A withWalCompression(Boolean walCompression) {
    this.walCompression = walCompression;
    return (A) this;
  }
  
  public A withWeb(PrometheusWebSpec web) {
    this._visitables.remove("web");
    if (web != null) {
        this.web = new PrometheusWebSpecBuilder(web);
        this._visitables.get("web").add(this.web);
    } else {
        this.web = null;
        this._visitables.get("web").remove(this.web);
    }
    return (A) this;
  }
  public class AdditionalArgsNested<N> extends ArgumentFluent<AdditionalArgsNested<N>> implements Nested<N>{
  
    ArgumentBuilder builder;
    int index;
  
    AdditionalArgsNested(int index,Argument item) {
      this.index = index;
      this.builder = new ArgumentBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToAdditionalArgs(index, builder.build());
    }
    
    public N endAdditionalArg() {
      return and();
    }
    
  }
  public class AlertingNested<N> extends AlertingSpecFluent<AlertingNested<N>> implements Nested<N>{
  
    AlertingSpecBuilder builder;
  
    AlertingNested(AlertingSpec item) {
      this.builder = new AlertingSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withAlerting(builder.build());
    }
    
    public N endAlerting() {
      return and();
    }
    
  }
  public class ApiserverConfigNested<N> extends APIServerConfigFluent<ApiserverConfigNested<N>> implements Nested<N>{
  
    APIServerConfigBuilder builder;
  
    ApiserverConfigNested(APIServerConfig item) {
      this.builder = new APIServerConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withApiserverConfig(builder.build());
    }
    
    public N endApiserverConfig() {
      return and();
    }
    
  }
  public class ArbitraryFSAccessThroughSMsNested<N> extends ArbitraryFSAccessThroughSMsConfigFluent<ArbitraryFSAccessThroughSMsNested<N>> implements Nested<N>{
  
    ArbitraryFSAccessThroughSMsConfigBuilder builder;
  
    ArbitraryFSAccessThroughSMsNested(ArbitraryFSAccessThroughSMsConfig item) {
      this.builder = new ArbitraryFSAccessThroughSMsConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withArbitraryFSAccessThroughSMs(builder.build());
    }
    
    public N endArbitraryFSAccessThroughSMs() {
      return and();
    }
    
  }
  public class ContainersNested<N> extends ContainerFluent<ContainersNested<N>> implements Nested<N>{
  
    ContainerBuilder builder;
    int index;
  
    ContainersNested(int index,Container item) {
      this.index = index;
      this.builder = new ContainerBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToContainers(index, builder.build());
    }
    
    public N endContainer() {
      return and();
    }
    
  }
  public class DnsConfigNested<N> extends PodDNSConfigFluent<DnsConfigNested<N>> implements Nested<N>{
  
    PodDNSConfigBuilder builder;
  
    DnsConfigNested(PodDNSConfig item) {
      this.builder = new PodDNSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withDnsConfig(builder.build());
    }
    
    public N endDnsConfig() {
      return and();
    }
    
  }
  public class ExcludedFromEnforcementNested<N> extends ObjectReferenceFluent<ExcludedFromEnforcementNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    ExcludedFromEnforcementNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToExcludedFromEnforcement(index, builder.build());
    }
    
    public N endExcludedFromEnforcement() {
      return and();
    }
    
  }
  public class ExemplarsNested<N> extends ExemplarsFluent<ExemplarsNested<N>> implements Nested<N>{
  
    ExemplarsBuilder builder;
  
    ExemplarsNested(Exemplars item) {
      this.builder = new ExemplarsBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withExemplars(builder.build());
    }
    
    public N endExemplars() {
      return and();
    }
    
  }
  public class HostAliasesNested<N> extends HostAliasFluent<HostAliasesNested<N>> implements Nested<N>{
  
    HostAliasBuilder builder;
    int index;
  
    HostAliasesNested(int index,HostAlias item) {
      this.index = index;
      this.builder = new HostAliasBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToHostAliases(index, builder.build());
    }
    
    public N endHostAlias() {
      return and();
    }
    
  }
  public class ImagePullSecretsNested<N> extends LocalObjectReferenceFluent<ImagePullSecretsNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    ImagePullSecretsNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToImagePullSecrets(index, builder.build());
    }
    
    public N endImagePullSecret() {
      return and();
    }
    
  }
  public class InitContainersNested<N> extends ContainerFluent<InitContainersNested<N>> implements Nested<N>{
  
    ContainerBuilder builder;
    int index;
  
    InitContainersNested(int index,Container item) {
      this.index = index;
      this.builder = new ContainerBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToInitContainers(index, builder.build());
    }
    
    public N endInitContainer() {
      return and();
    }
    
  }
  public class OtlpNested<N> extends OTLPConfigFluent<OtlpNested<N>> implements Nested<N>{
  
    OTLPConfigBuilder builder;
  
    OtlpNested(OTLPConfig item) {
      this.builder = new OTLPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withOtlp(builder.build());
    }
    
    public N endOtlp() {
      return and();
    }
    
  }
  public class PodMetadataNested<N> extends EmbeddedObjectMetadataFluent<PodMetadataNested<N>> implements Nested<N>{
  
    EmbeddedObjectMetadataBuilder builder;
  
    PodMetadataNested(EmbeddedObjectMetadata item) {
      this.builder = new EmbeddedObjectMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withPodMetadata(builder.build());
    }
    
    public N endPodMetadata() {
      return and();
    }
    
  }
  public class PodMonitorNamespaceSelectorNested<N> extends LabelSelectorFluent<PodMonitorNamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    PodMonitorNamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withPodMonitorNamespaceSelector(builder.build());
    }
    
    public N endPodMonitorNamespaceSelector() {
      return and();
    }
    
  }
  public class PodMonitorSelectorNested<N> extends LabelSelectorFluent<PodMonitorSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    PodMonitorSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withPodMonitorSelector(builder.build());
    }
    
    public N endPodMonitorSelector() {
      return and();
    }
    
  }
  public class ProbeNamespaceSelectorNested<N> extends LabelSelectorFluent<ProbeNamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ProbeNamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withProbeNamespaceSelector(builder.build());
    }
    
    public N endProbeNamespaceSelector() {
      return and();
    }
    
  }
  public class ProbeSelectorNested<N> extends LabelSelectorFluent<ProbeSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ProbeSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withProbeSelector(builder.build());
    }
    
    public N endProbeSelector() {
      return and();
    }
    
  }
  public class PrometheusRulesExcludedFromEnforceNested<N> extends PrometheusRuleExcludeConfigFluent<PrometheusRulesExcludedFromEnforceNested<N>> implements Nested<N>{
  
    PrometheusRuleExcludeConfigBuilder builder;
    int index;
  
    PrometheusRulesExcludedFromEnforceNested(int index,PrometheusRuleExcludeConfig item) {
      this.index = index;
      this.builder = new PrometheusRuleExcludeConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToPrometheusRulesExcludedFromEnforce(index, builder.build());
    }
    
    public N endPrometheusRulesExcludedFromEnforce() {
      return and();
    }
    
  }
  public class QueryNested<N> extends QuerySpecFluent<QueryNested<N>> implements Nested<N>{
  
    QuerySpecBuilder builder;
  
    QueryNested(QuerySpec item) {
      this.builder = new QuerySpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withQuery(builder.build());
    }
    
    public N endQuery() {
      return and();
    }
    
  }
  public class RemoteReadNested<N> extends RemoteReadSpecFluent<RemoteReadNested<N>> implements Nested<N>{
  
    RemoteReadSpecBuilder builder;
    int index;
  
    RemoteReadNested(int index,RemoteReadSpec item) {
      this.index = index;
      this.builder = new RemoteReadSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToRemoteRead(index, builder.build());
    }
    
    public N endRemoteRead() {
      return and();
    }
    
  }
  public class RemoteWriteNested<N> extends RemoteWriteSpecFluent<RemoteWriteNested<N>> implements Nested<N>{
  
    RemoteWriteSpecBuilder builder;
    int index;
  
    RemoteWriteNested(int index,RemoteWriteSpec item) {
      this.index = index;
      this.builder = new RemoteWriteSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToRemoteWrite(index, builder.build());
    }
    
    public N endRemoteWrite() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class RuleNamespaceSelectorNested<N> extends LabelSelectorFluent<RuleNamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    RuleNamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withRuleNamespaceSelector(builder.build());
    }
    
    public N endRuleNamespaceSelector() {
      return and();
    }
    
  }
  public class RuleSelectorNested<N> extends LabelSelectorFluent<RuleSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    RuleSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withRuleSelector(builder.build());
    }
    
    public N endRuleSelector() {
      return and();
    }
    
  }
  public class RulesNested<N> extends RulesFluent<RulesNested<N>> implements Nested<N>{
  
    RulesBuilder builder;
  
    RulesNested(Rules item) {
      this.builder = new RulesBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withRules(builder.build());
    }
    
    public N endRules() {
      return and();
    }
    
  }
  public class RuntimeNested<N> extends RuntimeConfigFluent<RuntimeNested<N>> implements Nested<N>{
  
    RuntimeConfigBuilder builder;
  
    RuntimeNested(RuntimeConfig item) {
      this.builder = new RuntimeConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withRuntime(builder.build());
    }
    
    public N endRuntime() {
      return and();
    }
    
  }
  public class ScrapeClassesNested<N> extends ScrapeClassFluent<ScrapeClassesNested<N>> implements Nested<N>{
  
    ScrapeClassBuilder builder;
    int index;
  
    ScrapeClassesNested(int index,ScrapeClass item) {
      this.index = index;
      this.builder = new ScrapeClassBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToScrapeClasses(index, builder.build());
    }
    
    public N endScrapeClass() {
      return and();
    }
    
  }
  public class ScrapeConfigNamespaceSelectorNested<N> extends LabelSelectorFluent<ScrapeConfigNamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ScrapeConfigNamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withScrapeConfigNamespaceSelector(builder.build());
    }
    
    public N endScrapeConfigNamespaceSelector() {
      return and();
    }
    
  }
  public class ScrapeConfigSelectorNested<N> extends LabelSelectorFluent<ScrapeConfigSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ScrapeConfigSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withScrapeConfigSelector(builder.build());
    }
    
    public N endScrapeConfigSelector() {
      return and();
    }
    
  }
  public class ServiceMonitorNamespaceSelectorNested<N> extends LabelSelectorFluent<ServiceMonitorNamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ServiceMonitorNamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withServiceMonitorNamespaceSelector(builder.build());
    }
    
    public N endServiceMonitorNamespaceSelector() {
      return and();
    }
    
  }
  public class ServiceMonitorSelectorNested<N> extends LabelSelectorFluent<ServiceMonitorSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ServiceMonitorSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withServiceMonitorSelector(builder.build());
    }
    
    public N endServiceMonitorSelector() {
      return and();
    }
    
  }
  public class ShardRetentionPolicyNested<N> extends ShardRetentionPolicyFluent<ShardRetentionPolicyNested<N>> implements Nested<N>{
  
    ShardRetentionPolicyBuilder builder;
  
    ShardRetentionPolicyNested(ShardRetentionPolicy item) {
      this.builder = new ShardRetentionPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withShardRetentionPolicy(builder.build());
    }
    
    public N endShardRetentionPolicy() {
      return and();
    }
    
  }
  public class ShardingStrategyNested<N> extends ShardingStrategyFluent<ShardingStrategyNested<N>> implements Nested<N>{
  
    ShardingStrategyBuilder builder;
  
    ShardingStrategyNested(ShardingStrategy item) {
      this.builder = new ShardingStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withShardingStrategy(builder.build());
    }
    
    public N endShardingStrategy() {
      return and();
    }
    
  }
  public class StorageNested<N> extends StorageSpecFluent<StorageNested<N>> implements Nested<N>{
  
    StorageSpecBuilder builder;
  
    StorageNested(StorageSpec item) {
      this.builder = new StorageSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withStorage(builder.build());
    }
    
    public N endStorage() {
      return and();
    }
    
  }
  public class ThanosNested<N> extends ThanosSpecFluent<ThanosNested<N>> implements Nested<N>{
  
    ThanosSpecBuilder builder;
  
    ThanosNested(ThanosSpec item) {
      this.builder = new ThanosSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withThanos(builder.build());
    }
    
    public N endThanos() {
      return and();
    }
    
  }
  public class TopologySpreadConstraintsNested<N> extends TopologySpreadConstraintFluent<TopologySpreadConstraintsNested<N>> implements Nested<N>{
  
    TopologySpreadConstraintBuilder builder;
    int index;
  
    TopologySpreadConstraintsNested(int index,TopologySpreadConstraint item) {
      this.index = index;
      this.builder = new TopologySpreadConstraintBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToTopologySpreadConstraints(index, builder.build());
    }
    
    public N endTopologySpreadConstraint() {
      return and();
    }
    
  }
  public class TracingConfigNested<N> extends TracingConfigFluent<TracingConfigNested<N>> implements Nested<N>{
  
    TracingConfigBuilder builder;
  
    TracingConfigNested(TracingConfig item) {
      this.builder = new TracingConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withTracingConfig(builder.build());
    }
    
    public N endTracingConfig() {
      return and();
    }
    
  }
  public class TsdbNested<N> extends TSDBSpecFluent<TsdbNested<N>> implements Nested<N>{
  
    TSDBSpecBuilder builder;
  
    TsdbNested(TSDBSpec item) {
      this.builder = new TSDBSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withTsdb(builder.build());
    }
    
    public N endTsdb() {
      return and();
    }
    
  }
  public class UpdateStrategyNested<N> extends StatefulSetUpdateStrategyFluent<UpdateStrategyNested<N>> implements Nested<N>{
  
    StatefulSetUpdateStrategyBuilder builder;
  
    UpdateStrategyNested(StatefulSetUpdateStrategy item) {
      this.builder = new StatefulSetUpdateStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withUpdateStrategy(builder.build());
    }
    
    public N endUpdateStrategy() {
      return and();
    }
    
  }
  public class VolumeMountsNested<N> extends VolumeMountFluent<VolumeMountsNested<N>> implements Nested<N>{
  
    VolumeMountBuilder builder;
    int index;
  
    VolumeMountsNested(int index,VolumeMount item) {
      this.index = index;
      this.builder = new VolumeMountBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToVolumeMounts(index, builder.build());
    }
    
    public N endVolumeMount() {
      return and();
    }
    
  }
  public class VolumesNested<N> extends VolumeFluent<VolumesNested<N>> implements Nested<N>{
  
    VolumeBuilder builder;
    int index;
  
    VolumesNested(int index,Volume item) {
      this.index = index;
      this.builder = new VolumeBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
  public class WebNested<N> extends PrometheusWebSpecFluent<WebNested<N>> implements Nested<N>{
  
    PrometheusWebSpecBuilder builder;
  
    WebNested(PrometheusWebSpec item) {
      this.builder = new PrometheusWebSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusSpecFluent.this.withWeb(builder.build());
    }
    
    public N endWeb() {
      return and();
    }
    
  }
}