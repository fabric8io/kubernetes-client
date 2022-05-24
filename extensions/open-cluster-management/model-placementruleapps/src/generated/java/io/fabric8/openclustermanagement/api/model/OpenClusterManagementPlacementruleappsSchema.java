
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
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.ArgoServerSpec;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsCluster;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterList;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterSpec;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.ClusterConditionFilter;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.GenericClusterReference;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementDecision;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRule;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleSpec;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleStatus;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.ResourceHint;
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
    "github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_ArgoServerSpec",
    "github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsCluster",
    "github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterList",
    "github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterSpec",
    "github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterStatus",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ClusterConditionFilter",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_GenericClusterReference",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRule",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleList",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleSpec",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleStatus",
    "github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ResourceHint"
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
public class OpenClusterManagementPlacementruleappsSchema {

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_ArgoServerSpec")
    private ArgoServerSpec githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec;
    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsCluster")
    private GitOpsCluster githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster;
    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterList")
    private GitOpsClusterList githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList;
    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterSpec")
    private GitOpsClusterSpec githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec;
    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterStatus")
    private GitOpsClusterStatus githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ClusterConditionFilter")
    private ClusterConditionFilter githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_GenericClusterReference")
    private GenericClusterReference githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision")
    private PlacementDecision githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRule")
    private PlacementRule githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleList")
    private PlacementRuleList githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleSpec")
    private PlacementRuleSpec githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleStatus")
    private PlacementRuleStatus githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus;
    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ResourceHint")
    private ResourceHint githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementPlacementruleappsSchema() {
    }

    /**
     * 
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint
     * @param githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec
     * @param githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList
     * @param githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList
     * @param githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus
     * @param githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule
     * @param githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference
     */
    public OpenClusterManagementPlacementruleappsSchema(ArgoServerSpec githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec, GitOpsCluster githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster, GitOpsClusterList githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList, GitOpsClusterSpec githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec, GitOpsClusterStatus githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus, ClusterConditionFilter githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter, GenericClusterReference githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference, PlacementDecision githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision, PlacementRule githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule, PlacementRuleList githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList, PlacementRuleSpec githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec, PlacementRuleStatus githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus, ResourceHint githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint) {
        super();
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec;
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster;
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList;
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec;
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus;
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_ArgoServerSpec")
    public ArgoServerSpec getGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec() {
        return githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_ArgoServerSpec")
    public void setGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec(ArgoServerSpec githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec) {
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1ArgoServerSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsCluster")
    public GitOpsCluster getGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster() {
        return githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsCluster")
    public void setGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster(GitOpsCluster githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster) {
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsCluster;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterList")
    public GitOpsClusterList getGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList() {
        return githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterList")
    public void setGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList(GitOpsClusterList githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList) {
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterList;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterSpec")
    public GitOpsClusterSpec getGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec() {
        return githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterSpec")
    public void setGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec(GitOpsClusterSpec githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec) {
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterStatus")
    public GitOpsClusterStatus getGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus() {
        return githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-integrations_pkg_apis_apps_v1beta1_GitOpsClusterStatus")
    public void setGithubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus(GitOpsClusterStatus githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus) {
        this.githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus = githubComOpenClusterManagementMulticloudIntegrationsPkgApisAppsV1beta1GitOpsClusterStatus;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ClusterConditionFilter")
    public ClusterConditionFilter getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ClusterConditionFilter")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter(ClusterConditionFilter githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ClusterConditionFilter;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_GenericClusterReference")
    public GenericClusterReference getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_GenericClusterReference")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference(GenericClusterReference githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1GenericClusterReference;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision")
    public PlacementDecision getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementDecision")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision(PlacementDecision githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementDecision;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRule")
    public PlacementRule getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRule")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule(PlacementRule githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRule;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleList")
    public PlacementRuleList getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleList")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList(PlacementRuleList githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleList;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleSpec")
    public PlacementRuleSpec getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleSpec")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec(PlacementRuleSpec githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleSpec;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleStatus")
    public PlacementRuleStatus getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_PlacementRuleStatus")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus(PlacementRuleStatus githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1PlacementRuleStatus;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ResourceHint")
    public ResourceHint getGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint() {
        return githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint;
    }

    @JsonProperty("github_com_open-cluster-management_multicloud-operators-placementrule_pkg_apis_apps_v1_ResourceHint")
    public void setGithubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint(ResourceHint githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint) {
        this.githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint = githubComOpenClusterManagementMulticloudOperatorsPlacementrulePkgApisAppsV1ResourceHint;
    }

}
