
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "plugins",
    "providers",
    "route",
    "unsupportedConfigOverrides"
})
@ToString
@EqualsAndHashCode
@Setter
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
    private KubernetesResource observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("plugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> plugins = new ArrayList<String>();
    @JsonProperty("providers")
    private ConsoleProviders providers;
    @JsonProperty("route")
    private ConsoleConfigRoute route;
    @JsonProperty("unsupportedConfigOverrides")
    private KubernetesResource unsupportedConfigOverrides;
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
     * @param plugins
     * @param unsupportedConfigOverrides
     * @param operatorLogLevel
     * @param observedConfig
     * @param providers
     * @param managementState
     */
    public ConsoleSpec(ConsoleCustomization customization, String logLevel, String managementState, KubernetesResource observedConfig, String operatorLogLevel, List<String> plugins, ConsoleProviders providers, ConsoleConfigRoute route, KubernetesResource unsupportedConfigOverrides) {
        super();
        this.customization = customization;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.plugins = plugins;
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
    public KubernetesResource getObservedConfig() {
        return observedConfig;
    }

    @JsonProperty("observedConfig")
    public void setObservedConfig(KubernetesResource observedConfig) {
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

    @JsonProperty("plugins")
    public List<String> getPlugins() {
        return plugins;
    }

    @JsonProperty("plugins")
    public void setPlugins(List<String> plugins) {
        this.plugins = plugins;
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
    public KubernetesResource getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public void setUnsupportedConfigOverrides(KubernetesResource unsupportedConfigOverrides) {
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
