
package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "excludeResourceRules",
    "matchPolicy",
    "namespaceSelector",
    "objectSelector",
    "resourceRules"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class MatchResources implements KubernetesResource
{

    @JsonProperty("excludeResourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedRuleWithOperations> excludeResourceRules = new ArrayList<NamedRuleWithOperations>();
    @JsonProperty("matchPolicy")
    private String matchPolicy;
    @JsonProperty("namespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector;
    @JsonProperty("objectSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector objectSelector;
    @JsonProperty("resourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedRuleWithOperations> resourceRules = new ArrayList<NamedRuleWithOperations>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MatchResources() {
    }

    public MatchResources(List<NamedRuleWithOperations> excludeResourceRules, String matchPolicy, io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector objectSelector, List<NamedRuleWithOperations> resourceRules) {
        super();
        this.excludeResourceRules = excludeResourceRules;
        this.matchPolicy = matchPolicy;
        this.namespaceSelector = namespaceSelector;
        this.objectSelector = objectSelector;
        this.resourceRules = resourceRules;
    }

    @JsonProperty("excludeResourceRules")
    public List<NamedRuleWithOperations> getExcludeResourceRules() {
        return excludeResourceRules;
    }

    @JsonProperty("excludeResourceRules")
    public void setExcludeResourceRules(List<NamedRuleWithOperations> excludeResourceRules) {
        this.excludeResourceRules = excludeResourceRules;
    }

    @JsonProperty("matchPolicy")
    public String getMatchPolicy() {
        return matchPolicy;
    }

    @JsonProperty("matchPolicy")
    public void setMatchPolicy(String matchPolicy) {
        this.matchPolicy = matchPolicy;
    }

    @JsonProperty("namespaceSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("objectSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getObjectSelector() {
        return objectSelector;
    }

    @JsonProperty("objectSelector")
    public void setObjectSelector(io.fabric8.kubernetes.api.model.LabelSelector objectSelector) {
        this.objectSelector = objectSelector;
    }

    @JsonProperty("resourceRules")
    public List<NamedRuleWithOperations> getResourceRules() {
        return resourceRules;
    }

    @JsonProperty("resourceRules")
    public void setResourceRules(List<NamedRuleWithOperations> resourceRules) {
        this.resourceRules = resourceRules;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
