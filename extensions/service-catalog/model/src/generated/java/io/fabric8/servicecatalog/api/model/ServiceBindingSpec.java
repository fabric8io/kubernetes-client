
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
    "externalID",
    "instanceRef",
    "parameters",
    "parametersFrom",
    "secretName",
    "secretTransforms",
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
public class ServiceBindingSpec implements KubernetesResource
{

    @JsonProperty("externalID")
    private java.lang.String externalID;
    @JsonProperty("instanceRef")
    private io.fabric8.servicecatalog.api.model.LocalObjectReference instanceRef;
    @JsonProperty("parameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> parameters = new LinkedHashMap<String, Object>();
    @JsonProperty("parametersFrom")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParametersFromSource> parametersFrom = new ArrayList<ParametersFromSource>();
    @JsonProperty("secretName")
    private java.lang.String secretName;
    @JsonProperty("secretTransforms")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretTransform> secretTransforms = new ArrayList<SecretTransform>();
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonIgnore
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceBindingSpec() {
    }

    /**
     * 
     * @param userInfo
     * @param secretName
     * @param parametersFrom
     * @param externalID
     * @param secretTransforms
     * @param instanceRef
     * @param parameters
     */
    public ServiceBindingSpec(java.lang.String externalID, io.fabric8.servicecatalog.api.model.LocalObjectReference instanceRef, Map<String, Object> parameters, List<ParametersFromSource> parametersFrom, java.lang.String secretName, List<SecretTransform> secretTransforms, UserInfo userInfo) {
        super();
        this.externalID = externalID;
        this.instanceRef = instanceRef;
        this.parameters = parameters;
        this.parametersFrom = parametersFrom;
        this.secretName = secretName;
        this.secretTransforms = secretTransforms;
        this.userInfo = userInfo;
    }

    @JsonProperty("externalID")
    public java.lang.String getExternalID() {
        return externalID;
    }

    @JsonProperty("externalID")
    public void setExternalID(java.lang.String externalID) {
        this.externalID = externalID;
    }

    @JsonProperty("instanceRef")
    public io.fabric8.servicecatalog.api.model.LocalObjectReference getInstanceRef() {
        return instanceRef;
    }

    @JsonProperty("instanceRef")
    public void setInstanceRef(io.fabric8.servicecatalog.api.model.LocalObjectReference instanceRef) {
        this.instanceRef = instanceRef;
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

    @JsonProperty("secretName")
    public java.lang.String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(java.lang.String secretName) {
        this.secretName = secretName;
    }

    @JsonProperty("secretTransforms")
    public List<SecretTransform> getSecretTransforms() {
        return secretTransforms;
    }

    @JsonProperty("secretTransforms")
    public void setSecretTransforms(List<SecretTransform> secretTransforms) {
        this.secretTransforms = secretTransforms;
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
