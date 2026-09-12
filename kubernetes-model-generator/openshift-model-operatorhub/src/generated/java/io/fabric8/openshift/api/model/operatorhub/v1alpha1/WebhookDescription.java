
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * WebhookDescription provides details to OLM about required webhooks
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "admissionReviewVersions",
    "containerPort",
    "conversionCRDs",
    "deploymentName",
    "failurePolicy",
    "generateName",
    "matchPolicy",
    "objectSelector",
    "reinvocationPolicy",
    "rules",
    "sideEffects",
    "targetPort",
    "timeoutSeconds",
    "type",
    "webhookPath"
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
public class WebhookDescription implements Editable<WebhookDescriptionBuilder>, KubernetesResource
{

    @JsonProperty("admissionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> admissionReviewVersions = new ArrayList<>();
    @JsonProperty("containerPort")
    private Integer containerPort;
    @JsonProperty("conversionCRDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> conversionCRDs = new ArrayList<>();
    @JsonProperty("deploymentName")
    private String deploymentName;
    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("generateName")
    private String generateName;
    @JsonProperty("matchPolicy")
    private String matchPolicy;
    @JsonProperty("objectSelector")
    private LabelSelector objectSelector;
    @JsonProperty("reinvocationPolicy")
    private String reinvocationPolicy;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RuleWithOperations> rules = new ArrayList<>();
    @JsonProperty("sideEffects")
    private String sideEffects;
    @JsonProperty("targetPort")
    private IntOrString targetPort;
    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonProperty("type")
    private String type;
    @JsonProperty("webhookPath")
    private String webhookPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebhookDescription() {
    }

    public WebhookDescription(List<String> admissionReviewVersions, Integer containerPort, List<String> conversionCRDs, String deploymentName, String failurePolicy, String generateName, String matchPolicy, LabelSelector objectSelector, String reinvocationPolicy, List<RuleWithOperations> rules, String sideEffects, IntOrString targetPort, Integer timeoutSeconds, String type, String webhookPath) {
        super();
        this.admissionReviewVersions = admissionReviewVersions;
        this.containerPort = containerPort;
        this.conversionCRDs = conversionCRDs;
        this.deploymentName = deploymentName;
        this.failurePolicy = failurePolicy;
        this.generateName = generateName;
        this.matchPolicy = matchPolicy;
        this.objectSelector = objectSelector;
        this.reinvocationPolicy = reinvocationPolicy;
        this.rules = rules;
        this.sideEffects = sideEffects;
        this.targetPort = targetPort;
        this.timeoutSeconds = timeoutSeconds;
        this.type = type;
        this.webhookPath = webhookPath;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("admissionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdmissionReviewVersions() {
        return admissionReviewVersions;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("admissionReviewVersions")
    public void setAdmissionReviewVersions(List<String> admissionReviewVersions) {
        this.admissionReviewVersions = admissionReviewVersions;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("containerPort")
    public Integer getContainerPort() {
        return containerPort;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("containerPort")
    public void setContainerPort(Integer containerPort) {
        this.containerPort = containerPort;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("conversionCRDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConversionCRDs() {
        return conversionCRDs;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("conversionCRDs")
    public void setConversionCRDs(List<String> conversionCRDs) {
        this.conversionCRDs = conversionCRDs;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("deploymentName")
    public String getDeploymentName() {
        return deploymentName;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("deploymentName")
    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    /**
     * Possible enum values:<br><p>  - `"Fail"` means that an error calling the webhook causes the admission to fail.<br><p>  - `"Ignore"` means that an error calling the webhook is ignored.
     */
    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    /**
     * Possible enum values:<br><p>  - `"Fail"` means that an error calling the webhook causes the admission to fail.<br><p>  - `"Ignore"` means that an error calling the webhook is ignored.
     */
    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("generateName")
    public String getGenerateName() {
        return generateName;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("generateName")
    public void setGenerateName(String generateName) {
        this.generateName = generateName;
    }

    /**
     * Possible enum values:<br><p>  - `"Equivalent"` means requests should be sent to the webhook if they modify a resource listed in rules via another API group or version.<br><p>  - `"Exact"` means requests should only be sent to the webhook if they exactly match a given rule.
     */
    @JsonProperty("matchPolicy")
    public String getMatchPolicy() {
        return matchPolicy;
    }

    /**
     * Possible enum values:<br><p>  - `"Equivalent"` means requests should be sent to the webhook if they modify a resource listed in rules via another API group or version.<br><p>  - `"Exact"` means requests should only be sent to the webhook if they exactly match a given rule.
     */
    @JsonProperty("matchPolicy")
    public void setMatchPolicy(String matchPolicy) {
        this.matchPolicy = matchPolicy;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("objectSelector")
    public LabelSelector getObjectSelector() {
        return objectSelector;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("objectSelector")
    public void setObjectSelector(LabelSelector objectSelector) {
        this.objectSelector = objectSelector;
    }

    /**
     * Possible enum values:<br><p>  - `"IfNeeded"` indicates that the mutation may be called at least one additional time as part of the admission evaluation if the object being admitted is modified by other admission plugins after the initial mutation call.<br><p>  - `"Never"` indicates that the mutation must not be called more than once in a single admission evaluation.
     */
    @JsonProperty("reinvocationPolicy")
    public String getReinvocationPolicy() {
        return reinvocationPolicy;
    }

    /**
     * Possible enum values:<br><p>  - `"IfNeeded"` indicates that the mutation may be called at least one additional time as part of the admission evaluation if the object being admitted is modified by other admission plugins after the initial mutation call.<br><p>  - `"Never"` indicates that the mutation must not be called more than once in a single admission evaluation.
     */
    @JsonProperty("reinvocationPolicy")
    public void setReinvocationPolicy(String reinvocationPolicy) {
        this.reinvocationPolicy = reinvocationPolicy;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RuleWithOperations> getRules() {
        return rules;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("rules")
    public void setRules(List<RuleWithOperations> rules) {
        this.rules = rules;
    }

    /**
     * Possible enum values:<br><p>  - `"None"` means that calling the webhook will have no side effects.<br><p>  - `"NoneOnDryRun"` means that calling the webhook will possibly have side effects, but if the request being reviewed has the dry-run attribute, the side effects will be suppressed.<br><p>  - `"Some"` means that calling the webhook will possibly have side effects. If a request with the dry-run attribute would trigger a call to this webhook, the request will instead fail.<br><p>  - `"Unknown"` means that no information is known about the side effects of calling the webhook. If a request with the dry-run attribute would trigger a call to this webhook, the request will instead fail.
     */
    @JsonProperty("sideEffects")
    public String getSideEffects() {
        return sideEffects;
    }

    /**
     * Possible enum values:<br><p>  - `"None"` means that calling the webhook will have no side effects.<br><p>  - `"NoneOnDryRun"` means that calling the webhook will possibly have side effects, but if the request being reviewed has the dry-run attribute, the side effects will be suppressed.<br><p>  - `"Some"` means that calling the webhook will possibly have side effects. If a request with the dry-run attribute would trigger a call to this webhook, the request will instead fail.<br><p>  - `"Unknown"` means that no information is known about the side effects of calling the webhook. If a request with the dry-run attribute would trigger a call to this webhook, the request will instead fail.
     */
    @JsonProperty("sideEffects")
    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("targetPort")
    public IntOrString getTargetPort() {
        return targetPort;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("targetPort")
    public void setTargetPort(IntOrString targetPort) {
        this.targetPort = targetPort;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("webhookPath")
    public String getWebhookPath() {
        return webhookPath;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("webhookPath")
    public void setWebhookPath(String webhookPath) {
        this.webhookPath = webhookPath;
    }

    @JsonIgnore
    public WebhookDescriptionBuilder edit() {
        return new WebhookDescriptionBuilder(this);
    }

    @JsonIgnore
    public WebhookDescriptionBuilder toBuilder() {
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
        if (!(o instanceof WebhookDescription)) {
            return false;
        }
        WebhookDescription other = (WebhookDescription) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$admissionReviewVersions = this.getAdmissionReviewVersions();
        Object other$admissionReviewVersions = other.getAdmissionReviewVersions();
        if (this$admissionReviewVersions == null ? other$admissionReviewVersions != null : !this$admissionReviewVersions.equals(other$admissionReviewVersions)) {
            return false;
        }
        Object this$containerPort = this.getContainerPort();
        Object other$containerPort = other.getContainerPort();
        if (this$containerPort == null ? other$containerPort != null : !this$containerPort.equals(other$containerPort)) {
            return false;
        }
        Object this$conversionCRDs = this.getConversionCRDs();
        Object other$conversionCRDs = other.getConversionCRDs();
        if (this$conversionCRDs == null ? other$conversionCRDs != null : !this$conversionCRDs.equals(other$conversionCRDs)) {
            return false;
        }
        Object this$deploymentName = this.getDeploymentName();
        Object other$deploymentName = other.getDeploymentName();
        if (this$deploymentName == null ? other$deploymentName != null : !this$deploymentName.equals(other$deploymentName)) {
            return false;
        }
        Object this$failurePolicy = this.getFailurePolicy();
        Object other$failurePolicy = other.getFailurePolicy();
        if (this$failurePolicy == null ? other$failurePolicy != null : !this$failurePolicy.equals(other$failurePolicy)) {
            return false;
        }
        Object this$generateName = this.getGenerateName();
        Object other$generateName = other.getGenerateName();
        if (this$generateName == null ? other$generateName != null : !this$generateName.equals(other$generateName)) {
            return false;
        }
        Object this$matchPolicy = this.getMatchPolicy();
        Object other$matchPolicy = other.getMatchPolicy();
        if (this$matchPolicy == null ? other$matchPolicy != null : !this$matchPolicy.equals(other$matchPolicy)) {
            return false;
        }
        Object this$objectSelector = this.getObjectSelector();
        Object other$objectSelector = other.getObjectSelector();
        if (this$objectSelector == null ? other$objectSelector != null : !this$objectSelector.equals(other$objectSelector)) {
            return false;
        }
        Object this$reinvocationPolicy = this.getReinvocationPolicy();
        Object other$reinvocationPolicy = other.getReinvocationPolicy();
        if (this$reinvocationPolicy == null ? other$reinvocationPolicy != null : !this$reinvocationPolicy.equals(other$reinvocationPolicy)) {
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
        Object this$targetPort = this.getTargetPort();
        Object other$targetPort = other.getTargetPort();
        if (this$targetPort == null ? other$targetPort != null : !this$targetPort.equals(other$targetPort)) {
            return false;
        }
        Object this$timeoutSeconds = this.getTimeoutSeconds();
        Object other$timeoutSeconds = other.getTimeoutSeconds();
        if (this$timeoutSeconds == null ? other$timeoutSeconds != null : !this$timeoutSeconds.equals(other$timeoutSeconds)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$webhookPath = this.getWebhookPath();
        Object other$webhookPath = other.getWebhookPath();
        if (this$webhookPath == null ? other$webhookPath != null : !this$webhookPath.equals(other$webhookPath)) {
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
        return other instanceof WebhookDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $admissionReviewVersions = this.getAdmissionReviewVersions();
        result = result * prime + ($admissionReviewVersions == null ? 43 : $admissionReviewVersions.hashCode());
        Object $containerPort = this.getContainerPort();
        result = result * prime + ($containerPort == null ? 43 : $containerPort.hashCode());
        Object $conversionCRDs = this.getConversionCRDs();
        result = result * prime + ($conversionCRDs == null ? 43 : $conversionCRDs.hashCode());
        Object $deploymentName = this.getDeploymentName();
        result = result * prime + ($deploymentName == null ? 43 : $deploymentName.hashCode());
        Object $failurePolicy = this.getFailurePolicy();
        result = result * prime + ($failurePolicy == null ? 43 : $failurePolicy.hashCode());
        Object $generateName = this.getGenerateName();
        result = result * prime + ($generateName == null ? 43 : $generateName.hashCode());
        Object $matchPolicy = this.getMatchPolicy();
        result = result * prime + ($matchPolicy == null ? 43 : $matchPolicy.hashCode());
        Object $objectSelector = this.getObjectSelector();
        result = result * prime + ($objectSelector == null ? 43 : $objectSelector.hashCode());
        Object $reinvocationPolicy = this.getReinvocationPolicy();
        result = result * prime + ($reinvocationPolicy == null ? 43 : $reinvocationPolicy.hashCode());
        Object $rules = this.getRules();
        result = result * prime + ($rules == null ? 43 : $rules.hashCode());
        Object $sideEffects = this.getSideEffects();
        result = result * prime + ($sideEffects == null ? 43 : $sideEffects.hashCode());
        Object $targetPort = this.getTargetPort();
        result = result * prime + ($targetPort == null ? 43 : $targetPort.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $webhookPath = this.getWebhookPath();
        result = result * prime + ($webhookPath == null ? 43 : $webhookPath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WebhookDescription(" + "admissionReviewVersions=" + this.getAdmissionReviewVersions() + ", containerPort=" + this.getContainerPort() + ", conversionCRDs=" + this.getConversionCRDs() + ", deploymentName=" + this.getDeploymentName() + ", failurePolicy=" + this.getFailurePolicy() + ", generateName=" + this.getGenerateName() + ", matchPolicy=" + this.getMatchPolicy() + ", objectSelector=" + this.getObjectSelector() + ", reinvocationPolicy=" + this.getReinvocationPolicy() + ", rules=" + this.getRules() + ", sideEffects=" + this.getSideEffects() + ", targetPort=" + this.getTargetPort() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", type=" + this.getType() + ", webhookPath=" + this.getWebhookPath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
