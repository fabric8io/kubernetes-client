
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations;
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
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class WebhookDescription implements KubernetesResource
{

    @JsonProperty("admissionReviewVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> admissionReviewVersions = new ArrayList<String>();
    @JsonProperty("containerPort")
    private Integer containerPort;
    @JsonProperty("conversionCRDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> conversionCRDs = new ArrayList<String>();
    @JsonProperty("deploymentName")
    private String deploymentName;
    @JsonProperty("failurePolicy")
    private String failurePolicy;
    @JsonProperty("generateName")
    private String generateName;
    @JsonProperty("matchPolicy")
    private String matchPolicy;
    @JsonProperty("objectSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector objectSelector;
    @JsonProperty("reinvocationPolicy")
    private String reinvocationPolicy;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RuleWithOperations> rules = new ArrayList<RuleWithOperations>();
    @JsonProperty("sideEffects")
    private String sideEffects;
    @JsonProperty("targetPort")
    private io.fabric8.kubernetes.api.model.IntOrString targetPort;
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
     * 
     */
    public WebhookDescription() {
    }

    public WebhookDescription(List<String> admissionReviewVersions, Integer containerPort, List<String> conversionCRDs, String deploymentName, String failurePolicy, String generateName, String matchPolicy, io.fabric8.kubernetes.api.model.LabelSelector objectSelector, String reinvocationPolicy, List<RuleWithOperations> rules, String sideEffects, io.fabric8.kubernetes.api.model.IntOrString targetPort, Integer timeoutSeconds, String type, String webhookPath) {
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

    @JsonProperty("admissionReviewVersions")
    public List<String> getAdmissionReviewVersions() {
        return admissionReviewVersions;
    }

    @JsonProperty("admissionReviewVersions")
    public void setAdmissionReviewVersions(List<String> admissionReviewVersions) {
        this.admissionReviewVersions = admissionReviewVersions;
    }

    @JsonProperty("containerPort")
    public Integer getContainerPort() {
        return containerPort;
    }

    @JsonProperty("containerPort")
    public void setContainerPort(Integer containerPort) {
        this.containerPort = containerPort;
    }

    @JsonProperty("conversionCRDs")
    public List<String> getConversionCRDs() {
        return conversionCRDs;
    }

    @JsonProperty("conversionCRDs")
    public void setConversionCRDs(List<String> conversionCRDs) {
        this.conversionCRDs = conversionCRDs;
    }

    @JsonProperty("deploymentName")
    public String getDeploymentName() {
        return deploymentName;
    }

    @JsonProperty("deploymentName")
    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    @JsonProperty("failurePolicy")
    public String getFailurePolicy() {
        return failurePolicy;
    }

    @JsonProperty("failurePolicy")
    public void setFailurePolicy(String failurePolicy) {
        this.failurePolicy = failurePolicy;
    }

    @JsonProperty("generateName")
    public String getGenerateName() {
        return generateName;
    }

    @JsonProperty("generateName")
    public void setGenerateName(String generateName) {
        this.generateName = generateName;
    }

    @JsonProperty("matchPolicy")
    public String getMatchPolicy() {
        return matchPolicy;
    }

    @JsonProperty("matchPolicy")
    public void setMatchPolicy(String matchPolicy) {
        this.matchPolicy = matchPolicy;
    }

    @JsonProperty("objectSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getObjectSelector() {
        return objectSelector;
    }

    @JsonProperty("objectSelector")
    public void setObjectSelector(io.fabric8.kubernetes.api.model.LabelSelector objectSelector) {
        this.objectSelector = objectSelector;
    }

    @JsonProperty("reinvocationPolicy")
    public String getReinvocationPolicy() {
        return reinvocationPolicy;
    }

    @JsonProperty("reinvocationPolicy")
    public void setReinvocationPolicy(String reinvocationPolicy) {
        this.reinvocationPolicy = reinvocationPolicy;
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

    @JsonProperty("targetPort")
    public io.fabric8.kubernetes.api.model.IntOrString getTargetPort() {
        return targetPort;
    }

    @JsonProperty("targetPort")
    public void setTargetPort(io.fabric8.kubernetes.api.model.IntOrString targetPort) {
        this.targetPort = targetPort;
    }

    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("webhookPath")
    public String getWebhookPath() {
        return webhookPath;
    }

    @JsonProperty("webhookPath")
    public void setWebhookPath(String webhookPath) {
        this.webhookPath = webhookPath;
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
