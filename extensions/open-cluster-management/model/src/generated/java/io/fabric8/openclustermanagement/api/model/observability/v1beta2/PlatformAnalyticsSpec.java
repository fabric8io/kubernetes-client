
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "incidentDetection",
    "namespaceRightSizingRecommendation"
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
public class PlatformAnalyticsSpec implements Editable<PlatformAnalyticsSpecBuilder>, KubernetesResource
{

    @JsonProperty("incidentDetection")
    private PlatformIncidentDetectionSpec incidentDetection;
    @JsonProperty("namespaceRightSizingRecommendation")
    private PlatformNamespaceRightSizingRecommendationSpec namespaceRightSizingRecommendation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlatformAnalyticsSpec() {
    }

    public PlatformAnalyticsSpec(PlatformIncidentDetectionSpec incidentDetection, PlatformNamespaceRightSizingRecommendationSpec namespaceRightSizingRecommendation) {
        super();
        this.incidentDetection = incidentDetection;
        this.namespaceRightSizingRecommendation = namespaceRightSizingRecommendation;
    }

    @JsonProperty("incidentDetection")
    public PlatformIncidentDetectionSpec getIncidentDetection() {
        return incidentDetection;
    }

    @JsonProperty("incidentDetection")
    public void setIncidentDetection(PlatformIncidentDetectionSpec incidentDetection) {
        this.incidentDetection = incidentDetection;
    }

    @JsonProperty("namespaceRightSizingRecommendation")
    public PlatformNamespaceRightSizingRecommendationSpec getNamespaceRightSizingRecommendation() {
        return namespaceRightSizingRecommendation;
    }

    @JsonProperty("namespaceRightSizingRecommendation")
    public void setNamespaceRightSizingRecommendation(PlatformNamespaceRightSizingRecommendationSpec namespaceRightSizingRecommendation) {
        this.namespaceRightSizingRecommendation = namespaceRightSizingRecommendation;
    }

    @JsonIgnore
    public PlatformAnalyticsSpecBuilder edit() {
        return new PlatformAnalyticsSpecBuilder(this);
    }

    @JsonIgnore
    public PlatformAnalyticsSpecBuilder toBuilder() {
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
        if (!(o instanceof PlatformAnalyticsSpec)) {
            return false;
        }
        PlatformAnalyticsSpec other = (PlatformAnalyticsSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$incidentDetection = this.getIncidentDetection();
        Object other$incidentDetection = other.getIncidentDetection();
        if (this$incidentDetection == null ? other$incidentDetection != null : !this$incidentDetection.equals(other$incidentDetection)) {
            return false;
        }
        Object this$namespaceRightSizingRecommendation = this.getNamespaceRightSizingRecommendation();
        Object other$namespaceRightSizingRecommendation = other.getNamespaceRightSizingRecommendation();
        if (this$namespaceRightSizingRecommendation == null ? other$namespaceRightSizingRecommendation != null : !this$namespaceRightSizingRecommendation.equals(other$namespaceRightSizingRecommendation)) {
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
        return other instanceof PlatformAnalyticsSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $incidentDetection = this.getIncidentDetection();
        result = result * prime + ($incidentDetection == null ? 43 : $incidentDetection.hashCode());
        Object $namespaceRightSizingRecommendation = this.getNamespaceRightSizingRecommendation();
        result = result * prime + ($namespaceRightSizingRecommendation == null ? 43 : $namespaceRightSizingRecommendation.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlatformAnalyticsSpec(" + "incidentDetection=" + this.getIncidentDetection() + ", namespaceRightSizingRecommendation=" + this.getNamespaceRightSizingRecommendation() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
