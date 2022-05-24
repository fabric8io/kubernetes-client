
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
import io.fabric8.openclustermanagement.api.model.cluster.v1.ClientConfig;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedCluster;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterClaim;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterList;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterSpec;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterStatus;
import io.fabric8.openclustermanagement.api.model.cluster.v1.ManagedClusterVersion;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.ClusterClaimSelector;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.ClusterDecision;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.ClusterPredicate;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.ClusterSelector;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.Placement;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecision;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecisionList;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementDecisionStatus;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementList;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementSpec;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PlacementStatus;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PrioritizerConfig;
import io.fabric8.openclustermanagement.api.model.cluster.v1alpha1.PrioritizerPolicy;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSet;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBinding;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBindingList;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetBindingSpec;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetList;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetSpec;
import io.fabric8.openclustermanagement.api.model.cluster.v1beta1.ManagedClusterSetStatus;
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
    "open-cluster-management_io_api_cluster_v1_ClientConfig",
    "open-cluster-management_io_api_cluster_v1_ManagedCluster",
    "open-cluster-management_io_api_cluster_v1_ManagedClusterClaim",
    "open-cluster-management_io_api_cluster_v1_ManagedClusterList",
    "open-cluster-management_io_api_cluster_v1_ManagedClusterSpec",
    "open-cluster-management_io_api_cluster_v1_ManagedClusterStatus",
    "open-cluster-management_io_api_cluster_v1_ManagedClusterVersion",
    "open-cluster-management_io_api_cluster_v1alpha1_ClusterClaimSelector",
    "open-cluster-management_io_api_cluster_v1alpha1_ClusterDecision",
    "open-cluster-management_io_api_cluster_v1alpha1_ClusterPredicate",
    "open-cluster-management_io_api_cluster_v1alpha1_ClusterSelector",
    "open-cluster-management_io_api_cluster_v1alpha1_Placement",
    "open-cluster-management_io_api_cluster_v1alpha1_PlacementDecision",
    "open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionList",
    "open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionStatus",
    "open-cluster-management_io_api_cluster_v1alpha1_PlacementList",
    "open-cluster-management_io_api_cluster_v1alpha1_PlacementSpec",
    "open-cluster-management_io_api_cluster_v1alpha1_PlacementStatus",
    "open-cluster-management_io_api_cluster_v1alpha1_PrioritizerConfig",
    "open-cluster-management_io_api_cluster_v1alpha1_PrioritizerPolicy",
    "open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSet",
    "open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBinding",
    "open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingList",
    "open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingSpec",
    "open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetList",
    "open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetSpec",
    "open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetStatus"
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
public class OpenClusterManagementClusterSchema {

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ClientConfig")
    private ClientConfig openClusterManagementIoApiClusterV1ClientConfig;
    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedCluster")
    private ManagedCluster openClusterManagementIoApiClusterV1ManagedCluster;
    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterClaim")
    private ManagedClusterClaim openClusterManagementIoApiClusterV1ManagedClusterClaim;
    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterList")
    private ManagedClusterList openClusterManagementIoApiClusterV1ManagedClusterList;
    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterSpec")
    private ManagedClusterSpec openClusterManagementIoApiClusterV1ManagedClusterSpec;
    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterStatus")
    private ManagedClusterStatus openClusterManagementIoApiClusterV1ManagedClusterStatus;
    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterVersion")
    private ManagedClusterVersion openClusterManagementIoApiClusterV1ManagedClusterVersion;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterClaimSelector")
    private ClusterClaimSelector openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterDecision")
    private ClusterDecision openClusterManagementIoApiClusterV1alpha1ClusterDecision;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterPredicate")
    private ClusterPredicate openClusterManagementIoApiClusterV1alpha1ClusterPredicate;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterSelector")
    private ClusterSelector openClusterManagementIoApiClusterV1alpha1ClusterSelector;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_Placement")
    private Placement openClusterManagementIoApiClusterV1alpha1Placement;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecision")
    private PlacementDecision openClusterManagementIoApiClusterV1alpha1PlacementDecision;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionList")
    private PlacementDecisionList openClusterManagementIoApiClusterV1alpha1PlacementDecisionList;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionStatus")
    private PlacementDecisionStatus openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementList")
    private PlacementList openClusterManagementIoApiClusterV1alpha1PlacementList;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementSpec")
    private PlacementSpec openClusterManagementIoApiClusterV1alpha1PlacementSpec;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementStatus")
    private PlacementStatus openClusterManagementIoApiClusterV1alpha1PlacementStatus;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PrioritizerConfig")
    private PrioritizerConfig openClusterManagementIoApiClusterV1alpha1PrioritizerConfig;
    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PrioritizerPolicy")
    private PrioritizerPolicy openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy;
    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSet")
    private ManagedClusterSet openClusterManagementIoApiClusterV1beta1ManagedClusterSet;
    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBinding")
    private ManagedClusterSetBinding openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding;
    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingList")
    private ManagedClusterSetBindingList openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList;
    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingSpec")
    private ManagedClusterSetBindingSpec openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec;
    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetList")
    private ManagedClusterSetList openClusterManagementIoApiClusterV1beta1ManagedClusterSetList;
    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetSpec")
    private ManagedClusterSetSpec openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec;
    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetStatus")
    private ManagedClusterSetStatus openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenClusterManagementClusterSchema() {
    }

    /**
     * 
     * @param openClusterManagementIoApiClusterV1alpha1ClusterPredicate
     * @param openClusterManagementIoApiClusterV1alpha1PlacementList
     * @param openClusterManagementIoApiClusterV1ManagedClusterClaim
     * @param openClusterManagementIoApiClusterV1ManagedClusterList
     * @param openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec
     * @param openClusterManagementIoApiClusterV1alpha1PlacementDecision
     * @param openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList
     * @param openClusterManagementIoApiClusterV1alpha1ClusterSelector
     * @param openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy
     * @param openClusterManagementIoApiClusterV1ClientConfig
     * @param openClusterManagementIoApiClusterV1alpha1PlacementDecisionList
     * @param openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus
     * @param openClusterManagementIoApiClusterV1alpha1PlacementSpec
     * @param openClusterManagementIoApiClusterV1ManagedCluster
     * @param openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector
     * @param openClusterManagementIoApiClusterV1ManagedClusterStatus
     * @param openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding
     * @param openClusterManagementIoApiClusterV1alpha1Placement
     * @param openClusterManagementIoApiClusterV1ManagedClusterSpec
     * @param openClusterManagementIoApiClusterV1beta1ManagedClusterSet
     * @param openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus
     * @param openClusterManagementIoApiClusterV1beta1ManagedClusterSetList
     * @param openClusterManagementIoApiClusterV1alpha1PlacementStatus
     * @param openClusterManagementIoApiClusterV1alpha1PrioritizerConfig
     * @param openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec
     * @param openClusterManagementIoApiClusterV1ManagedClusterVersion
     * @param openClusterManagementIoApiClusterV1alpha1ClusterDecision
     */
    public OpenClusterManagementClusterSchema(ClientConfig openClusterManagementIoApiClusterV1ClientConfig, ManagedCluster openClusterManagementIoApiClusterV1ManagedCluster, ManagedClusterClaim openClusterManagementIoApiClusterV1ManagedClusterClaim, ManagedClusterList openClusterManagementIoApiClusterV1ManagedClusterList, ManagedClusterSpec openClusterManagementIoApiClusterV1ManagedClusterSpec, ManagedClusterStatus openClusterManagementIoApiClusterV1ManagedClusterStatus, ManagedClusterVersion openClusterManagementIoApiClusterV1ManagedClusterVersion, ClusterClaimSelector openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector, ClusterDecision openClusterManagementIoApiClusterV1alpha1ClusterDecision, ClusterPredicate openClusterManagementIoApiClusterV1alpha1ClusterPredicate, ClusterSelector openClusterManagementIoApiClusterV1alpha1ClusterSelector, Placement openClusterManagementIoApiClusterV1alpha1Placement, PlacementDecision openClusterManagementIoApiClusterV1alpha1PlacementDecision, PlacementDecisionList openClusterManagementIoApiClusterV1alpha1PlacementDecisionList, PlacementDecisionStatus openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus, PlacementList openClusterManagementIoApiClusterV1alpha1PlacementList, PlacementSpec openClusterManagementIoApiClusterV1alpha1PlacementSpec, PlacementStatus openClusterManagementIoApiClusterV1alpha1PlacementStatus, PrioritizerConfig openClusterManagementIoApiClusterV1alpha1PrioritizerConfig, PrioritizerPolicy openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy, ManagedClusterSet openClusterManagementIoApiClusterV1beta1ManagedClusterSet, ManagedClusterSetBinding openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding, ManagedClusterSetBindingList openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList, ManagedClusterSetBindingSpec openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec, ManagedClusterSetList openClusterManagementIoApiClusterV1beta1ManagedClusterSetList, ManagedClusterSetSpec openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec, ManagedClusterSetStatus openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus) {
        super();
        this.openClusterManagementIoApiClusterV1ClientConfig = openClusterManagementIoApiClusterV1ClientConfig;
        this.openClusterManagementIoApiClusterV1ManagedCluster = openClusterManagementIoApiClusterV1ManagedCluster;
        this.openClusterManagementIoApiClusterV1ManagedClusterClaim = openClusterManagementIoApiClusterV1ManagedClusterClaim;
        this.openClusterManagementIoApiClusterV1ManagedClusterList = openClusterManagementIoApiClusterV1ManagedClusterList;
        this.openClusterManagementIoApiClusterV1ManagedClusterSpec = openClusterManagementIoApiClusterV1ManagedClusterSpec;
        this.openClusterManagementIoApiClusterV1ManagedClusterStatus = openClusterManagementIoApiClusterV1ManagedClusterStatus;
        this.openClusterManagementIoApiClusterV1ManagedClusterVersion = openClusterManagementIoApiClusterV1ManagedClusterVersion;
        this.openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector = openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector;
        this.openClusterManagementIoApiClusterV1alpha1ClusterDecision = openClusterManagementIoApiClusterV1alpha1ClusterDecision;
        this.openClusterManagementIoApiClusterV1alpha1ClusterPredicate = openClusterManagementIoApiClusterV1alpha1ClusterPredicate;
        this.openClusterManagementIoApiClusterV1alpha1ClusterSelector = openClusterManagementIoApiClusterV1alpha1ClusterSelector;
        this.openClusterManagementIoApiClusterV1alpha1Placement = openClusterManagementIoApiClusterV1alpha1Placement;
        this.openClusterManagementIoApiClusterV1alpha1PlacementDecision = openClusterManagementIoApiClusterV1alpha1PlacementDecision;
        this.openClusterManagementIoApiClusterV1alpha1PlacementDecisionList = openClusterManagementIoApiClusterV1alpha1PlacementDecisionList;
        this.openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus = openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus;
        this.openClusterManagementIoApiClusterV1alpha1PlacementList = openClusterManagementIoApiClusterV1alpha1PlacementList;
        this.openClusterManagementIoApiClusterV1alpha1PlacementSpec = openClusterManagementIoApiClusterV1alpha1PlacementSpec;
        this.openClusterManagementIoApiClusterV1alpha1PlacementStatus = openClusterManagementIoApiClusterV1alpha1PlacementStatus;
        this.openClusterManagementIoApiClusterV1alpha1PrioritizerConfig = openClusterManagementIoApiClusterV1alpha1PrioritizerConfig;
        this.openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy = openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy;
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSet = openClusterManagementIoApiClusterV1beta1ManagedClusterSet;
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding = openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding;
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList = openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList;
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec = openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec;
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetList = openClusterManagementIoApiClusterV1beta1ManagedClusterSetList;
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec = openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec;
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus = openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ClientConfig")
    public ClientConfig getOpenClusterManagementIoApiClusterV1ClientConfig() {
        return openClusterManagementIoApiClusterV1ClientConfig;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ClientConfig")
    public void setOpenClusterManagementIoApiClusterV1ClientConfig(ClientConfig openClusterManagementIoApiClusterV1ClientConfig) {
        this.openClusterManagementIoApiClusterV1ClientConfig = openClusterManagementIoApiClusterV1ClientConfig;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedCluster")
    public ManagedCluster getOpenClusterManagementIoApiClusterV1ManagedCluster() {
        return openClusterManagementIoApiClusterV1ManagedCluster;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedCluster")
    public void setOpenClusterManagementIoApiClusterV1ManagedCluster(ManagedCluster openClusterManagementIoApiClusterV1ManagedCluster) {
        this.openClusterManagementIoApiClusterV1ManagedCluster = openClusterManagementIoApiClusterV1ManagedCluster;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterClaim")
    public ManagedClusterClaim getOpenClusterManagementIoApiClusterV1ManagedClusterClaim() {
        return openClusterManagementIoApiClusterV1ManagedClusterClaim;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterClaim")
    public void setOpenClusterManagementIoApiClusterV1ManagedClusterClaim(ManagedClusterClaim openClusterManagementIoApiClusterV1ManagedClusterClaim) {
        this.openClusterManagementIoApiClusterV1ManagedClusterClaim = openClusterManagementIoApiClusterV1ManagedClusterClaim;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterList")
    public ManagedClusterList getOpenClusterManagementIoApiClusterV1ManagedClusterList() {
        return openClusterManagementIoApiClusterV1ManagedClusterList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterList")
    public void setOpenClusterManagementIoApiClusterV1ManagedClusterList(ManagedClusterList openClusterManagementIoApiClusterV1ManagedClusterList) {
        this.openClusterManagementIoApiClusterV1ManagedClusterList = openClusterManagementIoApiClusterV1ManagedClusterList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterSpec")
    public ManagedClusterSpec getOpenClusterManagementIoApiClusterV1ManagedClusterSpec() {
        return openClusterManagementIoApiClusterV1ManagedClusterSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterSpec")
    public void setOpenClusterManagementIoApiClusterV1ManagedClusterSpec(ManagedClusterSpec openClusterManagementIoApiClusterV1ManagedClusterSpec) {
        this.openClusterManagementIoApiClusterV1ManagedClusterSpec = openClusterManagementIoApiClusterV1ManagedClusterSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterStatus")
    public ManagedClusterStatus getOpenClusterManagementIoApiClusterV1ManagedClusterStatus() {
        return openClusterManagementIoApiClusterV1ManagedClusterStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterStatus")
    public void setOpenClusterManagementIoApiClusterV1ManagedClusterStatus(ManagedClusterStatus openClusterManagementIoApiClusterV1ManagedClusterStatus) {
        this.openClusterManagementIoApiClusterV1ManagedClusterStatus = openClusterManagementIoApiClusterV1ManagedClusterStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterVersion")
    public ManagedClusterVersion getOpenClusterManagementIoApiClusterV1ManagedClusterVersion() {
        return openClusterManagementIoApiClusterV1ManagedClusterVersion;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1_ManagedClusterVersion")
    public void setOpenClusterManagementIoApiClusterV1ManagedClusterVersion(ManagedClusterVersion openClusterManagementIoApiClusterV1ManagedClusterVersion) {
        this.openClusterManagementIoApiClusterV1ManagedClusterVersion = openClusterManagementIoApiClusterV1ManagedClusterVersion;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterClaimSelector")
    public ClusterClaimSelector getOpenClusterManagementIoApiClusterV1alpha1ClusterClaimSelector() {
        return openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterClaimSelector")
    public void setOpenClusterManagementIoApiClusterV1alpha1ClusterClaimSelector(ClusterClaimSelector openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector) {
        this.openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector = openClusterManagementIoApiClusterV1alpha1ClusterClaimSelector;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterDecision")
    public ClusterDecision getOpenClusterManagementIoApiClusterV1alpha1ClusterDecision() {
        return openClusterManagementIoApiClusterV1alpha1ClusterDecision;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterDecision")
    public void setOpenClusterManagementIoApiClusterV1alpha1ClusterDecision(ClusterDecision openClusterManagementIoApiClusterV1alpha1ClusterDecision) {
        this.openClusterManagementIoApiClusterV1alpha1ClusterDecision = openClusterManagementIoApiClusterV1alpha1ClusterDecision;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterPredicate")
    public ClusterPredicate getOpenClusterManagementIoApiClusterV1alpha1ClusterPredicate() {
        return openClusterManagementIoApiClusterV1alpha1ClusterPredicate;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterPredicate")
    public void setOpenClusterManagementIoApiClusterV1alpha1ClusterPredicate(ClusterPredicate openClusterManagementIoApiClusterV1alpha1ClusterPredicate) {
        this.openClusterManagementIoApiClusterV1alpha1ClusterPredicate = openClusterManagementIoApiClusterV1alpha1ClusterPredicate;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterSelector")
    public ClusterSelector getOpenClusterManagementIoApiClusterV1alpha1ClusterSelector() {
        return openClusterManagementIoApiClusterV1alpha1ClusterSelector;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_ClusterSelector")
    public void setOpenClusterManagementIoApiClusterV1alpha1ClusterSelector(ClusterSelector openClusterManagementIoApiClusterV1alpha1ClusterSelector) {
        this.openClusterManagementIoApiClusterV1alpha1ClusterSelector = openClusterManagementIoApiClusterV1alpha1ClusterSelector;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_Placement")
    public Placement getOpenClusterManagementIoApiClusterV1alpha1Placement() {
        return openClusterManagementIoApiClusterV1alpha1Placement;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_Placement")
    public void setOpenClusterManagementIoApiClusterV1alpha1Placement(Placement openClusterManagementIoApiClusterV1alpha1Placement) {
        this.openClusterManagementIoApiClusterV1alpha1Placement = openClusterManagementIoApiClusterV1alpha1Placement;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecision")
    public PlacementDecision getOpenClusterManagementIoApiClusterV1alpha1PlacementDecision() {
        return openClusterManagementIoApiClusterV1alpha1PlacementDecision;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecision")
    public void setOpenClusterManagementIoApiClusterV1alpha1PlacementDecision(PlacementDecision openClusterManagementIoApiClusterV1alpha1PlacementDecision) {
        this.openClusterManagementIoApiClusterV1alpha1PlacementDecision = openClusterManagementIoApiClusterV1alpha1PlacementDecision;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionList")
    public PlacementDecisionList getOpenClusterManagementIoApiClusterV1alpha1PlacementDecisionList() {
        return openClusterManagementIoApiClusterV1alpha1PlacementDecisionList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionList")
    public void setOpenClusterManagementIoApiClusterV1alpha1PlacementDecisionList(PlacementDecisionList openClusterManagementIoApiClusterV1alpha1PlacementDecisionList) {
        this.openClusterManagementIoApiClusterV1alpha1PlacementDecisionList = openClusterManagementIoApiClusterV1alpha1PlacementDecisionList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionStatus")
    public PlacementDecisionStatus getOpenClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus() {
        return openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementDecisionStatus")
    public void setOpenClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus(PlacementDecisionStatus openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus) {
        this.openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus = openClusterManagementIoApiClusterV1alpha1PlacementDecisionStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementList")
    public PlacementList getOpenClusterManagementIoApiClusterV1alpha1PlacementList() {
        return openClusterManagementIoApiClusterV1alpha1PlacementList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementList")
    public void setOpenClusterManagementIoApiClusterV1alpha1PlacementList(PlacementList openClusterManagementIoApiClusterV1alpha1PlacementList) {
        this.openClusterManagementIoApiClusterV1alpha1PlacementList = openClusterManagementIoApiClusterV1alpha1PlacementList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementSpec")
    public PlacementSpec getOpenClusterManagementIoApiClusterV1alpha1PlacementSpec() {
        return openClusterManagementIoApiClusterV1alpha1PlacementSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementSpec")
    public void setOpenClusterManagementIoApiClusterV1alpha1PlacementSpec(PlacementSpec openClusterManagementIoApiClusterV1alpha1PlacementSpec) {
        this.openClusterManagementIoApiClusterV1alpha1PlacementSpec = openClusterManagementIoApiClusterV1alpha1PlacementSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementStatus")
    public PlacementStatus getOpenClusterManagementIoApiClusterV1alpha1PlacementStatus() {
        return openClusterManagementIoApiClusterV1alpha1PlacementStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PlacementStatus")
    public void setOpenClusterManagementIoApiClusterV1alpha1PlacementStatus(PlacementStatus openClusterManagementIoApiClusterV1alpha1PlacementStatus) {
        this.openClusterManagementIoApiClusterV1alpha1PlacementStatus = openClusterManagementIoApiClusterV1alpha1PlacementStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PrioritizerConfig")
    public PrioritizerConfig getOpenClusterManagementIoApiClusterV1alpha1PrioritizerConfig() {
        return openClusterManagementIoApiClusterV1alpha1PrioritizerConfig;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PrioritizerConfig")
    public void setOpenClusterManagementIoApiClusterV1alpha1PrioritizerConfig(PrioritizerConfig openClusterManagementIoApiClusterV1alpha1PrioritizerConfig) {
        this.openClusterManagementIoApiClusterV1alpha1PrioritizerConfig = openClusterManagementIoApiClusterV1alpha1PrioritizerConfig;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PrioritizerPolicy")
    public PrioritizerPolicy getOpenClusterManagementIoApiClusterV1alpha1PrioritizerPolicy() {
        return openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1alpha1_PrioritizerPolicy")
    public void setOpenClusterManagementIoApiClusterV1alpha1PrioritizerPolicy(PrioritizerPolicy openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy) {
        this.openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy = openClusterManagementIoApiClusterV1alpha1PrioritizerPolicy;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSet")
    public ManagedClusterSet getOpenClusterManagementIoApiClusterV1beta1ManagedClusterSet() {
        return openClusterManagementIoApiClusterV1beta1ManagedClusterSet;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSet")
    public void setOpenClusterManagementIoApiClusterV1beta1ManagedClusterSet(ManagedClusterSet openClusterManagementIoApiClusterV1beta1ManagedClusterSet) {
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSet = openClusterManagementIoApiClusterV1beta1ManagedClusterSet;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBinding")
    public ManagedClusterSetBinding getOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding() {
        return openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBinding")
    public void setOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding(ManagedClusterSetBinding openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding) {
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding = openClusterManagementIoApiClusterV1beta1ManagedClusterSetBinding;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingList")
    public ManagedClusterSetBindingList getOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList() {
        return openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingList")
    public void setOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList(ManagedClusterSetBindingList openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList) {
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList = openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingSpec")
    public ManagedClusterSetBindingSpec getOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec() {
        return openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetBindingSpec")
    public void setOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec(ManagedClusterSetBindingSpec openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec) {
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec = openClusterManagementIoApiClusterV1beta1ManagedClusterSetBindingSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetList")
    public ManagedClusterSetList getOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetList() {
        return openClusterManagementIoApiClusterV1beta1ManagedClusterSetList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetList")
    public void setOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetList(ManagedClusterSetList openClusterManagementIoApiClusterV1beta1ManagedClusterSetList) {
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetList = openClusterManagementIoApiClusterV1beta1ManagedClusterSetList;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetSpec")
    public ManagedClusterSetSpec getOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec() {
        return openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetSpec")
    public void setOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec(ManagedClusterSetSpec openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec) {
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec = openClusterManagementIoApiClusterV1beta1ManagedClusterSetSpec;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetStatus")
    public ManagedClusterSetStatus getOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus() {
        return openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus;
    }

    @JsonProperty("open-cluster-management_io_api_cluster_v1beta1_ManagedClusterSetStatus")
    public void setOpenClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus(ManagedClusterSetStatus openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus) {
        this.openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus = openClusterManagementIoApiClusterV1beta1ManagedClusterSetStatus;
    }

}
