
package io.fabric8.tekton.v1.internal.pipeline.pkg.apis.config;

import java.util.LinkedHashMap;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "AwaitSidecarReadiness",
    "DisableAffinityAssistant",
    "DisableCredsInit",
    "EnableAPIFields",
    "EnableProvenanceInStatus",
    "EnableTektonOCIBundles",
    "EnforceNonfalsifiability",
    "MaxResultSize",
    "RequireGitSSHSecretKnownHosts",
    "ResultExtractionMethod",
    "RunningInEnvWithInjectedSidecars",
    "ScopeWhenExpressionsToTask",
    "SendCloudEventsForRuns",
    "VerificationNoMatchPolicy"
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
@Generated("jsonschema2pojo")
public class FeatureFlags implements KubernetesResource
{

    @JsonProperty("AwaitSidecarReadiness")
    private Boolean awaitSidecarReadiness;
    @JsonProperty("DisableAffinityAssistant")
    private Boolean disableAffinityAssistant;
    @JsonProperty("DisableCredsInit")
    private Boolean disableCredsInit;
    @JsonProperty("EnableAPIFields")
    private String enableAPIFields;
    @JsonProperty("EnableProvenanceInStatus")
    private Boolean enableProvenanceInStatus;
    @JsonProperty("EnableTektonOCIBundles")
    private Boolean enableTektonOCIBundles;
    @JsonProperty("EnforceNonfalsifiability")
    private String enforceNonfalsifiability;
    @JsonProperty("MaxResultSize")
    private Integer maxResultSize;
    @JsonProperty("RequireGitSSHSecretKnownHosts")
    private Boolean requireGitSSHSecretKnownHosts;
    @JsonProperty("ResultExtractionMethod")
    private String resultExtractionMethod;
    @JsonProperty("RunningInEnvWithInjectedSidecars")
    private Boolean runningInEnvWithInjectedSidecars;
    @JsonProperty("ScopeWhenExpressionsToTask")
    private Boolean scopeWhenExpressionsToTask;
    @JsonProperty("SendCloudEventsForRuns")
    private Boolean sendCloudEventsForRuns;
    @JsonProperty("VerificationNoMatchPolicy")
    private String verificationNoMatchPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FeatureFlags() {
    }

    public FeatureFlags(Boolean awaitSidecarReadiness, Boolean disableAffinityAssistant, Boolean disableCredsInit, String enableAPIFields, Boolean enableProvenanceInStatus, Boolean enableTektonOCIBundles, String enforceNonfalsifiability, Integer maxResultSize, Boolean requireGitSSHSecretKnownHosts, String resultExtractionMethod, Boolean runningInEnvWithInjectedSidecars, Boolean scopeWhenExpressionsToTask, Boolean sendCloudEventsForRuns, String verificationNoMatchPolicy) {
        super();
        this.awaitSidecarReadiness = awaitSidecarReadiness;
        this.disableAffinityAssistant = disableAffinityAssistant;
        this.disableCredsInit = disableCredsInit;
        this.enableAPIFields = enableAPIFields;
        this.enableProvenanceInStatus = enableProvenanceInStatus;
        this.enableTektonOCIBundles = enableTektonOCIBundles;
        this.enforceNonfalsifiability = enforceNonfalsifiability;
        this.maxResultSize = maxResultSize;
        this.requireGitSSHSecretKnownHosts = requireGitSSHSecretKnownHosts;
        this.resultExtractionMethod = resultExtractionMethod;
        this.runningInEnvWithInjectedSidecars = runningInEnvWithInjectedSidecars;
        this.scopeWhenExpressionsToTask = scopeWhenExpressionsToTask;
        this.sendCloudEventsForRuns = sendCloudEventsForRuns;
        this.verificationNoMatchPolicy = verificationNoMatchPolicy;
    }

    @JsonProperty("AwaitSidecarReadiness")
    public Boolean getAwaitSidecarReadiness() {
        return awaitSidecarReadiness;
    }

    @JsonProperty("AwaitSidecarReadiness")
    public void setAwaitSidecarReadiness(Boolean awaitSidecarReadiness) {
        this.awaitSidecarReadiness = awaitSidecarReadiness;
    }

    @JsonProperty("DisableAffinityAssistant")
    public Boolean getDisableAffinityAssistant() {
        return disableAffinityAssistant;
    }

    @JsonProperty("DisableAffinityAssistant")
    public void setDisableAffinityAssistant(Boolean disableAffinityAssistant) {
        this.disableAffinityAssistant = disableAffinityAssistant;
    }

    @JsonProperty("DisableCredsInit")
    public Boolean getDisableCredsInit() {
        return disableCredsInit;
    }

    @JsonProperty("DisableCredsInit")
    public void setDisableCredsInit(Boolean disableCredsInit) {
        this.disableCredsInit = disableCredsInit;
    }

    @JsonProperty("EnableAPIFields")
    public String getEnableAPIFields() {
        return enableAPIFields;
    }

    @JsonProperty("EnableAPIFields")
    public void setEnableAPIFields(String enableAPIFields) {
        this.enableAPIFields = enableAPIFields;
    }

    @JsonProperty("EnableProvenanceInStatus")
    public Boolean getEnableProvenanceInStatus() {
        return enableProvenanceInStatus;
    }

    @JsonProperty("EnableProvenanceInStatus")
    public void setEnableProvenanceInStatus(Boolean enableProvenanceInStatus) {
        this.enableProvenanceInStatus = enableProvenanceInStatus;
    }

    @JsonProperty("EnableTektonOCIBundles")
    public Boolean getEnableTektonOCIBundles() {
        return enableTektonOCIBundles;
    }

    @JsonProperty("EnableTektonOCIBundles")
    public void setEnableTektonOCIBundles(Boolean enableTektonOCIBundles) {
        this.enableTektonOCIBundles = enableTektonOCIBundles;
    }

    @JsonProperty("EnforceNonfalsifiability")
    public String getEnforceNonfalsifiability() {
        return enforceNonfalsifiability;
    }

    @JsonProperty("EnforceNonfalsifiability")
    public void setEnforceNonfalsifiability(String enforceNonfalsifiability) {
        this.enforceNonfalsifiability = enforceNonfalsifiability;
    }

    @JsonProperty("MaxResultSize")
    public Integer getMaxResultSize() {
        return maxResultSize;
    }

    @JsonProperty("MaxResultSize")
    public void setMaxResultSize(Integer maxResultSize) {
        this.maxResultSize = maxResultSize;
    }

    @JsonProperty("RequireGitSSHSecretKnownHosts")
    public Boolean getRequireGitSSHSecretKnownHosts() {
        return requireGitSSHSecretKnownHosts;
    }

    @JsonProperty("RequireGitSSHSecretKnownHosts")
    public void setRequireGitSSHSecretKnownHosts(Boolean requireGitSSHSecretKnownHosts) {
        this.requireGitSSHSecretKnownHosts = requireGitSSHSecretKnownHosts;
    }

    @JsonProperty("ResultExtractionMethod")
    public String getResultExtractionMethod() {
        return resultExtractionMethod;
    }

    @JsonProperty("ResultExtractionMethod")
    public void setResultExtractionMethod(String resultExtractionMethod) {
        this.resultExtractionMethod = resultExtractionMethod;
    }

    @JsonProperty("RunningInEnvWithInjectedSidecars")
    public Boolean getRunningInEnvWithInjectedSidecars() {
        return runningInEnvWithInjectedSidecars;
    }

    @JsonProperty("RunningInEnvWithInjectedSidecars")
    public void setRunningInEnvWithInjectedSidecars(Boolean runningInEnvWithInjectedSidecars) {
        this.runningInEnvWithInjectedSidecars = runningInEnvWithInjectedSidecars;
    }

    @JsonProperty("ScopeWhenExpressionsToTask")
    public Boolean getScopeWhenExpressionsToTask() {
        return scopeWhenExpressionsToTask;
    }

    @JsonProperty("ScopeWhenExpressionsToTask")
    public void setScopeWhenExpressionsToTask(Boolean scopeWhenExpressionsToTask) {
        this.scopeWhenExpressionsToTask = scopeWhenExpressionsToTask;
    }

    @JsonProperty("SendCloudEventsForRuns")
    public Boolean getSendCloudEventsForRuns() {
        return sendCloudEventsForRuns;
    }

    @JsonProperty("SendCloudEventsForRuns")
    public void setSendCloudEventsForRuns(Boolean sendCloudEventsForRuns) {
        this.sendCloudEventsForRuns = sendCloudEventsForRuns;
    }

    @JsonProperty("VerificationNoMatchPolicy")
    public String getVerificationNoMatchPolicy() {
        return verificationNoMatchPolicy;
    }

    @JsonProperty("VerificationNoMatchPolicy")
    public void setVerificationNoMatchPolicy(String verificationNoMatchPolicy) {
        this.verificationNoMatchPolicy = verificationNoMatchPolicy;
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
