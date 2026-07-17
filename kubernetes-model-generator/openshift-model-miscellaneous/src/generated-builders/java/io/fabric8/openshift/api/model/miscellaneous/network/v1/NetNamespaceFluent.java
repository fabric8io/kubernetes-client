package io.fabric8.openshift.api.model.miscellaneous.network.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
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
public class NetNamespaceFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1.NetNamespaceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private List<String> egressIPs = new ArrayList<String>();
  private String kind;
  private ObjectMetaBuilder metadata;
  private Long netid;
  private String netname;

  public NetNamespaceFluent() {
  }
  
  public NetNamespaceFluent(NetNamespace instance) {
    this.copyInstance(instance);
  }

  public A addAllToEgressIPs(Collection<String> items) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    for (String item : items) {
      this.egressIPs.add(item);
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
  
  public A addToEgressIPs(String... items) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    for (String item : items) {
      this.egressIPs.add(item);
    }
    return (A) this;
  }
  
  public A addToEgressIPs(int index,String item) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    this.egressIPs.add(index, item);
    return (A) this;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(NetNamespace instance) {
    instance = instance != null ? instance : new NetNamespace();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withEgressIPs(instance.getEgressIPs());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withNetid(instance.getNetid());
        this.withNetname(instance.getNetname());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    NetNamespaceFluent that = (NetNamespaceFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(egressIPs, that.egressIPs))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(netid, that.netid))) {
      return false;
    }
    if (!(Objects.equals(netname, that.netname))) {
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
  
  public String getEgressIP(int index) {
    return this.egressIPs.get(index);
  }
  
  public List<String> getEgressIPs() {
    return this.egressIPs;
  }
  
  public String getFirstEgressIP() {
    return this.egressIPs.get(0);
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getLastEgressIP() {
    return this.egressIPs.get(egressIPs.size() - 1);
  }
  
  public String getMatchingEgressIP(Predicate<String> predicate) {
      for (String item : egressIPs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getNetid() {
    return this.netid;
  }
  
  public String getNetname() {
    return this.netname;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasEgressIPs() {
    return this.egressIPs != null && !(this.egressIPs.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingEgressIP(Predicate<String> predicate) {
      for (String item : egressIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasNetid() {
    return this.netid != null;
  }
  
  public boolean hasNetname() {
    return this.netname != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, egressIPs, kind, metadata, netid, netname, additionalProperties);
  }
  
  public A removeAllFromEgressIPs(Collection<String> items) {
    if (this.egressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.egressIPs.remove(item);
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
  
  public A removeFromEgressIPs(String... items) {
    if (this.egressIPs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.egressIPs.remove(item);
    }
    return (A) this;
  }
  
  public A setToEgressIPs(int index,String item) {
    if (this.egressIPs == null) {
      this.egressIPs = new ArrayList();
    }
    this.egressIPs.set(index, item);
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
    if (!(egressIPs == null) && !(egressIPs.isEmpty())) {
        sb.append("egressIPs:");
        sb.append(egressIPs);
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
    if (!(netid == null)) {
        sb.append("netid:");
        sb.append(netid);
        sb.append(",");
    }
    if (!(netname == null)) {
        sb.append("netname:");
        sb.append(netname);
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
  
  public A withEgressIPs(List<String> egressIPs) {
    if (egressIPs != null) {
        this.egressIPs = new ArrayList();
        for (String item : egressIPs) {
          this.addToEgressIPs(item);
        }
    } else {
      this.egressIPs = null;
    }
    return (A) this;
  }
  
  public A withEgressIPs(String... egressIPs) {
    if (this.egressIPs != null) {
        this.egressIPs.clear();
        _visitables.remove("egressIPs");
    }
    if (egressIPs != null) {
      for (String item : egressIPs) {
        this.addToEgressIPs(item);
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
  
  public A withNetid(Long netid) {
    this.netid = netid;
    return (A) this;
  }
  
  public A withNetname(String netname) {
    this.netname = netname;
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) NetNamespaceFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}