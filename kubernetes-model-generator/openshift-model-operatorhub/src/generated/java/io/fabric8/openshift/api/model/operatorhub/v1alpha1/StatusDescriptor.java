
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "displayName",
    "path",
    "value",
    "x-descriptors"
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
public class StatusDescriptor implements Editable<StatusDescriptorBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("path")
    private String path;
    @JsonProperty("value")
    private String value;
    @JsonProperty("x-descriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> xDescriptors = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatusDescriptor() {
    }

    public StatusDescriptor(String description, String displayName, String path, String value, List<String> xDescriptors) {
        super();
        this.description = description;
        this.displayName = displayName;
        this.path = path;
        this.value = value;
        this.xDescriptors = xDescriptors;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("x-descriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getXDescriptors() {
        return xDescriptors;
    }

    /**
     * StatusDescriptor describes a field in a status block of a CRD so that OLM can consume it
     */
    @JsonProperty("x-descriptors")
    public void setXDescriptors(List<String> xDescriptors) {
        this.xDescriptors = xDescriptors;
    }

    @JsonIgnore
    public StatusDescriptorBuilder edit() {
        return new StatusDescriptorBuilder(this);
    }

    @JsonIgnore
    public StatusDescriptorBuilder toBuilder() {
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
        if (!(o instanceof StatusDescriptor)) {
            return false;
        }
        StatusDescriptor other = (StatusDescriptor) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
            return false;
        }
        Object this$xDescriptors = this.getXDescriptors();
        Object other$xDescriptors = other.getXDescriptors();
        if (this$xDescriptors == null ? other$xDescriptors != null : !this$xDescriptors.equals(other$xDescriptors)) {
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
        return other instanceof StatusDescriptor;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $xDescriptors = this.getXDescriptors();
        result = result * prime + ($xDescriptors == null ? 43 : $xDescriptors.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StatusDescriptor(" + "description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", path=" + this.getPath() + ", value=" + this.getValue() + ", xDescriptors=" + this.getXDescriptors() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
