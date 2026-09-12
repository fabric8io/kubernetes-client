
package io.fabric8.openshift.api.model.operatorhub.v1;

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
 * Features contains the list of configurable OLM features.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disableCopiedCSVs",
    "packageServerSyncInterval"
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
public class Features implements Editable<FeaturesBuilder>, KubernetesResource
{

    @JsonProperty("disableCopiedCSVs")
    private Boolean disableCopiedCSVs;
    @JsonProperty("packageServerSyncInterval")
    private String packageServerSyncInterval;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Features() {
    }

    public Features(Boolean disableCopiedCSVs, String packageServerSyncInterval) {
        super();
        this.disableCopiedCSVs = disableCopiedCSVs;
        this.packageServerSyncInterval = packageServerSyncInterval;
    }

    /**
     * DisableCopiedCSVs is used to disable OLM's "Copied CSV" feature for operators installed at the cluster scope, where a cluster scoped operator is one that has been installed in an OperatorGroup that targets all namespaces. When reenabled, OLM will recreate the "Copied CSVs" for each cluster scoped operator.
     */
    @JsonProperty("disableCopiedCSVs")
    public Boolean getDisableCopiedCSVs() {
        return disableCopiedCSVs;
    }

    /**
     * DisableCopiedCSVs is used to disable OLM's "Copied CSV" feature for operators installed at the cluster scope, where a cluster scoped operator is one that has been installed in an OperatorGroup that targets all namespaces. When reenabled, OLM will recreate the "Copied CSVs" for each cluster scoped operator.
     */
    @JsonProperty("disableCopiedCSVs")
    public void setDisableCopiedCSVs(Boolean disableCopiedCSVs) {
        this.disableCopiedCSVs = disableCopiedCSVs;
    }

    /**
     * Features contains the list of configurable OLM features.
     */
    @JsonProperty("packageServerSyncInterval")
    public String getPackageServerSyncInterval() {
        return packageServerSyncInterval;
    }

    /**
     * Features contains the list of configurable OLM features.
     */
    @JsonProperty("packageServerSyncInterval")
    public void setPackageServerSyncInterval(String packageServerSyncInterval) {
        this.packageServerSyncInterval = packageServerSyncInterval;
    }

    @JsonIgnore
    public FeaturesBuilder edit() {
        return new FeaturesBuilder(this);
    }

    @JsonIgnore
    public FeaturesBuilder toBuilder() {
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
        if (!(o instanceof Features)) {
            return false;
        }
        Features other = (Features) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$disableCopiedCSVs = this.getDisableCopiedCSVs();
        Object other$disableCopiedCSVs = other.getDisableCopiedCSVs();
        if (this$disableCopiedCSVs == null ? other$disableCopiedCSVs != null : !this$disableCopiedCSVs.equals(other$disableCopiedCSVs)) {
            return false;
        }
        Object this$packageServerSyncInterval = this.getPackageServerSyncInterval();
        Object other$packageServerSyncInterval = other.getPackageServerSyncInterval();
        if (this$packageServerSyncInterval == null ? other$packageServerSyncInterval != null : !this$packageServerSyncInterval.equals(other$packageServerSyncInterval)) {
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
        return other instanceof Features;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $disableCopiedCSVs = this.getDisableCopiedCSVs();
        result = result * prime + ($disableCopiedCSVs == null ? 43 : $disableCopiedCSVs.hashCode());
        Object $packageServerSyncInterval = this.getPackageServerSyncInterval();
        result = result * prime + ($packageServerSyncInterval == null ? 43 : $packageServerSyncInterval.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Features(" + "disableCopiedCSVs=" + this.getDisableCopiedCSVs() + ", packageServerSyncInterval=" + this.getPackageServerSyncInterval() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
