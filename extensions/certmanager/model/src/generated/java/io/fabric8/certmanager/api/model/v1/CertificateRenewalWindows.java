
package io.fabric8.certmanager.api.model.v1;

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
import io.fabric8.kubernetes.api.model.Duration;
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
 * CertificateRenewalWindows is the definition for renewal windows
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cron",
    "timezone",
    "windowDuration"
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
public class CertificateRenewalWindows implements Editable<CertificateRenewalWindowsBuilder>, KubernetesResource
{

    @JsonProperty("cron")
    private String cron;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("windowDuration")
    private Duration windowDuration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CertificateRenewalWindows() {
    }

    public CertificateRenewalWindows(String cron, String timezone, Duration windowDuration) {
        super();
        this.cron = cron;
        this.timezone = timezone;
        this.windowDuration = windowDuration;
    }

    /**
     * `cron` is a cron compliant string to allow when the renewal should be allowed. Format is as shown below: &#42; &#42; &#42; &#42; &#42; | | | | | | | | | day of the week (0–6) (Sunday to Saturday; | | | month (1–12)             7 is also Sunday on some systems) | | day of the month (1–31) | hour (0–23) minute (0–59)
     */
    @JsonProperty("cron")
    public String getCron() {
        return cron;
    }

    /**
     * `cron` is a cron compliant string to allow when the renewal should be allowed. Format is as shown below: &#42; &#42; &#42; &#42; &#42; | | | | | | | | | day of the week (0–6) (Sunday to Saturday; | | | month (1–12)             7 is also Sunday on some systems) | | day of the month (1–31) | hour (0–23) minute (0–59)
     */
    @JsonProperty("cron")
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * `timezone` is IANA compliant timezone. For example America/Denver. If this field is not set, timezone is treated as UTC.
     */
    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * `timezone` is IANA compliant timezone. For example America/Denver. If this field is not set, timezone is treated as UTC.
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * CertificateRenewalWindows is the definition for renewal windows
     */
    @JsonProperty("windowDuration")
    public Duration getWindowDuration() {
        return windowDuration;
    }

    /**
     * CertificateRenewalWindows is the definition for renewal windows
     */
    @JsonProperty("windowDuration")
    public void setWindowDuration(Duration windowDuration) {
        this.windowDuration = windowDuration;
    }

    @JsonIgnore
    public CertificateRenewalWindowsBuilder edit() {
        return new CertificateRenewalWindowsBuilder(this);
    }

    @JsonIgnore
    public CertificateRenewalWindowsBuilder toBuilder() {
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
        if (!(o instanceof CertificateRenewalWindows)) {
            return false;
        }
        CertificateRenewalWindows other = (CertificateRenewalWindows) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cron = this.getCron();
        Object other$cron = other.getCron();
        if (this$cron == null ? other$cron != null : !this$cron.equals(other$cron)) {
            return false;
        }
        Object this$timezone = this.getTimezone();
        Object other$timezone = other.getTimezone();
        if (this$timezone == null ? other$timezone != null : !this$timezone.equals(other$timezone)) {
            return false;
        }
        Object this$windowDuration = this.getWindowDuration();
        Object other$windowDuration = other.getWindowDuration();
        if (this$windowDuration == null ? other$windowDuration != null : !this$windowDuration.equals(other$windowDuration)) {
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
        return other instanceof CertificateRenewalWindows;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cron = this.getCron();
        result = result * prime + ($cron == null ? 43 : $cron.hashCode());
        Object $timezone = this.getTimezone();
        result = result * prime + ($timezone == null ? 43 : $timezone.hashCode());
        Object $windowDuration = this.getWindowDuration();
        result = result * prime + ($windowDuration == null ? 43 : $windowDuration.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CertificateRenewalWindows(" + "cron=" + this.getCron() + ", timezone=" + this.getTimezone() + ", windowDuration=" + this.getWindowDuration() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
