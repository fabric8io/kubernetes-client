
package io.fabric8.servicecatalog.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "clusterServiceClassExternalID",
    "clusterServiceClassExternalName",
    "clusterServiceClassName",
    "clusterServiceClassRef",
    "clusterServicePlanExternalID",
    "clusterServicePlanExternalName",
    "clusterServicePlanName",
    "clusterServicePlanRef",
    "externalID",
    "parameters",
    "parametersFrom",
    "serviceClassExternalID",
    "serviceClassExternalName",
    "serviceClassName",
    "serviceClassRef",
    "servicePlanExternalID",
    "servicePlanExternalName",
    "servicePlanName",
    "servicePlanRef",
    "updateRequests",
    "userInfo"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ServiceInstanceSpec implements KubernetesResource
{

    @JsonProperty("clusterServiceClassExternalID")
    private java.lang.String clusterServiceClassExternalID;
    @JsonProperty("clusterServiceClassExternalName")
    private java.lang.String clusterServiceClassExternalName;
    @JsonProperty("clusterServiceClassName")
    private java.lang.String clusterServiceClassName;
    @JsonProperty("clusterServiceClassRef")
    private ClusterObjectReference clusterServiceClassRef;
    @JsonProperty("clusterServicePlanExternalID")
    private java.lang.String clusterServicePlanExternalID;
    @JsonProperty("clusterServicePlanExternalName")
    private java.lang.String clusterServicePlanExternalName;
    @JsonProperty("clusterServicePlanName")
    private java.lang.String clusterServicePlanName;
    @JsonProperty("clusterServicePlanRef")
    private ClusterObjectReference clusterServicePlanRef;
    @JsonProperty("externalID")
    private java.lang.String externalID;
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> parameters = new LinkedHashMap<String, Object>();
    @JsonProperty("parametersFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParametersFromSource> parametersFrom = new ArrayList<ParametersFromSource>();
    @JsonProperty("serviceClassExternalID")
    private java.lang.String serviceClassExternalID;
    @JsonProperty("serviceClassExternalName")
    private java.lang.String serviceClassExternalName;
    @JsonProperty("serviceClassName")
    private java.lang.String serviceClassName;
    @JsonProperty("serviceClassRef")
    private io.fabric8.servicecatalog.api.model.LocalObjectReference serviceClassRef;
    @JsonProperty("servicePlanExternalID")
    private java.lang.String servicePlanExternalID;
    @JsonProperty("servicePlanExternalName")
    private java.lang.String servicePlanExternalName;
    @JsonProperty("servicePlanName")
    private java.lang.String servicePlanName;
    @JsonProperty("servicePlanRef")
    private io.fabric8.servicecatalog.api.model.LocalObjectReference servicePlanRef;
    @JsonProperty("updateRequests")
    private Long updateRequests;
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceInstanceSpec() {
    }

    /**
     * 
     * @param updateRequests
     * @param userInfo
     * @param parametersFrom
     * @param clusterServicePlanExternalID
     * @param externalID
     * @param clusterServiceClassExternalID
     * @param clusterServiceClassName
     * @param clusterServicePlanRef
     * @param serviceClassExternalName
     * @param serviceClassName
     * @param serviceClassExternalID
     * @param servicePlanExternalName
     * @param clusterServiceClassExternalName
     * @param clusterServiceClassRef
     * @param serviceClassRef
     * @param clusterServicePlanName
     * @param servicePlanName
     * @param clusterServicePlanExternalName
     * @param servicePlanExternalID
     * @param servicePlanRef
     * @param parameters
     */
    public ServiceInstanceSpec(java.lang.String clusterServiceClassExternalID, java.lang.String clusterServiceClassExternalName, java.lang.String clusterServiceClassName, ClusterObjectReference clusterServiceClassRef, java.lang.String clusterServicePlanExternalID, java.lang.String clusterServicePlanExternalName, java.lang.String clusterServicePlanName, ClusterObjectReference clusterServicePlanRef, java.lang.String externalID, Map<String, Object> parameters, List<ParametersFromSource> parametersFrom, java.lang.String serviceClassExternalID, java.lang.String serviceClassExternalName, java.lang.String serviceClassName, io.fabric8.servicecatalog.api.model.LocalObjectReference serviceClassRef, java.lang.String servicePlanExternalID, java.lang.String servicePlanExternalName, java.lang.String servicePlanName, io.fabric8.servicecatalog.api.model.LocalObjectReference servicePlanRef, Long updateRequests, UserInfo userInfo) {
        super();
        this.clusterServiceClassExternalID = clusterServiceClassExternalID;
        this.clusterServiceClassExternalName = clusterServiceClassExternalName;
        this.clusterServiceClassName = clusterServiceClassName;
        this.clusterServiceClassRef = clusterServiceClassRef;
        this.clusterServicePlanExternalID = clusterServicePlanExternalID;
        this.clusterServicePlanExternalName = clusterServicePlanExternalName;
        this.clusterServicePlanName = clusterServicePlanName;
        this.clusterServicePlanRef = clusterServicePlanRef;
        this.externalID = externalID;
        this.parameters = parameters;
        this.parametersFrom = parametersFrom;
        this.serviceClassExternalID = serviceClassExternalID;
        this.serviceClassExternalName = serviceClassExternalName;
        this.serviceClassName = serviceClassName;
        this.serviceClassRef = serviceClassRef;
        this.servicePlanExternalID = servicePlanExternalID;
        this.servicePlanExternalName = servicePlanExternalName;
        this.servicePlanName = servicePlanName;
        this.servicePlanRef = servicePlanRef;
        this.updateRequests = updateRequests;
        this.userInfo = userInfo;
    }

    @JsonProperty("clusterServiceClassExternalID")
    public java.lang.String getClusterServiceClassExternalID() {
        return clusterServiceClassExternalID;
    }

    @JsonProperty("clusterServiceClassExternalID")
    public void setClusterServiceClassExternalID(java.lang.String clusterServiceClassExternalID) {
        this.clusterServiceClassExternalID = clusterServiceClassExternalID;
    }

    @JsonProperty("clusterServiceClassExternalName")
    public java.lang.String getClusterServiceClassExternalName() {
        return clusterServiceClassExternalName;
    }

    @JsonProperty("clusterServiceClassExternalName")
    public void setClusterServiceClassExternalName(java.lang.String clusterServiceClassExternalName) {
        this.clusterServiceClassExternalName = clusterServiceClassExternalName;
    }

    @JsonProperty("clusterServiceClassName")
    public java.lang.String getClusterServiceClassName() {
        return clusterServiceClassName;
    }

    @JsonProperty("clusterServiceClassName")
    public void setClusterServiceClassName(java.lang.String clusterServiceClassName) {
        this.clusterServiceClassName = clusterServiceClassName;
    }

    @JsonProperty("clusterServiceClassRef")
    public ClusterObjectReference getClusterServiceClassRef() {
        return clusterServiceClassRef;
    }

    @JsonProperty("clusterServiceClassRef")
    public void setClusterServiceClassRef(ClusterObjectReference clusterServiceClassRef) {
        this.clusterServiceClassRef = clusterServiceClassRef;
    }

    @JsonProperty("clusterServicePlanExternalID")
    public java.lang.String getClusterServicePlanExternalID() {
        return clusterServicePlanExternalID;
    }

    @JsonProperty("clusterServicePlanExternalID")
    public void setClusterServicePlanExternalID(java.lang.String clusterServicePlanExternalID) {
        this.clusterServicePlanExternalID = clusterServicePlanExternalID;
    }

    @JsonProperty("clusterServicePlanExternalName")
    public java.lang.String getClusterServicePlanExternalName() {
        return clusterServicePlanExternalName;
    }

    @JsonProperty("clusterServicePlanExternalName")
    public void setClusterServicePlanExternalName(java.lang.String clusterServicePlanExternalName) {
        this.clusterServicePlanExternalName = clusterServicePlanExternalName;
    }

    @JsonProperty("clusterServicePlanName")
    public java.lang.String getClusterServicePlanName() {
        return clusterServicePlanName;
    }

    @JsonProperty("clusterServicePlanName")
    public void setClusterServicePlanName(java.lang.String clusterServicePlanName) {
        this.clusterServicePlanName = clusterServicePlanName;
    }

    @JsonProperty("clusterServicePlanRef")
    public ClusterObjectReference getClusterServicePlanRef() {
        return clusterServicePlanRef;
    }

    @JsonProperty("clusterServicePlanRef")
    public void setClusterServicePlanRef(ClusterObjectReference clusterServicePlanRef) {
        this.clusterServicePlanRef = clusterServicePlanRef;
    }

    @JsonProperty("externalID")
    public java.lang.String getExternalID() {
        return externalID;
    }

    @JsonProperty("externalID")
    public void setExternalID(java.lang.String externalID) {
        this.externalID = externalID;
    }

    @JsonProperty("parameters")
    public Map<String, Object> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @JsonProperty("parametersFrom")
    public List<ParametersFromSource> getParametersFrom() {
        return parametersFrom;
    }

    @JsonProperty("parametersFrom")
    public void setParametersFrom(List<ParametersFromSource> parametersFrom) {
        this.parametersFrom = parametersFrom;
    }

    @JsonProperty("serviceClassExternalID")
    public java.lang.String getServiceClassExternalID() {
        return serviceClassExternalID;
    }

    @JsonProperty("serviceClassExternalID")
    public void setServiceClassExternalID(java.lang.String serviceClassExternalID) {
        this.serviceClassExternalID = serviceClassExternalID;
    }

    @JsonProperty("serviceClassExternalName")
    public java.lang.String getServiceClassExternalName() {
        return serviceClassExternalName;
    }

    @JsonProperty("serviceClassExternalName")
    public void setServiceClassExternalName(java.lang.String serviceClassExternalName) {
        this.serviceClassExternalName = serviceClassExternalName;
    }

    @JsonProperty("serviceClassName")
    public java.lang.String getServiceClassName() {
        return serviceClassName;
    }

    @JsonProperty("serviceClassName")
    public void setServiceClassName(java.lang.String serviceClassName) {
        this.serviceClassName = serviceClassName;
    }

    @JsonProperty("serviceClassRef")
    public io.fabric8.servicecatalog.api.model.LocalObjectReference getServiceClassRef() {
        return serviceClassRef;
    }

    @JsonProperty("serviceClassRef")
    public void setServiceClassRef(io.fabric8.servicecatalog.api.model.LocalObjectReference serviceClassRef) {
        this.serviceClassRef = serviceClassRef;
    }

    @JsonProperty("servicePlanExternalID")
    public java.lang.String getServicePlanExternalID() {
        return servicePlanExternalID;
    }

    @JsonProperty("servicePlanExternalID")
    public void setServicePlanExternalID(java.lang.String servicePlanExternalID) {
        this.servicePlanExternalID = servicePlanExternalID;
    }

    @JsonProperty("servicePlanExternalName")
    public java.lang.String getServicePlanExternalName() {
        return servicePlanExternalName;
    }

    @JsonProperty("servicePlanExternalName")
    public void setServicePlanExternalName(java.lang.String servicePlanExternalName) {
        this.servicePlanExternalName = servicePlanExternalName;
    }

    @JsonProperty("servicePlanName")
    public java.lang.String getServicePlanName() {
        return servicePlanName;
    }

    @JsonProperty("servicePlanName")
    public void setServicePlanName(java.lang.String servicePlanName) {
        this.servicePlanName = servicePlanName;
    }

    @JsonProperty("servicePlanRef")
    public io.fabric8.servicecatalog.api.model.LocalObjectReference getServicePlanRef() {
        return servicePlanRef;
    }

    @JsonProperty("servicePlanRef")
    public void setServicePlanRef(io.fabric8.servicecatalog.api.model.LocalObjectReference servicePlanRef) {
        this.servicePlanRef = servicePlanRef;
    }

    @JsonProperty("updateRequests")
    public Long getUpdateRequests() {
        return updateRequests;
    }

    @JsonProperty("updateRequests")
    public void setUpdateRequests(Long updateRequests) {
        this.updateRequests = updateRequests;
    }

    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JsonAnyGetter
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
