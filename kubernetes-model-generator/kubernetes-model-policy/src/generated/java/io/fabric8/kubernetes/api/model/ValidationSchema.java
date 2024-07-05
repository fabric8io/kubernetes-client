
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private CreateOptions createOptions;
    private DeleteOptions deleteOptions;
    private io.fabric8.kubernetes.api.model.policy.v1beta1.Eviction eviction;
    private GetOptions getOptions;
    private Info info;
    private ListOptions listOptions;
    private ObjectMeta objectMeta;
    private ObjectReference objectReference;
    private Patch patch;
    private PatchOptions patchOptions;
    private io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget podDisruptionBudget;
    private io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList podDisruptionBudgetList;
    private Quantity quantity;
    private RootPaths rootPaths;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    private io.fabric8.kubernetes.api.model.policy.v1.Eviction v1Eviction;
    private io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudget v1PodDisruptionBudget;
    private io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudgetList v1PodDisruptionBudgetList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, io.fabric8.kubernetes.api.model.policy.v1beta1.Eviction eviction, GetOptions getOptions, Info info, ListOptions listOptions, ObjectMeta objectMeta, ObjectReference objectReference, Patch patch, PatchOptions patchOptions, io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget podDisruptionBudget, io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList podDisruptionBudgetList, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.policy.v1.Eviction v1Eviction, io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudget v1PodDisruptionBudget, io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudgetList v1PodDisruptionBudgetList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.eviction = eviction;
        this.getOptions = getOptions;
        this.info = info;
        this.listOptions = listOptions;
        this.objectMeta = objectMeta;
        this.objectReference = objectReference;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.podDisruptionBudget = podDisruptionBudget;
        this.podDisruptionBudgetList = podDisruptionBudgetList;
        this.quantity = quantity;
        this.rootPaths = rootPaths;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.v1Eviction = v1Eviction;
        this.v1PodDisruptionBudget = v1PodDisruptionBudget;
        this.v1PodDisruptionBudgetList = v1PodDisruptionBudgetList;
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

    @JsonProperty("Eviction")
    public io.fabric8.kubernetes.api.model.policy.v1beta1.Eviction getEviction() {
        return eviction;
    }

    @JsonProperty("Eviction")
    public void setEviction(io.fabric8.kubernetes.api.model.policy.v1beta1.Eviction eviction) {
        this.eviction = eviction;
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

    @JsonProperty("PodDisruptionBudget")
    public io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget getPodDisruptionBudget() {
        return podDisruptionBudget;
    }

    @JsonProperty("PodDisruptionBudget")
    public void setPodDisruptionBudget(io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget podDisruptionBudget) {
        this.podDisruptionBudget = podDisruptionBudget;
    }

    @JsonProperty("PodDisruptionBudgetList")
    public io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList getPodDisruptionBudgetList() {
        return podDisruptionBudgetList;
    }

    @JsonProperty("PodDisruptionBudgetList")
    public void setPodDisruptionBudgetList(io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList podDisruptionBudgetList) {
        this.podDisruptionBudgetList = podDisruptionBudgetList;
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

    @JsonProperty("V1Eviction")
    public io.fabric8.kubernetes.api.model.policy.v1.Eviction getV1Eviction() {
        return v1Eviction;
    }

    @JsonProperty("V1Eviction")
    public void setV1Eviction(io.fabric8.kubernetes.api.model.policy.v1.Eviction v1Eviction) {
        this.v1Eviction = v1Eviction;
    }

    @JsonProperty("V1PodDisruptionBudget")
    public io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudget getV1PodDisruptionBudget() {
        return v1PodDisruptionBudget;
    }

    @JsonProperty("V1PodDisruptionBudget")
    public void setV1PodDisruptionBudget(io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudget v1PodDisruptionBudget) {
        this.v1PodDisruptionBudget = v1PodDisruptionBudget;
    }

    @JsonProperty("V1PodDisruptionBudgetList")
    public io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudgetList getV1PodDisruptionBudgetList() {
        return v1PodDisruptionBudgetList;
    }

    @JsonProperty("V1PodDisruptionBudgetList")
    public void setV1PodDisruptionBudgetList(io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudgetList v1PodDisruptionBudgetList) {
        this.v1PodDisruptionBudgetList = v1PodDisruptionBudgetList;
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
