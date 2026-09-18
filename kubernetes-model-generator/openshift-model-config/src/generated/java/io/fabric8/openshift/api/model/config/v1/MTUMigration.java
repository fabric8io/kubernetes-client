
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MTUMigration contains infomation about MTU migration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "machine",
    "network"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MTUMigration implements Editable<MTUMigrationBuilder>, KubernetesResource
{

    @JsonProperty("machine")
    private MTUMigrationValues machine;
    @JsonProperty("network")
    private MTUMigrationValues network;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MTUMigration() {
    }

    public MTUMigration(MTUMigrationValues machine, MTUMigrationValues network) {
        super();
        this.machine = machine;
        this.network = network;
    }

    /**
     * MTUMigration contains infomation about MTU migration.
     */
    @JsonProperty("machine")
    public MTUMigrationValues getMachine() {
        return machine;
    }

    /**
     * MTUMigration contains infomation about MTU migration.
     */
    @JsonProperty("machine")
    public void setMachine(MTUMigrationValues machine) {
        this.machine = machine;
    }

    /**
     * MTUMigration contains infomation about MTU migration.
     */
    @JsonProperty("network")
    public MTUMigrationValues getNetwork() {
        return network;
    }

    /**
     * MTUMigration contains infomation about MTU migration.
     */
    @JsonProperty("network")
    public void setNetwork(MTUMigrationValues network) {
        this.network = network;
    }

    @JsonIgnore
    public MTUMigrationBuilder edit() {
        return new MTUMigrationBuilder(this);
    }

    @JsonIgnore
    public MTUMigrationBuilder toBuilder() {
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
        if (!(o instanceof MTUMigration)) {
            return false;
        }
        MTUMigration other = (MTUMigration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$machine = this.getMachine();
        Object other$machine = other.getMachine();
        if (this$machine == null ? other$machine != null : !this$machine.equals(other$machine)) {
            return false;
        }
        Object this$network = this.getNetwork();
        Object other$network = other.getNetwork();
        if (this$network == null ? other$network != null : !this$network.equals(other$network)) {
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
        return other instanceof MTUMigration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $machine = this.getMachine();
        result = result * prime + ($machine == null ? 43 : $machine.hashCode());
        Object $network = this.getNetwork();
        result = result * prime + ($network == null ? 43 : $network.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MTUMigration(" + "machine=" + this.getMachine() + ", network=" + this.getNetwork() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
