
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicy;
import io.fabric8.kubernetes.api.model.networking.v1.NetworkPolicyList;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddress;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.IPAddressList;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ServiceCIDR;
import io.fabric8.kubernetes.api.model.networking.v1alpha1.ServiceCIDRList;
import io.fabric8.kubernetes.api.model.version.Info;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private CreateOptions createOptions;
    private DeleteOptions deleteOptions;
    private GetOptions getOptions;
    private Info info;
    private io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress ingress;
    private io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClass ingressClass;
    private io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClassList ingressClassList;
    private io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList ingressList;
    private ListOptions listOptions;
    private NetworkPolicy networkPolicy;
    private NetworkPolicyList networkPolicyList;
    private ObjectMeta objectMeta;
    private ObjectReference objectReference;
    private Patch patch;
    private PatchOptions patchOptions;
    private Quantity quantity;
    private RootPaths rootPaths;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    private IPAddress v1Alpha1IPAddress;
    private IPAddressList v1Alpha1IPAddressList;
    private ServiceCIDR v1Alpha1ServiceCIDR;
    private ServiceCIDRList v1Alpha1ServiceCIDRList;
    private io.fabric8.kubernetes.api.model.networking.v1.Ingress v1Ingress;
    private io.fabric8.kubernetes.api.model.networking.v1.IngressClass v1IngressClass;
    private io.fabric8.kubernetes.api.model.networking.v1.IngressClassList v1IngressClassList;
    private io.fabric8.kubernetes.api.model.networking.v1.IngressList v1IngressList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress ingress, io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClass ingressClass, io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClassList ingressClassList, io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList ingressList, ListOptions listOptions, NetworkPolicy networkPolicy, NetworkPolicyList networkPolicyList, ObjectMeta objectMeta, ObjectReference objectReference, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, IPAddress v1Alpha1IPAddress, IPAddressList v1Alpha1IPAddressList, ServiceCIDR v1Alpha1ServiceCIDR, ServiceCIDRList v1Alpha1ServiceCIDRList, io.fabric8.kubernetes.api.model.networking.v1.Ingress v1Ingress, io.fabric8.kubernetes.api.model.networking.v1.IngressClass v1IngressClass, io.fabric8.kubernetes.api.model.networking.v1.IngressClassList v1IngressClassList, io.fabric8.kubernetes.api.model.networking.v1.IngressList v1IngressList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.getOptions = getOptions;
        this.info = info;
        this.ingress = ingress;
        this.ingressClass = ingressClass;
        this.ingressClassList = ingressClassList;
        this.ingressList = ingressList;
        this.listOptions = listOptions;
        this.networkPolicy = networkPolicy;
        this.networkPolicyList = networkPolicyList;
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
        this.v1Alpha1IPAddress = v1Alpha1IPAddress;
        this.v1Alpha1IPAddressList = v1Alpha1IPAddressList;
        this.v1Alpha1ServiceCIDR = v1Alpha1ServiceCIDR;
        this.v1Alpha1ServiceCIDRList = v1Alpha1ServiceCIDRList;
        this.v1Ingress = v1Ingress;
        this.v1IngressClass = v1IngressClass;
        this.v1IngressClassList = v1IngressClassList;
        this.v1IngressList = v1IngressList;
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
    public io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress getIngress() {
        return ingress;
    }

    @JsonProperty("Ingress")
    public void setIngress(io.fabric8.kubernetes.api.model.networking.v1beta1.Ingress ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("IngressClass")
    public io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClass getIngressClass() {
        return ingressClass;
    }

    @JsonProperty("IngressClass")
    public void setIngressClass(io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClass ingressClass) {
        this.ingressClass = ingressClass;
    }

    @JsonProperty("IngressClassList")
    public io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClassList getIngressClassList() {
        return ingressClassList;
    }

    @JsonProperty("IngressClassList")
    public void setIngressClassList(io.fabric8.kubernetes.api.model.networking.v1beta1.IngressClassList ingressClassList) {
        this.ingressClassList = ingressClassList;
    }

    @JsonProperty("IngressList")
    public io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList getIngressList() {
        return ingressList;
    }

    @JsonProperty("IngressList")
    public void setIngressList(io.fabric8.kubernetes.api.model.networking.v1beta1.IngressList ingressList) {
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

    @JsonProperty("V1Alpha1IPAddress")
    public IPAddress getV1Alpha1IPAddress() {
        return v1Alpha1IPAddress;
    }

    @JsonProperty("V1Alpha1IPAddress")
    public void setV1Alpha1IPAddress(IPAddress v1Alpha1IPAddress) {
        this.v1Alpha1IPAddress = v1Alpha1IPAddress;
    }

    @JsonProperty("V1Alpha1IPAddressList")
    public IPAddressList getV1Alpha1IPAddressList() {
        return v1Alpha1IPAddressList;
    }

    @JsonProperty("V1Alpha1IPAddressList")
    public void setV1Alpha1IPAddressList(IPAddressList v1Alpha1IPAddressList) {
        this.v1Alpha1IPAddressList = v1Alpha1IPAddressList;
    }

    @JsonProperty("V1Alpha1ServiceCIDR")
    public ServiceCIDR getV1Alpha1ServiceCIDR() {
        return v1Alpha1ServiceCIDR;
    }

    @JsonProperty("V1Alpha1ServiceCIDR")
    public void setV1Alpha1ServiceCIDR(ServiceCIDR v1Alpha1ServiceCIDR) {
        this.v1Alpha1ServiceCIDR = v1Alpha1ServiceCIDR;
    }

    @JsonProperty("V1Alpha1ServiceCIDRList")
    public ServiceCIDRList getV1Alpha1ServiceCIDRList() {
        return v1Alpha1ServiceCIDRList;
    }

    @JsonProperty("V1Alpha1ServiceCIDRList")
    public void setV1Alpha1ServiceCIDRList(ServiceCIDRList v1Alpha1ServiceCIDRList) {
        this.v1Alpha1ServiceCIDRList = v1Alpha1ServiceCIDRList;
    }

    @JsonProperty("V1Ingress")
    public io.fabric8.kubernetes.api.model.networking.v1.Ingress getV1Ingress() {
        return v1Ingress;
    }

    @JsonProperty("V1Ingress")
    public void setV1Ingress(io.fabric8.kubernetes.api.model.networking.v1.Ingress v1Ingress) {
        this.v1Ingress = v1Ingress;
    }

    @JsonProperty("V1IngressClass")
    public io.fabric8.kubernetes.api.model.networking.v1.IngressClass getV1IngressClass() {
        return v1IngressClass;
    }

    @JsonProperty("V1IngressClass")
    public void setV1IngressClass(io.fabric8.kubernetes.api.model.networking.v1.IngressClass v1IngressClass) {
        this.v1IngressClass = v1IngressClass;
    }

    @JsonProperty("V1IngressClassList")
    public io.fabric8.kubernetes.api.model.networking.v1.IngressClassList getV1IngressClassList() {
        return v1IngressClassList;
    }

    @JsonProperty("V1IngressClassList")
    public void setV1IngressClassList(io.fabric8.kubernetes.api.model.networking.v1.IngressClassList v1IngressClassList) {
        this.v1IngressClassList = v1IngressClassList;
    }

    @JsonProperty("V1IngressList")
    public io.fabric8.kubernetes.api.model.networking.v1.IngressList getV1IngressList() {
        return v1IngressList;
    }

    @JsonProperty("V1IngressList")
    public void setV1IngressList(io.fabric8.kubernetes.api.model.networking.v1.IngressList v1IngressList) {
        this.v1IngressList = v1IngressList;
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
