
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
 * SyslogLoggingDestinationParameters describes parameters for the Syslog logging destination type.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "facility",
    "maxLength",
    "port"
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
public class SyslogLoggingDestinationParameters implements Editable<SyslogLoggingDestinationParametersBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private String address;
    @JsonProperty("facility")
    private String facility;
    @JsonProperty("maxLength")
    private Long maxLength;
    @JsonProperty("port")
    private Long port;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SyslogLoggingDestinationParameters() {
    }

    public SyslogLoggingDestinationParameters(String address, String facility, Long maxLength, Long port) {
        super();
        this.address = address;
        this.facility = facility;
        this.maxLength = maxLength;
        this.port = port;
    }

    /**
     * address is the IP address of the syslog endpoint that receives log messages.
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * address is the IP address of the syslog endpoint that receives log messages.
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * facility specifies the syslog facility of log messages.<br><p> <br><p> If this field is empty, the facility is "local1".
     */
    @JsonProperty("facility")
    public String getFacility() {
        return facility;
    }

    /**
     * facility specifies the syslog facility of log messages.<br><p> <br><p> If this field is empty, the facility is "local1".
     */
    @JsonProperty("facility")
    public void setFacility(String facility) {
        this.facility = facility;
    }

    /**
     * maxLength is the maximum length of the log message.<br><p> <br><p> Valid values are integers in the range 480 to 4096, inclusive.<br><p> <br><p> When omitted, the default value is 1024.
     */
    @JsonProperty("maxLength")
    public Long getMaxLength() {
        return maxLength;
    }

    /**
     * maxLength is the maximum length of the log message.<br><p> <br><p> Valid values are integers in the range 480 to 4096, inclusive.<br><p> <br><p> When omitted, the default value is 1024.
     */
    @JsonProperty("maxLength")
    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * port is the UDP port number of the syslog endpoint that receives log messages.
     */
    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    /**
     * port is the UDP port number of the syslog endpoint that receives log messages.
     */
    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    @JsonIgnore
    public SyslogLoggingDestinationParametersBuilder edit() {
        return new SyslogLoggingDestinationParametersBuilder(this);
    }

    @JsonIgnore
    public SyslogLoggingDestinationParametersBuilder toBuilder() {
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
        if (!(o instanceof SyslogLoggingDestinationParameters)) {
            return false;
        }
        SyslogLoggingDestinationParameters other = (SyslogLoggingDestinationParameters) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$address = this.getAddress();
        Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
            return false;
        }
        Object this$facility = this.getFacility();
        Object other$facility = other.getFacility();
        if (this$facility == null ? other$facility != null : !this$facility.equals(other$facility)) {
            return false;
        }
        Object this$maxLength = this.getMaxLength();
        Object other$maxLength = other.getMaxLength();
        if (this$maxLength == null ? other$maxLength != null : !this$maxLength.equals(other$maxLength)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
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
        return other instanceof SyslogLoggingDestinationParameters;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $address = this.getAddress();
        result = result * prime + ($address == null ? 43 : $address.hashCode());
        Object $facility = this.getFacility();
        result = result * prime + ($facility == null ? 43 : $facility.hashCode());
        Object $maxLength = this.getMaxLength();
        result = result * prime + ($maxLength == null ? 43 : $maxLength.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SyslogLoggingDestinationParameters(" + "address=" + this.getAddress() + ", facility=" + this.getFacility() + ", maxLength=" + this.getMaxLength() + ", port=" + this.getPort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
