
package io.fabric8.kubernetes.api.model.storage.v1beta1;

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

/**
 * StorageClass describes the parameters for a class of storage for which PersistentVolumes can be dynamically provisioned.<br><p> <br><p> StorageClasses are non-namespaced; the name of the storage class according to etcd is in ObjectMeta.Name.
 */
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
@Version("v1beta1")
@Group("storage.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class StorageClass implements Editable<StorageClassBuilder>, HasMetadata
{

    @JsonProperty("allowVolumeExpansion")
    private Boolean allowVolumeExpansion;
    @JsonProperty("allowedTopologies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySelectorTerm> allowedTopologies = new ArrayList<>();
    @JsonProperty("apiVersion")
    private String apiVersion = "storage.k8s.io/v1beta1";
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

    /**
     * AllowVolumeExpansion shows whether the storage class allow volume expand
     */
    @JsonProperty("allowVolumeExpansion")
    public Boolean getAllowVolumeExpansion() {
        return allowVolumeExpansion;
    }

    /**
     * AllowVolumeExpansion shows whether the storage class allow volume expand
     */
    @JsonProperty("allowVolumeExpansion")
    public void setAllowVolumeExpansion(Boolean allowVolumeExpansion) {
        this.allowVolumeExpansion = allowVolumeExpansion;
    }

    /**
     * Restrict the node topologies where volumes can be dynamically provisioned. Each volume plugin defines its own supported topology specifications. An empty TopologySelectorTerm list means there is no topology restriction. This field is only honored by servers that enable the VolumeScheduling feature.
     */
    @JsonProperty("allowedTopologies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TopologySelectorTerm> getAllowedTopologies() {
        return allowedTopologies;
    }

    /**
     * Restrict the node topologies where volumes can be dynamically provisioned. Each volume plugin defines its own supported topology specifications. An empty TopologySelectorTerm list means there is no topology restriction. This field is only honored by servers that enable the VolumeScheduling feature.
     */
    @JsonProperty("allowedTopologies")
    public void setAllowedTopologies(List<TopologySelectorTerm> allowedTopologies) {
        this.allowedTopologies = allowedTopologies;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * StorageClass describes the parameters for a class of storage for which PersistentVolumes can be dynamically provisioned.<br><p> <br><p> StorageClasses are non-namespaced; the name of the storage class according to etcd is in ObjectMeta.Name.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * StorageClass describes the parameters for a class of storage for which PersistentVolumes can be dynamically provisioned.<br><p> <br><p> StorageClasses are non-namespaced; the name of the storage class according to etcd is in ObjectMeta.Name.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * Dynamically provisioned PersistentVolumes of this storage class are created with these mountOptions, e.g. ["ro", "soft"]. Not validated - mount of the PVs will simply fail if one is invalid.
     */
    @JsonProperty("mountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMountOptions() {
        return mountOptions;
    }

    /**
     * Dynamically provisioned PersistentVolumes of this storage class are created with these mountOptions, e.g. ["ro", "soft"]. Not validated - mount of the PVs will simply fail if one is invalid.
     */
    @JsonProperty("mountOptions")
    public void setMountOptions(List<String> mountOptions) {
        this.mountOptions = mountOptions;
    }

    /**
     * Parameters holds the parameters for the provisioner that should create volumes of this storage class.
     */
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * Parameters holds the parameters for the provisioner that should create volumes of this storage class.
     */
    @JsonProperty("parameters")
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * Provisioner indicates the type of the provisioner.
     */
    @JsonProperty("provisioner")
    public String getProvisioner() {
        return provisioner;
    }

    /**
     * Provisioner indicates the type of the provisioner.
     */
    @JsonProperty("provisioner")
    public void setProvisioner(String provisioner) {
        this.provisioner = provisioner;
    }

    /**
     * Dynamically provisioned PersistentVolumes of this storage class are created with this reclaimPolicy. Defaults to Delete.
     */
    @JsonProperty("reclaimPolicy")
    public String getReclaimPolicy() {
        return reclaimPolicy;
    }

    /**
     * Dynamically provisioned PersistentVolumes of this storage class are created with this reclaimPolicy. Defaults to Delete.
     */
    @JsonProperty("reclaimPolicy")
    public void setReclaimPolicy(String reclaimPolicy) {
        this.reclaimPolicy = reclaimPolicy;
    }

    /**
     * VolumeBindingMode indicates how PersistentVolumeClaims should be provisioned and bound.  When unset, VolumeBindingImmediate is used. This field is only honored by servers that enable the VolumeScheduling feature.
     */
    @JsonProperty("volumeBindingMode")
    public String getVolumeBindingMode() {
        return volumeBindingMode;
    }

    /**
     * VolumeBindingMode indicates how PersistentVolumeClaims should be provisioned and bound.  When unset, VolumeBindingImmediate is used. This field is only honored by servers that enable the VolumeScheduling feature.
     */
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
        if (!(o instanceof StorageClass)) {
            return false;
        }
        StorageClass other = (StorageClass) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowVolumeExpansion = this.getAllowVolumeExpansion();
        Object other$allowVolumeExpansion = other.getAllowVolumeExpansion();
        if (this$allowVolumeExpansion == null ? other$allowVolumeExpansion != null : !this$allowVolumeExpansion.equals(other$allowVolumeExpansion)) {
            return false;
        }
        Object this$allowedTopologies = this.getAllowedTopologies();
        Object other$allowedTopologies = other.getAllowedTopologies();
        if (this$allowedTopologies == null ? other$allowedTopologies != null : !this$allowedTopologies.equals(other$allowedTopologies)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$mountOptions = this.getMountOptions();
        Object other$mountOptions = other.getMountOptions();
        if (this$mountOptions == null ? other$mountOptions != null : !this$mountOptions.equals(other$mountOptions)) {
            return false;
        }
        Object this$parameters = this.getParameters();
        Object other$parameters = other.getParameters();
        if (this$parameters == null ? other$parameters != null : !this$parameters.equals(other$parameters)) {
            return false;
        }
        Object this$provisioner = this.getProvisioner();
        Object other$provisioner = other.getProvisioner();
        if (this$provisioner == null ? other$provisioner != null : !this$provisioner.equals(other$provisioner)) {
            return false;
        }
        Object this$reclaimPolicy = this.getReclaimPolicy();
        Object other$reclaimPolicy = other.getReclaimPolicy();
        if (this$reclaimPolicy == null ? other$reclaimPolicy != null : !this$reclaimPolicy.equals(other$reclaimPolicy)) {
            return false;
        }
        Object this$volumeBindingMode = this.getVolumeBindingMode();
        Object other$volumeBindingMode = other.getVolumeBindingMode();
        if (this$volumeBindingMode == null ? other$volumeBindingMode != null : !this$volumeBindingMode.equals(other$volumeBindingMode)) {
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
        return other instanceof StorageClass;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowVolumeExpansion = this.getAllowVolumeExpansion();
        result = result * prime + ($allowVolumeExpansion == null ? 43 : $allowVolumeExpansion.hashCode());
        Object $allowedTopologies = this.getAllowedTopologies();
        result = result * prime + ($allowedTopologies == null ? 43 : $allowedTopologies.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $mountOptions = this.getMountOptions();
        result = result * prime + ($mountOptions == null ? 43 : $mountOptions.hashCode());
        Object $parameters = this.getParameters();
        result = result * prime + ($parameters == null ? 43 : $parameters.hashCode());
        Object $provisioner = this.getProvisioner();
        result = result * prime + ($provisioner == null ? 43 : $provisioner.hashCode());
        Object $reclaimPolicy = this.getReclaimPolicy();
        result = result * prime + ($reclaimPolicy == null ? 43 : $reclaimPolicy.hashCode());
        Object $volumeBindingMode = this.getVolumeBindingMode();
        result = result * prime + ($volumeBindingMode == null ? 43 : $volumeBindingMode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StorageClass(" + "allowVolumeExpansion=" + this.getAllowVolumeExpansion() + ", allowedTopologies=" + this.getAllowedTopologies() + ", apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", mountOptions=" + this.getMountOptions() + ", parameters=" + this.getParameters() + ", provisioner=" + this.getProvisioner() + ", reclaimPolicy=" + this.getReclaimPolicy() + ", volumeBindingMode=" + this.getVolumeBindingMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
