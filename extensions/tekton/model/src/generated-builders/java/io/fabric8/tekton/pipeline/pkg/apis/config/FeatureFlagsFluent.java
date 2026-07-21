package io.fabric8.tekton.pipeline.pkg.apis.config;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class FeatureFlagsFluent<A extends io.fabric8.tekton.pipeline.pkg.apis.config.FeatureFlagsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean awaitSidecarReadiness;
  private String coschedule;
  private Boolean disableCredsInit;
  private String disableInlineSpec;
  private String enableAPIFields;
  private Boolean enableArtifacts;
  private Boolean enableCELInWhenExpression;
  private Boolean enableConciseResolverSyntax;
  private Boolean enableKeepPodOnCancel;
  private Boolean enableKubernetesSidecar;
  private Boolean enableParamEnum;
  private Boolean enableProvenanceInStatus;
  private Boolean enableStepActions;
  private Boolean enableTektonOCIBundles;
  private Boolean enableWaitExponentialBackoff;
  private String enforceNonfalsifiability;
  private Integer maxResultSize;
  private Boolean requireGitSSHSecretKnownHosts;
  private String resultExtractionMethod;
  private Boolean runningInEnvWithInjectedSidecars;
  private Boolean sendCloudEventsForRuns;
  private Boolean setSecurityContext;
  private Boolean setSecurityContextReadOnlyRootFilesystem;
  private String verificationNoMatchPolicy;

  public FeatureFlagsFluent() {
  }
  
  public FeatureFlagsFluent(FeatureFlags instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(FeatureFlags instance) {
    instance = instance != null ? instance : new FeatureFlags();
    if (instance != null) {
        this.withAwaitSidecarReadiness(instance.getAwaitSidecarReadiness());
        this.withCoschedule(instance.getCoschedule());
        this.withDisableCredsInit(instance.getDisableCredsInit());
        this.withDisableInlineSpec(instance.getDisableInlineSpec());
        this.withEnableAPIFields(instance.getEnableAPIFields());
        this.withEnableArtifacts(instance.getEnableArtifacts());
        this.withEnableCELInWhenExpression(instance.getEnableCELInWhenExpression());
        this.withEnableConciseResolverSyntax(instance.getEnableConciseResolverSyntax());
        this.withEnableKeepPodOnCancel(instance.getEnableKeepPodOnCancel());
        this.withEnableKubernetesSidecar(instance.getEnableKubernetesSidecar());
        this.withEnableParamEnum(instance.getEnableParamEnum());
        this.withEnableProvenanceInStatus(instance.getEnableProvenanceInStatus());
        this.withEnableStepActions(instance.getEnableStepActions());
        this.withEnableTektonOCIBundles(instance.getEnableTektonOCIBundles());
        this.withEnableWaitExponentialBackoff(instance.getEnableWaitExponentialBackoff());
        this.withEnforceNonfalsifiability(instance.getEnforceNonfalsifiability());
        this.withMaxResultSize(instance.getMaxResultSize());
        this.withRequireGitSSHSecretKnownHosts(instance.getRequireGitSSHSecretKnownHosts());
        this.withResultExtractionMethod(instance.getResultExtractionMethod());
        this.withRunningInEnvWithInjectedSidecars(instance.getRunningInEnvWithInjectedSidecars());
        this.withSendCloudEventsForRuns(instance.getSendCloudEventsForRuns());
        this.withSetSecurityContext(instance.getSetSecurityContext());
        this.withSetSecurityContextReadOnlyRootFilesystem(instance.getSetSecurityContextReadOnlyRootFilesystem());
        this.withVerificationNoMatchPolicy(instance.getVerificationNoMatchPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    FeatureFlagsFluent that = (FeatureFlagsFluent) o;
    if (!(Objects.equals(awaitSidecarReadiness, that.awaitSidecarReadiness))) {
      return false;
    }
    if (!(Objects.equals(coschedule, that.coschedule))) {
      return false;
    }
    if (!(Objects.equals(disableCredsInit, that.disableCredsInit))) {
      return false;
    }
    if (!(Objects.equals(disableInlineSpec, that.disableInlineSpec))) {
      return false;
    }
    if (!(Objects.equals(enableAPIFields, that.enableAPIFields))) {
      return false;
    }
    if (!(Objects.equals(enableArtifacts, that.enableArtifacts))) {
      return false;
    }
    if (!(Objects.equals(enableCELInWhenExpression, that.enableCELInWhenExpression))) {
      return false;
    }
    if (!(Objects.equals(enableConciseResolverSyntax, that.enableConciseResolverSyntax))) {
      return false;
    }
    if (!(Objects.equals(enableKeepPodOnCancel, that.enableKeepPodOnCancel))) {
      return false;
    }
    if (!(Objects.equals(enableKubernetesSidecar, that.enableKubernetesSidecar))) {
      return false;
    }
    if (!(Objects.equals(enableParamEnum, that.enableParamEnum))) {
      return false;
    }
    if (!(Objects.equals(enableProvenanceInStatus, that.enableProvenanceInStatus))) {
      return false;
    }
    if (!(Objects.equals(enableStepActions, that.enableStepActions))) {
      return false;
    }
    if (!(Objects.equals(enableTektonOCIBundles, that.enableTektonOCIBundles))) {
      return false;
    }
    if (!(Objects.equals(enableWaitExponentialBackoff, that.enableWaitExponentialBackoff))) {
      return false;
    }
    if (!(Objects.equals(enforceNonfalsifiability, that.enforceNonfalsifiability))) {
      return false;
    }
    if (!(Objects.equals(maxResultSize, that.maxResultSize))) {
      return false;
    }
    if (!(Objects.equals(requireGitSSHSecretKnownHosts, that.requireGitSSHSecretKnownHosts))) {
      return false;
    }
    if (!(Objects.equals(resultExtractionMethod, that.resultExtractionMethod))) {
      return false;
    }
    if (!(Objects.equals(runningInEnvWithInjectedSidecars, that.runningInEnvWithInjectedSidecars))) {
      return false;
    }
    if (!(Objects.equals(sendCloudEventsForRuns, that.sendCloudEventsForRuns))) {
      return false;
    }
    if (!(Objects.equals(setSecurityContext, that.setSecurityContext))) {
      return false;
    }
    if (!(Objects.equals(setSecurityContextReadOnlyRootFilesystem, that.setSecurityContextReadOnlyRootFilesystem))) {
      return false;
    }
    if (!(Objects.equals(verificationNoMatchPolicy, that.verificationNoMatchPolicy))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Boolean getAwaitSidecarReadiness() {
    return this.awaitSidecarReadiness;
  }
  
  public String getCoschedule() {
    return this.coschedule;
  }
  
  public Boolean getDisableCredsInit() {
    return this.disableCredsInit;
  }
  
  public String getDisableInlineSpec() {
    return this.disableInlineSpec;
  }
  
  public String getEnableAPIFields() {
    return this.enableAPIFields;
  }
  
  public Boolean getEnableArtifacts() {
    return this.enableArtifacts;
  }
  
  public Boolean getEnableCELInWhenExpression() {
    return this.enableCELInWhenExpression;
  }
  
  public Boolean getEnableConciseResolverSyntax() {
    return this.enableConciseResolverSyntax;
  }
  
  public Boolean getEnableKeepPodOnCancel() {
    return this.enableKeepPodOnCancel;
  }
  
  public Boolean getEnableKubernetesSidecar() {
    return this.enableKubernetesSidecar;
  }
  
  public Boolean getEnableParamEnum() {
    return this.enableParamEnum;
  }
  
  public Boolean getEnableProvenanceInStatus() {
    return this.enableProvenanceInStatus;
  }
  
  public Boolean getEnableStepActions() {
    return this.enableStepActions;
  }
  
  public Boolean getEnableTektonOCIBundles() {
    return this.enableTektonOCIBundles;
  }
  
  public Boolean getEnableWaitExponentialBackoff() {
    return this.enableWaitExponentialBackoff;
  }
  
  public String getEnforceNonfalsifiability() {
    return this.enforceNonfalsifiability;
  }
  
  public Integer getMaxResultSize() {
    return this.maxResultSize;
  }
  
  public Boolean getRequireGitSSHSecretKnownHosts() {
    return this.requireGitSSHSecretKnownHosts;
  }
  
  public String getResultExtractionMethod() {
    return this.resultExtractionMethod;
  }
  
  public Boolean getRunningInEnvWithInjectedSidecars() {
    return this.runningInEnvWithInjectedSidecars;
  }
  
  public Boolean getSendCloudEventsForRuns() {
    return this.sendCloudEventsForRuns;
  }
  
  public Boolean getSetSecurityContext() {
    return this.setSecurityContext;
  }
  
  public Boolean getSetSecurityContextReadOnlyRootFilesystem() {
    return this.setSecurityContextReadOnlyRootFilesystem;
  }
  
  public String getVerificationNoMatchPolicy() {
    return this.verificationNoMatchPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAwaitSidecarReadiness() {
    return this.awaitSidecarReadiness != null;
  }
  
  public boolean hasCoschedule() {
    return this.coschedule != null;
  }
  
  public boolean hasDisableCredsInit() {
    return this.disableCredsInit != null;
  }
  
  public boolean hasDisableInlineSpec() {
    return this.disableInlineSpec != null;
  }
  
  public boolean hasEnableAPIFields() {
    return this.enableAPIFields != null;
  }
  
  public boolean hasEnableArtifacts() {
    return this.enableArtifacts != null;
  }
  
  public boolean hasEnableCELInWhenExpression() {
    return this.enableCELInWhenExpression != null;
  }
  
  public boolean hasEnableConciseResolverSyntax() {
    return this.enableConciseResolverSyntax != null;
  }
  
  public boolean hasEnableKeepPodOnCancel() {
    return this.enableKeepPodOnCancel != null;
  }
  
  public boolean hasEnableKubernetesSidecar() {
    return this.enableKubernetesSidecar != null;
  }
  
  public boolean hasEnableParamEnum() {
    return this.enableParamEnum != null;
  }
  
  public boolean hasEnableProvenanceInStatus() {
    return this.enableProvenanceInStatus != null;
  }
  
  public boolean hasEnableStepActions() {
    return this.enableStepActions != null;
  }
  
  public boolean hasEnableTektonOCIBundles() {
    return this.enableTektonOCIBundles != null;
  }
  
  public boolean hasEnableWaitExponentialBackoff() {
    return this.enableWaitExponentialBackoff != null;
  }
  
  public boolean hasEnforceNonfalsifiability() {
    return this.enforceNonfalsifiability != null;
  }
  
  public boolean hasMaxResultSize() {
    return this.maxResultSize != null;
  }
  
  public boolean hasRequireGitSSHSecretKnownHosts() {
    return this.requireGitSSHSecretKnownHosts != null;
  }
  
  public boolean hasResultExtractionMethod() {
    return this.resultExtractionMethod != null;
  }
  
  public boolean hasRunningInEnvWithInjectedSidecars() {
    return this.runningInEnvWithInjectedSidecars != null;
  }
  
  public boolean hasSendCloudEventsForRuns() {
    return this.sendCloudEventsForRuns != null;
  }
  
  public boolean hasSetSecurityContext() {
    return this.setSecurityContext != null;
  }
  
  public boolean hasSetSecurityContextReadOnlyRootFilesystem() {
    return this.setSecurityContextReadOnlyRootFilesystem != null;
  }
  
  public boolean hasVerificationNoMatchPolicy() {
    return this.verificationNoMatchPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(awaitSidecarReadiness, coschedule, disableCredsInit, disableInlineSpec, enableAPIFields, enableArtifacts, enableCELInWhenExpression, enableConciseResolverSyntax, enableKeepPodOnCancel, enableKubernetesSidecar, enableParamEnum, enableProvenanceInStatus, enableStepActions, enableTektonOCIBundles, enableWaitExponentialBackoff, enforceNonfalsifiability, maxResultSize, requireGitSSHSecretKnownHosts, resultExtractionMethod, runningInEnvWithInjectedSidecars, sendCloudEventsForRuns, setSecurityContext, setSecurityContextReadOnlyRootFilesystem, verificationNoMatchPolicy, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(awaitSidecarReadiness == null)) {
        sb.append("awaitSidecarReadiness:");
        sb.append(awaitSidecarReadiness);
        sb.append(",");
    }
    if (!(coschedule == null)) {
        sb.append("coschedule:");
        sb.append(coschedule);
        sb.append(",");
    }
    if (!(disableCredsInit == null)) {
        sb.append("disableCredsInit:");
        sb.append(disableCredsInit);
        sb.append(",");
    }
    if (!(disableInlineSpec == null)) {
        sb.append("disableInlineSpec:");
        sb.append(disableInlineSpec);
        sb.append(",");
    }
    if (!(enableAPIFields == null)) {
        sb.append("enableAPIFields:");
        sb.append(enableAPIFields);
        sb.append(",");
    }
    if (!(enableArtifacts == null)) {
        sb.append("enableArtifacts:");
        sb.append(enableArtifacts);
        sb.append(",");
    }
    if (!(enableCELInWhenExpression == null)) {
        sb.append("enableCELInWhenExpression:");
        sb.append(enableCELInWhenExpression);
        sb.append(",");
    }
    if (!(enableConciseResolverSyntax == null)) {
        sb.append("enableConciseResolverSyntax:");
        sb.append(enableConciseResolverSyntax);
        sb.append(",");
    }
    if (!(enableKeepPodOnCancel == null)) {
        sb.append("enableKeepPodOnCancel:");
        sb.append(enableKeepPodOnCancel);
        sb.append(",");
    }
    if (!(enableKubernetesSidecar == null)) {
        sb.append("enableKubernetesSidecar:");
        sb.append(enableKubernetesSidecar);
        sb.append(",");
    }
    if (!(enableParamEnum == null)) {
        sb.append("enableParamEnum:");
        sb.append(enableParamEnum);
        sb.append(",");
    }
    if (!(enableProvenanceInStatus == null)) {
        sb.append("enableProvenanceInStatus:");
        sb.append(enableProvenanceInStatus);
        sb.append(",");
    }
    if (!(enableStepActions == null)) {
        sb.append("enableStepActions:");
        sb.append(enableStepActions);
        sb.append(",");
    }
    if (!(enableTektonOCIBundles == null)) {
        sb.append("enableTektonOCIBundles:");
        sb.append(enableTektonOCIBundles);
        sb.append(",");
    }
    if (!(enableWaitExponentialBackoff == null)) {
        sb.append("enableWaitExponentialBackoff:");
        sb.append(enableWaitExponentialBackoff);
        sb.append(",");
    }
    if (!(enforceNonfalsifiability == null)) {
        sb.append("enforceNonfalsifiability:");
        sb.append(enforceNonfalsifiability);
        sb.append(",");
    }
    if (!(maxResultSize == null)) {
        sb.append("maxResultSize:");
        sb.append(maxResultSize);
        sb.append(",");
    }
    if (!(requireGitSSHSecretKnownHosts == null)) {
        sb.append("requireGitSSHSecretKnownHosts:");
        sb.append(requireGitSSHSecretKnownHosts);
        sb.append(",");
    }
    if (!(resultExtractionMethod == null)) {
        sb.append("resultExtractionMethod:");
        sb.append(resultExtractionMethod);
        sb.append(",");
    }
    if (!(runningInEnvWithInjectedSidecars == null)) {
        sb.append("runningInEnvWithInjectedSidecars:");
        sb.append(runningInEnvWithInjectedSidecars);
        sb.append(",");
    }
    if (!(sendCloudEventsForRuns == null)) {
        sb.append("sendCloudEventsForRuns:");
        sb.append(sendCloudEventsForRuns);
        sb.append(",");
    }
    if (!(setSecurityContext == null)) {
        sb.append("setSecurityContext:");
        sb.append(setSecurityContext);
        sb.append(",");
    }
    if (!(setSecurityContextReadOnlyRootFilesystem == null)) {
        sb.append("setSecurityContextReadOnlyRootFilesystem:");
        sb.append(setSecurityContextReadOnlyRootFilesystem);
        sb.append(",");
    }
    if (!(verificationNoMatchPolicy == null)) {
        sb.append("verificationNoMatchPolicy:");
        sb.append(verificationNoMatchPolicy);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAwaitSidecarReadiness() {
    return withAwaitSidecarReadiness(true);
  }
  
  public A withAwaitSidecarReadiness(Boolean awaitSidecarReadiness) {
    this.awaitSidecarReadiness = awaitSidecarReadiness;
    return (A) this;
  }
  
  public A withCoschedule(String coschedule) {
    this.coschedule = coschedule;
    return (A) this;
  }
  
  public A withDisableCredsInit() {
    return withDisableCredsInit(true);
  }
  
  public A withDisableCredsInit(Boolean disableCredsInit) {
    this.disableCredsInit = disableCredsInit;
    return (A) this;
  }
  
  public A withDisableInlineSpec(String disableInlineSpec) {
    this.disableInlineSpec = disableInlineSpec;
    return (A) this;
  }
  
  public A withEnableAPIFields(String enableAPIFields) {
    this.enableAPIFields = enableAPIFields;
    return (A) this;
  }
  
  public A withEnableArtifacts() {
    return withEnableArtifacts(true);
  }
  
  public A withEnableArtifacts(Boolean enableArtifacts) {
    this.enableArtifacts = enableArtifacts;
    return (A) this;
  }
  
  public A withEnableCELInWhenExpression() {
    return withEnableCELInWhenExpression(true);
  }
  
  public A withEnableCELInWhenExpression(Boolean enableCELInWhenExpression) {
    this.enableCELInWhenExpression = enableCELInWhenExpression;
    return (A) this;
  }
  
  public A withEnableConciseResolverSyntax() {
    return withEnableConciseResolverSyntax(true);
  }
  
  public A withEnableConciseResolverSyntax(Boolean enableConciseResolverSyntax) {
    this.enableConciseResolverSyntax = enableConciseResolverSyntax;
    return (A) this;
  }
  
  public A withEnableKeepPodOnCancel() {
    return withEnableKeepPodOnCancel(true);
  }
  
  public A withEnableKeepPodOnCancel(Boolean enableKeepPodOnCancel) {
    this.enableKeepPodOnCancel = enableKeepPodOnCancel;
    return (A) this;
  }
  
  public A withEnableKubernetesSidecar() {
    return withEnableKubernetesSidecar(true);
  }
  
  public A withEnableKubernetesSidecar(Boolean enableKubernetesSidecar) {
    this.enableKubernetesSidecar = enableKubernetesSidecar;
    return (A) this;
  }
  
  public A withEnableParamEnum() {
    return withEnableParamEnum(true);
  }
  
  public A withEnableParamEnum(Boolean enableParamEnum) {
    this.enableParamEnum = enableParamEnum;
    return (A) this;
  }
  
  public A withEnableProvenanceInStatus() {
    return withEnableProvenanceInStatus(true);
  }
  
  public A withEnableProvenanceInStatus(Boolean enableProvenanceInStatus) {
    this.enableProvenanceInStatus = enableProvenanceInStatus;
    return (A) this;
  }
  
  public A withEnableStepActions() {
    return withEnableStepActions(true);
  }
  
  public A withEnableStepActions(Boolean enableStepActions) {
    this.enableStepActions = enableStepActions;
    return (A) this;
  }
  
  public A withEnableTektonOCIBundles() {
    return withEnableTektonOCIBundles(true);
  }
  
  public A withEnableTektonOCIBundles(Boolean enableTektonOCIBundles) {
    this.enableTektonOCIBundles = enableTektonOCIBundles;
    return (A) this;
  }
  
  public A withEnableWaitExponentialBackoff() {
    return withEnableWaitExponentialBackoff(true);
  }
  
  public A withEnableWaitExponentialBackoff(Boolean enableWaitExponentialBackoff) {
    this.enableWaitExponentialBackoff = enableWaitExponentialBackoff;
    return (A) this;
  }
  
  public A withEnforceNonfalsifiability(String enforceNonfalsifiability) {
    this.enforceNonfalsifiability = enforceNonfalsifiability;
    return (A) this;
  }
  
  public A withMaxResultSize(Integer maxResultSize) {
    this.maxResultSize = maxResultSize;
    return (A) this;
  }
  
  public A withRequireGitSSHSecretKnownHosts() {
    return withRequireGitSSHSecretKnownHosts(true);
  }
  
  public A withRequireGitSSHSecretKnownHosts(Boolean requireGitSSHSecretKnownHosts) {
    this.requireGitSSHSecretKnownHosts = requireGitSSHSecretKnownHosts;
    return (A) this;
  }
  
  public A withResultExtractionMethod(String resultExtractionMethod) {
    this.resultExtractionMethod = resultExtractionMethod;
    return (A) this;
  }
  
  public A withRunningInEnvWithInjectedSidecars() {
    return withRunningInEnvWithInjectedSidecars(true);
  }
  
  public A withRunningInEnvWithInjectedSidecars(Boolean runningInEnvWithInjectedSidecars) {
    this.runningInEnvWithInjectedSidecars = runningInEnvWithInjectedSidecars;
    return (A) this;
  }
  
  public A withSendCloudEventsForRuns() {
    return withSendCloudEventsForRuns(true);
  }
  
  public A withSendCloudEventsForRuns(Boolean sendCloudEventsForRuns) {
    this.sendCloudEventsForRuns = sendCloudEventsForRuns;
    return (A) this;
  }
  
  public A withSetSecurityContext() {
    return withSetSecurityContext(true);
  }
  
  public A withSetSecurityContext(Boolean setSecurityContext) {
    this.setSecurityContext = setSecurityContext;
    return (A) this;
  }
  
  public A withSetSecurityContextReadOnlyRootFilesystem() {
    return withSetSecurityContextReadOnlyRootFilesystem(true);
  }
  
  public A withSetSecurityContextReadOnlyRootFilesystem(Boolean setSecurityContextReadOnlyRootFilesystem) {
    this.setSecurityContextReadOnlyRootFilesystem = setSecurityContextReadOnlyRootFilesystem;
    return (A) this;
  }
  
  public A withVerificationNoMatchPolicy(String verificationNoMatchPolicy) {
    this.verificationNoMatchPolicy = verificationNoMatchPolicy;
    return (A) this;
  }
  
}