
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * BuildParams is used to build tags around an azure resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Additional",
    "ClusterName",
    "Lifecycle",
    "Name",
    "ResourceID",
    "Role"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class BuildParams implements Editable<BuildParamsBuilder>, KubernetesResource
{

    @JsonProperty("Additional")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> additional = new LinkedHashMap<>();
    @JsonProperty("ClusterName")
    private String clusterName;
    @JsonProperty("Lifecycle")
    private String lifecycle;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ResourceID")
    private String resourceID;
    @JsonProperty("Role")
    private String role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildParams() {
    }

    public BuildParams(Map<String, String> additional, String clusterName, String lifecycle, String name, String resourceID, String role) {
        super();
        this.additional = additional;
        this.clusterName = clusterName;
        this.lifecycle = lifecycle;
        this.name = name;
        this.resourceID = resourceID;
        this.role = role;
    }

    /**
     * Any additional tags to be added to the resource.
     */
    @JsonProperty("Additional")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAdditional() {
        return additional;
    }

    /**
     * Any additional tags to be added to the resource.
     */
    @JsonProperty("Additional")
    public void setAdditional(Map<String, String> additional) {
        this.additional = additional;
    }

    /**
     * ClusterName is the cluster associated with the resource.
     */
    @JsonProperty("ClusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * ClusterName is the cluster associated with the resource.
     */
    @JsonProperty("ClusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * Lifecycle determines the resource lifecycle.
     */
    @JsonProperty("Lifecycle")
    public String getLifecycle() {
        return lifecycle;
    }

    /**
     * Lifecycle determines the resource lifecycle.
     */
    @JsonProperty("Lifecycle")
    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    /**
     * Name is the name of the resource, it's applied as the tag "Name" on Azure.
     */
    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the resource, it's applied as the tag "Name" on Azure.
     */
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ResourceID is the unique identifier of the resource to be tagged.
     */
    @JsonProperty("ResourceID")
    public String getResourceID() {
        return resourceID;
    }

    /**
     * ResourceID is the unique identifier of the resource to be tagged.
     */
    @JsonProperty("ResourceID")
    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    /**
     * Role is the role associated to the resource.
     */
    @JsonProperty("Role")
    public String getRole() {
        return role;
    }

    /**
     * Role is the role associated to the resource.
     */
    @JsonProperty("Role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    public BuildParamsBuilder edit() {
        return new BuildParamsBuilder(this);
    }

    @JsonIgnore
    public BuildParamsBuilder toBuilder() {
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
