
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ResourceClaimParameters defines resource requests for a ResourceClaim in an in-tree format understood by Kubernetes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "driverRequests",
    "generatedFrom",
    "shareable"
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
@Version("v1alpha2")
@Group("resource.k8s.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ResourceClaimParameters implements Editable<ResourceClaimParametersBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "resource.k8s.io/v1alpha2";
    @JsonProperty("driverRequests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DriverRequests> driverRequests = new ArrayList<>();
    @JsonProperty("generatedFrom")
    private ResourceClaimParametersReference generatedFrom;
    @JsonProperty("kind")
    private String kind = "ResourceClaimParameters";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("shareable")
    private Boolean shareable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceClaimParameters() {
    }

    public ResourceClaimParameters(String apiVersion, List<DriverRequests> driverRequests, ResourceClaimParametersReference generatedFrom, String kind, ObjectMeta metadata, Boolean shareable) {
        super();
        this.apiVersion = apiVersion;
        this.driverRequests = driverRequests;
        this.generatedFrom = generatedFrom;
        this.kind = kind;
        this.metadata = metadata;
        this.shareable = shareable;
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
     * DriverRequests describes all resources that are needed for the allocated claim. A single claim may use resources coming from different drivers. For each driver, this array has at most one entry which then may have one or more per-driver requests.<br><p> <br><p> May be empty, in which case the claim can always be allocated.
     */
    @JsonProperty("driverRequests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DriverRequests> getDriverRequests() {
        return driverRequests;
    }

    /**
     * DriverRequests describes all resources that are needed for the allocated claim. A single claim may use resources coming from different drivers. For each driver, this array has at most one entry which then may have one or more per-driver requests.<br><p> <br><p> May be empty, in which case the claim can always be allocated.
     */
    @JsonProperty("driverRequests")
    public void setDriverRequests(List<DriverRequests> driverRequests) {
        this.driverRequests = driverRequests;
    }

    /**
     * ResourceClaimParameters defines resource requests for a ResourceClaim in an in-tree format understood by Kubernetes.
     */
    @JsonProperty("generatedFrom")
    public ResourceClaimParametersReference getGeneratedFrom() {
        return generatedFrom;
    }

    /**
     * ResourceClaimParameters defines resource requests for a ResourceClaim in an in-tree format understood by Kubernetes.
     */
    @JsonProperty("generatedFrom")
    public void setGeneratedFrom(ResourceClaimParametersReference generatedFrom) {
        this.generatedFrom = generatedFrom;
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
     * ResourceClaimParameters defines resource requests for a ResourceClaim in an in-tree format understood by Kubernetes.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ResourceClaimParameters defines resource requests for a ResourceClaim in an in-tree format understood by Kubernetes.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * Shareable indicates whether the allocated claim is meant to be shareable by multiple consumers at the same time.
     */
    @JsonProperty("shareable")
    public Boolean getShareable() {
        return shareable;
    }

    /**
     * Shareable indicates whether the allocated claim is meant to be shareable by multiple consumers at the same time.
     */
    @JsonProperty("shareable")
    public void setShareable(Boolean shareable) {
        this.shareable = shareable;
    }

    @JsonIgnore
    public ResourceClaimParametersBuilder edit() {
        return new ResourceClaimParametersBuilder(this);
    }

    @JsonIgnore
    public ResourceClaimParametersBuilder toBuilder() {
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
        if (!(o instanceof ResourceClaimParameters)) {
            return false;
        }
        ResourceClaimParameters other = (ResourceClaimParameters) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$driverRequests = this.getDriverRequests();
        Object other$driverRequests = other.getDriverRequests();
        if (this$driverRequests == null ? other$driverRequests != null : !this$driverRequests.equals(other$driverRequests)) {
            return false;
        }
        Object this$generatedFrom = this.getGeneratedFrom();
        Object other$generatedFrom = other.getGeneratedFrom();
        if (this$generatedFrom == null ? other$generatedFrom != null : !this$generatedFrom.equals(other$generatedFrom)) {
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
        Object this$shareable = this.getShareable();
        Object other$shareable = other.getShareable();
        if (this$shareable == null ? other$shareable != null : !this$shareable.equals(other$shareable)) {
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
        return other instanceof ResourceClaimParameters;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $driverRequests = this.getDriverRequests();
        result = result * prime + ($driverRequests == null ? 43 : $driverRequests.hashCode());
        Object $generatedFrom = this.getGeneratedFrom();
        result = result * prime + ($generatedFrom == null ? 43 : $generatedFrom.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $shareable = this.getShareable();
        result = result * prime + ($shareable == null ? 43 : $shareable.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceClaimParameters(" + "apiVersion=" + this.getApiVersion() + ", driverRequests=" + this.getDriverRequests() + ", generatedFrom=" + this.getGeneratedFrom() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", shareable=" + this.getShareable() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
