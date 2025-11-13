
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
     * WebhookDescription provides details to OLM about required webhooks
     */
    @JsonProperty("reinvocationPolicy")
    public String getReinvocationPolicy() {
        return reinvocationPolicy;
    }

    /**
     * WebhookDescription provides details to OLM about required webhooks
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

}
