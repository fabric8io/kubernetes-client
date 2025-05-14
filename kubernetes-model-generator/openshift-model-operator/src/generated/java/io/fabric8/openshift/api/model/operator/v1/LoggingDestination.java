
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
 * LoggingDestination describes a destination for log messages.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "container",
    "syslog",
    "type"
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
public class LoggingDestination implements Editable<LoggingDestinationBuilder>, KubernetesResource
{

    @JsonProperty("container")
    private ContainerLoggingDestinationParameters container;
    @JsonProperty("syslog")
    private SyslogLoggingDestinationParameters syslog;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoggingDestination() {
    }

    public LoggingDestination(ContainerLoggingDestinationParameters container, SyslogLoggingDestinationParameters syslog, String type) {
        super();
        this.container = container;
        this.syslog = syslog;
        this.type = type;
    }

    /**
     * LoggingDestination describes a destination for log messages.
     */
    @JsonProperty("container")
    public ContainerLoggingDestinationParameters getContainer() {
        return container;
    }

    /**
     * LoggingDestination describes a destination for log messages.
     */
    @JsonProperty("container")
    public void setContainer(ContainerLoggingDestinationParameters container) {
        this.container = container;
    }

    /**
     * LoggingDestination describes a destination for log messages.
     */
    @JsonProperty("syslog")
    public SyslogLoggingDestinationParameters getSyslog() {
        return syslog;
    }

    /**
     * LoggingDestination describes a destination for log messages.
     */
    @JsonProperty("syslog")
    public void setSyslog(SyslogLoggingDestinationParameters syslog) {
        this.syslog = syslog;
    }

    /**
     * type is the type of destination for logs.  It must be one of the following:<br><p> <br><p> &#42; Container<br><p> <br><p> The ingress operator configures the sidecar container named "logs" on the ingress controller pod and configures the ingress controller to write logs to the sidecar.  The logs are then available as container logs.  The expectation is that the administrator configures a custom logging solution that reads logs from this sidecar.  Note that using container logs means that logs may be dropped if the rate of logs exceeds the container runtime's or the custom logging solution's capacity.<br><p> <br><p> &#42; Syslog<br><p> <br><p> Logs are sent to a syslog endpoint.  The administrator must specify an endpoint that can receive syslog messages.  The expectation is that the administrator has configured a custom syslog instance.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of destination for logs.  It must be one of the following:<br><p> <br><p> &#42; Container<br><p> <br><p> The ingress operator configures the sidecar container named "logs" on the ingress controller pod and configures the ingress controller to write logs to the sidecar.  The logs are then available as container logs.  The expectation is that the administrator configures a custom logging solution that reads logs from this sidecar.  Note that using container logs means that logs may be dropped if the rate of logs exceeds the container runtime's or the custom logging solution's capacity.<br><p> <br><p> &#42; Syslog<br><p> <br><p> Logs are sent to a syslog endpoint.  The administrator must specify an endpoint that can receive syslog messages.  The expectation is that the administrator has configured a custom syslog instance.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public LoggingDestinationBuilder edit() {
        return new LoggingDestinationBuilder(this);
    }

    @JsonIgnore
    public LoggingDestinationBuilder toBuilder() {
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
