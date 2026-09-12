
package io.fabric8.knative.internal.networking.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
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

/**
 * ServerlessServiceSpec describes the ServerlessService.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode",
    "numActivators",
    "objectRef",
    "protocolType"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ServerlessServiceSpec implements Editable<ServerlessServiceSpecBuilder>, KubernetesResource
{

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("numActivators")
    private Integer numActivators;
    @JsonProperty("objectRef")
    private ObjectReference objectRef;
    @JsonProperty("protocolType")
    private String protocolType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServerlessServiceSpec() {
    }

    public ServerlessServiceSpec(String mode, Integer numActivators, ObjectReference objectRef, String protocolType) {
        super();
        this.mode = mode;
        this.numActivators = numActivators;
        this.objectRef = objectRef;
        this.protocolType = protocolType;
    }

    /**
     * Mode describes the mode of operation of the ServerlessService.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode describes the mode of operation of the ServerlessService.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * NumActivators contains number of Activators that this revision should be assigned. O means — assign all.
     */
    @JsonProperty("numActivators")
    public Integer getNumActivators() {
        return numActivators;
    }

    /**
     * NumActivators contains number of Activators that this revision should be assigned. O means — assign all.
     */
    @JsonProperty("numActivators")
    public void setNumActivators(Integer numActivators) {
        this.numActivators = numActivators;
    }

    /**
     * ServerlessServiceSpec describes the ServerlessService.
     */
    @JsonProperty("objectRef")
    public ObjectReference getObjectRef() {
        return objectRef;
    }

    /**
     * ServerlessServiceSpec describes the ServerlessService.
     */
    @JsonProperty("objectRef")
    public void setObjectRef(ObjectReference objectRef) {
        this.objectRef = objectRef;
    }

    /**
     * The application-layer protocol. Matches `RevisionProtocolType` set on the owning pa/revision. serving imports networking, so just use string.
     */
    @JsonProperty("protocolType")
    public String getProtocolType() {
        return protocolType;
    }

    /**
     * The application-layer protocol. Matches `RevisionProtocolType` set on the owning pa/revision. serving imports networking, so just use string.
     */
    @JsonProperty("protocolType")
    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    @JsonIgnore
    public ServerlessServiceSpecBuilder edit() {
        return new ServerlessServiceSpecBuilder(this);
    }

    @JsonIgnore
    public ServerlessServiceSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ServerlessServiceSpec)) {
            return false;
        }
        ServerlessServiceSpec other = (ServerlessServiceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$numActivators = this.getNumActivators();
        Object other$numActivators = other.getNumActivators();
        if (this$numActivators == null ? other$numActivators != null : !this$numActivators.equals(other$numActivators)) {
            return false;
        }
        Object this$objectRef = this.getObjectRef();
        Object other$objectRef = other.getObjectRef();
        if (this$objectRef == null ? other$objectRef != null : !this$objectRef.equals(other$objectRef)) {
            return false;
        }
        Object this$protocolType = this.getProtocolType();
        Object other$protocolType = other.getProtocolType();
        if (this$protocolType == null ? other$protocolType != null : !this$protocolType.equals(other$protocolType)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ServerlessServiceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $numActivators = this.getNumActivators();
        result = result * prime + ($numActivators == null ? 43 : $numActivators.hashCode());
        Object $objectRef = this.getObjectRef();
        result = result * prime + ($objectRef == null ? 43 : $objectRef.hashCode());
        Object $protocolType = this.getProtocolType();
        result = result * prime + ($protocolType == null ? 43 : $protocolType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ServerlessServiceSpec(" + "mode=" + this.getMode() + ", numActivators=" + this.getNumActivators() + ", objectRef=" + this.getObjectRef() + ", protocolType=" + this.getProtocolType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
