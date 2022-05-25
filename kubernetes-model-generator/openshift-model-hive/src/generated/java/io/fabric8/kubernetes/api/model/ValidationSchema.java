
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.ClusterOperatorStatusCondition;
import io.fabric8.openshift.api.model.hive.v1.Checkpoint;
import io.fabric8.openshift.api.model.hive.v1.CheckpointList;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaim;
import io.fabric8.openshift.api.model.hive.v1.ClusterClaimList;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeployment;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentList;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovision;
import io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionList;
import io.fabric8.openshift.api.model.hive.v1.ClusterImageSet;
import io.fabric8.openshift.api.model.hive.v1.ClusterImageSetList;
import io.fabric8.openshift.api.model.hive.v1.ClusterPool;
import io.fabric8.openshift.api.model.hive.v1.ClusterPoolList;
import io.fabric8.openshift.api.model.hive.v1.ClusterProvision;
import io.fabric8.openshift.api.model.hive.v1.ClusterProvisionList;
import io.fabric8.openshift.api.model.hive.v1.ClusterRelocate;
import io.fabric8.openshift.api.model.hive.v1.ClusterRelocateList;
import io.fabric8.openshift.api.model.hive.v1.ClusterState;
import io.fabric8.openshift.api.model.hive.v1.ClusterStateList;
import io.fabric8.openshift.api.model.hive.v1.DNSZone;
import io.fabric8.openshift.api.model.hive.v1.DNSZoneList;
import io.fabric8.openshift.api.model.hive.v1.HiveConfig;
import io.fabric8.openshift.api.model.hive.v1.HiveConfigList;
import io.fabric8.openshift.api.model.hive.v1.MachinePool;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolList;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolNameLease;
import io.fabric8.openshift.api.model.hive.v1.MachinePoolNameLeaseList;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProvider;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncIdentityProviderList;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSet;
import io.fabric8.openshift.api.model.hive.v1.SelectorSyncSetList;
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProvider;
import io.fabric8.openshift.api.model.hive.v1.SyncIdentityProviderList;
import io.fabric8.openshift.api.model.hive.v1.SyncSet;
import io.fabric8.openshift.api.model.hive.v1.SyncSetList;
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
    "APIGroup",
    "APIGroupList",
    "AzureOSDisk",
    "BaseKubernetesList",
    "Checkpoint",
    "CheckpointList",
    "ClusterClaim",
    "ClusterClaimList",
    "ClusterDeployment",
    "ClusterDeploymentList",
    "ClusterDeprovision",
    "ClusterDeprovisionList",
    "ClusterImageSet",
    "ClusterImageSetList",
    "ClusterOperatorStatusCondition",
    "ClusterPool",
    "ClusterPoolList",
    "ClusterProvision",
    "ClusterProvisionList",
    "ClusterRelocate",
    "ClusterRelocateList",
    "ClusterState",
    "ClusterStateList",
    "DNSZone",
    "DNSZoneList",
    "GcpOSDisk",
    "HiveConfig",
    "HiveConfigList",
    "LocalObjectReference",
    "MachinePool",
    "MachinePoolList",
    "MachinePoolNameLease",
    "MachinePoolNameLeaseList",
    "ObjectMeta",
    "Patch",
    "SelectorSyncIdentityProvider",
    "SelectorSyncIdentityProviderList",
    "SelectorSyncSet",
    "SelectorSyncSetList",
    "Status",
    "SyncIdentityProvider",
    "SyncIdentityProviderList",
    "SyncSet",
    "SyncSetList",
    "Time",
    "TypeMeta",
    "VsphereOSDisk"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ValidationSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("AzureOSDisk")
    private io.fabric8.openshift.api.model.hive.azure.v1.OSDisk azureOSDisk;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("Checkpoint")
    private Checkpoint checkpoint;
    @JsonProperty("CheckpointList")
    private CheckpointList checkpointList;
    @JsonProperty("ClusterClaim")
    private ClusterClaim clusterClaim;
    @JsonProperty("ClusterClaimList")
    private ClusterClaimList clusterClaimList;
    @JsonProperty("ClusterDeployment")
    private ClusterDeployment clusterDeployment;
    @JsonProperty("ClusterDeploymentList")
    private ClusterDeploymentList clusterDeploymentList;
    @JsonProperty("ClusterDeprovision")
    private ClusterDeprovision clusterDeprovision;
    @JsonProperty("ClusterDeprovisionList")
    private ClusterDeprovisionList clusterDeprovisionList;
    @JsonProperty("ClusterImageSet")
    private ClusterImageSet clusterImageSet;
    @JsonProperty("ClusterImageSetList")
    private ClusterImageSetList clusterImageSetList;
    @JsonProperty("ClusterOperatorStatusCondition")
    private ClusterOperatorStatusCondition clusterOperatorStatusCondition;
    @JsonProperty("ClusterPool")
    private ClusterPool clusterPool;
    @JsonProperty("ClusterPoolList")
    private ClusterPoolList clusterPoolList;
    @JsonProperty("ClusterProvision")
    private ClusterProvision clusterProvision;
    @JsonProperty("ClusterProvisionList")
    private ClusterProvisionList clusterProvisionList;
    @JsonProperty("ClusterRelocate")
    private ClusterRelocate clusterRelocate;
    @JsonProperty("ClusterRelocateList")
    private ClusterRelocateList clusterRelocateList;
    @JsonProperty("ClusterState")
    private ClusterState clusterState;
    @JsonProperty("ClusterStateList")
    private ClusterStateList clusterStateList;
    @JsonProperty("DNSZone")
    private DNSZone dNSZone;
    @JsonProperty("DNSZoneList")
    private DNSZoneList dNSZoneList;
    @JsonProperty("GcpOSDisk")
    private io.fabric8.openshift.api.model.hive.gcp.v1.OSDisk gcpOSDisk;
    @JsonProperty("HiveConfig")
    private HiveConfig hiveConfig;
    @JsonProperty("HiveConfigList")
    private HiveConfigList hiveConfigList;
    @JsonProperty("LocalObjectReference")
    private io.fabric8.kubernetes.api.model.LocalObjectReference localObjectReference;
    @JsonProperty("MachinePool")
    private MachinePool machinePool;
    @JsonProperty("MachinePoolList")
    private MachinePoolList machinePoolList;
    @JsonProperty("MachinePoolNameLease")
    private MachinePoolNameLease machinePoolNameLease;
    @JsonProperty("MachinePoolNameLeaseList")
    private MachinePoolNameLeaseList machinePoolNameLeaseList;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("SelectorSyncIdentityProvider")
    private SelectorSyncIdentityProvider selectorSyncIdentityProvider;
    @JsonProperty("SelectorSyncIdentityProviderList")
    private SelectorSyncIdentityProviderList selectorSyncIdentityProviderList;
    @JsonProperty("SelectorSyncSet")
    private SelectorSyncSet selectorSyncSet;
    @JsonProperty("SelectorSyncSetList")
    private SelectorSyncSetList selectorSyncSetList;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("SyncIdentityProvider")
    private SyncIdentityProvider syncIdentityProvider;
    @JsonProperty("SyncIdentityProviderList")
    private SyncIdentityProviderList syncIdentityProviderList;
    @JsonProperty("SyncSet")
    private SyncSet syncSet;
    @JsonProperty("SyncSetList")
    private SyncSetList syncSetList;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("VsphereOSDisk")
    private io.fabric8.openshift.api.model.hive.vsphere.v1.OSDisk vsphereOSDisk;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    /**
     * 
     * @param checkpoint
     * @param clusterRelocateList
     * @param aPIGroupList
     * @param clusterImageSetList
     * @param hiveConfigList
     * @param clusterDeployment
     * @param clusterPool
     * @param machinePoolNameLease
     * @param baseKubernetesList
     * @param clusterDeprovisionList
     * @param clusterProvisionList
     * @param clusterProvision
     * @param clusterStateList
     * @param localObjectReference
     * @param patch
     * @param clusterPoolList
     * @param selectorSyncIdentityProviderList
     * @param vsphereOSDisk
     * @param selectorSyncSetList
     * @param machinePoolList
     * @param syncIdentityProviderList
     * @param selectorSyncSet
     * @param clusterState
     * @param clusterDeploymentList
     * @param clusterDeprovision
     * @param gcpOSDisk
     * @param syncSet
     * @param clusterRelocate
     * @param clusterOperatorStatusCondition
     * @param clusterClaim
     * @param syncIdentityProvider
     * @param clusterImageSet
     * @param machinePoolNameLeaseList
     * @param checkpointList
     * @param dNSZone
     * @param aPIGroup
     * @param syncSetList
     * @param typeMeta
     * @param clusterClaimList
     * @param objectMeta
     * @param hiveConfig
     * @param azureOSDisk
     * @param selectorSyncIdentityProvider
     * @param time
     * @param machinePool
     * @param dNSZoneList
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, io.fabric8.openshift.api.model.hive.azure.v1.OSDisk azureOSDisk, BaseKubernetesList baseKubernetesList, Checkpoint checkpoint, CheckpointList checkpointList, ClusterClaim clusterClaim, ClusterClaimList clusterClaimList, ClusterDeployment clusterDeployment, ClusterDeploymentList clusterDeploymentList, ClusterDeprovision clusterDeprovision, ClusterDeprovisionList clusterDeprovisionList, ClusterImageSet clusterImageSet, ClusterImageSetList clusterImageSetList, ClusterOperatorStatusCondition clusterOperatorStatusCondition, ClusterPool clusterPool, ClusterPoolList clusterPoolList, ClusterProvision clusterProvision, ClusterProvisionList clusterProvisionList, ClusterRelocate clusterRelocate, ClusterRelocateList clusterRelocateList, ClusterState clusterState, ClusterStateList clusterStateList, DNSZone dNSZone, DNSZoneList dNSZoneList, io.fabric8.openshift.api.model.hive.gcp.v1.OSDisk gcpOSDisk, HiveConfig hiveConfig, HiveConfigList hiveConfigList, io.fabric8.kubernetes.api.model.LocalObjectReference localObjectReference, MachinePool machinePool, MachinePoolList machinePoolList, MachinePoolNameLease machinePoolNameLease, MachinePoolNameLeaseList machinePoolNameLeaseList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, SelectorSyncIdentityProvider selectorSyncIdentityProvider, SelectorSyncIdentityProviderList selectorSyncIdentityProviderList, SelectorSyncSet selectorSyncSet, SelectorSyncSetList selectorSyncSetList, Status status, SyncIdentityProvider syncIdentityProvider, SyncIdentityProviderList syncIdentityProviderList, SyncSet syncSet, SyncSetList syncSetList, String time, TypeMeta typeMeta, io.fabric8.openshift.api.model.hive.vsphere.v1.OSDisk vsphereOSDisk) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.azureOSDisk = azureOSDisk;
        this.baseKubernetesList = baseKubernetesList;
        this.checkpoint = checkpoint;
        this.checkpointList = checkpointList;
        this.clusterClaim = clusterClaim;
        this.clusterClaimList = clusterClaimList;
        this.clusterDeployment = clusterDeployment;
        this.clusterDeploymentList = clusterDeploymentList;
        this.clusterDeprovision = clusterDeprovision;
        this.clusterDeprovisionList = clusterDeprovisionList;
        this.clusterImageSet = clusterImageSet;
        this.clusterImageSetList = clusterImageSetList;
        this.clusterOperatorStatusCondition = clusterOperatorStatusCondition;
        this.clusterPool = clusterPool;
        this.clusterPoolList = clusterPoolList;
        this.clusterProvision = clusterProvision;
        this.clusterProvisionList = clusterProvisionList;
        this.clusterRelocate = clusterRelocate;
        this.clusterRelocateList = clusterRelocateList;
        this.clusterState = clusterState;
        this.clusterStateList = clusterStateList;
        this.dNSZone = dNSZone;
        this.dNSZoneList = dNSZoneList;
        this.gcpOSDisk = gcpOSDisk;
        this.hiveConfig = hiveConfig;
        this.hiveConfigList = hiveConfigList;
        this.localObjectReference = localObjectReference;
        this.machinePool = machinePool;
        this.machinePoolList = machinePoolList;
        this.machinePoolNameLease = machinePoolNameLease;
        this.machinePoolNameLeaseList = machinePoolNameLeaseList;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.selectorSyncIdentityProvider = selectorSyncIdentityProvider;
        this.selectorSyncIdentityProviderList = selectorSyncIdentityProviderList;
        this.selectorSyncSet = selectorSyncSet;
        this.selectorSyncSetList = selectorSyncSetList;
        this.status = status;
        this.syncIdentityProvider = syncIdentityProvider;
        this.syncIdentityProviderList = syncIdentityProviderList;
        this.syncSet = syncSet;
        this.syncSetList = syncSetList;
        this.time = time;
        this.typeMeta = typeMeta;
        this.vsphereOSDisk = vsphereOSDisk;
    }

    @JsonProperty("APIGroup")
    public APIGroup getAPIGroup() {
        return aPIGroup;
    }

    @JsonProperty("APIGroup")
    public void setAPIGroup(APIGroup aPIGroup) {
        this.aPIGroup = aPIGroup;
    }

    @JsonProperty("APIGroupList")
    public APIGroupList getAPIGroupList() {
        return aPIGroupList;
    }

    @JsonProperty("APIGroupList")
    public void setAPIGroupList(APIGroupList aPIGroupList) {
        this.aPIGroupList = aPIGroupList;
    }

    @JsonProperty("AzureOSDisk")
    public io.fabric8.openshift.api.model.hive.azure.v1.OSDisk getAzureOSDisk() {
        return azureOSDisk;
    }

    @JsonProperty("AzureOSDisk")
    public void setAzureOSDisk(io.fabric8.openshift.api.model.hive.azure.v1.OSDisk azureOSDisk) {
        this.azureOSDisk = azureOSDisk;
    }

    @JsonProperty("BaseKubernetesList")
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("Checkpoint")
    public Checkpoint getCheckpoint() {
        return checkpoint;
    }

    @JsonProperty("Checkpoint")
    public void setCheckpoint(Checkpoint checkpoint) {
        this.checkpoint = checkpoint;
    }

    @JsonProperty("CheckpointList")
    public CheckpointList getCheckpointList() {
        return checkpointList;
    }

    @JsonProperty("CheckpointList")
    public void setCheckpointList(CheckpointList checkpointList) {
        this.checkpointList = checkpointList;
    }

    @JsonProperty("ClusterClaim")
    public ClusterClaim getClusterClaim() {
        return clusterClaim;
    }

    @JsonProperty("ClusterClaim")
    public void setClusterClaim(ClusterClaim clusterClaim) {
        this.clusterClaim = clusterClaim;
    }

    @JsonProperty("ClusterClaimList")
    public ClusterClaimList getClusterClaimList() {
        return clusterClaimList;
    }

    @JsonProperty("ClusterClaimList")
    public void setClusterClaimList(ClusterClaimList clusterClaimList) {
        this.clusterClaimList = clusterClaimList;
    }

    @JsonProperty("ClusterDeployment")
    public ClusterDeployment getClusterDeployment() {
        return clusterDeployment;
    }

    @JsonProperty("ClusterDeployment")
    public void setClusterDeployment(ClusterDeployment clusterDeployment) {
        this.clusterDeployment = clusterDeployment;
    }

    @JsonProperty("ClusterDeploymentList")
    public ClusterDeploymentList getClusterDeploymentList() {
        return clusterDeploymentList;
    }

    @JsonProperty("ClusterDeploymentList")
    public void setClusterDeploymentList(ClusterDeploymentList clusterDeploymentList) {
        this.clusterDeploymentList = clusterDeploymentList;
    }

    @JsonProperty("ClusterDeprovision")
    public ClusterDeprovision getClusterDeprovision() {
        return clusterDeprovision;
    }

    @JsonProperty("ClusterDeprovision")
    public void setClusterDeprovision(ClusterDeprovision clusterDeprovision) {
        this.clusterDeprovision = clusterDeprovision;
    }

    @JsonProperty("ClusterDeprovisionList")
    public ClusterDeprovisionList getClusterDeprovisionList() {
        return clusterDeprovisionList;
    }

    @JsonProperty("ClusterDeprovisionList")
    public void setClusterDeprovisionList(ClusterDeprovisionList clusterDeprovisionList) {
        this.clusterDeprovisionList = clusterDeprovisionList;
    }

    @JsonProperty("ClusterImageSet")
    public ClusterImageSet getClusterImageSet() {
        return clusterImageSet;
    }

    @JsonProperty("ClusterImageSet")
    public void setClusterImageSet(ClusterImageSet clusterImageSet) {
        this.clusterImageSet = clusterImageSet;
    }

    @JsonProperty("ClusterImageSetList")
    public ClusterImageSetList getClusterImageSetList() {
        return clusterImageSetList;
    }

    @JsonProperty("ClusterImageSetList")
    public void setClusterImageSetList(ClusterImageSetList clusterImageSetList) {
        this.clusterImageSetList = clusterImageSetList;
    }

    @JsonProperty("ClusterOperatorStatusCondition")
    public ClusterOperatorStatusCondition getClusterOperatorStatusCondition() {
        return clusterOperatorStatusCondition;
    }

    @JsonProperty("ClusterOperatorStatusCondition")
    public void setClusterOperatorStatusCondition(ClusterOperatorStatusCondition clusterOperatorStatusCondition) {
        this.clusterOperatorStatusCondition = clusterOperatorStatusCondition;
    }

    @JsonProperty("ClusterPool")
    public ClusterPool getClusterPool() {
        return clusterPool;
    }

    @JsonProperty("ClusterPool")
    public void setClusterPool(ClusterPool clusterPool) {
        this.clusterPool = clusterPool;
    }

    @JsonProperty("ClusterPoolList")
    public ClusterPoolList getClusterPoolList() {
        return clusterPoolList;
    }

    @JsonProperty("ClusterPoolList")
    public void setClusterPoolList(ClusterPoolList clusterPoolList) {
        this.clusterPoolList = clusterPoolList;
    }

    @JsonProperty("ClusterProvision")
    public ClusterProvision getClusterProvision() {
        return clusterProvision;
    }

    @JsonProperty("ClusterProvision")
    public void setClusterProvision(ClusterProvision clusterProvision) {
        this.clusterProvision = clusterProvision;
    }

    @JsonProperty("ClusterProvisionList")
    public ClusterProvisionList getClusterProvisionList() {
        return clusterProvisionList;
    }

    @JsonProperty("ClusterProvisionList")
    public void setClusterProvisionList(ClusterProvisionList clusterProvisionList) {
        this.clusterProvisionList = clusterProvisionList;
    }

    @JsonProperty("ClusterRelocate")
    public ClusterRelocate getClusterRelocate() {
        return clusterRelocate;
    }

    @JsonProperty("ClusterRelocate")
    public void setClusterRelocate(ClusterRelocate clusterRelocate) {
        this.clusterRelocate = clusterRelocate;
    }

    @JsonProperty("ClusterRelocateList")
    public ClusterRelocateList getClusterRelocateList() {
        return clusterRelocateList;
    }

    @JsonProperty("ClusterRelocateList")
    public void setClusterRelocateList(ClusterRelocateList clusterRelocateList) {
        this.clusterRelocateList = clusterRelocateList;
    }

    @JsonProperty("ClusterState")
    public ClusterState getClusterState() {
        return clusterState;
    }

    @JsonProperty("ClusterState")
    public void setClusterState(ClusterState clusterState) {
        this.clusterState = clusterState;
    }

    @JsonProperty("ClusterStateList")
    public ClusterStateList getClusterStateList() {
        return clusterStateList;
    }

    @JsonProperty("ClusterStateList")
    public void setClusterStateList(ClusterStateList clusterStateList) {
        this.clusterStateList = clusterStateList;
    }

    @JsonProperty("DNSZone")
    public DNSZone getDNSZone() {
        return dNSZone;
    }

    @JsonProperty("DNSZone")
    public void setDNSZone(DNSZone dNSZone) {
        this.dNSZone = dNSZone;
    }

    @JsonProperty("DNSZoneList")
    public DNSZoneList getDNSZoneList() {
        return dNSZoneList;
    }

    @JsonProperty("DNSZoneList")
    public void setDNSZoneList(DNSZoneList dNSZoneList) {
        this.dNSZoneList = dNSZoneList;
    }

    @JsonProperty("GcpOSDisk")
    public io.fabric8.openshift.api.model.hive.gcp.v1.OSDisk getGcpOSDisk() {
        return gcpOSDisk;
    }

    @JsonProperty("GcpOSDisk")
    public void setGcpOSDisk(io.fabric8.openshift.api.model.hive.gcp.v1.OSDisk gcpOSDisk) {
        this.gcpOSDisk = gcpOSDisk;
    }

    @JsonProperty("HiveConfig")
    public HiveConfig getHiveConfig() {
        return hiveConfig;
    }

    @JsonProperty("HiveConfig")
    public void setHiveConfig(HiveConfig hiveConfig) {
        this.hiveConfig = hiveConfig;
    }

    @JsonProperty("HiveConfigList")
    public HiveConfigList getHiveConfigList() {
        return hiveConfigList;
    }

    @JsonProperty("HiveConfigList")
    public void setHiveConfigList(HiveConfigList hiveConfigList) {
        this.hiveConfigList = hiveConfigList;
    }

    @JsonProperty("LocalObjectReference")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getLocalObjectReference() {
        return localObjectReference;
    }

    @JsonProperty("LocalObjectReference")
    public void setLocalObjectReference(io.fabric8.kubernetes.api.model.LocalObjectReference localObjectReference) {
        this.localObjectReference = localObjectReference;
    }

    @JsonProperty("MachinePool")
    public MachinePool getMachinePool() {
        return machinePool;
    }

    @JsonProperty("MachinePool")
    public void setMachinePool(MachinePool machinePool) {
        this.machinePool = machinePool;
    }

    @JsonProperty("MachinePoolList")
    public MachinePoolList getMachinePoolList() {
        return machinePoolList;
    }

    @JsonProperty("MachinePoolList")
    public void setMachinePoolList(MachinePoolList machinePoolList) {
        this.machinePoolList = machinePoolList;
    }

    @JsonProperty("MachinePoolNameLease")
    public MachinePoolNameLease getMachinePoolNameLease() {
        return machinePoolNameLease;
    }

    @JsonProperty("MachinePoolNameLease")
    public void setMachinePoolNameLease(MachinePoolNameLease machinePoolNameLease) {
        this.machinePoolNameLease = machinePoolNameLease;
    }

    @JsonProperty("MachinePoolNameLeaseList")
    public MachinePoolNameLeaseList getMachinePoolNameLeaseList() {
        return machinePoolNameLeaseList;
    }

    @JsonProperty("MachinePoolNameLeaseList")
    public void setMachinePoolNameLeaseList(MachinePoolNameLeaseList machinePoolNameLeaseList) {
        this.machinePoolNameLeaseList = machinePoolNameLeaseList;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("SelectorSyncIdentityProvider")
    public SelectorSyncIdentityProvider getSelectorSyncIdentityProvider() {
        return selectorSyncIdentityProvider;
    }

    @JsonProperty("SelectorSyncIdentityProvider")
    public void setSelectorSyncIdentityProvider(SelectorSyncIdentityProvider selectorSyncIdentityProvider) {
        this.selectorSyncIdentityProvider = selectorSyncIdentityProvider;
    }

    @JsonProperty("SelectorSyncIdentityProviderList")
    public SelectorSyncIdentityProviderList getSelectorSyncIdentityProviderList() {
        return selectorSyncIdentityProviderList;
    }

    @JsonProperty("SelectorSyncIdentityProviderList")
    public void setSelectorSyncIdentityProviderList(SelectorSyncIdentityProviderList selectorSyncIdentityProviderList) {
        this.selectorSyncIdentityProviderList = selectorSyncIdentityProviderList;
    }

    @JsonProperty("SelectorSyncSet")
    public SelectorSyncSet getSelectorSyncSet() {
        return selectorSyncSet;
    }

    @JsonProperty("SelectorSyncSet")
    public void setSelectorSyncSet(SelectorSyncSet selectorSyncSet) {
        this.selectorSyncSet = selectorSyncSet;
    }

    @JsonProperty("SelectorSyncSetList")
    public SelectorSyncSetList getSelectorSyncSetList() {
        return selectorSyncSetList;
    }

    @JsonProperty("SelectorSyncSetList")
    public void setSelectorSyncSetList(SelectorSyncSetList selectorSyncSetList) {
        this.selectorSyncSetList = selectorSyncSetList;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("SyncIdentityProvider")
    public SyncIdentityProvider getSyncIdentityProvider() {
        return syncIdentityProvider;
    }

    @JsonProperty("SyncIdentityProvider")
    public void setSyncIdentityProvider(SyncIdentityProvider syncIdentityProvider) {
        this.syncIdentityProvider = syncIdentityProvider;
    }

    @JsonProperty("SyncIdentityProviderList")
    public SyncIdentityProviderList getSyncIdentityProviderList() {
        return syncIdentityProviderList;
    }

    @JsonProperty("SyncIdentityProviderList")
    public void setSyncIdentityProviderList(SyncIdentityProviderList syncIdentityProviderList) {
        this.syncIdentityProviderList = syncIdentityProviderList;
    }

    @JsonProperty("SyncSet")
    public SyncSet getSyncSet() {
        return syncSet;
    }

    @JsonProperty("SyncSet")
    public void setSyncSet(SyncSet syncSet) {
        this.syncSet = syncSet;
    }

    @JsonProperty("SyncSetList")
    public SyncSetList getSyncSetList() {
        return syncSetList;
    }

    @JsonProperty("SyncSetList")
    public void setSyncSetList(SyncSetList syncSetList) {
        this.syncSetList = syncSetList;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonProperty("VsphereOSDisk")
    public io.fabric8.openshift.api.model.hive.vsphere.v1.OSDisk getVsphereOSDisk() {
        return vsphereOSDisk;
    }

    @JsonProperty("VsphereOSDisk")
    public void setVsphereOSDisk(io.fabric8.openshift.api.model.hive.vsphere.v1.OSDisk vsphereOSDisk) {
        this.vsphereOSDisk = vsphereOSDisk;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
