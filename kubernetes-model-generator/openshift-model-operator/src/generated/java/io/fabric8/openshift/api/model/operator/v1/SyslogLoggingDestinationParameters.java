
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
