
package io.fabric8.knative.sources.v1alpha1;

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
import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.Destination;
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
 * IntegrationSourceSpec defines the desired state of IntegrationSource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "ceOverrides",
    "sink",
    "template",
    "timer"
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
public class IntegrationSourceSpec implements Editable<IntegrationSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private Aws aws;
    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("sink")
    private Destination sink;
    @JsonProperty("template")
    private PodTemplateSpec template;
    @JsonProperty("timer")
    private Timer timer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IntegrationSourceSpec() {
    }

    public IntegrationSourceSpec(Aws aws, CloudEventOverrides ceOverrides, Destination sink, PodTemplateSpec template, Timer timer) {
        super();
        this.aws = aws;
        this.ceOverrides = ceOverrides;
        this.sink = sink;
        this.template = template;
        this.timer = timer;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("aws")
    public Aws getAws() {
        return aws;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("aws")
    public void setAws(Aws aws) {
        this.aws = aws;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("template")
    public PodTemplateSpec getTemplate() {
        return template;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("template")
    public void setTemplate(PodTemplateSpec template) {
        this.template = template;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("timer")
    public Timer getTimer() {
        return timer;
    }

    /**
     * IntegrationSourceSpec defines the desired state of IntegrationSource
     */
    @JsonProperty("timer")
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @JsonIgnore
    public IntegrationSourceSpecBuilder edit() {
        return new IntegrationSourceSpecBuilder(this);
    }

    @JsonIgnore
    public IntegrationSourceSpecBuilder toBuilder() {
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
        if (!(o instanceof IntegrationSourceSpec)) {
            return false;
        }
        IntegrationSourceSpec other = (IntegrationSourceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$aws = this.getAws();
        Object other$aws = other.getAws();
        if (this$aws == null ? other$aws != null : !this$aws.equals(other$aws)) {
            return false;
        }
        Object this$ceOverrides = this.getCeOverrides();
        Object other$ceOverrides = other.getCeOverrides();
        if (this$ceOverrides == null ? other$ceOverrides != null : !this$ceOverrides.equals(other$ceOverrides)) {
            return false;
        }
        Object this$sink = this.getSink();
        Object other$sink = other.getSink();
        if (this$sink == null ? other$sink != null : !this$sink.equals(other$sink)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
            return false;
        }
        Object this$timer = this.getTimer();
        Object other$timer = other.getTimer();
        if (this$timer == null ? other$timer != null : !this$timer.equals(other$timer)) {
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
        return other instanceof IntegrationSourceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $ceOverrides = this.getCeOverrides();
        result = result * prime + ($ceOverrides == null ? 43 : $ceOverrides.hashCode());
        Object $sink = this.getSink();
        result = result * prime + ($sink == null ? 43 : $sink.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $timer = this.getTimer();
        result = result * prime + ($timer == null ? 43 : $timer.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IntegrationSourceSpec(" + "aws=" + this.getAws() + ", ceOverrides=" + this.getCeOverrides() + ", sink=" + this.getSink() + ", template=" + this.getTemplate() + ", timer=" + this.getTimer() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
