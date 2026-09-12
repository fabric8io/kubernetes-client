
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ImageRegistryConfigStorageSwift)) {
            return false;
        }
        ImageRegistryConfigStorageSwift other = (ImageRegistryConfigStorageSwift) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$authURL = this.getAuthURL();
        Object other$authURL = other.getAuthURL();
        if (this$authURL == null ? other$authURL != null : !this$authURL.equals(other$authURL)) {
            return false;
        }
        Object this$authVersion = this.getAuthVersion();
        Object other$authVersion = other.getAuthVersion();
        if (this$authVersion == null ? other$authVersion != null : !this$authVersion.equals(other$authVersion)) {
            return false;
        }
        Object this$container = this.getContainer();
        Object other$container = other.getContainer();
        if (this$container == null ? other$container != null : !this$container.equals(other$container)) {
            return false;
        }
        Object this$domain = this.getDomain();
        Object other$domain = other.getDomain();
        if (this$domain == null ? other$domain != null : !this$domain.equals(other$domain)) {
            return false;
        }
        Object this$domainID = this.getDomainID();
        Object other$domainID = other.getDomainID();
        if (this$domainID == null ? other$domainID != null : !this$domainID.equals(other$domainID)) {
            return false;
        }
        Object this$regionName = this.getRegionName();
        Object other$regionName = other.getRegionName();
        if (this$regionName == null ? other$regionName != null : !this$regionName.equals(other$regionName)) {
            return false;
        }
        Object this$tenant = this.getTenant();
        Object other$tenant = other.getTenant();
        if (this$tenant == null ? other$tenant != null : !this$tenant.equals(other$tenant)) {
            return false;
        }
        Object this$tenantID = this.getTenantID();
        Object other$tenantID = other.getTenantID();
        if (this$tenantID == null ? other$tenantID != null : !this$tenantID.equals(other$tenantID)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ImageRegistryConfigStorageSwift;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $authURL = this.getAuthURL();
        result = result * prime + ($authURL == null ? 43 : $authURL.hashCode());
        Object $authVersion = this.getAuthVersion();
        result = result * prime + ($authVersion == null ? 43 : $authVersion.hashCode());
        Object $container = this.getContainer();
        result = result * prime + ($container == null ? 43 : $container.hashCode());
        Object $domain = this.getDomain();
        result = result * prime + ($domain == null ? 43 : $domain.hashCode());
        Object $domainID = this.getDomainID();
        result = result * prime + ($domainID == null ? 43 : $domainID.hashCode());
        Object $regionName = this.getRegionName();
        result = result * prime + ($regionName == null ? 43 : $regionName.hashCode());
        Object $tenant = this.getTenant();
        result = result * prime + ($tenant == null ? 43 : $tenant.hashCode());
        Object $tenantID = this.getTenantID();
        result = result * prime + ($tenantID == null ? 43 : $tenantID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageRegistryConfigStorageSwift(" + "authURL=" + this.getAuthURL() + ", authVersion=" + this.getAuthVersion() + ", container=" + this.getContainer() + ", domain=" + this.getDomain() + ", domainID=" + this.getDomainID() + ", regionName=" + this.getRegionName() + ", tenant=" + this.getTenant() + ", tenantID=" + this.getTenantID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
