
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
    "Time",
    "TypeMeta",
    "UpdateOptions",
    "V1Beta1PriorityClass",
    "V1Beta1PriorityClassList",
    "V1PriorityClass",
    "V1PriorityClassList"
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
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonProperty("V1Beta1PriorityClass")
    private io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClass v1Beta1PriorityClass;
    @JsonProperty("V1Beta1PriorityClassList")
    private io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClassList v1Beta1PriorityClassList;
    @JsonProperty("V1PriorityClass")
    private io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass v1PriorityClass;
    @JsonProperty("V1PriorityClassList")
    private io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassList v1PriorityClassList;
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
     * @param patchOptions
     * @param deleteOptions
     * @param quantity
     * @param v1PriorityClassList
     * @param baseKubernetesList
     * @param updateOptions
     * @param objectReference
     * @param createOptions
     * @param patch
     * @param aPIGroup
     * @param typeMeta
     * @param v1Beta1PriorityClass
     * @param objectMeta
     * @param v1PriorityClass
     * @param v1Beta1PriorityClassList
     * @param rootPaths
     * @param getOptions
     * @param time
     * @param info
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, ListOptions listOptions, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, io.fabric8.kubernetes.api.model.ObjectReference objectReference, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClass v1Beta1PriorityClass, io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClassList v1Beta1PriorityClassList, io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass v1PriorityClass, io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassList v1PriorityClassList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
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
        this.time = time;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.v1Beta1PriorityClass = v1Beta1PriorityClass;
        this.v1Beta1PriorityClassList = v1Beta1PriorityClassList;
        this.v1PriorityClass = v1PriorityClass;
        this.v1PriorityClassList = v1PriorityClassList;
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

    @JsonProperty("V1Beta1PriorityClass")
    public io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClass getV1Beta1PriorityClass() {
        return v1Beta1PriorityClass;
    }

    @JsonProperty("V1Beta1PriorityClass")
    public void setV1Beta1PriorityClass(io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClass v1Beta1PriorityClass) {
        this.v1Beta1PriorityClass = v1Beta1PriorityClass;
    }

    @JsonProperty("V1Beta1PriorityClassList")
    public io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClassList getV1Beta1PriorityClassList() {
        return v1Beta1PriorityClassList;
    }

    @JsonProperty("V1Beta1PriorityClassList")
    public void setV1Beta1PriorityClassList(io.fabric8.kubernetes.api.model.scheduling.v1beta1.PriorityClassList v1Beta1PriorityClassList) {
        this.v1Beta1PriorityClassList = v1Beta1PriorityClassList;
    }

    @JsonProperty("V1PriorityClass")
    public io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass getV1PriorityClass() {
        return v1PriorityClass;
    }

    @JsonProperty("V1PriorityClass")
    public void setV1PriorityClass(io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClass v1PriorityClass) {
        this.v1PriorityClass = v1PriorityClass;
    }

    @JsonProperty("V1PriorityClassList")
    public io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassList getV1PriorityClassList() {
        return v1PriorityClassList;
    }

    @JsonProperty("V1PriorityClassList")
    public void setV1PriorityClassList(io.fabric8.kubernetes.api.model.scheduling.v1.PriorityClassList v1PriorityClassList) {
        this.v1PriorityClassList = v1PriorityClassList;
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
