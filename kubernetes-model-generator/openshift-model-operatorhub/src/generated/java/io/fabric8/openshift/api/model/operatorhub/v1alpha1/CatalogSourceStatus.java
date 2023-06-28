
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "conditions",
    "configMapReference",
    "connectionState",
    "latestImageRegistryPoll",
    "message",
    "reason",
    "registryService"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CatalogSourceStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("configMapReference")
    private ConfigMapResourceReference configMapReference;
    @JsonProperty("connectionState")
    private GRPCConnectionState connectionState;
    @JsonProperty("latestImageRegistryPoll")
    private String latestImageRegistryPoll;
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("reason")
    private java.lang.String reason;
    @JsonProperty("registryService")
    private RegistryServiceStatus registryService;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CatalogSourceStatus() {
    }

    public CatalogSourceStatus(List<Condition> conditions, ConfigMapResourceReference configMapReference, GRPCConnectionState connectionState, String latestImageRegistryPoll, java.lang.String message, java.lang.String reason, RegistryServiceStatus registryService) {
        super();
        this.conditions = conditions;
        this.configMapReference = configMapReference;
        this.connectionState = connectionState;
        this.latestImageRegistryPoll = latestImageRegistryPoll;
        this.message = message;
        this.reason = reason;
        this.registryService = registryService;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("configMapReference")
    public ConfigMapResourceReference getConfigMapReference() {
        return configMapReference;
    }

    @JsonProperty("configMapReference")
    public void setConfigMapReference(ConfigMapResourceReference configMapReference) {
        this.configMapReference = configMapReference;
    }

    @JsonProperty("connectionState")
    public GRPCConnectionState getConnectionState() {
        return connectionState;
    }

    @JsonProperty("connectionState")
    public void setConnectionState(GRPCConnectionState connectionState) {
        this.connectionState = connectionState;
    }

    @JsonProperty("latestImageRegistryPoll")
    public String getLatestImageRegistryPoll() {
        return latestImageRegistryPoll;
    }

    @JsonProperty("latestImageRegistryPoll")
    public void setLatestImageRegistryPoll(String latestImageRegistryPoll) {
        this.latestImageRegistryPoll = latestImageRegistryPoll;
    }

    @JsonProperty("message")
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @JsonProperty("reason")
    public java.lang.String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    @JsonProperty("registryService")
    public RegistryServiceStatus getRegistryService() {
        return registryService;
    }

    @JsonProperty("registryService")
    public void setRegistryService(RegistryServiceStatus registryService) {
        this.registryService = registryService;
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
