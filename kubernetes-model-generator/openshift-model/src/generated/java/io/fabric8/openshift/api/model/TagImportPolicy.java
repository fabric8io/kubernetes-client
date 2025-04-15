
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
 * TagImportPolicy controls how images related to this tag will be imported.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "importMode",
    "insecure",
    "scheduled"
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
public class TagImportPolicy implements Editable<TagImportPolicyBuilder>, KubernetesResource
{

    @JsonProperty("importMode")
    private String importMode;
    @JsonProperty("insecure")
    private Boolean insecure;
    @JsonProperty("scheduled")
    private Boolean scheduled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TagImportPolicy() {
    }

    public TagImportPolicy(String importMode, Boolean insecure, Boolean scheduled) {
        super();
        this.importMode = importMode;
        this.insecure = insecure;
        this.scheduled = scheduled;
    }

    /**
     * ImportMode describes how to import an image manifest.
     */
    @JsonProperty("importMode")
    public String getImportMode() {
        return importMode;
    }

    /**
     * ImportMode describes how to import an image manifest.
     */
    @JsonProperty("importMode")
    public void setImportMode(String importMode) {
        this.importMode = importMode;
    }

    /**
     * Insecure is true if the server may bypass certificate verification or connect directly over HTTP during image import.
     */
    @JsonProperty("insecure")
    public Boolean getInsecure() {
        return insecure;
    }

    /**
     * Insecure is true if the server may bypass certificate verification or connect directly over HTTP during image import.
     */
    @JsonProperty("insecure")
    public void setInsecure(Boolean insecure) {
        this.insecure = insecure;
    }

    /**
     * Scheduled indicates to the server that this tag should be periodically checked to ensure it is up to date, and imported
     */
    @JsonProperty("scheduled")
    public Boolean getScheduled() {
        return scheduled;
    }

    /**
     * Scheduled indicates to the server that this tag should be periodically checked to ensure it is up to date, and imported
     */
    @JsonProperty("scheduled")
    public void setScheduled(Boolean scheduled) {
        this.scheduled = scheduled;
    }

    @JsonIgnore
    public TagImportPolicyBuilder edit() {
        return new TagImportPolicyBuilder(this);
    }

    @JsonIgnore
    public TagImportPolicyBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
