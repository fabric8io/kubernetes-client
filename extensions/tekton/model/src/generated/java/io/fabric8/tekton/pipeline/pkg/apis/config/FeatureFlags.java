
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
    "enableTektonOCIBundles",
    "enableWaitExponentialBackoff",
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
    @JsonProperty("enableTektonOCIBundles")
    private Boolean enableTektonOCIBundles;
    @JsonProperty("enableWaitExponentialBackoff")
    private Boolean enableWaitExponentialBackoff;
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

    public FeatureFlags(Boolean awaitSidecarReadiness, String coschedule, Boolean disableCredsInit, String disableInlineSpec, String enableAPIFields, Boolean enableArtifacts, Boolean enableCELInWhenExpression, Boolean enableConciseResolverSyntax, Boolean enableKeepPodOnCancel, Boolean enableKubernetesSidecar, Boolean enableParamEnum, Boolean enableProvenanceInStatus, Boolean enableStepActions, Boolean enableTektonOCIBundles, Boolean enableWaitExponentialBackoff, String enforceNonfalsifiability, Integer maxResultSize, Boolean requireGitSSHSecretKnownHosts, String resultExtractionMethod, Boolean runningInEnvWithInjectedSidecars, Boolean sendCloudEventsForRuns, Boolean setSecurityContext, Boolean setSecurityContextReadOnlyRootFilesystem, String verificationNoMatchPolicy) {
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
        this.enableTektonOCIBundles = enableTektonOCIBundles;
        this.enableWaitExponentialBackoff = enableWaitExponentialBackoff;
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
     * Deprecated: see DefaultSendCloudEventsForRuns
     */
    @JsonProperty("awaitSidecarReadiness")
    public Boolean getAwaitSidecarReadiness() {
        return awaitSidecarReadiness;
    }

    /**
     * Deprecated: see DefaultSendCloudEventsForRuns
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
     * DeprecatedEnableTektonOCIBundles is maintained for backward compatibility to allow deletion of PipelineRuns created before v0.62.x. This field is not used and can be removed in a future release once we're confident old PipelineRuns have been cleaned up. See issue #8359 for context.
     */
    @JsonProperty("enableTektonOCIBundles")
    public Boolean getEnableTektonOCIBundles() {
        return enableTektonOCIBundles;
    }

    /**
     * DeprecatedEnableTektonOCIBundles is maintained for backward compatibility to allow deletion of PipelineRuns created before v0.62.x. This field is not used and can be removed in a future release once we're confident old PipelineRuns have been cleaned up. See issue #8359 for context.
     */
    @JsonProperty("enableTektonOCIBundles")
    public void setEnableTektonOCIBundles(Boolean enableTektonOCIBundles) {
        this.enableTektonOCIBundles = enableTektonOCIBundles;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableWaitExponentialBackoff")
    public Boolean getEnableWaitExponentialBackoff() {
        return enableWaitExponentialBackoff;
    }

    /**
     * FeatureFlags holds the features configurations
     */
    @JsonProperty("enableWaitExponentialBackoff")
    public void setEnableWaitExponentialBackoff(Boolean enableWaitExponentialBackoff) {
        this.enableWaitExponentialBackoff = enableWaitExponentialBackoff;
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FeatureFlags)) {
            return false;
        }
        FeatureFlags other = (FeatureFlags) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$awaitSidecarReadiness = this.getAwaitSidecarReadiness();
        Object other$awaitSidecarReadiness = other.getAwaitSidecarReadiness();
        if (this$awaitSidecarReadiness == null ? other$awaitSidecarReadiness != null : !this$awaitSidecarReadiness.equals(other$awaitSidecarReadiness)) {
            return false;
        }
        Object this$coschedule = this.getCoschedule();
        Object other$coschedule = other.getCoschedule();
        if (this$coschedule == null ? other$coschedule != null : !this$coschedule.equals(other$coschedule)) {
            return false;
        }
        Object this$disableCredsInit = this.getDisableCredsInit();
        Object other$disableCredsInit = other.getDisableCredsInit();
        if (this$disableCredsInit == null ? other$disableCredsInit != null : !this$disableCredsInit.equals(other$disableCredsInit)) {
            return false;
        }
        Object this$disableInlineSpec = this.getDisableInlineSpec();
        Object other$disableInlineSpec = other.getDisableInlineSpec();
        if (this$disableInlineSpec == null ? other$disableInlineSpec != null : !this$disableInlineSpec.equals(other$disableInlineSpec)) {
            return false;
        }
        Object this$enableAPIFields = this.getEnableAPIFields();
        Object other$enableAPIFields = other.getEnableAPIFields();
        if (this$enableAPIFields == null ? other$enableAPIFields != null : !this$enableAPIFields.equals(other$enableAPIFields)) {
            return false;
        }
        Object this$enableArtifacts = this.getEnableArtifacts();
        Object other$enableArtifacts = other.getEnableArtifacts();
        if (this$enableArtifacts == null ? other$enableArtifacts != null : !this$enableArtifacts.equals(other$enableArtifacts)) {
            return false;
        }
        Object this$enableCELInWhenExpression = this.getEnableCELInWhenExpression();
        Object other$enableCELInWhenExpression = other.getEnableCELInWhenExpression();
        if (this$enableCELInWhenExpression == null ? other$enableCELInWhenExpression != null : !this$enableCELInWhenExpression.equals(other$enableCELInWhenExpression)) {
            return false;
        }
        Object this$enableConciseResolverSyntax = this.getEnableConciseResolverSyntax();
        Object other$enableConciseResolverSyntax = other.getEnableConciseResolverSyntax();
        if (this$enableConciseResolverSyntax == null ? other$enableConciseResolverSyntax != null : !this$enableConciseResolverSyntax.equals(other$enableConciseResolverSyntax)) {
            return false;
        }
        Object this$enableKeepPodOnCancel = this.getEnableKeepPodOnCancel();
        Object other$enableKeepPodOnCancel = other.getEnableKeepPodOnCancel();
        if (this$enableKeepPodOnCancel == null ? other$enableKeepPodOnCancel != null : !this$enableKeepPodOnCancel.equals(other$enableKeepPodOnCancel)) {
            return false;
        }
        Object this$enableKubernetesSidecar = this.getEnableKubernetesSidecar();
        Object other$enableKubernetesSidecar = other.getEnableKubernetesSidecar();
        if (this$enableKubernetesSidecar == null ? other$enableKubernetesSidecar != null : !this$enableKubernetesSidecar.equals(other$enableKubernetesSidecar)) {
            return false;
        }
        Object this$enableParamEnum = this.getEnableParamEnum();
        Object other$enableParamEnum = other.getEnableParamEnum();
        if (this$enableParamEnum == null ? other$enableParamEnum != null : !this$enableParamEnum.equals(other$enableParamEnum)) {
            return false;
        }
        Object this$enableProvenanceInStatus = this.getEnableProvenanceInStatus();
        Object other$enableProvenanceInStatus = other.getEnableProvenanceInStatus();
        if (this$enableProvenanceInStatus == null ? other$enableProvenanceInStatus != null : !this$enableProvenanceInStatus.equals(other$enableProvenanceInStatus)) {
            return false;
        }
        Object this$enableStepActions = this.getEnableStepActions();
        Object other$enableStepActions = other.getEnableStepActions();
        if (this$enableStepActions == null ? other$enableStepActions != null : !this$enableStepActions.equals(other$enableStepActions)) {
            return false;
        }
        Object this$enableTektonOCIBundles = this.getEnableTektonOCIBundles();
        Object other$enableTektonOCIBundles = other.getEnableTektonOCIBundles();
        if (this$enableTektonOCIBundles == null ? other$enableTektonOCIBundles != null : !this$enableTektonOCIBundles.equals(other$enableTektonOCIBundles)) {
            return false;
        }
        Object this$enableWaitExponentialBackoff = this.getEnableWaitExponentialBackoff();
        Object other$enableWaitExponentialBackoff = other.getEnableWaitExponentialBackoff();
        if (this$enableWaitExponentialBackoff == null ? other$enableWaitExponentialBackoff != null : !this$enableWaitExponentialBackoff.equals(other$enableWaitExponentialBackoff)) {
            return false;
        }
        Object this$enforceNonfalsifiability = this.getEnforceNonfalsifiability();
        Object other$enforceNonfalsifiability = other.getEnforceNonfalsifiability();
        if (this$enforceNonfalsifiability == null ? other$enforceNonfalsifiability != null : !this$enforceNonfalsifiability.equals(other$enforceNonfalsifiability)) {
            return false;
        }
        Object this$maxResultSize = this.getMaxResultSize();
        Object other$maxResultSize = other.getMaxResultSize();
        if (this$maxResultSize == null ? other$maxResultSize != null : !this$maxResultSize.equals(other$maxResultSize)) {
            return false;
        }
        Object this$requireGitSSHSecretKnownHosts = this.getRequireGitSSHSecretKnownHosts();
        Object other$requireGitSSHSecretKnownHosts = other.getRequireGitSSHSecretKnownHosts();
        if (this$requireGitSSHSecretKnownHosts == null ? other$requireGitSSHSecretKnownHosts != null : !this$requireGitSSHSecretKnownHosts.equals(other$requireGitSSHSecretKnownHosts)) {
            return false;
        }
        Object this$resultExtractionMethod = this.getResultExtractionMethod();
        Object other$resultExtractionMethod = other.getResultExtractionMethod();
        if (this$resultExtractionMethod == null ? other$resultExtractionMethod != null : !this$resultExtractionMethod.equals(other$resultExtractionMethod)) {
            return false;
        }
        Object this$runningInEnvWithInjectedSidecars = this.getRunningInEnvWithInjectedSidecars();
        Object other$runningInEnvWithInjectedSidecars = other.getRunningInEnvWithInjectedSidecars();
        if (this$runningInEnvWithInjectedSidecars == null ? other$runningInEnvWithInjectedSidecars != null : !this$runningInEnvWithInjectedSidecars.equals(other$runningInEnvWithInjectedSidecars)) {
            return false;
        }
        Object this$sendCloudEventsForRuns = this.getSendCloudEventsForRuns();
        Object other$sendCloudEventsForRuns = other.getSendCloudEventsForRuns();
        if (this$sendCloudEventsForRuns == null ? other$sendCloudEventsForRuns != null : !this$sendCloudEventsForRuns.equals(other$sendCloudEventsForRuns)) {
            return false;
        }
        Object this$setSecurityContext = this.getSetSecurityContext();
        Object other$setSecurityContext = other.getSetSecurityContext();
        if (this$setSecurityContext == null ? other$setSecurityContext != null : !this$setSecurityContext.equals(other$setSecurityContext)) {
            return false;
        }
        Object this$setSecurityContextReadOnlyRootFilesystem = this.getSetSecurityContextReadOnlyRootFilesystem();
        Object other$setSecurityContextReadOnlyRootFilesystem = other.getSetSecurityContextReadOnlyRootFilesystem();
        if (this$setSecurityContextReadOnlyRootFilesystem == null ? other$setSecurityContextReadOnlyRootFilesystem != null : !this$setSecurityContextReadOnlyRootFilesystem.equals(other$setSecurityContextReadOnlyRootFilesystem)) {
            return false;
        }
        Object this$verificationNoMatchPolicy = this.getVerificationNoMatchPolicy();
        Object other$verificationNoMatchPolicy = other.getVerificationNoMatchPolicy();
        if (this$verificationNoMatchPolicy == null ? other$verificationNoMatchPolicy != null : !this$verificationNoMatchPolicy.equals(other$verificationNoMatchPolicy)) {
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
        return other instanceof FeatureFlags;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $awaitSidecarReadiness = this.getAwaitSidecarReadiness();
        result = result * prime + ($awaitSidecarReadiness == null ? 43 : $awaitSidecarReadiness.hashCode());
        Object $coschedule = this.getCoschedule();
        result = result * prime + ($coschedule == null ? 43 : $coschedule.hashCode());
        Object $disableCredsInit = this.getDisableCredsInit();
        result = result * prime + ($disableCredsInit == null ? 43 : $disableCredsInit.hashCode());
        Object $disableInlineSpec = this.getDisableInlineSpec();
        result = result * prime + ($disableInlineSpec == null ? 43 : $disableInlineSpec.hashCode());
        Object $enableAPIFields = this.getEnableAPIFields();
        result = result * prime + ($enableAPIFields == null ? 43 : $enableAPIFields.hashCode());
        Object $enableArtifacts = this.getEnableArtifacts();
        result = result * prime + ($enableArtifacts == null ? 43 : $enableArtifacts.hashCode());
        Object $enableCELInWhenExpression = this.getEnableCELInWhenExpression();
        result = result * prime + ($enableCELInWhenExpression == null ? 43 : $enableCELInWhenExpression.hashCode());
        Object $enableConciseResolverSyntax = this.getEnableConciseResolverSyntax();
        result = result * prime + ($enableConciseResolverSyntax == null ? 43 : $enableConciseResolverSyntax.hashCode());
        Object $enableKeepPodOnCancel = this.getEnableKeepPodOnCancel();
        result = result * prime + ($enableKeepPodOnCancel == null ? 43 : $enableKeepPodOnCancel.hashCode());
        Object $enableKubernetesSidecar = this.getEnableKubernetesSidecar();
        result = result * prime + ($enableKubernetesSidecar == null ? 43 : $enableKubernetesSidecar.hashCode());
        Object $enableParamEnum = this.getEnableParamEnum();
        result = result * prime + ($enableParamEnum == null ? 43 : $enableParamEnum.hashCode());
        Object $enableProvenanceInStatus = this.getEnableProvenanceInStatus();
        result = result * prime + ($enableProvenanceInStatus == null ? 43 : $enableProvenanceInStatus.hashCode());
        Object $enableStepActions = this.getEnableStepActions();
        result = result * prime + ($enableStepActions == null ? 43 : $enableStepActions.hashCode());
        Object $enableTektonOCIBundles = this.getEnableTektonOCIBundles();
        result = result * prime + ($enableTektonOCIBundles == null ? 43 : $enableTektonOCIBundles.hashCode());
        Object $enableWaitExponentialBackoff = this.getEnableWaitExponentialBackoff();
        result = result * prime + ($enableWaitExponentialBackoff == null ? 43 : $enableWaitExponentialBackoff.hashCode());
        Object $enforceNonfalsifiability = this.getEnforceNonfalsifiability();
        result = result * prime + ($enforceNonfalsifiability == null ? 43 : $enforceNonfalsifiability.hashCode());
        Object $maxResultSize = this.getMaxResultSize();
        result = result * prime + ($maxResultSize == null ? 43 : $maxResultSize.hashCode());
        Object $requireGitSSHSecretKnownHosts = this.getRequireGitSSHSecretKnownHosts();
        result = result * prime + ($requireGitSSHSecretKnownHosts == null ? 43 : $requireGitSSHSecretKnownHosts.hashCode());
        Object $resultExtractionMethod = this.getResultExtractionMethod();
        result = result * prime + ($resultExtractionMethod == null ? 43 : $resultExtractionMethod.hashCode());
        Object $runningInEnvWithInjectedSidecars = this.getRunningInEnvWithInjectedSidecars();
        result = result * prime + ($runningInEnvWithInjectedSidecars == null ? 43 : $runningInEnvWithInjectedSidecars.hashCode());
        Object $sendCloudEventsForRuns = this.getSendCloudEventsForRuns();
        result = result * prime + ($sendCloudEventsForRuns == null ? 43 : $sendCloudEventsForRuns.hashCode());
        Object $setSecurityContext = this.getSetSecurityContext();
        result = result * prime + ($setSecurityContext == null ? 43 : $setSecurityContext.hashCode());
        Object $setSecurityContextReadOnlyRootFilesystem = this.getSetSecurityContextReadOnlyRootFilesystem();
        result = result * prime + ($setSecurityContextReadOnlyRootFilesystem == null ? 43 : $setSecurityContextReadOnlyRootFilesystem.hashCode());
        Object $verificationNoMatchPolicy = this.getVerificationNoMatchPolicy();
        result = result * prime + ($verificationNoMatchPolicy == null ? 43 : $verificationNoMatchPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FeatureFlags(" + "awaitSidecarReadiness=" + this.getAwaitSidecarReadiness() + ", coschedule=" + this.getCoschedule() + ", disableCredsInit=" + this.getDisableCredsInit() + ", disableInlineSpec=" + this.getDisableInlineSpec() + ", enableAPIFields=" + this.getEnableAPIFields() + ", enableArtifacts=" + this.getEnableArtifacts() + ", enableCELInWhenExpression=" + this.getEnableCELInWhenExpression() + ", enableConciseResolverSyntax=" + this.getEnableConciseResolverSyntax() + ", enableKeepPodOnCancel=" + this.getEnableKeepPodOnCancel() + ", enableKubernetesSidecar=" + this.getEnableKubernetesSidecar() + ", enableParamEnum=" + this.getEnableParamEnum() + ", enableProvenanceInStatus=" + this.getEnableProvenanceInStatus() + ", enableStepActions=" + this.getEnableStepActions() + ", enableTektonOCIBundles=" + this.getEnableTektonOCIBundles() + ", enableWaitExponentialBackoff=" + this.getEnableWaitExponentialBackoff() + ", enforceNonfalsifiability=" + this.getEnforceNonfalsifiability() + ", maxResultSize=" + this.getMaxResultSize() + ", requireGitSSHSecretKnownHosts=" + this.getRequireGitSSHSecretKnownHosts() + ", resultExtractionMethod=" + this.getResultExtractionMethod() + ", runningInEnvWithInjectedSidecars=" + this.getRunningInEnvWithInjectedSidecars() + ", sendCloudEventsForRuns=" + this.getSendCloudEventsForRuns() + ", setSecurityContext=" + this.getSetSecurityContext() + ", setSecurityContextReadOnlyRootFilesystem=" + this.getSetSecurityContextReadOnlyRootFilesystem() + ", verificationNoMatchPolicy=" + this.getVerificationNoMatchPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
