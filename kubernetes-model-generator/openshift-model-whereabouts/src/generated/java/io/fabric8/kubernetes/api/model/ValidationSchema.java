
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPAllocation;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPool;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPoolList;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservation;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservationList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private IPAllocation iPAllocation;
    private IPPool iPPool;
    private IPPoolList iPPoolList;
    private Info info;
    private ObjectMeta objectMeta;
    private OverlappingRangeIPReservation overlappingRangeIPReservation;
    private OverlappingRangeIPReservationList overlappingRangeIPReservationList;
    private Patch patch;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, IPAllocation iPAllocation, IPPool iPPool, IPPoolList iPPoolList, Info info, ObjectMeta objectMeta, OverlappingRangeIPReservation overlappingRangeIPReservation, OverlappingRangeIPReservationList overlappingRangeIPReservationList, Patch patch, Status status, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.iPAllocation = iPAllocation;
        this.iPPool = iPPool;
        this.iPPoolList = iPPoolList;
        this.info = info;
        this.objectMeta = objectMeta;
        this.overlappingRangeIPReservation = overlappingRangeIPReservation;
        this.overlappingRangeIPReservationList = overlappingRangeIPReservationList;
        this.patch = patch;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
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

    @JsonProperty("IPAllocation")
    public IPAllocation getIPAllocation() {
        return iPAllocation;
    }

    @JsonProperty("IPAllocation")
    public void setIPAllocation(IPAllocation iPAllocation) {
        this.iPAllocation = iPAllocation;
    }

    @JsonProperty("IPPool")
    public IPPool getIPPool() {
        return iPPool;
    }

    @JsonProperty("IPPool")
    public void setIPPool(IPPool iPPool) {
        this.iPPool = iPPool;
    }

    @JsonProperty("IPPoolList")
    public IPPoolList getIPPoolList() {
        return iPPoolList;
    }

    @JsonProperty("IPPoolList")
    public void setIPPoolList(IPPoolList iPPoolList) {
        this.iPPoolList = iPPoolList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("ObjectMeta")
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("OverlappingRangeIPReservation")
    public OverlappingRangeIPReservation getOverlappingRangeIPReservation() {
        return overlappingRangeIPReservation;
    }

    @JsonProperty("OverlappingRangeIPReservation")
    public void setOverlappingRangeIPReservation(OverlappingRangeIPReservation overlappingRangeIPReservation) {
        this.overlappingRangeIPReservation = overlappingRangeIPReservation;
    }

    @JsonProperty("OverlappingRangeIPReservationList")
    public OverlappingRangeIPReservationList getOverlappingRangeIPReservationList() {
        return overlappingRangeIPReservationList;
    }

    @JsonProperty("OverlappingRangeIPReservationList")
    public void setOverlappingRangeIPReservationList(OverlappingRangeIPReservationList overlappingRangeIPReservationList) {
        this.overlappingRangeIPReservationList = overlappingRangeIPReservationList;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
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
