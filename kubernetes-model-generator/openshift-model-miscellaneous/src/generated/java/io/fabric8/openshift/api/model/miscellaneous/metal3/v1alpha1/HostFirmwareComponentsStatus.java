
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "components",
    "conditions",
    "lastUpdated",
    "updates"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class HostFirmwareComponentsStatus implements Editable<HostFirmwareComponentsStatusBuilder> , KubernetesResource
{

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostFirmwareComponentsStatusComponents> components = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostFirmwareComponentsStatusConditions> conditions = new ArrayList<>();
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("updates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostFirmwareComponentsStatusUpdates> updates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HostFirmwareComponentsStatus() {
    }

    public HostFirmwareComponentsStatus(List<HostFirmwareComponentsStatusComponents> components, List<HostFirmwareComponentsStatusConditions> conditions, String lastUpdated, List<HostFirmwareComponentsStatusUpdates> updates) {
        super();
        this.components = components;
        this.conditions = conditions;
        this.lastUpdated = lastUpdated;
        this.updates = updates;
    }

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostFirmwareComponentsStatusComponents> getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(List<HostFirmwareComponentsStatusComponents> components) {
        this.components = components;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostFirmwareComponentsStatusConditions> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<HostFirmwareComponentsStatusConditions> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("updates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostFirmwareComponentsStatusUpdates> getUpdates() {
        return updates;
    }

    @JsonProperty("updates")
    public void setUpdates(List<HostFirmwareComponentsStatusUpdates> updates) {
        this.updates = updates;
    }

    @JsonIgnore
    public HostFirmwareComponentsStatusBuilder edit() {
        return new HostFirmwareComponentsStatusBuilder(this);
    }

    @JsonIgnore
    public HostFirmwareComponentsStatusBuilder toBuilder() {
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
