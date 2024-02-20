
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.openshift.api.model.installer.v1.InstallConfig;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private io.fabric8.openshift.api.model.installer.alibabacloud.v1.MachinePool alibabaCloudMachinePool;
    private io.fabric8.openshift.api.model.installer.aws.v1.MachinePool awsMachinePool;
    private io.fabric8.openshift.api.model.installer.azure.v1.MachinePool azureMachinePool;
    private io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool baremetalMachinePool;
    private KubernetesList baseKubernetesList;
    private io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool gcpMachinePool;
    private io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool iBMCloudMachinePool;
    private InstallConfig installConfig;
    private io.fabric8.openshift.api.model.installer.libvirt.v1.MachinePool libvirtMachinePool;
    private ObjectMeta objectMeta;
    private io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool openStackMachinePool;
    private io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool ovirtMachinePool;
    private Patch patch;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    private io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool vSphereMachinePool;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, io.fabric8.openshift.api.model.installer.alibabacloud.v1.MachinePool alibabaCloudMachinePool, io.fabric8.openshift.api.model.installer.aws.v1.MachinePool awsMachinePool, io.fabric8.openshift.api.model.installer.azure.v1.MachinePool azureMachinePool, io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool baremetalMachinePool, KubernetesList baseKubernetesList, io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool gcpMachinePool, io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool iBMCloudMachinePool, InstallConfig installConfig, io.fabric8.openshift.api.model.installer.libvirt.v1.MachinePool libvirtMachinePool, ObjectMeta objectMeta, io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool openStackMachinePool, io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool ovirtMachinePool, Patch patch, Status status, String time, TypeMeta typeMeta, io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool vSphereMachinePool) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.alibabaCloudMachinePool = alibabaCloudMachinePool;
        this.awsMachinePool = awsMachinePool;
        this.azureMachinePool = azureMachinePool;
        this.baremetalMachinePool = baremetalMachinePool;
        this.baseKubernetesList = baseKubernetesList;
        this.gcpMachinePool = gcpMachinePool;
        this.iBMCloudMachinePool = iBMCloudMachinePool;
        this.installConfig = installConfig;
        this.libvirtMachinePool = libvirtMachinePool;
        this.objectMeta = objectMeta;
        this.openStackMachinePool = openStackMachinePool;
        this.ovirtMachinePool = ovirtMachinePool;
        this.patch = patch;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.vSphereMachinePool = vSphereMachinePool;
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

    @JsonProperty("AlibabaCloudMachinePool")
    public io.fabric8.openshift.api.model.installer.alibabacloud.v1.MachinePool getAlibabaCloudMachinePool() {
        return alibabaCloudMachinePool;
    }

    @JsonProperty("AlibabaCloudMachinePool")
    public void setAlibabaCloudMachinePool(io.fabric8.openshift.api.model.installer.alibabacloud.v1.MachinePool alibabaCloudMachinePool) {
        this.alibabaCloudMachinePool = alibabaCloudMachinePool;
    }

    @JsonProperty("AwsMachinePool")
    public io.fabric8.openshift.api.model.installer.aws.v1.MachinePool getAwsMachinePool() {
        return awsMachinePool;
    }

    @JsonProperty("AwsMachinePool")
    public void setAwsMachinePool(io.fabric8.openshift.api.model.installer.aws.v1.MachinePool awsMachinePool) {
        this.awsMachinePool = awsMachinePool;
    }

    @JsonProperty("AzureMachinePool")
    public io.fabric8.openshift.api.model.installer.azure.v1.MachinePool getAzureMachinePool() {
        return azureMachinePool;
    }

    @JsonProperty("AzureMachinePool")
    public void setAzureMachinePool(io.fabric8.openshift.api.model.installer.azure.v1.MachinePool azureMachinePool) {
        this.azureMachinePool = azureMachinePool;
    }

    @JsonProperty("BaremetalMachinePool")
    public io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool getBaremetalMachinePool() {
        return baremetalMachinePool;
    }

    @JsonProperty("BaremetalMachinePool")
    public void setBaremetalMachinePool(io.fabric8.openshift.api.model.installer.baremetal.v1.MachinePool baremetalMachinePool) {
        this.baremetalMachinePool = baremetalMachinePool;
    }

    @JsonProperty("BaseKubernetesList")
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("GcpMachinePool")
    public io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool getGcpMachinePool() {
        return gcpMachinePool;
    }

    @JsonProperty("GcpMachinePool")
    public void setGcpMachinePool(io.fabric8.openshift.api.model.installer.gcp.v1.MachinePool gcpMachinePool) {
        this.gcpMachinePool = gcpMachinePool;
    }

    @JsonProperty("IBMCloudMachinePool")
    public io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool getIBMCloudMachinePool() {
        return iBMCloudMachinePool;
    }

    @JsonProperty("IBMCloudMachinePool")
    public void setIBMCloudMachinePool(io.fabric8.openshift.api.model.installer.ibmcloud.v1.MachinePool iBMCloudMachinePool) {
        this.iBMCloudMachinePool = iBMCloudMachinePool;
    }

    @JsonProperty("InstallConfig")
    public InstallConfig getInstallConfig() {
        return installConfig;
    }

    @JsonProperty("InstallConfig")
    public void setInstallConfig(InstallConfig installConfig) {
        this.installConfig = installConfig;
    }

    @JsonProperty("LibvirtMachinePool")
    public io.fabric8.openshift.api.model.installer.libvirt.v1.MachinePool getLibvirtMachinePool() {
        return libvirtMachinePool;
    }

    @JsonProperty("LibvirtMachinePool")
    public void setLibvirtMachinePool(io.fabric8.openshift.api.model.installer.libvirt.v1.MachinePool libvirtMachinePool) {
        this.libvirtMachinePool = libvirtMachinePool;
    }

    @JsonProperty("ObjectMeta")
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("OpenStackMachinePool")
    public io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool getOpenStackMachinePool() {
        return openStackMachinePool;
    }

    @JsonProperty("OpenStackMachinePool")
    public void setOpenStackMachinePool(io.fabric8.openshift.api.model.installer.openstack.v1.MachinePool openStackMachinePool) {
        this.openStackMachinePool = openStackMachinePool;
    }

    @JsonProperty("OvirtMachinePool")
    public io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool getOvirtMachinePool() {
        return ovirtMachinePool;
    }

    @JsonProperty("OvirtMachinePool")
    public void setOvirtMachinePool(io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePool ovirtMachinePool) {
        this.ovirtMachinePool = ovirtMachinePool;
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

    @JsonProperty("VSphereMachinePool")
    public io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool getVSphereMachinePool() {
        return vSphereMachinePool;
    }

    @JsonProperty("VSphereMachinePool")
    public void setVSphereMachinePool(io.fabric8.openshift.api.model.installer.vsphere.v1.MachinePool vSphereMachinePool) {
        this.vSphereMachinePool = vSphereMachinePool;
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
