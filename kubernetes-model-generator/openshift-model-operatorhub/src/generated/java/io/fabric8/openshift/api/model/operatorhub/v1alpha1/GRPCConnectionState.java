
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "address",
    "lastConnect",
    "lastObservedState"
})
@ToString
@EqualsAndHashCode
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
public class GRPCConnectionState implements KubernetesResource
{

    @JsonProperty("address")
    private java.lang.String address;
    @JsonProperty("lastConnect")
    private String lastConnect;
    @JsonProperty("lastObservedState")
    private java.lang.String lastObservedState;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GRPCConnectionState() {
    }

    /**
     * 
     * @param address
     * @param lastConnect
     * @param lastObservedState
     */
    public GRPCConnectionState(java.lang.String address, String lastConnect, java.lang.String lastObservedState) {
        super();
        this.address = address;
        this.lastConnect = lastConnect;
        this.lastObservedState = lastObservedState;
    }

    @JsonProperty("address")
    public java.lang.String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    @JsonProperty("lastConnect")
    public String getLastConnect() {
        return lastConnect;
    }

    @JsonProperty("lastConnect")
    public void setLastConnect(String lastConnect) {
        this.lastConnect = lastConnect;
    }

    @JsonProperty("lastObservedState")
    public java.lang.String getLastObservedState() {
        return lastObservedState;
    }

    @JsonProperty("lastObservedState")
    public void setLastObservedState(java.lang.String lastObservedState) {
        this.lastObservedState = lastObservedState;
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
