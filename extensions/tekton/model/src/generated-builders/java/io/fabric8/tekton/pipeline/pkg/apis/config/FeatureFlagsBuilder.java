package io.fabric8.tekton.pipeline.pkg.apis.config;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FeatureFlagsBuilder extends FeatureFlagsFluent<FeatureFlagsBuilder> implements VisitableBuilder<FeatureFlags,FeatureFlagsBuilder>{

  FeatureFlagsFluent<?> fluent;

  public FeatureFlagsBuilder() {
    this(new FeatureFlags());
  }
  
  public FeatureFlagsBuilder(FeatureFlagsFluent<?> fluent) {
    this(fluent, new FeatureFlags());
  }
  
  public FeatureFlagsBuilder(FeatureFlags instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FeatureFlagsBuilder(FeatureFlagsFluent<?> fluent,FeatureFlags instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FeatureFlags build() {
    FeatureFlags buildable = new FeatureFlags(fluent.getAwaitSidecarReadiness(), fluent.getCoschedule(), fluent.getDisableCredsInit(), fluent.getDisableInlineSpec(), fluent.getEnableAPIFields(), fluent.getEnableArtifacts(), fluent.getEnableCELInWhenExpression(), fluent.getEnableConciseResolverSyntax(), fluent.getEnableKeepPodOnCancel(), fluent.getEnableKubernetesSidecar(), fluent.getEnableParamEnum(), fluent.getEnableProvenanceInStatus(), fluent.getEnableStepActions(), fluent.getEnableTektonOCIBundles(), fluent.getEnableWaitExponentialBackoff(), fluent.getEnforceNonfalsifiability(), fluent.getMaxResultSize(), fluent.getRequireGitSSHSecretKnownHosts(), fluent.getResultExtractionMethod(), fluent.getRunningInEnvWithInjectedSidecars(), fluent.getSendCloudEventsForRuns(), fluent.getSetSecurityContext(), fluent.getSetSecurityContextReadOnlyRootFilesystem(), fluent.getVerificationNoMatchPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}