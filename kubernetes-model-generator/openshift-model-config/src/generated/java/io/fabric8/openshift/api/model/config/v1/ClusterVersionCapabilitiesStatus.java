
package io.fabric8.openshift.api.model.config.v1;

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
 * ClusterVersionCapabilitiesStatus describes the state of optional, core cluster components.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "enabledCapabilities",
    "knownCapabilities"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterVersionCapabilitiesStatus implements Editable<ClusterVersionCapabilitiesStatusBuilder>, KubernetesResource
{

    @JsonProperty("enabledCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> enabledCapabilities = new ArrayList<>();
    @JsonProperty("knownCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> knownCapabilities = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterVersionCapabilitiesStatus() {
    }

    public ClusterVersionCapabilitiesStatus(List<String> enabledCapabilities, List<String> knownCapabilities) {
        super();
        this.enabledCapabilities = enabledCapabilities;
        this.knownCapabilities = knownCapabilities;
    }

    /**
     * enabledCapabilities lists all the capabilities that are currently managed.
     */
    @JsonProperty("enabledCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnabledCapabilities() {
        return enabledCapabilities;
    }

    /**
     * enabledCapabilities lists all the capabilities that are currently managed.
     */
    @JsonProperty("enabledCapabilities")
    public void setEnabledCapabilities(List<String> enabledCapabilities) {
        this.enabledCapabilities = enabledCapabilities;
    }

    /**
     * knownCapabilities lists all the capabilities known to the current cluster.
     */
    @JsonProperty("knownCapabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getKnownCapabilities() {
        return knownCapabilities;
    }

    /**
     * knownCapabilities lists all the capabilities known to the current cluster.
     */
    @JsonProperty("knownCapabilities")
    public void setKnownCapabilities(List<String> knownCapabilities) {
        this.knownCapabilities = knownCapabilities;
    }

    @JsonIgnore
    public ClusterVersionCapabilitiesStatusBuilder edit() {
        return new ClusterVersionCapabilitiesStatusBuilder(this);
    }

    @JsonIgnore
    public ClusterVersionCapabilitiesStatusBuilder toBuilder() {
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
