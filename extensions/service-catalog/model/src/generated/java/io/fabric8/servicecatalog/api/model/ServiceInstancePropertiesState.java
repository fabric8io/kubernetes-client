
package io.fabric8.servicecatalog.api.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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
    "clusterServicePlanExternalID",
    "clusterServicePlanExternalName",
    "parameterChecksum",
    "parameters",
    "servicePlanExternalID",
    "servicePlanExternalName",
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ServiceInstancePropertiesState implements KubernetesResource
{

    @JsonProperty("clusterServicePlanExternalID")
    private java.lang.String clusterServicePlanExternalID;
    @JsonProperty("clusterServicePlanExternalName")
    private java.lang.String clusterServicePlanExternalName;
    @JsonProperty("parameterChecksum")
    private java.lang.String parameterChecksum;
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> parameters = new LinkedHashMap<String, Object>();
    @JsonProperty("servicePlanExternalID")
    private java.lang.String servicePlanExternalID;
    @JsonProperty("servicePlanExternalName")
    private java.lang.String servicePlanExternalName;
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceInstancePropertiesState() {
    }

    /**
     * 
     * @param userInfo
     * @param parameterChecksum
     * @param clusterServicePlanExternalName
     * @param clusterServicePlanExternalID
     * @param servicePlanExternalID
     * @param parameters
     * @param servicePlanExternalName
     */
    public ServiceInstancePropertiesState(java.lang.String clusterServicePlanExternalID, java.lang.String clusterServicePlanExternalName, java.lang.String parameterChecksum, Map<String, Object> parameters, java.lang.String servicePlanExternalID, java.lang.String servicePlanExternalName, UserInfo userInfo) {
        super();
        this.clusterServicePlanExternalID = clusterServicePlanExternalID;
        this.clusterServicePlanExternalName = clusterServicePlanExternalName;
        this.parameterChecksum = parameterChecksum;
        this.parameters = parameters;
        this.servicePlanExternalID = servicePlanExternalID;
        this.servicePlanExternalName = servicePlanExternalName;
        this.userInfo = userInfo;
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

    @JsonProperty("parameterChecksum")
    public java.lang.String getParameterChecksum() {
        return parameterChecksum;
    }

    @JsonProperty("parameterChecksum")
    public void setParameterChecksum(java.lang.String parameterChecksum) {
        this.parameterChecksum = parameterChecksum;
    }

    @JsonProperty("parameters")
    public Map<String, Object> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
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
