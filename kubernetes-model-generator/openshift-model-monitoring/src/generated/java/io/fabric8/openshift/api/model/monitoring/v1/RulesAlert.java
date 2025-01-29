
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "forGracePeriod",
    "forOutageTolerance",
    "resendDelay"
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
public class RulesAlert implements Editable<RulesAlertBuilder>, KubernetesResource
{

    @JsonProperty("forGracePeriod")
    private String forGracePeriod;
    @JsonProperty("forOutageTolerance")
    private String forOutageTolerance;
    @JsonProperty("resendDelay")
    private String resendDelay;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RulesAlert() {
    }

    public RulesAlert(String forGracePeriod, String forOutageTolerance, String resendDelay) {
        super();
        this.forGracePeriod = forGracePeriod;
        this.forOutageTolerance = forOutageTolerance;
        this.resendDelay = resendDelay;
    }

    /**
     * Minimum duration between alert and restored 'for' state.<br><p> <br><p> This is maintained only for alerts with a configured 'for' time greater than the grace period.
     */
    @JsonProperty("forGracePeriod")
    public String getForGracePeriod() {
        return forGracePeriod;
    }

    /**
     * Minimum duration between alert and restored 'for' state.<br><p> <br><p> This is maintained only for alerts with a configured 'for' time greater than the grace period.
     */
    @JsonProperty("forGracePeriod")
    public void setForGracePeriod(String forGracePeriod) {
        this.forGracePeriod = forGracePeriod;
    }

    /**
     * Max time to tolerate prometheus outage for restoring 'for' state of alert.
     */
    @JsonProperty("forOutageTolerance")
    public String getForOutageTolerance() {
        return forOutageTolerance;
    }

    /**
     * Max time to tolerate prometheus outage for restoring 'for' state of alert.
     */
    @JsonProperty("forOutageTolerance")
    public void setForOutageTolerance(String forOutageTolerance) {
        this.forOutageTolerance = forOutageTolerance;
    }

    /**
     * Minimum amount of time to wait before resending an alert to Alertmanager.
     */
    @JsonProperty("resendDelay")
    public String getResendDelay() {
        return resendDelay;
    }

    /**
     * Minimum amount of time to wait before resending an alert to Alertmanager.
     */
    @JsonProperty("resendDelay")
    public void setResendDelay(String resendDelay) {
        this.resendDelay = resendDelay;
    }

    @JsonIgnore
    public RulesAlertBuilder edit() {
        return new RulesAlertBuilder(this);
    }

    @JsonIgnore
    public RulesAlertBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
