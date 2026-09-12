
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
 * Hash based on a specific HTTP header.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpHeaderName"
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
public class LoadBalancerSettingsConsistentHashLBHttpHeaderName implements IsLoadBalancerSettingsConsistentHashLBHashKey, Editable<LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder>, KubernetesResource
{

    @JsonProperty("httpHeaderName")
    private String httpHeaderName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerSettingsConsistentHashLBHttpHeaderName() {
    }

    public LoadBalancerSettingsConsistentHashLBHttpHeaderName(String httpHeaderName) {
        super();
        this.httpHeaderName = httpHeaderName;
    }

    /**
     * Hash based on a specific HTTP header.
     */
    @JsonProperty("httpHeaderName")
    public String getHttpHeaderName() {
        return httpHeaderName;
    }

    /**
     * Hash based on a specific HTTP header.
     */
    @JsonProperty("httpHeaderName")
    public void setHttpHeaderName(String httpHeaderName) {
        this.httpHeaderName = httpHeaderName;
    }

    @JsonIgnore
    public LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder edit() {
        return new LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder toBuilder() {
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
        if (!(o instanceof LoadBalancerSettingsConsistentHashLBHttpHeaderName)) {
            return false;
        }
        LoadBalancerSettingsConsistentHashLBHttpHeaderName other = (LoadBalancerSettingsConsistentHashLBHttpHeaderName) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$httpHeaderName = this.getHttpHeaderName();
        Object other$httpHeaderName = other.getHttpHeaderName();
        if (this$httpHeaderName == null ? other$httpHeaderName != null : !this$httpHeaderName.equals(other$httpHeaderName)) {
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
        return other instanceof LoadBalancerSettingsConsistentHashLBHttpHeaderName;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $httpHeaderName = this.getHttpHeaderName();
        result = result * prime + ($httpHeaderName == null ? 43 : $httpHeaderName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LoadBalancerSettingsConsistentHashLBHttpHeaderName(" + "httpHeaderName=" + this.getHttpHeaderName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
