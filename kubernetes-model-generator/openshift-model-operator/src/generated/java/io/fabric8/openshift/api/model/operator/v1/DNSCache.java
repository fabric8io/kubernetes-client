
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
 * DNSCache defines the fields for configuring DNS caching.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "negativeTTL",
    "positiveTTL"
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
public class DNSCache implements Editable<DNSCacheBuilder>, KubernetesResource
{

    @JsonProperty("negativeTTL")
    private String negativeTTL;
    @JsonProperty("positiveTTL")
    private String positiveTTL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSCache() {
    }

    public DNSCache(String negativeTTL, String positiveTTL) {
        super();
        this.negativeTTL = negativeTTL;
        this.positiveTTL = positiveTTL;
    }

    /**
     * DNSCache defines the fields for configuring DNS caching.
     */
    @JsonProperty("negativeTTL")
    public String getNegativeTTL() {
        return negativeTTL;
    }

    /**
     * DNSCache defines the fields for configuring DNS caching.
     */
    @JsonProperty("negativeTTL")
    public void setNegativeTTL(String negativeTTL) {
        this.negativeTTL = negativeTTL;
    }

    /**
     * DNSCache defines the fields for configuring DNS caching.
     */
    @JsonProperty("positiveTTL")
    public String getPositiveTTL() {
        return positiveTTL;
    }

    /**
     * DNSCache defines the fields for configuring DNS caching.
     */
    @JsonProperty("positiveTTL")
    public void setPositiveTTL(String positiveTTL) {
        this.positiveTTL = positiveTTL;
    }

    @JsonIgnore
    public DNSCacheBuilder edit() {
        return new DNSCacheBuilder(this);
    }

    @JsonIgnore
    public DNSCacheBuilder toBuilder() {
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
        if (!(o instanceof DNSCache)) {
            return false;
        }
        DNSCache other = (DNSCache) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$negativeTTL = this.getNegativeTTL();
        Object other$negativeTTL = other.getNegativeTTL();
        if (this$negativeTTL == null ? other$negativeTTL != null : !this$negativeTTL.equals(other$negativeTTL)) {
            return false;
        }
        Object this$positiveTTL = this.getPositiveTTL();
        Object other$positiveTTL = other.getPositiveTTL();
        if (this$positiveTTL == null ? other$positiveTTL != null : !this$positiveTTL.equals(other$positiveTTL)) {
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
        return other instanceof DNSCache;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $negativeTTL = this.getNegativeTTL();
        result = result * prime + ($negativeTTL == null ? 43 : $negativeTTL.hashCode());
        Object $positiveTTL = this.getPositiveTTL();
        result = result * prime + ($positiveTTL == null ? 43 : $positiveTTL.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSCache(" + "negativeTTL=" + this.getNegativeTTL() + ", positiveTTL=" + this.getPositiveTTL() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
