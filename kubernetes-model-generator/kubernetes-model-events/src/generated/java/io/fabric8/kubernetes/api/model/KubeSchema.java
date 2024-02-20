
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
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
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
    private String time;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    private io.fabric8.kubernetes.api.model.events.v1beta1.Event v1Beta1Event;
    private io.fabric8.kubernetes.api.model.events.v1beta1.EventList v1Beta1EventList;
    private io.fabric8.kubernetes.api.model.events.v1beta1.EventSeries v1Beta1EventSeries;
    private io.fabric8.kubernetes.api.model.events.v1.Event v1Event;
    private io.fabric8.kubernetes.api.model.events.v1.EventList v1EventList;
    private io.fabric8.kubernetes.api.model.events.v1.EventSeries v1EventSeries;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, ListOptions listOptions, ObjectMeta objectMeta, ObjectReference objectReference, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.events.v1beta1.Event v1Beta1Event, io.fabric8.kubernetes.api.model.events.v1beta1.EventList v1Beta1EventList, io.fabric8.kubernetes.api.model.events.v1beta1.EventSeries v1Beta1EventSeries, io.fabric8.kubernetes.api.model.events.v1.Event v1Event, io.fabric8.kubernetes.api.model.events.v1.EventList v1EventList, io.fabric8.kubernetes.api.model.events.v1.EventSeries v1EventSeries) {
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
        this.v1Beta1Event = v1Beta1Event;
        this.v1Beta1EventList = v1Beta1EventList;
        this.v1Beta1EventSeries = v1Beta1EventSeries;
        this.v1Event = v1Event;
        this.v1EventList = v1EventList;
        this.v1EventSeries = v1EventSeries;
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

    @JsonProperty("V1Beta1Event")
    public io.fabric8.kubernetes.api.model.events.v1beta1.Event getV1Beta1Event() {
        return v1Beta1Event;
    }

    @JsonProperty("V1Beta1Event")
    public void setV1Beta1Event(io.fabric8.kubernetes.api.model.events.v1beta1.Event v1Beta1Event) {
        this.v1Beta1Event = v1Beta1Event;
    }

    @JsonProperty("V1Beta1EventList")
    public io.fabric8.kubernetes.api.model.events.v1beta1.EventList getV1Beta1EventList() {
        return v1Beta1EventList;
    }

    @JsonProperty("V1Beta1EventList")
    public void setV1Beta1EventList(io.fabric8.kubernetes.api.model.events.v1beta1.EventList v1Beta1EventList) {
        this.v1Beta1EventList = v1Beta1EventList;
    }

    @JsonProperty("V1Beta1EventSeries")
    public io.fabric8.kubernetes.api.model.events.v1beta1.EventSeries getV1Beta1EventSeries() {
        return v1Beta1EventSeries;
    }

    @JsonProperty("V1Beta1EventSeries")
    public void setV1Beta1EventSeries(io.fabric8.kubernetes.api.model.events.v1beta1.EventSeries v1Beta1EventSeries) {
        this.v1Beta1EventSeries = v1Beta1EventSeries;
    }

    @JsonProperty("V1Event")
    public io.fabric8.kubernetes.api.model.events.v1.Event getV1Event() {
        return v1Event;
    }

    @JsonProperty("V1Event")
    public void setV1Event(io.fabric8.kubernetes.api.model.events.v1.Event v1Event) {
        this.v1Event = v1Event;
    }

    @JsonProperty("V1EventList")
    public io.fabric8.kubernetes.api.model.events.v1.EventList getV1EventList() {
        return v1EventList;
    }

    @JsonProperty("V1EventList")
    public void setV1EventList(io.fabric8.kubernetes.api.model.events.v1.EventList v1EventList) {
        this.v1EventList = v1EventList;
    }

    @JsonProperty("V1EventSeries")
    public io.fabric8.kubernetes.api.model.events.v1.EventSeries getV1EventSeries() {
        return v1EventSeries;
    }

    @JsonProperty("V1EventSeries")
    public void setV1EventSeries(io.fabric8.kubernetes.api.model.events.v1.EventSeries v1EventSeries) {
        this.v1EventSeries = v1EventSeries;
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
