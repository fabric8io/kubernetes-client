
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * PlatformMetricsSpec defines the spec for the addon to collect, forward and store metrics from fleet managed clusters.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alerts",
    "default",
    "ui"
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
public class PlatformMetricsSpec implements Editable<PlatformMetricsSpecBuilder>, KubernetesResource
{

    @JsonProperty("alerts")
    private MetricsAlertsSpec alerts;
    @JsonProperty("default")
    private PlatformMetricsDefaultSpec _default;
    @JsonProperty("ui")
    private UIConfig ui;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlatformMetricsSpec() {
    }

    public PlatformMetricsSpec(MetricsAlertsSpec alerts, PlatformMetricsDefaultSpec _default, UIConfig ui) {
        super();
        this.alerts = alerts;
        this._default = _default;
        this.ui = ui;
    }

    /**
     * PlatformMetricsSpec defines the spec for the addon to collect, forward and store metrics from fleet managed clusters.
     */
    @JsonProperty("alerts")
    public MetricsAlertsSpec getAlerts() {
        return alerts;
    }

    /**
     * PlatformMetricsSpec defines the spec for the addon to collect, forward and store metrics from fleet managed clusters.
     */
    @JsonProperty("alerts")
    public void setAlerts(MetricsAlertsSpec alerts) {
        this.alerts = alerts;
    }

    /**
     * PlatformMetricsSpec defines the spec for the addon to collect, forward and store metrics from fleet managed clusters.
     */
    @JsonProperty("default")
    public PlatformMetricsDefaultSpec getDefault() {
        return _default;
    }

    /**
     * PlatformMetricsSpec defines the spec for the addon to collect, forward and store metrics from fleet managed clusters.
     */
    @JsonProperty("default")
    public void setDefault(PlatformMetricsDefaultSpec _default) {
        this._default = _default;
    }

    /**
     * PlatformMetricsSpec defines the spec for the addon to collect, forward and store metrics from fleet managed clusters.
     */
    @JsonProperty("ui")
    public UIConfig getUi() {
        return ui;
    }

    /**
     * PlatformMetricsSpec defines the spec for the addon to collect, forward and store metrics from fleet managed clusters.
     */
    @JsonProperty("ui")
    public void setUi(UIConfig ui) {
        this.ui = ui;
    }

    @JsonIgnore
    public PlatformMetricsSpecBuilder edit() {
        return new PlatformMetricsSpecBuilder(this);
    }

    @JsonIgnore
    public PlatformMetricsSpecBuilder toBuilder() {
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
        if (!(o instanceof PlatformMetricsSpec)) {
            return false;
        }
        PlatformMetricsSpec other = (PlatformMetricsSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alerts = this.getAlerts();
        Object other$alerts = other.getAlerts();
        if (this$alerts == null ? other$alerts != null : !this$alerts.equals(other$alerts)) {
            return false;
        }
        Object this$_default = this.getDefault();
        Object other$_default = other.getDefault();
        if (this$_default == null ? other$_default != null : !this$_default.equals(other$_default)) {
            return false;
        }
        Object this$ui = this.getUi();
        Object other$ui = other.getUi();
        if (this$ui == null ? other$ui != null : !this$ui.equals(other$ui)) {
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
        return other instanceof PlatformMetricsSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alerts = this.getAlerts();
        result = result * prime + ($alerts == null ? 43 : $alerts.hashCode());
        Object $_default = this.getDefault();
        result = result * prime + ($_default == null ? 43 : $_default.hashCode());
        Object $ui = this.getUi();
        result = result * prime + ($ui == null ? 43 : $ui.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlatformMetricsSpec(" + "alerts=" + this.getAlerts() + ", _default=" + this.getDefault() + ", ui=" + this.getUi() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
