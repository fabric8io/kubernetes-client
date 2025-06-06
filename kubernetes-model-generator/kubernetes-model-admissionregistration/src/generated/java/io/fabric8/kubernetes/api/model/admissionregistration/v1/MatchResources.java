
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
 * MatchResources decides whether to run the admission control policy on an object based on whether it meets the match criteria. The exclude rules take precedence over include rules (if a resource matches both, it is excluded)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "excludeResourceRules",
    "matchPolicy",
    "namespaceSelector",
    "objectSelector",
    "resourceRules"
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
public class MatchResources implements Editable<MatchResourcesBuilder>, KubernetesResource
{

    @JsonProperty("excludeResourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedRuleWithOperations> excludeResourceRules = new ArrayList<>();
    @JsonProperty("matchPolicy")
    private String matchPolicy;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("objectSelector")
    private LabelSelector objectSelector;
    @JsonProperty("resourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedRuleWithOperations> resourceRules = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MatchResources() {
    }

    public MatchResources(List<NamedRuleWithOperations> excludeResourceRules, String matchPolicy, LabelSelector namespaceSelector, LabelSelector objectSelector, List<NamedRuleWithOperations> resourceRules) {
        super();
        this.excludeResourceRules = excludeResourceRules;
        this.matchPolicy = matchPolicy;
        this.namespaceSelector = namespaceSelector;
        this.objectSelector = objectSelector;
        this.resourceRules = resourceRules;
    }

    /**
     * ExcludeResourceRules describes what operations on what resources/subresources the ValidatingAdmissionPolicy should not care about. The exclude rules take precedence over include rules (if a resource matches both, it is excluded)
     */
    @JsonProperty("excludeResourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedRuleWithOperations> getExcludeResourceRules() {
        return excludeResourceRules;
    }

    /**
     * ExcludeResourceRules describes what operations on what resources/subresources the ValidatingAdmissionPolicy should not care about. The exclude rules take precedence over include rules (if a resource matches both, it is excluded)
     */
    @JsonProperty("excludeResourceRules")
    public void setExcludeResourceRules(List<NamedRuleWithOperations> excludeResourceRules) {
        this.excludeResourceRules = excludeResourceRules;
    }

    /**
     * matchPolicy defines how the "MatchResources" list is used to match incoming requests. Allowed values are "Exact" or "Equivalent".<br><p> <br><p> - Exact: match a request only if it exactly matches a specified rule. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, but "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would not be sent to the ValidatingAdmissionPolicy.<br><p> <br><p> - Equivalent: match a request if modifies a resource listed in rules, even via another API group or version. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, and "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would be converted to apps/v1 and sent to the ValidatingAdmissionPolicy.<br><p> <br><p> Defaults to "Equivalent"
     */
    @JsonProperty("matchPolicy")
    public String getMatchPolicy() {
        return matchPolicy;
    }

    /**
     * matchPolicy defines how the "MatchResources" list is used to match incoming requests. Allowed values are "Exact" or "Equivalent".<br><p> <br><p> - Exact: match a request only if it exactly matches a specified rule. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, but "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would not be sent to the ValidatingAdmissionPolicy.<br><p> <br><p> - Equivalent: match a request if modifies a resource listed in rules, even via another API group or version. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, and "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would be converted to apps/v1 and sent to the ValidatingAdmissionPolicy.<br><p> <br><p> Defaults to "Equivalent"
     */
    @JsonProperty("matchPolicy")
    public void setMatchPolicy(String matchPolicy) {
        this.matchPolicy = matchPolicy;
    }

    /**
     * MatchResources decides whether to run the admission control policy on an object based on whether it meets the match criteria. The exclude rules take precedence over include rules (if a resource matches both, it is excluded)
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * MatchResources decides whether to run the admission control policy on an object based on whether it meets the match criteria. The exclude rules take precedence over include rules (if a resource matches both, it is excluded)
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * MatchResources decides whether to run the admission control policy on an object based on whether it meets the match criteria. The exclude rules take precedence over include rules (if a resource matches both, it is excluded)
     */
    @JsonProperty("objectSelector")
    public LabelSelector getObjectSelector() {
        return objectSelector;
    }

    /**
     * MatchResources decides whether to run the admission control policy on an object based on whether it meets the match criteria. The exclude rules take precedence over include rules (if a resource matches both, it is excluded)
     */
    @JsonProperty("objectSelector")
    public void setObjectSelector(LabelSelector objectSelector) {
        this.objectSelector = objectSelector;
    }

    /**
     * ResourceRules describes what operations on what resources/subresources the ValidatingAdmissionPolicy matches. The policy cares about an operation if it matches _any_ Rule.
     */
    @JsonProperty("resourceRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedRuleWithOperations> getResourceRules() {
        return resourceRules;
    }

    /**
     * ResourceRules describes what operations on what resources/subresources the ValidatingAdmissionPolicy matches. The policy cares about an operation if it matches _any_ Rule.
     */
    @JsonProperty("resourceRules")
    public void setResourceRules(List<NamedRuleWithOperations> resourceRules) {
        this.resourceRules = resourceRules;
    }

    @JsonIgnore
    public MatchResourcesBuilder edit() {
        return new MatchResourcesBuilder(this);
    }

    @JsonIgnore
    public MatchResourcesBuilder toBuilder() {
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
