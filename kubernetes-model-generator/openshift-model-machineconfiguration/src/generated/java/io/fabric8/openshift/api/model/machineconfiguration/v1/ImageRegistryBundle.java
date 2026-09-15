
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ImageRegistryBundle contains information for writing image registry certificates
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "file"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageRegistryBundle implements Editable<ImageRegistryBundleBuilder>, KubernetesResource
{

    @JsonProperty("data")
    private String data;
    @JsonProperty("file")
    private String file;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryBundle() {
    }

    public ImageRegistryBundle(String data, String file) {
        super();
        this.data = data;
        this.file = file;
    }

    /**
     * data holds the contents of the bundle that will be written to the file location
     */
    @JsonProperty("data")
    public String getData() {
        return data;
    }

    /**
     * data holds the contents of the bundle that will be written to the file location
     */
    @JsonProperty("data")
    public void setData(String data) {
        this.data = data;
    }

    /**
     * file holds the name of the file where the bundle will be written to disk
     */
    @JsonProperty("file")
    public String getFile() {
        return file;
    }

    /**
     * file holds the name of the file where the bundle will be written to disk
     */
    @JsonProperty("file")
    public void setFile(String file) {
        this.file = file;
    }

    @JsonIgnore
    public ImageRegistryBundleBuilder edit() {
        return new ImageRegistryBundleBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryBundleBuilder toBuilder() {
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
        if (!(o instanceof ImageRegistryBundle)) {
            return false;
        }
        ImageRegistryBundle other = (ImageRegistryBundle) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$data = this.getData();
        Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) {
            return false;
        }
        Object this$file = this.getFile();
        Object other$file = other.getFile();
        if (this$file == null ? other$file != null : !this$file.equals(other$file)) {
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
        return other instanceof ImageRegistryBundle;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $data = this.getData();
        result = result * prime + ($data == null ? 43 : $data.hashCode());
        Object $file = this.getFile();
        result = result * prime + ($file == null ? 43 : $file.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageRegistryBundle(" + "data=" + this.getData() + ", file=" + this.getFile() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
