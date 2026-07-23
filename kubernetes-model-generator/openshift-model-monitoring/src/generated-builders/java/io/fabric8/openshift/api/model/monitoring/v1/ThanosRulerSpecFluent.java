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
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeFluent;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.VolumeMountBuilder;
import io.fabric8.kubernetes.api.model.VolumeMountFluent;
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
public class ThanosRulerSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ThanosRulerSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<ArgumentBuilder> additionalArgs = new ArrayList<ArgumentBuilder>();
  private Map<String,Object> additionalProperties;
  private Affinity affinity;
  private List<String> alertDropLabels = new ArrayList<String>();
  private String alertQueryUrl;
  private String alertRelabelConfigFile;
  private SecretKeySelector alertRelabelConfigs;
  private SecretKeySelector alertmanagersConfig;
  private List<String> alertmanagersUrl = new ArrayList<String>();
  private ArrayList<ContainerBuilder> containers = new ArrayList<ContainerBuilder>();
  private PodDNSConfigBuilder dnsConfig;
  private String dnsPolicy;
  private List<String> enableFeatures = new ArrayList<String>();
  private Boolean enableServiceLinks;
  private String enforcedNamespaceLabel;
  private String evaluationInterval;
  private ArrayList<ObjectReferenceBuilder> excludedFromEnforcement = new ArrayList<ObjectReferenceBuilder>();
  private String externalPrefix;
  private GRPCServerTLSConfigBuilder grpcServerTlsConfig;
  private ArrayList<HostAliasBuilder> hostAliases = new ArrayList<HostAliasBuilder>();
  private Boolean hostUsers;
  private String image;
  private String imagePullPolicy;
  private ArrayList<LocalObjectReferenceBuilder> imagePullSecrets = new ArrayList<LocalObjectReferenceBuilder>();
  private ArrayList<ContainerBuilder> initContainers = new ArrayList<ContainerBuilder>();
  private Map<String,String> labels;
  private Boolean listenLocal;
  private String logFormat;
  private String logLevel;
  private Integer minReadySeconds;
  private Map<String,String> nodeSelector;
  private SecretKeySelector objectStorageConfig;
  private String objectStorageConfigFile;
  private Boolean paused;
  private String podManagementPolicy;
  private EmbeddedObjectMetadataBuilder podMetadata;
  private String portName;
  private String priorityClassName;
  private ArrayList<PrometheusRuleExcludeConfigBuilder> prometheusRulesExcludedFromEnforce = new ArrayList<PrometheusRuleExcludeConfigBuilder>();
  private SecretKeySelector queryConfig;
  private List<String> queryEndpoints = new ArrayList<String>();
  private ArrayList<RemoteWriteSpecBuilder> remoteWrite = new ArrayList<RemoteWriteSpecBuilder>();
  private Integer replicas;
  private String resendDelay;
  private ResourceRequirementsBuilder resources;
  private String retention;
  private String routePrefix;
  private Integer ruleConcurrentEval;
  private String ruleGracePeriod;
  private LabelSelectorBuilder ruleNamespaceSelector;
  private String ruleOutageTolerance;
  private String ruleQueryOffset;
  private LabelSelectorBuilder ruleSelector;
  private String schedulerName;
  private PodSecurityContext securityContext;
  private String serviceAccountName;
  private String serviceName;
  private StorageSpecBuilder storage;
  private Long terminationGracePeriodSeconds;
  private List<Toleration> tolerations = new ArrayList<Toleration>();
  private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
  private SecretKeySelector tracingConfig;
  private String tracingConfigFile;
  private StatefulSetUpdateStrategyBuilder updateStrategy;
  private String version;
  private ArrayList<VolumeMountBuilder> volumeMounts = new ArrayList<VolumeMountBuilder>();
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();
  private ThanosRulerWebSpecBuilder web;

  public ThanosRulerSpecFluent() {
  }
  
  public ThanosRulerSpecFluent(ThanosRulerSpec instance) {
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
  
  public A addAllToAlertDropLabels(Collection<String> items) {
    if (this.alertDropLabels == null) {
      this.alertDropLabels = new ArrayList();
    }
    for (String item : items) {
      this.alertDropLabels.add(item);
    }
    return (A) this;
  }
  
  public A addAllToAlertmanagersUrl(Collection<String> items) {
    if (this.alertmanagersUrl == null) {
      this.alertmanagersUrl = new ArrayList();
    }
    for (String item : items) {
      this.alertmanagersUrl.add(item);
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
  
  public A addAllToQueryEndpoints(Collection<String> items) {
    if (this.queryEndpoints == null) {
      this.queryEndpoints = new ArrayList();
    }
    for (String item : items) {
      this.queryEndpoints.add(item);
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
      this.topologySpreadConstraints.add(item);
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
  
  public RemoteWriteNested<A> addNewRemoteWrite() {
    return new RemoteWriteNested(-1, null);
  }
  
  public RemoteWriteNested<A> addNewRemoteWriteLike(RemoteWriteSpec item) {
    return new RemoteWriteNested(-1, item);
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
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
  
  public A addToAlertDropLabels(String... items) {
    if (this.alertDropLabels == null) {
      this.alertDropLabels = new ArrayList();
    }
    for (String item : items) {
      this.alertDropLabels.add(item);
    }
    return (A) this;
  }
  
  public A addToAlertDropLabels(int index,String item) {
    if (this.alertDropLabels == null) {
      this.alertDropLabels = new ArrayList();
    }
    this.alertDropLabels.add(index, item);
    return (A) this;
  }
  
  public A addToAlertmanagersUrl(String... items) {
    if (this.alertmanagersUrl == null) {
      this.alertmanagersUrl = new ArrayList();
    }
    for (String item : items) {
      this.alertmanagersUrl.add(item);
    }
    return (A) this;
  }
  
  public A addToAlertmanagersUrl(int index,String item) {
    if (this.alertmanagersUrl == null) {
      this.alertmanagersUrl = new ArrayList();
    }
    this.alertmanagersUrl.add(index, item);
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
  
  public A addToLabels(Map<String,String> map) {
    if (this.labels == null && map != null) {
      this.labels = new LinkedHashMap();
    }
    if (map != null) {
      this.labels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabels(String key,String value) {
    if (this.labels == null && key != null && value != null) {
      this.labels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.labels.put(key, value);
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
  
  public A addToQueryEndpoints(String... items) {
    if (this.queryEndpoints == null) {
      this.queryEndpoints = new ArrayList();
    }
    for (String item : items) {
      this.queryEndpoints.add(item);
    }
    return (A) this;
  }
  
  public A addToQueryEndpoints(int index,String item) {
    if (this.queryEndpoints == null) {
      this.queryEndpoints = new ArrayList();
    }
    this.queryEndpoints.add(index, item);
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
      this.topologySpreadConstraints.add(item);
    }
    return (A) this;
  }
  
  public A addToTopologySpreadConstraints(int index,TopologySpreadConstraint item) {
    if (this.topologySpreadConstraints == null) {
      this.topologySpreadConstraints = new ArrayList();
    }
    this.topologySpreadConstraints.add(index, item);
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
  
  public RemoteWriteSpec buildFirstRemoteWrite() {
    return this.remoteWrite.get(0).build();
  }
  
  public Volume buildFirstVolume() {
    return this.volumes.get(0).build();
  }
  
  public VolumeMount buildFirstVolumeMount() {
    return this.volumeMounts.get(0).build();
  }
  
  public GRPCServerTLSConfig buildGrpcServerTlsConfig() {
    return this.grpcServerTlsConfig != null ? this.grpcServerTlsConfig.build() : null;
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
  
  public RemoteWriteSpec buildLastRemoteWrite() {
    return this.remoteWrite.get(remoteWrite.size() - 1).build();
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
  
  public RemoteWriteSpec buildMatchingRemoteWrite(Predicate<RemoteWriteSpecBuilder> predicate) {
      for (RemoteWriteSpecBuilder item : remoteWrite) {
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
  
  public EmbeddedObjectMetadata buildPodMetadata() {
    return this.podMetadata != null ? this.podMetadata.build() : null;
  }
  
  public List<PrometheusRuleExcludeConfig> buildPrometheusRulesExcludedFromEnforce() {
    return this.prometheusRulesExcludedFromEnforce != null ? build(prometheusRulesExcludedFromEnforce) : null;
  }
  
  public PrometheusRuleExcludeConfig buildPrometheusRulesExcludedFromEnforce(int index) {
    return this.prometheusRulesExcludedFromEnforce.get(index).build();
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
  
  public StorageSpec buildStorage() {
    return this.storage != null ? this.storage.build() : null;
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
  
  public ThanosRulerWebSpec buildWeb() {
    return this.web != null ? this.web.build() : null;
  }
  
  protected void copyInstance(ThanosRulerSpec instance) {
    instance = instance != null ? instance : new ThanosRulerSpec();
    if (instance != null) {
        this.withAdditionalArgs(instance.getAdditionalArgs());
        this.withAffinity(instance.getAffinity());
        this.withAlertDropLabels(instance.getAlertDropLabels());
        this.withAlertQueryUrl(instance.getAlertQueryUrl());
        this.withAlertRelabelConfigFile(instance.getAlertRelabelConfigFile());
        this.withAlertRelabelConfigs(instance.getAlertRelabelConfigs());
        this.withAlertmanagersConfig(instance.getAlertmanagersConfig());
        this.withAlertmanagersUrl(instance.getAlertmanagersUrl());
        this.withContainers(instance.getContainers());
        this.withDnsConfig(instance.getDnsConfig());
        this.withDnsPolicy(instance.getDnsPolicy());
        this.withEnableFeatures(instance.getEnableFeatures());
        this.withEnableServiceLinks(instance.getEnableServiceLinks());
        this.withEnforcedNamespaceLabel(instance.getEnforcedNamespaceLabel());
        this.withEvaluationInterval(instance.getEvaluationInterval());
        this.withExcludedFromEnforcement(instance.getExcludedFromEnforcement());
        this.withExternalPrefix(instance.getExternalPrefix());
        this.withGrpcServerTlsConfig(instance.getGrpcServerTlsConfig());
        this.withHostAliases(instance.getHostAliases());
        this.withHostUsers(instance.getHostUsers());
        this.withImage(instance.getImage());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecrets(instance.getImagePullSecrets());
        this.withInitContainers(instance.getInitContainers());
        this.withLabels(instance.getLabels());
        this.withListenLocal(instance.getListenLocal());
        this.withLogFormat(instance.getLogFormat());
        this.withLogLevel(instance.getLogLevel());
        this.withMinReadySeconds(instance.getMinReadySeconds());
        this.withNodeSelector(instance.getNodeSelector());
        this.withObjectStorageConfig(instance.getObjectStorageConfig());
        this.withObjectStorageConfigFile(instance.getObjectStorageConfigFile());
        this.withPaused(instance.getPaused());
        this.withPodManagementPolicy(instance.getPodManagementPolicy());
        this.withPodMetadata(instance.getPodMetadata());
        this.withPortName(instance.getPortName());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withPrometheusRulesExcludedFromEnforce(instance.getPrometheusRulesExcludedFromEnforce());
        this.withQueryConfig(instance.getQueryConfig());
        this.withQueryEndpoints(instance.getQueryEndpoints());
        this.withRemoteWrite(instance.getRemoteWrite());
        this.withReplicas(instance.getReplicas());
        this.withResendDelay(instance.getResendDelay());
        this.withResources(instance.getResources());
        this.withRetention(instance.getRetention());
        this.withRoutePrefix(instance.getRoutePrefix());
        this.withRuleConcurrentEval(instance.getRuleConcurrentEval());
        this.withRuleGracePeriod(instance.getRuleGracePeriod());
        this.withRuleNamespaceSelector(instance.getRuleNamespaceSelector());
        this.withRuleOutageTolerance(instance.getRuleOutageTolerance());
        this.withRuleQueryOffset(instance.getRuleQueryOffset());
        this.withRuleSelector(instance.getRuleSelector());
        this.withSchedulerName(instance.getSchedulerName());
        this.withSecurityContext(instance.getSecurityContext());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withServiceName(instance.getServiceName());
        this.withStorage(instance.getStorage());
        this.withTerminationGracePeriodSeconds(instance.getTerminationGracePeriodSeconds());
        this.withTolerations(instance.getTolerations());
        this.withTopologySpreadConstraints(instance.getTopologySpreadConstraints());
        this.withTracingConfig(instance.getTracingConfig());
        this.withTracingConfigFile(instance.getTracingConfigFile());
        this.withUpdateStrategy(instance.getUpdateStrategy());
        this.withVersion(instance.getVersion());
        this.withVolumeMounts(instance.getVolumeMounts());
        this.withVolumes(instance.getVolumes());
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
  
  public RemoteWriteNested<A> editFirstRemoteWrite() {
    if (remoteWrite.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "remoteWrite"));
    }
    return this.setNewRemoteWriteLike(0, this.buildRemoteWrite(0));
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
  
  public GrpcServerTlsConfigNested<A> editGrpcServerTlsConfig() {
    return this.withNewGrpcServerTlsConfigLike(Optional.ofNullable(this.buildGrpcServerTlsConfig()).orElse(null));
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
  
  public RemoteWriteNested<A> editLastRemoteWrite() {
    int index = remoteWrite.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "remoteWrite"));
    }
    return this.setNewRemoteWriteLike(index, this.buildRemoteWrite(index));
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
  
  public DnsConfigNested<A> editOrNewDnsConfig() {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(new PodDNSConfigBuilder().build()));
  }
  
  public DnsConfigNested<A> editOrNewDnsConfigLike(PodDNSConfig item) {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(item));
  }
  
  public GrpcServerTlsConfigNested<A> editOrNewGrpcServerTlsConfig() {
    return this.withNewGrpcServerTlsConfigLike(Optional.ofNullable(this.buildGrpcServerTlsConfig()).orElse(new GRPCServerTLSConfigBuilder().build()));
  }
  
  public GrpcServerTlsConfigNested<A> editOrNewGrpcServerTlsConfigLike(GRPCServerTLSConfig item) {
    return this.withNewGrpcServerTlsConfigLike(Optional.ofNullable(this.buildGrpcServerTlsConfig()).orElse(item));
  }
  
  public PodMetadataNested<A> editOrNewPodMetadata() {
    return this.withNewPodMetadataLike(Optional.ofNullable(this.buildPodMetadata()).orElse(new EmbeddedObjectMetadataBuilder().build()));
  }
  
  public PodMetadataNested<A> editOrNewPodMetadataLike(EmbeddedObjectMetadata item) {
    return this.withNewPodMetadataLike(Optional.ofNullable(this.buildPodMetadata()).orElse(item));
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
  
  public StorageNested<A> editOrNewStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(new StorageSpecBuilder().build()));
  }
  
  public StorageNested<A> editOrNewStorageLike(StorageSpec item) {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(item));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategy() {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(new StatefulSetUpdateStrategyBuilder().build()));
  }
  
  public UpdateStrategyNested<A> editOrNewUpdateStrategyLike(StatefulSetUpdateStrategy item) {
    return this.withNewUpdateStrategyLike(Optional.ofNullable(this.buildUpdateStrategy()).orElse(item));
  }
  
  public WebNested<A> editOrNewWeb() {
    return this.withNewWebLike(Optional.ofNullable(this.buildWeb()).orElse(new ThanosRulerWebSpecBuilder().build()));
  }
  
  public WebNested<A> editOrNewWebLike(ThanosRulerWebSpec item) {
    return this.withNewWebLike(Optional.ofNullable(this.buildWeb()).orElse(item));
  }
  
  public PodMetadataNested<A> editPodMetadata() {
    return this.withNewPodMetadataLike(Optional.ofNullable(this.buildPodMetadata()).orElse(null));
  }
  
  public PrometheusRulesExcludedFromEnforceNested<A> editPrometheusRulesExcludedFromEnforce(int index) {
    if (prometheusRulesExcludedFromEnforce.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "prometheusRulesExcludedFromEnforce"));
    }
    return this.setNewPrometheusRulesExcludedFromEnforceLike(index, this.buildPrometheusRulesExcludedFromEnforce(index));
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
  
  public StorageNested<A> editStorage() {
    return this.withNewStorageLike(Optional.ofNullable(this.buildStorage()).orElse(null));
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
    ThanosRulerSpecFluent that = (ThanosRulerSpecFluent) o;
    if (!(Objects.equals(additionalArgs, that.additionalArgs))) {
      return false;
    }
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(alertDropLabels, that.alertDropLabels))) {
      return false;
    }
    if (!(Objects.equals(alertQueryUrl, that.alertQueryUrl))) {
      return false;
    }
    if (!(Objects.equals(alertRelabelConfigFile, that.alertRelabelConfigFile))) {
      return false;
    }
    if (!(Objects.equals(alertRelabelConfigs, that.alertRelabelConfigs))) {
      return false;
    }
    if (!(Objects.equals(alertmanagersConfig, that.alertmanagersConfig))) {
      return false;
    }
    if (!(Objects.equals(alertmanagersUrl, that.alertmanagersUrl))) {
      return false;
    }
    if (!(Objects.equals(containers, that.containers))) {
      return false;
    }
    if (!(Objects.equals(dnsConfig, that.dnsConfig))) {
      return false;
    }
    if (!(Objects.equals(dnsPolicy, that.dnsPolicy))) {
      return false;
    }
    if (!(Objects.equals(enableFeatures, that.enableFeatures))) {
      return false;
    }
    if (!(Objects.equals(enableServiceLinks, that.enableServiceLinks))) {
      return false;
    }
    if (!(Objects.equals(enforcedNamespaceLabel, that.enforcedNamespaceLabel))) {
      return false;
    }
    if (!(Objects.equals(evaluationInterval, that.evaluationInterval))) {
      return false;
    }
    if (!(Objects.equals(excludedFromEnforcement, that.excludedFromEnforcement))) {
      return false;
    }
    if (!(Objects.equals(externalPrefix, that.externalPrefix))) {
      return false;
    }
    if (!(Objects.equals(grpcServerTlsConfig, that.grpcServerTlsConfig))) {
      return false;
    }
    if (!(Objects.equals(hostAliases, that.hostAliases))) {
      return false;
    }
    if (!(Objects.equals(hostUsers, that.hostUsers))) {
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
    if (!(Objects.equals(labels, that.labels))) {
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
    if (!(Objects.equals(minReadySeconds, that.minReadySeconds))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(objectStorageConfig, that.objectStorageConfig))) {
      return false;
    }
    if (!(Objects.equals(objectStorageConfigFile, that.objectStorageConfigFile))) {
      return false;
    }
    if (!(Objects.equals(paused, that.paused))) {
      return false;
    }
    if (!(Objects.equals(podManagementPolicy, that.podManagementPolicy))) {
      return false;
    }
    if (!(Objects.equals(podMetadata, that.podMetadata))) {
      return false;
    }
    if (!(Objects.equals(portName, that.portName))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(prometheusRulesExcludedFromEnforce, that.prometheusRulesExcludedFromEnforce))) {
      return false;
    }
    if (!(Objects.equals(queryConfig, that.queryConfig))) {
      return false;
    }
    if (!(Objects.equals(queryEndpoints, that.queryEndpoints))) {
      return false;
    }
    if (!(Objects.equals(remoteWrite, that.remoteWrite))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(resendDelay, that.resendDelay))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(retention, that.retention))) {
      return false;
    }
    if (!(Objects.equals(routePrefix, that.routePrefix))) {
      return false;
    }
    if (!(Objects.equals(ruleConcurrentEval, that.ruleConcurrentEval))) {
      return false;
    }
    if (!(Objects.equals(ruleGracePeriod, that.ruleGracePeriod))) {
      return false;
    }
    if (!(Objects.equals(ruleNamespaceSelector, that.ruleNamespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(ruleOutageTolerance, that.ruleOutageTolerance))) {
      return false;
    }
    if (!(Objects.equals(ruleQueryOffset, that.ruleQueryOffset))) {
      return false;
    }
    if (!(Objects.equals(ruleSelector, that.ruleSelector))) {
      return false;
    }
    if (!(Objects.equals(schedulerName, that.schedulerName))) {
      return false;
    }
    if (!(Objects.equals(securityContext, that.securityContext))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(serviceName, that.serviceName))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
      return false;
    }
    if (!(Objects.equals(terminationGracePeriodSeconds, that.terminationGracePeriodSeconds))) {
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
    if (!(Objects.equals(tracingConfigFile, that.tracingConfigFile))) {
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
    if (!(Objects.equals(web, that.web))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Affinity getAffinity() {
    return this.affinity;
  }
  
  public String getAlertDropLabel(int index) {
    return this.alertDropLabels.get(index);
  }
  
  public List<String> getAlertDropLabels() {
    return this.alertDropLabels;
  }
  
  public String getAlertQueryUrl() {
    return this.alertQueryUrl;
  }
  
  public String getAlertRelabelConfigFile() {
    return this.alertRelabelConfigFile;
  }
  
  public SecretKeySelector getAlertRelabelConfigs() {
    return this.alertRelabelConfigs;
  }
  
  public SecretKeySelector getAlertmanagersConfig() {
    return this.alertmanagersConfig;
  }
  
  public List<String> getAlertmanagersUrl() {
    return this.alertmanagersUrl;
  }
  
  public String getAlertmanagersUrl(int index) {
    return this.alertmanagersUrl.get(index);
  }
  
  public String getDnsPolicy() {
    return this.dnsPolicy;
  }
  
  public String getEnableFeature(int index) {
    return this.enableFeatures.get(index);
  }
  
  public List<String> getEnableFeatures() {
    return this.enableFeatures;
  }
  
  public Boolean getEnableServiceLinks() {
    return this.enableServiceLinks;
  }
  
  public String getEnforcedNamespaceLabel() {
    return this.enforcedNamespaceLabel;
  }
  
  public String getEvaluationInterval() {
    return this.evaluationInterval;
  }
  
  public String getExternalPrefix() {
    return this.externalPrefix;
  }
  
  public String getFirstAlertDropLabel() {
    return this.alertDropLabels.get(0);
  }
  
  public String getFirstAlertmanagersUrl() {
    return this.alertmanagersUrl.get(0);
  }
  
  public String getFirstEnableFeature() {
    return this.enableFeatures.get(0);
  }
  
  public String getFirstQueryEndpoint() {
    return this.queryEndpoints.get(0);
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public TopologySpreadConstraint getFirstTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(0);
  }
  
  public Boolean getHostUsers() {
    return this.hostUsers;
  }
  
  public String getImage() {
    return this.image;
  }
  
  public String getImagePullPolicy() {
    return this.imagePullPolicy;
  }
  
  public Map<String,String> getLabels() {
    return this.labels;
  }
  
  public String getLastAlertDropLabel() {
    return this.alertDropLabels.get(alertDropLabels.size() - 1);
  }
  
  public String getLastAlertmanagersUrl() {
    return this.alertmanagersUrl.get(alertmanagersUrl.size() - 1);
  }
  
  public String getLastEnableFeature() {
    return this.enableFeatures.get(enableFeatures.size() - 1);
  }
  
  public String getLastQueryEndpoint() {
    return this.queryEndpoints.get(queryEndpoints.size() - 1);
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public TopologySpreadConstraint getLastTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(topologySpreadConstraints.size() - 1);
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
  
  public String getMatchingAlertDropLabel(Predicate<String> predicate) {
      for (String item : alertDropLabels) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingAlertmanagersUrl(Predicate<String> predicate) {
      for (String item : alertmanagersUrl) {
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
  
  public String getMatchingQueryEndpoint(Predicate<String> predicate) {
      for (String item : queryEndpoints) {
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
  
  public TopologySpreadConstraint getMatchingTopologySpreadConstraint(Predicate<TopologySpreadConstraint> predicate) {
      for (TopologySpreadConstraint item : topologySpreadConstraints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMinReadySeconds() {
    return this.minReadySeconds;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public SecretKeySelector getObjectStorageConfig() {
    return this.objectStorageConfig;
  }
  
  public String getObjectStorageConfigFile() {
    return this.objectStorageConfigFile;
  }
  
  public Boolean getPaused() {
    return this.paused;
  }
  
  public String getPodManagementPolicy() {
    return this.podManagementPolicy;
  }
  
  public String getPortName() {
    return this.portName;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public SecretKeySelector getQueryConfig() {
    return this.queryConfig;
  }
  
  public String getQueryEndpoint(int index) {
    return this.queryEndpoints.get(index);
  }
  
  public List<String> getQueryEndpoints() {
    return this.queryEndpoints;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getResendDelay() {
    return this.resendDelay;
  }
  
  public String getRetention() {
    return this.retention;
  }
  
  public String getRoutePrefix() {
    return this.routePrefix;
  }
  
  public Integer getRuleConcurrentEval() {
    return this.ruleConcurrentEval;
  }
  
  public String getRuleGracePeriod() {
    return this.ruleGracePeriod;
  }
  
  public String getRuleOutageTolerance() {
    return this.ruleOutageTolerance;
  }
  
  public String getRuleQueryOffset() {
    return this.ruleQueryOffset;
  }
  
  public String getSchedulerName() {
    return this.schedulerName;
  }
  
  public PodSecurityContext getSecurityContext() {
    return this.securityContext;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public String getServiceName() {
    return this.serviceName;
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
  
  public TopologySpreadConstraint getTopologySpreadConstraint(int index) {
    return this.topologySpreadConstraints.get(index);
  }
  
  public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
    return this.topologySpreadConstraints;
  }
  
  public SecretKeySelector getTracingConfig() {
    return this.tracingConfig;
  }
  
  public String getTracingConfigFile() {
    return this.tracingConfigFile;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalArgs() {
    return this.additionalArgs != null && !(this.additionalArgs.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasAlertDropLabels() {
    return this.alertDropLabels != null && !(this.alertDropLabels.isEmpty());
  }
  
  public boolean hasAlertQueryUrl() {
    return this.alertQueryUrl != null;
  }
  
  public boolean hasAlertRelabelConfigFile() {
    return this.alertRelabelConfigFile != null;
  }
  
  public boolean hasAlertRelabelConfigs() {
    return this.alertRelabelConfigs != null;
  }
  
  public boolean hasAlertmanagersConfig() {
    return this.alertmanagersConfig != null;
  }
  
  public boolean hasAlertmanagersUrl() {
    return this.alertmanagersUrl != null && !(this.alertmanagersUrl.isEmpty());
  }
  
  public boolean hasContainers() {
    return this.containers != null && !(this.containers.isEmpty());
  }
  
  public boolean hasDnsConfig() {
    return this.dnsConfig != null;
  }
  
  public boolean hasDnsPolicy() {
    return this.dnsPolicy != null;
  }
  
  public boolean hasEnableFeatures() {
    return this.enableFeatures != null && !(this.enableFeatures.isEmpty());
  }
  
  public boolean hasEnableServiceLinks() {
    return this.enableServiceLinks != null;
  }
  
  public boolean hasEnforcedNamespaceLabel() {
    return this.enforcedNamespaceLabel != null;
  }
  
  public boolean hasEvaluationInterval() {
    return this.evaluationInterval != null;
  }
  
  public boolean hasExcludedFromEnforcement() {
    return this.excludedFromEnforcement != null && !(this.excludedFromEnforcement.isEmpty());
  }
  
  public boolean hasExternalPrefix() {
    return this.externalPrefix != null;
  }
  
  public boolean hasGrpcServerTlsConfig() {
    return this.grpcServerTlsConfig != null;
  }
  
  public boolean hasHostAliases() {
    return this.hostAliases != null && !(this.hostAliases.isEmpty());
  }
  
  public boolean hasHostUsers() {
    return this.hostUsers != null;
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
  
  public boolean hasLabels() {
    return this.labels != null;
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
  
  public boolean hasMatchingAlertDropLabel(Predicate<String> predicate) {
      for (String item : alertDropLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAlertmanagersUrl(Predicate<String> predicate) {
      for (String item : alertmanagersUrl) {
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
  
  public boolean hasMatchingPrometheusRulesExcludedFromEnforce(Predicate<PrometheusRuleExcludeConfigBuilder> predicate) {
      for (PrometheusRuleExcludeConfigBuilder item : prometheusRulesExcludedFromEnforce) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingQueryEndpoint(Predicate<String> predicate) {
      for (String item : queryEndpoints) {
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
  
  public boolean hasMatchingToleration(Predicate<Toleration> predicate) {
      for (Toleration item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTopologySpreadConstraint(Predicate<TopologySpreadConstraint> predicate) {
      for (TopologySpreadConstraint item : topologySpreadConstraints) {
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
  
  public boolean hasMinReadySeconds() {
    return this.minReadySeconds != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasObjectStorageConfig() {
    return this.objectStorageConfig != null;
  }
  
  public boolean hasObjectStorageConfigFile() {
    return this.objectStorageConfigFile != null;
  }
  
  public boolean hasPaused() {
    return this.paused != null;
  }
  
  public boolean hasPodManagementPolicy() {
    return this.podManagementPolicy != null;
  }
  
  public boolean hasPodMetadata() {
    return this.podMetadata != null;
  }
  
  public boolean hasPortName() {
    return this.portName != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasPrometheusRulesExcludedFromEnforce() {
    return this.prometheusRulesExcludedFromEnforce != null && !(this.prometheusRulesExcludedFromEnforce.isEmpty());
  }
  
  public boolean hasQueryConfig() {
    return this.queryConfig != null;
  }
  
  public boolean hasQueryEndpoints() {
    return this.queryEndpoints != null && !(this.queryEndpoints.isEmpty());
  }
  
  public boolean hasRemoteWrite() {
    return this.remoteWrite != null && !(this.remoteWrite.isEmpty());
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasResendDelay() {
    return this.resendDelay != null;
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasRetention() {
    return this.retention != null;
  }
  
  public boolean hasRoutePrefix() {
    return this.routePrefix != null;
  }
  
  public boolean hasRuleConcurrentEval() {
    return this.ruleConcurrentEval != null;
  }
  
  public boolean hasRuleGracePeriod() {
    return this.ruleGracePeriod != null;
  }
  
  public boolean hasRuleNamespaceSelector() {
    return this.ruleNamespaceSelector != null;
  }
  
  public boolean hasRuleOutageTolerance() {
    return this.ruleOutageTolerance != null;
  }
  
  public boolean hasRuleQueryOffset() {
    return this.ruleQueryOffset != null;
  }
  
  public boolean hasRuleSelector() {
    return this.ruleSelector != null;
  }
  
  public boolean hasSchedulerName() {
    return this.schedulerName != null;
  }
  
  public boolean hasSecurityContext() {
    return this.securityContext != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasServiceName() {
    return this.serviceName != null;
  }
  
  public boolean hasStorage() {
    return this.storage != null;
  }
  
  public boolean hasTerminationGracePeriodSeconds() {
    return this.terminationGracePeriodSeconds != null;
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
  
  public boolean hasTracingConfigFile() {
    return this.tracingConfigFile != null;
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
  
  public boolean hasWeb() {
    return this.web != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalArgs, affinity, alertDropLabels, alertQueryUrl, alertRelabelConfigFile, alertRelabelConfigs, alertmanagersConfig, alertmanagersUrl, containers, dnsConfig, dnsPolicy, enableFeatures, enableServiceLinks, enforcedNamespaceLabel, evaluationInterval, excludedFromEnforcement, externalPrefix, grpcServerTlsConfig, hostAliases, hostUsers, image, imagePullPolicy, imagePullSecrets, initContainers, labels, listenLocal, logFormat, logLevel, minReadySeconds, nodeSelector, objectStorageConfig, objectStorageConfigFile, paused, podManagementPolicy, podMetadata, portName, priorityClassName, prometheusRulesExcludedFromEnforce, queryConfig, queryEndpoints, remoteWrite, replicas, resendDelay, resources, retention, routePrefix, ruleConcurrentEval, ruleGracePeriod, ruleNamespaceSelector, ruleOutageTolerance, ruleQueryOffset, ruleSelector, schedulerName, securityContext, serviceAccountName, serviceName, storage, terminationGracePeriodSeconds, tolerations, topologySpreadConstraints, tracingConfig, tracingConfigFile, updateStrategy, version, volumeMounts, volumes, web, additionalProperties);
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
  
  public A removeAllFromAlertDropLabels(Collection<String> items) {
    if (this.alertDropLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.alertDropLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromAlertmanagersUrl(Collection<String> items) {
    if (this.alertmanagersUrl == null) {
      return (A) this;
    }
    for (String item : items) {
      this.alertmanagersUrl.remove(item);
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
  
  public A removeAllFromQueryEndpoints(Collection<String> items) {
    if (this.queryEndpoints == null) {
      return (A) this;
    }
    for (String item : items) {
      this.queryEndpoints.remove(item);
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
      this.topologySpreadConstraints.remove(item);
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
  
  public A removeFromAlertDropLabels(String... items) {
    if (this.alertDropLabels == null) {
      return (A) this;
    }
    for (String item : items) {
      this.alertDropLabels.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAlertmanagersUrl(String... items) {
    if (this.alertmanagersUrl == null) {
      return (A) this;
    }
    for (String item : items) {
      this.alertmanagersUrl.remove(item);
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
  
  public A removeFromLabels(String key) {
    if (this.labels == null) {
      return (A) this;
    }
    if (key != null && this.labels != null) {
      this.labels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabels(Map<String,String> map) {
    if (this.labels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.labels != null) {
          this.labels.remove(key);
        }
      }
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
  
  public A removeFromQueryEndpoints(String... items) {
    if (this.queryEndpoints == null) {
      return (A) this;
    }
    for (String item : items) {
      this.queryEndpoints.remove(item);
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
      this.topologySpreadConstraints.remove(item);
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
  
  public RemoteWriteNested<A> setNewRemoteWriteLike(int index,RemoteWriteSpec item) {
    return new RemoteWriteNested(index, item);
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
  
  public A setToAlertDropLabels(int index,String item) {
    if (this.alertDropLabels == null) {
      this.alertDropLabels = new ArrayList();
    }
    this.alertDropLabels.set(index, item);
    return (A) this;
  }
  
  public A setToAlertmanagersUrl(int index,String item) {
    if (this.alertmanagersUrl == null) {
      this.alertmanagersUrl = new ArrayList();
    }
    this.alertmanagersUrl.set(index, item);
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
  
  public A setToQueryEndpoints(int index,String item) {
    if (this.queryEndpoints == null) {
      this.queryEndpoints = new ArrayList();
    }
    this.queryEndpoints.set(index, item);
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
    this.topologySpreadConstraints.set(index, item);
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
    if (!(additionalArgs == null) && !(additionalArgs.isEmpty())) {
        sb.append("additionalArgs:");
        sb.append(additionalArgs);
        sb.append(",");
    }
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(alertDropLabels == null) && !(alertDropLabels.isEmpty())) {
        sb.append("alertDropLabels:");
        sb.append(alertDropLabels);
        sb.append(",");
    }
    if (!(alertQueryUrl == null)) {
        sb.append("alertQueryUrl:");
        sb.append(alertQueryUrl);
        sb.append(",");
    }
    if (!(alertRelabelConfigFile == null)) {
        sb.append("alertRelabelConfigFile:");
        sb.append(alertRelabelConfigFile);
        sb.append(",");
    }
    if (!(alertRelabelConfigs == null)) {
        sb.append("alertRelabelConfigs:");
        sb.append(alertRelabelConfigs);
        sb.append(",");
    }
    if (!(alertmanagersConfig == null)) {
        sb.append("alertmanagersConfig:");
        sb.append(alertmanagersConfig);
        sb.append(",");
    }
    if (!(alertmanagersUrl == null) && !(alertmanagersUrl.isEmpty())) {
        sb.append("alertmanagersUrl:");
        sb.append(alertmanagersUrl);
        sb.append(",");
    }
    if (!(containers == null) && !(containers.isEmpty())) {
        sb.append("containers:");
        sb.append(containers);
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
    if (!(enableFeatures == null) && !(enableFeatures.isEmpty())) {
        sb.append("enableFeatures:");
        sb.append(enableFeatures);
        sb.append(",");
    }
    if (!(enableServiceLinks == null)) {
        sb.append("enableServiceLinks:");
        sb.append(enableServiceLinks);
        sb.append(",");
    }
    if (!(enforcedNamespaceLabel == null)) {
        sb.append("enforcedNamespaceLabel:");
        sb.append(enforcedNamespaceLabel);
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
    if (!(externalPrefix == null)) {
        sb.append("externalPrefix:");
        sb.append(externalPrefix);
        sb.append(",");
    }
    if (!(grpcServerTlsConfig == null)) {
        sb.append("grpcServerTlsConfig:");
        sb.append(grpcServerTlsConfig);
        sb.append(",");
    }
    if (!(hostAliases == null) && !(hostAliases.isEmpty())) {
        sb.append("hostAliases:");
        sb.append(hostAliases);
        sb.append(",");
    }
    if (!(hostUsers == null)) {
        sb.append("hostUsers:");
        sb.append(hostUsers);
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
    if (!(labels == null) && !(labels.isEmpty())) {
        sb.append("labels:");
        sb.append(labels);
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
    if (!(minReadySeconds == null)) {
        sb.append("minReadySeconds:");
        sb.append(minReadySeconds);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(objectStorageConfig == null)) {
        sb.append("objectStorageConfig:");
        sb.append(objectStorageConfig);
        sb.append(",");
    }
    if (!(objectStorageConfigFile == null)) {
        sb.append("objectStorageConfigFile:");
        sb.append(objectStorageConfigFile);
        sb.append(",");
    }
    if (!(paused == null)) {
        sb.append("paused:");
        sb.append(paused);
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
    if (!(prometheusRulesExcludedFromEnforce == null) && !(prometheusRulesExcludedFromEnforce.isEmpty())) {
        sb.append("prometheusRulesExcludedFromEnforce:");
        sb.append(prometheusRulesExcludedFromEnforce);
        sb.append(",");
    }
    if (!(queryConfig == null)) {
        sb.append("queryConfig:");
        sb.append(queryConfig);
        sb.append(",");
    }
    if (!(queryEndpoints == null) && !(queryEndpoints.isEmpty())) {
        sb.append("queryEndpoints:");
        sb.append(queryEndpoints);
        sb.append(",");
    }
    if (!(remoteWrite == null) && !(remoteWrite.isEmpty())) {
        sb.append("remoteWrite:");
        sb.append(remoteWrite);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(resendDelay == null)) {
        sb.append("resendDelay:");
        sb.append(resendDelay);
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
    if (!(routePrefix == null)) {
        sb.append("routePrefix:");
        sb.append(routePrefix);
        sb.append(",");
    }
    if (!(ruleConcurrentEval == null)) {
        sb.append("ruleConcurrentEval:");
        sb.append(ruleConcurrentEval);
        sb.append(",");
    }
    if (!(ruleGracePeriod == null)) {
        sb.append("ruleGracePeriod:");
        sb.append(ruleGracePeriod);
        sb.append(",");
    }
    if (!(ruleNamespaceSelector == null)) {
        sb.append("ruleNamespaceSelector:");
        sb.append(ruleNamespaceSelector);
        sb.append(",");
    }
    if (!(ruleOutageTolerance == null)) {
        sb.append("ruleOutageTolerance:");
        sb.append(ruleOutageTolerance);
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
    if (!(schedulerName == null)) {
        sb.append("schedulerName:");
        sb.append(schedulerName);
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
    if (!(serviceName == null)) {
        sb.append("serviceName:");
        sb.append(serviceName);
        sb.append(",");
    }
    if (!(storage == null)) {
        sb.append("storage:");
        sb.append(storage);
        sb.append(",");
    }
    if (!(terminationGracePeriodSeconds == null)) {
        sb.append("terminationGracePeriodSeconds:");
        sb.append(terminationGracePeriodSeconds);
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
    if (!(tracingConfigFile == null)) {
        sb.append("tracingConfigFile:");
        sb.append(tracingConfigFile);
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
  
  public A withAffinity(Affinity affinity) {
    this.affinity = affinity;
    return (A) this;
  }
  
  public A withAlertDropLabels(List<String> alertDropLabels) {
    if (alertDropLabels != null) {
        this.alertDropLabels = new ArrayList();
        for (String item : alertDropLabels) {
          this.addToAlertDropLabels(item);
        }
    } else {
      this.alertDropLabels = null;
    }
    return (A) this;
  }
  
  public A withAlertDropLabels(String... alertDropLabels) {
    if (this.alertDropLabels != null) {
        this.alertDropLabels.clear();
        _visitables.remove("alertDropLabels");
    }
    if (alertDropLabels != null) {
      for (String item : alertDropLabels) {
        this.addToAlertDropLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withAlertQueryUrl(String alertQueryUrl) {
    this.alertQueryUrl = alertQueryUrl;
    return (A) this;
  }
  
  public A withAlertRelabelConfigFile(String alertRelabelConfigFile) {
    this.alertRelabelConfigFile = alertRelabelConfigFile;
    return (A) this;
  }
  
  public A withAlertRelabelConfigs(SecretKeySelector alertRelabelConfigs) {
    this.alertRelabelConfigs = alertRelabelConfigs;
    return (A) this;
  }
  
  public A withAlertmanagersConfig(SecretKeySelector alertmanagersConfig) {
    this.alertmanagersConfig = alertmanagersConfig;
    return (A) this;
  }
  
  public A withAlertmanagersUrl(List<String> alertmanagersUrl) {
    if (alertmanagersUrl != null) {
        this.alertmanagersUrl = new ArrayList();
        for (String item : alertmanagersUrl) {
          this.addToAlertmanagersUrl(item);
        }
    } else {
      this.alertmanagersUrl = null;
    }
    return (A) this;
  }
  
  public A withAlertmanagersUrl(String... alertmanagersUrl) {
    if (this.alertmanagersUrl != null) {
        this.alertmanagersUrl.clear();
        _visitables.remove("alertmanagersUrl");
    }
    if (alertmanagersUrl != null) {
      for (String item : alertmanagersUrl) {
        this.addToAlertmanagersUrl(item);
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
  
  public A withEnableServiceLinks() {
    return withEnableServiceLinks(true);
  }
  
  public A withEnableServiceLinks(Boolean enableServiceLinks) {
    this.enableServiceLinks = enableServiceLinks;
    return (A) this;
  }
  
  public A withEnforcedNamespaceLabel(String enforcedNamespaceLabel) {
    this.enforcedNamespaceLabel = enforcedNamespaceLabel;
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
  
  public A withExternalPrefix(String externalPrefix) {
    this.externalPrefix = externalPrefix;
    return (A) this;
  }
  
  public A withGrpcServerTlsConfig(GRPCServerTLSConfig grpcServerTlsConfig) {
    this._visitables.remove("grpcServerTlsConfig");
    if (grpcServerTlsConfig != null) {
        this.grpcServerTlsConfig = new GRPCServerTLSConfigBuilder(grpcServerTlsConfig);
        this._visitables.get("grpcServerTlsConfig").add(this.grpcServerTlsConfig);
    } else {
        this.grpcServerTlsConfig = null;
        this._visitables.get("grpcServerTlsConfig").remove(this.grpcServerTlsConfig);
    }
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
  
  public A withHostUsers() {
    return withHostUsers(true);
  }
  
  public A withHostUsers(Boolean hostUsers) {
    this.hostUsers = hostUsers;
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
  
  public <K,V>A withLabels(Map<String,String> labels) {
    if (labels == null) {
      this.labels = null;
    } else {
      this.labels = new LinkedHashMap(labels);
    }
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
  
  public A withMinReadySeconds(Integer minReadySeconds) {
    this.minReadySeconds = minReadySeconds;
    return (A) this;
  }
  
  public A withNewAlertRelabelConfigs(String key,String name,Boolean optional) {
    return (A) this.withAlertRelabelConfigs(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewAlertmanagersConfig(String key,String name,Boolean optional) {
    return (A) this.withAlertmanagersConfig(new SecretKeySelector(key, name, optional));
  }
  
  public DnsConfigNested<A> withNewDnsConfig() {
    return new DnsConfigNested(null);
  }
  
  public DnsConfigNested<A> withNewDnsConfigLike(PodDNSConfig item) {
    return new DnsConfigNested(item);
  }
  
  public GrpcServerTlsConfigNested<A> withNewGrpcServerTlsConfig() {
    return new GrpcServerTlsConfigNested(null);
  }
  
  public GrpcServerTlsConfigNested<A> withNewGrpcServerTlsConfigLike(GRPCServerTLSConfig item) {
    return new GrpcServerTlsConfigNested(item);
  }
  
  public A withNewObjectStorageConfig(String key,String name,Boolean optional) {
    return (A) this.withObjectStorageConfig(new SecretKeySelector(key, name, optional));
  }
  
  public PodMetadataNested<A> withNewPodMetadata() {
    return new PodMetadataNested(null);
  }
  
  public PodMetadataNested<A> withNewPodMetadataLike(EmbeddedObjectMetadata item) {
    return new PodMetadataNested(item);
  }
  
  public A withNewQueryConfig(String key,String name,Boolean optional) {
    return (A) this.withQueryConfig(new SecretKeySelector(key, name, optional));
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
  
  public StorageNested<A> withNewStorage() {
    return new StorageNested(null);
  }
  
  public StorageNested<A> withNewStorageLike(StorageSpec item) {
    return new StorageNested(item);
  }
  
  public A withNewTracingConfig(String key,String name,Boolean optional) {
    return (A) this.withTracingConfig(new SecretKeySelector(key, name, optional));
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
  
  public WebNested<A> withNewWebLike(ThanosRulerWebSpec item) {
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
  
  public A withObjectStorageConfig(SecretKeySelector objectStorageConfig) {
    this.objectStorageConfig = objectStorageConfig;
    return (A) this;
  }
  
  public A withObjectStorageConfigFile(String objectStorageConfigFile) {
    this.objectStorageConfigFile = objectStorageConfigFile;
    return (A) this;
  }
  
  public A withPaused() {
    return withPaused(true);
  }
  
  public A withPaused(Boolean paused) {
    this.paused = paused;
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
  
  public A withPortName(String portName) {
    this.portName = portName;
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
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
  
  public A withQueryConfig(SecretKeySelector queryConfig) {
    this.queryConfig = queryConfig;
    return (A) this;
  }
  
  public A withQueryEndpoints(List<String> queryEndpoints) {
    if (queryEndpoints != null) {
        this.queryEndpoints = new ArrayList();
        for (String item : queryEndpoints) {
          this.addToQueryEndpoints(item);
        }
    } else {
      this.queryEndpoints = null;
    }
    return (A) this;
  }
  
  public A withQueryEndpoints(String... queryEndpoints) {
    if (this.queryEndpoints != null) {
        this.queryEndpoints.clear();
        _visitables.remove("queryEndpoints");
    }
    if (queryEndpoints != null) {
      for (String item : queryEndpoints) {
        this.addToQueryEndpoints(item);
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
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withResendDelay(String resendDelay) {
    this.resendDelay = resendDelay;
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
  
  public A withRoutePrefix(String routePrefix) {
    this.routePrefix = routePrefix;
    return (A) this;
  }
  
  public A withRuleConcurrentEval(Integer ruleConcurrentEval) {
    this.ruleConcurrentEval = ruleConcurrentEval;
    return (A) this;
  }
  
  public A withRuleGracePeriod(String ruleGracePeriod) {
    this.ruleGracePeriod = ruleGracePeriod;
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
  
  public A withRuleOutageTolerance(String ruleOutageTolerance) {
    this.ruleOutageTolerance = ruleOutageTolerance;
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
  
  public A withSchedulerName(String schedulerName) {
    this.schedulerName = schedulerName;
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
  
  public A withServiceName(String serviceName) {
    this.serviceName = serviceName;
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
  
  public A withTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
    this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
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
  
  public A withTracingConfig(SecretKeySelector tracingConfig) {
    this.tracingConfig = tracingConfig;
    return (A) this;
  }
  
  public A withTracingConfigFile(String tracingConfigFile) {
    this.tracingConfigFile = tracingConfigFile;
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
  
  public A withWeb(ThanosRulerWebSpec web) {
    this._visitables.remove("web");
    if (web != null) {
        this.web = new ThanosRulerWebSpecBuilder(web);
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
      return (N) ThanosRulerSpecFluent.this.setToAdditionalArgs(index, builder.build());
    }
    
    public N endAdditionalArg() {
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
      return (N) ThanosRulerSpecFluent.this.setToContainers(index, builder.build());
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
      return (N) ThanosRulerSpecFluent.this.withDnsConfig(builder.build());
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
      return (N) ThanosRulerSpecFluent.this.setToExcludedFromEnforcement(index, builder.build());
    }
    
    public N endExcludedFromEnforcement() {
      return and();
    }
    
  }
  public class GrpcServerTlsConfigNested<N> extends GRPCServerTLSConfigFluent<GrpcServerTlsConfigNested<N>> implements Nested<N>{
  
    GRPCServerTLSConfigBuilder builder;
  
    GrpcServerTlsConfigNested(GRPCServerTLSConfig item) {
      this.builder = new GRPCServerTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosRulerSpecFluent.this.withGrpcServerTlsConfig(builder.build());
    }
    
    public N endGrpcServerTlsConfig() {
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
      return (N) ThanosRulerSpecFluent.this.setToHostAliases(index, builder.build());
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
      return (N) ThanosRulerSpecFluent.this.setToImagePullSecrets(index, builder.build());
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
      return (N) ThanosRulerSpecFluent.this.setToInitContainers(index, builder.build());
    }
    
    public N endInitContainer() {
      return and();
    }
    
  }
  public class PodMetadataNested<N> extends EmbeddedObjectMetadataFluent<PodMetadataNested<N>> implements Nested<N>{
  
    EmbeddedObjectMetadataBuilder builder;
  
    PodMetadataNested(EmbeddedObjectMetadata item) {
      this.builder = new EmbeddedObjectMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosRulerSpecFluent.this.withPodMetadata(builder.build());
    }
    
    public N endPodMetadata() {
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
      return (N) ThanosRulerSpecFluent.this.setToPrometheusRulesExcludedFromEnforce(index, builder.build());
    }
    
    public N endPrometheusRulesExcludedFromEnforce() {
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
      return (N) ThanosRulerSpecFluent.this.setToRemoteWrite(index, builder.build());
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
      return (N) ThanosRulerSpecFluent.this.withResources(builder.build());
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
      return (N) ThanosRulerSpecFluent.this.withRuleNamespaceSelector(builder.build());
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
      return (N) ThanosRulerSpecFluent.this.withRuleSelector(builder.build());
    }
    
    public N endRuleSelector() {
      return and();
    }
    
  }
  public class StorageNested<N> extends StorageSpecFluent<StorageNested<N>> implements Nested<N>{
  
    StorageSpecBuilder builder;
  
    StorageNested(StorageSpec item) {
      this.builder = new StorageSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosRulerSpecFluent.this.withStorage(builder.build());
    }
    
    public N endStorage() {
      return and();
    }
    
  }
  public class UpdateStrategyNested<N> extends StatefulSetUpdateStrategyFluent<UpdateStrategyNested<N>> implements Nested<N>{
  
    StatefulSetUpdateStrategyBuilder builder;
  
    UpdateStrategyNested(StatefulSetUpdateStrategy item) {
      this.builder = new StatefulSetUpdateStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosRulerSpecFluent.this.withUpdateStrategy(builder.build());
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
      return (N) ThanosRulerSpecFluent.this.setToVolumeMounts(index, builder.build());
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
      return (N) ThanosRulerSpecFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
  public class WebNested<N> extends ThanosRulerWebSpecFluent<WebNested<N>> implements Nested<N>{
  
    ThanosRulerWebSpecBuilder builder;
  
    WebNested(ThanosRulerWebSpec item) {
      this.builder = new ThanosRulerWebSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ThanosRulerSpecFluent.this.withWeb(builder.build());
    }
    
    public N endWeb() {
      return and();
    }
    
  }
}