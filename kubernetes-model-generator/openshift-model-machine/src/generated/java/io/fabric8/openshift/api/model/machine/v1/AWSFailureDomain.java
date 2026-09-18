
package io.fabric8.openshift.api.model.machine.v1;

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
 * AWSFailureDomain configures failure domain information for the AWS platform.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "placement",
    "subnet"
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
public class AWSFailureDomain implements Editable<AWSFailureDomainBuilder>, KubernetesResource
{

    @JsonProperty("placement")
    private AWSFailureDomainPlacement placement;
    @JsonProperty("subnet")
    private AWSResourceReference subnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSFailureDomain() {
    }

    public AWSFailureDomain(AWSFailureDomainPlacement placement, AWSResourceReference subnet) {
        super();
        this.placement = placement;
        this.subnet = subnet;
    }

    /**
     * AWSFailureDomain configures failure domain information for the AWS platform.
     */
    @JsonProperty("placement")
    public AWSFailureDomainPlacement getPlacement() {
        return placement;
    }

    /**
     * AWSFailureDomain configures failure domain information for the AWS platform.
     */
    @JsonProperty("placement")
    public void setPlacement(AWSFailureDomainPlacement placement) {
        this.placement = placement;
    }

    /**
     * AWSFailureDomain configures failure domain information for the AWS platform.
     */
    @JsonProperty("subnet")
    public AWSResourceReference getSubnet() {
        return subnet;
    }

    /**
     * AWSFailureDomain configures failure domain information for the AWS platform.
     */
    @JsonProperty("subnet")
    public void setSubnet(AWSResourceReference subnet) {
        this.subnet = subnet;
    }

    @JsonIgnore
    public AWSFailureDomainBuilder edit() {
        return new AWSFailureDomainBuilder(this);
    }

    @JsonIgnore
    public AWSFailureDomainBuilder toBuilder() {
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
        if (!(o instanceof AWSFailureDomain)) {
            return false;
        }
        AWSFailureDomain other = (AWSFailureDomain) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$placement = this.getPlacement();
        Object other$placement = other.getPlacement();
        if (this$placement == null ? other$placement != null : !this$placement.equals(other$placement)) {
            return false;
        }
        Object this$subnet = this.getSubnet();
        Object other$subnet = other.getSubnet();
        if (this$subnet == null ? other$subnet != null : !this$subnet.equals(other$subnet)) {
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
        return other instanceof AWSFailureDomain;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $placement = this.getPlacement();
        result = result * prime + ($placement == null ? 43 : $placement.hashCode());
        Object $subnet = this.getSubnet();
        result = result * prime + ($subnet == null ? 43 : $subnet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSFailureDomain(" + "placement=" + this.getPlacement() + ", subnet=" + this.getSubnet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
