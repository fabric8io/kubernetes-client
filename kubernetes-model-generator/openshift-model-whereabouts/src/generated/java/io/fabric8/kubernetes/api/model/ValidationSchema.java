
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
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPAllocation;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPool;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPoolList;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservation;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservationList;
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
    "IPAllocation",
    "IPPool",
    "IPPoolList",
    "Info",
    "ObjectMeta",
    "OverlappingRangeIPReservation",
    "OverlappingRangeIPReservationList",
    "Patch",
    "Status",
    "Time",
    "TypeMeta"
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
    @JsonProperty("IPAllocation")
    private IPAllocation iPAllocation;
    @JsonProperty("IPPool")
    private IPPool iPPool;
    @JsonProperty("IPPoolList")
    private IPPoolList iPPoolList;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("OverlappingRangeIPReservation")
    private OverlappingRangeIPReservation overlappingRangeIPReservation;
    @JsonProperty("OverlappingRangeIPReservationList")
    private OverlappingRangeIPReservationList overlappingRangeIPReservationList;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
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
     * @param aPIGroupList
     * @param baseKubernetesList
     * @param overlappingRangeIPReservation
     * @param iPAllocation
     * @param patch
     * @param aPIGroup
     * @param iPPoolList
     * @param typeMeta
     * @param overlappingRangeIPReservationList
     * @param objectMeta
     * @param iPPool
     * @param time
     * @param info
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, IPAllocation iPAllocation, IPPool iPPool, IPPoolList iPPoolList, Info info, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, OverlappingRangeIPReservation overlappingRangeIPReservation, OverlappingRangeIPReservationList overlappingRangeIPReservationList, Patch patch, Status status, String time, TypeMeta typeMeta) {
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
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
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
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
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
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
