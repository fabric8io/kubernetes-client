
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachment;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentList;
import io.fabric8.kubernetes.api.model.storage.v1alpha1.VolumeAttributesClass;
import io.fabric8.kubernetes.api.model.storage.v1alpha1.VolumeAttributesClassList;
import io.fabric8.kubernetes.api.model.storagemigration.v1alpha1.StorageVersionMigration;
import io.fabric8.kubernetes.api.model.storagemigration.v1alpha1.StorageVersionMigrationList;
import io.fabric8.kubernetes.api.model.version.Info;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriver cSIDriver;
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriverList cSIDriverList;
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSINode cSINode;
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeList cSINodeList;
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity cSIStorageCapacity;
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList cSIStorageCapacityList;
    private CreateOptions createOptions;
    private DeleteOptions deleteOptions;
    private GetOptions getOptions;
    private Info info;
    private ListOptions listOptions;
    private ObjectMeta objectMeta;
    private ObjectReference objectReference;
    private Patch patch;
    private PatchOptions patchOptions;
    private Quantity quantity;
    private RootPaths rootPaths;
    private Status status;
    private StorageClass storageClass;
    private StorageClassList storageClassList;
    private StorageVersionMigration storageVersionMigration;
    private StorageVersionMigrationList storageVersionMigrationList;
    private String time;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    private io.fabric8.kubernetes.api.model.storage.CSIDriver v1CSIDriver;
    private io.fabric8.kubernetes.api.model.storage.CSIDriverList v1CSIDriverList;
    private io.fabric8.kubernetes.api.model.storage.CSINode v1CSINode;
    private io.fabric8.kubernetes.api.model.storage.CSINodeList v1CSINodeList;
    private io.fabric8.kubernetes.api.model.storage.CSIStorageCapacity v1CSIStorageCapacity;
    private io.fabric8.kubernetes.api.model.storage.CSIStorageCapacityList v1CSIStorageCapacityList;
    private VolumeAttachment volumeAttachment;
    private VolumeAttachmentList volumeAttachmentList;
    private VolumeAttributesClass volumeAttributesClass;
    private VolumeAttributesClassList volumeAttributesClassList;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriver cSIDriver, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriverList cSIDriverList, io.fabric8.kubernetes.api.model.storage.v1beta1.CSINode cSINode, io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeList cSINodeList, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity cSIStorageCapacity, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList cSIStorageCapacityList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, ListOptions listOptions, ObjectMeta objectMeta, ObjectReference objectReference, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Status status, StorageClass storageClass, StorageClassList storageClassList, StorageVersionMigration storageVersionMigration, StorageVersionMigrationList storageVersionMigrationList, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.storage.CSIDriver v1CSIDriver, io.fabric8.kubernetes.api.model.storage.CSIDriverList v1CSIDriverList, io.fabric8.kubernetes.api.model.storage.CSINode v1CSINode, io.fabric8.kubernetes.api.model.storage.CSINodeList v1CSINodeList, io.fabric8.kubernetes.api.model.storage.CSIStorageCapacity v1CSIStorageCapacity, io.fabric8.kubernetes.api.model.storage.CSIStorageCapacityList v1CSIStorageCapacityList, VolumeAttachment volumeAttachment, VolumeAttachmentList volumeAttachmentList, VolumeAttributesClass volumeAttributesClass, VolumeAttributesClassList volumeAttributesClassList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.cSIDriver = cSIDriver;
        this.cSIDriverList = cSIDriverList;
        this.cSINode = cSINode;
        this.cSINodeList = cSINodeList;
        this.cSIStorageCapacity = cSIStorageCapacity;
        this.cSIStorageCapacityList = cSIStorageCapacityList;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.getOptions = getOptions;
        this.info = info;
        this.listOptions = listOptions;
        this.objectMeta = objectMeta;
        this.objectReference = objectReference;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.quantity = quantity;
        this.rootPaths = rootPaths;
        this.status = status;
        this.storageClass = storageClass;
        this.storageClassList = storageClassList;
        this.storageVersionMigration = storageVersionMigration;
        this.storageVersionMigrationList = storageVersionMigrationList;
        this.time = time;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.v1CSIDriver = v1CSIDriver;
        this.v1CSIDriverList = v1CSIDriverList;
        this.v1CSINode = v1CSINode;
        this.v1CSINodeList = v1CSINodeList;
        this.v1CSIStorageCapacity = v1CSIStorageCapacity;
        this.v1CSIStorageCapacityList = v1CSIStorageCapacityList;
        this.volumeAttachment = volumeAttachment;
        this.volumeAttachmentList = volumeAttachmentList;
        this.volumeAttributesClass = volumeAttributesClass;
        this.volumeAttributesClassList = volumeAttributesClassList;
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

    @JsonProperty("BaseKubernetesList")
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("CSIDriver")
    public io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriver getCSIDriver() {
        return cSIDriver;
    }

    @JsonProperty("CSIDriver")
    public void setCSIDriver(io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriver cSIDriver) {
        this.cSIDriver = cSIDriver;
    }

    @JsonProperty("CSIDriverList")
    public io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriverList getCSIDriverList() {
        return cSIDriverList;
    }

    @JsonProperty("CSIDriverList")
    public void setCSIDriverList(io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriverList cSIDriverList) {
        this.cSIDriverList = cSIDriverList;
    }

    @JsonProperty("CSINode")
    public io.fabric8.kubernetes.api.model.storage.v1beta1.CSINode getCSINode() {
        return cSINode;
    }

    @JsonProperty("CSINode")
    public void setCSINode(io.fabric8.kubernetes.api.model.storage.v1beta1.CSINode cSINode) {
        this.cSINode = cSINode;
    }

    @JsonProperty("CSINodeList")
    public io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeList getCSINodeList() {
        return cSINodeList;
    }

    @JsonProperty("CSINodeList")
    public void setCSINodeList(io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeList cSINodeList) {
        this.cSINodeList = cSINodeList;
    }

    @JsonProperty("CSIStorageCapacity")
    public io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity getCSIStorageCapacity() {
        return cSIStorageCapacity;
    }

    @JsonProperty("CSIStorageCapacity")
    public void setCSIStorageCapacity(io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity cSIStorageCapacity) {
        this.cSIStorageCapacity = cSIStorageCapacity;
    }

    @JsonProperty("CSIStorageCapacityList")
    public io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList getCSIStorageCapacityList() {
        return cSIStorageCapacityList;
    }

    @JsonProperty("CSIStorageCapacityList")
    public void setCSIStorageCapacityList(io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList cSIStorageCapacityList) {
        this.cSIStorageCapacityList = cSIStorageCapacityList;
    }

    @JsonProperty("CreateOptions")
    public CreateOptions getCreateOptions() {
        return createOptions;
    }

    @JsonProperty("CreateOptions")
    public void setCreateOptions(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    @JsonProperty("DeleteOptions")
    public DeleteOptions getDeleteOptions() {
        return deleteOptions;
    }

    @JsonProperty("DeleteOptions")
    public void setDeleteOptions(DeleteOptions deleteOptions) {
        this.deleteOptions = deleteOptions;
    }

    @JsonProperty("GetOptions")
    public GetOptions getGetOptions() {
        return getOptions;
    }

    @JsonProperty("GetOptions")
    public void setGetOptions(GetOptions getOptions) {
        this.getOptions = getOptions;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("ListOptions")
    public ListOptions getListOptions() {
        return listOptions;
    }

    @JsonProperty("ListOptions")
    public void setListOptions(ListOptions listOptions) {
        this.listOptions = listOptions;
    }

    @JsonProperty("ObjectMeta")
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("ObjectReference")
    public ObjectReference getObjectReference() {
        return objectReference;
    }

    @JsonProperty("ObjectReference")
    public void setObjectReference(ObjectReference objectReference) {
        this.objectReference = objectReference;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("PatchOptions")
    public PatchOptions getPatchOptions() {
        return patchOptions;
    }

    @JsonProperty("PatchOptions")
    public void setPatchOptions(PatchOptions patchOptions) {
        this.patchOptions = patchOptions;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("RootPaths")
    public RootPaths getRootPaths() {
        return rootPaths;
    }

    @JsonProperty("RootPaths")
    public void setRootPaths(RootPaths rootPaths) {
        this.rootPaths = rootPaths;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("StorageClass")
    public StorageClass getStorageClass() {
        return storageClass;
    }

    @JsonProperty("StorageClass")
    public void setStorageClass(StorageClass storageClass) {
        this.storageClass = storageClass;
    }

    @JsonProperty("StorageClassList")
    public StorageClassList getStorageClassList() {
        return storageClassList;
    }

    @JsonProperty("StorageClassList")
    public void setStorageClassList(StorageClassList storageClassList) {
        this.storageClassList = storageClassList;
    }

    @JsonProperty("StorageVersionMigration")
    public StorageVersionMigration getStorageVersionMigration() {
        return storageVersionMigration;
    }

    @JsonProperty("StorageVersionMigration")
    public void setStorageVersionMigration(StorageVersionMigration storageVersionMigration) {
        this.storageVersionMigration = storageVersionMigration;
    }

    @JsonProperty("StorageVersionMigrationList")
    public StorageVersionMigrationList getStorageVersionMigrationList() {
        return storageVersionMigrationList;
    }

    @JsonProperty("StorageVersionMigrationList")
    public void setStorageVersionMigrationList(StorageVersionMigrationList storageVersionMigrationList) {
        this.storageVersionMigrationList = storageVersionMigrationList;
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

    @JsonProperty("UpdateOptions")
    public UpdateOptions getUpdateOptions() {
        return updateOptions;
    }

    @JsonProperty("UpdateOptions")
    public void setUpdateOptions(UpdateOptions updateOptions) {
        this.updateOptions = updateOptions;
    }

    @JsonProperty("V1CSIDriver")
    public io.fabric8.kubernetes.api.model.storage.CSIDriver getV1CSIDriver() {
        return v1CSIDriver;
    }

    @JsonProperty("V1CSIDriver")
    public void setV1CSIDriver(io.fabric8.kubernetes.api.model.storage.CSIDriver v1CSIDriver) {
        this.v1CSIDriver = v1CSIDriver;
    }

    @JsonProperty("V1CSIDriverList")
    public io.fabric8.kubernetes.api.model.storage.CSIDriverList getV1CSIDriverList() {
        return v1CSIDriverList;
    }

    @JsonProperty("V1CSIDriverList")
    public void setV1CSIDriverList(io.fabric8.kubernetes.api.model.storage.CSIDriverList v1CSIDriverList) {
        this.v1CSIDriverList = v1CSIDriverList;
    }

    @JsonProperty("V1CSINode")
    public io.fabric8.kubernetes.api.model.storage.CSINode getV1CSINode() {
        return v1CSINode;
    }

    @JsonProperty("V1CSINode")
    public void setV1CSINode(io.fabric8.kubernetes.api.model.storage.CSINode v1CSINode) {
        this.v1CSINode = v1CSINode;
    }

    @JsonProperty("V1CSINodeList")
    public io.fabric8.kubernetes.api.model.storage.CSINodeList getV1CSINodeList() {
        return v1CSINodeList;
    }

    @JsonProperty("V1CSINodeList")
    public void setV1CSINodeList(io.fabric8.kubernetes.api.model.storage.CSINodeList v1CSINodeList) {
        this.v1CSINodeList = v1CSINodeList;
    }

    @JsonProperty("V1CSIStorageCapacity")
    public io.fabric8.kubernetes.api.model.storage.CSIStorageCapacity getV1CSIStorageCapacity() {
        return v1CSIStorageCapacity;
    }

    @JsonProperty("V1CSIStorageCapacity")
    public void setV1CSIStorageCapacity(io.fabric8.kubernetes.api.model.storage.CSIStorageCapacity v1CSIStorageCapacity) {
        this.v1CSIStorageCapacity = v1CSIStorageCapacity;
    }

    @JsonProperty("V1CSIStorageCapacityList")
    public io.fabric8.kubernetes.api.model.storage.CSIStorageCapacityList getV1CSIStorageCapacityList() {
        return v1CSIStorageCapacityList;
    }

    @JsonProperty("V1CSIStorageCapacityList")
    public void setV1CSIStorageCapacityList(io.fabric8.kubernetes.api.model.storage.CSIStorageCapacityList v1CSIStorageCapacityList) {
        this.v1CSIStorageCapacityList = v1CSIStorageCapacityList;
    }

    @JsonProperty("VolumeAttachment")
    public VolumeAttachment getVolumeAttachment() {
        return volumeAttachment;
    }

    @JsonProperty("VolumeAttachment")
    public void setVolumeAttachment(VolumeAttachment volumeAttachment) {
        this.volumeAttachment = volumeAttachment;
    }

    @JsonProperty("VolumeAttachmentList")
    public VolumeAttachmentList getVolumeAttachmentList() {
        return volumeAttachmentList;
    }

    @JsonProperty("VolumeAttachmentList")
    public void setVolumeAttachmentList(VolumeAttachmentList volumeAttachmentList) {
        this.volumeAttachmentList = volumeAttachmentList;
    }

    @JsonProperty("VolumeAttributesClass")
    public VolumeAttributesClass getVolumeAttributesClass() {
        return volumeAttributesClass;
    }

    @JsonProperty("VolumeAttributesClass")
    public void setVolumeAttributesClass(VolumeAttributesClass volumeAttributesClass) {
        this.volumeAttributesClass = volumeAttributesClass;
    }

    @JsonProperty("VolumeAttributesClassList")
    public VolumeAttributesClassList getVolumeAttributesClassList() {
        return volumeAttributesClassList;
    }

    @JsonProperty("VolumeAttributesClassList")
    public void setVolumeAttributesClassList(VolumeAttributesClassList volumeAttributesClassList) {
        this.volumeAttributesClassList = volumeAttributesClassList;
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
