
package io.fabric8.openshift.api.model.hive.v1;

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

/**
 * PlatformStatus contains the observed state for the specific platform upon which to perform the installation
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "gcp"
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
public class PlatformStatus implements Editable<PlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatus aws;
    @JsonProperty("gcp")
    private io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus gcp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlatformStatus() {
    }

    public PlatformStatus(io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatus aws, io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus gcp) {
        super();
        this.aws = aws;
        this.gcp = gcp;
    }

    /**
     * PlatformStatus contains the observed state for the specific platform upon which to perform the installation
     */
    @JsonProperty("aws")
    public io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatus getAws() {
        return aws;
    }

    /**
     * PlatformStatus contains the observed state for the specific platform upon which to perform the installation
     */
    @JsonProperty("aws")
    public void setAws(io.fabric8.openshift.api.model.hive.aws.v1.PlatformStatus aws) {
        this.aws = aws;
    }

    /**
     * PlatformStatus contains the observed state for the specific platform upon which to perform the installation
     */
    @JsonProperty("gcp")
    public io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus getGcp() {
        return gcp;
    }

    /**
     * PlatformStatus contains the observed state for the specific platform upon which to perform the installation
     */
    @JsonProperty("gcp")
    public void setGcp(io.fabric8.openshift.api.model.hive.gcp.v1.PlatformStatus gcp) {
        this.gcp = gcp;
    }

    @JsonIgnore
    public PlatformStatusBuilder edit() {
        return new PlatformStatusBuilder(this);
    }

    @JsonIgnore
    public PlatformStatusBuilder toBuilder() {
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
        if (!(o instanceof PlatformStatus)) {
            return false;
        }
        PlatformStatus other = (PlatformStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$aws = this.getAws();
        Object other$aws = other.getAws();
        if (this$aws == null ? other$aws != null : !this$aws.equals(other$aws)) {
            return false;
        }
        Object this$gcp = this.getGcp();
        Object other$gcp = other.getGcp();
        if (this$gcp == null ? other$gcp != null : !this$gcp.equals(other$gcp)) {
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
        return other instanceof PlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $gcp = this.getGcp();
        result = result * prime + ($gcp == null ? 43 : $gcp.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlatformStatus(" + "aws=" + this.getAws() + ", gcp=" + this.getGcp() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
