package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
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
public class ClusterNetworkFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1.ClusterNetworkFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private ArrayList<ClusterNetworkEntryBuilder> clusterNetworks = new ArrayList<ClusterNetworkEntryBuilder>();
  private Long hostsubnetlength;
  private String kind;
  private ObjectMetaBuilder metadata;
  private Long mtu;
  private String network;
  private String pluginName;
  private String serviceNetwork;
  private Long vxlanPort;

  public ClusterNetworkFluent() {
  }
  
  public ClusterNetworkFluent(ClusterNetwork instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterNetworks(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetworks == null) {
      this.clusterNetworks = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworks").add(builder);
        this.clusterNetworks.add(builder);
    }
    return (A) this;
  }
  
  public ClusterNetworksNested<A> addNewClusterNetwork() {
    return new ClusterNetworksNested(-1, null);
  }
  
  public A addNewClusterNetwork(String cIDR,Long hostSubnetLength) {
    return (A) this.addToClusterNetworks(new ClusterNetworkEntry(cIDR, hostSubnetLength));
  }
  
  public ClusterNetworksNested<A> addNewClusterNetworkLike(ClusterNetworkEntry item) {
    return new ClusterNetworksNested(-1, item);
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
  
  public A addToClusterNetworks(ClusterNetworkEntry... items) {
    if (this.clusterNetworks == null) {
      this.clusterNetworks = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworks").add(builder);
        this.clusterNetworks.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterNetworks(int index,ClusterNetworkEntry item) {
    if (this.clusterNetworks == null) {
      this.clusterNetworks = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetworks.size()) {
        _visitables.get("clusterNetworks").add(builder);
        clusterNetworks.add(builder);
    } else {
        _visitables.get("clusterNetworks").add(builder);
        clusterNetworks.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterNetworkEntry buildClusterNetwork(int index) {
    return this.clusterNetworks.get(index).build();
  }
  
  public List<ClusterNetworkEntry> buildClusterNetworks() {
    return this.clusterNetworks != null ? build(clusterNetworks) : null;
  }
  
  public ClusterNetworkEntry buildFirstClusterNetwork() {
    return this.clusterNetworks.get(0).build();
  }
  
  public ClusterNetworkEntry buildLastClusterNetwork() {
    return this.clusterNetworks.get(clusterNetworks.size() - 1).build();
  }
  
  public ClusterNetworkEntry buildMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetworks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(ClusterNetwork instance) {
    instance = instance != null ? instance : new ClusterNetwork();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withClusterNetworks(instance.getClusterNetworks());
        this.withHostsubnetlength(instance.getHostsubnetlength());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withMtu(instance.getMtu());
        this.withNetwork(instance.getNetwork());
        this.withPluginName(instance.getPluginName());
        this.withServiceNetwork(instance.getServiceNetwork());
        this.withVxlanPort(instance.getVxlanPort());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterNetworksNested<A> editClusterNetwork(int index) {
    if (clusterNetworks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterNetworks"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworksNested<A> editFirstClusterNetwork() {
    if (clusterNetworks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterNetworks"));
    }
    return this.setNewClusterNetworkLike(0, this.buildClusterNetwork(0));
  }
  
  public ClusterNetworksNested<A> editLastClusterNetwork() {
    int index = clusterNetworks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterNetworks"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworksNested<A> editMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterNetworks.size();i++) {
      if (predicate.test(clusterNetworks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterNetworks"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    ClusterNetworkFluent that = (ClusterNetworkFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(clusterNetworks, that.clusterNetworks))) {
      return false;
    }
    if (!(Objects.equals(hostsubnetlength, that.hostsubnetlength))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(pluginName, that.pluginName))) {
      return false;
    }
    if (!(Objects.equals(serviceNetwork, that.serviceNetwork))) {
      return false;
    }
    if (!(Objects.equals(vxlanPort, that.vxlanPort))) {
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
  
  public Long getHostsubnetlength() {
    return this.hostsubnetlength;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public Long getMtu() {
    return this.mtu;
  }
  
  public String getNetwork() {
    return this.network;
  }
  
  public String getPluginName() {
    return this.pluginName;
  }
  
  public String getServiceNetwork() {
    return this.serviceNetwork;
  }
  
  public Long getVxlanPort() {
    return this.vxlanPort;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasClusterNetworks() {
    return this.clusterNetworks != null && !(this.clusterNetworks.isEmpty());
  }
  
  public boolean hasHostsubnetlength() {
    return this.hostsubnetlength != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetworks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasPluginName() {
    return this.pluginName != null;
  }
  
  public boolean hasServiceNetwork() {
    return this.serviceNetwork != null;
  }
  
  public boolean hasVxlanPort() {
    return this.vxlanPort != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, clusterNetworks, hostsubnetlength, kind, metadata, mtu, network, pluginName, serviceNetwork, vxlanPort, additionalProperties);
  }
  
  public A removeAllFromClusterNetworks(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetworks == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworks").remove(builder);
        this.clusterNetworks.remove(builder);
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
  
  public A removeFromClusterNetworks(ClusterNetworkEntry... items) {
    if (this.clusterNetworks == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetworks").remove(builder);
        this.clusterNetworks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterNetworks(Predicate<ClusterNetworkEntryBuilder> predicate) {
    if (clusterNetworks == null) {
      return (A) this;
    }
    Iterator<ClusterNetworkEntryBuilder> each = clusterNetworks.iterator();
    List visitables = _visitables.get("clusterNetworks");
    while (each.hasNext()) {
        ClusterNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterNetworksNested<A> setNewClusterNetworkLike(int index,ClusterNetworkEntry item) {
    return new ClusterNetworksNested(index, item);
  }
  
  public A setToClusterNetworks(int index,ClusterNetworkEntry item) {
    if (this.clusterNetworks == null) {
      this.clusterNetworks = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetworks.size()) {
        _visitables.get("clusterNetworks").add(builder);
        clusterNetworks.add(builder);
    } else {
        _visitables.get("clusterNetworks").add(builder);
        clusterNetworks.set(index, builder);
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
    if (!(clusterNetworks == null) && !(clusterNetworks.isEmpty())) {
        sb.append("clusterNetworks:");
        sb.append(clusterNetworks);
        sb.append(",");
    }
    if (!(hostsubnetlength == null)) {
        sb.append("hostsubnetlength:");
        sb.append(hostsubnetlength);
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
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(pluginName == null)) {
        sb.append("pluginName:");
        sb.append(pluginName);
        sb.append(",");
    }
    if (!(serviceNetwork == null)) {
        sb.append("serviceNetwork:");
        sb.append(serviceNetwork);
        sb.append(",");
    }
    if (!(vxlanPort == null)) {
        sb.append("vxlanPort:");
        sb.append(vxlanPort);
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
  
  public A withClusterNetworks(List<ClusterNetworkEntry> clusterNetworks) {
    if (this.clusterNetworks != null) {
      this._visitables.get("clusterNetworks").clear();
    }
    if (clusterNetworks != null) {
        this.clusterNetworks = new ArrayList();
        for (ClusterNetworkEntry item : clusterNetworks) {
          this.addToClusterNetworks(item);
        }
    } else {
      this.clusterNetworks = null;
    }
    return (A) this;
  }
  
  public A withClusterNetworks(ClusterNetworkEntry... clusterNetworks) {
    if (this.clusterNetworks != null) {
        this.clusterNetworks.clear();
        _visitables.remove("clusterNetworks");
    }
    if (clusterNetworks != null) {
      for (ClusterNetworkEntry item : clusterNetworks) {
        this.addToClusterNetworks(item);
      }
    }
    return (A) this;
  }
  
  public A withHostsubnetlength(Long hostsubnetlength) {
    this.hostsubnetlength = hostsubnetlength;
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
  
  public A withMtu(Long mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withPluginName(String pluginName) {
    this.pluginName = pluginName;
    return (A) this;
  }
  
  public A withServiceNetwork(String serviceNetwork) {
    this.serviceNetwork = serviceNetwork;
    return (A) this;
  }
  
  public A withVxlanPort(Long vxlanPort) {
    this.vxlanPort = vxlanPort;
    return (A) this;
  }
  public class ClusterNetworksNested<N> extends ClusterNetworkEntryFluent<ClusterNetworksNested<N>> implements Nested<N>{
  
    ClusterNetworkEntryBuilder builder;
    int index;
  
    ClusterNetworksNested(int index,ClusterNetworkEntry item) {
      this.index = index;
      this.builder = new ClusterNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterNetworkFluent.this.setToClusterNetworks(index, builder.build());
    }
    
    public N endClusterNetwork() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterNetworkFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}