
package io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "authURL",
    "authVersion",
    "container",
    "domain",
    "domainID",
    "regionName",
    "tenant",
    "tenantID"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ImageRegistryConfigStorageSwift implements KubernetesResource
{

    @JsonProperty("authURL")
    private String authURL;
    @JsonProperty("authVersion")
    private String authVersion;
    @JsonProperty("container")
    private String container;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("domainID")
    private String domainID;
    @JsonProperty("regionName")
    private String regionName;
    @JsonProperty("tenant")
    private String tenant;
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageRegistryConfigStorageSwift() {
    }

    public ImageRegistryConfigStorageSwift(String authURL, String authVersion, String container, String domain, String domainID, String regionName, String tenant, String tenantID) {
        super();
        this.authURL = authURL;
        this.authVersion = authVersion;
        this.container = container;
        this.domain = domain;
        this.domainID = domainID;
        this.regionName = regionName;
        this.tenant = tenant;
        this.tenantID = tenantID;
    }

    @JsonProperty("authURL")
    public String getAuthURL() {
        return authURL;
    }

    @JsonProperty("authURL")
    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

    @JsonProperty("authVersion")
    public String getAuthVersion() {
        return authVersion;
    }

    @JsonProperty("authVersion")
    public void setAuthVersion(String authVersion) {
        this.authVersion = authVersion;
    }

    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("domainID")
    public String getDomainID() {
        return domainID;
    }

    @JsonProperty("domainID")
    public void setDomainID(String domainID) {
        this.domainID = domainID;
    }

    @JsonProperty("regionName")
    public String getRegionName() {
        return regionName;
    }

    @JsonProperty("regionName")
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @JsonProperty("tenant")
    public String getTenant() {
        return tenant;
    }

    @JsonProperty("tenant")
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
