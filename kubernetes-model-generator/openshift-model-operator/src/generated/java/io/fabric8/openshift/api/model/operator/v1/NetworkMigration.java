
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NetworkMigration represents the cluster network migration configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "features",
    "mode",
    "mtu",
    "networkType"
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
public class NetworkMigration implements Editable<NetworkMigrationBuilder>, KubernetesResource
{

    @JsonProperty("features")
    private FeaturesMigration features;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("mtu")
    private MTUMigration mtu;
    @JsonProperty("networkType")
    private String networkType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkMigration() {
    }

    public NetworkMigration(FeaturesMigration features, String mode, MTUMigration mtu, String networkType) {
        super();
        this.features = features;
        this.mode = mode;
        this.mtu = mtu;
        this.networkType = networkType;
    }

    /**
     * NetworkMigration represents the cluster network migration configuration.
     */
    @JsonProperty("features")
    public FeaturesMigration getFeatures() {
        return features;
    }

    /**
     * NetworkMigration represents the cluster network migration configuration.
     */
    @JsonProperty("features")
    public void setFeatures(FeaturesMigration features) {
        this.features = features;
    }

    /**
     * mode indicates the mode of network type migration. DEPRECATED: network type migration is no longer supported, and setting this to a non-empty value will result in the network operator rejecting the configuration.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode indicates the mode of network type migration. DEPRECATED: network type migration is no longer supported, and setting this to a non-empty value will result in the network operator rejecting the configuration.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * NetworkMigration represents the cluster network migration configuration.
     */
    @JsonProperty("mtu")
    public MTUMigration getMtu() {
        return mtu;
    }

    /**
     * NetworkMigration represents the cluster network migration configuration.
     */
    @JsonProperty("mtu")
    public void setMtu(MTUMigration mtu) {
        this.mtu = mtu;
    }

    /**
     * networkType was previously used when changing the default network type. DEPRECATED: network type migration is no longer supported, and setting this to a non-empty value will result in the network operator rejecting the configuration.
     */
    @JsonProperty("networkType")
    public String getNetworkType() {
        return networkType;
    }

    /**
     * networkType was previously used when changing the default network type. DEPRECATED: network type migration is no longer supported, and setting this to a non-empty value will result in the network operator rejecting the configuration.
     */
    @JsonProperty("networkType")
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    @JsonIgnore
    public NetworkMigrationBuilder edit() {
        return new NetworkMigrationBuilder(this);
    }

    @JsonIgnore
    public NetworkMigrationBuilder toBuilder() {
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

}
