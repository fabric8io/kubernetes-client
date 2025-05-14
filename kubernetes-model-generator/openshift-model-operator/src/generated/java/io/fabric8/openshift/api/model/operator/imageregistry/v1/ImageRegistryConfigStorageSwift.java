
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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

/**
 * ImageRegistryConfigStorageSwift holds the information to configure the registry to use the OpenStack Swift service for backend storage https://docs.docker.com/registry/storage-drivers/swift/
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class ImageRegistryConfigStorageSwift implements Editable<ImageRegistryConfigStorageSwiftBuilder>, KubernetesResource
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

    /**
     * authURL defines the URL for obtaining an authentication token.
     */
    @JsonProperty("authURL")
    public String getAuthURL() {
        return authURL;
    }

    /**
     * authURL defines the URL for obtaining an authentication token.
     */
    @JsonProperty("authURL")
    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

    /**
     * authVersion specifies the OpenStack Auth's version.
     */
    @JsonProperty("authVersion")
    public String getAuthVersion() {
        return authVersion;
    }

    /**
     * authVersion specifies the OpenStack Auth's version.
     */
    @JsonProperty("authVersion")
    public void setAuthVersion(String authVersion) {
        this.authVersion = authVersion;
    }

    /**
     * container defines the name of Swift container where to store the registry's data.
     */
    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    /**
     * container defines the name of Swift container where to store the registry's data.
     */
    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * domain specifies Openstack's domain name for Identity v3 API.
     */
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    /**
     * domain specifies Openstack's domain name for Identity v3 API.
     */
    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * domainID specifies Openstack's domain id for Identity v3 API.
     */
    @JsonProperty("domainID")
    public String getDomainID() {
        return domainID;
    }

    /**
     * domainID specifies Openstack's domain id for Identity v3 API.
     */
    @JsonProperty("domainID")
    public void setDomainID(String domainID) {
        this.domainID = domainID;
    }

    /**
     * regionName defines Openstack's region in which container exists.
     */
    @JsonProperty("regionName")
    public String getRegionName() {
        return regionName;
    }

    /**
     * regionName defines Openstack's region in which container exists.
     */
    @JsonProperty("regionName")
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * tenant defines Openstack tenant name to be used by registry.
     */
    @JsonProperty("tenant")
    public String getTenant() {
        return tenant;
    }

    /**
     * tenant defines Openstack tenant name to be used by registry.
     */
    @JsonProperty("tenant")
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    /**
     * tenant defines Openstack tenant id to be used by registry.
     */
    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    /**
     * tenant defines Openstack tenant id to be used by registry.
     */
    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    @JsonIgnore
    public ImageRegistryConfigStorageSwiftBuilder edit() {
        return new ImageRegistryConfigStorageSwiftBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigStorageSwiftBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
