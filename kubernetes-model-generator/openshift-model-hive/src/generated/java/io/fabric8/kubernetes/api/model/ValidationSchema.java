
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.openshift.api.model.config.v1.ClusterOperatorStatusConditions;
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

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private io.fabric8.openshift.api.model.hive.azure.v1.OSDisk azureOSDisk;
    private KubernetesList baseKubernetesList;
    private Checkpoint checkpoint;
    private CheckpointList checkpointList;
    private ClusterClaim clusterClaim;
    private ClusterClaimList clusterClaimList;
    private ClusterDeployment clusterDeployment;
    private ClusterDeploymentList clusterDeploymentList;
    private ClusterDeprovision clusterDeprovision;
    private ClusterDeprovisionList clusterDeprovisionList;
    private ClusterImageSet clusterImageSet;
    private ClusterImageSetList clusterImageSetList;
    private ClusterOperatorStatusConditions clusterOperatorStatusCondition;
    private ClusterPool clusterPool;
    private ClusterPoolList clusterPoolList;
    private ClusterProvision clusterProvision;
    private ClusterProvisionList clusterProvisionList;
    private ClusterRelocate clusterRelocate;
    private ClusterRelocateList clusterRelocateList;
    private ClusterState clusterState;
    private ClusterStateList clusterStateList;
    private DNSZone dNSZone;
    private DNSZoneList dNSZoneList;
    private io.fabric8.openshift.api.model.hive.gcp.v1.OSDisk gcpOSDisk;
    private HiveConfig hiveConfig;
    private HiveConfigList hiveConfigList;
    private LocalObjectReference localObjectReference;
    private MachinePool machinePool;
    private MachinePoolList machinePoolList;
    private MachinePoolNameLease machinePoolNameLease;
    private MachinePoolNameLeaseList machinePoolNameLeaseList;
    private ObjectMeta objectMeta;
    private Patch patch;
    private SelectorSyncIdentityProvider selectorSyncIdentityProvider;
    private SelectorSyncIdentityProviderList selectorSyncIdentityProviderList;
    private SelectorSyncSet selectorSyncSet;
    private SelectorSyncSetList selectorSyncSetList;
    private Status status;
    private SyncIdentityProvider syncIdentityProvider;
    private SyncIdentityProviderList syncIdentityProviderList;
    private SyncSet syncSet;
    private SyncSetList syncSetList;
    private String time;
    private TypeMeta typeMeta;
    private io.fabric8.openshift.api.model.hive.vsphere.v1.OSDisk vsphereOSDisk;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, io.fabric8.openshift.api.model.hive.azure.v1.OSDisk azureOSDisk, KubernetesList baseKubernetesList, Checkpoint checkpoint, CheckpointList checkpointList, ClusterClaim clusterClaim, ClusterClaimList clusterClaimList, ClusterDeployment clusterDeployment, ClusterDeploymentList clusterDeploymentList, ClusterDeprovision clusterDeprovision, ClusterDeprovisionList clusterDeprovisionList, ClusterImageSet clusterImageSet, ClusterImageSetList clusterImageSetList, ClusterOperatorStatusConditions clusterOperatorStatusCondition, ClusterPool clusterPool, ClusterPoolList clusterPoolList, ClusterProvision clusterProvision, ClusterProvisionList clusterProvisionList, ClusterRelocate clusterRelocate, ClusterRelocateList clusterRelocateList, ClusterState clusterState, ClusterStateList clusterStateList, DNSZone dNSZone, DNSZoneList dNSZoneList, io.fabric8.openshift.api.model.hive.gcp.v1.OSDisk gcpOSDisk, HiveConfig hiveConfig, HiveConfigList hiveConfigList, LocalObjectReference localObjectReference, MachinePool machinePool, MachinePoolList machinePoolList, MachinePoolNameLease machinePoolNameLease, MachinePoolNameLeaseList machinePoolNameLeaseList, ObjectMeta objectMeta, Patch patch, SelectorSyncIdentityProvider selectorSyncIdentityProvider, SelectorSyncIdentityProviderList selectorSyncIdentityProviderList, SelectorSyncSet selectorSyncSet, SelectorSyncSetList selectorSyncSetList, Status status, SyncIdentityProvider syncIdentityProvider, SyncIdentityProviderList syncIdentityProviderList, SyncSet syncSet, SyncSetList syncSetList, String time, TypeMeta typeMeta, io.fabric8.openshift.api.model.hive.vsphere.v1.OSDisk vsphereOSDisk) {
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
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
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
    public ClusterOperatorStatusConditions getClusterOperatorStatusCondition() {
        return clusterOperatorStatusCondition;
    }

    @JsonProperty("ClusterOperatorStatusCondition")
    public void setClusterOperatorStatusCondition(ClusterOperatorStatusConditions clusterOperatorStatusCondition) {
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
    public LocalObjectReference getLocalObjectReference() {
        return localObjectReference;
    }

    @JsonProperty("LocalObjectReference")
    public void setLocalObjectReference(LocalObjectReference localObjectReference) {
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
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
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
