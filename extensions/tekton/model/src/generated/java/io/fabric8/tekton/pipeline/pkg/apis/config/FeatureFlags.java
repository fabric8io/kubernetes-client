
package io.fabric8.tekton.pipeline.pkg.apis.config;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AwaitSidecarReadiness",
    "Coschedule",
    "DisableAffinityAssistant",
    "DisableCredsInit",
    "DisableInlineSpec",
    "EnableAPIFields",
    "EnableArtifacts",
    "EnableCELInWhenExpression",
    "EnableConciseResolverSyntax",
    "EnableKeepPodOnCancel",
    "EnableKubernetesSidecar",
    "EnableParamEnum",
    "EnableProvenanceInStatus",
    "EnableStepActions",
    "EnforceNonfalsifiability",
    "MaxResultSize",
    "RequireGitSSHSecretKnownHosts",
    "ResultExtractionMethod",
    "RunningInEnvWithInjectedSidecars",
    "SendCloudEventsForRuns",
    "SetSecurityContext",
    "VerificationNoMatchPolicy"
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
public class FeatureFlags implements Editable<FeatureFlagsBuilder>, KubernetesResource
{

    @JsonProperty("AwaitSidecarReadiness")
    private Boolean awaitSidecarReadiness;
    @JsonProperty("Coschedule")
    private String coschedule;
    @JsonProperty("DisableAffinityAssistant")
    private Boolean disableAffinityAssistant;
    @JsonProperty("DisableCredsInit")
    private Boolean disableCredsInit;
    @JsonProperty("DisableInlineSpec")
    private String disableInlineSpec;
    @JsonProperty("EnableAPIFields")
    private String enableAPIFields;
    @JsonProperty("EnableArtifacts")
    private Boolean enableArtifacts;
    @JsonProperty("EnableCELInWhenExpression")
    private Boolean enableCELInWhenExpression;
    @JsonProperty("EnableConciseResolverSyntax")
    private Boolean enableConciseResolverSyntax;
    @JsonProperty("EnableKeepPodOnCancel")
    private Boolean enableKeepPodOnCancel;
    @JsonProperty("EnableKubernetesSidecar")
    private Boolean enableKubernetesSidecar;
    @JsonProperty("EnableParamEnum")
    private Boolean enableParamEnum;
    @JsonProperty("EnableProvenanceInStatus")
    private Boolean enableProvenanceInStatus;
    @JsonProperty("EnableStepActions")
    private Boolean enableStepActions;
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
    @JsonProperty("SendCloudEventsForRuns")
    private Boolean sendCloudEventsForRuns;
    @JsonProperty("SetSecurityContext")
    private Boolean setSecurityContext;
    @JsonProperty("VerificationNoMatchPolicy")
    private String verificationNoMatchPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FeatureFlags() {
    }

    public FeatureFlags(Boolean awaitSidecarReadiness, String coschedule, Boolean disableAffinityAssistant, Boolean disableCredsInit, String disableInlineSpec, String enableAPIFields, Boolean enableArtifacts, Boolean enableCELInWhenExpression, Boolean enableConciseResolverSyntax, Boolean enableKeepPodOnCancel, Boolean enableKubernetesSidecar, Boolean enableParamEnum, Boolean enableProvenanceInStatus, Boolean enableStepActions, String enforceNonfalsifiability, Integer maxResultSize, Boolean requireGitSSHSecretKnownHosts, String resultExtractionMethod, Boolean runningInEnvWithInjectedSidecars, Boolean sendCloudEventsForRuns, Boolean setSecurityContext, String verificationNoMatchPolicy) {
        super();
        this.awaitSidecarReadiness = awaitSidecarReadiness;
        this.coschedule = coschedule;
        this.disableAffinityAssistant = disableAffinityAssistant;
        this.disableCredsInit = disableCredsInit;
        this.disableInlineSpec = disableInlineSpec;
        this.enableAPIFields = enableAPIFields;
        this.enableArtifacts = enableArtifacts;
        this.enableCELInWhenExpression = enableCELInWhenExpression;
        this.enableConciseResolverSyntax = enableConciseResolverSyntax;
        this.enableKeepPodOnCancel = enableKeepPodOnCancel;
        this.enableKubernetesSidecar = enableKubernetesSidecar;
        this.enableParamEnum = enableParamEnum;
        this.enableProvenanceInStatus = enableProvenanceInStatus;
        this.enableStepActions = enableStepActions;
        this.enforceNonfalsifiability = enforceNonfalsifiability;
        this.maxResultSize = maxResultSize;
        this.requireGitSSHSecretKnownHosts = requireGitSSHSecretKnownHosts;
        this.resultExtractionMethod = resultExtractionMethod;
        this.runningInEnvWithInjectedSidecars = runningInEnvWithInjectedSidecars;
        this.sendCloudEventsForRuns = sendCloudEventsForRuns;
        this.setSecurityContext = setSecurityContext;
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

    @JsonProperty("Coschedule")
    public String getCoschedule() {
        return coschedule;
    }

    @JsonProperty("Coschedule")
    public void setCoschedule(String coschedule) {
        this.coschedule = coschedule;
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

    @JsonProperty("DisableInlineSpec")
    public String getDisableInlineSpec() {
        return disableInlineSpec;
    }

    @JsonProperty("DisableInlineSpec")
    public void setDisableInlineSpec(String disableInlineSpec) {
        this.disableInlineSpec = disableInlineSpec;
    }

    @JsonProperty("EnableAPIFields")
    public String getEnableAPIFields() {
        return enableAPIFields;
    }

    @JsonProperty("EnableAPIFields")
    public void setEnableAPIFields(String enableAPIFields) {
        this.enableAPIFields = enableAPIFields;
    }

    @JsonProperty("EnableArtifacts")
    public Boolean getEnableArtifacts() {
        return enableArtifacts;
    }

    @JsonProperty("EnableArtifacts")
    public void setEnableArtifacts(Boolean enableArtifacts) {
        this.enableArtifacts = enableArtifacts;
    }

    @JsonProperty("EnableCELInWhenExpression")
    public Boolean getEnableCELInWhenExpression() {
        return enableCELInWhenExpression;
    }

    @JsonProperty("EnableCELInWhenExpression")
    public void setEnableCELInWhenExpression(Boolean enableCELInWhenExpression) {
        this.enableCELInWhenExpression = enableCELInWhenExpression;
    }

    @JsonProperty("EnableConciseResolverSyntax")
    public Boolean getEnableConciseResolverSyntax() {
        return enableConciseResolverSyntax;
    }

    @JsonProperty("EnableConciseResolverSyntax")
    public void setEnableConciseResolverSyntax(Boolean enableConciseResolverSyntax) {
        this.enableConciseResolverSyntax = enableConciseResolverSyntax;
    }

    @JsonProperty("EnableKeepPodOnCancel")
    public Boolean getEnableKeepPodOnCancel() {
        return enableKeepPodOnCancel;
    }

    @JsonProperty("EnableKeepPodOnCancel")
    public void setEnableKeepPodOnCancel(Boolean enableKeepPodOnCancel) {
        this.enableKeepPodOnCancel = enableKeepPodOnCancel;
    }

    @JsonProperty("EnableKubernetesSidecar")
    public Boolean getEnableKubernetesSidecar() {
        return enableKubernetesSidecar;
    }

    @JsonProperty("EnableKubernetesSidecar")
    public void setEnableKubernetesSidecar(Boolean enableKubernetesSidecar) {
        this.enableKubernetesSidecar = enableKubernetesSidecar;
    }

    @JsonProperty("EnableParamEnum")
    public Boolean getEnableParamEnum() {
        return enableParamEnum;
    }

    @JsonProperty("EnableParamEnum")
    public void setEnableParamEnum(Boolean enableParamEnum) {
        this.enableParamEnum = enableParamEnum;
    }

    @JsonProperty("EnableProvenanceInStatus")
    public Boolean getEnableProvenanceInStatus() {
        return enableProvenanceInStatus;
    }

    @JsonProperty("EnableProvenanceInStatus")
    public void setEnableProvenanceInStatus(Boolean enableProvenanceInStatus) {
        this.enableProvenanceInStatus = enableProvenanceInStatus;
    }

    @JsonProperty("EnableStepActions")
    public Boolean getEnableStepActions() {
        return enableStepActions;
    }

    @JsonProperty("EnableStepActions")
    public void setEnableStepActions(Boolean enableStepActions) {
        this.enableStepActions = enableStepActions;
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

    @JsonProperty("SendCloudEventsForRuns")
    public Boolean getSendCloudEventsForRuns() {
        return sendCloudEventsForRuns;
    }

    @JsonProperty("SendCloudEventsForRuns")
    public void setSendCloudEventsForRuns(Boolean sendCloudEventsForRuns) {
        this.sendCloudEventsForRuns = sendCloudEventsForRuns;
    }

    @JsonProperty("SetSecurityContext")
    public Boolean getSetSecurityContext() {
        return setSecurityContext;
    }

    @JsonProperty("SetSecurityContext")
    public void setSetSecurityContext(Boolean setSecurityContext) {
        this.setSecurityContext = setSecurityContext;
    }

    @JsonProperty("VerificationNoMatchPolicy")
    public String getVerificationNoMatchPolicy() {
        return verificationNoMatchPolicy;
    }

    @JsonProperty("VerificationNoMatchPolicy")
    public void setVerificationNoMatchPolicy(String verificationNoMatchPolicy) {
        this.verificationNoMatchPolicy = verificationNoMatchPolicy;
    }

    @JsonIgnore
    public FeatureFlagsBuilder edit() {
        return new FeatureFlagsBuilder(this);
    }

    @JsonIgnore
    public FeatureFlagsBuilder toBuilder() {
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
