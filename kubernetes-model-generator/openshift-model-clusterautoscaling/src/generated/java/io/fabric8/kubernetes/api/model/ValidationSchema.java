
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1.ClusterAutoscalerList;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscaler;
import io.fabric8.openshift.api.model.clusterautoscaling.v1beta1.MachineAutoscalerList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private ClusterAutoscaler clusterAutoscaler;
    private ClusterAutoscalerList clusterAutoscalerList;
    private Info info;
    private ObjectMeta objectMeta;
    private Patch patch;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    private MachineAutoscaler v1beta1MachineAutoscaler;
    private MachineAutoscalerList v1beta1MachineAutoscalerList;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, ClusterAutoscaler clusterAutoscaler, ClusterAutoscalerList clusterAutoscalerList, Info info, ObjectMeta objectMeta, Patch patch, Status status, String time, TypeMeta typeMeta, MachineAutoscaler v1beta1MachineAutoscaler, MachineAutoscalerList v1beta1MachineAutoscalerList) {
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
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
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
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
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
