package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PodSpecFluent<A extends io.fabric8.kubernetes.api.model.PodSpecFluent<A>> extends BaseFluent<A>{

  private Long activeDeadlineSeconds;
  private Map<String,Object> additionalProperties;
  private AffinityBuilder affinity;
  private Boolean automountServiceAccountToken;
  private ArrayList<ContainerBuilder> containers = new ArrayList<ContainerBuilder>();
  private PodDNSConfigBuilder dnsConfig;
  private String dnsPolicy;
  private Boolean enableServiceLinks;
  private ArrayList<EphemeralContainerBuilder> ephemeralContainers = new ArrayList<EphemeralContainerBuilder>();
  private ArrayList<HostAliasBuilder> hostAliases = new ArrayList<HostAliasBuilder>();
  private Boolean hostIPC;
  private Boolean hostNetwork;
  private Boolean hostPID;
  private Boolean hostUsers;
  private String hostname;
  private String hostnameOverride;
  private ArrayList<LocalObjectReferenceBuilder> imagePullSecrets = new ArrayList<LocalObjectReferenceBuilder>();
  private ArrayList<ContainerBuilder> initContainers = new ArrayList<ContainerBuilder>();
  private String nodeName;
  private Map<String,String> nodeSelector;
  private PodOSBuilder os;
  private Map<String,Quantity> overhead;
  private String preemptionPolicy;
  private Integer priority;
  private String priorityClassName;
  private ArrayList<PodReadinessGateBuilder> readinessGates = new ArrayList<PodReadinessGateBuilder>();
  private ArrayList<PodResourceClaimBuilder> resourceClaims = new ArrayList<PodResourceClaimBuilder>();
  private ResourceRequirementsBuilder resources;
  private String restartPolicy;
  private String runtimeClassName;
  private String schedulerName;
  private ArrayList<PodSchedulingGateBuilder> schedulingGates = new ArrayList<PodSchedulingGateBuilder>();
  private PodSchedulingGroupBuilder schedulingGroup;
  private PodSecurityContextBuilder securityContext;
  private String serviceAccount;
  private String serviceAccountName;
  private Boolean setHostnameAsFQDN;
  private Boolean shareProcessNamespace;
  private String subdomain;
  private Long terminationGracePeriodSeconds;
  private ArrayList<TolerationBuilder> tolerations = new ArrayList<TolerationBuilder>();
  private ArrayList<TopologySpreadConstraintBuilder> topologySpreadConstraints = new ArrayList<TopologySpreadConstraintBuilder>();
  private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();

  public PodSpecFluent() {
  }
  
  public PodSpecFluent(PodSpec instance) {
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
        EphemeralContainerBuilder builder = new EphemeralContainerBuilder(item);
        _visitables.get("ephemeralContainers").add(builder);
        this.ephemeralContainers.add(builder);
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
  
  public A addAllToReadinessGates(Collection<PodReadinessGate> items) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    for (PodReadinessGate item : items) {
        PodReadinessGateBuilder builder = new PodReadinessGateBuilder(item);
        _visitables.get("readinessGates").add(builder);
        this.readinessGates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToResourceClaims(Collection<PodResourceClaim> items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (PodResourceClaim item : items) {
        PodResourceClaimBuilder builder = new PodResourceClaimBuilder(item);
        _visitables.get("resourceClaims").add(builder);
        this.resourceClaims.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSchedulingGates(Collection<PodSchedulingGate> items) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    for (PodSchedulingGate item : items) {
        PodSchedulingGateBuilder builder = new PodSchedulingGateBuilder(item);
        _visitables.get("schedulingGates").add(builder);
        this.schedulingGates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").add(builder);
        this.tolerations.add(builder);
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
  
  public EphemeralContainersNested<A> addNewEphemeralContainer() {
    return new EphemeralContainersNested(-1, null);
  }
  
  public EphemeralContainersNested<A> addNewEphemeralContainerLike(EphemeralContainer item) {
    return new EphemeralContainersNested(-1, item);
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
  
  public ReadinessGatesNested<A> addNewReadinessGate() {
    return new ReadinessGatesNested(-1, null);
  }
  
  public A addNewReadinessGate(String conditionType) {
    return (A) this.addToReadinessGates(new PodReadinessGate(conditionType));
  }
  
  public ReadinessGatesNested<A> addNewReadinessGateLike(PodReadinessGate item) {
    return new ReadinessGatesNested(-1, item);
  }
  
  public ResourceClaimsNested<A> addNewResourceClaim() {
    return new ResourceClaimsNested(-1, null);
  }
  
  public A addNewResourceClaim(String name,String resourceClaimName,String resourceClaimTemplateName) {
    return (A) this.addToResourceClaims(new PodResourceClaim(name, resourceClaimName, resourceClaimTemplateName));
  }
  
  public ResourceClaimsNested<A> addNewResourceClaimLike(PodResourceClaim item) {
    return new ResourceClaimsNested(-1, item);
  }
  
  public SchedulingGatesNested<A> addNewSchedulingGate() {
    return new SchedulingGatesNested(-1, null);
  }
  
  public A addNewSchedulingGate(String name) {
    return (A) this.addToSchedulingGates(new PodSchedulingGate(name));
  }
  
  public SchedulingGatesNested<A> addNewSchedulingGateLike(PodSchedulingGate item) {
    return new SchedulingGatesNested(-1, item);
  }
  
  public TolerationsNested<A> addNewToleration() {
    return new TolerationsNested(-1, null);
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
  }
  
  public TolerationsNested<A> addNewTolerationLike(Toleration item) {
    return new TolerationsNested(-1, item);
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
        EphemeralContainerBuilder builder = new EphemeralContainerBuilder(item);
        _visitables.get("ephemeralContainers").add(builder);
        this.ephemeralContainers.add(builder);
    }
    return (A) this;
  }
  
  public A addToEphemeralContainers(int index,EphemeralContainer item) {
    if (this.ephemeralContainers == null) {
      this.ephemeralContainers = new ArrayList();
    }
    EphemeralContainerBuilder builder = new EphemeralContainerBuilder(item);
    if (index < 0 || index >= ephemeralContainers.size()) {
        _visitables.get("ephemeralContainers").add(builder);
        ephemeralContainers.add(builder);
    } else {
        _visitables.get("ephemeralContainers").add(builder);
        ephemeralContainers.add(index, builder);
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
        PodReadinessGateBuilder builder = new PodReadinessGateBuilder(item);
        _visitables.get("readinessGates").add(builder);
        this.readinessGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToReadinessGates(int index,PodReadinessGate item) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    PodReadinessGateBuilder builder = new PodReadinessGateBuilder(item);
    if (index < 0 || index >= readinessGates.size()) {
        _visitables.get("readinessGates").add(builder);
        readinessGates.add(builder);
    } else {
        _visitables.get("readinessGates").add(builder);
        readinessGates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToResourceClaims(PodResourceClaim... items) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    for (PodResourceClaim item : items) {
        PodResourceClaimBuilder builder = new PodResourceClaimBuilder(item);
        _visitables.get("resourceClaims").add(builder);
        this.resourceClaims.add(builder);
    }
    return (A) this;
  }
  
  public A addToResourceClaims(int index,PodResourceClaim item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    PodResourceClaimBuilder builder = new PodResourceClaimBuilder(item);
    if (index < 0 || index >= resourceClaims.size()) {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.add(builder);
    } else {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToSchedulingGates(PodSchedulingGate... items) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    for (PodSchedulingGate item : items) {
        PodSchedulingGateBuilder builder = new PodSchedulingGateBuilder(item);
        _visitables.get("schedulingGates").add(builder);
        this.schedulingGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToSchedulingGates(int index,PodSchedulingGate item) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    PodSchedulingGateBuilder builder = new PodSchedulingGateBuilder(item);
    if (index < 0 || index >= schedulingGates.size()) {
        _visitables.get("schedulingGates").add(builder);
        schedulingGates.add(builder);
    } else {
        _visitables.get("schedulingGates").add(builder);
        schedulingGates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").add(builder);
        this.tolerations.add(builder);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    TolerationBuilder builder = new TolerationBuilder(item);
    if (index < 0 || index >= tolerations.size()) {
        _visitables.get("tolerations").add(builder);
        tolerations.add(builder);
    } else {
        _visitables.get("tolerations").add(builder);
        tolerations.add(index, builder);
    }
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
  
  public Affinity buildAffinity() {
    return this.affinity != null ? this.affinity.build() : null;
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
  
  public EphemeralContainer buildEphemeralContainer(int index) {
    return this.ephemeralContainers.get(index).build();
  }
  
  public List<EphemeralContainer> buildEphemeralContainers() {
    return this.ephemeralContainers != null ? build(ephemeralContainers) : null;
  }
  
  public Container buildFirstContainer() {
    return this.containers.get(0).build();
  }
  
  public EphemeralContainer buildFirstEphemeralContainer() {
    return this.ephemeralContainers.get(0).build();
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
  
  public PodReadinessGate buildFirstReadinessGate() {
    return this.readinessGates.get(0).build();
  }
  
  public PodResourceClaim buildFirstResourceClaim() {
    return this.resourceClaims.get(0).build();
  }
  
  public PodSchedulingGate buildFirstSchedulingGate() {
    return this.schedulingGates.get(0).build();
  }
  
  public Toleration buildFirstToleration() {
    return this.tolerations.get(0).build();
  }
  
  public TopologySpreadConstraint buildFirstTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(0).build();
  }
  
  public Volume buildFirstVolume() {
    return this.volumes.get(0).build();
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
  
  public Container buildLastContainer() {
    return this.containers.get(containers.size() - 1).build();
  }
  
  public EphemeralContainer buildLastEphemeralContainer() {
    return this.ephemeralContainers.get(ephemeralContainers.size() - 1).build();
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
  
  public PodReadinessGate buildLastReadinessGate() {
    return this.readinessGates.get(readinessGates.size() - 1).build();
  }
  
  public PodResourceClaim buildLastResourceClaim() {
    return this.resourceClaims.get(resourceClaims.size() - 1).build();
  }
  
  public PodSchedulingGate buildLastSchedulingGate() {
    return this.schedulingGates.get(schedulingGates.size() - 1).build();
  }
  
  public Toleration buildLastToleration() {
    return this.tolerations.get(tolerations.size() - 1).build();
  }
  
  public TopologySpreadConstraint buildLastTopologySpreadConstraint() {
    return this.topologySpreadConstraints.get(topologySpreadConstraints.size() - 1).build();
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
  
  public EphemeralContainer buildMatchingEphemeralContainer(Predicate<EphemeralContainerBuilder> predicate) {
      for (EphemeralContainerBuilder item : ephemeralContainers) {
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
  
  public PodReadinessGate buildMatchingReadinessGate(Predicate<PodReadinessGateBuilder> predicate) {
      for (PodReadinessGateBuilder item : readinessGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodResourceClaim buildMatchingResourceClaim(Predicate<PodResourceClaimBuilder> predicate) {
      for (PodResourceClaimBuilder item : resourceClaims) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PodSchedulingGate buildMatchingSchedulingGate(Predicate<PodSchedulingGateBuilder> predicate) {
      for (PodSchedulingGateBuilder item : schedulingGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Toleration buildMatchingToleration(Predicate<TolerationBuilder> predicate) {
      for (TolerationBuilder item : tolerations) {
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
  
  public PodOS buildOs() {
    return this.os != null ? this.os.build() : null;
  }
  
  public PodReadinessGate buildReadinessGate(int index) {
    return this.readinessGates.get(index).build();
  }
  
  public List<PodReadinessGate> buildReadinessGates() {
    return this.readinessGates != null ? build(readinessGates) : null;
  }
  
  public PodResourceClaim buildResourceClaim(int index) {
    return this.resourceClaims.get(index).build();
  }
  
  public List<PodResourceClaim> buildResourceClaims() {
    return this.resourceClaims != null ? build(resourceClaims) : null;
  }
  
  public ResourceRequirements buildResources() {
    return this.resources != null ? this.resources.build() : null;
  }
  
  public PodSchedulingGate buildSchedulingGate(int index) {
    return this.schedulingGates.get(index).build();
  }
  
  public List<PodSchedulingGate> buildSchedulingGates() {
    return this.schedulingGates != null ? build(schedulingGates) : null;
  }
  
  public PodSchedulingGroup buildSchedulingGroup() {
    return this.schedulingGroup != null ? this.schedulingGroup.build() : null;
  }
  
  public PodSecurityContext buildSecurityContext() {
    return this.securityContext != null ? this.securityContext.build() : null;
  }
  
  public Toleration buildToleration(int index) {
    return this.tolerations.get(index).build();
  }
  
  public List<Toleration> buildTolerations() {
    return this.tolerations != null ? build(tolerations) : null;
  }
  
  public TopologySpreadConstraint buildTopologySpreadConstraint(int index) {
    return this.topologySpreadConstraints.get(index).build();
  }
  
  public List<TopologySpreadConstraint> buildTopologySpreadConstraints() {
    return this.topologySpreadConstraints != null ? build(topologySpreadConstraints) : null;
  }
  
  public Volume buildVolume(int index) {
    return this.volumes.get(index).build();
  }
  
  public List<Volume> buildVolumes() {
    return this.volumes != null ? build(volumes) : null;
  }
  
  protected void copyInstance(PodSpec instance) {
    instance = instance != null ? instance : new PodSpec();
    if (instance != null) {
        this.withActiveDeadlineSeconds(instance.getActiveDeadlineSeconds());
        this.withAffinity(instance.getAffinity());
        this.withAutomountServiceAccountToken(instance.getAutomountServiceAccountToken());
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
        this.withRestartPolicy(instance.getRestartPolicy());
        this.withRuntimeClassName(instance.getRuntimeClassName());
        this.withSchedulerName(instance.getSchedulerName());
        this.withSchedulingGates(instance.getSchedulingGates());
        this.withSchedulingGroup(instance.getSchedulingGroup());
        this.withSecurityContext(instance.getSecurityContext());
        this.withServiceAccount(instance.getServiceAccount());
        this.withServiceAccountName(instance.getServiceAccountName());
        this.withSetHostnameAsFQDN(instance.getSetHostnameAsFQDN());
        this.withShareProcessNamespace(instance.getShareProcessNamespace());
        this.withSubdomain(instance.getSubdomain());
        this.withTerminationGracePeriodSeconds(instance.getTerminationGracePeriodSeconds());
        this.withTolerations(instance.getTolerations());
        this.withTopologySpreadConstraints(instance.getTopologySpreadConstraints());
        this.withVolumes(instance.getVolumes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AffinityNested<A> editAffinity() {
    return this.withNewAffinityLike(Optional.ofNullable(this.buildAffinity()).orElse(null));
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
  
  public EphemeralContainersNested<A> editEphemeralContainer(int index) {
    if (ephemeralContainers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ephemeralContainers"));
    }
    return this.setNewEphemeralContainerLike(index, this.buildEphemeralContainer(index));
  }
  
  public ContainersNested<A> editFirstContainer() {
    if (containers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(0, this.buildContainer(0));
  }
  
  public EphemeralContainersNested<A> editFirstEphemeralContainer() {
    if (ephemeralContainers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ephemeralContainers"));
    }
    return this.setNewEphemeralContainerLike(0, this.buildEphemeralContainer(0));
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
  
  public ReadinessGatesNested<A> editFirstReadinessGate() {
    if (readinessGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(0, this.buildReadinessGate(0));
  }
  
  public ResourceClaimsNested<A> editFirstResourceClaim() {
    if (resourceClaims.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(0, this.buildResourceClaim(0));
  }
  
  public SchedulingGatesNested<A> editFirstSchedulingGate() {
    if (schedulingGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "schedulingGates"));
    }
    return this.setNewSchedulingGateLike(0, this.buildSchedulingGate(0));
  }
  
  public TolerationsNested<A> editFirstToleration() {
    if (tolerations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tolerations"));
    }
    return this.setNewTolerationLike(0, this.buildToleration(0));
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
  
  public ContainersNested<A> editLastContainer() {
    int index = containers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containers"));
    }
    return this.setNewContainerLike(index, this.buildContainer(index));
  }
  
  public EphemeralContainersNested<A> editLastEphemeralContainer() {
    int index = ephemeralContainers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ephemeralContainers"));
    }
    return this.setNewEphemeralContainerLike(index, this.buildEphemeralContainer(index));
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
  
  public ReadinessGatesNested<A> editLastReadinessGate() {
    int index = readinessGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(index, this.buildReadinessGate(index));
  }
  
  public ResourceClaimsNested<A> editLastResourceClaim() {
    int index = resourceClaims.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(index, this.buildResourceClaim(index));
  }
  
  public SchedulingGatesNested<A> editLastSchedulingGate() {
    int index = schedulingGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "schedulingGates"));
    }
    return this.setNewSchedulingGateLike(index, this.buildSchedulingGate(index));
  }
  
  public TolerationsNested<A> editLastToleration() {
    int index = tolerations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
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
  
  public EphemeralContainersNested<A> editMatchingEphemeralContainer(Predicate<EphemeralContainerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ephemeralContainers.size();i++) {
      if (predicate.test(ephemeralContainers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ephemeralContainers"));
    }
    return this.setNewEphemeralContainerLike(index, this.buildEphemeralContainer(index));
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
  
  public ReadinessGatesNested<A> editMatchingReadinessGate(Predicate<PodReadinessGateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < readinessGates.size();i++) {
      if (predicate.test(readinessGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(index, this.buildReadinessGate(index));
  }
  
  public ResourceClaimsNested<A> editMatchingResourceClaim(Predicate<PodResourceClaimBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < resourceClaims.size();i++) {
      if (predicate.test(resourceClaims.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(index, this.buildResourceClaim(index));
  }
  
  public SchedulingGatesNested<A> editMatchingSchedulingGate(Predicate<PodSchedulingGateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < schedulingGates.size();i++) {
      if (predicate.test(schedulingGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "schedulingGates"));
    }
    return this.setNewSchedulingGateLike(index, this.buildSchedulingGate(index));
  }
  
  public TolerationsNested<A> editMatchingToleration(Predicate<TolerationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tolerations.size();i++) {
      if (predicate.test(tolerations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
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
  
  public AffinityNested<A> editOrNewAffinity() {
    return this.withNewAffinityLike(Optional.ofNullable(this.buildAffinity()).orElse(new AffinityBuilder().build()));
  }
  
  public AffinityNested<A> editOrNewAffinityLike(Affinity item) {
    return this.withNewAffinityLike(Optional.ofNullable(this.buildAffinity()).orElse(item));
  }
  
  public DnsConfigNested<A> editOrNewDnsConfig() {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(new PodDNSConfigBuilder().build()));
  }
  
  public DnsConfigNested<A> editOrNewDnsConfigLike(PodDNSConfig item) {
    return this.withNewDnsConfigLike(Optional.ofNullable(this.buildDnsConfig()).orElse(item));
  }
  
  public OsNested<A> editOrNewOs() {
    return this.withNewOsLike(Optional.ofNullable(this.buildOs()).orElse(new PodOSBuilder().build()));
  }
  
  public OsNested<A> editOrNewOsLike(PodOS item) {
    return this.withNewOsLike(Optional.ofNullable(this.buildOs()).orElse(item));
  }
  
  public ResourcesNested<A> editOrNewResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(new ResourceRequirementsBuilder().build()));
  }
  
  public ResourcesNested<A> editOrNewResourcesLike(ResourceRequirements item) {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(item));
  }
  
  public SchedulingGroupNested<A> editOrNewSchedulingGroup() {
    return this.withNewSchedulingGroupLike(Optional.ofNullable(this.buildSchedulingGroup()).orElse(new PodSchedulingGroupBuilder().build()));
  }
  
  public SchedulingGroupNested<A> editOrNewSchedulingGroupLike(PodSchedulingGroup item) {
    return this.withNewSchedulingGroupLike(Optional.ofNullable(this.buildSchedulingGroup()).orElse(item));
  }
  
  public SecurityContextNested<A> editOrNewSecurityContext() {
    return this.withNewSecurityContextLike(Optional.ofNullable(this.buildSecurityContext()).orElse(new PodSecurityContextBuilder().build()));
  }
  
  public SecurityContextNested<A> editOrNewSecurityContextLike(PodSecurityContext item) {
    return this.withNewSecurityContextLike(Optional.ofNullable(this.buildSecurityContext()).orElse(item));
  }
  
  public OsNested<A> editOs() {
    return this.withNewOsLike(Optional.ofNullable(this.buildOs()).orElse(null));
  }
  
  public ReadinessGatesNested<A> editReadinessGate(int index) {
    if (readinessGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "readinessGates"));
    }
    return this.setNewReadinessGateLike(index, this.buildReadinessGate(index));
  }
  
  public ResourceClaimsNested<A> editResourceClaim(int index) {
    if (resourceClaims.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "resourceClaims"));
    }
    return this.setNewResourceClaimLike(index, this.buildResourceClaim(index));
  }
  
  public ResourcesNested<A> editResources() {
    return this.withNewResourcesLike(Optional.ofNullable(this.buildResources()).orElse(null));
  }
  
  public SchedulingGatesNested<A> editSchedulingGate(int index) {
    if (schedulingGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "schedulingGates"));
    }
    return this.setNewSchedulingGateLike(index, this.buildSchedulingGate(index));
  }
  
  public SchedulingGroupNested<A> editSchedulingGroup() {
    return this.withNewSchedulingGroupLike(Optional.ofNullable(this.buildSchedulingGroup()).orElse(null));
  }
  
  public SecurityContextNested<A> editSecurityContext() {
    return this.withNewSecurityContextLike(Optional.ofNullable(this.buildSecurityContext()).orElse(null));
  }
  
  public TolerationsNested<A> editToleration(int index) {
    if (tolerations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
  }
  
  public TopologySpreadConstraintsNested<A> editTopologySpreadConstraint(int index) {
    if (topologySpreadConstraints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "topologySpreadConstraints"));
    }
    return this.setNewTopologySpreadConstraintLike(index, this.buildTopologySpreadConstraint(index));
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
    PodSpecFluent that = (PodSpecFluent) o;
    if (!(Objects.equals(activeDeadlineSeconds, that.activeDeadlineSeconds))) {
      return false;
    }
    if (!(Objects.equals(affinity, that.affinity))) {
      return false;
    }
    if (!(Objects.equals(automountServiceAccountToken, that.automountServiceAccountToken))) {
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
    if (!(Objects.equals(schedulingGroup, that.schedulingGroup))) {
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
    if (!(Objects.equals(tolerations, that.tolerations))) {
      return false;
    }
    if (!(Objects.equals(topologySpreadConstraints, that.topologySpreadConstraints))) {
      return false;
    }
    if (!(Objects.equals(volumes, that.volumes))) {
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
  
  public Boolean getAutomountServiceAccountToken() {
    return this.automountServiceAccountToken;
  }
  
  public String getDnsPolicy() {
    return this.dnsPolicy;
  }
  
  public Boolean getEnableServiceLinks() {
    return this.enableServiceLinks;
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
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public Map<String,String> getNodeSelector() {
    return this.nodeSelector;
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
  
  public String getRestartPolicy() {
    return this.restartPolicy;
  }
  
  public String getRuntimeClassName() {
    return this.runtimeClassName;
  }
  
  public String getSchedulerName() {
    return this.schedulerName;
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
  
  public boolean hasMatchingEphemeralContainer(Predicate<EphemeralContainerBuilder> predicate) {
      for (EphemeralContainerBuilder item : ephemeralContainers) {
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
  
  public boolean hasMatchingReadinessGate(Predicate<PodReadinessGateBuilder> predicate) {
      for (PodReadinessGateBuilder item : readinessGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingResourceClaim(Predicate<PodResourceClaimBuilder> predicate) {
      for (PodResourceClaimBuilder item : resourceClaims) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSchedulingGate(Predicate<PodSchedulingGateBuilder> predicate) {
      for (PodSchedulingGateBuilder item : schedulingGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingToleration(Predicate<TolerationBuilder> predicate) {
      for (TolerationBuilder item : tolerations) {
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
  
  public boolean hasSchedulingGroup() {
    return this.schedulingGroup != null;
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
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public boolean hasTopologySpreadConstraints() {
    return this.topologySpreadConstraints != null && !(this.topologySpreadConstraints.isEmpty());
  }
  
  public boolean hasVolumes() {
    return this.volumes != null && !(this.volumes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(activeDeadlineSeconds, affinity, automountServiceAccountToken, containers, dnsConfig, dnsPolicy, enableServiceLinks, ephemeralContainers, hostAliases, hostIPC, hostNetwork, hostPID, hostUsers, hostname, hostnameOverride, imagePullSecrets, initContainers, nodeName, nodeSelector, os, overhead, preemptionPolicy, priority, priorityClassName, readinessGates, resourceClaims, resources, restartPolicy, runtimeClassName, schedulerName, schedulingGates, schedulingGroup, securityContext, serviceAccount, serviceAccountName, setHostnameAsFQDN, shareProcessNamespace, subdomain, terminationGracePeriodSeconds, tolerations, topologySpreadConstraints, volumes, additionalProperties);
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
        EphemeralContainerBuilder builder = new EphemeralContainerBuilder(item);
        _visitables.get("ephemeralContainers").remove(builder);
        this.ephemeralContainers.remove(builder);
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
  
  public A removeAllFromReadinessGates(Collection<PodReadinessGate> items) {
    if (this.readinessGates == null) {
      return (A) this;
    }
    for (PodReadinessGate item : items) {
        PodReadinessGateBuilder builder = new PodReadinessGateBuilder(item);
        _visitables.get("readinessGates").remove(builder);
        this.readinessGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromResourceClaims(Collection<PodResourceClaim> items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (PodResourceClaim item : items) {
        PodResourceClaimBuilder builder = new PodResourceClaimBuilder(item);
        _visitables.get("resourceClaims").remove(builder);
        this.resourceClaims.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSchedulingGates(Collection<PodSchedulingGate> items) {
    if (this.schedulingGates == null) {
      return (A) this;
    }
    for (PodSchedulingGate item : items) {
        PodSchedulingGateBuilder builder = new PodSchedulingGateBuilder(item);
        _visitables.get("schedulingGates").remove(builder);
        this.schedulingGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").remove(builder);
        this.tolerations.remove(builder);
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
        EphemeralContainerBuilder builder = new EphemeralContainerBuilder(item);
        _visitables.get("ephemeralContainers").remove(builder);
        this.ephemeralContainers.remove(builder);
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
        PodReadinessGateBuilder builder = new PodReadinessGateBuilder(item);
        _visitables.get("readinessGates").remove(builder);
        this.readinessGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromResourceClaims(PodResourceClaim... items) {
    if (this.resourceClaims == null) {
      return (A) this;
    }
    for (PodResourceClaim item : items) {
        PodResourceClaimBuilder builder = new PodResourceClaimBuilder(item);
        _visitables.get("resourceClaims").remove(builder);
        this.resourceClaims.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromSchedulingGates(PodSchedulingGate... items) {
    if (this.schedulingGates == null) {
      return (A) this;
    }
    for (PodSchedulingGate item : items) {
        PodSchedulingGateBuilder builder = new PodSchedulingGateBuilder(item);
        _visitables.get("schedulingGates").remove(builder);
        this.schedulingGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").remove(builder);
        this.tolerations.remove(builder);
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
  
  public A removeMatchingFromEphemeralContainers(Predicate<EphemeralContainerBuilder> predicate) {
    if (ephemeralContainers == null) {
      return (A) this;
    }
    Iterator<EphemeralContainerBuilder> each = ephemeralContainers.iterator();
    List visitables = _visitables.get("ephemeralContainers");
    while (each.hasNext()) {
        EphemeralContainerBuilder builder = each.next();
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
  
  public A removeMatchingFromReadinessGates(Predicate<PodReadinessGateBuilder> predicate) {
    if (readinessGates == null) {
      return (A) this;
    }
    Iterator<PodReadinessGateBuilder> each = readinessGates.iterator();
    List visitables = _visitables.get("readinessGates");
    while (each.hasNext()) {
        PodReadinessGateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromResourceClaims(Predicate<PodResourceClaimBuilder> predicate) {
    if (resourceClaims == null) {
      return (A) this;
    }
    Iterator<PodResourceClaimBuilder> each = resourceClaims.iterator();
    List visitables = _visitables.get("resourceClaims");
    while (each.hasNext()) {
        PodResourceClaimBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSchedulingGates(Predicate<PodSchedulingGateBuilder> predicate) {
    if (schedulingGates == null) {
      return (A) this;
    }
    Iterator<PodSchedulingGateBuilder> each = schedulingGates.iterator();
    List visitables = _visitables.get("schedulingGates");
    while (each.hasNext()) {
        PodSchedulingGateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTolerations(Predicate<TolerationBuilder> predicate) {
    if (tolerations == null) {
      return (A) this;
    }
    Iterator<TolerationBuilder> each = tolerations.iterator();
    List visitables = _visitables.get("tolerations");
    while (each.hasNext()) {
        TolerationBuilder builder = each.next();
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
  
  public EphemeralContainersNested<A> setNewEphemeralContainerLike(int index,EphemeralContainer item) {
    return new EphemeralContainersNested(index, item);
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
  
  public ReadinessGatesNested<A> setNewReadinessGateLike(int index,PodReadinessGate item) {
    return new ReadinessGatesNested(index, item);
  }
  
  public ResourceClaimsNested<A> setNewResourceClaimLike(int index,PodResourceClaim item) {
    return new ResourceClaimsNested(index, item);
  }
  
  public SchedulingGatesNested<A> setNewSchedulingGateLike(int index,PodSchedulingGate item) {
    return new SchedulingGatesNested(index, item);
  }
  
  public TolerationsNested<A> setNewTolerationLike(int index,Toleration item) {
    return new TolerationsNested(index, item);
  }
  
  public TopologySpreadConstraintsNested<A> setNewTopologySpreadConstraintLike(int index,TopologySpreadConstraint item) {
    return new TopologySpreadConstraintsNested(index, item);
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
    EphemeralContainerBuilder builder = new EphemeralContainerBuilder(item);
    if (index < 0 || index >= ephemeralContainers.size()) {
        _visitables.get("ephemeralContainers").add(builder);
        ephemeralContainers.add(builder);
    } else {
        _visitables.get("ephemeralContainers").add(builder);
        ephemeralContainers.set(index, builder);
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
  
  public A setToReadinessGates(int index,PodReadinessGate item) {
    if (this.readinessGates == null) {
      this.readinessGates = new ArrayList();
    }
    PodReadinessGateBuilder builder = new PodReadinessGateBuilder(item);
    if (index < 0 || index >= readinessGates.size()) {
        _visitables.get("readinessGates").add(builder);
        readinessGates.add(builder);
    } else {
        _visitables.get("readinessGates").add(builder);
        readinessGates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToResourceClaims(int index,PodResourceClaim item) {
    if (this.resourceClaims == null) {
      this.resourceClaims = new ArrayList();
    }
    PodResourceClaimBuilder builder = new PodResourceClaimBuilder(item);
    if (index < 0 || index >= resourceClaims.size()) {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.add(builder);
    } else {
        _visitables.get("resourceClaims").add(builder);
        resourceClaims.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSchedulingGates(int index,PodSchedulingGate item) {
    if (this.schedulingGates == null) {
      this.schedulingGates = new ArrayList();
    }
    PodSchedulingGateBuilder builder = new PodSchedulingGateBuilder(item);
    if (index < 0 || index >= schedulingGates.size()) {
        _visitables.get("schedulingGates").add(builder);
        schedulingGates.add(builder);
    } else {
        _visitables.get("schedulingGates").add(builder);
        schedulingGates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    TolerationBuilder builder = new TolerationBuilder(item);
    if (index < 0 || index >= tolerations.size()) {
        _visitables.get("tolerations").add(builder);
        tolerations.add(builder);
    } else {
        _visitables.get("tolerations").add(builder);
        tolerations.set(index, builder);
    }
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
    if (!(schedulingGroup == null)) {
        sb.append("schedulingGroup:");
        sb.append(schedulingGroup);
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
    this._visitables.remove("affinity");
    if (affinity != null) {
        this.affinity = new AffinityBuilder(affinity);
        this._visitables.get("affinity").add(this.affinity);
    } else {
        this.affinity = null;
        this._visitables.get("affinity").remove(this.affinity);
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
  
  public A withEnableServiceLinks() {
    return withEnableServiceLinks(true);
  }
  
  public A withEnableServiceLinks(Boolean enableServiceLinks) {
    this.enableServiceLinks = enableServiceLinks;
    return (A) this;
  }
  
  public A withEphemeralContainers(List<EphemeralContainer> ephemeralContainers) {
    if (this.ephemeralContainers != null) {
      this._visitables.get("ephemeralContainers").clear();
    }
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
  
  public AffinityNested<A> withNewAffinity() {
    return new AffinityNested(null);
  }
  
  public AffinityNested<A> withNewAffinityLike(Affinity item) {
    return new AffinityNested(item);
  }
  
  public DnsConfigNested<A> withNewDnsConfig() {
    return new DnsConfigNested(null);
  }
  
  public DnsConfigNested<A> withNewDnsConfigLike(PodDNSConfig item) {
    return new DnsConfigNested(item);
  }
  
  public OsNested<A> withNewOs() {
    return new OsNested(null);
  }
  
  public A withNewOs(String name) {
    return (A) this.withOs(new PodOS(name));
  }
  
  public OsNested<A> withNewOsLike(PodOS item) {
    return new OsNested(item);
  }
  
  public ResourcesNested<A> withNewResources() {
    return new ResourcesNested(null);
  }
  
  public ResourcesNested<A> withNewResourcesLike(ResourceRequirements item) {
    return new ResourcesNested(item);
  }
  
  public SchedulingGroupNested<A> withNewSchedulingGroup() {
    return new SchedulingGroupNested(null);
  }
  
  public A withNewSchedulingGroup(String podGroupName) {
    return (A) this.withSchedulingGroup(new PodSchedulingGroup(podGroupName));
  }
  
  public SchedulingGroupNested<A> withNewSchedulingGroupLike(PodSchedulingGroup item) {
    return new SchedulingGroupNested(item);
  }
  
  public SecurityContextNested<A> withNewSecurityContext() {
    return new SecurityContextNested(null);
  }
  
  public SecurityContextNested<A> withNewSecurityContextLike(PodSecurityContext item) {
    return new SecurityContextNested(item);
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
    this._visitables.remove("os");
    if (os != null) {
        this.os = new PodOSBuilder(os);
        this._visitables.get("os").add(this.os);
    } else {
        this.os = null;
        this._visitables.get("os").remove(this.os);
    }
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
    if (this.readinessGates != null) {
      this._visitables.get("readinessGates").clear();
    }
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
    if (this.resourceClaims != null) {
      this._visitables.get("resourceClaims").clear();
    }
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
    if (this.schedulingGates != null) {
      this._visitables.get("schedulingGates").clear();
    }
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
  
  public A withSchedulingGroup(PodSchedulingGroup schedulingGroup) {
    this._visitables.remove("schedulingGroup");
    if (schedulingGroup != null) {
        this.schedulingGroup = new PodSchedulingGroupBuilder(schedulingGroup);
        this._visitables.get("schedulingGroup").add(this.schedulingGroup);
    } else {
        this.schedulingGroup = null;
        this._visitables.get("schedulingGroup").remove(this.schedulingGroup);
    }
    return (A) this;
  }
  
  public A withSecurityContext(PodSecurityContext securityContext) {
    this._visitables.remove("securityContext");
    if (securityContext != null) {
        this.securityContext = new PodSecurityContextBuilder(securityContext);
        this._visitables.get("securityContext").add(this.securityContext);
    } else {
        this.securityContext = null;
        this._visitables.get("securityContext").remove(this.securityContext);
    }
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
  
  public A withTolerations(List<Toleration> tolerations) {
    if (this.tolerations != null) {
      this._visitables.get("tolerations").clear();
    }
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
  public class AffinityNested<N> extends AffinityFluent<AffinityNested<N>> implements Nested<N>{
  
    AffinityBuilder builder;
  
    AffinityNested(Affinity item) {
      this.builder = new AffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.withAffinity(builder.build());
    }
    
    public N endAffinity() {
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
      return (N) PodSpecFluent.this.setToContainers(index, builder.build());
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
      return (N) PodSpecFluent.this.withDnsConfig(builder.build());
    }
    
    public N endDnsConfig() {
      return and();
    }
    
  }
  public class EphemeralContainersNested<N> extends EphemeralContainerFluent<EphemeralContainersNested<N>> implements Nested<N>{
  
    EphemeralContainerBuilder builder;
    int index;
  
    EphemeralContainersNested(int index,EphemeralContainer item) {
      this.index = index;
      this.builder = new EphemeralContainerBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.setToEphemeralContainers(index, builder.build());
    }
    
    public N endEphemeralContainer() {
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
      return (N) PodSpecFluent.this.setToHostAliases(index, builder.build());
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
      return (N) PodSpecFluent.this.setToImagePullSecrets(index, builder.build());
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
      return (N) PodSpecFluent.this.setToInitContainers(index, builder.build());
    }
    
    public N endInitContainer() {
      return and();
    }
    
  }
  public class OsNested<N> extends PodOSFluent<OsNested<N>> implements Nested<N>{
  
    PodOSBuilder builder;
  
    OsNested(PodOS item) {
      this.builder = new PodOSBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.withOs(builder.build());
    }
    
    public N endOs() {
      return and();
    }
    
  }
  public class ReadinessGatesNested<N> extends PodReadinessGateFluent<ReadinessGatesNested<N>> implements Nested<N>{
  
    PodReadinessGateBuilder builder;
    int index;
  
    ReadinessGatesNested(int index,PodReadinessGate item) {
      this.index = index;
      this.builder = new PodReadinessGateBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.setToReadinessGates(index, builder.build());
    }
    
    public N endReadinessGate() {
      return and();
    }
    
  }
  public class ResourceClaimsNested<N> extends PodResourceClaimFluent<ResourceClaimsNested<N>> implements Nested<N>{
  
    PodResourceClaimBuilder builder;
    int index;
  
    ResourceClaimsNested(int index,PodResourceClaim item) {
      this.index = index;
      this.builder = new PodResourceClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.setToResourceClaims(index, builder.build());
    }
    
    public N endResourceClaim() {
      return and();
    }
    
  }
  public class ResourcesNested<N> extends ResourceRequirementsFluent<ResourcesNested<N>> implements Nested<N>{
  
    ResourceRequirementsBuilder builder;
  
    ResourcesNested(ResourceRequirements item) {
      this.builder = new ResourceRequirementsBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.withResources(builder.build());
    }
    
    public N endResources() {
      return and();
    }
    
  }
  public class SchedulingGatesNested<N> extends PodSchedulingGateFluent<SchedulingGatesNested<N>> implements Nested<N>{
  
    PodSchedulingGateBuilder builder;
    int index;
  
    SchedulingGatesNested(int index,PodSchedulingGate item) {
      this.index = index;
      this.builder = new PodSchedulingGateBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.setToSchedulingGates(index, builder.build());
    }
    
    public N endSchedulingGate() {
      return and();
    }
    
  }
  public class SchedulingGroupNested<N> extends PodSchedulingGroupFluent<SchedulingGroupNested<N>> implements Nested<N>{
  
    PodSchedulingGroupBuilder builder;
  
    SchedulingGroupNested(PodSchedulingGroup item) {
      this.builder = new PodSchedulingGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.withSchedulingGroup(builder.build());
    }
    
    public N endSchedulingGroup() {
      return and();
    }
    
  }
  public class SecurityContextNested<N> extends PodSecurityContextFluent<SecurityContextNested<N>> implements Nested<N>{
  
    PodSecurityContextBuilder builder;
  
    SecurityContextNested(PodSecurityContext item) {
      this.builder = new PodSecurityContextBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.withSecurityContext(builder.build());
    }
    
    public N endSecurityContext() {
      return and();
    }
    
  }
  public class TolerationsNested<N> extends TolerationFluent<TolerationsNested<N>> implements Nested<N>{
  
    TolerationBuilder builder;
    int index;
  
    TolerationsNested(int index,Toleration item) {
      this.index = index;
      this.builder = new TolerationBuilder(this, item);
    }
  
    public N and() {
      return (N) PodSpecFluent.this.setToTolerations(index, builder.build());
    }
    
    public N endToleration() {
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
      return (N) PodSpecFluent.this.setToTopologySpreadConstraints(index, builder.build());
    }
    
    public N endTopologySpreadConstraint() {
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
      return (N) PodSpecFluent.this.setToVolumes(index, builder.build());
    }
    
    public N endVolume() {
      return and();
    }
    
  }
}