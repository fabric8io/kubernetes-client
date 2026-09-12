
package io.fabric8.openshift.api.model.operator.v1;

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
 * EgressIPConfig defines the configuration knobs for egressip
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reachabilityTotalTimeoutSeconds"
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
public class EgressIPConfig implements Editable<EgressIPConfigBuilder>, KubernetesResource
{

    @JsonProperty("reachabilityTotalTimeoutSeconds")
    private Long reachabilityTotalTimeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressIPConfig() {
    }

    public EgressIPConfig(Long reachabilityTotalTimeoutSeconds) {
        super();
        this.reachabilityTotalTimeoutSeconds = reachabilityTotalTimeoutSeconds;
    }

    /**
     * reachabilityTotalTimeout configures the EgressIP node reachability check total timeout in seconds. If the EgressIP node cannot be reached within this timeout, the node is declared down. Setting a large value may cause the EgressIP feature to react slowly to node changes. In particular, it may react slowly for EgressIP nodes that really have a genuine problem and are unreachable. When omitted, this means the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 1 second. A value of 0 disables the EgressIP node's reachability check.
     */
    @JsonProperty("reachabilityTotalTimeoutSeconds")
    public Long getReachabilityTotalTimeoutSeconds() {
        return reachabilityTotalTimeoutSeconds;
    }

    /**
     * reachabilityTotalTimeout configures the EgressIP node reachability check total timeout in seconds. If the EgressIP node cannot be reached within this timeout, the node is declared down. Setting a large value may cause the EgressIP feature to react slowly to node changes. In particular, it may react slowly for EgressIP nodes that really have a genuine problem and are unreachable. When omitted, this means the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 1 second. A value of 0 disables the EgressIP node's reachability check.
     */
    @JsonProperty("reachabilityTotalTimeoutSeconds")
    public void setReachabilityTotalTimeoutSeconds(Long reachabilityTotalTimeoutSeconds) {
        this.reachabilityTotalTimeoutSeconds = reachabilityTotalTimeoutSeconds;
    }

    @JsonIgnore
    public EgressIPConfigBuilder edit() {
        return new EgressIPConfigBuilder(this);
    }

    @JsonIgnore
    public EgressIPConfigBuilder toBuilder() {
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
        if (!(o instanceof EgressIPConfig)) {
            return false;
        }
        EgressIPConfig other = (EgressIPConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$reachabilityTotalTimeoutSeconds = this.getReachabilityTotalTimeoutSeconds();
        Object other$reachabilityTotalTimeoutSeconds = other.getReachabilityTotalTimeoutSeconds();
        if (this$reachabilityTotalTimeoutSeconds == null ? other$reachabilityTotalTimeoutSeconds != null : !this$reachabilityTotalTimeoutSeconds.equals(other$reachabilityTotalTimeoutSeconds)) {
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
        return other instanceof EgressIPConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $reachabilityTotalTimeoutSeconds = this.getReachabilityTotalTimeoutSeconds();
        result = result * prime + ($reachabilityTotalTimeoutSeconds == null ? 43 : $reachabilityTotalTimeoutSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EgressIPConfig(" + "reachabilityTotalTimeoutSeconds=" + this.getReachabilityTotalTimeoutSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
