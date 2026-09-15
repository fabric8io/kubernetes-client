
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
    "base64data",
    "mediatype"
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
public class Icon implements Editable<IconBuilder>, KubernetesResource
{

    @JsonProperty("base64data")
    private String base64data;
    @JsonProperty("mediatype")
    private String mediatype;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Icon() {
    }

    public Icon(String base64data, String mediatype) {
        super();
        this.base64data = base64data;
        this.mediatype = mediatype;
    }

    @JsonProperty("base64data")
    public String getBase64data() {
        return base64data;
    }

    @JsonProperty("base64data")
    public void setBase64data(String base64data) {
        this.base64data = base64data;
    }

    @JsonProperty("mediatype")
    public String getMediatype() {
        return mediatype;
    }

    @JsonProperty("mediatype")
    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    @JsonIgnore
    public IconBuilder edit() {
        return new IconBuilder(this);
    }

    @JsonIgnore
    public IconBuilder toBuilder() {
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
        if (!(o instanceof Icon)) {
            return false;
        }
        Icon other = (Icon) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$base64data = this.getBase64data();
        Object other$base64data = other.getBase64data();
        if (this$base64data == null ? other$base64data != null : !this$base64data.equals(other$base64data)) {
            return false;
        }
        Object this$mediatype = this.getMediatype();
        Object other$mediatype = other.getMediatype();
        if (this$mediatype == null ? other$mediatype != null : !this$mediatype.equals(other$mediatype)) {
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
        return other instanceof Icon;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $base64data = this.getBase64data();
        result = result * prime + ($base64data == null ? 43 : $base64data.hashCode());
        Object $mediatype = this.getMediatype();
        result = result * prime + ($mediatype == null ? 43 : $mediatype.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Icon(" + "base64data=" + this.getBase64data() + ", mediatype=" + this.getMediatype() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
