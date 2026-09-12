
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
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
 * The image stream import resource provides an easy way for a user to find and import container images from other container image registries into the server. Individual images or an entire image repository may be imported, and users may choose to see the results of the import prior to tagging the resulting images into the specified image stream.<br><p> <br><p> This API is intended for end-user tools that need to see the metadata of the image prior to import (for instance, to generate an application from it). Clients that know the desired image can continue to create spec.tags directly into their image streams.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Version("v1")
@Group("image.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageStreamImport implements Editable<ImageStreamImportBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "image.openshift.io/v1";
    @JsonProperty("kind")
    private String kind = "ImageStreamImport";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("spec")
    private ImageStreamImportSpec spec;
    @JsonProperty("status")
    private ImageStreamImportStatus status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageStreamImport() {
    }

    public ImageStreamImport(String apiVersion, String kind, ObjectMeta metadata, ImageStreamImportSpec spec, ImageStreamImportStatus status) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.spec = spec;
        this.status = status;
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
     * The image stream import resource provides an easy way for a user to find and import container images from other container image registries into the server. Individual images or an entire image repository may be imported, and users may choose to see the results of the import prior to tagging the resulting images into the specified image stream.<br><p> <br><p> This API is intended for end-user tools that need to see the metadata of the image prior to import (for instance, to generate an application from it). Clients that know the desired image can continue to create spec.tags directly into their image streams.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * The image stream import resource provides an easy way for a user to find and import container images from other container image registries into the server. Individual images or an entire image repository may be imported, and users may choose to see the results of the import prior to tagging the resulting images into the specified image stream.<br><p> <br><p> This API is intended for end-user tools that need to see the metadata of the image prior to import (for instance, to generate an application from it). Clients that know the desired image can continue to create spec.tags directly into their image streams.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * The image stream import resource provides an easy way for a user to find and import container images from other container image registries into the server. Individual images or an entire image repository may be imported, and users may choose to see the results of the import prior to tagging the resulting images into the specified image stream.<br><p> <br><p> This API is intended for end-user tools that need to see the metadata of the image prior to import (for instance, to generate an application from it). Clients that know the desired image can continue to create spec.tags directly into their image streams.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public ImageStreamImportSpec getSpec() {
        return spec;
    }

    /**
     * The image stream import resource provides an easy way for a user to find and import container images from other container image registries into the server. Individual images or an entire image repository may be imported, and users may choose to see the results of the import prior to tagging the resulting images into the specified image stream.<br><p> <br><p> This API is intended for end-user tools that need to see the metadata of the image prior to import (for instance, to generate an application from it). Clients that know the desired image can continue to create spec.tags directly into their image streams.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spec")
    public void setSpec(ImageStreamImportSpec spec) {
        this.spec = spec;
    }

    /**
     * The image stream import resource provides an easy way for a user to find and import container images from other container image registries into the server. Individual images or an entire image repository may be imported, and users may choose to see the results of the import prior to tagging the resulting images into the specified image stream.<br><p> <br><p> This API is intended for end-user tools that need to see the metadata of the image prior to import (for instance, to generate an application from it). Clients that know the desired image can continue to create spec.tags directly into their image streams.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public ImageStreamImportStatus getStatus() {
        return status;
    }

    /**
     * The image stream import resource provides an easy way for a user to find and import container images from other container image registries into the server. Individual images or an entire image repository may be imported, and users may choose to see the results of the import prior to tagging the resulting images into the specified image stream.<br><p> <br><p> This API is intended for end-user tools that need to see the metadata of the image prior to import (for instance, to generate an application from it). Clients that know the desired image can continue to create spec.tags directly into their image streams.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("status")
    public void setStatus(ImageStreamImportStatus status) {
        this.status = status;
    }

    @JsonIgnore
    public ImageStreamImportBuilder edit() {
        return new ImageStreamImportBuilder(this);
    }

    @JsonIgnore
    public ImageStreamImportBuilder toBuilder() {
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
        if (!(o instanceof ImageStreamImport)) {
            return false;
        }
        ImageStreamImport other = (ImageStreamImport) o;
        if (!other.canEqual(this)) {
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
        Object this$spec = this.getSpec();
        Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof ImageStreamImport;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $spec = this.getSpec();
        result = result * prime + ($spec == null ? 43 : $spec.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageStreamImport(" + "apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", spec=" + this.getSpec() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
