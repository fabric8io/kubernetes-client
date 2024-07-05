
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetrics;
import io.fabric8.kubernetes.api.model.metrics.v1beta1.PodMetricsList;
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
    private ListOptions listOptions;
    private NodeMetrics nodeMetrics;
    private NodeMetricsList nodeMetricsList;
    private ObjectMeta objectMeta;
    private ObjectReference objectReference;
    private Patch patch;
    private PatchOptions patchOptions;
    private PodMetrics podMetrics;
    private PodMetricsList podMetricsList;
    private Quantity quantity;
    private RootPaths rootPaths;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, ListOptions listOptions, NodeMetrics nodeMetrics, NodeMetricsList nodeMetricsList, ObjectMeta objectMeta, ObjectReference objectReference, Patch patch, PatchOptions patchOptions, PodMetrics podMetrics, PodMetricsList podMetricsList, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.getOptions = getOptions;
        this.info = info;
        this.listOptions = listOptions;
        this.nodeMetrics = nodeMetrics;
        this.nodeMetricsList = nodeMetricsList;
        this.objectMeta = objectMeta;
        this.objectReference = objectReference;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.podMetrics = podMetrics;
        this.podMetricsList = podMetricsList;
        this.quantity = quantity;
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

    @JsonProperty("ListOptions")
    public ListOptions getListOptions() {
        return listOptions;
    }

    @JsonProperty("ListOptions")
    public void setListOptions(ListOptions listOptions) {
        this.listOptions = listOptions;
    }

    @JsonProperty("NodeMetrics")
    public NodeMetrics getNodeMetrics() {
        return nodeMetrics;
    }

    @JsonProperty("NodeMetrics")
    public void setNodeMetrics(NodeMetrics nodeMetrics) {
        this.nodeMetrics = nodeMetrics;
    }

    @JsonProperty("NodeMetricsList")
    public NodeMetricsList getNodeMetricsList() {
        return nodeMetricsList;
    }

    @JsonProperty("NodeMetricsList")
    public void setNodeMetricsList(NodeMetricsList nodeMetricsList) {
        this.nodeMetricsList = nodeMetricsList;
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

    @JsonProperty("PodMetrics")
    public PodMetrics getPodMetrics() {
        return podMetrics;
    }

    @JsonProperty("PodMetrics")
    public void setPodMetrics(PodMetrics podMetrics) {
        this.podMetrics = podMetrics;
    }

    @JsonProperty("PodMetricsList")
    public PodMetricsList getPodMetricsList() {
        return podMetricsList;
    }

    @JsonProperty("PodMetricsList")
    public void setPodMetricsList(PodMetricsList podMetricsList) {
        this.podMetricsList = podMetricsList;
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
