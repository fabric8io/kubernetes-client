
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * ConsoleSpec is the specification of the desired behavior of the Console.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customization",
    "ingress",
    "logLevel",
    "managementState",
    "observedConfig",
    "operatorLogLevel",
    "plugins",
    "providers",
    "route",
    "unsupportedConfigOverrides"
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
public class ConsoleSpec implements Editable<ConsoleSpecBuilder>, KubernetesResource
{

    @JsonProperty("customization")
    private ConsoleCustomization customization;
    @JsonProperty("ingress")
    private Ingress ingress;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("plugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> plugins = new ArrayList<>();
    @JsonProperty("providers")
    private ConsoleProviders providers;
    @JsonProperty("route")
    private ConsoleConfigRoute route;
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleSpec() {
    }

    public ConsoleSpec(ConsoleCustomization customization, Ingress ingress, String logLevel, String managementState, Object observedConfig, String operatorLogLevel, List<String> plugins, ConsoleProviders providers, ConsoleConfigRoute route, Object unsupportedConfigOverrides) {
        super();
        this.customization = customization;
        this.ingress = ingress;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.plugins = plugins;
        this.providers = providers;
        this.route = route;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("customization")
    public ConsoleCustomization getCustomization() {
        return customization;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("customization")
    public void setCustomization(ConsoleCustomization customization) {
        this.customization = customization;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("ingress")
    public Ingress getIngress() {
        return ingress;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("ingress")
    public void setIngress(Ingress ingress) {
        this.ingress = ingress;
    }

    /**
     * logLevel is an intent based logging for an overall component.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for their operands.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel is an intent based logging for an overall component.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for their operands.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("observedConfig")
    public Object getObservedConfig() {
        return observedConfig;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setObservedConfig(Object observedConfig) {
        this.observedConfig = observedConfig;
    }

    /**
     * operatorLogLevel is an intent based logging for the operator itself.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for themselves.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    /**
     * operatorLogLevel is an intent based logging for the operator itself.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for themselves.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    /**
     * plugins defines a list of enabled console plugin names.
     */
    @JsonProperty("plugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPlugins() {
        return plugins;
    }

    /**
     * plugins defines a list of enabled console plugin names.
     */
    @JsonProperty("plugins")
    public void setPlugins(List<String> plugins) {
        this.plugins = plugins;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("providers")
    public ConsoleProviders getProviders() {
        return providers;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("providers")
    public void setProviders(ConsoleProviders providers) {
        this.providers = providers;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("route")
    public ConsoleConfigRoute getRoute() {
        return route;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("route")
    public void setRoute(ConsoleConfigRoute route) {
        this.route = route;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    /**
     * ConsoleSpec is the specification of the desired behavior of the Console.
     */
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonIgnore
    public ConsoleSpecBuilder edit() {
        return new ConsoleSpecBuilder(this);
    }

    @JsonIgnore
    public ConsoleSpecBuilder toBuilder() {
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
