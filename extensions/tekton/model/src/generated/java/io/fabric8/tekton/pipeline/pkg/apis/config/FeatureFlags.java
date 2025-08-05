
package io.fabric8.tekton.pipeline.pkg.apis.config;

import java.util.LinkedHashMap;
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
 * FeatureFlags holds the features configurations
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "awaitSidecarReadiness",
    "coschedule",
    "disableCredsInit",
    "disableInlineSpec",
    "enableAPIFields",
    "enableArtifacts",
    "enableCELInWhenExpression",
    "enableConciseResolverSyntax",
    "enableKeepPodOnCancel",
    "enableKubernetesSidecar",
    "enableParamEnum",
    "enableProvenanceInStatus",
    "enableStepActions",
    "enforceNonfalsifiability",
    "maxResultSize",
    "requireGitSSHSecretKnownHosts",
    "resultExtractionMethod",
    "runningInEnvWithInjectedSidecars",
    "sendCloudEventsForRuns",
    "setSecurityContext",
    "setSecurityContextReadOnlyRootFilesystem",
    "verificationNoMatchPolicy"
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

    @JsonProperty("awaitSidecarReadiness")
    private Boolean awaitSidecarReadiness;
    @JsonProperty("coschedule")
    private String coschedule;
    @JsonProperty("disableCredsInit")
    private Boolean disableCredsInit;
    @JsonProperty("disableInlineSpec")
    private String disableInlineSpec;
    @JsonProperty("enableAPIFields")
    private String enableAPIFields;
    @JsonProperty("enableArtifacts")
    private Boolean enableArtifacts;
    @JsonProperty("enableCELInWhenExpression")
    private Boolean enableCELInWhenExpression;
    @JsonProperty("enableConciseResolverSyntax")
    private Boolean enableConciseResolverSyntax;
    @JsonProperty("enableKeepPodOnCancel")
    private Boolean enableKeepPodOnCancel;
    @JsonProperty("enableKubernetesSidecar")
    private Boolean enableKubernetesSidecar;
    @JsonProperty("enableParamEnum")
    private Boolean enableParamEnum;
    @JsonProperty("enableProvenanceInStatus")
    private Boolean enableProvenanceInStatus;
    @JsonProperty("enableStepActions")
    private Boolean enableStepActions;
    @JsonProperty("enforceNonfalsifiability")
    private String enforceNonfalsifiability;
    @JsonProperty("maxResultSize")
    private Integer maxResultSize;
    @JsonProperty("requireGitSSHSecretKnownHosts")
    private Boolean requireGitSSHSecretKnownHosts;
    @JsonProperty("resultExtractionMethod")
    private String resultExtractionMethod;
    @JsonProperty("runningInEnvWithInjectedSidecars")
    private Boolean runningInEnvWithInjectedSidecars;
    @JsonProperty("sendCloudEventsForRuns")
    private Boolean sendCloudEventsForRuns;
    @JsonProperty("setSecurityContext")
    private Boolean setSecurityContext;
    @JsonProperty("setSecurityContextReadOnlyRootFilesystem")
    private Boolean setSecurityContextReadOnlyRootFilesystem;
    @JsonProperty("verificationNoMatchPolicy")
    private String verificationNoMatchPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FeatureFlags() {
    }

    public FeatureFlags(Boolean awaitSidecarReadiness, String coschedule, Boolean disableCredsInit, String disableInlineSpec, String enableAPIFields, Boolean enableArtifacts, Boolean enableCELInWhenExpression, Boolean enableConciseResolverSyntax, Boolean enableKeepPodOnCancel, Boolean enableKubernetesSidecar, Boolean enableParamEnum, Boolean enableProvenanceInStatus, Boolean enableStepActions, String enforceNonfalsifiability, Integer maxResultSize, Boolean requireGitSSHSecretKnownHosts, String resultExtractionMethod, Boolean runningInEnvWithInjectedSidecars, Boolean sendCloudEventsForRuns, Boolean setSecurityContext, Boolean setSecurityContextReadOnlyRootFilesystem, String verificationNoMatchPolicy) {
        super();
        this.awaitSidecarReadiness = awaitSidecarReadiness;
        this.coschedule = coschedule;
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
        this.setSecurityContextReadOnlyRootFilesystem = setSecurityContextReadOnlyRootFilesystem;
        this.verificationNoMatchPolicy = verificationNoMatchPolicy;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("awaitSidecarReadiness")
    public Boolean getAwaitSidecarReadiness() {
        return awaitSidecarReadiness;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("awaitSidecarReadiness")
    public void setAwaitSidecarReadiness(Boolean awaitSidecarReadiness) {
        this.awaitSidecarReadiness = awaitSidecarReadiness;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("coschedule")
    public String getCoschedule() {
        return coschedule;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("coschedule")
    public void setCoschedule(String coschedule) {
        this.coschedule = coschedule;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("disableCredsInit")
    public Boolean getDisableCredsInit() {
        return disableCredsInit;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("disableCredsInit")
    public void setDisableCredsInit(Boolean disableCredsInit) {
        this.disableCredsInit = disableCredsInit;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("disableInlineSpec")
    public String getDisableInlineSpec() {
        return disableInlineSpec;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("disableInlineSpec")
    public void setDisableInlineSpec(String disableInlineSpec) {
        this.disableInlineSpec = disableInlineSpec;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableAPIFields")
    public String getEnableAPIFields() {
        return enableAPIFields;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableAPIFields")
    public void setEnableAPIFields(String enableAPIFields) {
        this.enableAPIFields = enableAPIFields;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableArtifacts")
    public Boolean getEnableArtifacts() {
        return enableArtifacts;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableArtifacts")
    public void setEnableArtifacts(Boolean enableArtifacts) {
        this.enableArtifacts = enableArtifacts;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableCELInWhenExpression")
    public Boolean getEnableCELInWhenExpression() {
        return enableCELInWhenExpression;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableCELInWhenExpression")
    public void setEnableCELInWhenExpression(Boolean enableCELInWhenExpression) {
        this.enableCELInWhenExpression = enableCELInWhenExpression;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableConciseResolverSyntax")
    public Boolean getEnableConciseResolverSyntax() {
        return enableConciseResolverSyntax;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableConciseResolverSyntax")
    public void setEnableConciseResolverSyntax(Boolean enableConciseResolverSyntax) {
        this.enableConciseResolverSyntax = enableConciseResolverSyntax;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableKeepPodOnCancel")
    public Boolean getEnableKeepPodOnCancel() {
        return enableKeepPodOnCancel;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableKeepPodOnCancel")
    public void setEnableKeepPodOnCancel(Boolean enableKeepPodOnCancel) {
        this.enableKeepPodOnCancel = enableKeepPodOnCancel;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableKubernetesSidecar")
    public Boolean getEnableKubernetesSidecar() {
        return enableKubernetesSidecar;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableKubernetesSidecar")
    public void setEnableKubernetesSidecar(Boolean enableKubernetesSidecar) {
        this.enableKubernetesSidecar = enableKubernetesSidecar;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableParamEnum")
    public Boolean getEnableParamEnum() {
        return enableParamEnum;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableParamEnum")
    public void setEnableParamEnum(Boolean enableParamEnum) {
        this.enableParamEnum = enableParamEnum;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableProvenanceInStatus")
    public Boolean getEnableProvenanceInStatus() {
        return enableProvenanceInStatus;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableProvenanceInStatus")
    public void setEnableProvenanceInStatus(Boolean enableProvenanceInStatus) {
        this.enableProvenanceInStatus = enableProvenanceInStatus;
    }

    /**
     * EnableStepActions is a no-op flag since StepActions are stable
     */
    @JsonProperty("enableStepActions")
    public Boolean getEnableStepActions() {
        return enableStepActions;
    }

    /**
     * EnableStepActions is a no-op flag since StepActions are stable
     */
    @JsonProperty("enableStepActions")
    public void setEnableStepActions(Boolean enableStepActions) {
        this.enableStepActions = enableStepActions;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enforceNonfalsifiability")
    public String getEnforceNonfalsifiability() {
        return enforceNonfalsifiability;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enforceNonfalsifiability")
    public void setEnforceNonfalsifiability(String enforceNonfalsifiability) {
        this.enforceNonfalsifiability = enforceNonfalsifiability;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("maxResultSize")
    public Integer getMaxResultSize() {
        return maxResultSize;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("maxResultSize")
    public void setMaxResultSize(Integer maxResultSize) {
        this.maxResultSize = maxResultSize;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("requireGitSSHSecretKnownHosts")
    public Boolean getRequireGitSSHSecretKnownHosts() {
        return requireGitSSHSecretKnownHosts;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("requireGitSSHSecretKnownHosts")
    public void setRequireGitSSHSecretKnownHosts(Boolean requireGitSSHSecretKnownHosts) {
        this.requireGitSSHSecretKnownHosts = requireGitSSHSecretKnownHosts;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("resultExtractionMethod")
    public String getResultExtractionMethod() {
        return resultExtractionMethod;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("resultExtractionMethod")
    public void setResultExtractionMethod(String resultExtractionMethod) {
        this.resultExtractionMethod = resultExtractionMethod;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("runningInEnvWithInjectedSidecars")
    public Boolean getRunningInEnvWithInjectedSidecars() {
        return runningInEnvWithInjectedSidecars;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("runningInEnvWithInjectedSidecars")
    public void setRunningInEnvWithInjectedSidecars(Boolean runningInEnvWithInjectedSidecars) {
        this.runningInEnvWithInjectedSidecars = runningInEnvWithInjectedSidecars;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("sendCloudEventsForRuns")
    public Boolean getSendCloudEventsForRuns() {
        return sendCloudEventsForRuns;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("sendCloudEventsForRuns")
    public void setSendCloudEventsForRuns(Boolean sendCloudEventsForRuns) {
        this.sendCloudEventsForRuns = sendCloudEventsForRuns;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("setSecurityContext")
    public Boolean getSetSecurityContext() {
        return setSecurityContext;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("setSecurityContext")
    public void setSetSecurityContext(Boolean setSecurityContext) {
        this.setSecurityContext = setSecurityContext;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("setSecurityContextReadOnlyRootFilesystem")
    public Boolean getSetSecurityContextReadOnlyRootFilesystem() {
        return setSecurityContextReadOnlyRootFilesystem;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("setSecurityContextReadOnlyRootFilesystem")
    public void setSetSecurityContextReadOnlyRootFilesystem(Boolean setSecurityContextReadOnlyRootFilesystem) {
        this.setSecurityContextReadOnlyRootFilesystem = setSecurityContextReadOnlyRootFilesystem;
    }

    /**
     * VerificationNoMatchPolicy is the feature flag for "trusted-resources-verification-no-match-policy" VerificationNoMatchPolicy can be set to "ignore", "warn" and "fail" values. ignore: skip trusted resources verification when no matching verification policies found warn: skip trusted resources verification when no matching verification policies found and log a warning fail: fail the taskrun or pipelines run if no matching verification policies found
     */
    @JsonProperty("verificationNoMatchPolicy")
    public String getVerificationNoMatchPolicy() {
        return verificationNoMatchPolicy;
    }

    /**
     * VerificationNoMatchPolicy is the feature flag for "trusted-resources-verification-no-match-policy" VerificationNoMatchPolicy can be set to "ignore", "warn" and "fail" values. ignore: skip trusted resources verification when no matching verification policies found warn: skip trusted resources verification when no matching verification policies found and log a warning fail: fail the taskrun or pipelines run if no matching verification policies found
     */
    @JsonProperty("verificationNoMatchPolicy")
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
