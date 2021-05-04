
package io.fabric8.openshift.api.model;

import java.util.HashMap;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "apiServerInternalURI",
    "apiServerURL",
    "etcdDiscoveryDomain",
    "infrastructureName",
    "platform",
    "platformStatus"
})
@ToString
@EqualsAndHashCode
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
public class InfrastructureStatus implements KubernetesResource
{

    @JsonProperty("apiServerInternalURI")
    private String apiServerInternalURI;
    @JsonProperty("apiServerURL")
    private String apiServerURL;
    @JsonProperty("etcdDiscoveryDomain")
    private String etcdDiscoveryDomain;
    @JsonProperty("infrastructureName")
    private String infrastructureName;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("platformStatus")
    private PlatformStatus platformStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfrastructureStatus() {
    }

    /**
     * 
     * @param apiServerInternalURI
     * @param etcdDiscoveryDomain
     * @param infrastructureName
     * @param apiServerURL
     * @param platformStatus
     * @param platform
     */
    public InfrastructureStatus(String apiServerInternalURI, String apiServerURL, String etcdDiscoveryDomain, String infrastructureName, String platform, PlatformStatus platformStatus) {
        super();
        this.apiServerInternalURI = apiServerInternalURI;
        this.apiServerURL = apiServerURL;
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
        this.infrastructureName = infrastructureName;
        this.platform = platform;
        this.platformStatus = platformStatus;
    }

    @JsonProperty("apiServerInternalURI")
    public String getApiServerInternalURI() {
        return apiServerInternalURI;
    }

    @JsonProperty("apiServerInternalURI")
    public void setApiServerInternalURI(String apiServerInternalURI) {
        this.apiServerInternalURI = apiServerInternalURI;
    }

    @JsonProperty("apiServerURL")
    public String getApiServerURL() {
        return apiServerURL;
    }

    @JsonProperty("apiServerURL")
    public void setApiServerURL(String apiServerURL) {
        this.apiServerURL = apiServerURL;
    }

    @JsonProperty("etcdDiscoveryDomain")
    public String getEtcdDiscoveryDomain() {
        return etcdDiscoveryDomain;
    }

    @JsonProperty("etcdDiscoveryDomain")
    public void setEtcdDiscoveryDomain(String etcdDiscoveryDomain) {
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
    }

    @JsonProperty("infrastructureName")
    public String getInfrastructureName() {
        return infrastructureName;
    }

    @JsonProperty("infrastructureName")
    public void setInfrastructureName(String infrastructureName) {
        this.infrastructureName = infrastructureName;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("platformStatus")
    public PlatformStatus getPlatformStatus() {
        return platformStatus;
    }

    @JsonProperty("platformStatus")
    public void setPlatformStatus(PlatformStatus platformStatus) {
        this.platformStatus = platformStatus;
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
