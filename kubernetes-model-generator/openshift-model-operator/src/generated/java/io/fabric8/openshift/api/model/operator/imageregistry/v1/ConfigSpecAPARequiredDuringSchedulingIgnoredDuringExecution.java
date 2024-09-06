
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
    "labelSelector",
    "matchLabelKeys",
    "mismatchLabelKeys",
    "namespaceSelector",
    "namespaces",
    "topologyKey"
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
public class ConfigSpecAPARequiredDuringSchedulingIgnoredDuringExecution implements Editable<ConfigSpecAPARequiredDuringSchedulingIgnoredDuringExecutionBuilder> , KubernetesResource
{

    @JsonProperty("labelSelector")
    private ConfigSpecAPARDSIDELabelSelector labelSelector;
    @JsonProperty("matchLabelKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> matchLabelKeys = new ArrayList<>();
    @JsonProperty("mismatchLabelKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> mismatchLabelKeys = new ArrayList<>();
    @JsonProperty("namespaceSelector")
    private ConfigSpecAPARDSIDENamespaceSelector namespaceSelector;
    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> namespaces = new ArrayList<>();
    @JsonProperty("topologyKey")
    private String topologyKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConfigSpecAPARequiredDuringSchedulingIgnoredDuringExecution() {
    }

    public ConfigSpecAPARequiredDuringSchedulingIgnoredDuringExecution(ConfigSpecAPARDSIDELabelSelector labelSelector, List<String> matchLabelKeys, List<String> mismatchLabelKeys, ConfigSpecAPARDSIDENamespaceSelector namespaceSelector, List<String> namespaces, String topologyKey) {
        super();
        this.labelSelector = labelSelector;
        this.matchLabelKeys = matchLabelKeys;
        this.mismatchLabelKeys = mismatchLabelKeys;
        this.namespaceSelector = namespaceSelector;
        this.namespaces = namespaces;
        this.topologyKey = topologyKey;
    }

    @JsonProperty("labelSelector")
    public ConfigSpecAPARDSIDELabelSelector getLabelSelector() {
        return labelSelector;
    }

    @JsonProperty("labelSelector")
    public void setLabelSelector(ConfigSpecAPARDSIDELabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    @JsonProperty("matchLabelKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMatchLabelKeys() {
        return matchLabelKeys;
    }

    @JsonProperty("matchLabelKeys")
    public void setMatchLabelKeys(List<String> matchLabelKeys) {
        this.matchLabelKeys = matchLabelKeys;
    }

    @JsonProperty("mismatchLabelKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMismatchLabelKeys() {
        return mismatchLabelKeys;
    }

    @JsonProperty("mismatchLabelKeys")
    public void setMismatchLabelKeys(List<String> mismatchLabelKeys) {
        this.mismatchLabelKeys = mismatchLabelKeys;
    }

    @JsonProperty("namespaceSelector")
    public ConfigSpecAPARDSIDENamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(ConfigSpecAPARDSIDENamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("namespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNamespaces() {
        return namespaces;
    }

    @JsonProperty("namespaces")
    public void setNamespaces(List<String> namespaces) {
        this.namespaces = namespaces;
    }

    @JsonProperty("topologyKey")
    public String getTopologyKey() {
        return topologyKey;
    }

    @JsonProperty("topologyKey")
    public void setTopologyKey(String topologyKey) {
        this.topologyKey = topologyKey;
    }

    @JsonIgnore
    public ConfigSpecAPARequiredDuringSchedulingIgnoredDuringExecutionBuilder edit() {
        return new ConfigSpecAPARequiredDuringSchedulingIgnoredDuringExecutionBuilder(this);
    }

    @JsonIgnore
    public ConfigSpecAPARequiredDuringSchedulingIgnoredDuringExecutionBuilder toBuilder() {
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
