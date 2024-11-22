
package io.fabric8.kubernetes.api.model.storage.v1beta1;

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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.TopologySelectorTerm;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1beta1")
@Group("storage.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class StorageClass implements Editable<StorageClassBuilder> , HasMetadata
{

    @JsonProperty("allowVolumeExpansion")
    private Boolean allowVolumeExpansion;
    @JsonProperty("allowedTopologies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySelectorTerm> allowedTopologies = new ArrayList<>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "storage.k8s.io/v1beta1";
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "StorageClass";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("mountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> mountOptions = new ArrayList<>();
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> parameters = new LinkedHashMap<>();
    @JsonProperty("provisioner")
    private String provisioner;
    @JsonProperty("reclaimPolicy")
    private String reclaimPolicy;
    @JsonProperty("volumeBindingMode")
    private String volumeBindingMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public StorageClass() {
    }

    public StorageClass(Boolean allowVolumeExpansion, List<TopologySelectorTerm> allowedTopologies, String apiVersion, String kind, ObjectMeta metadata, List<String> mountOptions, Map<String, String> parameters, String provisioner, String reclaimPolicy, String volumeBindingMode) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("mountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMountOptions() {
        return mountOptions;
    }

    @JsonProperty("mountOptions")
    public void setMountOptions(List<String> mountOptions) {
        this.mountOptions = mountOptions;
    }

    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("provisioner")
    public String getProvisioner() {
        return provisioner;
    }

    @JsonProperty("provisioner")
    public void setProvisioner(String provisioner) {
        this.provisioner = provisioner;
    }

    @JsonProperty("reclaimPolicy")
    public String getReclaimPolicy() {
        return reclaimPolicy;
    }

    @JsonProperty("reclaimPolicy")
    public void setReclaimPolicy(String reclaimPolicy) {
        this.reclaimPolicy = reclaimPolicy;
    }

    @JsonProperty("volumeBindingMode")
    public String getVolumeBindingMode() {
        return volumeBindingMode;
    }

    @JsonProperty("volumeBindingMode")
    public void setVolumeBindingMode(String volumeBindingMode) {
        this.volumeBindingMode = volumeBindingMode;
    }

    @JsonIgnore
    public StorageClassBuilder edit() {
        return new StorageClassBuilder(this);
    }

    @JsonIgnore
    public StorageClassBuilder toBuilder() {
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
