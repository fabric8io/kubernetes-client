
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
    "ContainerRuntimeConfig",
    "ContainerRuntimeConfigList",
    "ControllerConfig",
    "ControllerConfigList",
    "Info",
    "KubeletConfig",
    "KubeletConfigList",
    "MachineConfig",
    "MachineConfigList",
    "MachineConfigPool",
    "MachineConfigPoolList",
    "ObjectMeta",
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
    @JsonProperty("ContainerRuntimeConfig")
    private ContainerRuntimeConfig containerRuntimeConfig;
    @JsonProperty("ContainerRuntimeConfigList")
    private ContainerRuntimeConfigList containerRuntimeConfigList;
    @JsonProperty("ControllerConfig")
    private ControllerConfig controllerConfig;
    @JsonProperty("ControllerConfigList")
    private ControllerConfigList controllerConfigList;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("KubeletConfig")
    private KubeletConfig kubeletConfig;
    @JsonProperty("KubeletConfigList")
    private KubeletConfigList kubeletConfigList;
    @JsonProperty("MachineConfig")
    private MachineConfig machineConfig;
    @JsonProperty("MachineConfigList")
    private MachineConfigList machineConfigList;
    @JsonProperty("MachineConfigPool")
    private MachineConfigPool machineConfigPool;
    @JsonProperty("MachineConfigPoolList")
    private MachineConfigPoolList machineConfigPoolList;
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
     * @param containerRuntimeConfigList
     * @param aPIGroupList
     * @param machineConfig
     * @param containerRuntimeConfig
     * @param controllerConfigList
     * @param controllerConfig
     * @param baseKubernetesList
     * @param kubeletConfigList
     * @param machineConfigPoolList
     * @param machineConfigList
     * @param patch
     * @param aPIGroup
     * @param typeMeta
     * @param kubeletConfig
     * @param objectMeta
     * @param time
     * @param machineConfigPool
     * @param info
     * @param status
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, ContainerRuntimeConfig containerRuntimeConfig, ContainerRuntimeConfigList containerRuntimeConfigList, ControllerConfig controllerConfig, ControllerConfigList controllerConfigList, Info info, KubeletConfig kubeletConfig, KubeletConfigList kubeletConfigList, MachineConfig machineConfig, MachineConfigList machineConfigList, MachineConfigPool machineConfigPool, MachineConfigPoolList machineConfigPoolList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, Status status, String time, TypeMeta typeMeta) {
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
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
