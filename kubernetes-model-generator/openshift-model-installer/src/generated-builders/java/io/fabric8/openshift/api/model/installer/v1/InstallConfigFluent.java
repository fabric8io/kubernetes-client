package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Boolean;
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
public class InstallConfigFluent<A extends io.fabric8.openshift.api.model.installer.v1.InstallConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String additionalTrustBundle;
  private String additionalTrustBundlePolicy;
  private String apiVersion;
  private MachinePoolBuilder arbiter;
  private String baseDomain;
  private BootstrapInPlaceBuilder bootstrapInPlace;
  private CapabilitiesBuilder capabilities;
  private ArrayList<MachinePoolBuilder> compute = new ArrayList<MachinePoolBuilder>();
  private MachinePoolBuilder controlPlane;
  private String cpuPartitioningMode;
  private String credentialsMode;
  private List<String> featureGates = new ArrayList<String>();
  private String featureSet;
  private Boolean fips;
  private ArrayList<ImageContentSourceBuilder> imageContentSources = new ArrayList<ImageContentSourceBuilder>();
  private ArrayList<ImageDigestSourceBuilder> imageDigestSources = new ArrayList<ImageDigestSourceBuilder>();
  private String kind;
  private ObjectMetaBuilder metadata;
  private NetworkingBuilder networking;
  private OperatorPublishingStrategyBuilder operatorPublishingStrategy;
  private PlatformBuilder platform;
  private ProxyBuilder proxy;
  private String publish;
  private String pullSecret;
  private String sshKey;

  public InstallConfigFluent() {
  }
  
  public InstallConfigFluent(InstallConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToCompute(Collection<MachinePool> items) {
    if (this.compute == null) {
      this.compute = new ArrayList();
    }
    for (MachinePool item : items) {
        MachinePoolBuilder builder = new MachinePoolBuilder(item);
        _visitables.get("compute").add(builder);
        this.compute.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFeatureGates(Collection<String> items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (String item : items) {
      this.featureGates.add(item);
    }
    return (A) this;
  }
  
  public A addAllToImageContentSources(Collection<ImageContentSource> items) {
    if (this.imageContentSources == null) {
      this.imageContentSources = new ArrayList();
    }
    for (ImageContentSource item : items) {
        ImageContentSourceBuilder builder = new ImageContentSourceBuilder(item);
        _visitables.get("imageContentSources").add(builder);
        this.imageContentSources.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToImageDigestSources(Collection<ImageDigestSource> items) {
    if (this.imageDigestSources == null) {
      this.imageDigestSources = new ArrayList();
    }
    for (ImageDigestSource item : items) {
        ImageDigestSourceBuilder builder = new ImageDigestSourceBuilder(item);
        _visitables.get("imageDigestSources").add(builder);
        this.imageDigestSources.add(builder);
    }
    return (A) this;
  }
  
  public ComputeNested<A> addNewCompute() {
    return new ComputeNested(-1, null);
  }
  
  public ComputeNested<A> addNewComputeLike(MachinePool item) {
    return new ComputeNested(-1, item);
  }
  
  public ImageContentSourcesNested<A> addNewImageContentSource() {
    return new ImageContentSourcesNested(-1, null);
  }
  
  public ImageContentSourcesNested<A> addNewImageContentSourceLike(ImageContentSource item) {
    return new ImageContentSourcesNested(-1, item);
  }
  
  public ImageDigestSourcesNested<A> addNewImageDigestSource() {
    return new ImageDigestSourcesNested(-1, null);
  }
  
  public ImageDigestSourcesNested<A> addNewImageDigestSourceLike(ImageDigestSource item) {
    return new ImageDigestSourcesNested(-1, item);
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
  
  public A addToCompute(MachinePool... items) {
    if (this.compute == null) {
      this.compute = new ArrayList();
    }
    for (MachinePool item : items) {
        MachinePoolBuilder builder = new MachinePoolBuilder(item);
        _visitables.get("compute").add(builder);
        this.compute.add(builder);
    }
    return (A) this;
  }
  
  public A addToCompute(int index,MachinePool item) {
    if (this.compute == null) {
      this.compute = new ArrayList();
    }
    MachinePoolBuilder builder = new MachinePoolBuilder(item);
    if (index < 0 || index >= compute.size()) {
        _visitables.get("compute").add(builder);
        compute.add(builder);
    } else {
        _visitables.get("compute").add(builder);
        compute.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFeatureGates(String... items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (String item : items) {
      this.featureGates.add(item);
    }
    return (A) this;
  }
  
  public A addToFeatureGates(int index,String item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    this.featureGates.add(index, item);
    return (A) this;
  }
  
  public A addToImageContentSources(ImageContentSource... items) {
    if (this.imageContentSources == null) {
      this.imageContentSources = new ArrayList();
    }
    for (ImageContentSource item : items) {
        ImageContentSourceBuilder builder = new ImageContentSourceBuilder(item);
        _visitables.get("imageContentSources").add(builder);
        this.imageContentSources.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageContentSources(int index,ImageContentSource item) {
    if (this.imageContentSources == null) {
      this.imageContentSources = new ArrayList();
    }
    ImageContentSourceBuilder builder = new ImageContentSourceBuilder(item);
    if (index < 0 || index >= imageContentSources.size()) {
        _visitables.get("imageContentSources").add(builder);
        imageContentSources.add(builder);
    } else {
        _visitables.get("imageContentSources").add(builder);
        imageContentSources.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToImageDigestSources(ImageDigestSource... items) {
    if (this.imageDigestSources == null) {
      this.imageDigestSources = new ArrayList();
    }
    for (ImageDigestSource item : items) {
        ImageDigestSourceBuilder builder = new ImageDigestSourceBuilder(item);
        _visitables.get("imageDigestSources").add(builder);
        this.imageDigestSources.add(builder);
    }
    return (A) this;
  }
  
  public A addToImageDigestSources(int index,ImageDigestSource item) {
    if (this.imageDigestSources == null) {
      this.imageDigestSources = new ArrayList();
    }
    ImageDigestSourceBuilder builder = new ImageDigestSourceBuilder(item);
    if (index < 0 || index >= imageDigestSources.size()) {
        _visitables.get("imageDigestSources").add(builder);
        imageDigestSources.add(builder);
    } else {
        _visitables.get("imageDigestSources").add(builder);
        imageDigestSources.add(index, builder);
    }
    return (A) this;
  }
  
  public MachinePool buildArbiter() {
    return this.arbiter != null ? this.arbiter.build() : null;
  }
  
  public BootstrapInPlace buildBootstrapInPlace() {
    return this.bootstrapInPlace != null ? this.bootstrapInPlace.build() : null;
  }
  
  public Capabilities buildCapabilities() {
    return this.capabilities != null ? this.capabilities.build() : null;
  }
  
  public List<MachinePool> buildCompute() {
    return this.compute != null ? build(compute) : null;
  }
  
  public MachinePool buildCompute(int index) {
    return this.compute.get(index).build();
  }
  
  public MachinePool buildControlPlane() {
    return this.controlPlane != null ? this.controlPlane.build() : null;
  }
  
  public MachinePool buildFirstCompute() {
    return this.compute.get(0).build();
  }
  
  public ImageContentSource buildFirstImageContentSource() {
    return this.imageContentSources.get(0).build();
  }
  
  public ImageDigestSource buildFirstImageDigestSource() {
    return this.imageDigestSources.get(0).build();
  }
  
  public ImageContentSource buildImageContentSource(int index) {
    return this.imageContentSources.get(index).build();
  }
  
  public List<ImageContentSource> buildImageContentSources() {
    return this.imageContentSources != null ? build(imageContentSources) : null;
  }
  
  public ImageDigestSource buildImageDigestSource(int index) {
    return this.imageDigestSources.get(index).build();
  }
  
  public List<ImageDigestSource> buildImageDigestSources() {
    return this.imageDigestSources != null ? build(imageDigestSources) : null;
  }
  
  public MachinePool buildLastCompute() {
    return this.compute.get(compute.size() - 1).build();
  }
  
  public ImageContentSource buildLastImageContentSource() {
    return this.imageContentSources.get(imageContentSources.size() - 1).build();
  }
  
  public ImageDigestSource buildLastImageDigestSource() {
    return this.imageDigestSources.get(imageDigestSources.size() - 1).build();
  }
  
  public MachinePool buildMatchingCompute(Predicate<MachinePoolBuilder> predicate) {
      for (MachinePoolBuilder item : compute) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageContentSource buildMatchingImageContentSource(Predicate<ImageContentSourceBuilder> predicate) {
      for (ImageContentSourceBuilder item : imageContentSources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ImageDigestSource buildMatchingImageDigestSource(Predicate<ImageDigestSourceBuilder> predicate) {
      for (ImageDigestSourceBuilder item : imageDigestSources) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public Networking buildNetworking() {
    return this.networking != null ? this.networking.build() : null;
  }
  
  public OperatorPublishingStrategy buildOperatorPublishingStrategy() {
    return this.operatorPublishingStrategy != null ? this.operatorPublishingStrategy.build() : null;
  }
  
  public Platform buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  public Proxy buildProxy() {
    return this.proxy != null ? this.proxy.build() : null;
  }
  
  protected void copyInstance(InstallConfig instance) {
    instance = instance != null ? instance : new InstallConfig();
    if (instance != null) {
        this.withAdditionalTrustBundle(instance.getAdditionalTrustBundle());
        this.withAdditionalTrustBundlePolicy(instance.getAdditionalTrustBundlePolicy());
        this.withApiVersion(instance.getApiVersion());
        this.withArbiter(instance.getArbiter());
        this.withBaseDomain(instance.getBaseDomain());
        this.withBootstrapInPlace(instance.getBootstrapInPlace());
        this.withCapabilities(instance.getCapabilities());
        this.withCompute(instance.getCompute());
        this.withControlPlane(instance.getControlPlane());
        this.withCpuPartitioningMode(instance.getCpuPartitioningMode());
        this.withCredentialsMode(instance.getCredentialsMode());
        this.withFeatureGates(instance.getFeatureGates());
        this.withFeatureSet(instance.getFeatureSet());
        this.withFips(instance.getFips());
        this.withImageContentSources(instance.getImageContentSources());
        this.withImageDigestSources(instance.getImageDigestSources());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withNetworking(instance.getNetworking());
        this.withOperatorPublishingStrategy(instance.getOperatorPublishingStrategy());
        this.withPlatform(instance.getPlatform());
        this.withProxy(instance.getProxy());
        this.withPublish(instance.getPublish());
        this.withPullSecret(instance.getPullSecret());
        this.withSshKey(instance.getSshKey());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ArbiterNested<A> editArbiter() {
    return this.withNewArbiterLike(Optional.ofNullable(this.buildArbiter()).orElse(null));
  }
  
  public BootstrapInPlaceNested<A> editBootstrapInPlace() {
    return this.withNewBootstrapInPlaceLike(Optional.ofNullable(this.buildBootstrapInPlace()).orElse(null));
  }
  
  public CapabilitiesNested<A> editCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(null));
  }
  
  public ComputeNested<A> editCompute(int index) {
    if (compute.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "compute"));
    }
    return this.setNewComputeLike(index, this.buildCompute(index));
  }
  
  public ControlPlaneNested<A> editControlPlane() {
    return this.withNewControlPlaneLike(Optional.ofNullable(this.buildControlPlane()).orElse(null));
  }
  
  public ComputeNested<A> editFirstCompute() {
    if (compute.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "compute"));
    }
    return this.setNewComputeLike(0, this.buildCompute(0));
  }
  
  public ImageContentSourcesNested<A> editFirstImageContentSource() {
    if (imageContentSources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageContentSources"));
    }
    return this.setNewImageContentSourceLike(0, this.buildImageContentSource(0));
  }
  
  public ImageDigestSourcesNested<A> editFirstImageDigestSource() {
    if (imageDigestSources.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "imageDigestSources"));
    }
    return this.setNewImageDigestSourceLike(0, this.buildImageDigestSource(0));
  }
  
  public ImageContentSourcesNested<A> editImageContentSource(int index) {
    if (imageContentSources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageContentSources"));
    }
    return this.setNewImageContentSourceLike(index, this.buildImageContentSource(index));
  }
  
  public ImageDigestSourcesNested<A> editImageDigestSource(int index) {
    if (imageDigestSources.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "imageDigestSources"));
    }
    return this.setNewImageDigestSourceLike(index, this.buildImageDigestSource(index));
  }
  
  public ComputeNested<A> editLastCompute() {
    int index = compute.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "compute"));
    }
    return this.setNewComputeLike(index, this.buildCompute(index));
  }
  
  public ImageContentSourcesNested<A> editLastImageContentSource() {
    int index = imageContentSources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageContentSources"));
    }
    return this.setNewImageContentSourceLike(index, this.buildImageContentSource(index));
  }
  
  public ImageDigestSourcesNested<A> editLastImageDigestSource() {
    int index = imageDigestSources.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "imageDigestSources"));
    }
    return this.setNewImageDigestSourceLike(index, this.buildImageDigestSource(index));
  }
  
  public ComputeNested<A> editMatchingCompute(Predicate<MachinePoolBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < compute.size();i++) {
      if (predicate.test(compute.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "compute"));
    }
    return this.setNewComputeLike(index, this.buildCompute(index));
  }
  
  public ImageContentSourcesNested<A> editMatchingImageContentSource(Predicate<ImageContentSourceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageContentSources.size();i++) {
      if (predicate.test(imageContentSources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageContentSources"));
    }
    return this.setNewImageContentSourceLike(index, this.buildImageContentSource(index));
  }
  
  public ImageDigestSourcesNested<A> editMatchingImageDigestSource(Predicate<ImageDigestSourceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < imageDigestSources.size();i++) {
      if (predicate.test(imageDigestSources.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "imageDigestSources"));
    }
    return this.setNewImageDigestSourceLike(index, this.buildImageDigestSource(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public NetworkingNested<A> editNetworking() {
    return this.withNewNetworkingLike(Optional.ofNullable(this.buildNetworking()).orElse(null));
  }
  
  public OperatorPublishingStrategyNested<A> editOperatorPublishingStrategy() {
    return this.withNewOperatorPublishingStrategyLike(Optional.ofNullable(this.buildOperatorPublishingStrategy()).orElse(null));
  }
  
  public ArbiterNested<A> editOrNewArbiter() {
    return this.withNewArbiterLike(Optional.ofNullable(this.buildArbiter()).orElse(new MachinePoolBuilder().build()));
  }
  
  public ArbiterNested<A> editOrNewArbiterLike(MachinePool item) {
    return this.withNewArbiterLike(Optional.ofNullable(this.buildArbiter()).orElse(item));
  }
  
  public BootstrapInPlaceNested<A> editOrNewBootstrapInPlace() {
    return this.withNewBootstrapInPlaceLike(Optional.ofNullable(this.buildBootstrapInPlace()).orElse(new BootstrapInPlaceBuilder().build()));
  }
  
  public BootstrapInPlaceNested<A> editOrNewBootstrapInPlaceLike(BootstrapInPlace item) {
    return this.withNewBootstrapInPlaceLike(Optional.ofNullable(this.buildBootstrapInPlace()).orElse(item));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(new CapabilitiesBuilder().build()));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilitiesLike(Capabilities item) {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(item));
  }
  
  public ControlPlaneNested<A> editOrNewControlPlane() {
    return this.withNewControlPlaneLike(Optional.ofNullable(this.buildControlPlane()).orElse(new MachinePoolBuilder().build()));
  }
  
  public ControlPlaneNested<A> editOrNewControlPlaneLike(MachinePool item) {
    return this.withNewControlPlaneLike(Optional.ofNullable(this.buildControlPlane()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public NetworkingNested<A> editOrNewNetworking() {
    return this.withNewNetworkingLike(Optional.ofNullable(this.buildNetworking()).orElse(new NetworkingBuilder().build()));
  }
  
  public NetworkingNested<A> editOrNewNetworkingLike(Networking item) {
    return this.withNewNetworkingLike(Optional.ofNullable(this.buildNetworking()).orElse(item));
  }
  
  public OperatorPublishingStrategyNested<A> editOrNewOperatorPublishingStrategy() {
    return this.withNewOperatorPublishingStrategyLike(Optional.ofNullable(this.buildOperatorPublishingStrategy()).orElse(new OperatorPublishingStrategyBuilder().build()));
  }
  
  public OperatorPublishingStrategyNested<A> editOrNewOperatorPublishingStrategyLike(OperatorPublishingStrategy item) {
    return this.withNewOperatorPublishingStrategyLike(Optional.ofNullable(this.buildOperatorPublishingStrategy()).orElse(item));
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new PlatformBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(Platform item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public ProxyNested<A> editOrNewProxy() {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(new ProxyBuilder().build()));
  }
  
  public ProxyNested<A> editOrNewProxyLike(Proxy item) {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
  }
  
  public ProxyNested<A> editProxy() {
    return this.withNewProxyLike(Optional.ofNullable(this.buildProxy()).orElse(null));
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
    InstallConfigFluent that = (InstallConfigFluent) o;
    if (!(Objects.equals(additionalTrustBundle, that.additionalTrustBundle))) {
      return false;
    }
    if (!(Objects.equals(additionalTrustBundlePolicy, that.additionalTrustBundlePolicy))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(arbiter, that.arbiter))) {
      return false;
    }
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(bootstrapInPlace, that.bootstrapInPlace))) {
      return false;
    }
    if (!(Objects.equals(capabilities, that.capabilities))) {
      return false;
    }
    if (!(Objects.equals(compute, that.compute))) {
      return false;
    }
    if (!(Objects.equals(controlPlane, that.controlPlane))) {
      return false;
    }
    if (!(Objects.equals(cpuPartitioningMode, that.cpuPartitioningMode))) {
      return false;
    }
    if (!(Objects.equals(credentialsMode, that.credentialsMode))) {
      return false;
    }
    if (!(Objects.equals(featureGates, that.featureGates))) {
      return false;
    }
    if (!(Objects.equals(featureSet, that.featureSet))) {
      return false;
    }
    if (!(Objects.equals(fips, that.fips))) {
      return false;
    }
    if (!(Objects.equals(imageContentSources, that.imageContentSources))) {
      return false;
    }
    if (!(Objects.equals(imageDigestSources, that.imageDigestSources))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(networking, that.networking))) {
      return false;
    }
    if (!(Objects.equals(operatorPublishingStrategy, that.operatorPublishingStrategy))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(proxy, that.proxy))) {
      return false;
    }
    if (!(Objects.equals(publish, that.publish))) {
      return false;
    }
    if (!(Objects.equals(pullSecret, that.pullSecret))) {
      return false;
    }
    if (!(Objects.equals(sshKey, that.sshKey))) {
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
  
  public String getAdditionalTrustBundle() {
    return this.additionalTrustBundle;
  }
  
  public String getAdditionalTrustBundlePolicy() {
    return this.additionalTrustBundlePolicy;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getBaseDomain() {
    return this.baseDomain;
  }
  
  public String getCpuPartitioningMode() {
    return this.cpuPartitioningMode;
  }
  
  public String getCredentialsMode() {
    return this.credentialsMode;
  }
  
  public String getFeatureGate(int index) {
    return this.featureGates.get(index);
  }
  
  public List<String> getFeatureGates() {
    return this.featureGates;
  }
  
  public String getFeatureSet() {
    return this.featureSet;
  }
  
  public Boolean getFips() {
    return this.fips;
  }
  
  public String getFirstFeatureGate() {
    return this.featureGates.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastFeatureGate() {
    return this.featureGates.get(featureGates.size() - 1);
  }
  
  public String getMatchingFeatureGate(Predicate<String> predicate) {
      for (String item : featureGates) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPublish() {
    return this.publish;
  }
  
  public String getPullSecret() {
    return this.pullSecret;
  }
  
  public String getSshKey() {
    return this.sshKey;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalTrustBundle() {
    return this.additionalTrustBundle != null;
  }
  
  public boolean hasAdditionalTrustBundlePolicy() {
    return this.additionalTrustBundlePolicy != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasArbiter() {
    return this.arbiter != null;
  }
  
  public boolean hasBaseDomain() {
    return this.baseDomain != null;
  }
  
  public boolean hasBootstrapInPlace() {
    return this.bootstrapInPlace != null;
  }
  
  public boolean hasCapabilities() {
    return this.capabilities != null;
  }
  
  public boolean hasCompute() {
    return this.compute != null && !(this.compute.isEmpty());
  }
  
  public boolean hasControlPlane() {
    return this.controlPlane != null;
  }
  
  public boolean hasCpuPartitioningMode() {
    return this.cpuPartitioningMode != null;
  }
  
  public boolean hasCredentialsMode() {
    return this.credentialsMode != null;
  }
  
  public boolean hasFeatureGates() {
    return this.featureGates != null && !(this.featureGates.isEmpty());
  }
  
  public boolean hasFeatureSet() {
    return this.featureSet != null;
  }
  
  public boolean hasFips() {
    return this.fips != null;
  }
  
  public boolean hasImageContentSources() {
    return this.imageContentSources != null && !(this.imageContentSources.isEmpty());
  }
  
  public boolean hasImageDigestSources() {
    return this.imageDigestSources != null && !(this.imageDigestSources.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingCompute(Predicate<MachinePoolBuilder> predicate) {
      for (MachinePoolBuilder item : compute) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFeatureGate(Predicate<String> predicate) {
      for (String item : featureGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImageContentSource(Predicate<ImageContentSourceBuilder> predicate) {
      for (ImageContentSourceBuilder item : imageContentSources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingImageDigestSource(Predicate<ImageDigestSourceBuilder> predicate) {
      for (ImageDigestSourceBuilder item : imageDigestSources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNetworking() {
    return this.networking != null;
  }
  
  public boolean hasOperatorPublishingStrategy() {
    return this.operatorPublishingStrategy != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasProxy() {
    return this.proxy != null;
  }
  
  public boolean hasPublish() {
    return this.publish != null;
  }
  
  public boolean hasPullSecret() {
    return this.pullSecret != null;
  }
  
  public boolean hasSshKey() {
    return this.sshKey != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalTrustBundle, additionalTrustBundlePolicy, apiVersion, arbiter, baseDomain, bootstrapInPlace, capabilities, compute, controlPlane, cpuPartitioningMode, credentialsMode, featureGates, featureSet, fips, imageContentSources, imageDigestSources, kind, metadata, networking, operatorPublishingStrategy, platform, proxy, publish, pullSecret, sshKey, additionalProperties);
  }
  
  public A removeAllFromCompute(Collection<MachinePool> items) {
    if (this.compute == null) {
      return (A) this;
    }
    for (MachinePool item : items) {
        MachinePoolBuilder builder = new MachinePoolBuilder(item);
        _visitables.get("compute").remove(builder);
        this.compute.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFeatureGates(Collection<String> items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (String item : items) {
      this.featureGates.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromImageContentSources(Collection<ImageContentSource> items) {
    if (this.imageContentSources == null) {
      return (A) this;
    }
    for (ImageContentSource item : items) {
        ImageContentSourceBuilder builder = new ImageContentSourceBuilder(item);
        _visitables.get("imageContentSources").remove(builder);
        this.imageContentSources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromImageDigestSources(Collection<ImageDigestSource> items) {
    if (this.imageDigestSources == null) {
      return (A) this;
    }
    for (ImageDigestSource item : items) {
        ImageDigestSourceBuilder builder = new ImageDigestSourceBuilder(item);
        _visitables.get("imageDigestSources").remove(builder);
        this.imageDigestSources.remove(builder);
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
  
  public A removeFromCompute(MachinePool... items) {
    if (this.compute == null) {
      return (A) this;
    }
    for (MachinePool item : items) {
        MachinePoolBuilder builder = new MachinePoolBuilder(item);
        _visitables.get("compute").remove(builder);
        this.compute.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFeatureGates(String... items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (String item : items) {
      this.featureGates.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromImageContentSources(ImageContentSource... items) {
    if (this.imageContentSources == null) {
      return (A) this;
    }
    for (ImageContentSource item : items) {
        ImageContentSourceBuilder builder = new ImageContentSourceBuilder(item);
        _visitables.get("imageContentSources").remove(builder);
        this.imageContentSources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromImageDigestSources(ImageDigestSource... items) {
    if (this.imageDigestSources == null) {
      return (A) this;
    }
    for (ImageDigestSource item : items) {
        ImageDigestSourceBuilder builder = new ImageDigestSourceBuilder(item);
        _visitables.get("imageDigestSources").remove(builder);
        this.imageDigestSources.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCompute(Predicate<MachinePoolBuilder> predicate) {
    if (compute == null) {
      return (A) this;
    }
    Iterator<MachinePoolBuilder> each = compute.iterator();
    List visitables = _visitables.get("compute");
    while (each.hasNext()) {
        MachinePoolBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageContentSources(Predicate<ImageContentSourceBuilder> predicate) {
    if (imageContentSources == null) {
      return (A) this;
    }
    Iterator<ImageContentSourceBuilder> each = imageContentSources.iterator();
    List visitables = _visitables.get("imageContentSources");
    while (each.hasNext()) {
        ImageContentSourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromImageDigestSources(Predicate<ImageDigestSourceBuilder> predicate) {
    if (imageDigestSources == null) {
      return (A) this;
    }
    Iterator<ImageDigestSourceBuilder> each = imageDigestSources.iterator();
    List visitables = _visitables.get("imageDigestSources");
    while (each.hasNext()) {
        ImageDigestSourceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ComputeNested<A> setNewComputeLike(int index,MachinePool item) {
    return new ComputeNested(index, item);
  }
  
  public ImageContentSourcesNested<A> setNewImageContentSourceLike(int index,ImageContentSource item) {
    return new ImageContentSourcesNested(index, item);
  }
  
  public ImageDigestSourcesNested<A> setNewImageDigestSourceLike(int index,ImageDigestSource item) {
    return new ImageDigestSourcesNested(index, item);
  }
  
  public A setToCompute(int index,MachinePool item) {
    if (this.compute == null) {
      this.compute = new ArrayList();
    }
    MachinePoolBuilder builder = new MachinePoolBuilder(item);
    if (index < 0 || index >= compute.size()) {
        _visitables.get("compute").add(builder);
        compute.add(builder);
    } else {
        _visitables.get("compute").add(builder);
        compute.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFeatureGates(int index,String item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    this.featureGates.set(index, item);
    return (A) this;
  }
  
  public A setToImageContentSources(int index,ImageContentSource item) {
    if (this.imageContentSources == null) {
      this.imageContentSources = new ArrayList();
    }
    ImageContentSourceBuilder builder = new ImageContentSourceBuilder(item);
    if (index < 0 || index >= imageContentSources.size()) {
        _visitables.get("imageContentSources").add(builder);
        imageContentSources.add(builder);
    } else {
        _visitables.get("imageContentSources").add(builder);
        imageContentSources.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToImageDigestSources(int index,ImageDigestSource item) {
    if (this.imageDigestSources == null) {
      this.imageDigestSources = new ArrayList();
    }
    ImageDigestSourceBuilder builder = new ImageDigestSourceBuilder(item);
    if (index < 0 || index >= imageDigestSources.size()) {
        _visitables.get("imageDigestSources").add(builder);
        imageDigestSources.add(builder);
    } else {
        _visitables.get("imageDigestSources").add(builder);
        imageDigestSources.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalTrustBundle == null)) {
        sb.append("additionalTrustBundle:");
        sb.append(additionalTrustBundle);
        sb.append(",");
    }
    if (!(additionalTrustBundlePolicy == null)) {
        sb.append("additionalTrustBundlePolicy:");
        sb.append(additionalTrustBundlePolicy);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(arbiter == null)) {
        sb.append("arbiter:");
        sb.append(arbiter);
        sb.append(",");
    }
    if (!(baseDomain == null)) {
        sb.append("baseDomain:");
        sb.append(baseDomain);
        sb.append(",");
    }
    if (!(bootstrapInPlace == null)) {
        sb.append("bootstrapInPlace:");
        sb.append(bootstrapInPlace);
        sb.append(",");
    }
    if (!(capabilities == null)) {
        sb.append("capabilities:");
        sb.append(capabilities);
        sb.append(",");
    }
    if (!(compute == null) && !(compute.isEmpty())) {
        sb.append("compute:");
        sb.append(compute);
        sb.append(",");
    }
    if (!(controlPlane == null)) {
        sb.append("controlPlane:");
        sb.append(controlPlane);
        sb.append(",");
    }
    if (!(cpuPartitioningMode == null)) {
        sb.append("cpuPartitioningMode:");
        sb.append(cpuPartitioningMode);
        sb.append(",");
    }
    if (!(credentialsMode == null)) {
        sb.append("credentialsMode:");
        sb.append(credentialsMode);
        sb.append(",");
    }
    if (!(featureGates == null) && !(featureGates.isEmpty())) {
        sb.append("featureGates:");
        sb.append(featureGates);
        sb.append(",");
    }
    if (!(featureSet == null)) {
        sb.append("featureSet:");
        sb.append(featureSet);
        sb.append(",");
    }
    if (!(fips == null)) {
        sb.append("fips:");
        sb.append(fips);
        sb.append(",");
    }
    if (!(imageContentSources == null) && !(imageContentSources.isEmpty())) {
        sb.append("imageContentSources:");
        sb.append(imageContentSources);
        sb.append(",");
    }
    if (!(imageDigestSources == null) && !(imageDigestSources.isEmpty())) {
        sb.append("imageDigestSources:");
        sb.append(imageDigestSources);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(networking == null)) {
        sb.append("networking:");
        sb.append(networking);
        sb.append(",");
    }
    if (!(operatorPublishingStrategy == null)) {
        sb.append("operatorPublishingStrategy:");
        sb.append(operatorPublishingStrategy);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(proxy == null)) {
        sb.append("proxy:");
        sb.append(proxy);
        sb.append(",");
    }
    if (!(publish == null)) {
        sb.append("publish:");
        sb.append(publish);
        sb.append(",");
    }
    if (!(pullSecret == null)) {
        sb.append("pullSecret:");
        sb.append(pullSecret);
        sb.append(",");
    }
    if (!(sshKey == null)) {
        sb.append("sshKey:");
        sb.append(sshKey);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAdditionalTrustBundle(String additionalTrustBundle) {
    this.additionalTrustBundle = additionalTrustBundle;
    return (A) this;
  }
  
  public A withAdditionalTrustBundlePolicy(String additionalTrustBundlePolicy) {
    this.additionalTrustBundlePolicy = additionalTrustBundlePolicy;
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withArbiter(MachinePool arbiter) {
    this._visitables.remove("arbiter");
    if (arbiter != null) {
        this.arbiter = new MachinePoolBuilder(arbiter);
        this._visitables.get("arbiter").add(this.arbiter);
    } else {
        this.arbiter = null;
        this._visitables.get("arbiter").remove(this.arbiter);
    }
    return (A) this;
  }
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public A withBootstrapInPlace(BootstrapInPlace bootstrapInPlace) {
    this._visitables.remove("bootstrapInPlace");
    if (bootstrapInPlace != null) {
        this.bootstrapInPlace = new BootstrapInPlaceBuilder(bootstrapInPlace);
        this._visitables.get("bootstrapInPlace").add(this.bootstrapInPlace);
    } else {
        this.bootstrapInPlace = null;
        this._visitables.get("bootstrapInPlace").remove(this.bootstrapInPlace);
    }
    return (A) this;
  }
  
  public A withCapabilities(Capabilities capabilities) {
    this._visitables.remove("capabilities");
    if (capabilities != null) {
        this.capabilities = new CapabilitiesBuilder(capabilities);
        this._visitables.get("capabilities").add(this.capabilities);
    } else {
        this.capabilities = null;
        this._visitables.get("capabilities").remove(this.capabilities);
    }
    return (A) this;
  }
  
  public A withCompute(List<MachinePool> compute) {
    if (this.compute != null) {
      this._visitables.get("compute").clear();
    }
    if (compute != null) {
        this.compute = new ArrayList();
        for (MachinePool item : compute) {
          this.addToCompute(item);
        }
    } else {
      this.compute = null;
    }
    return (A) this;
  }
  
  public A withCompute(MachinePool... compute) {
    if (this.compute != null) {
        this.compute.clear();
        _visitables.remove("compute");
    }
    if (compute != null) {
      for (MachinePool item : compute) {
        this.addToCompute(item);
      }
    }
    return (A) this;
  }
  
  public A withControlPlane(MachinePool controlPlane) {
    this._visitables.remove("controlPlane");
    if (controlPlane != null) {
        this.controlPlane = new MachinePoolBuilder(controlPlane);
        this._visitables.get("controlPlane").add(this.controlPlane);
    } else {
        this.controlPlane = null;
        this._visitables.get("controlPlane").remove(this.controlPlane);
    }
    return (A) this;
  }
  
  public A withCpuPartitioningMode(String cpuPartitioningMode) {
    this.cpuPartitioningMode = cpuPartitioningMode;
    return (A) this;
  }
  
  public A withCredentialsMode(String credentialsMode) {
    this.credentialsMode = credentialsMode;
    return (A) this;
  }
  
  public A withFeatureGates(List<String> featureGates) {
    if (featureGates != null) {
        this.featureGates = new ArrayList();
        for (String item : featureGates) {
          this.addToFeatureGates(item);
        }
    } else {
      this.featureGates = null;
    }
    return (A) this;
  }
  
  public A withFeatureGates(String... featureGates) {
    if (this.featureGates != null) {
        this.featureGates.clear();
        _visitables.remove("featureGates");
    }
    if (featureGates != null) {
      for (String item : featureGates) {
        this.addToFeatureGates(item);
      }
    }
    return (A) this;
  }
  
  public A withFeatureSet(String featureSet) {
    this.featureSet = featureSet;
    return (A) this;
  }
  
  public A withFips() {
    return withFips(true);
  }
  
  public A withFips(Boolean fips) {
    this.fips = fips;
    return (A) this;
  }
  
  public A withImageContentSources(List<ImageContentSource> imageContentSources) {
    if (this.imageContentSources != null) {
      this._visitables.get("imageContentSources").clear();
    }
    if (imageContentSources != null) {
        this.imageContentSources = new ArrayList();
        for (ImageContentSource item : imageContentSources) {
          this.addToImageContentSources(item);
        }
    } else {
      this.imageContentSources = null;
    }
    return (A) this;
  }
  
  public A withImageContentSources(ImageContentSource... imageContentSources) {
    if (this.imageContentSources != null) {
        this.imageContentSources.clear();
        _visitables.remove("imageContentSources");
    }
    if (imageContentSources != null) {
      for (ImageContentSource item : imageContentSources) {
        this.addToImageContentSources(item);
      }
    }
    return (A) this;
  }
  
  public A withImageDigestSources(List<ImageDigestSource> imageDigestSources) {
    if (this.imageDigestSources != null) {
      this._visitables.get("imageDigestSources").clear();
    }
    if (imageDigestSources != null) {
        this.imageDigestSources = new ArrayList();
        for (ImageDigestSource item : imageDigestSources) {
          this.addToImageDigestSources(item);
        }
    } else {
      this.imageDigestSources = null;
    }
    return (A) this;
  }
  
  public A withImageDigestSources(ImageDigestSource... imageDigestSources) {
    if (this.imageDigestSources != null) {
        this.imageDigestSources.clear();
        _visitables.remove("imageDigestSources");
    }
    if (imageDigestSources != null) {
      for (ImageDigestSource item : imageDigestSources) {
        this.addToImageDigestSources(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public A withNetworking(Networking networking) {
    this._visitables.remove("networking");
    if (networking != null) {
        this.networking = new NetworkingBuilder(networking);
        this._visitables.get("networking").add(this.networking);
    } else {
        this.networking = null;
        this._visitables.get("networking").remove(this.networking);
    }
    return (A) this;
  }
  
  public ArbiterNested<A> withNewArbiter() {
    return new ArbiterNested(null);
  }
  
  public ArbiterNested<A> withNewArbiterLike(MachinePool item) {
    return new ArbiterNested(item);
  }
  
  public BootstrapInPlaceNested<A> withNewBootstrapInPlace() {
    return new BootstrapInPlaceNested(null);
  }
  
  public A withNewBootstrapInPlace(String installationDisk) {
    return (A) this.withBootstrapInPlace(new BootstrapInPlace(installationDisk));
  }
  
  public BootstrapInPlaceNested<A> withNewBootstrapInPlaceLike(BootstrapInPlace item) {
    return new BootstrapInPlaceNested(item);
  }
  
  public CapabilitiesNested<A> withNewCapabilities() {
    return new CapabilitiesNested(null);
  }
  
  public CapabilitiesNested<A> withNewCapabilitiesLike(Capabilities item) {
    return new CapabilitiesNested(item);
  }
  
  public ControlPlaneNested<A> withNewControlPlane() {
    return new ControlPlaneNested(null);
  }
  
  public ControlPlaneNested<A> withNewControlPlaneLike(MachinePool item) {
    return new ControlPlaneNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public NetworkingNested<A> withNewNetworking() {
    return new NetworkingNested(null);
  }
  
  public NetworkingNested<A> withNewNetworkingLike(Networking item) {
    return new NetworkingNested(item);
  }
  
  public OperatorPublishingStrategyNested<A> withNewOperatorPublishingStrategy() {
    return new OperatorPublishingStrategyNested(null);
  }
  
  public A withNewOperatorPublishingStrategy(String apiserver,String ingress) {
    return (A) this.withOperatorPublishingStrategy(new OperatorPublishingStrategy(apiserver, ingress));
  }
  
  public OperatorPublishingStrategyNested<A> withNewOperatorPublishingStrategyLike(OperatorPublishingStrategy item) {
    return new OperatorPublishingStrategyNested(item);
  }
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(Platform item) {
    return new PlatformNested(item);
  }
  
  public ProxyNested<A> withNewProxy() {
    return new ProxyNested(null);
  }
  
  public A withNewProxy(String httpProxy,String httpsProxy,String noProxy) {
    return (A) this.withProxy(new Proxy(httpProxy, httpsProxy, noProxy));
  }
  
  public ProxyNested<A> withNewProxyLike(Proxy item) {
    return new ProxyNested(item);
  }
  
  public A withOperatorPublishingStrategy(OperatorPublishingStrategy operatorPublishingStrategy) {
    this._visitables.remove("operatorPublishingStrategy");
    if (operatorPublishingStrategy != null) {
        this.operatorPublishingStrategy = new OperatorPublishingStrategyBuilder(operatorPublishingStrategy);
        this._visitables.get("operatorPublishingStrategy").add(this.operatorPublishingStrategy);
    } else {
        this.operatorPublishingStrategy = null;
        this._visitables.get("operatorPublishingStrategy").remove(this.operatorPublishingStrategy);
    }
    return (A) this;
  }
  
  public A withPlatform(Platform platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new PlatformBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  
  public A withProxy(Proxy proxy) {
    this._visitables.remove("proxy");
    if (proxy != null) {
        this.proxy = new ProxyBuilder(proxy);
        this._visitables.get("proxy").add(this.proxy);
    } else {
        this.proxy = null;
        this._visitables.get("proxy").remove(this.proxy);
    }
    return (A) this;
  }
  
  public A withPublish(String publish) {
    this.publish = publish;
    return (A) this;
  }
  
  public A withPullSecret(String pullSecret) {
    this.pullSecret = pullSecret;
    return (A) this;
  }
  
  public A withSshKey(String sshKey) {
    this.sshKey = sshKey;
    return (A) this;
  }
  public class ArbiterNested<N> extends MachinePoolFluent<ArbiterNested<N>> implements Nested<N>{
  
    MachinePoolBuilder builder;
  
    ArbiterNested(MachinePool item) {
      this.builder = new MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withArbiter(builder.build());
    }
    
    public N endArbiter() {
      return and();
    }
    
  }
  public class BootstrapInPlaceNested<N> extends BootstrapInPlaceFluent<BootstrapInPlaceNested<N>> implements Nested<N>{
  
    BootstrapInPlaceBuilder builder;
  
    BootstrapInPlaceNested(BootstrapInPlace item) {
      this.builder = new BootstrapInPlaceBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withBootstrapInPlace(builder.build());
    }
    
    public N endBootstrapInPlace() {
      return and();
    }
    
  }
  public class CapabilitiesNested<N> extends CapabilitiesFluent<CapabilitiesNested<N>> implements Nested<N>{
  
    CapabilitiesBuilder builder;
  
    CapabilitiesNested(Capabilities item) {
      this.builder = new CapabilitiesBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withCapabilities(builder.build());
    }
    
    public N endCapabilities() {
      return and();
    }
    
  }
  public class ComputeNested<N> extends MachinePoolFluent<ComputeNested<N>> implements Nested<N>{
  
    MachinePoolBuilder builder;
    int index;
  
    ComputeNested(int index,MachinePool item) {
      this.index = index;
      this.builder = new MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.setToCompute(index, builder.build());
    }
    
    public N endCompute() {
      return and();
    }
    
  }
  public class ControlPlaneNested<N> extends MachinePoolFluent<ControlPlaneNested<N>> implements Nested<N>{
  
    MachinePoolBuilder builder;
  
    ControlPlaneNested(MachinePool item) {
      this.builder = new MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withControlPlane(builder.build());
    }
    
    public N endControlPlane() {
      return and();
    }
    
  }
  public class ImageContentSourcesNested<N> extends ImageContentSourceFluent<ImageContentSourcesNested<N>> implements Nested<N>{
  
    ImageContentSourceBuilder builder;
    int index;
  
    ImageContentSourcesNested(int index,ImageContentSource item) {
      this.index = index;
      this.builder = new ImageContentSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.setToImageContentSources(index, builder.build());
    }
    
    public N endImageContentSource() {
      return and();
    }
    
  }
  public class ImageDigestSourcesNested<N> extends ImageDigestSourceFluent<ImageDigestSourcesNested<N>> implements Nested<N>{
  
    ImageDigestSourceBuilder builder;
    int index;
  
    ImageDigestSourcesNested(int index,ImageDigestSource item) {
      this.index = index;
      this.builder = new ImageDigestSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.setToImageDigestSources(index, builder.build());
    }
    
    public N endImageDigestSource() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class NetworkingNested<N> extends NetworkingFluent<NetworkingNested<N>> implements Nested<N>{
  
    NetworkingBuilder builder;
  
    NetworkingNested(Networking item) {
      this.builder = new NetworkingBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withNetworking(builder.build());
    }
    
    public N endNetworking() {
      return and();
    }
    
  }
  public class OperatorPublishingStrategyNested<N> extends OperatorPublishingStrategyFluent<OperatorPublishingStrategyNested<N>> implements Nested<N>{
  
    OperatorPublishingStrategyBuilder builder;
  
    OperatorPublishingStrategyNested(OperatorPublishingStrategy item) {
      this.builder = new OperatorPublishingStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withOperatorPublishingStrategy(builder.build());
    }
    
    public N endOperatorPublishingStrategy() {
      return and();
    }
    
  }
  public class PlatformNested<N> extends PlatformFluent<PlatformNested<N>> implements Nested<N>{
  
    PlatformBuilder builder;
  
    PlatformNested(Platform item) {
      this.builder = new PlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
  public class ProxyNested<N> extends ProxyFluent<ProxyNested<N>> implements Nested<N>{
  
    ProxyBuilder builder;
  
    ProxyNested(Proxy item) {
      this.builder = new ProxyBuilder(this, item);
    }
  
    public N and() {
      return (N) InstallConfigFluent.this.withProxy(builder.build());
    }
    
    public N endProxy() {
      return and();
    }
    
  }
}