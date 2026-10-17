
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "osExtensionsImage",
    "osImage"
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
public class OSImageStreamSet implements Editable<OSImageStreamSetBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("osExtensionsImage")
    private String osExtensionsImage;
    @JsonProperty("osImage")
    private String osImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSImageStreamSet() {
    }

    public OSImageStreamSet(String name, String osExtensionsImage, String osImage) {
        super();
        this.name = name;
        this.osExtensionsImage = osExtensionsImage;
        this.osImage = osImage;
    }

    /**
     * name is the required identifier of the stream.<br><p> <br><p> name is determined by the operator based on the OCI label of the discovered OS or Extension Image.<br><p> <br><p> Must be a valid RFC 1123 subdomain between 1 and 253 characters in length, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.').
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the required identifier of the stream.<br><p> <br><p> name is determined by the operator based on the OCI label of the discovered OS or Extension Image.<br><p> <br><p> Must be a valid RFC 1123 subdomain between 1 and 253 characters in length, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.').
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * osExtensionsImage is a required OS Extensions Image referenced by digest.<br><p> <br><p> osExtensionsImage bundles the extra repositories used to enable extensions, augmenting the base operating system without modifying the underlying immutable osImage.<br><p> <br><p> The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("osExtensionsImage")
    public String getOsExtensionsImage() {
        return osExtensionsImage;
    }

    /**
     * osExtensionsImage is a required OS Extensions Image referenced by digest.<br><p> <br><p> osExtensionsImage bundles the extra repositories used to enable extensions, augmenting the base operating system without modifying the underlying immutable osImage.<br><p> <br><p> The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("osExtensionsImage")
    public void setOsExtensionsImage(String osExtensionsImage) {
        this.osExtensionsImage = osExtensionsImage;
    }

    /**
     * osImage is a required OS Image referenced by digest.<br><p> <br><p> osImage contains the immutable, fundamental operating system components, including the kernel and base utilities, that define the core environment for the node's host operating system.<br><p> <br><p> The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("osImage")
    public String getOsImage() {
        return osImage;
    }

    /**
     * osImage is a required OS Image referenced by digest.<br><p> <br><p> osImage contains the immutable, fundamental operating system components, including the kernel and base utilities, that define the core environment for the node's host operating system.<br><p> <br><p> The format of the image pull spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("osImage")
    public void setOsImage(String osImage) {
        this.osImage = osImage;
    }

    @JsonIgnore
    public OSImageStreamSetBuilder edit() {
        return new OSImageStreamSetBuilder(this);
    }

    @JsonIgnore
    public OSImageStreamSetBuilder toBuilder() {
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
        if (!(o instanceof OSImageStreamSet)) {
            return false;
        }
        OSImageStreamSet other = (OSImageStreamSet) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$osExtensionsImage = this.getOsExtensionsImage();
        Object other$osExtensionsImage = other.getOsExtensionsImage();
        if (this$osExtensionsImage == null ? other$osExtensionsImage != null : !this$osExtensionsImage.equals(other$osExtensionsImage)) {
            return false;
        }
        Object this$osImage = this.getOsImage();
        Object other$osImage = other.getOsImage();
        if (this$osImage == null ? other$osImage != null : !this$osImage.equals(other$osImage)) {
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
        return other instanceof OSImageStreamSet;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $osExtensionsImage = this.getOsExtensionsImage();
        result = result * prime + ($osExtensionsImage == null ? 43 : $osExtensionsImage.hashCode());
        Object $osImage = this.getOsImage();
        result = result * prime + ($osImage == null ? 43 : $osImage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OSImageStreamSet(" + "name=" + this.getName() + ", osExtensionsImage=" + this.getOsExtensionsImage() + ", osImage=" + this.getOsImage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
