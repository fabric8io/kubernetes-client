
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.ContainerRuntimeConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.ControllerConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.KubeletConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfig;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigList;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPool;
import io.fabric8.openshift.api.model.machineconfig.v1.MachineConfigPoolList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private ContainerRuntimeConfig containerRuntimeConfig;
    private ContainerRuntimeConfigList containerRuntimeConfigList;
    private ControllerConfig controllerConfig;
    private ControllerConfigList controllerConfigList;
    private Info info;
    private KubeletConfig kubeletConfig;
    private KubeletConfigList kubeletConfigList;
    private MachineConfig machineConfig;
    private MachineConfigList machineConfigList;
    private MachineConfigPool machineConfigPool;
    private MachineConfigPoolList machineConfigPoolList;
    private ObjectMeta objectMeta;
    private Patch patch;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, ContainerRuntimeConfig containerRuntimeConfig, ContainerRuntimeConfigList containerRuntimeConfigList, ControllerConfig controllerConfig, ControllerConfigList controllerConfigList, Info info, KubeletConfig kubeletConfig, KubeletConfigList kubeletConfigList, MachineConfig machineConfig, MachineConfigList machineConfigList, MachineConfigPool machineConfigPool, MachineConfigPoolList machineConfigPoolList, ObjectMeta objectMeta, Patch patch, Status status, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.containerRuntimeConfig = containerRuntimeConfig;
        this.containerRuntimeConfigList = containerRuntimeConfigList;
        this.controllerConfig = controllerConfig;
        this.controllerConfigList = controllerConfigList;
        this.info = info;
        this.kubeletConfig = kubeletConfig;
        this.kubeletConfigList = kubeletConfigList;
        this.machineConfig = machineConfig;
        this.machineConfigList = machineConfigList;
        this.machineConfigPool = machineConfigPool;
        this.machineConfigPoolList = machineConfigPoolList;
        this.objectMeta = objectMeta;
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

    @JsonProperty("ContainerRuntimeConfig")
    public ContainerRuntimeConfig getContainerRuntimeConfig() {
        return containerRuntimeConfig;
    }

    @JsonProperty("ContainerRuntimeConfig")
    public void setContainerRuntimeConfig(ContainerRuntimeConfig containerRuntimeConfig) {
        this.containerRuntimeConfig = containerRuntimeConfig;
    }

    @JsonProperty("ContainerRuntimeConfigList")
    public ContainerRuntimeConfigList getContainerRuntimeConfigList() {
        return containerRuntimeConfigList;
    }

    @JsonProperty("ContainerRuntimeConfigList")
    public void setContainerRuntimeConfigList(ContainerRuntimeConfigList containerRuntimeConfigList) {
        this.containerRuntimeConfigList = containerRuntimeConfigList;
    }

    @JsonProperty("ControllerConfig")
    public ControllerConfig getControllerConfig() {
        return controllerConfig;
    }

    @JsonProperty("ControllerConfig")
    public void setControllerConfig(ControllerConfig controllerConfig) {
        this.controllerConfig = controllerConfig;
    }

    @JsonProperty("ControllerConfigList")
    public ControllerConfigList getControllerConfigList() {
        return controllerConfigList;
    }

    @JsonProperty("ControllerConfigList")
    public void setControllerConfigList(ControllerConfigList controllerConfigList) {
        this.controllerConfigList = controllerConfigList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("KubeletConfig")
    public KubeletConfig getKubeletConfig() {
        return kubeletConfig;
    }

    @JsonProperty("KubeletConfig")
    public void setKubeletConfig(KubeletConfig kubeletConfig) {
        this.kubeletConfig = kubeletConfig;
    }

    @JsonProperty("KubeletConfigList")
    public KubeletConfigList getKubeletConfigList() {
        return kubeletConfigList;
    }

    @JsonProperty("KubeletConfigList")
    public void setKubeletConfigList(KubeletConfigList kubeletConfigList) {
        this.kubeletConfigList = kubeletConfigList;
    }

    @JsonProperty("MachineConfig")
    public MachineConfig getMachineConfig() {
        return machineConfig;
    }

    @JsonProperty("MachineConfig")
    public void setMachineConfig(MachineConfig machineConfig) {
        this.machineConfig = machineConfig;
    }

    @JsonProperty("MachineConfigList")
    public MachineConfigList getMachineConfigList() {
        return machineConfigList;
    }

    @JsonProperty("MachineConfigList")
    public void setMachineConfigList(MachineConfigList machineConfigList) {
        this.machineConfigList = machineConfigList;
    }

    @JsonProperty("MachineConfigPool")
    public MachineConfigPool getMachineConfigPool() {
        return machineConfigPool;
    }

    @JsonProperty("MachineConfigPool")
    public void setMachineConfigPool(MachineConfigPool machineConfigPool) {
        this.machineConfigPool = machineConfigPool;
    }

    @JsonProperty("MachineConfigPoolList")
    public MachineConfigPoolList getMachineConfigPoolList() {
        return machineConfigPoolList;
    }

    @JsonProperty("MachineConfigPoolList")
    public void setMachineConfigPoolList(MachineConfigPoolList machineConfigPoolList) {
        this.machineConfigPoolList = machineConfigPoolList;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<java.lang.String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
