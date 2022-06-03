
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
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscalerList;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscalerList;
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
    "ClusterAutoscaler",
    "ClusterAutoscalerList",
    "Info",
    "ObjectMeta",
    "Patch",
    "Status",
    "Time",
    "TypeMeta",
    "V1beta1MachineAutoscaler",
    "V1beta1MachineAutoscalerList"
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
    @JsonProperty("ClusterAutoscaler")
    private ClusterAutoscaler clusterAutoscaler;
    @JsonProperty("ClusterAutoscalerList")
    private ClusterAutoscalerList clusterAutoscalerList;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("V1beta1MachineAutoscaler")
    private MachineAutoscaler v1beta1MachineAutoscaler;
    @JsonProperty("V1beta1MachineAutoscalerList")
    private MachineAutoscalerList v1beta1MachineAutoscalerList;
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
     * @param clusterAutoscaler
     * @param baseKubernetesList
     * @param v1beta1MachineAutoscaler
     * @param patch
     * @param aPIGroup
     * @param typeMeta
     * @param v1beta1MachineAutoscalerList
     * @param objectMeta
     * @param clusterAutoscalerList
     * @param time
     * @param info
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, ClusterAutoscaler clusterAutoscaler, ClusterAutoscalerList clusterAutoscalerList, Info info, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, Status status, String time, TypeMeta typeMeta, MachineAutoscaler v1beta1MachineAutoscaler, MachineAutoscalerList v1beta1MachineAutoscalerList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.clusterAutoscaler = clusterAutoscaler;
        this.clusterAutoscalerList = clusterAutoscalerList;
        this.info = info;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.v1beta1MachineAutoscaler = v1beta1MachineAutoscaler;
        this.v1beta1MachineAutoscalerList = v1beta1MachineAutoscalerList;
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

    @JsonProperty("ClusterAutoscaler")
    public ClusterAutoscaler getClusterAutoscaler() {
        return clusterAutoscaler;
    }

    @JsonProperty("ClusterAutoscaler")
    public void setClusterAutoscaler(ClusterAutoscaler clusterAutoscaler) {
        this.clusterAutoscaler = clusterAutoscaler;
    }

    @JsonProperty("ClusterAutoscalerList")
    public ClusterAutoscalerList getClusterAutoscalerList() {
        return clusterAutoscalerList;
    }

    @JsonProperty("ClusterAutoscalerList")
    public void setClusterAutoscalerList(ClusterAutoscalerList clusterAutoscalerList) {
        this.clusterAutoscalerList = clusterAutoscalerList;
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

    @JsonProperty("V1beta1MachineAutoscaler")
    public MachineAutoscaler getV1beta1MachineAutoscaler() {
        return v1beta1MachineAutoscaler;
    }

    @JsonProperty("V1beta1MachineAutoscaler")
    public void setV1beta1MachineAutoscaler(MachineAutoscaler v1beta1MachineAutoscaler) {
        this.v1beta1MachineAutoscaler = v1beta1MachineAutoscaler;
    }

    @JsonProperty("V1beta1MachineAutoscalerList")
    public MachineAutoscalerList getV1beta1MachineAutoscalerList() {
        return v1beta1MachineAutoscalerList;
    }

    @JsonProperty("V1beta1MachineAutoscalerList")
    public void setV1beta1MachineAutoscalerList(MachineAutoscalerList v1beta1MachineAutoscalerList) {
        this.v1beta1MachineAutoscalerList = v1beta1MachineAutoscalerList;
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
