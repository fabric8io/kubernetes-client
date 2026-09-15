
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceQuotaSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterResourceQuotaSpec defines the desired quota restrictions
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "quota",
    "selector"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterResourceQuotaSpec implements Editable<ClusterResourceQuotaSpecBuilder>, KubernetesResource
{

    @JsonProperty("quota")
    private ResourceQuotaSpec quota;
    @JsonProperty("selector")
    private ClusterResourceQuotaSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterResourceQuotaSpec() {
    }

    public ClusterResourceQuotaSpec(ResourceQuotaSpec quota, ClusterResourceQuotaSelector selector) {
        super();
        this.quota = quota;
        this.selector = selector;
    }

    /**
     * ClusterResourceQuotaSpec defines the desired quota restrictions
     */
    @JsonProperty("quota")
    public ResourceQuotaSpec getQuota() {
        return quota;
    }

    /**
     * ClusterResourceQuotaSpec defines the desired quota restrictions
     */
    @JsonProperty("quota")
    public void setQuota(ResourceQuotaSpec quota) {
        this.quota = quota;
    }

    /**
     * ClusterResourceQuotaSpec defines the desired quota restrictions
     */
    @JsonProperty("selector")
    public ClusterResourceQuotaSelector getSelector() {
        return selector;
    }

    /**
     * ClusterResourceQuotaSpec defines the desired quota restrictions
     */
    @JsonProperty("selector")
    public void setSelector(ClusterResourceQuotaSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public ClusterResourceQuotaSpecBuilder edit() {
        return new ClusterResourceQuotaSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterResourceQuotaSpecBuilder toBuilder() {
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
        if (!(o instanceof ClusterResourceQuotaSpec)) {
            return false;
        }
        ClusterResourceQuotaSpec other = (ClusterResourceQuotaSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$quota = this.getQuota();
        Object other$quota = other.getQuota();
        if (this$quota == null ? other$quota != null : !this$quota.equals(other$quota)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
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
        return other instanceof ClusterResourceQuotaSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $quota = this.getQuota();
        result = result * prime + ($quota == null ? 43 : $quota.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterResourceQuotaSpec(" + "quota=" + this.getQuota() + ", selector=" + this.getSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
