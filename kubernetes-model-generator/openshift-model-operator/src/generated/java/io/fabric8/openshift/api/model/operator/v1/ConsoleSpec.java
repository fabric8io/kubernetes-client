
package io.fabric8.openshift.api.model.operator.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "customization",
    "logLevel",
    "managementState",
    "observedConfig",
    "operatorLogLevel",
    "providers",
    "route",
    "unsupportedConfigOverrides"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ConsoleSpec implements KubernetesResource
{

    @JsonProperty("customization")
    private ConsoleCustomization customization;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("observedConfig")
    private HasMetadata observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("providers")
    private ConsoleProviders providers;
    @JsonProperty("route")
    private ConsoleConfigRoute route;
    @JsonProperty("unsupportedConfigOverrides")
    private HasMetadata unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConsoleSpec() {
    }

    /**
     * 
     * @param route
     * @param logLevel
     * @param customization
     * @param unsupportedConfigOverrides
     * @param operatorLogLevel
     * @param observedConfig
     * @param providers
     * @param managementState
     */
    public ConsoleSpec(ConsoleCustomization customization, String logLevel, String managementState, HasMetadata observedConfig, String operatorLogLevel, ConsoleProviders providers, ConsoleConfigRoute route, HasMetadata unsupportedConfigOverrides) {
        super();
        this.customization = customization;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.providers = providers;
        this.route = route;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonProperty("customization")
    public ConsoleCustomization getCustomization() {
        return customization;
    }

    @JsonProperty("customization")
    public void setCustomization(ConsoleCustomization customization) {
        this.customization = customization;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    @JsonProperty("observedConfig")
    public HasMetadata getObservedConfig() {
        return observedConfig;
    }

    @JsonProperty("observedConfig")
    public void setObservedConfig(HasMetadata observedConfig) {
        this.observedConfig = observedConfig;
    }

    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    @JsonProperty("providers")
    public ConsoleProviders getProviders() {
        return providers;
    }

    @JsonProperty("providers")
    public void setProviders(ConsoleProviders providers) {
        this.providers = providers;
    }

    @JsonProperty("route")
    public ConsoleConfigRoute getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(ConsoleConfigRoute route) {
        this.route = route;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public HasMetadata getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public void setUnsupportedConfigOverrides(HasMetadata unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
