
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
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyList;
import io.fabric8.kubernetes.api.model.policy.v1beta1.RunAsUserStrategyOptions;
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
    "Eviction",
    "GetOptions",
    "Info",
    "KubernetesRunAsUserStrategyOptions",
    "ListOptions",
    "ObjectMeta",
    "ObjectReference",
    "Patch",
    "PatchOptions",
    "PodDisruptionBudget",
    "PodDisruptionBudgetList",
    "PodSecurityPolicy",
    "PodSecurityPolicyList",
    "Quantity",
    "RootPaths",
    "Status",
    "Time",
    "TypeMeta",
    "UpdateOptions",
    "V1Eviction",
    "V1PodDisruptionBudget",
    "V1PodDisruptionBudgetList"
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
    @JsonProperty("Eviction")
    private io.fabric8.kubernetes.api.model.policy.v1beta1.Eviction eviction;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("KubernetesRunAsUserStrategyOptions")
    private RunAsUserStrategyOptions kubernetesRunAsUserStrategyOptions;
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
    @JsonProperty("PodDisruptionBudget")
    private io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget podDisruptionBudget;
    @JsonProperty("PodDisruptionBudgetList")
    private io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList podDisruptionBudgetList;
    @JsonProperty("PodSecurityPolicy")
    private PodSecurityPolicy podSecurityPolicy;
    @JsonProperty("PodSecurityPolicyList")
    private PodSecurityPolicyList podSecurityPolicyList;
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
    @JsonProperty("V1Eviction")
    private io.fabric8.kubernetes.api.model.policy.v1.Eviction v1Eviction;
    @JsonProperty("V1PodDisruptionBudget")
    private io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudget v1PodDisruptionBudget;
    @JsonProperty("V1PodDisruptionBudgetList")
    private io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudgetList v1PodDisruptionBudgetList;
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
     * @param podDisruptionBudgetList
     * @param baseKubernetesList
     * @param updateOptions
     * @param kubernetesRunAsUserStrategyOptions
     * @param patch
     * @param eviction
     * @param v1PodDisruptionBudget
     * @param v1PodDisruptionBudgetList
     * @param podDisruptionBudget
     * @param rootPaths
     * @param info
     * @param v1Eviction
     * @param patchOptions
     * @param deleteOptions
     * @param quantity
     * @param objectReference
     * @param createOptions
     * @param aPIGroup
     * @param typeMeta
     * @param objectMeta
     * @param getOptions
     * @param time
     * @param podSecurityPolicy
     * @param podSecurityPolicyList
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, io.fabric8.kubernetes.api.model.policy.v1beta1.Eviction eviction, GetOptions getOptions, Info info, RunAsUserStrategyOptions kubernetesRunAsUserStrategyOptions, ListOptions listOptions, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, io.fabric8.kubernetes.api.model.ObjectReference objectReference, Patch patch, PatchOptions patchOptions, io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget podDisruptionBudget, io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetList podDisruptionBudgetList, PodSecurityPolicy podSecurityPolicy, PodSecurityPolicyList podSecurityPolicyList, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.policy.v1.Eviction v1Eviction, io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudget v1PodDisruptionBudget, io.fabric8.kubernetes.api.model.policy.v1.PodDisruptionBudgetList v1PodDisruptionBudgetList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.eviction = eviction;
        this.getOptions = getOptions;
        this.info = info;
        this.kubernetesRunAsUserStrategyOptions = kubernetesRunAsUserStrategyOptions;
        this.listOptions = listOptions;
        this.objectMeta = objectMeta;
        this.objectReference = objectReference;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.podDisruptionBudget = podDisruptionBudget;
        this.podDisruptionBudgetList = podDisruptionBudgetList;
        this.podSecurityPolicy = podSecurityPolicy;
        this.podSecurityPolicyList = podSecurityPolicyList;
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

    @JsonProperty("KubernetesRunAsUserStrategyOptions")
    public RunAsUserStrategyOptions getKubernetesRunAsUserStrategyOptions() {
        return kubernetesRunAsUserStrategyOptions;
    }

    @JsonProperty("KubernetesRunAsUserStrategyOptions")
    public void setKubernetesRunAsUserStrategyOptions(RunAsUserStrategyOptions kubernetesRunAsUserStrategyOptions) {
        this.kubernetesRunAsUserStrategyOptions = kubernetesRunAsUserStrategyOptions;
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

    @JsonProperty("PodSecurityPolicy")
    public PodSecurityPolicy getPodSecurityPolicy() {
        return podSecurityPolicy;
    }

    @JsonProperty("PodSecurityPolicy")
    public void setPodSecurityPolicy(PodSecurityPolicy podSecurityPolicy) {
        this.podSecurityPolicy = podSecurityPolicy;
    }

    @JsonProperty("PodSecurityPolicyList")
    public PodSecurityPolicyList getPodSecurityPolicyList() {
        return podSecurityPolicyList;
    }

    @JsonProperty("PodSecurityPolicyList")
    public void setPodSecurityPolicyList(PodSecurityPolicyList podSecurityPolicyList) {
        this.podSecurityPolicyList = podSecurityPolicyList;
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
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
