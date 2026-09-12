
package io.fabric8.kubernetes.api.model.node.v1alpha1;

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
 * RuntimeClassSpec is a specification of a RuntimeClass. It contains parameters that are required to describe the RuntimeClass to the Container Runtime Interface (CRI) implementation, as well as any other components that need to understand how the pod will be run. The RuntimeClassSpec is immutable.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overhead",
    "runtimeHandler",
    "scheduling"
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
public class RuntimeClassSpec implements Editable<RuntimeClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("overhead")
    private Overhead overhead;
    @JsonProperty("runtimeHandler")
    private String runtimeHandler;
    @JsonProperty("scheduling")
    private Scheduling scheduling;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RuntimeClassSpec() {
    }

    public RuntimeClassSpec(Overhead overhead, String runtimeHandler, Scheduling scheduling) {
        super();
        this.overhead = overhead;
        this.runtimeHandler = runtimeHandler;
        this.scheduling = scheduling;
    }

    /**
     * RuntimeClassSpec is a specification of a RuntimeClass. It contains parameters that are required to describe the RuntimeClass to the Container Runtime Interface (CRI) implementation, as well as any other components that need to understand how the pod will be run. The RuntimeClassSpec is immutable.
     */
    @JsonProperty("overhead")
    public Overhead getOverhead() {
        return overhead;
    }

    /**
     * RuntimeClassSpec is a specification of a RuntimeClass. It contains parameters that are required to describe the RuntimeClass to the Container Runtime Interface (CRI) implementation, as well as any other components that need to understand how the pod will be run. The RuntimeClassSpec is immutable.
     */
    @JsonProperty("overhead")
    public void setOverhead(Overhead overhead) {
        this.overhead = overhead;
    }

    /**
     * RuntimeHandler specifies the underlying runtime and configuration that the CRI implementation will use to handle pods of this class. The possible values are specific to the node &amp; CRI configuration.  It is assumed that all handlers are available on every node, and handlers of the same name are equivalent on every node. For example, a handler called "runc" might specify that the runc OCI runtime (using native Linux containers) will be used to run the containers in a pod. The RuntimeHandler must be lowercase, conform to the DNS Label (RFC 1123) requirements, and is immutable.
     */
    @JsonProperty("runtimeHandler")
    public String getRuntimeHandler() {
        return runtimeHandler;
    }

    /**
     * RuntimeHandler specifies the underlying runtime and configuration that the CRI implementation will use to handle pods of this class. The possible values are specific to the node &amp; CRI configuration.  It is assumed that all handlers are available on every node, and handlers of the same name are equivalent on every node. For example, a handler called "runc" might specify that the runc OCI runtime (using native Linux containers) will be used to run the containers in a pod. The RuntimeHandler must be lowercase, conform to the DNS Label (RFC 1123) requirements, and is immutable.
     */
    @JsonProperty("runtimeHandler")
    public void setRuntimeHandler(String runtimeHandler) {
        this.runtimeHandler = runtimeHandler;
    }

    /**
     * RuntimeClassSpec is a specification of a RuntimeClass. It contains parameters that are required to describe the RuntimeClass to the Container Runtime Interface (CRI) implementation, as well as any other components that need to understand how the pod will be run. The RuntimeClassSpec is immutable.
     */
    @JsonProperty("scheduling")
    public Scheduling getScheduling() {
        return scheduling;
    }

    /**
     * RuntimeClassSpec is a specification of a RuntimeClass. It contains parameters that are required to describe the RuntimeClass to the Container Runtime Interface (CRI) implementation, as well as any other components that need to understand how the pod will be run. The RuntimeClassSpec is immutable.
     */
    @JsonProperty("scheduling")
    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
    }

    @JsonIgnore
    public RuntimeClassSpecBuilder edit() {
        return new RuntimeClassSpecBuilder(this);
    }

    @JsonIgnore
    public RuntimeClassSpecBuilder toBuilder() {
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
        if (!(o instanceof RuntimeClassSpec)) {
            return false;
        }
        RuntimeClassSpec other = (RuntimeClassSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$overhead = this.getOverhead();
        Object other$overhead = other.getOverhead();
        if (this$overhead == null ? other$overhead != null : !this$overhead.equals(other$overhead)) {
            return false;
        }
        Object this$runtimeHandler = this.getRuntimeHandler();
        Object other$runtimeHandler = other.getRuntimeHandler();
        if (this$runtimeHandler == null ? other$runtimeHandler != null : !this$runtimeHandler.equals(other$runtimeHandler)) {
            return false;
        }
        Object this$scheduling = this.getScheduling();
        Object other$scheduling = other.getScheduling();
        if (this$scheduling == null ? other$scheduling != null : !this$scheduling.equals(other$scheduling)) {
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
        return other instanceof RuntimeClassSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $overhead = this.getOverhead();
        result = result * prime + ($overhead == null ? 43 : $overhead.hashCode());
        Object $runtimeHandler = this.getRuntimeHandler();
        result = result * prime + ($runtimeHandler == null ? 43 : $runtimeHandler.hashCode());
        Object $scheduling = this.getScheduling();
        result = result * prime + ($scheduling == null ? 43 : $scheduling.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RuntimeClassSpec(" + "overhead=" + this.getOverhead() + ", runtimeHandler=" + this.getRuntimeHandler() + ", scheduling=" + this.getScheduling() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
