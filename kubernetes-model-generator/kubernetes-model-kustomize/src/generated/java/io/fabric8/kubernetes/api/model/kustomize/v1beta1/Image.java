
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "digest",
    "name",
    "newName",
    "newTag",
    "tagSuffix"
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
public class Image implements Editable<ImageBuilder>, KubernetesResource
{

    @JsonProperty("digest")
    private String digest;
    @JsonProperty("name")
    private String name;
    @JsonProperty("newName")
    private String newName;
    @JsonProperty("newTag")
    private String newTag;
    @JsonProperty("tagSuffix")
    private String tagSuffix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Image() {
    }

    public Image(String digest, String name, String newName, String newTag, String tagSuffix) {
        super();
        this.digest = digest;
        this.name = name;
        this.newName = newName;
        this.newTag = newTag;
        this.tagSuffix = tagSuffix;
    }

    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    @JsonProperty("digest")
    public void setDigest(String digest) {
        this.digest = digest;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("newName")
    public String getNewName() {
        return newName;
    }

    @JsonProperty("newName")
    public void setNewName(String newName) {
        this.newName = newName;
    }

    @JsonProperty("newTag")
    public String getNewTag() {
        return newTag;
    }

    @JsonProperty("newTag")
    public void setNewTag(String newTag) {
        this.newTag = newTag;
    }

    @JsonProperty("tagSuffix")
    public String getTagSuffix() {
        return tagSuffix;
    }

    @JsonProperty("tagSuffix")
    public void setTagSuffix(String tagSuffix) {
        this.tagSuffix = tagSuffix;
    }

    @JsonIgnore
    public ImageBuilder edit() {
        return new ImageBuilder(this);
    }

    @JsonIgnore
    public ImageBuilder toBuilder() {
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
        if (!(o instanceof Image)) {
            return false;
        }
        Image other = (Image) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$digest = this.getDigest();
        Object other$digest = other.getDigest();
        if (this$digest == null ? other$digest != null : !this$digest.equals(other$digest)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$newName = this.getNewName();
        Object other$newName = other.getNewName();
        if (this$newName == null ? other$newName != null : !this$newName.equals(other$newName)) {
            return false;
        }
        Object this$newTag = this.getNewTag();
        Object other$newTag = other.getNewTag();
        if (this$newTag == null ? other$newTag != null : !this$newTag.equals(other$newTag)) {
            return false;
        }
        Object this$tagSuffix = this.getTagSuffix();
        Object other$tagSuffix = other.getTagSuffix();
        if (this$tagSuffix == null ? other$tagSuffix != null : !this$tagSuffix.equals(other$tagSuffix)) {
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
        return other instanceof Image;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $digest = this.getDigest();
        result = result * prime + ($digest == null ? 43 : $digest.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $newName = this.getNewName();
        result = result * prime + ($newName == null ? 43 : $newName.hashCode());
        Object $newTag = this.getNewTag();
        result = result * prime + ($newTag == null ? 43 : $newTag.hashCode());
        Object $tagSuffix = this.getTagSuffix();
        result = result * prime + ($tagSuffix == null ? 43 : $tagSuffix.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Image(" + "digest=" + this.getDigest() + ", name=" + this.getName() + ", newName=" + this.getNewName() + ", newTag=" + this.getNewTag() + ", tagSuffix=" + this.getTagSuffix() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
