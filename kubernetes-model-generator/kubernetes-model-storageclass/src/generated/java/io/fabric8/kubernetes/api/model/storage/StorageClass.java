
package io.fabric8.kubernetes.api.model.storage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.TopologySelectorTerm;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
    "allowVolumeExpansion",
    "allowedTopologies",
    "mountOptions",
    "parameters",
    "provisioner",
    "reclaimPolicy",
    "volumeBindingMode"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("storage.k8s.io")
@Generated("jsonschema2pojo")
public class StorageClass implements HasMetadata
{

    @JsonProperty("allowVolumeExpansion")
    private Boolean allowVolumeExpansion;
    @JsonProperty("allowedTopologies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySelectorTerm> allowedTopologies = new ArrayList<TopologySelectorTerm>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private java.lang.String apiVersion = "storage.k8s.io/v1";
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private java.lang.String kind = "StorageClass";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("mountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> mountOptions = new ArrayList<java.lang.String>();
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> parameters = new LinkedHashMap<String, String>();
    @JsonProperty("provisioner")
    private java.lang.String provisioner;
    @JsonProperty("reclaimPolicy")
    private java.lang.String reclaimPolicy;
    @JsonProperty("volumeBindingMode")
    private java.lang.String volumeBindingMode;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StorageClass() {
    }

    public StorageClass(Boolean allowVolumeExpansion, List<TopologySelectorTerm> allowedTopologies, java.lang.String apiVersion, java.lang.String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, List<java.lang.String> mountOptions, Map<String, String> parameters, java.lang.String provisioner, java.lang.String reclaimPolicy, java.lang.String volumeBindingMode) {
        super();
        this.allowVolumeExpansion = allowVolumeExpansion;
        this.allowedTopologies = allowedTopologies;
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.mountOptions = mountOptions;
        this.parameters = parameters;
        this.provisioner = provisioner;
        this.reclaimPolicy = reclaimPolicy;
        this.volumeBindingMode = volumeBindingMode;
    }

    @JsonProperty("allowVolumeExpansion")
    public Boolean getAllowVolumeExpansion() {
        return allowVolumeExpansion;
    }

    @JsonProperty("allowVolumeExpansion")
    public void setAllowVolumeExpansion(Boolean allowVolumeExpansion) {
        this.allowVolumeExpansion = allowVolumeExpansion;
    }

    @JsonProperty("allowedTopologies")
    public List<TopologySelectorTerm> getAllowedTopologies() {
        return allowedTopologies;
    }

    @JsonProperty("allowedTopologies")
    public void setAllowedTopologies(List<TopologySelectorTerm> allowedTopologies) {
        this.allowedTopologies = allowedTopologies;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("mountOptions")
    public List<java.lang.String> getMountOptions() {
        return mountOptions;
    }

    @JsonProperty("mountOptions")
    public void setMountOptions(List<java.lang.String> mountOptions) {
        this.mountOptions = mountOptions;
    }

    @JsonProperty("parameters")
    public Map<String, String> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("provisioner")
    public java.lang.String getProvisioner() {
        return provisioner;
    }

    @JsonProperty("provisioner")
    public void setProvisioner(java.lang.String provisioner) {
        this.provisioner = provisioner;
    }

    @JsonProperty("reclaimPolicy")
    public java.lang.String getReclaimPolicy() {
        return reclaimPolicy;
    }

    @JsonProperty("reclaimPolicy")
    public void setReclaimPolicy(java.lang.String reclaimPolicy) {
        this.reclaimPolicy = reclaimPolicy;
    }

    @JsonProperty("volumeBindingMode")
    public java.lang.String getVolumeBindingMode() {
        return volumeBindingMode;
    }

    @JsonProperty("volumeBindingMode")
    public void setVolumeBindingMode(java.lang.String volumeBindingMode) {
        this.volumeBindingMode = volumeBindingMode;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
