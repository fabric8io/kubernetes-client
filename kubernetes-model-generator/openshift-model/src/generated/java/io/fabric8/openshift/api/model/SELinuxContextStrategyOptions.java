
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SELinuxOptions;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SELinuxContextStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "seLinuxOptions",
    "type"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SELinuxContextStrategyOptions implements Editable<SELinuxContextStrategyOptionsBuilder>, KubernetesResource
{

    @JsonProperty("seLinuxOptions")
    private SELinuxOptions seLinuxOptions;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SELinuxContextStrategyOptions() {
    }

    public SELinuxContextStrategyOptions(SELinuxOptions seLinuxOptions, String type) {
        super();
        this.seLinuxOptions = seLinuxOptions;
        this.type = type;
    }

    /**
     * SELinuxContextStrategyOptions defines the strategy type and any options used to create the strategy.
     */
    @JsonProperty("seLinuxOptions")
    public SELinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    /**
     * SELinuxContextStrategyOptions defines the strategy type and any options used to create the strategy.
     */
    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(SELinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    /**
     * Type is the strategy that will dictate what SELinux context is used in the SecurityContext.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the strategy that will dictate what SELinux context is used in the SecurityContext.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public SELinuxContextStrategyOptionsBuilder edit() {
        return new SELinuxContextStrategyOptionsBuilder(this);
    }

    @JsonIgnore
    public SELinuxContextStrategyOptionsBuilder toBuilder() {
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
