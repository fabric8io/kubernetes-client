package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Integer;
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
public class PowerVSMachineProviderConfigFluent<A extends io.fabric8.openshift.api.model.machine.v1.PowerVSMachineProviderConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private PowerVSSecretReferenceBuilder credentialsSecret;
  private PowerVSResourceBuilder image;
  private String keyPairName;
  private String kind;
  private ArrayList<LoadBalancerReferenceBuilder> loadBalancers = new ArrayList<LoadBalancerReferenceBuilder>();
  private Integer memoryGiB;
  private ObjectMetaBuilder metadata;
  private PowerVSResourceBuilder network;
  private String processorType;
  private IntOrStringBuilder processors;
  private PowerVSResourceBuilder serviceInstance;
  private String systemType;
  private PowerVSSecretReferenceBuilder userDataSecret;

  public PowerVSMachineProviderConfigFluent() {
  }
  
  public PowerVSMachineProviderConfigFluent(PowerVSMachineProviderConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToLoadBalancers(Collection<LoadBalancerReference> items) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").add(builder);
        this.loadBalancers.add(builder);
    }
    return (A) this;
  }
  
  public LoadBalancersNested<A> addNewLoadBalancer() {
    return new LoadBalancersNested(-1, null);
  }
  
  public A addNewLoadBalancer(String name,String type) {
    return (A) this.addToLoadBalancers(new LoadBalancerReference(name, type));
  }
  
  public LoadBalancersNested<A> addNewLoadBalancerLike(LoadBalancerReference item) {
    return new LoadBalancersNested(-1, item);
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
  
  public A addToLoadBalancers(LoadBalancerReference... items) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").add(builder);
        this.loadBalancers.add(builder);
    }
    return (A) this;
  }
  
  public A addToLoadBalancers(int index,LoadBalancerReference item) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
    if (index < 0 || index >= loadBalancers.size()) {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.add(builder);
    } else {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.add(index, builder);
    }
    return (A) this;
  }
  
  public PowerVSSecretReference buildCredentialsSecret() {
    return this.credentialsSecret != null ? this.credentialsSecret.build() : null;
  }
  
  public LoadBalancerReference buildFirstLoadBalancer() {
    return this.loadBalancers.get(0).build();
  }
  
  public PowerVSResource buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public LoadBalancerReference buildLastLoadBalancer() {
    return this.loadBalancers.get(loadBalancers.size() - 1).build();
  }
  
  public LoadBalancerReference buildLoadBalancer(int index) {
    return this.loadBalancers.get(index).build();
  }
  
  public List<LoadBalancerReference> buildLoadBalancers() {
    return this.loadBalancers != null ? build(loadBalancers) : null;
  }
  
  public LoadBalancerReference buildMatchingLoadBalancer(Predicate<LoadBalancerReferenceBuilder> predicate) {
      for (LoadBalancerReferenceBuilder item : loadBalancers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public PowerVSResource buildNetwork() {
    return this.network != null ? this.network.build() : null;
  }
  
  public IntOrString buildProcessors() {
    return this.processors != null ? this.processors.build() : null;
  }
  
  public PowerVSResource buildServiceInstance() {
    return this.serviceInstance != null ? this.serviceInstance.build() : null;
  }
  
  public PowerVSSecretReference buildUserDataSecret() {
    return this.userDataSecret != null ? this.userDataSecret.build() : null;
  }
  
  protected void copyInstance(PowerVSMachineProviderConfig instance) {
    instance = instance != null ? instance : new PowerVSMachineProviderConfig();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withCredentialsSecret(instance.getCredentialsSecret());
        this.withImage(instance.getImage());
        this.withKeyPairName(instance.getKeyPairName());
        this.withKind(instance.getKind());
        this.withLoadBalancers(instance.getLoadBalancers());
        this.withMemoryGiB(instance.getMemoryGiB());
        this.withMetadata(instance.getMetadata());
        this.withNetwork(instance.getNetwork());
        this.withProcessorType(instance.getProcessorType());
        this.withProcessors(instance.getProcessors());
        this.withServiceInstance(instance.getServiceInstance());
        this.withSystemType(instance.getSystemType());
        this.withUserDataSecret(instance.getUserDataSecret());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CredentialsSecretNested<A> editCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(null));
  }
  
  public LoadBalancersNested<A> editFirstLoadBalancer() {
    if (loadBalancers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(0, this.buildLoadBalancer(0));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public LoadBalancersNested<A> editLastLoadBalancer() {
    int index = loadBalancers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(index, this.buildLoadBalancer(index));
  }
  
  public LoadBalancersNested<A> editLoadBalancer(int index) {
    if (loadBalancers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(index, this.buildLoadBalancer(index));
  }
  
  public LoadBalancersNested<A> editMatchingLoadBalancer(Predicate<LoadBalancerReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < loadBalancers.size();i++) {
      if (predicate.test(loadBalancers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "loadBalancers"));
    }
    return this.setNewLoadBalancerLike(index, this.buildLoadBalancer(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public NetworkNested<A> editNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(null));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecret() {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(new PowerVSSecretReferenceBuilder().build()));
  }
  
  public CredentialsSecretNested<A> editOrNewCredentialsSecretLike(PowerVSSecretReference item) {
    return this.withNewCredentialsSecretLike(Optional.ofNullable(this.buildCredentialsSecret()).orElse(item));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new PowerVSResourceBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(PowerVSResource item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public NetworkNested<A> editOrNewNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(new PowerVSResourceBuilder().build()));
  }
  
  public NetworkNested<A> editOrNewNetworkLike(PowerVSResource item) {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(item));
  }
  
  public ProcessorsNested<A> editOrNewProcessors() {
    return this.withNewProcessorsLike(Optional.ofNullable(this.buildProcessors()).orElse(new IntOrStringBuilder().build()));
  }
  
  public ProcessorsNested<A> editOrNewProcessorsLike(IntOrString item) {
    return this.withNewProcessorsLike(Optional.ofNullable(this.buildProcessors()).orElse(item));
  }
  
  public ServiceInstanceNested<A> editOrNewServiceInstance() {
    return this.withNewServiceInstanceLike(Optional.ofNullable(this.buildServiceInstance()).orElse(new PowerVSResourceBuilder().build()));
  }
  
  public ServiceInstanceNested<A> editOrNewServiceInstanceLike(PowerVSResource item) {
    return this.withNewServiceInstanceLike(Optional.ofNullable(this.buildServiceInstance()).orElse(item));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(new PowerVSSecretReferenceBuilder().build()));
  }
  
  public UserDataSecretNested<A> editOrNewUserDataSecretLike(PowerVSSecretReference item) {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(item));
  }
  
  public ProcessorsNested<A> editProcessors() {
    return this.withNewProcessorsLike(Optional.ofNullable(this.buildProcessors()).orElse(null));
  }
  
  public ServiceInstanceNested<A> editServiceInstance() {
    return this.withNewServiceInstanceLike(Optional.ofNullable(this.buildServiceInstance()).orElse(null));
  }
  
  public UserDataSecretNested<A> editUserDataSecret() {
    return this.withNewUserDataSecretLike(Optional.ofNullable(this.buildUserDataSecret()).orElse(null));
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
    PowerVSMachineProviderConfigFluent that = (PowerVSMachineProviderConfigFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecret, that.credentialsSecret))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(keyPairName, that.keyPairName))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(loadBalancers, that.loadBalancers))) {
      return false;
    }
    if (!(Objects.equals(memoryGiB, that.memoryGiB))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(processorType, that.processorType))) {
      return false;
    }
    if (!(Objects.equals(processors, that.processors))) {
      return false;
    }
    if (!(Objects.equals(serviceInstance, that.serviceInstance))) {
      return false;
    }
    if (!(Objects.equals(systemType, that.systemType))) {
      return false;
    }
    if (!(Objects.equals(userDataSecret, that.userDataSecret))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKeyPairName() {
    return this.keyPairName;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Integer getMemoryGiB() {
    return this.memoryGiB;
  }
  
  public String getProcessorType() {
    return this.processorType;
  }
  
  public String getSystemType() {
    return this.systemType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasCredentialsSecret() {
    return this.credentialsSecret != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasKeyPairName() {
    return this.keyPairName != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasLoadBalancers() {
    return this.loadBalancers != null && !(this.loadBalancers.isEmpty());
  }
  
  public boolean hasMatchingLoadBalancer(Predicate<LoadBalancerReferenceBuilder> predicate) {
      for (LoadBalancerReferenceBuilder item : loadBalancers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemoryGiB() {
    return this.memoryGiB != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasProcessorType() {
    return this.processorType != null;
  }
  
  public boolean hasProcessors() {
    return this.processors != null;
  }
  
  public boolean hasServiceInstance() {
    return this.serviceInstance != null;
  }
  
  public boolean hasSystemType() {
    return this.systemType != null;
  }
  
  public boolean hasUserDataSecret() {
    return this.userDataSecret != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, credentialsSecret, image, keyPairName, kind, loadBalancers, memoryGiB, metadata, network, processorType, processors, serviceInstance, systemType, userDataSecret, additionalProperties);
  }
  
  public A removeAllFromLoadBalancers(Collection<LoadBalancerReference> items) {
    if (this.loadBalancers == null) {
      return (A) this;
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").remove(builder);
        this.loadBalancers.remove(builder);
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
  
  public A removeFromLoadBalancers(LoadBalancerReference... items) {
    if (this.loadBalancers == null) {
      return (A) this;
    }
    for (LoadBalancerReference item : items) {
        LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
        _visitables.get("loadBalancers").remove(builder);
        this.loadBalancers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromLoadBalancers(Predicate<LoadBalancerReferenceBuilder> predicate) {
    if (loadBalancers == null) {
      return (A) this;
    }
    Iterator<LoadBalancerReferenceBuilder> each = loadBalancers.iterator();
    List visitables = _visitables.get("loadBalancers");
    while (each.hasNext()) {
        LoadBalancerReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public LoadBalancersNested<A> setNewLoadBalancerLike(int index,LoadBalancerReference item) {
    return new LoadBalancersNested(index, item);
  }
  
  public A setToLoadBalancers(int index,LoadBalancerReference item) {
    if (this.loadBalancers == null) {
      this.loadBalancers = new ArrayList();
    }
    LoadBalancerReferenceBuilder builder = new LoadBalancerReferenceBuilder(item);
    if (index < 0 || index >= loadBalancers.size()) {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.add(builder);
    } else {
        _visitables.get("loadBalancers").add(builder);
        loadBalancers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(credentialsSecret == null)) {
        sb.append("credentialsSecret:");
        sb.append(credentialsSecret);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(keyPairName == null)) {
        sb.append("keyPairName:");
        sb.append(keyPairName);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(loadBalancers == null) && !(loadBalancers.isEmpty())) {
        sb.append("loadBalancers:");
        sb.append(loadBalancers);
        sb.append(",");
    }
    if (!(memoryGiB == null)) {
        sb.append("memoryGiB:");
        sb.append(memoryGiB);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(processorType == null)) {
        sb.append("processorType:");
        sb.append(processorType);
        sb.append(",");
    }
    if (!(processors == null)) {
        sb.append("processors:");
        sb.append(processors);
        sb.append(",");
    }
    if (!(serviceInstance == null)) {
        sb.append("serviceInstance:");
        sb.append(serviceInstance);
        sb.append(",");
    }
    if (!(systemType == null)) {
        sb.append("systemType:");
        sb.append(systemType);
        sb.append(",");
    }
    if (!(userDataSecret == null)) {
        sb.append("userDataSecret:");
        sb.append(userDataSecret);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withCredentialsSecret(PowerVSSecretReference credentialsSecret) {
    this._visitables.remove("credentialsSecret");
    if (credentialsSecret != null) {
        this.credentialsSecret = new PowerVSSecretReferenceBuilder(credentialsSecret);
        this._visitables.get("credentialsSecret").add(this.credentialsSecret);
    } else {
        this.credentialsSecret = null;
        this._visitables.get("credentialsSecret").remove(this.credentialsSecret);
    }
    return (A) this;
  }
  
  public A withImage(PowerVSResource image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new PowerVSResourceBuilder(image);
        this._visitables.get("image").add(this.image);
    } else {
        this.image = null;
        this._visitables.get("image").remove(this.image);
    }
    return (A) this;
  }
  
  public A withKeyPairName(String keyPairName) {
    this.keyPairName = keyPairName;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withLoadBalancers(List<LoadBalancerReference> loadBalancers) {
    if (this.loadBalancers != null) {
      this._visitables.get("loadBalancers").clear();
    }
    if (loadBalancers != null) {
        this.loadBalancers = new ArrayList();
        for (LoadBalancerReference item : loadBalancers) {
          this.addToLoadBalancers(item);
        }
    } else {
      this.loadBalancers = null;
    }
    return (A) this;
  }
  
  public A withLoadBalancers(LoadBalancerReference... loadBalancers) {
    if (this.loadBalancers != null) {
        this.loadBalancers.clear();
        _visitables.remove("loadBalancers");
    }
    if (loadBalancers != null) {
      for (LoadBalancerReference item : loadBalancers) {
        this.addToLoadBalancers(item);
      }
    }
    return (A) this;
  }
  
  public A withMemoryGiB(Integer memoryGiB) {
    this.memoryGiB = memoryGiB;
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
  
  public A withNetwork(PowerVSResource network) {
    this._visitables.remove("network");
    if (network != null) {
        this.network = new PowerVSResourceBuilder(network);
        this._visitables.get("network").add(this.network);
    } else {
        this.network = null;
        this._visitables.get("network").remove(this.network);
    }
    return (A) this;
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecret() {
    return new CredentialsSecretNested(null);
  }
  
  public A withNewCredentialsSecret(String name) {
    return (A) this.withCredentialsSecret(new PowerVSSecretReference(name));
  }
  
  public CredentialsSecretNested<A> withNewCredentialsSecretLike(PowerVSSecretReference item) {
    return new CredentialsSecretNested(item);
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public A withNewImage(String id,String name,String regex,String type) {
    return (A) this.withImage(new PowerVSResource(id, name, regex, type));
  }
  
  public ImageNested<A> withNewImageLike(PowerVSResource item) {
    return new ImageNested(item);
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public NetworkNested<A> withNewNetwork() {
    return new NetworkNested(null);
  }
  
  public A withNewNetwork(String id,String name,String regex,String type) {
    return (A) this.withNetwork(new PowerVSResource(id, name, regex, type));
  }
  
  public NetworkNested<A> withNewNetworkLike(PowerVSResource item) {
    return new NetworkNested(item);
  }
  
  public ProcessorsNested<A> withNewProcessors() {
    return new ProcessorsNested(null);
  }
  
  public A withNewProcessors(Object value) {
    return (A) this.withProcessors(new IntOrString(value));
  }
  
  public ProcessorsNested<A> withNewProcessorsLike(IntOrString item) {
    return new ProcessorsNested(item);
  }
  
  public ServiceInstanceNested<A> withNewServiceInstance() {
    return new ServiceInstanceNested(null);
  }
  
  public A withNewServiceInstance(String id,String name,String regex,String type) {
    return (A) this.withServiceInstance(new PowerVSResource(id, name, regex, type));
  }
  
  public ServiceInstanceNested<A> withNewServiceInstanceLike(PowerVSResource item) {
    return new ServiceInstanceNested(item);
  }
  
  public UserDataSecretNested<A> withNewUserDataSecret() {
    return new UserDataSecretNested(null);
  }
  
  public A withNewUserDataSecret(String name) {
    return (A) this.withUserDataSecret(new PowerVSSecretReference(name));
  }
  
  public UserDataSecretNested<A> withNewUserDataSecretLike(PowerVSSecretReference item) {
    return new UserDataSecretNested(item);
  }
  
  public A withProcessorType(String processorType) {
    this.processorType = processorType;
    return (A) this;
  }
  
  public A withProcessors(IntOrString processors) {
    this._visitables.remove("processors");
    if (processors != null) {
        this.processors = new IntOrStringBuilder(processors);
        this._visitables.get("processors").add(this.processors);
    } else {
        this.processors = null;
        this._visitables.get("processors").remove(this.processors);
    }
    return (A) this;
  }
  
  public A withServiceInstance(PowerVSResource serviceInstance) {
    this._visitables.remove("serviceInstance");
    if (serviceInstance != null) {
        this.serviceInstance = new PowerVSResourceBuilder(serviceInstance);
        this._visitables.get("serviceInstance").add(this.serviceInstance);
    } else {
        this.serviceInstance = null;
        this._visitables.get("serviceInstance").remove(this.serviceInstance);
    }
    return (A) this;
  }
  
  public A withSystemType(String systemType) {
    this.systemType = systemType;
    return (A) this;
  }
  
  public A withUserDataSecret(PowerVSSecretReference userDataSecret) {
    this._visitables.remove("userDataSecret");
    if (userDataSecret != null) {
        this.userDataSecret = new PowerVSSecretReferenceBuilder(userDataSecret);
        this._visitables.get("userDataSecret").add(this.userDataSecret);
    } else {
        this.userDataSecret = null;
        this._visitables.get("userDataSecret").remove(this.userDataSecret);
    }
    return (A) this;
  }
  public class CredentialsSecretNested<N> extends PowerVSSecretReferenceFluent<CredentialsSecretNested<N>> implements Nested<N>{
  
    PowerVSSecretReferenceBuilder builder;
  
    CredentialsSecretNested(PowerVSSecretReference item) {
      this.builder = new PowerVSSecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.withCredentialsSecret(builder.build());
    }
    
    public N endCredentialsSecret() {
      return and();
    }
    
  }
  public class ImageNested<N> extends PowerVSResourceFluent<ImageNested<N>> implements Nested<N>{
  
    PowerVSResourceBuilder builder;
  
    ImageNested(PowerVSResource item) {
      this.builder = new PowerVSResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class LoadBalancersNested<N> extends LoadBalancerReferenceFluent<LoadBalancersNested<N>> implements Nested<N>{
  
    LoadBalancerReferenceBuilder builder;
    int index;
  
    LoadBalancersNested(int index,LoadBalancerReference item) {
      this.index = index;
      this.builder = new LoadBalancerReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.setToLoadBalancers(index, builder.build());
    }
    
    public N endLoadBalancer() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class NetworkNested<N> extends PowerVSResourceFluent<NetworkNested<N>> implements Nested<N>{
  
    PowerVSResourceBuilder builder;
  
    NetworkNested(PowerVSResource item) {
      this.builder = new PowerVSResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.withNetwork(builder.build());
    }
    
    public N endNetwork() {
      return and();
    }
    
  }
  public class ProcessorsNested<N> extends IntOrStringFluent<ProcessorsNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    ProcessorsNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.withProcessors(builder.build());
    }
    
    public N endProcessors() {
      return and();
    }
    
  }
  public class ServiceInstanceNested<N> extends PowerVSResourceFluent<ServiceInstanceNested<N>> implements Nested<N>{
  
    PowerVSResourceBuilder builder;
  
    ServiceInstanceNested(PowerVSResource item) {
      this.builder = new PowerVSResourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.withServiceInstance(builder.build());
    }
    
    public N endServiceInstance() {
      return and();
    }
    
  }
  public class UserDataSecretNested<N> extends PowerVSSecretReferenceFluent<UserDataSecretNested<N>> implements Nested<N>{
  
    PowerVSSecretReferenceBuilder builder;
  
    UserDataSecretNested(PowerVSSecretReference item) {
      this.builder = new PowerVSSecretReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PowerVSMachineProviderConfigFluent.this.withUserDataSecret(builder.build());
    }
    
    public N endUserDataSecret() {
      return and();
    }
    
  }
}