
package io.fabric8.openshift.api.model.config.v1;

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
    "apiServerInternalURI",
    "apiServerURL",
    "controlPlaneTopology",
    "cpuPartitioning",
    "etcdDiscoveryDomain",
    "infrastructureName",
    "infrastructureTopology",
    "platform",
    "platformStatus"
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
public class InfrastructureStatus implements KubernetesResource
{

    @JsonProperty("apiServerInternalURI")
    private String apiServerInternalURI;
    @JsonProperty("apiServerURL")
    private String apiServerURL;
    @JsonProperty("controlPlaneTopology")
    private String controlPlaneTopology;
    @JsonProperty("cpuPartitioning")
    private String cpuPartitioning;
    @JsonProperty("etcdDiscoveryDomain")
    private String etcdDiscoveryDomain;
    @JsonProperty("infrastructureName")
    private String infrastructureName;
    @JsonProperty("infrastructureTopology")
    private String infrastructureTopology;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("platformStatus")
    private PlatformStatus platformStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InfrastructureStatus() {
    }

    public InfrastructureStatus(String apiServerInternalURI, String apiServerURL, String controlPlaneTopology, String cpuPartitioning, String etcdDiscoveryDomain, String infrastructureName, String infrastructureTopology, String platform, PlatformStatus platformStatus) {
        super();
        this.apiServerInternalURI = apiServerInternalURI;
        this.apiServerURL = apiServerURL;
        this.controlPlaneTopology = controlPlaneTopology;
        this.cpuPartitioning = cpuPartitioning;
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
        this.infrastructureName = infrastructureName;
        this.infrastructureTopology = infrastructureTopology;
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

    @JsonProperty("controlPlaneTopology")
    public String getControlPlaneTopology() {
        return controlPlaneTopology;
    }

    @JsonProperty("controlPlaneTopology")
    public void setControlPlaneTopology(String controlPlaneTopology) {
        this.controlPlaneTopology = controlPlaneTopology;
    }

    @JsonProperty("cpuPartitioning")
    public String getCpuPartitioning() {
        return cpuPartitioning;
    }

    @JsonProperty("cpuPartitioning")
    public void setCpuPartitioning(String cpuPartitioning) {
        this.cpuPartitioning = cpuPartitioning;
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

    @JsonProperty("infrastructureTopology")
    public String getInfrastructureTopology() {
        return infrastructureTopology;
    }

    @JsonProperty("infrastructureTopology")
    public void setInfrastructureTopology(String infrastructureTopology) {
        this.infrastructureTopology = infrastructureTopology;
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
