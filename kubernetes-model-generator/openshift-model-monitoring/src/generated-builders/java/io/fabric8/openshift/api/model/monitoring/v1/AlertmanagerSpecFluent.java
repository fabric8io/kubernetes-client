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
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
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
public class AlertmanagerSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.AlertmanagerSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<ArgumentBuilder> additionalArgs = new ArrayList<ArgumentBuilder>();
  private List<String> additionalPeers = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private Affinity affinity;
  private AlertmanagerConfigMatcherStrategyBuilder alertmanagerConfigMatcherStrategy;
  private LabelSelectorBuilder alertmanagerConfigNamespaceSelector;
  private LabelSelectorBuilder alertmanagerConfigSelector;
  private AlertmanagerConfigurationBuilder alertmanagerConfiguration;
  private Boolean automountServiceAccountToken;
  private String baseImage;
  private String clusterAdvertiseAddress;
  private String clusterGossipInterval;
  private String clusterLabel;
  private String clusterPeerTimeout;
  private String clusterPushpullInterval;
  private ClusterTLSConfigBuilder clusterTLS;
  private List<String> configMaps = new ArrayList<String>();
  private String configSecret;
  private ArrayList<ContainerBuilder> containers = new ArrayList<ContainerBuilder>();
  private PodDNSConfigBuilder dnsConfig;
  private String dnsPolicy;
  private List<String> enableFeatures = new ArrayList<String>();
  private Boolean enableServiceLinks;
  private String externalUrl;
  private Boolean forceEnableClusterMode;
  private ArrayList<HostAliasBuilder> hostAliases = new ArrayList<HostAliasBuilder>();
  private Boolean hostNetwork;
  private Boolean hostUsers;
  private String image;
  private String imagePullPolicy;
  private ArrayList<LocalObjectReferenceBuilder> imagePullSecrets = new ArrayList<LocalObjectReferenceBuilder>();
  private ArrayList<ContainerBuilder> initContainers = new ArrayList<ContainerBuilder>();
  private AlertmanagerLimitsSpecBuilder limits;
  private Boolean listenLocal;
  private String logFormat;
  private String logLevel;
  private Integer minReadySeconds;
  private Map<String,String> nodeSelector;
  private Boolean paused;
  private StatefulSetPersistentVolumeClaimRetentionPolicy persistentVolumeClaimRetentionPolicy;
  private String podManagementPolicy;
  private EmbeddedObjectMetadataBuilder podMetadata;
  private String portName;
  private String priorityClassName;
  private Integer replicas;
  private ResourceRequirementsBuilder resources;
  private String retention;
  private String routePrefix;
  private String schedulerName;
  private List<String> secrets = new ArrayList<String>();
  private PodSecurityContext securityContext;
  private String serviceAccountName;
  private String serviceName;
  private String sha;
  private StorageSpecBuilder storage;
  private String tag;
  private Long terminationGracePeriodSeconds;
  private List<Toleration> tolerations = new ArrayList<Toleration>();
  private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
  private StatefulSetUpdateStrategyBuilder updateStrategy;
  private String version;
  private ArrayList<VolumeMountBuilder> volumeMounts = new ArrayList<VolumeMountBuilder>();
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();
  private AlertmanagerWebSpecBuilder web;

  public AlertmanagerSpecFluent() {
  }
  
  public AlertmanagerSpecFluent(AlertmanagerSpec instance) {
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
  
  public A addAllToAdditionalPeers(Collection<String> items) {
    if (this.additionalPeers == null) {
      this.additionalPeers = new ArrayList();
    }
    for (String item : items) {
      this.additionalPeers.add(item);
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
  
  public A addToAdditionalPeers(String... items) {
    if (this.additionalPeers == null) {
      this.additionalPeers = new ArrayList();
    }
    for (String item : items) {
      this.additionalPeers.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalPeers(int index,String item) {
    if (this.additionalPeers == null) {
      this.additionalPeers = new ArrayList();
    }
    this.additionalPeers.add(index, item);
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
  
  public AlertmanagerConfigMatcherStrategy buildAlertmanagerConfigMatcherStrategy() {
    return this.alertmanagerConfigMatcherStrategy != null ? this.alertmanagerConfigMatcherStrategy.build() : null;
  }
  
  public LabelSelector buildAlertmanagerConfigNamespaceSelector() {
    return this.alertmanagerConfigNamespaceSelector != null ? this.alertmanagerConfigNamespaceSelector.build() : null;
  }
  
  public LabelSelector buildAlertmanagerConfigSelector() {
    return this.alertmanagerConfigSelector != null ? this.alertmanagerConfigSelector.build() : null;
  }
  
  public AlertmanagerConfiguration buildAlertmanagerConfiguration() {
    return this.alertmanagerConfiguration != null ? this.alertmanagerConfiguration.build() : null;
  }
  
  public ClusterTLSConfig buildClusterTLS() {
    return this.clusterTLS != null ? this.clusterTLS.build() : null;
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
  
  public Argument buildFirstAdditionalArg() {
    return this.additionalArgs.get(0).build();
  }
  
  public Container buildFirstContainer() {
    return this.containers.get(0).build();
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
  
  public HostAlias buildLastHostAlias() {
    return this.hostAliases.get(hostAliases.size() - 1).build();
  }
  
  public LocalObjectReference buildLastImagePullSecret() {
    return this.imagePullSecrets.get(imagePullSecrets.size() - 1).build();
  }
  
  public Container buildLastInitContainer() {
    return this.initContainers.get(initContainers.size() - 1).build();
  }
  
  public Volume buildLastVolume() {
    return this.volumes.get(volumes.size() - 1).build();
  }
  
  public VolumeMount buildLastVolumeMount() {
    return this.volumeMounts.get(volumeMounts.size() - 1).build();
  }
  
  public AlertmanagerLimitsSpec buildLimits() {
    return this.limits != null ? this.limits.build() : null;
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
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
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
  
  public AlertmanagerWebSpec buildWeb() {
    return this.web != null ? this.web.build() : null;
  }
  
  protected void copyInstance(AlertmanagerSpec instance) {
    instance = instance != null ? instance : new AlertmanagerSpec();
    if (instance != null) {
        this.withAdditionalArgs(instance.getAdditionalArgs());
        this.withAdditionalPeers(instance.getAdditionalPeers());
        this.withAffinity(instance.getAffinity());
        this.withAlertmanagerConfigMatcherStrategy(instance.getAlertmanagerConfigMatcherStrategy());
        this.withAlertmanagerConfigNamespaceSelector(instance.getAlertmanagerConfigNamespaceSelector());
        this.withAlertmanagerConfigSelector(instance.getAlertmanagerConfigSelector());
        this.withAlertmanagerConfiguration(instance.getAlertmanagerConfiguration());
        this.withAutomountServiceAccountToken(instance.getAutomountServiceAccountToken());
        this.withBaseImage(instance.getBaseImage());
        this.withClusterAdvertiseAddress(instance.getClusterAdvertiseAddress());
        this.withClusterGossipInterval(instance.getClusterGossipInterval());
        this.withClusterLabel(instance.getClusterLabel());
        this.withClusterPeerTimeout(instance.getClusterPeerTimeout());
        this.withClusterPushpullInterval(instance.getClusterPushpullInterval());
        this.withClusterTLS(instance.getClusterTLS());
        this.withConfigMaps(instance.getConfigMaps());
        this.withConfigSecret(instance.getConfigSecret());
        this.withContainers(instance.getContainers());
        this.withDnsConfig(instance.getDnsConfig());
        this.withDnsPolicy(instance.getDnsPolicy());
        this.withEnableFeatures(instance.getEnableFeatures());
        this.withEnableServiceLinks(instance.getEnableServiceLinks());
        this.withExternalUrl(instance.getExternalUrl());
        this.withForceEnableClusterMode(instance.getForceEnableClusterMode());
        this.withHostAliases(instance.getHostAliases());
        this.withHostNetwork(instance.getHostNetwork());
        this.withHostUsers(instance.getHostUsers());
        this.withImage(instance.getImage());
        this.withImagePullPolicy(instance.getImagePullPolicy());
        this.withImagePullSecrets(instance.getImagePullSecrets());
        this.withInitContainers(instance.getInitContainers());
        this.withLimits(instance.getLimits());
        this.withListenLocal(instance.getListenLocal());
        this.withLogFormat(instance.getLogFormat());
        this.withLogLevel(instance.getLogLevel());
        this.withMinReadySeconds(instance.getMinReadySeconds());
        this.withNodeSelector(instance.getNodeSelector());
        this.withPaused(instance.getPaused());
        this.withPersistentVolumeClaimRetentionPolicy(instance.getPersistentVolumeClaimRetentionPolicy());
        this.withPodManagementPolicy(instance.getPodManagementPolicy());
        this.withPodMetadata(instance.getPodMetadata());
        this.withPortName(instance.getPortName());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withReplicas(instance.getReplicas());
        this.withResources(instance.getResources());
        this.withRetention(instance.getRetention());
        this.withRoutePrefix(instance.getRoutePrefix());
        this.withSchedulerName(instance.getSchedulerName());
        this.withSecrets(instance.getSecrets());
        this.withSecurityContext(instance.getSecurityContext());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withServiceName(instance.getServiceName());
        this.withSha(instance.getSha());
        this.withStorage(instance.getStorage());
        this.withTag(instance.getTag());
        this.withTerminationGracePeriodSeconds(instance.getTerminationGracePeriodSeconds());
        this.withTolerations(instance.getTolerations());
        this.withTopologySpreadConstraints(instance.getTopologySpreadConstraints());
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
  
  public AlertmanagerConfigMatcherStrategyNested<A> editAlertmanagerConfigMatcherStrategy() {
    return this.withNewAlertmanagerConfigMatcherStrategyLike(Optional.ofNullable(this.buildAlertmanagerConfigMatcherStrategy()).orElse(null));
  }
  
  public AlertmanagerConfigNamespaceSelectorNested<A> editAlertmanagerConfigNamespaceSelector() {
    return this.withNewAlertmanagerConfigNamespaceSelectorLike(Optional.ofNullable(this.buildAlertmanagerConfigNamespaceSelector()).orElse(null));
  }
  
  public AlertmanagerConfigSelectorNested<A> editAlertmanagerConfigSelector() {
    return this.withNewAlertmanagerConfigSelectorLike(Optional.ofNullable(this.buildAlertmanagerConfigSelector()).orElse(null));
  }
  
  public AlertmanagerConfigurationNested<A> editAlertmanagerConfiguration() {
    return this.withNewAlertmanagerConfigurationLike(Optional.ofNullable(this.buildAlertmanagerConfiguration()).orElse(null));
  }
  
  public ClusterTLSNested<A> editClusterTLS() {
    return this.withNewClusterTLSLike(Optional.ofNullable(this.buildClusterTLS()).orElse(null));
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
  
  public LimitsNested<A> editLimits() {
    return this.withNewLimitsLike(Optional.ofNullable(this.buildLimits()).orElse(null));
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
  
  public AlertmanagerConfigMatcherStrategyNested<A> editOrNewAlertmanagerConfigMatcherStrategy() {
    return this.withNewAlertmanagerConfigMatcherStrategyLike(Optional.ofNullable(this.buildAlertmanagerConfigMatcherStrategy()).orElse(new AlertmanagerConfigMatcherStrategyBuilder().build()));
  }
  
  public AlertmanagerConfigMatcherStrategyNested<A> editOrNewAlertmanagerConfigMatcherStrategyLike(AlertmanagerConfigMatcherStrategy item) {
    return this.withNewAlertmanagerConfigMatcherStrategyLike(Optional.ofNullable(this.buildAlertmanagerConfigMatcherStrategy()).orElse(item));
  }
  
  public AlertmanagerConfigNamespaceSelectorNested<A> editOrNewAlertmanagerConfigNamespaceSelector() {
    return this.withNewAlertmanagerConfigNamespaceSelectorLike(Optional.ofNullable(this.buildAlertmanagerConfigNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public AlertmanagerConfigNamespaceSelectorNested<A> editOrNewAlertmanagerConfigNamespaceSelectorLike(LabelSelector item) {
    return this.withNewAlertmanagerConfigNamespaceSelectorLike(Optional.ofNullable(this.buildAlertmanagerConfigNamespaceSelector()).orElse(item));
  }
  
  public AlertmanagerConfigSelectorNested<A> editOrNewAlertmanagerConfigSelector() {
    return this.withNewAlertmanagerConfigSelectorLike(Optional.ofNullable(this.buildAlertmanagerConfigSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public AlertmanagerConfigSelectorNested<A> editOrNewAlertmanagerConfigSelectorLike(LabelSelector item) {
    return this.withNewAlertmanagerConfigSelectorLike(Optional.ofNullable(this.buildAlertmanagerConfigSelector()).orElse(item));
  }
  
  public AlertmanagerConfigurationNested<A> editOrNewAlertmanagerConfiguration() {
    return this.withNewAlertmanagerConfigurationLike(Optional.ofNullable(this.buildAlertmanagerConfiguration()).orElse(new AlertmanagerConfigurationBuilder().build()));
  }
  
  public AlertmanagerConfigurationNested<A> editOrNewAlertmanagerConfigurationLike(AlertmanagerConfiguration item) {
    return this.withNewAlertmanagerConfigurationLike(Optional.ofNullable(this.buildAlertmanagerConfiguration()).orElse(item));
  }
  
  public ClusterTLSNested<A> editOrNewClusterTLS() {
    return this.withNewClusterTLSLike(Optional.ofNullable(this.buildClusterTLS()).orElse(new ClusterTLSConfigBuilder().build()));
  }
  
  public ClusterTLSNested<A> editOrNewClusterTLSLike(ClusterTLSConfig item) {
    return this.withNewClusterTLSLike(Optional.ofNullable(this.buildClusterTLS()).orElse(item));
  }
  
  public DnsConfigNested<A> editOrNewDnsConfig() {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(new PodDNSConfigBuilder().build()));
  }
  
  public DnsConfigNested<A> editOrNewDnsConfigLike(PodDNSConfig item) {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(item));
  }
  
  public LimitsNested<A> editOrNewLimits() {
    return this.withNewLimitsLike(Optional.ofNullable(this.buildLimits()).orElse(new AlertmanagerLimitsSpecBuilder().build()));
  }
  
  public LimitsNested<A> editOrNewLimitsLike(AlertmanagerLimitsSpec item) {
    return this.withNewLimitsLike(Optional.ofNullable(this.buildLimits()).orElse(item));
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
    return this.withNewWebLike(Optional.ofNullable(this.buildWeb()).orElse(new AlertmanagerWebSpecBuilder().build()));
  }
  
  public WebNested<A> editOrNewWebLike(AlertmanagerWebSpec item) {
    return this.withNewWebLike(Optional.ofNullable(this.buildWeb()).orElse(item));
  }
  
  public PodMetadataNested<A> editPodMetadata() {
    return this.withNewPodMetadataLike(Optional.ofNullable(this.buildPodMetadata()).orElse(null));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
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
    AlertmanagerSpecFluent that = (AlertmanagerSpecFluent) o;
    if (!(Objects.equals(additionalArgs, that.additionalArgs))) {
      return false;
    }
    if (!(Objects.equals(additionalPeers, that.additionalPeers))) {
      return false;
    }
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(alertmanagerConfigMatcherStrategy, that.alertmanagerConfigMatcherStrategy))) {
      return false;
    }
    if (!(Objects.equals(alertmanagerConfigNamespaceSelector, that.alertmanagerConfigNamespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(alertmanagerConfigSelector, that.alertmanagerConfigSelector))) {
      return false;
    }
    if (!(Objects.equals(alertmanagerConfiguration, that.alertmanagerConfiguration))) {
      return false;
    }
    if (!(Objects.equals(automountServiceAccountToken, that.automountServiceAccountToken))) {
      return false;
    }
    if (!(Objects.equals(baseImage, that.baseImage))) {
      return false;
    }
    if (!(Objects.equals(clusterAdvertiseAddress, that.clusterAdvertiseAddress))) {
      return false;
    }
    if (!(Objects.equals(clusterGossipInterval, that.clusterGossipInterval))) {
      return false;
    }
    if (!(Objects.equals(clusterLabel, that.clusterLabel))) {
      return false;
    }
    if (!(Objects.equals(clusterPeerTimeout, that.clusterPeerTimeout))) {
      return false;
    }
    if (!(Objects.equals(clusterPushpullInterval, that.clusterPushpullInterval))) {
      return false;
    }
    if (!(Objects.equals(clusterTLS, that.clusterTLS))) {
      return false;
    }
    if (!(Objects.equals(configMaps, that.configMaps))) {
      return false;
    }
    if (!(Objects.equals(configSecret, that.configSecret))) {
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
    if (!(Objects.equals(externalUrl, that.externalUrl))) {
      return false;
    }
    if (!(Objects.equals(forceEnableClusterMode, that.forceEnableClusterMode))) {
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
    if (!(Objects.equals(limits, that.limits))) {
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
    if (!(Objects.equals(portName, that.portName))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
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
    if (!(Objects.equals(routePrefix, that.routePrefix))) {
      return false;
    }
    if (!(Objects.equals(schedulerName, that.schedulerName))) {
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
    if (!(Objects.equals(serviceName, that.serviceName))) {
      return false;
    }
    if (!(Objects.equals(sha, that.sha))) {
      return false;
    }
    if (!(Objects.equals(storage, that.storage))) {
      return false;
    }
    if (!(Objects.equals(tag, that.tag))) {
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
  
  public String getAdditionalPeer(int index) {
    return this.additionalPeers.get(index);
  }
  
  public List<String> getAdditionalPeers() {
    return this.additionalPeers;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Affinity getAffinity() {
    return this.affinity;
  }
  
  public Boolean getAutomountServiceAccountToken() {
    return this.automountServiceAccountToken;
  }
  
  public String getBaseImage() {
    return this.baseImage;
  }
  
  public String getClusterAdvertiseAddress() {
    return this.clusterAdvertiseAddress;
  }
  
  public String getClusterGossipInterval() {
    return this.clusterGossipInterval;
  }
  
  public String getClusterLabel() {
    return this.clusterLabel;
  }
  
  public String getClusterPeerTimeout() {
    return this.clusterPeerTimeout;
  }
  
  public String getClusterPushpullInterval() {
    return this.clusterPushpullInterval;
  }
  
  public String getConfigMap(int index) {
    return this.configMaps.get(index);
  }
  
  public List<String> getConfigMaps() {
    return this.configMaps;
  }
  
  public String getConfigSecret() {
    return this.configSecret;
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
  
  public String getExternalUrl() {
    return this.externalUrl;
  }
  
  public String getFirstAdditionalPeer() {
    return this.additionalPeers.get(0);
  }
  
  public String getFirstConfigMap() {
    return this.configMaps.get(0);
  }
  
  public String getFirstEnableFeature() {
    return this.enableFeatures.get(0);
  }
  
  public String getFirstSecret() {
    return this.secrets.get(0);
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public TopologySpreadConstraint getFirstTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(0);
  }
  
  public Boolean getForceEnableClusterMode() {
    return this.forceEnableClusterMode;
  }
  
  public Boolean getHostNetwork() {
    return this.hostNetwork;
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
  
  public String getLastAdditionalPeer() {
    return this.additionalPeers.get(additionalPeers.size() - 1);
  }
  
  public String getLastConfigMap() {
    return this.configMaps.get(configMaps.size() - 1);
  }
  
  public String getLastEnableFeature() {
    return this.enableFeatures.get(enableFeatures.size() - 1);
  }
  
  public String getLastSecret() {
    return this.secrets.get(secrets.size() - 1);
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
  
  public String getMatchingAdditionalPeer(Predicate<String> predicate) {
      for (String item : additionalPeers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
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
  
  public Boolean getPaused() {
    return this.paused;
  }
  
  public StatefulSetPersistentVolumeClaimRetentionPolicy getPersistentVolumeClaimRetentionPolicy() {
    return this.persistentVolumeClaimRetentionPolicy;
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
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getRetention() {
    return this.retention;
  }
  
  public String getRoutePrefix() {
    return this.routePrefix;
  }
  
  public String getSchedulerName() {
    return this.schedulerName;
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
  
  public String getServiceName() {
    return this.serviceName;
  }
  
  public String getSha() {
    return this.sha;
  }
  
  public String getTag() {
    return this.tag;
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
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalArgs() {
    return this.additionalArgs != null && !(this.additionalArgs.isEmpty());
  }
  
  public boolean hasAdditionalPeers() {
    return this.additionalPeers != null && !(this.additionalPeers.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasAlertmanagerConfigMatcherStrategy() {
    return this.alertmanagerConfigMatcherStrategy != null;
  }
  
  public boolean hasAlertmanagerConfigNamespaceSelector() {
    return this.alertmanagerConfigNamespaceSelector != null;
  }
  
  public boolean hasAlertmanagerConfigSelector() {
    return this.alertmanagerConfigSelector != null;
  }
  
  public boolean hasAlertmanagerConfiguration() {
    return this.alertmanagerConfiguration != null;
  }
  
  public boolean hasAutomountServiceAccountToken() {
    return this.automountServiceAccountToken != null;
  }
  
  public boolean hasBaseImage() {
    return this.baseImage != null;
  }
  
  public boolean hasClusterAdvertiseAddress() {
    return this.clusterAdvertiseAddress != null;
  }
  
  public boolean hasClusterGossipInterval() {
    return this.clusterGossipInterval != null;
  }
  
  public boolean hasClusterLabel() {
    return this.clusterLabel != null;
  }
  
  public boolean hasClusterPeerTimeout() {
    return this.clusterPeerTimeout != null;
  }
  
  public boolean hasClusterPushpullInterval() {
    return this.clusterPushpullInterval != null;
  }
  
  public boolean hasClusterTLS() {
    return this.clusterTLS != null;
  }
  
  public boolean hasConfigMaps() {
    return this.configMaps != null && !(this.configMaps.isEmpty());
  }
  
  public boolean hasConfigSecret() {
    return this.configSecret != null;
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
  
  public boolean hasExternalUrl() {
    return this.externalUrl != null;
  }
  
  public boolean hasForceEnableClusterMode() {
    return this.forceEnableClusterMode != null;
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
  
  public boolean hasLimits() {
    return this.limits != null;
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
  
  public boolean hasMatchingAdditionalPeer(Predicate<String> predicate) {
      for (String item : additionalPeers) {
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
  
  public boolean hasPortName() {
    return this.portName != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
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
  
  public boolean hasRoutePrefix() {
    return this.routePrefix != null;
  }
  
  public boolean hasSchedulerName() {
    return this.schedulerName != null;
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
  
  public boolean hasServiceName() {
    return this.serviceName != null;
  }
  
  public boolean hasSha() {
    return this.sha != null;
  }
  
  public boolean hasStorage() {
    return this.storage != null;
  }
  
  public boolean hasTag() {
    return this.tag != null;
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
    return Objects.hash(additionalArgs, additionalPeers, affinity, alertmanagerConfigMatcherStrategy, alertmanagerConfigNamespaceSelector, alertmanagerConfigSelector, alertmanagerConfiguration, automountServiceAccountToken, baseImage, clusterAdvertiseAddress, clusterGossipInterval, clusterLabel, clusterPeerTimeout, clusterPushpullInterval, clusterTLS, configMaps, configSecret, containers, dnsConfig, dnsPolicy, enableFeatures, enableServiceLinks, externalUrl, forceEnableClusterMode, hostAliases, hostNetwork, hostUsers, image, imagePullPolicy, imagePullSecrets, initContainers, limits, listenLocal, logFormat, logLevel, minReadySeconds, nodeSelector, paused, persistentVolumeClaimRetentionPolicy, podManagementPolicy, podMetadata, portName, priorityClassName, replicas, resources, retention, routePrefix, schedulerName, secrets, securityContext, serviceAccountName, serviceName, sha, storage, tag, terminationGracePeriodSeconds, tolerations, topologySpreadConstraints, updateStrategy, version, volumeMounts, volumes, web, additionalProperties);
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
  
  public A removeAllFromAdditionalPeers(Collection<String> items) {
    if (this.additionalPeers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalPeers.remove(item);
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
  
  public A removeFromAdditionalPeers(String... items) {
    if (this.additionalPeers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.additionalPeers.remove(item);
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
  
  public HostAliasesNested<A> setNewHostAliasLike(int index,HostAlias item) {
    return new HostAliasesNested(index, item);
  }
  
  public ImagePullSecretsNested<A> setNewImagePullSecretLike(int index,LocalObjectReference item) {
    return new ImagePullSecretsNested(index, item);
  }
  
  public InitContainersNested<A> setNewInitContainerLike(int index,Container item) {
    return new InitContainersNested(index, item);
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
  
  public A setToAdditionalPeers(int index,String item) {
    if (this.additionalPeers == null) {
      this.additionalPeers = new ArrayList();
    }
    this.additionalPeers.set(index, item);
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
    if (!(additionalPeers == null) && !(additionalPeers.isEmpty())) {
        sb.append("additionalPeers:");
        sb.append(additionalPeers);
        sb.append(",");
    }
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(alertmanagerConfigMatcherStrategy == null)) {
        sb.append("alertmanagerConfigMatcherStrategy:");
        sb.append(alertmanagerConfigMatcherStrategy);
        sb.append(",");
    }
    if (!(alertmanagerConfigNamespaceSelector == null)) {
        sb.append("alertmanagerConfigNamespaceSelector:");
        sb.append(alertmanagerConfigNamespaceSelector);
        sb.append(",");
    }
    if (!(alertmanagerConfigSelector == null)) {
        sb.append("alertmanagerConfigSelector:");
        sb.append(alertmanagerConfigSelector);
        sb.append(",");
    }
    if (!(alertmanagerConfiguration == null)) {
        sb.append("alertmanagerConfiguration:");
        sb.append(alertmanagerConfiguration);
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
    if (!(clusterAdvertiseAddress == null)) {
        sb.append("clusterAdvertiseAddress:");
        sb.append(clusterAdvertiseAddress);
        sb.append(",");
    }
    if (!(clusterGossipInterval == null)) {
        sb.append("clusterGossipInterval:");
        sb.append(clusterGossipInterval);
        sb.append(",");
    }
    if (!(clusterLabel == null)) {
        sb.append("clusterLabel:");
        sb.append(clusterLabel);
        sb.append(",");
    }
    if (!(clusterPeerTimeout == null)) {
        sb.append("clusterPeerTimeout:");
        sb.append(clusterPeerTimeout);
        sb.append(",");
    }
    if (!(clusterPushpullInterval == null)) {
        sb.append("clusterPushpullInterval:");
        sb.append(clusterPushpullInterval);
        sb.append(",");
    }
    if (!(clusterTLS == null)) {
        sb.append("clusterTLS:");
        sb.append(clusterTLS);
        sb.append(",");
    }
    if (!(configMaps == null) && !(configMaps.isEmpty())) {
        sb.append("configMaps:");
        sb.append(configMaps);
        sb.append(",");
    }
    if (!(configSecret == null)) {
        sb.append("configSecret:");
        sb.append(configSecret);
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
    if (!(externalUrl == null)) {
        sb.append("externalUrl:");
        sb.append(externalUrl);
        sb.append(",");
    }
    if (!(forceEnableClusterMode == null)) {
        sb.append("forceEnableClusterMode:");
        sb.append(forceEnableClusterMode);
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
    if (!(limits == null)) {
        sb.append("limits:");
        sb.append(limits);
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
    if (!(routePrefix == null)) {
        sb.append("routePrefix:");
        sb.append(routePrefix);
        sb.append(",");
    }
    if (!(schedulerName == null)) {
        sb.append("schedulerName:");
        sb.append(schedulerName);
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
  
  public A withAdditionalPeers(List<String> additionalPeers) {
    if (additionalPeers != null) {
        this.additionalPeers = new ArrayList();
        for (String item : additionalPeers) {
          this.addToAdditionalPeers(item);
        }
    } else {
      this.additionalPeers = null;
    }
    return (A) this;
  }
  
  public A withAdditionalPeers(String... additionalPeers) {
    if (this.additionalPeers != null) {
        this.additionalPeers.clear();
        _visitables.remove("additionalPeers");
    }
    if (additionalPeers != null) {
      for (String item : additionalPeers) {
        this.addToAdditionalPeers(item);
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
  
  public A withAlertmanagerConfigMatcherStrategy(AlertmanagerConfigMatcherStrategy alertmanagerConfigMatcherStrategy) {
    this._visitables.remove("alertmanagerConfigMatcherStrategy");
    if (alertmanagerConfigMatcherStrategy != null) {
        this.alertmanagerConfigMatcherStrategy = new AlertmanagerConfigMatcherStrategyBuilder(alertmanagerConfigMatcherStrategy);
        this._visitables.get("alertmanagerConfigMatcherStrategy").add(this.alertmanagerConfigMatcherStrategy);
    } else {
        this.alertmanagerConfigMatcherStrategy = null;
        this._visitables.get("alertmanagerConfigMatcherStrategy").remove(this.alertmanagerConfigMatcherStrategy);
    }
    return (A) this;
  }
  
  public A withAlertmanagerConfigNamespaceSelector(LabelSelector alertmanagerConfigNamespaceSelector) {
    this._visitables.remove("alertmanagerConfigNamespaceSelector");
    if (alertmanagerConfigNamespaceSelector != null) {
        this.alertmanagerConfigNamespaceSelector = new LabelSelectorBuilder(alertmanagerConfigNamespaceSelector);
        this._visitables.get("alertmanagerConfigNamespaceSelector").add(this.alertmanagerConfigNamespaceSelector);
    } else {
        this.alertmanagerConfigNamespaceSelector = null;
        this._visitables.get("alertmanagerConfigNamespaceSelector").remove(this.alertmanagerConfigNamespaceSelector);
    }
    return (A) this;
  }
  
  public A withAlertmanagerConfigSelector(LabelSelector alertmanagerConfigSelector) {
    this._visitables.remove("alertmanagerConfigSelector");
    if (alertmanagerConfigSelector != null) {
        this.alertmanagerConfigSelector = new LabelSelectorBuilder(alertmanagerConfigSelector);
        this._visitables.get("alertmanagerConfigSelector").add(this.alertmanagerConfigSelector);
    } else {
        this.alertmanagerConfigSelector = null;
        this._visitables.get("alertmanagerConfigSelector").remove(this.alertmanagerConfigSelector);
    }
    return (A) this;
  }
  
  public A withAlertmanagerConfiguration(AlertmanagerConfiguration alertmanagerConfiguration) {
    this._visitables.remove("alertmanagerConfiguration");
    if (alertmanagerConfiguration != null) {
        this.alertmanagerConfiguration = new AlertmanagerConfigurationBuilder(alertmanagerConfiguration);
        this._visitables.get("alertmanagerConfiguration").add(this.alertmanagerConfiguration);
    } else {
        this.alertmanagerConfiguration = null;
        this._visitables.get("alertmanagerConfiguration").remove(this.alertmanagerConfiguration);
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
  
  public A withClusterAdvertiseAddress(String clusterAdvertiseAddress) {
    this.clusterAdvertiseAddress = clusterAdvertiseAddress;
    return (A) this;
  }
  
  public A withClusterGossipInterval(String clusterGossipInterval) {
    this.clusterGossipInterval = clusterGossipInterval;
    return (A) this;
  }
  
  public A withClusterLabel(String clusterLabel) {
    this.clusterLabel = clusterLabel;
    return (A) this;
  }
  
  public A withClusterPeerTimeout(String clusterPeerTimeout) {
    this.clusterPeerTimeout = clusterPeerTimeout;
    return (A) this;
  }
  
  public A withClusterPushpullInterval(String clusterPushpullInterval) {
    this.clusterPushpullInterval = clusterPushpullInterval;
    return (A) this;
  }
  
  public A withClusterTLS(ClusterTLSConfig clusterTLS) {
    this._visitables.remove("clusterTLS");
    if (clusterTLS != null) {
        this.clusterTLS = new ClusterTLSConfigBuilder(clusterTLS);
        this._visitables.get("clusterTLS").add(this.clusterTLS);
    } else {
        this.clusterTLS = null;
        this._visitables.get("clusterTLS").remove(this.clusterTLS);
    }
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
  
  public A withConfigSecret(String configSecret) {
    this.configSecret = configSecret;
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
  
  public A withExternalUrl(String externalUrl) {
    this.externalUrl = externalUrl;
    return (A) this;
  }
  
  public A withForceEnableClusterMode() {
    return withForceEnableClusterMode(true);
  }
  
  public A withForceEnableClusterMode(Boolean forceEnableClusterMode) {
    this.forceEnableClusterMode = forceEnableClusterMode;
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
  
  public A withLimits(AlertmanagerLimitsSpec limits) {
    this._visitables.remove("limits");
    if (limits != null) {
        this.limits = new AlertmanagerLimitsSpecBuilder(limits);
        this._visitables.get("limits").add(this.limits);
    } else {
        this.limits = null;
        this._visitables.get("limits").remove(this.limits);
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
  
  public AlertmanagerConfigMatcherStrategyNested<A> withNewAlertmanagerConfigMatcherStrategy() {
    return new AlertmanagerConfigMatcherStrategyNested(null);
  }
  
  public A withNewAlertmanagerConfigMatcherStrategy(String type) {
    return (A) this.withAlertmanagerConfigMatcherStrategy(new AlertmanagerConfigMatcherStrategy(type));
  }
  
  public AlertmanagerConfigMatcherStrategyNested<A> withNewAlertmanagerConfigMatcherStrategyLike(AlertmanagerConfigMatcherStrategy item) {
    return new AlertmanagerConfigMatcherStrategyNested(item);
  }
  
  public AlertmanagerConfigNamespaceSelectorNested<A> withNewAlertmanagerConfigNamespaceSelector() {
    return new AlertmanagerConfigNamespaceSelectorNested(null);
  }
  
  public AlertmanagerConfigNamespaceSelectorNested<A> withNewAlertmanagerConfigNamespaceSelectorLike(LabelSelector item) {
    return new AlertmanagerConfigNamespaceSelectorNested(item);
  }
  
  public AlertmanagerConfigSelectorNested<A> withNewAlertmanagerConfigSelector() {
    return new AlertmanagerConfigSelectorNested(null);
  }
  
  public AlertmanagerConfigSelectorNested<A> withNewAlertmanagerConfigSelectorLike(LabelSelector item) {
    return new AlertmanagerConfigSelectorNested(item);
  }
  
  public AlertmanagerConfigurationNested<A> withNewAlertmanagerConfiguration() {
    return new AlertmanagerConfigurationNested(null);
  }
  
  public AlertmanagerConfigurationNested<A> withNewAlertmanagerConfigurationLike(AlertmanagerConfiguration item) {
    return new AlertmanagerConfigurationNested(item);
  }
  
  public ClusterTLSNested<A> withNewClusterTLS() {
    return new ClusterTLSNested(null);
  }
  
  public ClusterTLSNested<A> withNewClusterTLSLike(ClusterTLSConfig item) {
    return new ClusterTLSNested(item);
  }
  
  public DnsConfigNested<A> withNewDnsConfig() {
    return new DnsConfigNested(null);
  }
  
  public DnsConfigNested<A> withNewDnsConfigLike(PodDNSConfig item) {
    return new DnsConfigNested(item);
  }
  
  public LimitsNested<A> withNewLimits() {
    return new LimitsNested(null);
  }
  
  public A withNewLimits(String maxPerSilenceBytes,Integer maxSilences) {
    return (A) this.withLimits(new AlertmanagerLimitsSpec(maxPerSilenceBytes, maxSilences));
  }
  
  public LimitsNested<A> withNewLimitsLike(AlertmanagerLimitsSpec item) {
    return new LimitsNested(item);
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
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public StorageNested<A> withNewStorage() {
    return new StorageNested(null);
  }
  
  public StorageNested<A> withNewStorageLike(StorageSpec item) {
    return new StorageNested(item);
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
  
  public WebNested<A> withNewWebLike(AlertmanagerWebSpec item) {
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
  
  public A withPortName(String portName) {
    this.portName = portName;
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
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
  
  public A withRoutePrefix(String routePrefix) {
    this.routePrefix = routePrefix;
    return (A) this;
  }
  
  public A withSchedulerName(String schedulerName) {
    this.schedulerName = schedulerName;
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
  
  public A withServiceName(String serviceName) {
    this.serviceName = serviceName;
    return (A) this;
  }
  
  public A withSha(String sha) {
    this.sha = sha;
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
  
  public A withWeb(AlertmanagerWebSpec web) {
    this._visitables.remove("web");
    if (web != null) {
        this.web = new AlertmanagerWebSpecBuilder(web);
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
      return (N) AlertmanagerSpecFluent.this.setToAdditionalArgs(index, builder.build());
    }
    
    public N endAdditionalArg() {
      return and();
    }
    
  }
  public class AlertmanagerConfigMatcherStrategyNested<N> extends AlertmanagerConfigMatcherStrategyFluent<AlertmanagerConfigMatcherStrategyNested<N>> implements Nested<N>{
  
    AlertmanagerConfigMatcherStrategyBuilder builder;
  
    AlertmanagerConfigMatcherStrategyNested(AlertmanagerConfigMatcherStrategy item) {
      this.builder = new AlertmanagerConfigMatcherStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withAlertmanagerConfigMatcherStrategy(builder.build());
    }
    
    public N endAlertmanagerConfigMatcherStrategy() {
      return and();
    }
    
  }
  public class AlertmanagerConfigNamespaceSelectorNested<N> extends LabelSelectorFluent<AlertmanagerConfigNamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    AlertmanagerConfigNamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withAlertmanagerConfigNamespaceSelector(builder.build());
    }
    
    public N endAlertmanagerConfigNamespaceSelector() {
      return and();
    }
    
  }
  public class AlertmanagerConfigSelectorNested<N> extends LabelSelectorFluent<AlertmanagerConfigSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    AlertmanagerConfigSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withAlertmanagerConfigSelector(builder.build());
    }
    
    public N endAlertmanagerConfigSelector() {
      return and();
    }
    
  }
  public class AlertmanagerConfigurationNested<N> extends AlertmanagerConfigurationFluent<AlertmanagerConfigurationNested<N>> implements Nested<N>{
  
    AlertmanagerConfigurationBuilder builder;
  
    AlertmanagerConfigurationNested(AlertmanagerConfiguration item) {
      this.builder = new AlertmanagerConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withAlertmanagerConfiguration(builder.build());
    }
    
    public N endAlertmanagerConfiguration() {
      return and();
    }
    
  }
  public class ClusterTLSNested<N> extends ClusterTLSConfigFluent<ClusterTLSNested<N>> implements Nested<N>{
  
    ClusterTLSConfigBuilder builder;
  
    ClusterTLSNested(ClusterTLSConfig item) {
      this.builder = new ClusterTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withClusterTLS(builder.build());
    }
    
    public N endClusterTLS() {
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
      return (N) AlertmanagerSpecFluent.this.setToContainers(index, builder.build());
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
      return (N) AlertmanagerSpecFluent.this.withDnsConfig(builder.build());
    }
    
    public N endDnsConfig() {
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
      return (N) AlertmanagerSpecFluent.this.setToHostAliases(index, builder.build());
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
      return (N) AlertmanagerSpecFluent.this.setToImagePullSecrets(index, builder.build());
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
      return (N) AlertmanagerSpecFluent.this.setToInitContainers(index, builder.build());
    }
    
    public N endInitContainer() {
      return and();
    }
    
  }
  public class LimitsNested<N> extends AlertmanagerLimitsSpecFluent<LimitsNested<N>> implements Nested<N>{
  
    AlertmanagerLimitsSpecBuilder builder;
  
    LimitsNested(AlertmanagerLimitsSpec item) {
      this.builder = new AlertmanagerLimitsSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withLimits(builder.build());
    }
    
    public N endLimits() {
      return and();
    }
    
  }
  public class PodMetadataNested<N> extends EmbeddedObjectMetadataFluent<PodMetadataNested<N>> implements Nested<N>{
  
    EmbeddedObjectMetadataBuilder builder;
  
    PodMetadataNested(EmbeddedObjectMetadata item) {
      this.builder = new EmbeddedObjectMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withPodMetadata(builder.build());
    }
    
    public N endPodMetadata() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class StorageNested<N> extends StorageSpecFluent<StorageNested<N>> implements Nested<N>{
  
    StorageSpecBuilder builder;
  
    StorageNested(StorageSpec item) {
      this.builder = new StorageSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withStorage(builder.build());
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
      return (N) AlertmanagerSpecFluent.this.withUpdateStrategy(builder.build());
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
      return (N) AlertmanagerSpecFluent.this.setToVolumeMounts(index, builder.build());
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
      return (N) AlertmanagerSpecFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
  public class WebNested<N> extends AlertmanagerWebSpecFluent<WebNested<N>> implements Nested<N>{
  
    AlertmanagerWebSpecBuilder builder;
  
    WebNested(AlertmanagerWebSpec item) {
      this.builder = new AlertmanagerWebSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) AlertmanagerSpecFluent.this.withWeb(builder.build());
    }
    
    public N endWeb() {
      return and();
    }
    
  }
}