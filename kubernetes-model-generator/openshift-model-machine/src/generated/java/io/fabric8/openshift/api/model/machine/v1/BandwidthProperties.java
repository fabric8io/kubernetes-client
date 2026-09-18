
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
 * Bandwidth describes the bandwidth strategy for the network of the instance
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "internetMaxBandwidthIn",
    "internetMaxBandwidthOut"
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
public class BandwidthProperties implements Editable<BandwidthPropertiesBuilder>, KubernetesResource
{

    @JsonProperty("internetMaxBandwidthIn")
    private Long internetMaxBandwidthIn;
    @JsonProperty("internetMaxBandwidthOut")
    private Long internetMaxBandwidthOut;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BandwidthProperties() {
    }

    public BandwidthProperties(Long internetMaxBandwidthIn, Long internetMaxBandwidthOut) {
        super();
        this.internetMaxBandwidthIn = internetMaxBandwidthIn;
        this.internetMaxBandwidthOut = internetMaxBandwidthOut;
    }

    /**
     * internetMaxBandwidthIn is the maximum inbound public bandwidth. Unit: Mbit/s. Valid values: When the purchased outbound public bandwidth is less than or equal to 10 Mbit/s, the valid values of this parameter are 1 to 10. Currently the default is `10` when outbound bandwidth is less than or equal to 10 Mbit/s. When the purchased outbound public bandwidth is greater than 10, the valid values are 1 to the InternetMaxBandwidthOut value. Currently the default is the value used for `InternetMaxBandwidthOut` when outbound public bandwidth is greater than 10.
     */
    @JsonProperty("internetMaxBandwidthIn")
    public Long getInternetMaxBandwidthIn() {
        return internetMaxBandwidthIn;
    }

    /**
     * internetMaxBandwidthIn is the maximum inbound public bandwidth. Unit: Mbit/s. Valid values: When the purchased outbound public bandwidth is less than or equal to 10 Mbit/s, the valid values of this parameter are 1 to 10. Currently the default is `10` when outbound bandwidth is less than or equal to 10 Mbit/s. When the purchased outbound public bandwidth is greater than 10, the valid values are 1 to the InternetMaxBandwidthOut value. Currently the default is the value used for `InternetMaxBandwidthOut` when outbound public bandwidth is greater than 10.
     */
    @JsonProperty("internetMaxBandwidthIn")
    public void setInternetMaxBandwidthIn(Long internetMaxBandwidthIn) {
        this.internetMaxBandwidthIn = internetMaxBandwidthIn;
    }

    /**
     * internetMaxBandwidthOut is the maximum outbound public bandwidth. Unit: Mbit/s. Valid values: 0 to 100. When a value greater than 0 is used then a public IP address is assigned to the instance. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `0`
     */
    @JsonProperty("internetMaxBandwidthOut")
    public Long getInternetMaxBandwidthOut() {
        return internetMaxBandwidthOut;
    }

    /**
     * internetMaxBandwidthOut is the maximum outbound public bandwidth. Unit: Mbit/s. Valid values: 0 to 100. When a value greater than 0 is used then a public IP address is assigned to the instance. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `0`
     */
    @JsonProperty("internetMaxBandwidthOut")
    public void setInternetMaxBandwidthOut(Long internetMaxBandwidthOut) {
        this.internetMaxBandwidthOut = internetMaxBandwidthOut;
    }

    @JsonIgnore
    public BandwidthPropertiesBuilder edit() {
        return new BandwidthPropertiesBuilder(this);
    }

    @JsonIgnore
    public BandwidthPropertiesBuilder toBuilder() {
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
        if (!(o instanceof BandwidthProperties)) {
            return false;
        }
        BandwidthProperties other = (BandwidthProperties) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$internetMaxBandwidthIn = this.getInternetMaxBandwidthIn();
        Object other$internetMaxBandwidthIn = other.getInternetMaxBandwidthIn();
        if (this$internetMaxBandwidthIn == null ? other$internetMaxBandwidthIn != null : !this$internetMaxBandwidthIn.equals(other$internetMaxBandwidthIn)) {
            return false;
        }
        Object this$internetMaxBandwidthOut = this.getInternetMaxBandwidthOut();
        Object other$internetMaxBandwidthOut = other.getInternetMaxBandwidthOut();
        if (this$internetMaxBandwidthOut == null ? other$internetMaxBandwidthOut != null : !this$internetMaxBandwidthOut.equals(other$internetMaxBandwidthOut)) {
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
        return other instanceof BandwidthProperties;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $internetMaxBandwidthIn = this.getInternetMaxBandwidthIn();
        result = result * prime + ($internetMaxBandwidthIn == null ? 43 : $internetMaxBandwidthIn.hashCode());
        Object $internetMaxBandwidthOut = this.getInternetMaxBandwidthOut();
        result = result * prime + ($internetMaxBandwidthOut == null ? 43 : $internetMaxBandwidthOut.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BandwidthProperties(" + "internetMaxBandwidthIn=" + this.getInternetMaxBandwidthIn() + ", internetMaxBandwidthOut=" + this.getInternetMaxBandwidthOut() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
