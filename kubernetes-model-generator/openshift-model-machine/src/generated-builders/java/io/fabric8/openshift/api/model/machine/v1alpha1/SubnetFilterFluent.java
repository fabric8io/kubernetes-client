package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SubnetFilterFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.SubnetFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cidr;
  private String description;
  private Boolean enableDhcp;
  private String gatewayIp;
  private String id;
  private Integer ipVersion;
  private String ipv6AddressMode;
  private String ipv6RaMode;
  private Integer limit;
  private String marker;
  private String name;
  private String networkId;
  private String notTags;
  private String notTagsAny;
  private String projectId;
  private String sortDir;
  private String sortKey;
  private String subnetpoolId;
  private String tags;
  private String tagsAny;
  private String tenantId;

  public SubnetFilterFluent() {
  }
  
  public SubnetFilterFluent(SubnetFilter instance) {
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
  
  protected void copyInstance(SubnetFilter instance) {
    instance = instance != null ? instance : new SubnetFilter();
    if (instance != null) {
        this.withCidr(instance.getCidr());
        this.withDescription(instance.getDescription());
        this.withEnableDhcp(instance.getEnableDhcp());
        this.withGatewayIp(instance.getGatewayIp());
        this.withId(instance.getId());
        this.withIpVersion(instance.getIpVersion());
        this.withIpv6AddressMode(instance.getIpv6AddressMode());
        this.withIpv6RaMode(instance.getIpv6RaMode());
        this.withLimit(instance.getLimit());
        this.withMarker(instance.getMarker());
        this.withName(instance.getName());
        this.withNetworkId(instance.getNetworkId());
        this.withNotTags(instance.getNotTags());
        this.withNotTagsAny(instance.getNotTagsAny());
        this.withProjectId(instance.getProjectId());
        this.withSortDir(instance.getSortDir());
        this.withSortKey(instance.getSortKey());
        this.withSubnetpoolId(instance.getSubnetpoolId());
        this.withTags(instance.getTags());
        this.withTagsAny(instance.getTagsAny());
        this.withTenantId(instance.getTenantId());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    SubnetFilterFluent that = (SubnetFilterFluent) o;
    if (!(Objects.equals(cidr, that.cidr))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(enableDhcp, that.enableDhcp))) {
      return false;
    }
    if (!(Objects.equals(gatewayIp, that.gatewayIp))) {
      return false;
    }
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(ipVersion, that.ipVersion))) {
      return false;
    }
    if (!(Objects.equals(ipv6AddressMode, that.ipv6AddressMode))) {
      return false;
    }
    if (!(Objects.equals(ipv6RaMode, that.ipv6RaMode))) {
      return false;
    }
    if (!(Objects.equals(limit, that.limit))) {
      return false;
    }
    if (!(Objects.equals(marker, that.marker))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(networkId, that.networkId))) {
      return false;
    }
    if (!(Objects.equals(notTags, that.notTags))) {
      return false;
    }
    if (!(Objects.equals(notTagsAny, that.notTagsAny))) {
      return false;
    }
    if (!(Objects.equals(projectId, that.projectId))) {
      return false;
    }
    if (!(Objects.equals(sortDir, that.sortDir))) {
      return false;
    }
    if (!(Objects.equals(sortKey, that.sortKey))) {
      return false;
    }
    if (!(Objects.equals(subnetpoolId, that.subnetpoolId))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(tagsAny, that.tagsAny))) {
      return false;
    }
    if (!(Objects.equals(tenantId, that.tenantId))) {
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
  
  public String getCidr() {
    return this.cidr;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public Boolean getEnableDhcp() {
    return this.enableDhcp;
  }
  
  public String getGatewayIp() {
    return this.gatewayIp;
  }
  
  public String getId() {
    return this.id;
  }
  
  public Integer getIpVersion() {
    return this.ipVersion;
  }
  
  public String getIpv6AddressMode() {
    return this.ipv6AddressMode;
  }
  
  public String getIpv6RaMode() {
    return this.ipv6RaMode;
  }
  
  public Integer getLimit() {
    return this.limit;
  }
  
  public String getMarker() {
    return this.marker;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNetworkId() {
    return this.networkId;
  }
  
  public String getNotTags() {
    return this.notTags;
  }
  
  public String getNotTagsAny() {
    return this.notTagsAny;
  }
  
  public String getProjectId() {
    return this.projectId;
  }
  
  public String getSortDir() {
    return this.sortDir;
  }
  
  public String getSortKey() {
    return this.sortKey;
  }
  
  public String getSubnetpoolId() {
    return this.subnetpoolId;
  }
  
  public String getTags() {
    return this.tags;
  }
  
  public String getTagsAny() {
    return this.tagsAny;
  }
  
  public String getTenantId() {
    return this.tenantId;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCidr() {
    return this.cidr != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasEnableDhcp() {
    return this.enableDhcp != null;
  }
  
  public boolean hasGatewayIp() {
    return this.gatewayIp != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasIpVersion() {
    return this.ipVersion != null;
  }
  
  public boolean hasIpv6AddressMode() {
    return this.ipv6AddressMode != null;
  }
  
  public boolean hasIpv6RaMode() {
    return this.ipv6RaMode != null;
  }
  
  public boolean hasLimit() {
    return this.limit != null;
  }
  
  public boolean hasMarker() {
    return this.marker != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNetworkId() {
    return this.networkId != null;
  }
  
  public boolean hasNotTags() {
    return this.notTags != null;
  }
  
  public boolean hasNotTagsAny() {
    return this.notTagsAny != null;
  }
  
  public boolean hasProjectId() {
    return this.projectId != null;
  }
  
  public boolean hasSortDir() {
    return this.sortDir != null;
  }
  
  public boolean hasSortKey() {
    return this.sortKey != null;
  }
  
  public boolean hasSubnetpoolId() {
    return this.subnetpoolId != null;
  }
  
  public boolean hasTags() {
    return this.tags != null;
  }
  
  public boolean hasTagsAny() {
    return this.tagsAny != null;
  }
  
  public boolean hasTenantId() {
    return this.tenantId != null;
  }
  
  public int hashCode() {
    return Objects.hash(cidr, description, enableDhcp, gatewayIp, id, ipVersion, ipv6AddressMode, ipv6RaMode, limit, marker, name, networkId, notTags, notTagsAny, projectId, sortDir, sortKey, subnetpoolId, tags, tagsAny, tenantId, additionalProperties);
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
    if (!(cidr == null)) {
        sb.append("cidr:");
        sb.append(cidr);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(enableDhcp == null)) {
        sb.append("enableDhcp:");
        sb.append(enableDhcp);
        sb.append(",");
    }
    if (!(gatewayIp == null)) {
        sb.append("gatewayIp:");
        sb.append(gatewayIp);
        sb.append(",");
    }
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(ipVersion == null)) {
        sb.append("ipVersion:");
        sb.append(ipVersion);
        sb.append(",");
    }
    if (!(ipv6AddressMode == null)) {
        sb.append("ipv6AddressMode:");
        sb.append(ipv6AddressMode);
        sb.append(",");
    }
    if (!(ipv6RaMode == null)) {
        sb.append("ipv6RaMode:");
        sb.append(ipv6RaMode);
        sb.append(",");
    }
    if (!(limit == null)) {
        sb.append("limit:");
        sb.append(limit);
        sb.append(",");
    }
    if (!(marker == null)) {
        sb.append("marker:");
        sb.append(marker);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(networkId == null)) {
        sb.append("networkId:");
        sb.append(networkId);
        sb.append(",");
    }
    if (!(notTags == null)) {
        sb.append("notTags:");
        sb.append(notTags);
        sb.append(",");
    }
    if (!(notTagsAny == null)) {
        sb.append("notTagsAny:");
        sb.append(notTagsAny);
        sb.append(",");
    }
    if (!(projectId == null)) {
        sb.append("projectId:");
        sb.append(projectId);
        sb.append(",");
    }
    if (!(sortDir == null)) {
        sb.append("sortDir:");
        sb.append(sortDir);
        sb.append(",");
    }
    if (!(sortKey == null)) {
        sb.append("sortKey:");
        sb.append(sortKey);
        sb.append(",");
    }
    if (!(subnetpoolId == null)) {
        sb.append("subnetpoolId:");
        sb.append(subnetpoolId);
        sb.append(",");
    }
    if (!(tags == null)) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(tagsAny == null)) {
        sb.append("tagsAny:");
        sb.append(tagsAny);
        sb.append(",");
    }
    if (!(tenantId == null)) {
        sb.append("tenantId:");
        sb.append(tenantId);
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
  
  public A withCidr(String cidr) {
    this.cidr = cidr;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withEnableDhcp() {
    return withEnableDhcp(true);
  }
  
  public A withEnableDhcp(Boolean enableDhcp) {
    this.enableDhcp = enableDhcp;
    return (A) this;
  }
  
  public A withGatewayIp(String gatewayIp) {
    this.gatewayIp = gatewayIp;
    return (A) this;
  }
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withIpVersion(Integer ipVersion) {
    this.ipVersion = ipVersion;
    return (A) this;
  }
  
  public A withIpv6AddressMode(String ipv6AddressMode) {
    this.ipv6AddressMode = ipv6AddressMode;
    return (A) this;
  }
  
  public A withIpv6RaMode(String ipv6RaMode) {
    this.ipv6RaMode = ipv6RaMode;
    return (A) this;
  }
  
  public A withLimit(Integer limit) {
    this.limit = limit;
    return (A) this;
  }
  
  public A withMarker(String marker) {
    this.marker = marker;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNetworkId(String networkId) {
    this.networkId = networkId;
    return (A) this;
  }
  
  public A withNotTags(String notTags) {
    this.notTags = notTags;
    return (A) this;
  }
  
  public A withNotTagsAny(String notTagsAny) {
    this.notTagsAny = notTagsAny;
    return (A) this;
  }
  
  public A withProjectId(String projectId) {
    this.projectId = projectId;
    return (A) this;
  }
  
  public A withSortDir(String sortDir) {
    this.sortDir = sortDir;
    return (A) this;
  }
  
  public A withSortKey(String sortKey) {
    this.sortKey = sortKey;
    return (A) this;
  }
  
  public A withSubnetpoolId(String subnetpoolId) {
    this.subnetpoolId = subnetpoolId;
    return (A) this;
  }
  
  public A withTags(String tags) {
    this.tags = tags;
    return (A) this;
  }
  
  public A withTagsAny(String tagsAny) {
    this.tagsAny = tagsAny;
    return (A) this;
  }
  
  public A withTenantId(String tenantId) {
    this.tenantId = tenantId;
    return (A) this;
  }
  
}