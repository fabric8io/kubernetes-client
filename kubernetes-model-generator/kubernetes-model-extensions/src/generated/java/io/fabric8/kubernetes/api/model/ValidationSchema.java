
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
import io.fabric8.kubernetes.api.model.extensions.DaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetList;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.DeploymentRollback;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressList;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicy;
import io.fabric8.kubernetes.api.model.extensions.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
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
    "DaemonSet",
    "DaemonSetList",
    "DeleteOptions",
    "Deployment",
    "DeploymentList",
    "DeploymentRollback",
    "GetOptions",
    "Info",
    "Ingress",
    "IngressList",
    "ListOptions",
    "NetworkPolicy",
    "NetworkPolicyList",
    "ObjectMeta",
    "ObjectReference",
    "Patch",
    "PatchOptions",
    "Quantity",
    "ReplicaSet",
    "ReplicaSetList",
    "RootPaths",
    "Status",
    "Time",
    "TypeMeta",
    "UpdateOptions"
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
    @JsonProperty("DaemonSet")
    private DaemonSet daemonSet;
    @JsonProperty("DaemonSetList")
    private DaemonSetList daemonSetList;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("Deployment")
    private Deployment deployment;
    @JsonProperty("DeploymentList")
    private DeploymentList deploymentList;
    @JsonProperty("DeploymentRollback")
    private DeploymentRollback deploymentRollback;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("Ingress")
    private Ingress ingress;
    @JsonProperty("IngressList")
    private IngressList ingressList;
    @JsonProperty("ListOptions")
    private ListOptions listOptions;
    @JsonProperty("NetworkPolicy")
    private NetworkPolicy networkPolicy;
    @JsonProperty("NetworkPolicyList")
    private NetworkPolicyList networkPolicyList;
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
    @JsonProperty("ReplicaSet")
    private ReplicaSet replicaSet;
    @JsonProperty("ReplicaSetList")
    private ReplicaSetList replicaSetList;
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
     * @param deploymentRollback
     * @param listOptions
     * @param aPIGroupList
     * @param ingressList
     * @param baseKubernetesList
     * @param updateOptions
     * @param daemonSet
     * @param daemonSetList
     * @param patch
     * @param rootPaths
     * @param replicaSetList
     * @param deployment
     * @param info
     * @param patchOptions
     * @param deleteOptions
     * @param quantity
     * @param networkPolicyList
     * @param networkPolicy
     * @param deploymentList
     * @param objectReference
     * @param replicaSet
     * @param createOptions
     * @param aPIGroup
     * @param ingress
     * @param typeMeta
     * @param objectMeta
     * @param getOptions
     * @param time
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, CreateOptions createOptions, DaemonSet daemonSet, DaemonSetList daemonSetList, DeleteOptions deleteOptions, Deployment deployment, DeploymentList deploymentList, DeploymentRollback deploymentRollback, GetOptions getOptions, Info info, Ingress ingress, IngressList ingressList, ListOptions listOptions, NetworkPolicy networkPolicy, NetworkPolicyList networkPolicyList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, io.fabric8.kubernetes.api.model.ObjectReference objectReference, Patch patch, PatchOptions patchOptions, Quantity quantity, ReplicaSet replicaSet, ReplicaSetList replicaSetList, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.daemonSet = daemonSet;
        this.daemonSetList = daemonSetList;
        this.deleteOptions = deleteOptions;
        this.deployment = deployment;
        this.deploymentList = deploymentList;
        this.deploymentRollback = deploymentRollback;
        this.getOptions = getOptions;
        this.info = info;
        this.ingress = ingress;
        this.ingressList = ingressList;
        this.listOptions = listOptions;
        this.networkPolicy = networkPolicy;
        this.networkPolicyList = networkPolicyList;
        this.objectMeta = objectMeta;
        this.objectReference = objectReference;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.quantity = quantity;
        this.replicaSet = replicaSet;
        this.replicaSetList = replicaSetList;
        this.rootPaths = rootPaths;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
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

    @JsonProperty("DaemonSet")
    public DaemonSet getDaemonSet() {
        return daemonSet;
    }

    @JsonProperty("DaemonSet")
    public void setDaemonSet(DaemonSet daemonSet) {
        this.daemonSet = daemonSet;
    }

    @JsonProperty("DaemonSetList")
    public DaemonSetList getDaemonSetList() {
        return daemonSetList;
    }

    @JsonProperty("DaemonSetList")
    public void setDaemonSetList(DaemonSetList daemonSetList) {
        this.daemonSetList = daemonSetList;
    }

    @JsonProperty("DeleteOptions")
    public DeleteOptions getDeleteOptions() {
        return deleteOptions;
    }

    @JsonProperty("DeleteOptions")
    public void setDeleteOptions(DeleteOptions deleteOptions) {
        this.deleteOptions = deleteOptions;
    }

    @JsonProperty("Deployment")
    public Deployment getDeployment() {
        return deployment;
    }

    @JsonProperty("Deployment")
    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }

    @JsonProperty("DeploymentList")
    public DeploymentList getDeploymentList() {
        return deploymentList;
    }

    @JsonProperty("DeploymentList")
    public void setDeploymentList(DeploymentList deploymentList) {
        this.deploymentList = deploymentList;
    }

    @JsonProperty("DeploymentRollback")
    public DeploymentRollback getDeploymentRollback() {
        return deploymentRollback;
    }

    @JsonProperty("DeploymentRollback")
    public void setDeploymentRollback(DeploymentRollback deploymentRollback) {
        this.deploymentRollback = deploymentRollback;
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

    @JsonProperty("Ingress")
    public Ingress getIngress() {
        return ingress;
    }

    @JsonProperty("Ingress")
    public void setIngress(Ingress ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("IngressList")
    public IngressList getIngressList() {
        return ingressList;
    }

    @JsonProperty("IngressList")
    public void setIngressList(IngressList ingressList) {
        this.ingressList = ingressList;
    }

    @JsonProperty("ListOptions")
    public ListOptions getListOptions() {
        return listOptions;
    }

    @JsonProperty("ListOptions")
    public void setListOptions(ListOptions listOptions) {
        this.listOptions = listOptions;
    }

    @JsonProperty("NetworkPolicy")
    public NetworkPolicy getNetworkPolicy() {
        return networkPolicy;
    }

    @JsonProperty("NetworkPolicy")
    public void setNetworkPolicy(NetworkPolicy networkPolicy) {
        this.networkPolicy = networkPolicy;
    }

    @JsonProperty("NetworkPolicyList")
    public NetworkPolicyList getNetworkPolicyList() {
        return networkPolicyList;
    }

    @JsonProperty("NetworkPolicyList")
    public void setNetworkPolicyList(NetworkPolicyList networkPolicyList) {
        this.networkPolicyList = networkPolicyList;
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

    @JsonProperty("ReplicaSet")
    public ReplicaSet getReplicaSet() {
        return replicaSet;
    }

    @JsonProperty("ReplicaSet")
    public void setReplicaSet(ReplicaSet replicaSet) {
        this.replicaSet = replicaSet;
    }

    @JsonProperty("ReplicaSetList")
    public ReplicaSetList getReplicaSetList() {
        return replicaSetList;
    }

    @JsonProperty("ReplicaSetList")
    public void setReplicaSetList(ReplicaSetList replicaSetList) {
        this.replicaSetList = replicaSetList;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
