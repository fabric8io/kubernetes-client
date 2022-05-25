
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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
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
    "Patch",
    "PatchOptions",
    "Quantity",
    "RootPaths",
    "Scale",
    "Status",
    "Time",
    "TypeMeta",
    "UpdateOptions",
    "V1HorizontalPodAutoscaler",
    "V1HorizontalPodAutoscalerList",
    "V2beta1HorizontalPodAutoscaler",
    "V2beta1HorizontalPodAutoscalerList",
    "V2beta2HorizontalPodAutoscaler",
    "V2beta2HorizontalPodAutoscalerList"
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
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("PatchOptions")
    private PatchOptions patchOptions;
    @JsonProperty("Quantity")
    private Quantity quantity;
    @JsonProperty("RootPaths")
    private RootPaths rootPaths;
    @JsonProperty("Scale")
    private Scale scale;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonProperty("V1HorizontalPodAutoscaler")
    private io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler v1HorizontalPodAutoscaler;
    @JsonProperty("V1HorizontalPodAutoscalerList")
    private io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerList v1HorizontalPodAutoscalerList;
    @JsonProperty("V2beta1HorizontalPodAutoscaler")
    private io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscaler v2beta1HorizontalPodAutoscaler;
    @JsonProperty("V2beta1HorizontalPodAutoscalerList")
    private io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscalerList v2beta1HorizontalPodAutoscalerList;
    @JsonProperty("V2beta2HorizontalPodAutoscaler")
    private io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler v2beta2HorizontalPodAutoscaler;
    @JsonProperty("V2beta2HorizontalPodAutoscalerList")
    private io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerList v2beta2HorizontalPodAutoscalerList;
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
     * @param v1HorizontalPodAutoscalerList
     * @param aPIGroupList
     * @param patchOptions
     * @param deleteOptions
     * @param quantity
     * @param v2beta2HorizontalPodAutoscalerList
     * @param baseKubernetesList
     * @param scale
     * @param updateOptions
     * @param v1HorizontalPodAutoscaler
     * @param createOptions
     * @param patch
     * @param aPIGroup
     * @param typeMeta
     * @param v2beta1HorizontalPodAutoscalerList
     * @param v2beta2HorizontalPodAutoscaler
     * @param v2beta1HorizontalPodAutoscaler
     * @param objectMeta
     * @param rootPaths
     * @param getOptions
     * @param time
     * @param info
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, ListOptions listOptions, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Scale scale, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler v1HorizontalPodAutoscaler, io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerList v1HorizontalPodAutoscalerList, io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscaler v2beta1HorizontalPodAutoscaler, io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscalerList v2beta1HorizontalPodAutoscalerList, io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler v2beta2HorizontalPodAutoscaler, io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerList v2beta2HorizontalPodAutoscalerList) {
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
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.quantity = quantity;
        this.rootPaths = rootPaths;
        this.scale = scale;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.v1HorizontalPodAutoscaler = v1HorizontalPodAutoscaler;
        this.v1HorizontalPodAutoscalerList = v1HorizontalPodAutoscalerList;
        this.v2beta1HorizontalPodAutoscaler = v2beta1HorizontalPodAutoscaler;
        this.v2beta1HorizontalPodAutoscalerList = v2beta1HorizontalPodAutoscalerList;
        this.v2beta2HorizontalPodAutoscaler = v2beta2HorizontalPodAutoscaler;
        this.v2beta2HorizontalPodAutoscalerList = v2beta2HorizontalPodAutoscalerList;
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

    @JsonProperty("Scale")
    public Scale getScale() {
        return scale;
    }

    @JsonProperty("Scale")
    public void setScale(Scale scale) {
        this.scale = scale;
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

    @JsonProperty("V1HorizontalPodAutoscaler")
    public io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler getV1HorizontalPodAutoscaler() {
        return v1HorizontalPodAutoscaler;
    }

    @JsonProperty("V1HorizontalPodAutoscaler")
    public void setV1HorizontalPodAutoscaler(io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscaler v1HorizontalPodAutoscaler) {
        this.v1HorizontalPodAutoscaler = v1HorizontalPodAutoscaler;
    }

    @JsonProperty("V1HorizontalPodAutoscalerList")
    public io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerList getV1HorizontalPodAutoscalerList() {
        return v1HorizontalPodAutoscalerList;
    }

    @JsonProperty("V1HorizontalPodAutoscalerList")
    public void setV1HorizontalPodAutoscalerList(io.fabric8.kubernetes.api.model.autoscaling.v1.HorizontalPodAutoscalerList v1HorizontalPodAutoscalerList) {
        this.v1HorizontalPodAutoscalerList = v1HorizontalPodAutoscalerList;
    }

    @JsonProperty("V2beta1HorizontalPodAutoscaler")
    public io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscaler getV2beta1HorizontalPodAutoscaler() {
        return v2beta1HorizontalPodAutoscaler;
    }

    @JsonProperty("V2beta1HorizontalPodAutoscaler")
    public void setV2beta1HorizontalPodAutoscaler(io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscaler v2beta1HorizontalPodAutoscaler) {
        this.v2beta1HorizontalPodAutoscaler = v2beta1HorizontalPodAutoscaler;
    }

    @JsonProperty("V2beta1HorizontalPodAutoscalerList")
    public io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscalerList getV2beta1HorizontalPodAutoscalerList() {
        return v2beta1HorizontalPodAutoscalerList;
    }

    @JsonProperty("V2beta1HorizontalPodAutoscalerList")
    public void setV2beta1HorizontalPodAutoscalerList(io.fabric8.kubernetes.api.model.autoscaling.v2beta1.HorizontalPodAutoscalerList v2beta1HorizontalPodAutoscalerList) {
        this.v2beta1HorizontalPodAutoscalerList = v2beta1HorizontalPodAutoscalerList;
    }

    @JsonProperty("V2beta2HorizontalPodAutoscaler")
    public io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler getV2beta2HorizontalPodAutoscaler() {
        return v2beta2HorizontalPodAutoscaler;
    }

    @JsonProperty("V2beta2HorizontalPodAutoscaler")
    public void setV2beta2HorizontalPodAutoscaler(io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscaler v2beta2HorizontalPodAutoscaler) {
        this.v2beta2HorizontalPodAutoscaler = v2beta2HorizontalPodAutoscaler;
    }

    @JsonProperty("V2beta2HorizontalPodAutoscalerList")
    public io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerList getV2beta2HorizontalPodAutoscalerList() {
        return v2beta2HorizontalPodAutoscalerList;
    }

    @JsonProperty("V2beta2HorizontalPodAutoscalerList")
    public void setV2beta2HorizontalPodAutoscalerList(io.fabric8.kubernetes.api.model.autoscaling.v2beta2.HorizontalPodAutoscalerList v2beta2HorizontalPodAutoscalerList) {
        this.v2beta2HorizontalPodAutoscalerList = v2beta2HorizontalPodAutoscalerList;
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
