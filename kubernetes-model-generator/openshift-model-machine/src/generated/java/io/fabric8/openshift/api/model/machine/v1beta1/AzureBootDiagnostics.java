
package io.fabric8.openshift.api.model.machine.v1beta1;

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
 * AzureBootDiagnostics configures the boot diagnostics settings for the virtual machine. This allows you to configure capturing serial output from the virtual machine on boot. This is useful for debugging software based launch issues.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customerManaged",
    "storageAccountType"
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
public class AzureBootDiagnostics implements Editable<AzureBootDiagnosticsBuilder>, KubernetesResource
{

    @JsonProperty("customerManaged")
    private AzureCustomerManagedBootDiagnostics customerManaged;
    @JsonProperty("storageAccountType")
    private String storageAccountType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureBootDiagnostics() {
    }

    public AzureBootDiagnostics(AzureCustomerManagedBootDiagnostics customerManaged, String storageAccountType) {
        super();
        this.customerManaged = customerManaged;
        this.storageAccountType = storageAccountType;
    }

    /**
     * AzureBootDiagnostics configures the boot diagnostics settings for the virtual machine. This allows you to configure capturing serial output from the virtual machine on boot. This is useful for debugging software based launch issues.
     */
    @JsonProperty("customerManaged")
    public AzureCustomerManagedBootDiagnostics getCustomerManaged() {
        return customerManaged;
    }

    /**
     * AzureBootDiagnostics configures the boot diagnostics settings for the virtual machine. This allows you to configure capturing serial output from the virtual machine on boot. This is useful for debugging software based launch issues.
     */
    @JsonProperty("customerManaged")
    public void setCustomerManaged(AzureCustomerManagedBootDiagnostics customerManaged) {
        this.customerManaged = customerManaged;
    }

    /**
     * StorageAccountType determines if the storage account for storing the diagnostics data should be provisioned by Azure (AzureManaged) or by the customer (CustomerManaged).
     */
    @JsonProperty("storageAccountType")
    public String getStorageAccountType() {
        return storageAccountType;
    }

    /**
     * StorageAccountType determines if the storage account for storing the diagnostics data should be provisioned by Azure (AzureManaged) or by the customer (CustomerManaged).
     */
    @JsonProperty("storageAccountType")
    public void setStorageAccountType(String storageAccountType) {
        this.storageAccountType = storageAccountType;
    }

    @JsonIgnore
    public AzureBootDiagnosticsBuilder edit() {
        return new AzureBootDiagnosticsBuilder(this);
    }

    @JsonIgnore
    public AzureBootDiagnosticsBuilder toBuilder() {
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
