
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
 * ImageRegistryConfigRequests defines registry limits on requests read and write.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "read",
    "write"
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
public class ImageRegistryConfigRequests implements Editable<ImageRegistryConfigRequestsBuilder>, KubernetesResource
{

    @JsonProperty("read")
    private ImageRegistryConfigRequestsLimits read;
    @JsonProperty("write")
    private ImageRegistryConfigRequestsLimits write;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigRequests() {
    }

    public ImageRegistryConfigRequests(ImageRegistryConfigRequestsLimits read, ImageRegistryConfigRequestsLimits write) {
        super();
        this.read = read;
        this.write = write;
    }

    /**
     * ImageRegistryConfigRequests defines registry limits on requests read and write.
     */
    @JsonProperty("read")
    public ImageRegistryConfigRequestsLimits getRead() {
        return read;
    }

    /**
     * ImageRegistryConfigRequests defines registry limits on requests read and write.
     */
    @JsonProperty("read")
    public void setRead(ImageRegistryConfigRequestsLimits read) {
        this.read = read;
    }

    /**
     * ImageRegistryConfigRequests defines registry limits on requests read and write.
     */
    @JsonProperty("write")
    public ImageRegistryConfigRequestsLimits getWrite() {
        return write;
    }

    /**
     * ImageRegistryConfigRequests defines registry limits on requests read and write.
     */
    @JsonProperty("write")
    public void setWrite(ImageRegistryConfigRequestsLimits write) {
        this.write = write;
    }

    @JsonIgnore
    public ImageRegistryConfigRequestsBuilder edit() {
        return new ImageRegistryConfigRequestsBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigRequestsBuilder toBuilder() {
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
        if (!(o instanceof ImageRegistryConfigRequests)) {
            return false;
        }
        ImageRegistryConfigRequests other = (ImageRegistryConfigRequests) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$read = this.getRead();
        Object other$read = other.getRead();
        if (this$read == null ? other$read != null : !this$read.equals(other$read)) {
            return false;
        }
        Object this$write = this.getWrite();
        Object other$write = other.getWrite();
        if (this$write == null ? other$write != null : !this$write.equals(other$write)) {
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
        return other instanceof ImageRegistryConfigRequests;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $read = this.getRead();
        result = result * prime + ($read == null ? 43 : $read.hashCode());
        Object $write = this.getWrite();
        result = result * prime + ($write == null ? 43 : $write.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageRegistryConfigRequests(" + "read=" + this.getRead() + ", write=" + this.getWrite() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
