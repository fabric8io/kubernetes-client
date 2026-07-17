package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class NetworkSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.NetworkSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterNetworkEntryBuilder> clusterNetwork = new ArrayList<ClusterNetworkEntryBuilder>();
  private ExternalIPConfigBuilder externalIP;
  private NetworkDiagnosticsBuilder networkDiagnostics;
  private String networkType;
  private List<String> serviceNetwork = new ArrayList<String>();
  private String serviceNodePortRange;

  public NetworkSpecFluent() {
  }
  
  public NetworkSpecFluent(NetworkSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public ClusterNetworkNested<A> addNewClusterNetwork() {
    return new ClusterNetworkNested(-1, null);
  }
  
  public A addNewClusterNetwork(String cidr,Long hostPrefix) {
    return (A) this.addToClusterNetwork(new ClusterNetworkEntry(cidr, hostPrefix));
  }
  
  public ClusterNetworkNested<A> addNewClusterNetworkLike(ClusterNetworkEntry item) {
    return new ClusterNetworkNested(-1, item);
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
  
  public A addToClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.add(index, item);
    return (A) this;
  }
  
  public List<ClusterNetworkEntry> buildClusterNetwork() {
    return this.clusterNetwork != null ? build(clusterNetwork) : null;
  }
  
  public ClusterNetworkEntry buildClusterNetwork(int index) {
    return this.clusterNetwork.get(index).build();
  }
  
  public ExternalIPConfig buildExternalIP() {
    return this.externalIP != null ? this.externalIP.build() : null;
  }
  
  public ClusterNetworkEntry buildFirstClusterNetwork() {
    return this.clusterNetwork.get(0).build();
  }
  
  public ClusterNetworkEntry buildLastClusterNetwork() {
    return this.clusterNetwork.get(clusterNetwork.size() - 1).build();
  }
  
  public ClusterNetworkEntry buildMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDiagnostics buildNetworkDiagnostics() {
    return this.networkDiagnostics != null ? this.networkDiagnostics.build() : null;
  }
  
  protected void copyInstance(NetworkSpec instance) {
    instance = instance != null ? instance : new NetworkSpec();
    if (instance != null) {
        this.withClusterNetwork(instance.getClusterNetwork());
        this.withExternalIP(instance.getExternalIP());
        this.withNetworkDiagnostics(instance.getNetworkDiagnostics());
        this.withNetworkType(instance.getNetworkType());
        this.withServiceNetwork(instance.getServiceNetwork());
        this.withServiceNodePortRange(instance.getServiceNodePortRange());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClusterNetworkNested<A> editClusterNetwork(int index) {
    if (clusterNetwork.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ExternalIPNested<A> editExternalIP() {
    return this.withNewExternalIPLike(Optional.ofNullable(this.buildExternalIP()).orElse(null));
  }
  
  public ClusterNetworkNested<A> editFirstClusterNetwork() {
    if (clusterNetwork.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(0, this.buildClusterNetwork(0));
  }
  
  public ClusterNetworkNested<A> editLastClusterNetwork() {
    int index = clusterNetwork.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public ClusterNetworkNested<A> editMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterNetwork.size();i++) {
      if (predicate.test(clusterNetwork.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public NetworkDiagnosticsNested<A> editNetworkDiagnostics() {
    return this.withNewNetworkDiagnosticsLike(Optional.ofNullable(this.buildNetworkDiagnostics()).orElse(null));
  }
  
  public ExternalIPNested<A> editOrNewExternalIP() {
    return this.withNewExternalIPLike(Optional.ofNullable(this.buildExternalIP()).orElse(new ExternalIPConfigBuilder().build()));
  }
  
  public ExternalIPNested<A> editOrNewExternalIPLike(ExternalIPConfig item) {
    return this.withNewExternalIPLike(Optional.ofNullable(this.buildExternalIP()).orElse(item));
  }
  
  public NetworkDiagnosticsNested<A> editOrNewNetworkDiagnostics() {
    return this.withNewNetworkDiagnosticsLike(Optional.ofNullable(this.buildNetworkDiagnostics()).orElse(new NetworkDiagnosticsBuilder().build()));
  }
  
  public NetworkDiagnosticsNested<A> editOrNewNetworkDiagnosticsLike(NetworkDiagnostics item) {
    return this.withNewNetworkDiagnosticsLike(Optional.ofNullable(this.buildNetworkDiagnostics()).orElse(item));
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
    NetworkSpecFluent that = (NetworkSpecFluent) o;
    if (!(Objects.equals(clusterNetwork, that.clusterNetwork))) {
      return false;
    }
    if (!(Objects.equals(externalIP, that.externalIP))) {
      return false;
    }
    if (!(Objects.equals(networkDiagnostics, that.networkDiagnostics))) {
      return false;
    }
    if (!(Objects.equals(networkType, that.networkType))) {
      return false;
    }
    if (!(Objects.equals(serviceNetwork, that.serviceNetwork))) {
      return false;
    }
    if (!(Objects.equals(serviceNodePortRange, that.serviceNodePortRange))) {
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
  
  public String getFirstServiceNetwork() {
    return this.serviceNetwork.get(0);
  }
  
  public String getLastServiceNetwork() {
    return this.serviceNetwork.get(serviceNetwork.size() - 1);
  }
  
  public String getMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetworkType() {
    return this.networkType;
  }
  
  public List<String> getServiceNetwork() {
    return this.serviceNetwork;
  }
  
  public String getServiceNetwork(int index) {
    return this.serviceNetwork.get(index);
  }
  
  public String getServiceNodePortRange() {
    return this.serviceNodePortRange;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterNetwork() {
    return this.clusterNetwork != null && !(this.clusterNetwork.isEmpty());
  }
  
  public boolean hasExternalIP() {
    return this.externalIP != null;
  }
  
  public boolean hasMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkDiagnostics() {
    return this.networkDiagnostics != null;
  }
  
  public boolean hasNetworkType() {
    return this.networkType != null;
  }
  
  public boolean hasServiceNetwork() {
    return this.serviceNetwork != null && !(this.serviceNetwork.isEmpty());
  }
  
  public boolean hasServiceNodePortRange() {
    return this.serviceNodePortRange != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterNetwork, externalIP, networkDiagnostics, networkType, serviceNetwork, serviceNodePortRange, additionalProperties);
  }
  
  public A removeAllFromClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
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
  
  public A removeFromClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    if (clusterNetwork == null) {
      return (A) this;
    }
    Iterator<ClusterNetworkEntryBuilder> each = clusterNetwork.iterator();
    List visitables = _visitables.get("clusterNetwork");
    while (each.hasNext()) {
        ClusterNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterNetworkNested<A> setNewClusterNetworkLike(int index,ClusterNetworkEntry item) {
    return new ClusterNetworkNested(index, item);
  }
  
  public A setToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterNetwork == null) && !(clusterNetwork.isEmpty())) {
        sb.append("clusterNetwork:");
        sb.append(clusterNetwork);
        sb.append(",");
    }
    if (!(externalIP == null)) {
        sb.append("externalIP:");
        sb.append(externalIP);
        sb.append(",");
    }
    if (!(networkDiagnostics == null)) {
        sb.append("networkDiagnostics:");
        sb.append(networkDiagnostics);
        sb.append(",");
    }
    if (!(networkType == null)) {
        sb.append("networkType:");
        sb.append(networkType);
        sb.append(",");
    }
    if (!(serviceNetwork == null) && !(serviceNetwork.isEmpty())) {
        sb.append("serviceNetwork:");
        sb.append(serviceNetwork);
        sb.append(",");
    }
    if (!(serviceNodePortRange == null)) {
        sb.append("serviceNodePortRange:");
        sb.append(serviceNodePortRange);
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
  
  public A withClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
    if (this.clusterNetwork != null) {
      this._visitables.get("clusterNetwork").clear();
    }
    if (clusterNetwork != null) {
        this.clusterNetwork = new ArrayList();
        for (ClusterNetworkEntry item : clusterNetwork) {
          this.addToClusterNetwork(item);
        }
    } else {
      this.clusterNetwork = null;
    }
    return (A) this;
  }
  
  public A withClusterNetwork(ClusterNetworkEntry... clusterNetwork) {
    if (this.clusterNetwork != null) {
        this.clusterNetwork.clear();
        _visitables.remove("clusterNetwork");
    }
    if (clusterNetwork != null) {
      for (ClusterNetworkEntry item : clusterNetwork) {
        this.addToClusterNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withExternalIP(ExternalIPConfig externalIP) {
    this._visitables.remove("externalIP");
    if (externalIP != null) {
        this.externalIP = new ExternalIPConfigBuilder(externalIP);
        this._visitables.get("externalIP").add(this.externalIP);
    } else {
        this.externalIP = null;
        this._visitables.get("externalIP").remove(this.externalIP);
    }
    return (A) this;
  }
  
  public A withNetworkDiagnostics(NetworkDiagnostics networkDiagnostics) {
    this._visitables.remove("networkDiagnostics");
    if (networkDiagnostics != null) {
        this.networkDiagnostics = new NetworkDiagnosticsBuilder(networkDiagnostics);
        this._visitables.get("networkDiagnostics").add(this.networkDiagnostics);
    } else {
        this.networkDiagnostics = null;
        this._visitables.get("networkDiagnostics").remove(this.networkDiagnostics);
    }
    return (A) this;
  }
  
  public A withNetworkType(String networkType) {
    this.networkType = networkType;
    return (A) this;
  }
  
  public ExternalIPNested<A> withNewExternalIP() {
    return new ExternalIPNested(null);
  }
  
  public ExternalIPNested<A> withNewExternalIPLike(ExternalIPConfig item) {
    return new ExternalIPNested(item);
  }
  
  public NetworkDiagnosticsNested<A> withNewNetworkDiagnostics() {
    return new NetworkDiagnosticsNested(null);
  }
  
  public NetworkDiagnosticsNested<A> withNewNetworkDiagnosticsLike(NetworkDiagnostics item) {
    return new NetworkDiagnosticsNested(item);
  }
  
  public A withServiceNetwork(List<String> serviceNetwork) {
    if (serviceNetwork != null) {
        this.serviceNetwork = new ArrayList();
        for (String item : serviceNetwork) {
          this.addToServiceNetwork(item);
        }
    } else {
      this.serviceNetwork = null;
    }
    return (A) this;
  }
  
  public A withServiceNetwork(String... serviceNetwork) {
    if (this.serviceNetwork != null) {
        this.serviceNetwork.clear();
        _visitables.remove("serviceNetwork");
    }
    if (serviceNetwork != null) {
      for (String item : serviceNetwork) {
        this.addToServiceNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withServiceNodePortRange(String serviceNodePortRange) {
    this.serviceNodePortRange = serviceNodePortRange;
    return (A) this;
  }
  public class ClusterNetworkNested<N> extends ClusterNetworkEntryFluent<ClusterNetworkNested<N>> implements Nested<N>{
  
    ClusterNetworkEntryBuilder builder;
    int index;
  
    ClusterNetworkNested(int index,ClusterNetworkEntry item) {
      this.index = index;
      this.builder = new ClusterNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.setToClusterNetwork(index, builder.build());
    }
    
    public N endClusterNetwork() {
      return and();
    }
    
  }
  public class ExternalIPNested<N> extends ExternalIPConfigFluent<ExternalIPNested<N>> implements Nested<N>{
  
    ExternalIPConfigBuilder builder;
  
    ExternalIPNested(ExternalIPConfig item) {
      this.builder = new ExternalIPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withExternalIP(builder.build());
    }
    
    public N endExternalIP() {
      return and();
    }
    
  }
  public class NetworkDiagnosticsNested<N> extends NetworkDiagnosticsFluent<NetworkDiagnosticsNested<N>> implements Nested<N>{
  
    NetworkDiagnosticsBuilder builder;
  
    NetworkDiagnosticsNested(NetworkDiagnostics item) {
      this.builder = new NetworkDiagnosticsBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withNetworkDiagnostics(builder.build());
    }
    
    public N endNetworkDiagnostics() {
      return and();
    }
    
  }
}