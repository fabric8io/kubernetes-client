
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * `OutboundTrafficPolicy` sets the default behavior of the sidecar for handling unknown outbound traffic from the application.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "egressProxy",
    "mode"
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
public class OutboundTrafficPolicy implements Editable<OutboundTrafficPolicyBuilder>, KubernetesResource
{

    @JsonProperty("egressProxy")
    private Destination egressProxy;
    @JsonProperty("mode")
    private OutboundTrafficPolicyMode mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OutboundTrafficPolicy() {
    }

    public OutboundTrafficPolicy(Destination egressProxy, OutboundTrafficPolicyMode mode) {
        super();
        this.egressProxy = egressProxy;
        this.mode = mode;
    }

    /**
     * `OutboundTrafficPolicy` sets the default behavior of the sidecar for handling unknown outbound traffic from the application.
     */
    @JsonProperty("egressProxy")
    public Destination getEgressProxy() {
        return egressProxy;
    }

    /**
     * `OutboundTrafficPolicy` sets the default behavior of the sidecar for handling unknown outbound traffic from the application.
     */
    @JsonProperty("egressProxy")
    public void setEgressProxy(Destination egressProxy) {
        this.egressProxy = egressProxy;
    }

    /**
     * `OutboundTrafficPolicy` sets the default behavior of the sidecar for handling unknown outbound traffic from the application.
     */
    @JsonProperty("mode")
    public OutboundTrafficPolicyMode getMode() {
        return mode;
    }

    /**
     * `OutboundTrafficPolicy` sets the default behavior of the sidecar for handling unknown outbound traffic from the application.
     */
    @JsonProperty("mode")
    public void setMode(OutboundTrafficPolicyMode mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public OutboundTrafficPolicyBuilder edit() {
        return new OutboundTrafficPolicyBuilder(this);
    }

    @JsonIgnore
    public OutboundTrafficPolicyBuilder toBuilder() {
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
        if (!(o instanceof OutboundTrafficPolicy)) {
            return false;
        }
        OutboundTrafficPolicy other = (OutboundTrafficPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$egressProxy = this.getEgressProxy();
        Object other$egressProxy = other.getEgressProxy();
        if (this$egressProxy == null ? other$egressProxy != null : !this$egressProxy.equals(other$egressProxy)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
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
        return other instanceof OutboundTrafficPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $egressProxy = this.getEgressProxy();
        result = result * prime + ($egressProxy == null ? 43 : $egressProxy.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OutboundTrafficPolicy(" + "egressProxy=" + this.getEgressProxy() + ", mode=" + this.getMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
