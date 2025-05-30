
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SpecDescriptor implements Editable<SpecDescriptorBuilder>, KubernetesResource
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
    public SpecDescriptor() {
    }

    public SpecDescriptor(String description, String displayName, String path, String value, List<String> xDescriptors) {
        super();
        this.description = description;
        this.displayName = displayName;
        this.path = path;
        this.value = value;
        this.xDescriptors = xDescriptors;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("x-descriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getXDescriptors() {
        return xDescriptors;
    }

    /**
     * SpecDescriptor describes a field in a spec block of a CRD so that OLM can consume it
     */
    @JsonProperty("x-descriptors")
    public void setXDescriptors(List<String> xDescriptors) {
        this.xDescriptors = xDescriptors;
    }

    @JsonIgnore
    public SpecDescriptorBuilder edit() {
        return new SpecDescriptorBuilder(this);
    }

    @JsonIgnore
    public SpecDescriptorBuilder toBuilder() {
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

}
