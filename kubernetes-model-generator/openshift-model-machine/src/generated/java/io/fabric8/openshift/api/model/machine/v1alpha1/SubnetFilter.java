
package io.fabric8.openshift.api.model.machine.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidr",
    "description",
    "enableDhcp",
    "gateway_ip",
    "id",
    "ipVersion",
    "ipv6AddressMode",
    "ipv6RaMode",
    "limit",
    "marker",
    "name",
    "networkId",
    "notTags",
    "notTagsAny",
    "projectId",
    "sortDir",
    "sortKey",
    "subnetpoolId",
    "tags",
    "tagsAny",
    "tenantId"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SubnetFilter implements Editable<SubnetFilterBuilder>, KubernetesResource
{

    @JsonProperty("cidr")
    private String cidr;
    @JsonProperty("description")
    private String description;
    @JsonProperty("enableDhcp")
    private Boolean enableDhcp;
    @JsonProperty("gateway_ip")
    private String gatewayIp;
    @JsonProperty("id")
    private String id;
    @JsonProperty("ipVersion")
    private Integer ipVersion;
    @JsonProperty("ipv6AddressMode")
    private String ipv6AddressMode;
    @JsonProperty("ipv6RaMode")
    private String ipv6RaMode;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("marker")
    private String marker;
    @JsonProperty("name")
    private String name;
    @JsonProperty("networkId")
    private String networkId;
    @JsonProperty("notTags")
    private String notTags;
    @JsonProperty("notTagsAny")
    private String notTagsAny;
    @JsonProperty("projectId")
    private String projectId;
    @JsonProperty("sortDir")
    private String sortDir;
    @JsonProperty("sortKey")
    private String sortKey;
    @JsonProperty("subnetpoolId")
    private String subnetpoolId;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("tagsAny")
    private String tagsAny;
    @JsonProperty("tenantId")
    private String tenantId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubnetFilter() {
    }

    public SubnetFilter(String cidr, String description, Boolean enableDhcp, String gatewayIp, String id, Integer ipVersion, String ipv6AddressMode, String ipv6RaMode, Integer limit, String marker, String name, String networkId, String notTags, String notTagsAny, String projectId, String sortDir, String sortKey, String subnetpoolId, String tags, String tagsAny, String tenantId) {
        super();
        this.cidr = cidr;
        this.description = description;
        this.enableDhcp = enableDhcp;
        this.gatewayIp = gatewayIp;
        this.id = id;
        this.ipVersion = ipVersion;
        this.ipv6AddressMode = ipv6AddressMode;
        this.ipv6RaMode = ipv6RaMode;
        this.limit = limit;
        this.marker = marker;
        this.name = name;
        this.networkId = networkId;
        this.notTags = notTags;
        this.notTagsAny = notTagsAny;
        this.projectId = projectId;
        this.sortDir = sortDir;
        this.sortKey = sortKey;
        this.subnetpoolId = subnetpoolId;
        this.tags = tags;
        this.tagsAny = tagsAny;
        this.tenantId = tenantId;
    }

    /**
     * cidr filters subnets by CIDR.
     */
    @JsonProperty("cidr")
    public String getCidr() {
        return cidr;
    }

    /**
     * cidr filters subnets by CIDR.
     */
    @JsonProperty("cidr")
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     * description filters subnets by description.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description filters subnets by description.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Deprecated: enableDhcp is silently ignored. It has no replacement.
     */
    @JsonProperty("enableDhcp")
    public Boolean getEnableDhcp() {
        return enableDhcp;
    }

    /**
     * Deprecated: enableDhcp is silently ignored. It has no replacement.
     */
    @JsonProperty("enableDhcp")
    public void setEnableDhcp(Boolean enableDhcp) {
        this.enableDhcp = enableDhcp;
    }

    /**
     * gateway_ip filters subnets by gateway IP.
     */
    @JsonProperty("gateway_ip")
    public String getGatewayIp() {
        return gatewayIp;
    }

    /**
     * gateway_ip filters subnets by gateway IP.
     */
    @JsonProperty("gateway_ip")
    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    /**
     * id is the uuid of a specific subnet to use. If specified, id will not be validated. Instead server creation will fail with an appropriate error.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * id is the uuid of a specific subnet to use. If specified, id will not be validated. Instead server creation will fail with an appropriate error.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ipVersion filters subnets by IP version.
     */
    @JsonProperty("ipVersion")
    public Integer getIpVersion() {
        return ipVersion;
    }

    /**
     * ipVersion filters subnets by IP version.
     */
    @JsonProperty("ipVersion")
    public void setIpVersion(Integer ipVersion) {
        this.ipVersion = ipVersion;
    }

    /**
     * ipv6AddressMode filters subnets by IPv6 address mode.
     */
    @JsonProperty("ipv6AddressMode")
    public String getIpv6AddressMode() {
        return ipv6AddressMode;
    }

    /**
     * ipv6AddressMode filters subnets by IPv6 address mode.
     */
    @JsonProperty("ipv6AddressMode")
    public void setIpv6AddressMode(String ipv6AddressMode) {
        this.ipv6AddressMode = ipv6AddressMode;
    }

    /**
     * ipv6RaMode filters subnets by IPv6 router adversiement mode.
     */
    @JsonProperty("ipv6RaMode")
    public String getIpv6RaMode() {
        return ipv6RaMode;
    }

    /**
     * ipv6RaMode filters subnets by IPv6 router adversiement mode.
     */
    @JsonProperty("ipv6RaMode")
    public void setIpv6RaMode(String ipv6RaMode) {
        this.ipv6RaMode = ipv6RaMode;
    }

    /**
     * Deprecated: limit is silently ignored. It has no replacement.
     */
    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Deprecated: limit is silently ignored. It has no replacement.
     */
    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Deprecated: marker is silently ignored. It has no replacement.
     */
    @JsonProperty("marker")
    public String getMarker() {
        return marker;
    }

    /**
     * Deprecated: marker is silently ignored. It has no replacement.
     */
    @JsonProperty("marker")
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * name filters subnets by name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name filters subnets by name.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Deprecated: networkId is silently ignored. Set uuid on the containing network definition instead.
     */
    @JsonProperty("networkId")
    public String getNetworkId() {
        return networkId;
    }

    /**
     * Deprecated: networkId is silently ignored. Set uuid on the containing network definition instead.
     */
    @JsonProperty("networkId")
    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    /**
     * notTags filters by subnets which don't match all specified tags. NOT (t1 AND t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTags")
    public String getNotTags() {
        return notTags;
    }

    /**
     * notTags filters by subnets which don't match all specified tags. NOT (t1 AND t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTags")
    public void setNotTags(String notTags) {
        this.notTags = notTags;
    }

    /**
     * notTagsAny filters by subnets which don't match any specified tags. NOT (t1 OR t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTagsAny")
    public String getNotTagsAny() {
        return notTagsAny;
    }

    /**
     * notTagsAny filters by subnets which don't match any specified tags. NOT (t1 OR t2...) Multiple tags are comma separated.
     */
    @JsonProperty("notTagsAny")
    public void setNotTagsAny(String notTagsAny) {
        this.notTagsAny = notTagsAny;
    }

    /**
     * projectId filters subnets by project ID.
     */
    @JsonProperty("projectId")
    public String getProjectId() {
        return projectId;
    }

    /**
     * projectId filters subnets by project ID.
     */
    @JsonProperty("projectId")
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * Deprecated: sortDir is silently ignored. It has no replacement.
     */
    @JsonProperty("sortDir")
    public String getSortDir() {
        return sortDir;
    }

    /**
     * Deprecated: sortDir is silently ignored. It has no replacement.
     */
    @JsonProperty("sortDir")
    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    /**
     * Deprecated: sortKey is silently ignored. It has no replacement.
     */
    @JsonProperty("sortKey")
    public String getSortKey() {
        return sortKey;
    }

    /**
     * Deprecated: sortKey is silently ignored. It has no replacement.
     */
    @JsonProperty("sortKey")
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * subnetpoolId filters subnets by subnet pool ID.
     */
    @JsonProperty("subnetpoolId")
    public String getSubnetpoolId() {
        return subnetpoolId;
    }

    /**
     * subnetpoolId filters subnets by subnet pool ID.
     */
    @JsonProperty("subnetpoolId")
    public void setSubnetpoolId(String subnetpoolId) {
        this.subnetpoolId = subnetpoolId;
    }

    /**
     * tags filters by subnets containing all specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    /**
     * tags filters by subnets containing all specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * tagsAny filters by subnets containing any specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tagsAny")
    public String getTagsAny() {
        return tagsAny;
    }

    /**
     * tagsAny filters by subnets containing any specified tags. Multiple tags are comma separated.
     */
    @JsonProperty("tagsAny")
    public void setTagsAny(String tagsAny) {
        this.tagsAny = tagsAny;
    }

    /**
     * tenantId filters subnets by tenant ID. Deprecated: use projectId instead. tenantId will be ignored if projectId is set.
     */
    @JsonProperty("tenantId")
    public String getTenantId() {
        return tenantId;
    }

    /**
     * tenantId filters subnets by tenant ID. Deprecated: use projectId instead. tenantId will be ignored if projectId is set.
     */
    @JsonProperty("tenantId")
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @JsonIgnore
    public SubnetFilterBuilder edit() {
        return new SubnetFilterBuilder(this);
    }

    @JsonIgnore
    public SubnetFilterBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
