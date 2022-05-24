
package io.fabric8.openclustermanagement.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.ComplianceHistory;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.CompliancePerClusterStatus;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.DetailsPerTemplate;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.Placement;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBinding;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementBindingStatus;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PlacementSubject;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.Policy;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicySpec;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyStatus;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.PolicyTemplate;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1.Subject;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.AutomationDef;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomation;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationList;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationSpec;
import io.fabric8.openclustermanagement.api.model.governancepolicypropagator.policy.v1beta1.PolicyAutomationStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementDecision;
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
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_ComplianceHistory",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_CompliancePerClusterStatus",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_DetailsPerTemplate",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_Placement",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBinding",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingList",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingStatus",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementSubject",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_Policy",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyList",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicySpec",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyStatus",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyTemplate",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1_Subject",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_AutomationDef",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomation",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationList",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationSpec",
    "github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationStatus",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision"
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
public class OpenClusterManagementPolicySchema {

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_ComplianceHistory")
    private ComplianceHistory githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_CompliancePerClusterStatus")
    private CompliancePerClusterStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_DetailsPerTemplate")
    private DetailsPerTemplate githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Placement")
    private Placement githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBinding")
    private PlacementBinding githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingList")
    private PlacementBindingList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingStatus")
    private PlacementBindingStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementSubject")
    private PlacementSubject githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Policy")
    private Policy githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyList")
    private PolicyList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicySpec")
    private PolicySpec githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyStatus")
    private PolicyStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyTemplate")
    private PolicyTemplate githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Subject")
    private Subject githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_AutomationDef")
    private AutomationDef githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomation")
    private PolicyAutomation githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationList")
    private PolicyAutomationList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationSpec")
    private PolicyAutomationSpec githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec;
    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationStatus")
    private PolicyAutomationStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision")
    private PlacementDecision githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementPolicySchema() {
    }

    /**
     * 
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus
     * @param githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding
     */
    public OpenClusterManagementPolicySchema(ComplianceHistory githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory, CompliancePerClusterStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus, DetailsPerTemplate githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate, Placement githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement, PlacementBinding githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding, PlacementBindingList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList, PlacementBindingStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus, PlacementSubject githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject, Policy githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy, PolicyList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList, PolicySpec githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec, PolicyStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus, PolicyTemplate githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate, Subject githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject, AutomationDef githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef, PolicyAutomation githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation, PolicyAutomationList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList, PolicyAutomationSpec githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec, PolicyAutomationStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus, PlacementDecision githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision) {
        super();
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec;
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_ComplianceHistory")
    public ComplianceHistory getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_ComplianceHistory")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory(ComplianceHistory githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1ComplianceHistory;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_CompliancePerClusterStatus")
    public CompliancePerClusterStatus getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_CompliancePerClusterStatus")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus(CompliancePerClusterStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1CompliancePerClusterStatus;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_DetailsPerTemplate")
    public DetailsPerTemplate getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_DetailsPerTemplate")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate(DetailsPerTemplate githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1DetailsPerTemplate;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Placement")
    public Placement getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Placement")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement(Placement githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Placement;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBinding")
    public PlacementBinding getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBinding")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding(PlacementBinding githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBinding;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingList")
    public PlacementBindingList getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingList")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList(PlacementBindingList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingList;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingStatus")
    public PlacementBindingStatus getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementBindingStatus")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus(PlacementBindingStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementBindingStatus;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementSubject")
    public PlacementSubject getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PlacementSubject")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject(PlacementSubject githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PlacementSubject;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Policy")
    public Policy getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Policy")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy(Policy githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Policy;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyList")
    public PolicyList getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyList")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList(PolicyList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyList;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicySpec")
    public PolicySpec getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicySpec")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec(PolicySpec githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicySpec;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyStatus")
    public PolicyStatus getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyStatus")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus(PolicyStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyStatus;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyTemplate")
    public PolicyTemplate getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_PolicyTemplate")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate(PolicyTemplate githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1PolicyTemplate;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Subject")
    public Subject getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1_Subject")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject(Subject githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1Subject;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_AutomationDef")
    public AutomationDef getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_AutomationDef")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef(AutomationDef githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1AutomationDef;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomation")
    public PolicyAutomation getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomation")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation(PolicyAutomation githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomation;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationList")
    public PolicyAutomationList getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationList")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList(PolicyAutomationList githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationList;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationSpec")
    public PolicyAutomationSpec getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationSpec")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec(PolicyAutomationSpec githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationSpec;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationStatus")
    public PolicyAutomationStatus getGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus() {
        return githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus;
    }

    @JsonProperty("github_com_open-cluster-management_governance-policy-propagator_api_v1beta1_PolicyAutomationStatus")
    public void setGithubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus(PolicyAutomationStatus githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus) {
        this.githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus = githubComOpenClusterManagementGovernancePolicyPropagatorApiV1beta1PolicyAutomationStatus;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision")
    public PlacementDecision getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision(PlacementDecision githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;
    }

}
