
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
    "admissionReviewVersions",
    "clientConfig",
    "failurePolicy",
    "matchConditions",
    "matchPolicy",
    "name",
    "namespaceSelector",
    "objectSelector",
    "rules",
    "sideEffects",
    "timeoutSeconds"
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
public class ValidatingWebhook implements KubernetesResource
{

    @JsonProperty("admissionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> admissionReviewVersions = new ArrayList<String>();
    @JsonProperty("clientConfig")
    private WebhookClientConfig clientConfig;
    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("matchConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MatchCondition> matchConditions = new ArrayList<MatchCondition>();
    @JsonProperty("matchPolicy")
    private String matchPolicy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector;
    @JsonProperty("objectSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector objectSelector;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RuleWithOperations> rules = new ArrayList<RuleWithOperations>();
    @JsonProperty("sideEffects")
    private String sideEffects;
    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidatingWebhook() {
    }

    public ValidatingWebhook(List<String> admissionReviewVersions, WebhookClientConfig clientConfig, String failurePolicy, List<MatchCondition> matchConditions, String matchPolicy, String name, io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector, io.fabric8.kubernetes.api.model.LabelSelector objectSelector, List<RuleWithOperations> rules, String sideEffects, Integer timeoutSeconds) {
        super();
        this.admissionReviewVersions = admissionReviewVersions;
        this.clientConfig = clientConfig;
        this.failurePolicy = failurePolicy;
        this.matchConditions = matchConditions;
        this.matchPolicy = matchPolicy;
        this.name = name;
        this.namespaceSelector = namespaceSelector;
        this.objectSelector = objectSelector;
        this.rules = rules;
        this.sideEffects = sideEffects;
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonProperty("admissionReviewVersions")
    public List<String> getAdmissionReviewVersions() {
        return admissionReviewVersions;
    }

    @JsonProperty("admissionReviewVersions")
    public void setAdmissionReviewVersions(List<String> admissionReviewVersions) {
        this.admissionReviewVersions = admissionReviewVersions;
    }

    @JsonProperty("clientConfig")
    public WebhookClientConfig getClientConfig() {
        return clientConfig;
    }

    @JsonProperty("clientConfig")
    public void setClientConfig(WebhookClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    @JsonProperty("matchConditions")
    public List<MatchCondition> getMatchConditions() {
        return matchConditions;
    }

    @JsonProperty("matchConditions")
    public void setMatchConditions(List<MatchCondition> matchConditions) {
        this.matchConditions = matchConditions;
    }

    @JsonProperty("matchPolicy")
    public String getMatchPolicy() {
        return matchPolicy;
    }

    @JsonProperty("matchPolicy")
    public void setMatchPolicy(String matchPolicy) {
        this.matchPolicy = matchPolicy;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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

    @JsonProperty("rules")
    public List<RuleWithOperations> getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(List<RuleWithOperations> rules) {
        this.rules = rules;
    }

    @JsonProperty("sideEffects")
    public String getSideEffects() {
        return sideEffects;
    }

    @JsonProperty("sideEffects")
    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
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
