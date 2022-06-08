
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.storage.StorageClass;
import io.fabric8.kubernetes.api.model.storage.StorageClassList;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachment;
import io.fabric8.kubernetes.api.model.storage.VolumeAttachmentList;
import io.fabric8.kubernetes.api.model.version.Info;
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
    "BaseKubernetesList",
    "CSIDriver",
    "CSIDriverList",
    "CSINode",
    "CSINodeList",
    "CSIStorageCapacity",
    "CSIStorageCapacityList",
    "CreateOptions",
    "DeleteOptions",
    "GetOptions",
    "Info",
    "ListOptions",
    "ObjectMeta",
    "ObjectReference",
    "Patch",
    "PatchOptions",
    "Quantity",
    "RootPaths",
    "Status",
    "StorageClass",
    "StorageClassList",
    "Time",
    "TypeMeta",
    "UpdateOptions",
    "V1CSIDriver",
    "V1CSIDriverList",
    "V1CSINode",
    "V1CSINodeList",
    "V1CSIStorageCapacity",
    "V1CSIStorageCapacityList",
    "VolumeAttachment",
    "VolumeAttachmentList"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ValidationSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("CSIDriver")
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriver cSIDriver;
    @JsonProperty("CSIDriverList")
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriverList cSIDriverList;
    @JsonProperty("CSINode")
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSINode cSINode;
    @JsonProperty("CSINodeList")
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeList cSINodeList;
    @JsonProperty("CSIStorageCapacity")
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity cSIStorageCapacity;
    @JsonProperty("CSIStorageCapacityList")
    private io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList cSIStorageCapacityList;
    @JsonProperty("CreateOptions")
    private CreateOptions createOptions;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("ListOptions")
    private ListOptions listOptions;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("ObjectReference")
    private io.fabric8.kubernetes.api.model.ObjectReference objectReference;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("PatchOptions")
    private PatchOptions patchOptions;
    @JsonProperty("Quantity")
    private Quantity quantity;
    @JsonProperty("RootPaths")
    private RootPaths rootPaths;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("StorageClass")
    private StorageClass storageClass;
    @JsonProperty("StorageClassList")
    private StorageClassList storageClassList;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonProperty("V1CSIDriver")
    private io.fabric8.kubernetes.api.model.storage.CSIDriver v1CSIDriver;
    @JsonProperty("V1CSIDriverList")
    private io.fabric8.kubernetes.api.model.storage.CSIDriverList v1CSIDriverList;
    @JsonProperty("V1CSINode")
    private io.fabric8.kubernetes.api.model.storage.CSINode v1CSINode;
    @JsonProperty("V1CSINodeList")
    private io.fabric8.kubernetes.api.model.storage.CSINodeList v1CSINodeList;
    @JsonProperty("V1CSIStorageCapacity")
    private io.fabric8.kubernetes.api.model.storage.CSIStorageCapacity v1CSIStorageCapacity;
    @JsonProperty("V1CSIStorageCapacityList")
    private io.fabric8.kubernetes.api.model.storage.CSIStorageCapacityList v1CSIStorageCapacityList;
    @JsonProperty("VolumeAttachment")
    private VolumeAttachment volumeAttachment;
    @JsonProperty("VolumeAttachmentList")
    private VolumeAttachmentList volumeAttachmentList;
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
     * @param listOptions
     * @param aPIGroupList
     * @param v1CSINodeList
     * @param v1CSIStorageCapacityList
     * @param baseKubernetesList
     * @param updateOptions
     * @param cSIDriverList
     * @param v1CSIDriver
     * @param cSINode
     * @param patch
     * @param cSINodeList
     * @param storageClass
     * @param v1CSINode
     * @param volumeAttachmentList
     * @param v1CSIStorageCapacity
     * @param rootPaths
     * @param info
     * @param cSIDriver
     * @param patchOptions
     * @param deleteOptions
     * @param quantity
     * @param volumeAttachment
     * @param storageClassList
     * @param objectReference
     * @param cSIStorageCapacityList
     * @param createOptions
     * @param v1CSIDriverList
     * @param aPIGroup
     * @param typeMeta
     * @param objectMeta
     * @param cSIStorageCapacity
     * @param getOptions
     * @param time
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriver cSIDriver, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIDriverList cSIDriverList, io.fabric8.kubernetes.api.model.storage.v1beta1.CSINode cSINode, io.fabric8.kubernetes.api.model.storage.v1beta1.CSINodeList cSINodeList, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacity cSIStorageCapacity, io.fabric8.kubernetes.api.model.storage.v1beta1.CSIStorageCapacityList cSIStorageCapacityList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, ListOptions listOptions, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, io.fabric8.kubernetes.api.model.ObjectReference objectReference, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Status status, StorageClass storageClass, StorageClassList storageClassList, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.storage.CSIDriver v1CSIDriver, io.fabric8.kubernetes.api.model.storage.CSIDriverList v1CSIDriverList, io.fabric8.kubernetes.api.model.storage.CSINode v1CSINode, io.fabric8.kubernetes.api.model.storage.CSINodeList v1CSINodeList, io.fabric8.kubernetes.api.model.storage.CSIStorageCapacity v1CSIStorageCapacity, io.fabric8.kubernetes.api.model.storage.CSIStorageCapacityList v1CSIStorageCapacityList, VolumeAttachment volumeAttachment, VolumeAttachmentList volumeAttachmentList) {
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
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
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
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("ObjectReference")
    public io.fabric8.kubernetes.api.model.ObjectReference getObjectReference() {
        return objectReference;
    }

    @JsonProperty("ObjectReference")
    public void setObjectReference(io.fabric8.kubernetes.api.model.ObjectReference objectReference) {
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
