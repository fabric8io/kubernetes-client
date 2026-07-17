package io.fabric8.openshift.api.model.config.v1;

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
public class VSpherePlatformFailureDomainSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.VSpherePlatformFailureDomainSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String name;
  private String region;
  private VSphereFailureDomainRegionAffinityBuilder regionAffinity;
  private String server;
  private VSpherePlatformTopologyBuilder topology;
  private String zone;
  private VSphereFailureDomainZoneAffinityBuilder zoneAffinity;

  public VSpherePlatformFailureDomainSpecFluent() {
  }
  
  public VSpherePlatformFailureDomainSpecFluent(VSpherePlatformFailureDomainSpec instance) {
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
  
  public VSphereFailureDomainRegionAffinity buildRegionAffinity() {
    return this.regionAffinity != null ? this.regionAffinity.build() : null;
  }
  
  public VSpherePlatformTopology buildTopology() {
    return this.topology != null ? this.topology.build() : null;
  }
  
  public VSphereFailureDomainZoneAffinity buildZoneAffinity() {
    return this.zoneAffinity != null ? this.zoneAffinity.build() : null;
  }
  
  protected void copyInstance(VSpherePlatformFailureDomainSpec instance) {
    instance = instance != null ? instance : new VSpherePlatformFailureDomainSpec();
    if (instance != null) {
        this.withName(instance.getName());
        this.withRegion(instance.getRegion());
        this.withRegionAffinity(instance.getRegionAffinity());
        this.withServer(instance.getServer());
        this.withTopology(instance.getTopology());
        this.withZone(instance.getZone());
        this.withZoneAffinity(instance.getZoneAffinity());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RegionAffinityNested<A> editOrNewRegionAffinity() {
    return this.withNewRegionAffinityLike(Optional.ofNullable(this.buildRegionAffinity()).orElse(new VSphereFailureDomainRegionAffinityBuilder().build()));
  }
  
  public RegionAffinityNested<A> editOrNewRegionAffinityLike(VSphereFailureDomainRegionAffinity item) {
    return this.withNewRegionAffinityLike(Optional.ofNullable(this.buildRegionAffinity()).orElse(item));
  }
  
  public TopologyNested<A> editOrNewTopology() {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(new VSpherePlatformTopologyBuilder().build()));
  }
  
  public TopologyNested<A> editOrNewTopologyLike(VSpherePlatformTopology item) {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(item));
  }
  
  public ZoneAffinityNested<A> editOrNewZoneAffinity() {
    return this.withNewZoneAffinityLike(Optional.ofNullable(this.buildZoneAffinity()).orElse(new VSphereFailureDomainZoneAffinityBuilder().build()));
  }
  
  public ZoneAffinityNested<A> editOrNewZoneAffinityLike(VSphereFailureDomainZoneAffinity item) {
    return this.withNewZoneAffinityLike(Optional.ofNullable(this.buildZoneAffinity()).orElse(item));
  }
  
  public RegionAffinityNested<A> editRegionAffinity() {
    return this.withNewRegionAffinityLike(Optional.ofNullable(this.buildRegionAffinity()).orElse(null));
  }
  
  public TopologyNested<A> editTopology() {
    return this.withNewTopologyLike(Optional.ofNullable(this.buildTopology()).orElse(null));
  }
  
  public ZoneAffinityNested<A> editZoneAffinity() {
    return this.withNewZoneAffinityLike(Optional.ofNullable(this.buildZoneAffinity()).orElse(null));
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
    VSpherePlatformFailureDomainSpecFluent that = (VSpherePlatformFailureDomainSpecFluent) o;
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(regionAffinity, that.regionAffinity))) {
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
    if (!(Objects.equals(zoneAffinity, that.zoneAffinity))) {
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
  
  public String getServer() {
    return this.server;
  }
  
  public String getZone() {
    return this.zone;
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
  
  public boolean hasRegionAffinity() {
    return this.regionAffinity != null;
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
  
  public boolean hasZoneAffinity() {
    return this.zoneAffinity != null;
  }
  
  public int hashCode() {
    return Objects.hash(name, region, regionAffinity, server, topology, zone, zoneAffinity, additionalProperties);
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
    if (!(regionAffinity == null)) {
        sb.append("regionAffinity:");
        sb.append(regionAffinity);
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
    if (!(zoneAffinity == null)) {
        sb.append("zoneAffinity:");
        sb.append(zoneAffinity);
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
  
  public RegionAffinityNested<A> withNewRegionAffinity() {
    return new RegionAffinityNested(null);
  }
  
  public A withNewRegionAffinity(String type) {
    return (A) this.withRegionAffinity(new VSphereFailureDomainRegionAffinity(type));
  }
  
  public RegionAffinityNested<A> withNewRegionAffinityLike(VSphereFailureDomainRegionAffinity item) {
    return new RegionAffinityNested(item);
  }
  
  public TopologyNested<A> withNewTopology() {
    return new TopologyNested(null);
  }
  
  public TopologyNested<A> withNewTopologyLike(VSpherePlatformTopology item) {
    return new TopologyNested(item);
  }
  
  public ZoneAffinityNested<A> withNewZoneAffinity() {
    return new ZoneAffinityNested(null);
  }
  
  public ZoneAffinityNested<A> withNewZoneAffinityLike(VSphereFailureDomainZoneAffinity item) {
    return new ZoneAffinityNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withRegionAffinity(VSphereFailureDomainRegionAffinity regionAffinity) {
    this._visitables.remove("regionAffinity");
    if (regionAffinity != null) {
        this.regionAffinity = new VSphereFailureDomainRegionAffinityBuilder(regionAffinity);
        this._visitables.get("regionAffinity").add(this.regionAffinity);
    } else {
        this.regionAffinity = null;
        this._visitables.get("regionAffinity").remove(this.regionAffinity);
    }
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
  public A withTopology(VSpherePlatformTopology topology) {
    this._visitables.remove("topology");
    if (topology != null) {
        this.topology = new VSpherePlatformTopologyBuilder(topology);
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
  
  public A withZoneAffinity(VSphereFailureDomainZoneAffinity zoneAffinity) {
    this._visitables.remove("zoneAffinity");
    if (zoneAffinity != null) {
        this.zoneAffinity = new VSphereFailureDomainZoneAffinityBuilder(zoneAffinity);
        this._visitables.get("zoneAffinity").add(this.zoneAffinity);
    } else {
        this.zoneAffinity = null;
        this._visitables.get("zoneAffinity").remove(this.zoneAffinity);
    }
    return (A) this;
  }
  public class RegionAffinityNested<N> extends VSphereFailureDomainRegionAffinityFluent<RegionAffinityNested<N>> implements Nested<N>{
  
    VSphereFailureDomainRegionAffinityBuilder builder;
  
    RegionAffinityNested(VSphereFailureDomainRegionAffinity item) {
      this.builder = new VSphereFailureDomainRegionAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformFailureDomainSpecFluent.this.withRegionAffinity(builder.build());
    }
    
    public N endRegionAffinity() {
      return and();
    }
    
  }
  public class TopologyNested<N> extends VSpherePlatformTopologyFluent<TopologyNested<N>> implements Nested<N>{
  
    VSpherePlatformTopologyBuilder builder;
  
    TopologyNested(VSpherePlatformTopology item) {
      this.builder = new VSpherePlatformTopologyBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformFailureDomainSpecFluent.this.withTopology(builder.build());
    }
    
    public N endTopology() {
      return and();
    }
    
  }
  public class ZoneAffinityNested<N> extends VSphereFailureDomainZoneAffinityFluent<ZoneAffinityNested<N>> implements Nested<N>{
  
    VSphereFailureDomainZoneAffinityBuilder builder;
  
    ZoneAffinityNested(VSphereFailureDomainZoneAffinity item) {
      this.builder = new VSphereFailureDomainZoneAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) VSpherePlatformFailureDomainSpecFluent.this.withZoneAffinity(builder.build());
    }
    
    public N endZoneAffinity() {
      return and();
    }
    
  }
}