
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSet;
import io.fabric8.openshift.api.model.machine.v1.ControlPlaneMachineSetList;
import io.fabric8.openshift.api.model.machine.v1.NutanixCategory;
import io.fabric8.openshift.api.model.machine.v1.NutanixResourceIdentifier;
import io.fabric8.openshift.api.model.machine.v1alpha1.OpenstackProviderSpec;
import io.fabric8.openshift.api.model.machine.v1alpha1.SubnetFilter;
import io.fabric8.openshift.api.model.machine.v1beta1.Machine;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheck;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineHealthCheckList;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineList;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSet;
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSetList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private ControlPlaneMachineSet controlPlaneMachineSet;
    private ControlPlaneMachineSetList controlPlaneMachineSetList;
    private Info info;
    private Machine machine;
    private MachineHealthCheck machineHealthCheck;
    private MachineHealthCheckList machineHealthCheckList;
    private MachineList machineList;
    private MachineSet machineSet;
    private MachineSetList machineSetList;
    private ObjectMeta objectMeta;
    private Patch patch;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    private OpenstackProviderSpec v1Alpha1OpenStackProviderSpec;
    private SubnetFilter v1Alpha1SubnetFilter;
    private NutanixCategory v1NutanixCategory;
    private NutanixResourceIdentifier v1NutanixResourceIdentifier;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, ControlPlaneMachineSet controlPlaneMachineSet, ControlPlaneMachineSetList controlPlaneMachineSetList, Info info, Machine machine, MachineHealthCheck machineHealthCheck, MachineHealthCheckList machineHealthCheckList, MachineList machineList, MachineSet machineSet, MachineSetList machineSetList, ObjectMeta objectMeta, Patch patch, Status status, String time, TypeMeta typeMeta, OpenstackProviderSpec v1Alpha1OpenStackProviderSpec, SubnetFilter v1Alpha1SubnetFilter, NutanixCategory v1NutanixCategory, NutanixResourceIdentifier v1NutanixResourceIdentifier) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.controlPlaneMachineSet = controlPlaneMachineSet;
        this.controlPlaneMachineSetList = controlPlaneMachineSetList;
        this.info = info;
        this.machine = machine;
        this.machineHealthCheck = machineHealthCheck;
        this.machineHealthCheckList = machineHealthCheckList;
        this.machineList = machineList;
        this.machineSet = machineSet;
        this.machineSetList = machineSetList;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.v1Alpha1OpenStackProviderSpec = v1Alpha1OpenStackProviderSpec;
        this.v1Alpha1SubnetFilter = v1Alpha1SubnetFilter;
        this.v1NutanixCategory = v1NutanixCategory;
        this.v1NutanixResourceIdentifier = v1NutanixResourceIdentifier;
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

    @JsonProperty("ControlPlaneMachineSet")
    public ControlPlaneMachineSet getControlPlaneMachineSet() {
        return controlPlaneMachineSet;
    }

    @JsonProperty("ControlPlaneMachineSet")
    public void setControlPlaneMachineSet(ControlPlaneMachineSet controlPlaneMachineSet) {
        this.controlPlaneMachineSet = controlPlaneMachineSet;
    }

    @JsonProperty("ControlPlaneMachineSetList")
    public ControlPlaneMachineSetList getControlPlaneMachineSetList() {
        return controlPlaneMachineSetList;
    }

    @JsonProperty("ControlPlaneMachineSetList")
    public void setControlPlaneMachineSetList(ControlPlaneMachineSetList controlPlaneMachineSetList) {
        this.controlPlaneMachineSetList = controlPlaneMachineSetList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("Machine")
    public Machine getMachine() {
        return machine;
    }

    @JsonProperty("Machine")
    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @JsonProperty("MachineHealthCheck")
    public MachineHealthCheck getMachineHealthCheck() {
        return machineHealthCheck;
    }

    @JsonProperty("MachineHealthCheck")
    public void setMachineHealthCheck(MachineHealthCheck machineHealthCheck) {
        this.machineHealthCheck = machineHealthCheck;
    }

    @JsonProperty("MachineHealthCheckList")
    public MachineHealthCheckList getMachineHealthCheckList() {
        return machineHealthCheckList;
    }

    @JsonProperty("MachineHealthCheckList")
    public void setMachineHealthCheckList(MachineHealthCheckList machineHealthCheckList) {
        this.machineHealthCheckList = machineHealthCheckList;
    }

    @JsonProperty("MachineList")
    public MachineList getMachineList() {
        return machineList;
    }

    @JsonProperty("MachineList")
    public void setMachineList(MachineList machineList) {
        this.machineList = machineList;
    }

    @JsonProperty("MachineSet")
    public MachineSet getMachineSet() {
        return machineSet;
    }

    @JsonProperty("MachineSet")
    public void setMachineSet(MachineSet machineSet) {
        this.machineSet = machineSet;
    }

    @JsonProperty("MachineSetList")
    public MachineSetList getMachineSetList() {
        return machineSetList;
    }

    @JsonProperty("MachineSetList")
    public void setMachineSetList(MachineSetList machineSetList) {
        this.machineSetList = machineSetList;
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

    @JsonProperty("V1Alpha1OpenStackProviderSpec")
    public OpenstackProviderSpec getV1Alpha1OpenStackProviderSpec() {
        return v1Alpha1OpenStackProviderSpec;
    }

    @JsonProperty("V1Alpha1OpenStackProviderSpec")
    public void setV1Alpha1OpenStackProviderSpec(OpenstackProviderSpec v1Alpha1OpenStackProviderSpec) {
        this.v1Alpha1OpenStackProviderSpec = v1Alpha1OpenStackProviderSpec;
    }

    @JsonProperty("V1Alpha1SubnetFilter")
    public SubnetFilter getV1Alpha1SubnetFilter() {
        return v1Alpha1SubnetFilter;
    }

    @JsonProperty("V1Alpha1SubnetFilter")
    public void setV1Alpha1SubnetFilter(SubnetFilter v1Alpha1SubnetFilter) {
        this.v1Alpha1SubnetFilter = v1Alpha1SubnetFilter;
    }

    @JsonProperty("V1NutanixCategory")
    public NutanixCategory getV1NutanixCategory() {
        return v1NutanixCategory;
    }

    @JsonProperty("V1NutanixCategory")
    public void setV1NutanixCategory(NutanixCategory v1NutanixCategory) {
        this.v1NutanixCategory = v1NutanixCategory;
    }

    @JsonProperty("V1NutanixResourceIdentifier")
    public NutanixResourceIdentifier getV1NutanixResourceIdentifier() {
        return v1NutanixResourceIdentifier;
    }

    @JsonProperty("V1NutanixResourceIdentifier")
    public void setV1NutanixResourceIdentifier(NutanixResourceIdentifier v1NutanixResourceIdentifier) {
        this.v1NutanixResourceIdentifier = v1NutanixResourceIdentifier;
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
