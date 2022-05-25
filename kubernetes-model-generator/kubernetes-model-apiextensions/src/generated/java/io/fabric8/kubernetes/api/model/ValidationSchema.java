
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
import io.fabric8.kubernetes.api.model.apiextensions.v1.ConversionReview;
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
    "CustomResourceDefinition",
    "CustomResourceDefinitionCondition",
    "CustomResourceDefinitionList",
    "CustomResourceDefinitionNames",
    "CustomResourceDefinitionSpec",
    "CustomResourceDefinitionStatus",
    "DeleteOptions",
    "GetOptions",
    "Info",
    "JSONSchemaPropsOrStringArray",
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
    "V1ConversionReview",
    "V1CustomResourceDefinition",
    "V1CustomResourceDefinitionCondition",
    "V1CustomResourceDefinitionList",
    "V1CustomResourceDefinitionNames",
    "V1CustomResourceDefinitionSpec",
    "V1CustomResourceDefinitionStatus",
    "V1JSONSchemaPropsOrStringArray"
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
    @JsonProperty("CustomResourceDefinition")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition customResourceDefinition;
    @JsonProperty("CustomResourceDefinitionCondition")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionCondition customResourceDefinitionCondition;
    @JsonProperty("CustomResourceDefinitionList")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList customResourceDefinitionList;
    @JsonProperty("CustomResourceDefinitionNames")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionNames customResourceDefinitionNames;
    @JsonProperty("CustomResourceDefinitionSpec")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpec customResourceDefinitionSpec;
    @JsonProperty("CustomResourceDefinitionStatus")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionStatus customResourceDefinitionStatus;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("JSONSchemaPropsOrStringArray")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray jSONSchemaPropsOrStringArray;
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
    @JsonProperty("V1ConversionReview")
    private ConversionReview v1ConversionReview;
    @JsonProperty("V1CustomResourceDefinition")
    private io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition v1CustomResourceDefinition;
    @JsonProperty("V1CustomResourceDefinitionCondition")
    private io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionCondition v1CustomResourceDefinitionCondition;
    @JsonProperty("V1CustomResourceDefinitionList")
    private io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList v1CustomResourceDefinitionList;
    @JsonProperty("V1CustomResourceDefinitionNames")
    private io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames v1CustomResourceDefinitionNames;
    @JsonProperty("V1CustomResourceDefinitionSpec")
    private io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec v1CustomResourceDefinitionSpec;
    @JsonProperty("V1CustomResourceDefinitionStatus")
    private io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionStatus v1CustomResourceDefinitionStatus;
    @JsonProperty("V1JSONSchemaPropsOrStringArray")
    private io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray v1JSONSchemaPropsOrStringArray;
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
     * @param baseKubernetesList
     * @param customResourceDefinitionSpec
     * @param updateOptions
     * @param v1CustomResourceDefinitionList
     * @param v1JSONSchemaPropsOrStringArray
     * @param v1CustomResourceDefinitionCondition
     * @param patch
     * @param v1CustomResourceDefinition
     * @param customResourceDefinition
     * @param v1CustomResourceDefinitionNames
     * @param rootPaths
     * @param info
     * @param patchOptions
     * @param deleteOptions
     * @param quantity
     * @param objectReference
     * @param jSONSchemaPropsOrStringArray
     * @param v1CustomResourceDefinitionStatus
     * @param v1ConversionReview
     * @param v1CustomResourceDefinitionSpec
     * @param createOptions
     * @param aPIGroup
     * @param customResourceDefinitionList
     * @param customResourceDefinitionNames
     * @param typeMeta
     * @param customResourceDefinitionCondition
     * @param objectMeta
     * @param customResourceDefinitionStatus
     * @param getOptions
     * @param time
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, CreateOptions createOptions, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition customResourceDefinition, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionCondition customResourceDefinitionCondition, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList customResourceDefinitionList, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionNames customResourceDefinitionNames, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpec customResourceDefinitionSpec, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionStatus customResourceDefinitionStatus, DeleteOptions deleteOptions, GetOptions getOptions, Info info, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray jSONSchemaPropsOrStringArray, ListOptions listOptions, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, io.fabric8.kubernetes.api.model.ObjectReference objectReference, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, ConversionReview v1ConversionReview, io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition v1CustomResourceDefinition, io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionCondition v1CustomResourceDefinitionCondition, io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList v1CustomResourceDefinitionList, io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames v1CustomResourceDefinitionNames, io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec v1CustomResourceDefinitionSpec, io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionStatus v1CustomResourceDefinitionStatus, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray v1JSONSchemaPropsOrStringArray) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.customResourceDefinition = customResourceDefinition;
        this.customResourceDefinitionCondition = customResourceDefinitionCondition;
        this.customResourceDefinitionList = customResourceDefinitionList;
        this.customResourceDefinitionNames = customResourceDefinitionNames;
        this.customResourceDefinitionSpec = customResourceDefinitionSpec;
        this.customResourceDefinitionStatus = customResourceDefinitionStatus;
        this.deleteOptions = deleteOptions;
        this.getOptions = getOptions;
        this.info = info;
        this.jSONSchemaPropsOrStringArray = jSONSchemaPropsOrStringArray;
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
        this.v1ConversionReview = v1ConversionReview;
        this.v1CustomResourceDefinition = v1CustomResourceDefinition;
        this.v1CustomResourceDefinitionCondition = v1CustomResourceDefinitionCondition;
        this.v1CustomResourceDefinitionList = v1CustomResourceDefinitionList;
        this.v1CustomResourceDefinitionNames = v1CustomResourceDefinitionNames;
        this.v1CustomResourceDefinitionSpec = v1CustomResourceDefinitionSpec;
        this.v1CustomResourceDefinitionStatus = v1CustomResourceDefinitionStatus;
        this.v1JSONSchemaPropsOrStringArray = v1JSONSchemaPropsOrStringArray;
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

    @JsonProperty("CustomResourceDefinition")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition getCustomResourceDefinition() {
        return customResourceDefinition;
    }

    @JsonProperty("CustomResourceDefinition")
    public void setCustomResourceDefinition(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition customResourceDefinition) {
        this.customResourceDefinition = customResourceDefinition;
    }

    @JsonProperty("CustomResourceDefinitionCondition")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionCondition getCustomResourceDefinitionCondition() {
        return customResourceDefinitionCondition;
    }

    @JsonProperty("CustomResourceDefinitionCondition")
    public void setCustomResourceDefinitionCondition(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionCondition customResourceDefinitionCondition) {
        this.customResourceDefinitionCondition = customResourceDefinitionCondition;
    }

    @JsonProperty("CustomResourceDefinitionList")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList getCustomResourceDefinitionList() {
        return customResourceDefinitionList;
    }

    @JsonProperty("CustomResourceDefinitionList")
    public void setCustomResourceDefinitionList(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList customResourceDefinitionList) {
        this.customResourceDefinitionList = customResourceDefinitionList;
    }

    @JsonProperty("CustomResourceDefinitionNames")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionNames getCustomResourceDefinitionNames() {
        return customResourceDefinitionNames;
    }

    @JsonProperty("CustomResourceDefinitionNames")
    public void setCustomResourceDefinitionNames(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionNames customResourceDefinitionNames) {
        this.customResourceDefinitionNames = customResourceDefinitionNames;
    }

    @JsonProperty("CustomResourceDefinitionSpec")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpec getCustomResourceDefinitionSpec() {
        return customResourceDefinitionSpec;
    }

    @JsonProperty("CustomResourceDefinitionSpec")
    public void setCustomResourceDefinitionSpec(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionSpec customResourceDefinitionSpec) {
        this.customResourceDefinitionSpec = customResourceDefinitionSpec;
    }

    @JsonProperty("CustomResourceDefinitionStatus")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionStatus getCustomResourceDefinitionStatus() {
        return customResourceDefinitionStatus;
    }

    @JsonProperty("CustomResourceDefinitionStatus")
    public void setCustomResourceDefinitionStatus(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionStatus customResourceDefinitionStatus) {
        this.customResourceDefinitionStatus = customResourceDefinitionStatus;
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

    @JsonProperty("JSONSchemaPropsOrStringArray")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray getJSONSchemaPropsOrStringArray() {
        return jSONSchemaPropsOrStringArray;
    }

    @JsonProperty("JSONSchemaPropsOrStringArray")
    public void setJSONSchemaPropsOrStringArray(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaPropsOrStringArray jSONSchemaPropsOrStringArray) {
        this.jSONSchemaPropsOrStringArray = jSONSchemaPropsOrStringArray;
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

    @JsonProperty("V1ConversionReview")
    public ConversionReview getV1ConversionReview() {
        return v1ConversionReview;
    }

    @JsonProperty("V1ConversionReview")
    public void setV1ConversionReview(ConversionReview v1ConversionReview) {
        this.v1ConversionReview = v1ConversionReview;
    }

    @JsonProperty("V1CustomResourceDefinition")
    public io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition getV1CustomResourceDefinition() {
        return v1CustomResourceDefinition;
    }

    @JsonProperty("V1CustomResourceDefinition")
    public void setV1CustomResourceDefinition(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition v1CustomResourceDefinition) {
        this.v1CustomResourceDefinition = v1CustomResourceDefinition;
    }

    @JsonProperty("V1CustomResourceDefinitionCondition")
    public io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionCondition getV1CustomResourceDefinitionCondition() {
        return v1CustomResourceDefinitionCondition;
    }

    @JsonProperty("V1CustomResourceDefinitionCondition")
    public void setV1CustomResourceDefinitionCondition(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionCondition v1CustomResourceDefinitionCondition) {
        this.v1CustomResourceDefinitionCondition = v1CustomResourceDefinitionCondition;
    }

    @JsonProperty("V1CustomResourceDefinitionList")
    public io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList getV1CustomResourceDefinitionList() {
        return v1CustomResourceDefinitionList;
    }

    @JsonProperty("V1CustomResourceDefinitionList")
    public void setV1CustomResourceDefinitionList(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionList v1CustomResourceDefinitionList) {
        this.v1CustomResourceDefinitionList = v1CustomResourceDefinitionList;
    }

    @JsonProperty("V1CustomResourceDefinitionNames")
    public io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames getV1CustomResourceDefinitionNames() {
        return v1CustomResourceDefinitionNames;
    }

    @JsonProperty("V1CustomResourceDefinitionNames")
    public void setV1CustomResourceDefinitionNames(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames v1CustomResourceDefinitionNames) {
        this.v1CustomResourceDefinitionNames = v1CustomResourceDefinitionNames;
    }

    @JsonProperty("V1CustomResourceDefinitionSpec")
    public io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec getV1CustomResourceDefinitionSpec() {
        return v1CustomResourceDefinitionSpec;
    }

    @JsonProperty("V1CustomResourceDefinitionSpec")
    public void setV1CustomResourceDefinitionSpec(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec v1CustomResourceDefinitionSpec) {
        this.v1CustomResourceDefinitionSpec = v1CustomResourceDefinitionSpec;
    }

    @JsonProperty("V1CustomResourceDefinitionStatus")
    public io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionStatus getV1CustomResourceDefinitionStatus() {
        return v1CustomResourceDefinitionStatus;
    }

    @JsonProperty("V1CustomResourceDefinitionStatus")
    public void setV1CustomResourceDefinitionStatus(io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionStatus v1CustomResourceDefinitionStatus) {
        this.v1CustomResourceDefinitionStatus = v1CustomResourceDefinitionStatus;
    }

    @JsonProperty("V1JSONSchemaPropsOrStringArray")
    public io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray getV1JSONSchemaPropsOrStringArray() {
        return v1JSONSchemaPropsOrStringArray;
    }

    @JsonProperty("V1JSONSchemaPropsOrStringArray")
    public void setV1JSONSchemaPropsOrStringArray(io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsOrStringArray v1JSONSchemaPropsOrStringArray) {
        this.v1JSONSchemaPropsOrStringArray = v1JSONSchemaPropsOrStringArray;
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
