package io.fabric8.openshift.api.model.installer.vsphere.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class FailureDomainFluent<A extends io.fabric8.openshift.api.model.installer.vsphere.v1.FailureDomainFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String region;
  private String regionType;
  private String server;
  private TopologyBuilder topology;
  private String zone;
  private String zoneType;

  public FailureDomainFluent() {
  }
  
  public FailureDomainFluent(FailureDomain instance) {
    this.copyInstance(instance);
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
  
  public Topology buildTopology() {
    return this.topology != null ? this.topology.build() : null;
  }
  
  protected void copyInstance(FailureDomain instance) {
    instance = instance != null ? instance : new FailureDomain();
    if (instance != null) {
        this.withName(instance.getName());
        this.withRegion(instance.getRegion());
        this.withRegionType(instance.getRegionType());
        this.withServer(instance.getServer());
        this.withTopology(instance.getTopology());
        this.withZone(instance.getZone());
        this.withZoneType(instance.getZoneType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TopologyNested<A> editOrNewTopology() {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(new TopologyBuilder().build()));
  }
  
  public TopologyNested<A> editOrNewTopologyLike(Topology item) {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(item));
  }
  
  public TopologyNested<A> editTopology() {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(null));
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
    FailureDomainFluent that = (FailureDomainFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(regionType, that.regionType))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
      return false;
    }
    if (!(Objects.equals(topology, that.topology))) {
      return false;
    }
    if (!(Objects.equals(zone, that.zone))) {
      return false;
    }
    if (!(Objects.equals(zoneType, that.zoneType))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getRegionType() {
    return this.regionType;
  }
  
  public String getServer() {
    return this.server;
  }
  
  public String getZone() {
    return this.zone;
  }
  
  public String getZoneType() {
    return this.zoneType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasRegionType() {
    return this.regionType != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public boolean hasTopology() {
    return this.topology != null;
  }
  
  public boolean hasZone() {
    return this.zone != null;
  }
  
  public boolean hasZoneType() {
    return this.zoneType != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, region, regionType, server, topology, zone, zoneType, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(regionType == null)) {
        sb.append("regionType:");
        sb.append(regionType);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
        sb.append(",");
    }
    if (!(topology == null)) {
        sb.append("topology:");
        sb.append(topology);
        sb.append(",");
    }
    if (!(zone == null)) {
        sb.append("zone:");
        sb.append(zone);
        sb.append(",");
    }
    if (!(zoneType == null)) {
        sb.append("zoneType:");
        sb.append(zoneType);
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public TopologyNested<A> withNewTopology() {
    return new TopologyNested(null);
  }
  
  public TopologyNested<A> withNewTopologyLike(Topology item) {
    return new TopologyNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRegionType(String regionType) {
    this.regionType = regionType;
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
  public A withTopology(Topology topology) {
    this._visitables.remove("topology");
    if (topology != null) {
        this.topology = new TopologyBuilder(topology);
        this._visitables.get("topology").add(this.topology);
    } else {
        this.topology = null;
        this._visitables.get("topology").remove(this.topology);
    }
    return (A) this;
  }
  
  public A withZone(String zone) {
    this.zone = zone;
    return (A) this;
  }
  
  public A withZoneType(String zoneType) {
    this.zoneType = zoneType;
    return (A) this;
  }
  public class TopologyNested<N> extends TopologyFluent<TopologyNested<N>> implements Nested<N>{
  
    TopologyBuilder builder;
  
    TopologyNested(Topology item) {
      this.builder = new TopologyBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainFluent.this.withTopology(builder.build());
    }
    
    public N endTopology() {
      return and();
    }
    
  }
}