package io.fabric8.knative.serving.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerFluent;
import io.fabric8.kubernetes.api.model.EphemeralContainer;
import io.fabric8.kubernetes.api.model.HostAlias;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.PodDNSConfig;
import io.fabric8.kubernetes.api.model.PodOS;
import io.fabric8.kubernetes.api.model.PodReadinessGate;
import io.fabric8.kubernetes.api.model.PodResourceClaim;
import io.fabric8.kubernetes.api.model.PodSchedulingGate;
import io.fabric8.kubernetes.api.model.PodSecurityContext;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirementsFluent;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeFluent;
import io.fabric8.kubernetes.api.model.WorkloadReference;
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
public class RevisionSpecFluent<A extends io.fabric8.knative.serving.v1.RevisionSpecFluent<A>> extends BaseFluent<A>{

  private Long activeDeadlineSeconds;
  private Map<String,Object> additionalProperties;
  private Affinity affinity;
  private Boolean automountServiceAccountToken;
  private Long containerConcurrency;
  private ArrayList<ContainerBuilder> containers = new ArrayList<ContainerBuilder>();
  private PodDNSConfig dnsConfig;
  private String dnsPolicy;
  private Boolean enableServiceLinks;
  private List<EphemeralContainer> ephemeralContainers = new ArrayList<EphemeralContainer>();
  private List<HostAlias> hostAliases = new ArrayList<HostAlias>();
  private Boolean hostIPC;
  private Boolean hostNetwork;
  private Boolean hostPID;
  private Boolean hostUsers;
  private String hostname;
  private String hostnameOverride;
  private Long idleTimeoutSeconds;
  private ArrayList<LocalObjectReferenceBuilder> imagePullSecrets = new ArrayList<LocalObjectReferenceBuilder>();
  private ArrayList<ContainerBuilder> initContainers = new ArrayList<ContainerBuilder>();
  private String nodeName;
  private Map<String,String> nodeSelector;
  private PodOS os;
  private Map<String,Quantity> overhead;
  private String preemptionPolicy;
  private Integer priority;
  private String priorityClassName;
  private List<PodReadinessGate> readinessGates = new ArrayList<PodReadinessGate>();
  private List<PodResourceClaim> resourceClaims = new ArrayList<PodResourceClaim>();
  private ResourceRequirementsBuilder resources;
  private Long responseStartTimeoutSeconds;
  private String restartPolicy;
  private String runtimeClassName;
  private String schedulerName;
  private List<PodSchedulingGate> schedulingGates = new ArrayList<PodSchedulingGate>();
  private PodSecurityContext securityContext;
  private String serviceAccount;
  private String serviceAccountName;
  private Boolean setHostnameAsFQDN;
  private Boolean shareProcessNamespace;
  private String subdomain;
  private Long terminationGracePeriodSeconds;
  private Long timeoutSeconds;
  private List<Toleration> tolerations = new ArrayList<Toleration>();
  private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();
  private WorkloadReference workloadRef;

  public RevisionSpecFluent() {
  }
  
  public RevisionSpecFluent(RevisionSpec instance) {
    this.copyInstance(instance);
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
  
  public A addAllToEphemeralContainers(Collection<EphemeralContainer> items) {
    if (this.ephemeralContainers == null) {
      this.ephemeralContainers = new ArrayList();
    }
    for (EphemeralContainer item : items) {
      this.ephemeralContainers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToHostAliases(Collection<HostAlias> items) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    for (HostAlias item : items) {
      this.hostAliases.add(item);
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
  
  public A addAllToReadinessGates(Collection<PodReadinessGate> items) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    for (PodReadinessGate item : items) {
      this.readinessGates.add(item);
    }
    return (A) this;
  }
  
  public A addAllToResourceClaims(Collection<PodResourceClaim> items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (PodResourceClaim item : items) {
      this.resourceClaims.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSchedulingGates(Collection<PodSchedulingGate> items) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    for (PodSchedulingGate item : items) {
      this.schedulingGates.add(item);
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
  
  public ContainersNested<A> addNewContainer() {
    return new ContainersNested(-1, null);
  }
  
  public ContainersNested<A> addNewContainerLike(Container item) {
    return new ContainersNested(-1, item);
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
  
  public A addNewReadinessGate(String conditionType) {
    return (A) this.addToReadinessGates(new PodReadinessGate(conditionType));
  }
  
  public A addNewResourceClaim(String name,String resourceClaimName,String resourceClaimTemplateName) {
    return (A) this.addToResourceClaims(new PodResourceClaim(name, resourceClaimName, resourceClaimTemplateName));
  }
  
  public A addNewSchedulingGate(String name) {
    return (A) this.addToSchedulingGates(new PodSchedulingGate(name));
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
  
  public A addToEphemeralContainers(EphemeralContainer... items) {
    if (this.ephemeralContainers == null) {
      this.ephemeralContainers = new ArrayList();
    }
    for (EphemeralContainer item : items) {
      this.ephemeralContainers.add(item);
    }
    return (A) this;
  }
  
  public A addToEphemeralContainers(int index,EphemeralContainer item) {
    if (this.ephemeralContainers == null) {
      this.ephemeralContainers = new ArrayList();
    }
    this.ephemeralContainers.add(index, item);
    return (A) this;
  }
  
  public A addToHostAliases(HostAlias... items) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    for (HostAlias item : items) {
      this.hostAliases.add(item);
    }
    return (A) this;
  }
  
  public A addToHostAliases(int index,HostAlias item) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    this.hostAliases.add(index, item);
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
  
  public A addToOverhead(Map<String,Quantity> map) {
    if (this.overhead == null && map != null) {
      this.overhead = new LinkedHashMap();
    }
    if (map != null) {
      this.overhead.putAll(map);
    }
    return (A) this;
  }
  
  public A addToOverhead(String key,Quantity value) {
    if (this.overhead == null && key != null && value != null) {
      this.overhead = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.overhead.put(key, value);
    }
    return (A) this;
  }
  
  public A addToReadinessGates(PodReadinessGate... items) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    for (PodReadinessGate item : items) {
      this.readinessGates.add(item);
    }
    return (A) this;
  }
  
  public A addToReadinessGates(int index,PodReadinessGate item) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    this.readinessGates.add(index, item);
    return (A) this;
  }
  
  public A addToResourceClaims(PodResourceClaim... items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (PodResourceClaim item : items) {
      this.resourceClaims.add(item);
    }
    return (A) this;
  }
  
  public A addToResourceClaims(int index,PodResourceClaim item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    this.resourceClaims.add(index, item);
    return (A) this;
  }
  
  public A addToSchedulingGates(PodSchedulingGate... items) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    for (PodSchedulingGate item : items) {
      this.schedulingGates.add(item);
    }
    return (A) this;
  }
  
  public A addToSchedulingGates(int index,PodSchedulingGate item) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    this.schedulingGates.add(index, item);
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
  
  public Container buildContainer(int index) {
    return this.containers.get(index).build();
  }
  
  public List<Container> buildContainers() {
    return this.containers != null ? build(containers) : null;
  }
  
  public Container buildFirstContainer() {
    return this.containers.get(0).build();
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
  
  public Container buildLastContainer() {
    return this.containers.get(containers.size() - 1).build();
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
  
  public Container buildMatchingContainer(Predicate<ContainerBuilder> predicate) {
      for (ContainerBuilder item : containers) {
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
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public Volume buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public List<Volume> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  protected void copyInstance(RevisionSpec instance) {
    instance = instance != null ? instance : new RevisionSpec();
    if (instance != null) {
        this.withActiveDeadlineSeconds(instance.getActiveDeadlineSeconds());
        this.withAffinity(instance.getAffinity());
        this.withAutomountServiceAccountToken(instance.getAutomountServiceAccountToken());
        this.withContainerConcurrency(instance.getContainerConcurrency());
        this.withContainers(instance.getContainers());
        this.withDnsConfig(instance.getDnsConfig());
        this.withDnsPolicy(instance.getDnsPolicy());
        this.withEnableServiceLinks(instance.getEnableServiceLinks());
        this.withEphemeralContainers(instance.getEphemeralContainers());
        this.withHostAliases(instance.getHostAliases());
        this.withHostIPC(instance.getHostIPC());
        this.withHostNetwork(instance.getHostNetwork());
        this.withHostPID(instance.getHostPID());
        this.withHostUsers(instance.getHostUsers());
        this.withHostname(instance.getHostname());
        this.withHostnameOverride(instance.getHostnameOverride());
        this.withIdleTimeoutSeconds(instance.getIdleTimeoutSeconds());
        this.withImagePullSecrets(instance.getImagePullSecrets());
        this.withInitContainers(instance.getInitContainers());
        this.withNodeName(instance.getNodeName());
        this.withNodeSelector(instance.getNodeSelector());
        this.withOs(instance.getOs());
        this.withOverhead(instance.getOverhead());
        this.withPreemptionPolicy(instance.getPreemptionPolicy());
        this.withPriority(instance.getPriority());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withReadinessGates(instance.getReadinessGates());
        this.withResourceClaims(instance.getResourceClaims());
        this.withResources(instance.getResources());
        this.withResponseStartTimeoutSeconds(instance.getResponseStartTimeoutSeconds());
        this.withRestartPolicy(instance.getRestartPolicy());
        this.withRuntimeClassName(instance.getRuntimeClassName());
        this.withSchedulerName(instance.getSchedulerName());
        this.withSchedulingGates(instance.getSchedulingGates());
        this.withSecurityContext(instance.getSecurityContext());
        this.withServiceAccount(instance.getServiceAccount());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSetHostnameAsFQDN(instance.getSetHostnameAsFQDN());
        this.withShareProcessNamespace(instance.getShareProcessNamespace());
        this.withSubdomain(instance.getSubdomain());
        this.withTerminationGracePeriodSeconds(instance.getTerminationGracePeriodSeconds());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withTolerations(instance.getTolerations());
        this.withTopologySpreadConstraints(instance.getTopologySpreadConstraints());
        this.withVolumes(instance.getVolumes());
        this.withWorkloadRef(instance.getWorkloadRef());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainersNested<A> editContainer(int index) {
    if (containers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public ContainersNested<A> editFirstContainer() {
    if (containers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(0, this.buildContainer(0));
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
  
  public ContainersNested<A> editLastContainer() {
    int index = containers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
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
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public VolumesNested<A> editVolume(int index) {
    if (volumes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "volumes"));
    }
    return this.setNewVolumeLike(index, this.buildVolume(index));
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
    RevisionSpecFluent that = (RevisionSpecFluent) o;
    if (!(Objects.equals(activeDeadlineSeconds, that.activeDeadlineSeconds))) {
      return false;
    }
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(automountServiceAccountToken, that.automountServiceAccountToken))) {
      return false;
    }
    if (!(Objects.equals(containerConcurrency, that.containerConcurrency))) {
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
    if (!(Objects.equals(enableServiceLinks, that.enableServiceLinks))) {
      return false;
    }
    if (!(Objects.equals(ephemeralContainers, that.ephemeralContainers))) {
      return false;
    }
    if (!(Objects.equals(hostAliases, that.hostAliases))) {
      return false;
    }
    if (!(Objects.equals(hostIPC, that.hostIPC))) {
      return false;
    }
    if (!(Objects.equals(hostNetwork, that.hostNetwork))) {
      return false;
    }
    if (!(Objects.equals(hostPID, that.hostPID))) {
      return false;
    }
    if (!(Objects.equals(hostUsers, that.hostUsers))) {
      return false;
    }
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(hostnameOverride, that.hostnameOverride))) {
      return false;
    }
    if (!(Objects.equals(idleTimeoutSeconds, that.idleTimeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(imagePullSecrets, that.imagePullSecrets))) {
      return false;
    }
    if (!(Objects.equals(initContainers, that.initContainers))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(nodeSelector, that.nodeSelector))) {
      return false;
    }
    if (!(Objects.equals(os, that.os))) {
      return false;
    }
    if (!(Objects.equals(overhead, that.overhead))) {
      return false;
    }
    if (!(Objects.equals(preemptionPolicy, that.preemptionPolicy))) {
      return false;
    }
    if (!(Objects.equals(priority, that.priority))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(readinessGates, that.readinessGates))) {
      return false;
    }
    if (!(Objects.equals(resourceClaims, that.resourceClaims))) {
      return false;
    }
    if (!(Objects.equals(resources, that.resources))) {
      return false;
    }
    if (!(Objects.equals(responseStartTimeoutSeconds, that.responseStartTimeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(restartPolicy, that.restartPolicy))) {
      return false;
    }
    if (!(Objects.equals(runtimeClassName, that.runtimeClassName))) {
      return false;
    }
    if (!(Objects.equals(schedulerName, that.schedulerName))) {
      return false;
    }
    if (!(Objects.equals(schedulingGates, that.schedulingGates))) {
      return false;
    }
    if (!(Objects.equals(securityContext, that.securityContext))) {
      return false;
    }
    if (!(Objects.equals(serviceAccount, that.serviceAccount))) {
      return false;
    }
    if (!(Objects.equals(serviceAccountName, that.serviceAccountName))) {
      return false;
    }
    if (!(Objects.equals(setHostnameAsFQDN, that.setHostnameAsFQDN))) {
      return false;
    }
    if (!(Objects.equals(shareProcessNamespace, that.shareProcessNamespace))) {
      return false;
    }
    if (!(Objects.equals(subdomain, that.subdomain))) {
      return false;
    }
    if (!(Objects.equals(terminationGracePeriodSeconds, that.terminationGracePeriodSeconds))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
      return false;
    }
    if (!(Objects.equals(topologySpreadConstraints, that.topologySpreadConstraints))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
      return false;
    }
    if (!(Objects.equals(workloadRef, that.workloadRef))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Long getActiveDeadlineSeconds() {
    return this.activeDeadlineSeconds;
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
  
  public Long getContainerConcurrency() {
    return this.containerConcurrency;
  }
  
  public PodDNSConfig getDnsConfig() {
    return this.dnsConfig;
  }
  
  public String getDnsPolicy() {
    return this.dnsPolicy;
  }
  
  public Boolean getEnableServiceLinks() {
    return this.enableServiceLinks;
  }
  
  public EphemeralContainer getEphemeralContainer(int index) {
    return this.ephemeralContainers.get(index);
  }
  
  public List<EphemeralContainer> getEphemeralContainers() {
    return this.ephemeralContainers;
  }
  
  public EphemeralContainer getFirstEphemeralContainer() {
    return this.ephemeralContainers.get(0);
  }
  
  public HostAlias getFirstHostAlias() {
    return this.hostAliases.get(0);
  }
  
  public PodReadinessGate getFirstReadinessGate() {
    return this.readinessGates.get(0);
  }
  
  public PodResourceClaim getFirstResourceClaim() {
    return this.resourceClaims.get(0);
  }
  
  public PodSchedulingGate getFirstSchedulingGate() {
    return this.schedulingGates.get(0);
  }
  
  public Toleration getFirstToleration() {
    return this.tolerations.get(0);
  }
  
  public TopologySpreadConstraint getFirstTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(0);
  }
  
  public HostAlias getHostAlias(int index) {
    return this.hostAliases.get(index);
  }
  
  public List<HostAlias> getHostAliases() {
    return this.hostAliases;
  }
  
  public Boolean getHostIPC() {
    return this.hostIPC;
  }
  
  public Boolean getHostNetwork() {
    return this.hostNetwork;
  }
  
  public Boolean getHostPID() {
    return this.hostPID;
  }
  
  public Boolean getHostUsers() {
    return this.hostUsers;
  }
  
  public String getHostname() {
    return this.hostname;
  }
  
  public String getHostnameOverride() {
    return this.hostnameOverride;
  }
  
  public Long getIdleTimeoutSeconds() {
    return this.idleTimeoutSeconds;
  }
  
  public EphemeralContainer getLastEphemeralContainer() {
    return this.ephemeralContainers.get(ephemeralContainers.size() - 1);
  }
  
  public HostAlias getLastHostAlias() {
    return this.hostAliases.get(hostAliases.size() - 1);
  }
  
  public PodReadinessGate getLastReadinessGate() {
    return this.readinessGates.get(readinessGates.size() - 1);
  }
  
  public PodResourceClaim getLastResourceClaim() {
    return this.resourceClaims.get(resourceClaims.size() - 1);
  }
  
  public PodSchedulingGate getLastSchedulingGate() {
    return this.schedulingGates.get(schedulingGates.size() - 1);
  }
  
  public Toleration getLastToleration() {
    return this.tolerations.get(tolerations.size() - 1);
  }
  
  public TopologySpreadConstraint getLastTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(topologySpreadConstraints.size() - 1);
  }
  
  public EphemeralContainer getMatchingEphemeralContainer(Predicate<EphemeralContainer> predicate) {
      for (EphemeralContainer item : ephemeralContainers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public HostAlias getMatchingHostAlias(Predicate<HostAlias> predicate) {
      for (HostAlias item : hostAliases) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public PodReadinessGate getMatchingReadinessGate(Predicate<PodReadinessGate> predicate) {
      for (PodReadinessGate item : readinessGates) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public PodResourceClaim getMatchingResourceClaim(Predicate<PodResourceClaim> predicate) {
      for (PodResourceClaim item : resourceClaims) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public PodSchedulingGate getMatchingSchedulingGate(Predicate<PodSchedulingGate> predicate) {
      for (PodSchedulingGate item : schedulingGates) {
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
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
  }
  
  public PodOS getOs() {
    return this.os;
  }
  
  public Map<String,Quantity> getOverhead() {
    return this.overhead;
  }
  
  public String getPreemptionPolicy() {
    return this.preemptionPolicy;
  }
  
  public Integer getPriority() {
    return this.priority;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public PodReadinessGate getReadinessGate(int index) {
    return this.readinessGates.get(index);
  }
  
  public List<PodReadinessGate> getReadinessGates() {
    return this.readinessGates;
  }
  
  public PodResourceClaim getResourceClaim(int index) {
    return this.resourceClaims.get(index);
  }
  
  public List<PodResourceClaim> getResourceClaims() {
    return this.resourceClaims;
  }
  
  public Long getResponseStartTimeoutSeconds() {
    return this.responseStartTimeoutSeconds;
  }
  
  public String getRestartPolicy() {
    return this.restartPolicy;
  }
  
  public String getRuntimeClassName() {
    return this.runtimeClassName;
  }
  
  public String getSchedulerName() {
    return this.schedulerName;
  }
  
  public PodSchedulingGate getSchedulingGate(int index) {
    return this.schedulingGates.get(index);
  }
  
  public List<PodSchedulingGate> getSchedulingGates() {
    return this.schedulingGates;
  }
  
  public PodSecurityContext getSecurityContext() {
    return this.securityContext;
  }
  
  public String getServiceAccount() {
    return this.serviceAccount;
  }
  
  public String getServiceAccountName() {
    return this.serviceAccountName;
  }
  
  public Boolean getSetHostnameAsFQDN() {
    return this.setHostnameAsFQDN;
  }
  
  public Boolean getShareProcessNamespace() {
    return this.shareProcessNamespace;
  }
  
  public String getSubdomain() {
    return this.subdomain;
  }
  
  public Long getTerminationGracePeriodSeconds() {
    return this.terminationGracePeriodSeconds;
  }
  
  public Long getTimeoutSeconds() {
    return this.timeoutSeconds;
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
  
  public WorkloadReference getWorkloadRef() {
    return this.workloadRef;
  }
  
  public boolean hasActiveDeadlineSeconds() {
    return this.activeDeadlineSeconds != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinity() {
    return this.affinity != null;
  }
  
  public boolean hasAutomountServiceAccountToken() {
    return this.automountServiceAccountToken != null;
  }
  
  public boolean hasContainerConcurrency() {
    return this.containerConcurrency != null;
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
  
  public boolean hasEnableServiceLinks() {
    return this.enableServiceLinks != null;
  }
  
  public boolean hasEphemeralContainers() {
    return this.ephemeralContainers != null && !(this.ephemeralContainers.isEmpty());
  }
  
  public boolean hasHostAliases() {
    return this.hostAliases != null && !(this.hostAliases.isEmpty());
  }
  
  public boolean hasHostIPC() {
    return this.hostIPC != null;
  }
  
  public boolean hasHostNetwork() {
    return this.hostNetwork != null;
  }
  
  public boolean hasHostPID() {
    return this.hostPID != null;
  }
  
  public boolean hasHostUsers() {
    return this.hostUsers != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasHostnameOverride() {
    return this.hostnameOverride != null;
  }
  
  public boolean hasIdleTimeoutSeconds() {
    return this.idleTimeoutSeconds != null;
  }
  
  public boolean hasImagePullSecrets() {
    return this.imagePullSecrets != null && !(this.imagePullSecrets.isEmpty());
  }
  
  public boolean hasInitContainers() {
    return this.initContainers != null && !(this.initContainers.isEmpty());
  }
  
  public boolean hasMatchingContainer(Predicate<ContainerBuilder> predicate) {
      for (ContainerBuilder item : containers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEphemeralContainer(Predicate<EphemeralContainer> predicate) {
      for (EphemeralContainer item : ephemeralContainers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHostAlias(Predicate<HostAlias> predicate) {
      for (HostAlias item : hostAliases) {
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
  
  public boolean hasMatchingReadinessGate(Predicate<PodReadinessGate> predicate) {
      for (PodReadinessGate item : readinessGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceClaim(Predicate<PodResourceClaim> predicate) {
      for (PodResourceClaim item : resourceClaims) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSchedulingGate(Predicate<PodSchedulingGate> predicate) {
      for (PodSchedulingGate item : schedulingGates) {
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
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasNodeSelector() {
    return this.nodeSelector != null;
  }
  
  public boolean hasOs() {
    return this.os != null;
  }
  
  public boolean hasOverhead() {
    return this.overhead != null;
  }
  
  public boolean hasPreemptionPolicy() {
    return this.preemptionPolicy != null;
  }
  
  public boolean hasPriority() {
    return this.priority != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasReadinessGates() {
    return this.readinessGates != null && !(this.readinessGates.isEmpty());
  }
  
  public boolean hasResourceClaims() {
    return this.resourceClaims != null && !(this.resourceClaims.isEmpty());
  }
  
  public boolean hasResources() {
    return this.resources != null;
  }
  
  public boolean hasResponseStartTimeoutSeconds() {
    return this.responseStartTimeoutSeconds != null;
  }
  
  public boolean hasRestartPolicy() {
    return this.restartPolicy != null;
  }
  
  public boolean hasRuntimeClassName() {
    return this.runtimeClassName != null;
  }
  
  public boolean hasSchedulerName() {
    return this.schedulerName != null;
  }
  
  public boolean hasSchedulingGates() {
    return this.schedulingGates != null && !(this.schedulingGates.isEmpty());
  }
  
  public boolean hasSecurityContext() {
    return this.securityContext != null;
  }
  
  public boolean hasServiceAccount() {
    return this.serviceAccount != null;
  }
  
  public boolean hasServiceAccountName() {
    return this.serviceAccountName != null;
  }
  
  public boolean hasSetHostnameAsFQDN() {
    return this.setHostnameAsFQDN != null;
  }
  
  public boolean hasShareProcessNamespace() {
    return this.shareProcessNamespace != null;
  }
  
  public boolean hasSubdomain() {
    return this.subdomain != null;
  }
  
  public boolean hasTerminationGracePeriodSeconds() {
    return this.terminationGracePeriodSeconds != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public boolean hasTopologySpreadConstraints() {
    return this.topologySpreadConstraints != null && !(this.topologySpreadConstraints.isEmpty());
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public boolean hasWorkloadRef() {
    return this.workloadRef != null;
  }
  
  public int hashCode() {
    return Objects.hash(activeDeadlineSeconds, affinity, automountServiceAccountToken, containerConcurrency, containers, dnsConfig, dnsPolicy, enableServiceLinks, ephemeralContainers, hostAliases, hostIPC, hostNetwork, hostPID, hostUsers, hostname, hostnameOverride, idleTimeoutSeconds, imagePullSecrets, initContainers, nodeName, nodeSelector, os, overhead, preemptionPolicy, priority, priorityClassName, readinessGates, resourceClaims, resources, responseStartTimeoutSeconds, restartPolicy, runtimeClassName, schedulerName, schedulingGates, securityContext, serviceAccount, serviceAccountName, setHostnameAsFQDN, shareProcessNamespace, subdomain, terminationGracePeriodSeconds, timeoutSeconds, tolerations, topologySpreadConstraints, volumes, workloadRef, additionalProperties);
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
  
  public A removeAllFromEphemeralContainers(Collection<EphemeralContainer> items) {
    if (this.ephemeralContainers == null) {
      return (A) this;
    }
    for (EphemeralContainer item : items) {
      this.ephemeralContainers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromHostAliases(Collection<HostAlias> items) {
    if (this.hostAliases == null) {
      return (A) this;
    }
    for (HostAlias item : items) {
      this.hostAliases.remove(item);
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
  
  public A removeAllFromReadinessGates(Collection<PodReadinessGate> items) {
    if (this.readinessGates == null) {
      return (A) this;
    }
    for (PodReadinessGate item : items) {
      this.readinessGates.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceClaims(Collection<PodResourceClaim> items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (PodResourceClaim item : items) {
      this.resourceClaims.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSchedulingGates(Collection<PodSchedulingGate> items) {
    if (this.schedulingGates == null) {
      return (A) this;
    }
    for (PodSchedulingGate item : items) {
      this.schedulingGates.remove(item);
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
  
  public A removeFromEphemeralContainers(EphemeralContainer... items) {
    if (this.ephemeralContainers == null) {
      return (A) this;
    }
    for (EphemeralContainer item : items) {
      this.ephemeralContainers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromHostAliases(HostAlias... items) {
    if (this.hostAliases == null) {
      return (A) this;
    }
    for (HostAlias item : items) {
      this.hostAliases.remove(item);
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
  
  public A removeFromOverhead(String key) {
    if (this.overhead == null) {
      return (A) this;
    }
    if (key != null && this.overhead != null) {
      this.overhead.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromOverhead(Map<String,Quantity> map) {
    if (this.overhead == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.overhead != null) {
          this.overhead.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromReadinessGates(PodReadinessGate... items) {
    if (this.readinessGates == null) {
      return (A) this;
    }
    for (PodReadinessGate item : items) {
      this.readinessGates.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromResourceClaims(PodResourceClaim... items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (PodResourceClaim item : items) {
      this.resourceClaims.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSchedulingGates(PodSchedulingGate... items) {
    if (this.schedulingGates == null) {
      return (A) this;
    }
    for (PodSchedulingGate item : items) {
      this.schedulingGates.remove(item);
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
  
  public ContainersNested<A> setNewContainerLike(int index,Container item) {
    return new ContainersNested(index, item);
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
  
  public A setToEphemeralContainers(int index,EphemeralContainer item) {
    if (this.ephemeralContainers == null) {
      this.ephemeralContainers = new ArrayList();
    }
    this.ephemeralContainers.set(index, item);
    return (A) this;
  }
  
  public A setToHostAliases(int index,HostAlias item) {
    if (this.hostAliases == null) {
      this.hostAliases = new ArrayList();
    }
    this.hostAliases.set(index, item);
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
  
  public A setToReadinessGates(int index,PodReadinessGate item) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    this.readinessGates.set(index, item);
    return (A) this;
  }
  
  public A setToResourceClaims(int index,PodResourceClaim item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    this.resourceClaims.set(index, item);
    return (A) this;
  }
  
  public A setToSchedulingGates(int index,PodSchedulingGate item) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    this.schedulingGates.set(index, item);
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
    if (!(activeDeadlineSeconds == null)) {
        sb.append("activeDeadlineSeconds:");
        sb.append(activeDeadlineSeconds);
        sb.append(",");
    }
    if (!(affinity == null)) {
        sb.append("affinity:");
        sb.append(affinity);
        sb.append(",");
    }
    if (!(automountServiceAccountToken == null)) {
        sb.append("automountServiceAccountToken:");
        sb.append(automountServiceAccountToken);
        sb.append(",");
    }
    if (!(containerConcurrency == null)) {
        sb.append("containerConcurrency:");
        sb.append(containerConcurrency);
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
    if (!(enableServiceLinks == null)) {
        sb.append("enableServiceLinks:");
        sb.append(enableServiceLinks);
        sb.append(",");
    }
    if (!(ephemeralContainers == null) && !(ephemeralContainers.isEmpty())) {
        sb.append("ephemeralContainers:");
        sb.append(ephemeralContainers);
        sb.append(",");
    }
    if (!(hostAliases == null) && !(hostAliases.isEmpty())) {
        sb.append("hostAliases:");
        sb.append(hostAliases);
        sb.append(",");
    }
    if (!(hostIPC == null)) {
        sb.append("hostIPC:");
        sb.append(hostIPC);
        sb.append(",");
    }
    if (!(hostNetwork == null)) {
        sb.append("hostNetwork:");
        sb.append(hostNetwork);
        sb.append(",");
    }
    if (!(hostPID == null)) {
        sb.append("hostPID:");
        sb.append(hostPID);
        sb.append(",");
    }
    if (!(hostUsers == null)) {
        sb.append("hostUsers:");
        sb.append(hostUsers);
        sb.append(",");
    }
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(hostnameOverride == null)) {
        sb.append("hostnameOverride:");
        sb.append(hostnameOverride);
        sb.append(",");
    }
    if (!(idleTimeoutSeconds == null)) {
        sb.append("idleTimeoutSeconds:");
        sb.append(idleTimeoutSeconds);
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
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(nodeSelector == null) && !(nodeSelector.isEmpty())) {
        sb.append("nodeSelector:");
        sb.append(nodeSelector);
        sb.append(",");
    }
    if (!(os == null)) {
        sb.append("os:");
        sb.append(os);
        sb.append(",");
    }
    if (!(overhead == null) && !(overhead.isEmpty())) {
        sb.append("overhead:");
        sb.append(overhead);
        sb.append(",");
    }
    if (!(preemptionPolicy == null)) {
        sb.append("preemptionPolicy:");
        sb.append(preemptionPolicy);
        sb.append(",");
    }
    if (!(priority == null)) {
        sb.append("priority:");
        sb.append(priority);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(readinessGates == null) && !(readinessGates.isEmpty())) {
        sb.append("readinessGates:");
        sb.append(readinessGates);
        sb.append(",");
    }
    if (!(resourceClaims == null) && !(resourceClaims.isEmpty())) {
        sb.append("resourceClaims:");
        sb.append(resourceClaims);
        sb.append(",");
    }
    if (!(resources == null)) {
        sb.append("resources:");
        sb.append(resources);
        sb.append(",");
    }
    if (!(responseStartTimeoutSeconds == null)) {
        sb.append("responseStartTimeoutSeconds:");
        sb.append(responseStartTimeoutSeconds);
        sb.append(",");
    }
    if (!(restartPolicy == null)) {
        sb.append("restartPolicy:");
        sb.append(restartPolicy);
        sb.append(",");
    }
    if (!(runtimeClassName == null)) {
        sb.append("runtimeClassName:");
        sb.append(runtimeClassName);
        sb.append(",");
    }
    if (!(schedulerName == null)) {
        sb.append("schedulerName:");
        sb.append(schedulerName);
        sb.append(",");
    }
    if (!(schedulingGates == null) && !(schedulingGates.isEmpty())) {
        sb.append("schedulingGates:");
        sb.append(schedulingGates);
        sb.append(",");
    }
    if (!(securityContext == null)) {
        sb.append("securityContext:");
        sb.append(securityContext);
        sb.append(",");
    }
    if (!(serviceAccount == null)) {
        sb.append("serviceAccount:");
        sb.append(serviceAccount);
        sb.append(",");
    }
    if (!(serviceAccountName == null)) {
        sb.append("serviceAccountName:");
        sb.append(serviceAccountName);
        sb.append(",");
    }
    if (!(setHostnameAsFQDN == null)) {
        sb.append("setHostnameAsFQDN:");
        sb.append(setHostnameAsFQDN);
        sb.append(",");
    }
    if (!(shareProcessNamespace == null)) {
        sb.append("shareProcessNamespace:");
        sb.append(shareProcessNamespace);
        sb.append(",");
    }
    if (!(subdomain == null)) {
        sb.append("subdomain:");
        sb.append(subdomain);
        sb.append(",");
    }
    if (!(terminationGracePeriodSeconds == null)) {
        sb.append("terminationGracePeriodSeconds:");
        sb.append(terminationGracePeriodSeconds);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
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
    if (!(volumes == null) && !(volumes.isEmpty())) {
        sb.append("volumes:");
        sb.append(volumes);
        sb.append(",");
    }
    if (!(workloadRef == null)) {
        sb.append("workloadRef:");
        sb.append(workloadRef);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActiveDeadlineSeconds(Long activeDeadlineSeconds) {
    this.activeDeadlineSeconds = activeDeadlineSeconds;
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
  
  public A withAutomountServiceAccountToken() {
    return withAutomountServiceAccountToken(true);
  }
  
  public A withAutomountServiceAccountToken(Boolean automountServiceAccountToken) {
    this.automountServiceAccountToken = automountServiceAccountToken;
    return (A) this;
  }
  
  public A withContainerConcurrency(Long containerConcurrency) {
    this.containerConcurrency = containerConcurrency;
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
    this.dnsConfig = dnsConfig;
    return (A) this;
  }
  
  public A withDnsPolicy(String dnsPolicy) {
    this.dnsPolicy = dnsPolicy;
    return (A) this;
  }
  
  public A withEnableServiceLinks() {
    return withEnableServiceLinks(true);
  }
  
  public A withEnableServiceLinks(Boolean enableServiceLinks) {
    this.enableServiceLinks = enableServiceLinks;
    return (A) this;
  }
  
  public A withEphemeralContainers(List<EphemeralContainer> ephemeralContainers) {
    if (ephemeralContainers != null) {
        this.ephemeralContainers = new ArrayList();
        for (EphemeralContainer item : ephemeralContainers) {
          this.addToEphemeralContainers(item);
        }
    } else {
      this.ephemeralContainers = null;
    }
    return (A) this;
  }
  
  public A withEphemeralContainers(EphemeralContainer... ephemeralContainers) {
    if (this.ephemeralContainers != null) {
        this.ephemeralContainers.clear();
        _visitables.remove("ephemeralContainers");
    }
    if (ephemeralContainers != null) {
      for (EphemeralContainer item : ephemeralContainers) {
        this.addToEphemeralContainers(item);
      }
    }
    return (A) this;
  }
  
  public A withHostAliases(List<HostAlias> hostAliases) {
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
  
  public A withHostIPC() {
    return withHostIPC(true);
  }
  
  public A withHostIPC(Boolean hostIPC) {
    this.hostIPC = hostIPC;
    return (A) this;
  }
  
  public A withHostNetwork() {
    return withHostNetwork(true);
  }
  
  public A withHostNetwork(Boolean hostNetwork) {
    this.hostNetwork = hostNetwork;
    return (A) this;
  }
  
  public A withHostPID() {
    return withHostPID(true);
  }
  
  public A withHostPID(Boolean hostPID) {
    this.hostPID = hostPID;
    return (A) this;
  }
  
  public A withHostUsers() {
    return withHostUsers(true);
  }
  
  public A withHostUsers(Boolean hostUsers) {
    this.hostUsers = hostUsers;
    return (A) this;
  }
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public A withHostnameOverride(String hostnameOverride) {
    this.hostnameOverride = hostnameOverride;
    return (A) this;
  }
  
  public A withIdleTimeoutSeconds(Long idleTimeoutSeconds) {
    this.idleTimeoutSeconds = idleTimeoutSeconds;
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
  
  public A withNewOs(String name) {
    return (A) this.withOs(new PodOS(name));
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public A withNewWorkloadRef(String name,String podGroup,String podGroupReplicaKey) {
    return (A) this.withWorkloadRef(new WorkloadReference(name, podGroup, podGroupReplicaKey));
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public <K,V>A withNodeSelector(Map<String,String> nodeSelector) {
    if (nodeSelector == null) {
      this.nodeSelector = null;
    } else {
      this.nodeSelector = new LinkedHashMap(nodeSelector);
    }
    return (A) this;
  }
  
  public A withOs(PodOS os) {
    this.os = os;
    return (A) this;
  }
  
  public <K,V>A withOverhead(Map<String,Quantity> overhead) {
    if (overhead == null) {
      this.overhead = null;
    } else {
      this.overhead = new LinkedHashMap(overhead);
    }
    return (A) this;
  }
  
  public A withPreemptionPolicy(String preemptionPolicy) {
    this.preemptionPolicy = preemptionPolicy;
    return (A) this;
  }
  
  public A withPriority(Integer priority) {
    this.priority = priority;
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withReadinessGates(List<PodReadinessGate> readinessGates) {
    if (readinessGates != null) {
        this.readinessGates = new ArrayList();
        for (PodReadinessGate item : readinessGates) {
          this.addToReadinessGates(item);
        }
    } else {
      this.readinessGates = null;
    }
    return (A) this;
  }
  
  public A withReadinessGates(PodReadinessGate... readinessGates) {
    if (this.readinessGates != null) {
        this.readinessGates.clear();
        _visitables.remove("readinessGates");
    }
    if (readinessGates != null) {
      for (PodReadinessGate item : readinessGates) {
        this.addToReadinessGates(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceClaims(List<PodResourceClaim> resourceClaims) {
    if (resourceClaims != null) {
        this.resourceClaims = new ArrayList();
        for (PodResourceClaim item : resourceClaims) {
          this.addToResourceClaims(item);
        }
    } else {
      this.resourceClaims = null;
    }
    return (A) this;
  }
  
  public A withResourceClaims(PodResourceClaim... resourceClaims) {
    if (this.resourceClaims != null) {
        this.resourceClaims.clear();
        _visitables.remove("resourceClaims");
    }
    if (resourceClaims != null) {
      for (PodResourceClaim item : resourceClaims) {
        this.addToResourceClaims(item);
      }
    }
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
  
  public A withResponseStartTimeoutSeconds(Long responseStartTimeoutSeconds) {
    this.responseStartTimeoutSeconds = responseStartTimeoutSeconds;
    return (A) this;
  }
  
  public A withRestartPolicy(String restartPolicy) {
    this.restartPolicy = restartPolicy;
    return (A) this;
  }
  
  public A withRuntimeClassName(String runtimeClassName) {
    this.runtimeClassName = runtimeClassName;
    return (A) this;
  }
  
  public A withSchedulerName(String schedulerName) {
    this.schedulerName = schedulerName;
    return (A) this;
  }
  
  public A withSchedulingGates(List<PodSchedulingGate> schedulingGates) {
    if (schedulingGates != null) {
        this.schedulingGates = new ArrayList();
        for (PodSchedulingGate item : schedulingGates) {
          this.addToSchedulingGates(item);
        }
    } else {
      this.schedulingGates = null;
    }
    return (A) this;
  }
  
  public A withSchedulingGates(PodSchedulingGate... schedulingGates) {
    if (this.schedulingGates != null) {
        this.schedulingGates.clear();
        _visitables.remove("schedulingGates");
    }
    if (schedulingGates != null) {
      for (PodSchedulingGate item : schedulingGates) {
        this.addToSchedulingGates(item);
      }
    }
    return (A) this;
  }
  
  public A withSecurityContext(PodSecurityContext securityContext) {
    this.securityContext = securityContext;
    return (A) this;
  }
  
  public A withServiceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
    return (A) this;
  }
  
  public A withServiceAccountName(String serviceAccountName) {
    this.serviceAccountName = serviceAccountName;
    return (A) this;
  }
  
  public A withSetHostnameAsFQDN() {
    return withSetHostnameAsFQDN(true);
  }
  
  public A withSetHostnameAsFQDN(Boolean setHostnameAsFQDN) {
    this.setHostnameAsFQDN = setHostnameAsFQDN;
    return (A) this;
  }
  
  public A withShareProcessNamespace() {
    return withShareProcessNamespace(true);
  }
  
  public A withShareProcessNamespace(Boolean shareProcessNamespace) {
    this.shareProcessNamespace = shareProcessNamespace;
    return (A) this;
  }
  
  public A withSubdomain(String subdomain) {
    this.subdomain = subdomain;
    return (A) this;
  }
  
  public A withTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
    this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    return (A) this;
  }
  
  public A withTimeoutSeconds(Long timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
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
  
  public A withWorkloadRef(WorkloadReference workloadRef) {
    this.workloadRef = workloadRef;
    return (A) this;
  }
  public class ContainersNested<N> extends ContainerFluent<ContainersNested<N>> implements Nested<N>{
  
    ContainerBuilder builder;
    int index;
  
    ContainersNested(int index,Container item) {
      this.index = index;
      this.builder = new ContainerBuilder(this, item);
    }
  
    public N and() {
      return (N) RevisionSpecFluent.this.setToContainers(index, builder.build());
    }
    
    public N endContainer() {
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
      return (N) RevisionSpecFluent.this.setToImagePullSecrets(index, builder.build());
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
      return (N) RevisionSpecFluent.this.setToInitContainers(index, builder.build());
    }
    
    public N endInitContainer() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) RevisionSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
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
      return (N) RevisionSpecFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
}