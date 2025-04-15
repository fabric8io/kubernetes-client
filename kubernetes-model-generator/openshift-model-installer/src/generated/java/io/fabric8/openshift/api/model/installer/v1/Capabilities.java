
package io.fabric8.openshift.api.model.installer.v1;

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
 * Capabilities selects the managed set of optional, core cluster components.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalEnabledCapabilities",
    "baselineCapabilitySet"
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
public class Capabilities implements Editable<CapabilitiesBuilder>, KubernetesResource
{

    @JsonProperty("additionalEnabledCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalEnabledCapabilities = new ArrayList<>();
    @JsonProperty("baselineCapabilitySet")
    private String baselineCapabilitySet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Capabilities() {
    }

    public Capabilities(List<String> additionalEnabledCapabilities, String baselineCapabilitySet) {
        super();
        this.additionalEnabledCapabilities = additionalEnabledCapabilities;
        this.baselineCapabilitySet = baselineCapabilitySet;
    }

    /**
     * additionalEnabledCapabilities extends the set of managed capabilities beyond the baseline defined in baselineCapabilitySet. The default is an empty set.
     */
    @JsonProperty("additionalEnabledCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalEnabledCapabilities() {
        return additionalEnabledCapabilities;
    }

    /**
     * additionalEnabledCapabilities extends the set of managed capabilities beyond the baseline defined in baselineCapabilitySet. The default is an empty set.
     */
    @JsonProperty("additionalEnabledCapabilities")
    public void setAdditionalEnabledCapabilities(List<String> additionalEnabledCapabilities) {
        this.additionalEnabledCapabilities = additionalEnabledCapabilities;
    }

    /**
     * baselineCapabilitySet selects an initial set of optional capabilities to enable, which can be extended via additionalEnabledCapabilities. The default is vCurrent.
     */
    @JsonProperty("baselineCapabilitySet")
    public String getBaselineCapabilitySet() {
        return baselineCapabilitySet;
    }

    /**
     * baselineCapabilitySet selects an initial set of optional capabilities to enable, which can be extended via additionalEnabledCapabilities. The default is vCurrent.
     */
    @JsonProperty("baselineCapabilitySet")
    public void setBaselineCapabilitySet(String baselineCapabilitySet) {
        this.baselineCapabilitySet = baselineCapabilitySet;
    }

    @JsonIgnore
    public CapabilitiesBuilder edit() {
        return new CapabilitiesBuilder(this);
    }

    @JsonIgnore
    public CapabilitiesBuilder toBuilder() {
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
