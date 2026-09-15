
package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

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

/**
 * ValidatingWebhook describes an admission webhook and the resources and operations it applies to.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "admissionReviewVersions",
    "clientConfig",
    "failurePolicy",
    "matchPolicy",
    "name",
    "namespaceSelector",
    "objectSelector",
    "rules",
    "sideEffects",
    "timeoutSeconds"
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
public class ValidatingWebhook implements Editable<ValidatingWebhookBuilder>, KubernetesResource
{

    @JsonProperty("admissionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> admissionReviewVersions = new ArrayList<>();
    @JsonProperty("clientConfig")
    private WebhookClientConfig clientConfig;
    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("matchPolicy")
    private String matchPolicy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("objectSelector")
    private LabelSelector objectSelector;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RuleWithOperations> rules = new ArrayList<>();
    @JsonProperty("sideEffects")
    private String sideEffects;
    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ValidatingWebhook() {
    }

    public ValidatingWebhook(List<String> admissionReviewVersions, WebhookClientConfig clientConfig, String failurePolicy, String matchPolicy, String name, LabelSelector namespaceSelector, LabelSelector objectSelector, List<RuleWithOperations> rules, String sideEffects, Integer timeoutSeconds) {
        super();
        this.admissionReviewVersions = admissionReviewVersions;
        this.clientConfig = clientConfig;
        this.failurePolicy = failurePolicy;
        this.matchPolicy = matchPolicy;
        this.name = name;
        this.namespaceSelector = namespaceSelector;
        this.objectSelector = objectSelector;
        this.rules = rules;
        this.sideEffects = sideEffects;
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * AdmissionReviewVersions is an ordered list of preferred `AdmissionReview` versions the Webhook expects. API server will try to use first version in the list which it supports. If none of the versions specified in this list supported by API server, validation will fail for this object. If a persisted webhook configuration specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will fail and be subject to the failure policy. Default to `['v1beta1']`.
     */
    @JsonProperty("admissionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdmissionReviewVersions() {
        return admissionReviewVersions;
    }

    /**
     * AdmissionReviewVersions is an ordered list of preferred `AdmissionReview` versions the Webhook expects. API server will try to use first version in the list which it supports. If none of the versions specified in this list supported by API server, validation will fail for this object. If a persisted webhook configuration specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will fail and be subject to the failure policy. Default to `['v1beta1']`.
     */
    @JsonProperty("admissionReviewVersions")
    public void setAdmissionReviewVersions(List<String> admissionReviewVersions) {
        this.admissionReviewVersions = admissionReviewVersions;
    }

    /**
     * ValidatingWebhook describes an admission webhook and the resources and operations it applies to.
     */
    @JsonProperty("clientConfig")
    public WebhookClientConfig getClientConfig() {
        return clientConfig;
    }

    /**
     * ValidatingWebhook describes an admission webhook and the resources and operations it applies to.
     */
    @JsonProperty("clientConfig")
    public void setClientConfig(WebhookClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    /**
     * FailurePolicy defines how unrecognized errors from the admission endpoint are handled - allowed values are Ignore or Fail. Defaults to Ignore.
     */
    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    /**
     * FailurePolicy defines how unrecognized errors from the admission endpoint are handled - allowed values are Ignore or Fail. Defaults to Ignore.
     */
    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    /**
     * matchPolicy defines how the "rules" list is used to match incoming requests. Allowed values are "Exact" or "Equivalent".<br><p> <br><p> - Exact: match a request only if it exactly matches a specified rule. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, but "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would not be sent to the webhook.<br><p> <br><p> - Equivalent: match a request if modifies a resource listed in rules, even via another API group or version. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, and "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would be converted to apps/v1 and sent to the webhook.<br><p> <br><p> Defaults to "Exact"
     */
    @JsonProperty("matchPolicy")
    public String getMatchPolicy() {
        return matchPolicy;
    }

    /**
     * matchPolicy defines how the "rules" list is used to match incoming requests. Allowed values are "Exact" or "Equivalent".<br><p> <br><p> - Exact: match a request only if it exactly matches a specified rule. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, but "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would not be sent to the webhook.<br><p> <br><p> - Equivalent: match a request if modifies a resource listed in rules, even via another API group or version. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, and "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would be converted to apps/v1 and sent to the webhook.<br><p> <br><p> Defaults to "Exact"
     */
    @JsonProperty("matchPolicy")
    public void setMatchPolicy(String matchPolicy) {
        this.matchPolicy = matchPolicy;
    }

    /**
     * The name of the admission webhook. Name should be fully qualified, e.g., imagepolicy.kubernetes.io, where "imagepolicy" is the name of the webhook, and kubernetes.io is the name of the organization. Required.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of the admission webhook. Name should be fully qualified, e.g., imagepolicy.kubernetes.io, where "imagepolicy" is the name of the webhook, and kubernetes.io is the name of the organization. Required.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ValidatingWebhook describes an admission webhook and the resources and operations it applies to.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * ValidatingWebhook describes an admission webhook and the resources and operations it applies to.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * ValidatingWebhook describes an admission webhook and the resources and operations it applies to.
     */
    @JsonProperty("objectSelector")
    public LabelSelector getObjectSelector() {
        return objectSelector;
    }

    /**
     * ValidatingWebhook describes an admission webhook and the resources and operations it applies to.
     */
    @JsonProperty("objectSelector")
    public void setObjectSelector(LabelSelector objectSelector) {
        this.objectSelector = objectSelector;
    }

    /**
     * Rules describes what operations on what resources/subresources the webhook cares about. The webhook cares about an operation if it matches _any_ Rule. However, in order to prevent ValidatingAdmissionWebhooks and MutatingAdmissionWebhooks from putting the cluster in a state which cannot be recovered from without completely disabling the plugin, ValidatingAdmissionWebhooks and MutatingAdmissionWebhooks are never called on admission requests for ValidatingWebhookConfiguration and MutatingWebhookConfiguration objects.
     */
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RuleWithOperations> getRules() {
        return rules;
    }

    /**
     * Rules describes what operations on what resources/subresources the webhook cares about. The webhook cares about an operation if it matches _any_ Rule. However, in order to prevent ValidatingAdmissionWebhooks and MutatingAdmissionWebhooks from putting the cluster in a state which cannot be recovered from without completely disabling the plugin, ValidatingAdmissionWebhooks and MutatingAdmissionWebhooks are never called on admission requests for ValidatingWebhookConfiguration and MutatingWebhookConfiguration objects.
     */
    @JsonProperty("rules")
    public void setRules(List<RuleWithOperations> rules) {
        this.rules = rules;
    }

    /**
     * SideEffects states whether this webhook has side effects. Acceptable values are: Unknown, None, Some, NoneOnDryRun Webhooks with side effects MUST implement a reconciliation system, since a request may be rejected by a future step in the admission chain and the side effects therefore need to be undone. Requests with the dryRun attribute will be auto-rejected if they match a webhook with sideEffects == Unknown or Some. Defaults to Unknown.
     */
    @JsonProperty("sideEffects")
    public String getSideEffects() {
        return sideEffects;
    }

    /**
     * SideEffects states whether this webhook has side effects. Acceptable values are: Unknown, None, Some, NoneOnDryRun Webhooks with side effects MUST implement a reconciliation system, since a request may be rejected by a future step in the admission chain and the side effects therefore need to be undone. Requests with the dryRun attribute will be auto-rejected if they match a webhook with sideEffects == Unknown or Some. Defaults to Unknown.
     */
    @JsonProperty("sideEffects")
    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    /**
     * TimeoutSeconds specifies the timeout for this webhook. After the timeout passes, the webhook call will be ignored or the API call will fail based on the failure policy. The timeout value must be between 1 and 30 seconds. Default to 30 seconds.
     */
    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * TimeoutSeconds specifies the timeout for this webhook. After the timeout passes, the webhook call will be ignored or the API call will fail based on the failure policy. The timeout value must be between 1 and 30 seconds. Default to 30 seconds.
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonIgnore
    public ValidatingWebhookBuilder edit() {
        return new ValidatingWebhookBuilder(this);
    }

    @JsonIgnore
    public ValidatingWebhookBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ValidatingWebhook)) {
            return false;
        }
        ValidatingWebhook other = (ValidatingWebhook) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$admissionReviewVersions = this.getAdmissionReviewVersions();
        Object other$admissionReviewVersions = other.getAdmissionReviewVersions();
        if (this$admissionReviewVersions == null ? other$admissionReviewVersions != null : !this$admissionReviewVersions.equals(other$admissionReviewVersions)) {
            return false;
        }
        Object this$clientConfig = this.getClientConfig();
        Object other$clientConfig = other.getClientConfig();
        if (this$clientConfig == null ? other$clientConfig != null : !this$clientConfig.equals(other$clientConfig)) {
            return false;
        }
        Object this$failurePolicy = this.getFailurePolicy();
        Object other$failurePolicy = other.getFailurePolicy();
        if (this$failurePolicy == null ? other$failurePolicy != null : !this$failurePolicy.equals(other$failurePolicy)) {
            return false;
        }
        Object this$matchPolicy = this.getMatchPolicy();
        Object other$matchPolicy = other.getMatchPolicy();
        if (this$matchPolicy == null ? other$matchPolicy != null : !this$matchPolicy.equals(other$matchPolicy)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
            return false;
        }
        Object this$objectSelector = this.getObjectSelector();
        Object other$objectSelector = other.getObjectSelector();
        if (this$objectSelector == null ? other$objectSelector != null : !this$objectSelector.equals(other$objectSelector)) {
            return false;
        }
        Object this$rules = this.getRules();
        Object other$rules = other.getRules();
        if (this$rules == null ? other$rules != null : !this$rules.equals(other$rules)) {
            return false;
        }
        Object this$sideEffects = this.getSideEffects();
        Object other$sideEffects = other.getSideEffects();
        if (this$sideEffects == null ? other$sideEffects != null : !this$sideEffects.equals(other$sideEffects)) {
            return false;
        }
        Object this$timeoutSeconds = this.getTimeoutSeconds();
        Object other$timeoutSeconds = other.getTimeoutSeconds();
        if (this$timeoutSeconds == null ? other$timeoutSeconds != null : !this$timeoutSeconds.equals(other$timeoutSeconds)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ValidatingWebhook;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $admissionReviewVersions = this.getAdmissionReviewVersions();
        result = result * prime + ($admissionReviewVersions == null ? 43 : $admissionReviewVersions.hashCode());
        Object $clientConfig = this.getClientConfig();
        result = result * prime + ($clientConfig == null ? 43 : $clientConfig.hashCode());
        Object $failurePolicy = this.getFailurePolicy();
        result = result * prime + ($failurePolicy == null ? 43 : $failurePolicy.hashCode());
        Object $matchPolicy = this.getMatchPolicy();
        result = result * prime + ($matchPolicy == null ? 43 : $matchPolicy.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $objectSelector = this.getObjectSelector();
        result = result * prime + ($objectSelector == null ? 43 : $objectSelector.hashCode());
        Object $rules = this.getRules();
        result = result * prime + ($rules == null ? 43 : $rules.hashCode());
        Object $sideEffects = this.getSideEffects();
        result = result * prime + ($sideEffects == null ? 43 : $sideEffects.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ValidatingWebhook(" + "admissionReviewVersions=" + this.getAdmissionReviewVersions() + ", clientConfig=" + this.getClientConfig() + ", failurePolicy=" + this.getFailurePolicy() + ", matchPolicy=" + this.getMatchPolicy() + ", name=" + this.getName() + ", namespaceSelector=" + this.getNamespaceSelector() + ", objectSelector=" + this.getObjectSelector() + ", rules=" + this.getRules() + ", sideEffects=" + this.getSideEffects() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
