
package io.fabric8.kubernetes.api.model.resource.v1alpha3;

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
 * ResourcePoolStatusRequestSpec defines the filters for the pool status request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "defaultPartitionTypeAttribute",
    "driver",
    "limit",
    "poolName"
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
public class ResourcePoolStatusRequestSpec implements Editable<ResourcePoolStatusRequestSpecBuilder>, KubernetesResource
{

    @JsonProperty("defaultPartitionTypeAttribute")
    private String defaultPartitionTypeAttribute;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("poolName")
    private String poolName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourcePoolStatusRequestSpec() {
    }

    public ResourcePoolStatusRequestSpec(String defaultPartitionTypeAttribute, String driver, Integer limit, String poolName) {
        super();
        this.defaultPartitionTypeAttribute = defaultPartitionTypeAttribute;
        this.driver = driver;
        this.limit = limit;
        this.poolName = poolName;
    }

    /**
     * DefaultPartitionTypeAttribute optionally names a device attribute (by its fully qualified name, e.g. "gpu.example.com/profile") to use as the default grouping attribute for partitionable devices whose slice has not declared one themselves.<br><p> <br><p> A slice's own PartitionTypeAttribute always takes precedence. This default applies only to devices whose slice does not declare one, so that a request can still get an accurate partitionSummary from a driver that has not been updated to declare it. When neither the slice nor this default names an attribute, a partitionable pool reports no partitionSummary.<br><p> <br><p> Must include the domain qualifier.
     */
    @JsonProperty("defaultPartitionTypeAttribute")
    public String getDefaultPartitionTypeAttribute() {
        return defaultPartitionTypeAttribute;
    }

    /**
     * DefaultPartitionTypeAttribute optionally names a device attribute (by its fully qualified name, e.g. "gpu.example.com/profile") to use as the default grouping attribute for partitionable devices whose slice has not declared one themselves.<br><p> <br><p> A slice's own PartitionTypeAttribute always takes precedence. This default applies only to devices whose slice does not declare one, so that a request can still get an accurate partitionSummary from a driver that has not been updated to declare it. When neither the slice nor this default names an attribute, a partitionable pool reports no partitionSummary.<br><p> <br><p> Must include the domain qualifier.
     */
    @JsonProperty("defaultPartitionTypeAttribute")
    public void setDefaultPartitionTypeAttribute(String defaultPartitionTypeAttribute) {
        this.defaultPartitionTypeAttribute = defaultPartitionTypeAttribute;
    }

    /**
     * Driver specifies the DRA driver name to filter pools. Only pools from ResourceSlices with this driver will be included. Must be a DNS subdomain (e.g., "gpu.example.com").
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * Driver specifies the DRA driver name to filter pools. Only pools from ResourceSlices with this driver will be included. Must be a DNS subdomain (e.g., "gpu.example.com").
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * Limit optionally specifies the maximum number of pools to return in the status. If more pools match the filter criteria, the response will be truncated (i.e., len(status.pools) &lt; status.poolCount).<br><p> <br><p> Default: 100 Minimum: 1 Maximum: 1000
     */
    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Limit optionally specifies the maximum number of pools to return in the status. If more pools match the filter criteria, the response will be truncated (i.e., len(status.pools) &lt; status.poolCount).<br><p> <br><p> Default: 100 Minimum: 1 Maximum: 1000
     */
    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * PoolName optionally filters to a specific pool name. If not specified, all pools from the specified driver are included. When specified, must be a non-empty valid resource pool name (DNS subdomains separated by "/").
     */
    @JsonProperty("poolName")
    public String getPoolName() {
        return poolName;
    }

    /**
     * PoolName optionally filters to a specific pool name. If not specified, all pools from the specified driver are included. When specified, must be a non-empty valid resource pool name (DNS subdomains separated by "/").
     */
    @JsonProperty("poolName")
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    @JsonIgnore
    public ResourcePoolStatusRequestSpecBuilder edit() {
        return new ResourcePoolStatusRequestSpecBuilder(this);
    }

    @JsonIgnore
    public ResourcePoolStatusRequestSpecBuilder toBuilder() {
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
        if (!(o instanceof ResourcePoolStatusRequestSpec)) {
            return false;
        }
        ResourcePoolStatusRequestSpec other = (ResourcePoolStatusRequestSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$defaultPartitionTypeAttribute = this.getDefaultPartitionTypeAttribute();
        Object other$defaultPartitionTypeAttribute = other.getDefaultPartitionTypeAttribute();
        if (this$defaultPartitionTypeAttribute == null ? other$defaultPartitionTypeAttribute != null : !this$defaultPartitionTypeAttribute.equals(other$defaultPartitionTypeAttribute)) {
            return false;
        }
        Object this$driver = this.getDriver();
        Object other$driver = other.getDriver();
        if (this$driver == null ? other$driver != null : !this$driver.equals(other$driver)) {
            return false;
        }
        Object this$limit = this.getLimit();
        Object other$limit = other.getLimit();
        if (this$limit == null ? other$limit != null : !this$limit.equals(other$limit)) {
            return false;
        }
        Object this$poolName = this.getPoolName();
        Object other$poolName = other.getPoolName();
        if (this$poolName == null ? other$poolName != null : !this$poolName.equals(other$poolName)) {
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
        return other instanceof ResourcePoolStatusRequestSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $defaultPartitionTypeAttribute = this.getDefaultPartitionTypeAttribute();
        result = result * prime + ($defaultPartitionTypeAttribute == null ? 43 : $defaultPartitionTypeAttribute.hashCode());
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $limit = this.getLimit();
        result = result * prime + ($limit == null ? 43 : $limit.hashCode());
        Object $poolName = this.getPoolName();
        result = result * prime + ($poolName == null ? 43 : $poolName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourcePoolStatusRequestSpec(" + "defaultPartitionTypeAttribute=" + this.getDefaultPartitionTypeAttribute() + ", driver=" + this.getDriver() + ", limit=" + this.getLimit() + ", poolName=" + this.getPoolName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
