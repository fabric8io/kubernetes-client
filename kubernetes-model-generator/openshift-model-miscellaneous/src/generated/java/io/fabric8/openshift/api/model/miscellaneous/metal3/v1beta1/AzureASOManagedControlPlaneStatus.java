
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1.APIEndpoint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureASOManagedControlPlaneStatus defines the observed state of AzureASOManagedControlPlane.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controlPlaneEndpoint",
    "initialized",
    "ready",
    "resources",
    "version"
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
public class AzureASOManagedControlPlaneStatus implements Editable<AzureASOManagedControlPlaneStatusBuilder>, KubernetesResource
{

    @JsonProperty("controlPlaneEndpoint")
    private APIEndpoint controlPlaneEndpoint;
    @JsonProperty("initialized")
    private Boolean initialized;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceStatus> resources = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureASOManagedControlPlaneStatus() {
    }

    public AzureASOManagedControlPlaneStatus(APIEndpoint controlPlaneEndpoint, Boolean initialized, Boolean ready, List<ResourceStatus> resources, String version) {
        super();
        this.controlPlaneEndpoint = controlPlaneEndpoint;
        this.initialized = initialized;
        this.ready = ready;
        this.resources = resources;
        this.version = version;
    }

    /**
     * AzureASOManagedControlPlaneStatus defines the observed state of AzureASOManagedControlPlane.
     */
    @JsonProperty("controlPlaneEndpoint")
    public APIEndpoint getControlPlaneEndpoint() {
        return controlPlaneEndpoint;
    }

    /**
     * AzureASOManagedControlPlaneStatus defines the observed state of AzureASOManagedControlPlane.
     */
    @JsonProperty("controlPlaneEndpoint")
    public void setControlPlaneEndpoint(APIEndpoint controlPlaneEndpoint) {
        this.controlPlaneEndpoint = controlPlaneEndpoint;
    }

    /**
     * Initialized represents whether or not the API server has been provisioned. It fulfills Cluster API's control plane provider contract. For AKS, this is equivalent to `ready`.
     */
    @JsonProperty("initialized")
    public Boolean getInitialized() {
        return initialized;
    }

    /**
     * Initialized represents whether or not the API server has been provisioned. It fulfills Cluster API's control plane provider contract. For AKS, this is equivalent to `ready`.
     */
    @JsonProperty("initialized")
    public void setInitialized(Boolean initialized) {
        this.initialized = initialized;
    }

    /**
     * Ready represents whether or not the API server is ready to receive requests. It fulfills Cluster API's control plane provider contract. For AKS, this is equivalent to `initialized`.
     */
    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    /**
     * Ready represents whether or not the API server is ready to receive requests. It fulfills Cluster API's control plane provider contract. For AKS, this is equivalent to `initialized`.
     */
    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    /**
     * AzureASOManagedControlPlaneStatus defines the observed state of AzureASOManagedControlPlane.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceStatus> getResources() {
        return resources;
    }

    /**
     * AzureASOManagedControlPlaneStatus defines the observed state of AzureASOManagedControlPlane.
     */
    @JsonProperty("resources")
    public void setResources(List<ResourceStatus> resources) {
        this.resources = resources;
    }

    /**
     * Version is the observed Kubernetes version of the control plane. It fulfills Cluster API's control plane provider contract.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version is the observed Kubernetes version of the control plane. It fulfills Cluster API's control plane provider contract.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public AzureASOManagedControlPlaneStatusBuilder edit() {
        return new AzureASOManagedControlPlaneStatusBuilder(this);
    }

    @JsonIgnore
    public AzureASOManagedControlPlaneStatusBuilder toBuilder() {
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
