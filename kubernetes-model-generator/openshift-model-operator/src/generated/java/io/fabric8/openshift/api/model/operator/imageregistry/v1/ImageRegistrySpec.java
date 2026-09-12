
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
import io.fabric8.kubernetes.api.model.Affinity;
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
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ImageRegistrySpec defines the specs for the running registry.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinity",
    "defaultRoute",
    "disableRedirect",
    "httpSecret",
    "logLevel",
    "logging",
    "managementState",
    "nodeSelector",
    "observedConfig",
    "operatorLogLevel",
    "proxy",
    "readOnly",
    "replicas",
    "requests",
    "resources",
    "rolloutStrategy",
    "routes",
    "storage",
    "tolerations",
    "topologySpreadConstraints",
    "unsupportedConfigOverrides"
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
public class ImageRegistrySpec implements Editable<ImageRegistrySpecBuilder>, KubernetesResource
{

    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("defaultRoute")
    private Boolean defaultRoute;
    @JsonProperty("disableRedirect")
    private Boolean disableRedirect;
    @JsonProperty("httpSecret")
    private String httpSecret;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("logging")
    private Long logging;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("proxy")
    private ImageRegistryConfigProxy proxy;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("requests")
    private ImageRegistryConfigRequests requests;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonProperty("rolloutStrategy")
    private String rolloutStrategy;
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageRegistryConfigRoute> routes = new ArrayList<>();
    @JsonProperty("storage")
    private ImageRegistryConfigStorage storage;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<>();
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistrySpec() {
    }

    public ImageRegistrySpec(Affinity affinity, Boolean defaultRoute, Boolean disableRedirect, String httpSecret, String logLevel, Long logging, String managementState, Map<String, String> nodeSelector, Object observedConfig, String operatorLogLevel, ImageRegistryConfigProxy proxy, Boolean readOnly, Integer replicas, ImageRegistryConfigRequests requests, ResourceRequirements resources, String rolloutStrategy, List<ImageRegistryConfigRoute> routes, ImageRegistryConfigStorage storage, List<Toleration> tolerations, List<TopologySpreadConstraint> topologySpreadConstraints, Object unsupportedConfigOverrides) {
        super();
        this.affinity = affinity;
        this.defaultRoute = defaultRoute;
        this.disableRedirect = disableRedirect;
        this.httpSecret = httpSecret;
        this.logLevel = logLevel;
        this.logging = logging;
        this.managementState = managementState;
        this.nodeSelector = nodeSelector;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.proxy = proxy;
        this.readOnly = readOnly;
        this.replicas = replicas;
        this.requests = requests;
        this.resources = resources;
        this.rolloutStrategy = rolloutStrategy;
        this.routes = routes;
        this.storage = storage;
        this.tolerations = tolerations;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * defaultRoute indicates whether an external facing route for the registry should be created using the default generated hostname.
     */
    @JsonProperty("defaultRoute")
    public Boolean getDefaultRoute() {
        return defaultRoute;
    }

    /**
     * defaultRoute indicates whether an external facing route for the registry should be created using the default generated hostname.
     */
    @JsonProperty("defaultRoute")
    public void setDefaultRoute(Boolean defaultRoute) {
        this.defaultRoute = defaultRoute;
    }

    /**
     * disableRedirect controls whether to route all data through the Registry, rather than redirecting to the backend.
     */
    @JsonProperty("disableRedirect")
    public Boolean getDisableRedirect() {
        return disableRedirect;
    }

    /**
     * disableRedirect controls whether to route all data through the Registry, rather than redirecting to the backend.
     */
    @JsonProperty("disableRedirect")
    public void setDisableRedirect(Boolean disableRedirect) {
        this.disableRedirect = disableRedirect;
    }

    /**
     * httpSecret is the value needed by the registry to secure uploads, generated by default.
     */
    @JsonProperty("httpSecret")
    public String getHttpSecret() {
        return httpSecret;
    }

    /**
     * httpSecret is the value needed by the registry to secure uploads, generated by default.
     */
    @JsonProperty("httpSecret")
    public void setHttpSecret(String httpSecret) {
        this.httpSecret = httpSecret;
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
     * logging is deprecated, use logLevel instead.
     */
    @JsonProperty("logging")
    public Long getLogging() {
        return logging;
    }

    /**
     * logging is deprecated, use logLevel instead.
     */
    @JsonProperty("logging")
    public void setLogging(Long logging) {
        this.logging = logging;
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
     * nodeSelector defines the node selection constraints for the registry pod.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * nodeSelector defines the node selection constraints for the registry pod.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("observedConfig")
    public Object getObservedConfig() {
        return observedConfig;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
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
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("proxy")
    public ImageRegistryConfigProxy getProxy() {
        return proxy;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("proxy")
    public void setProxy(ImageRegistryConfigProxy proxy) {
        this.proxy = proxy;
    }

    /**
     * readOnly indicates whether the registry instance should reject attempts to push new images or delete existing ones.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly indicates whether the registry instance should reject attempts to push new images or delete existing ones.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * replicas determines the number of registry instances to run.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas determines the number of registry instances to run.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("requests")
    public ImageRegistryConfigRequests getRequests() {
        return requests;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("requests")
    public void setRequests(ImageRegistryConfigRequests requests) {
        this.requests = requests;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    /**
     * rolloutStrategy defines rollout strategy for the image registry deployment.
     */
    @JsonProperty("rolloutStrategy")
    public String getRolloutStrategy() {
        return rolloutStrategy;
    }

    /**
     * rolloutStrategy defines rollout strategy for the image registry deployment.
     */
    @JsonProperty("rolloutStrategy")
    public void setRolloutStrategy(String rolloutStrategy) {
        this.rolloutStrategy = rolloutStrategy;
    }

    /**
     * routes defines additional external facing routes which should be created for the registry.
     */
    @JsonProperty("routes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageRegistryConfigRoute> getRoutes() {
        return routes;
    }

    /**
     * routes defines additional external facing routes which should be created for the registry.
     */
    @JsonProperty("routes")
    public void setRoutes(List<ImageRegistryConfigRoute> routes) {
        this.routes = routes;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("storage")
    public ImageRegistryConfigStorage getStorage() {
        return storage;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("storage")
    public void setStorage(ImageRegistryConfigStorage storage) {
        this.storage = storage;
    }

    /**
     * tolerations defines the tolerations for the registry pod.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * tolerations defines the tolerations for the registry pod.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    /**
     * topologySpreadConstraints specify how to spread matching pods among the given topology.
     */
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    /**
     * topologySpreadConstraints specify how to spread matching pods among the given topology.
     */
    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    /**
     * ImageRegistrySpec defines the specs for the running registry.
     */
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonIgnore
    public ImageRegistrySpecBuilder edit() {
        return new ImageRegistrySpecBuilder(this);
    }

    @JsonIgnore
    public ImageRegistrySpecBuilder toBuilder() {
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
        if (!(o instanceof ImageRegistrySpec)) {
            return false;
        }
        ImageRegistrySpec other = (ImageRegistrySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$affinity = this.getAffinity();
        Object other$affinity = other.getAffinity();
        if (this$affinity == null ? other$affinity != null : !this$affinity.equals(other$affinity)) {
            return false;
        }
        Object this$defaultRoute = this.getDefaultRoute();
        Object other$defaultRoute = other.getDefaultRoute();
        if (this$defaultRoute == null ? other$defaultRoute != null : !this$defaultRoute.equals(other$defaultRoute)) {
            return false;
        }
        Object this$disableRedirect = this.getDisableRedirect();
        Object other$disableRedirect = other.getDisableRedirect();
        if (this$disableRedirect == null ? other$disableRedirect != null : !this$disableRedirect.equals(other$disableRedirect)) {
            return false;
        }
        Object this$httpSecret = this.getHttpSecret();
        Object other$httpSecret = other.getHttpSecret();
        if (this$httpSecret == null ? other$httpSecret != null : !this$httpSecret.equals(other$httpSecret)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$logging = this.getLogging();
        Object other$logging = other.getLogging();
        if (this$logging == null ? other$logging != null : !this$logging.equals(other$logging)) {
            return false;
        }
        Object this$managementState = this.getManagementState();
        Object other$managementState = other.getManagementState();
        if (this$managementState == null ? other$managementState != null : !this$managementState.equals(other$managementState)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$observedConfig = this.getObservedConfig();
        Object other$observedConfig = other.getObservedConfig();
        if (this$observedConfig == null ? other$observedConfig != null : !this$observedConfig.equals(other$observedConfig)) {
            return false;
        }
        Object this$operatorLogLevel = this.getOperatorLogLevel();
        Object other$operatorLogLevel = other.getOperatorLogLevel();
        if (this$operatorLogLevel == null ? other$operatorLogLevel != null : !this$operatorLogLevel.equals(other$operatorLogLevel)) {
            return false;
        }
        Object this$proxy = this.getProxy();
        Object other$proxy = other.getProxy();
        if (this$proxy == null ? other$proxy != null : !this$proxy.equals(other$proxy)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$requests = this.getRequests();
        Object other$requests = other.getRequests();
        if (this$requests == null ? other$requests != null : !this$requests.equals(other$requests)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$rolloutStrategy = this.getRolloutStrategy();
        Object other$rolloutStrategy = other.getRolloutStrategy();
        if (this$rolloutStrategy == null ? other$rolloutStrategy != null : !this$rolloutStrategy.equals(other$rolloutStrategy)) {
            return false;
        }
        Object this$routes = this.getRoutes();
        Object other$routes = other.getRoutes();
        if (this$routes == null ? other$routes != null : !this$routes.equals(other$routes)) {
            return false;
        }
        Object this$storage = this.getStorage();
        Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage)) {
            return false;
        }
        Object this$tolerations = this.getTolerations();
        Object other$tolerations = other.getTolerations();
        if (this$tolerations == null ? other$tolerations != null : !this$tolerations.equals(other$tolerations)) {
            return false;
        }
        Object this$topologySpreadConstraints = this.getTopologySpreadConstraints();
        Object other$topologySpreadConstraints = other.getTopologySpreadConstraints();
        if (this$topologySpreadConstraints == null ? other$topologySpreadConstraints != null : !this$topologySpreadConstraints.equals(other$topologySpreadConstraints)) {
            return false;
        }
        Object this$unsupportedConfigOverrides = this.getUnsupportedConfigOverrides();
        Object other$unsupportedConfigOverrides = other.getUnsupportedConfigOverrides();
        if (this$unsupportedConfigOverrides == null ? other$unsupportedConfigOverrides != null : !this$unsupportedConfigOverrides.equals(other$unsupportedConfigOverrides)) {
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
        return other instanceof ImageRegistrySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $affinity = this.getAffinity();
        result = result * prime + ($affinity == null ? 43 : $affinity.hashCode());
        Object $defaultRoute = this.getDefaultRoute();
        result = result * prime + ($defaultRoute == null ? 43 : $defaultRoute.hashCode());
        Object $disableRedirect = this.getDisableRedirect();
        result = result * prime + ($disableRedirect == null ? 43 : $disableRedirect.hashCode());
        Object $httpSecret = this.getHttpSecret();
        result = result * prime + ($httpSecret == null ? 43 : $httpSecret.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $logging = this.getLogging();
        result = result * prime + ($logging == null ? 43 : $logging.hashCode());
        Object $managementState = this.getManagementState();
        result = result * prime + ($managementState == null ? 43 : $managementState.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $observedConfig = this.getObservedConfig();
        result = result * prime + ($observedConfig == null ? 43 : $observedConfig.hashCode());
        Object $operatorLogLevel = this.getOperatorLogLevel();
        result = result * prime + ($operatorLogLevel == null ? 43 : $operatorLogLevel.hashCode());
        Object $proxy = this.getProxy();
        result = result * prime + ($proxy == null ? 43 : $proxy.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $requests = this.getRequests();
        result = result * prime + ($requests == null ? 43 : $requests.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $rolloutStrategy = this.getRolloutStrategy();
        result = result * prime + ($rolloutStrategy == null ? 43 : $rolloutStrategy.hashCode());
        Object $routes = this.getRoutes();
        result = result * prime + ($routes == null ? 43 : $routes.hashCode());
        Object $storage = this.getStorage();
        result = result * prime + ($storage == null ? 43 : $storage.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $topologySpreadConstraints = this.getTopologySpreadConstraints();
        result = result * prime + ($topologySpreadConstraints == null ? 43 : $topologySpreadConstraints.hashCode());
        Object $unsupportedConfigOverrides = this.getUnsupportedConfigOverrides();
        result = result * prime + ($unsupportedConfigOverrides == null ? 43 : $unsupportedConfigOverrides.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageRegistrySpec(" + "affinity=" + this.getAffinity() + ", defaultRoute=" + this.getDefaultRoute() + ", disableRedirect=" + this.getDisableRedirect() + ", httpSecret=" + this.getHttpSecret() + ", logLevel=" + this.getLogLevel() + ", logging=" + this.getLogging() + ", managementState=" + this.getManagementState() + ", nodeSelector=" + this.getNodeSelector() + ", observedConfig=" + this.getObservedConfig() + ", operatorLogLevel=" + this.getOperatorLogLevel() + ", proxy=" + this.getProxy() + ", readOnly=" + this.getReadOnly() + ", replicas=" + this.getReplicas() + ", requests=" + this.getRequests() + ", resources=" + this.getResources() + ", rolloutStrategy=" + this.getRolloutStrategy() + ", routes=" + this.getRoutes() + ", storage=" + this.getStorage() + ", tolerations=" + this.getTolerations() + ", topologySpreadConstraints=" + this.getTopologySpreadConstraints() + ", unsupportedConfigOverrides=" + this.getUnsupportedConfigOverrides() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
