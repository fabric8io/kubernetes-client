
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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

@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "HealthCheckMethod",
    "failureThreshold",
    "initialDelaySeconds",
    "periodSeconds",
    "successThreshold",
    "timeoutSeconds"
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
public class ReadinessProbe implements Editable<ReadinessProbeBuilder>, KubernetesResource
{

    @JsonProperty("HealthCheckMethod")
    @JsonUnwrapped
    private IsReadinessProbeHealthCheckMethod healthCheckMethod;
    @JsonProperty("failureThreshold")
    private Integer failureThreshold;
    @JsonProperty("initialDelaySeconds")
    private Integer initialDelaySeconds;
    @JsonProperty("periodSeconds")
    private Integer periodSeconds;
    @JsonProperty("successThreshold")
    private Integer successThreshold;
    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ReadinessProbe() {
    }

    public ReadinessProbe(IsReadinessProbeHealthCheckMethod healthCheckMethod, Integer failureThreshold, Integer initialDelaySeconds, Integer periodSeconds, Integer successThreshold, Integer timeoutSeconds) {
        super();
        this.healthCheckMethod = healthCheckMethod;
        this.failureThreshold = failureThreshold;
        this.initialDelaySeconds = initialDelaySeconds;
        this.periodSeconds = periodSeconds;
        this.successThreshold = successThreshold;
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonProperty("HealthCheckMethod")
    @JsonUnwrapped
    public IsReadinessProbeHealthCheckMethod getHealthCheckMethod() {
        return healthCheckMethod;
    }

    @JsonProperty("HealthCheckMethod")
    public void setHealthCheckMethod(IsReadinessProbeHealthCheckMethod healthCheckMethod) {
        this.healthCheckMethod = healthCheckMethod;
    }

    /**
     * Minimum consecutive failures for the probe to be considered failed after having succeeded. Defaults to 3 seconds.
     */
    @JsonProperty("failureThreshold")
    public Integer getFailureThreshold() {
        return failureThreshold;
    }

    /**
     * Minimum consecutive failures for the probe to be considered failed after having succeeded. Defaults to 3 seconds.
     */
    @JsonProperty("failureThreshold")
    public void setFailureThreshold(Integer failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    /**
     * Number of seconds after the container has started before readiness probes are initiated.
     */
    @JsonProperty("initialDelaySeconds")
    public Integer getInitialDelaySeconds() {
        return initialDelaySeconds;
    }

    /**
     * Number of seconds after the container has started before readiness probes are initiated.
     */
    @JsonProperty("initialDelaySeconds")
    public void setInitialDelaySeconds(Integer initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
    }

    /**
     * How often (in seconds) to perform the probe. Default to 10 seconds. Minimum value is 1 second.
     */
    @JsonProperty("periodSeconds")
    public Integer getPeriodSeconds() {
        return periodSeconds;
    }

    /**
     * How often (in seconds) to perform the probe. Default to 10 seconds. Minimum value is 1 second.
     */
    @JsonProperty("periodSeconds")
    public void setPeriodSeconds(Integer periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    /**
     * Minimum consecutive successes for the probe to be considered successful after having failed. Defaults to 1 second.
     */
    @JsonProperty("successThreshold")
    public Integer getSuccessThreshold() {
        return successThreshold;
    }

    /**
     * Minimum consecutive successes for the probe to be considered successful after having failed. Defaults to 1 second.
     */
    @JsonProperty("successThreshold")
    public void setSuccessThreshold(Integer successThreshold) {
        this.successThreshold = successThreshold;
    }

    /**
     * Number of seconds after which the probe times out. Defaults to 1 second. Minimum value is 1 second.
     */
    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * Number of seconds after which the probe times out. Defaults to 1 second. Minimum value is 1 second.
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonIgnore
    public ReadinessProbeBuilder edit() {
        return new ReadinessProbeBuilder(this);
    }

    @JsonIgnore
    public ReadinessProbeBuilder toBuilder() {
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
        if (!(o instanceof ReadinessProbe)) {
            return false;
        }
        ReadinessProbe other = (ReadinessProbe) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$healthCheckMethod = this.getHealthCheckMethod();
        Object other$healthCheckMethod = other.getHealthCheckMethod();
        if (this$healthCheckMethod == null ? other$healthCheckMethod != null : !this$healthCheckMethod.equals(other$healthCheckMethod)) {
            return false;
        }
        Object this$failureThreshold = this.getFailureThreshold();
        Object other$failureThreshold = other.getFailureThreshold();
        if (this$failureThreshold == null ? other$failureThreshold != null : !this$failureThreshold.equals(other$failureThreshold)) {
            return false;
        }
        Object this$initialDelaySeconds = this.getInitialDelaySeconds();
        Object other$initialDelaySeconds = other.getInitialDelaySeconds();
        if (this$initialDelaySeconds == null ? other$initialDelaySeconds != null : !this$initialDelaySeconds.equals(other$initialDelaySeconds)) {
            return false;
        }
        Object this$periodSeconds = this.getPeriodSeconds();
        Object other$periodSeconds = other.getPeriodSeconds();
        if (this$periodSeconds == null ? other$periodSeconds != null : !this$periodSeconds.equals(other$periodSeconds)) {
            return false;
        }
        Object this$successThreshold = this.getSuccessThreshold();
        Object other$successThreshold = other.getSuccessThreshold();
        if (this$successThreshold == null ? other$successThreshold != null : !this$successThreshold.equals(other$successThreshold)) {
            return false;
        }
        Object this$timeoutSeconds = this.getTimeoutSeconds();
        Object other$timeoutSeconds = other.getTimeoutSeconds();
        if (this$timeoutSeconds == null ? other$timeoutSeconds != null : !this$timeoutSeconds.equals(other$timeoutSeconds)) {
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
        return other instanceof ReadinessProbe;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $healthCheckMethod = this.getHealthCheckMethod();
        result = result * prime + ($healthCheckMethod == null ? 43 : $healthCheckMethod.hashCode());
        Object $failureThreshold = this.getFailureThreshold();
        result = result * prime + ($failureThreshold == null ? 43 : $failureThreshold.hashCode());
        Object $initialDelaySeconds = this.getInitialDelaySeconds();
        result = result * prime + ($initialDelaySeconds == null ? 43 : $initialDelaySeconds.hashCode());
        Object $periodSeconds = this.getPeriodSeconds();
        result = result * prime + ($periodSeconds == null ? 43 : $periodSeconds.hashCode());
        Object $successThreshold = this.getSuccessThreshold();
        result = result * prime + ($successThreshold == null ? 43 : $successThreshold.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReadinessProbe(" + "healthCheckMethod=" + this.getHealthCheckMethod() + ", failureThreshold=" + this.getFailureThreshold() + ", initialDelaySeconds=" + this.getInitialDelaySeconds() + ", periodSeconds=" + this.getPeriodSeconds() + ", successThreshold=" + this.getSuccessThreshold() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
