
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.rbac.AggregationRule;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleList;
import io.fabric8.kubernetes.api.model.rbac.Role;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.RoleList;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "AggregationRule",
    "ClusterRole",
    "ClusterRoleBinding",
    "ClusterRoleBindingList",
    "ClusterRoleList",
    "Role",
    "RoleBinding",
    "RoleBindingList",
    "RoleList"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ValidationSchema {

    @JsonProperty("AggregationRule")
    private AggregationRule aggregationRule;
    @JsonProperty("ClusterRole")
    private ClusterRole clusterRole;
    @JsonProperty("ClusterRoleBinding")
    private ClusterRoleBinding clusterRoleBinding;
    @JsonProperty("ClusterRoleBindingList")
    private ClusterRoleBindingList clusterRoleBindingList;
    @JsonProperty("ClusterRoleList")
    private ClusterRoleList clusterRoleList;
    @JsonProperty("Role")
    private Role role;
    @JsonProperty("RoleBinding")
    private RoleBinding roleBinding;
    @JsonProperty("RoleBindingList")
    private RoleBindingList roleBindingList;
    @JsonProperty("RoleList")
    private RoleList roleList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    /**
     * 
     * @param aggregationRule
     * @param role
     * @param clusterRole
     * @param roleBinding
     * @param clusterRoleBinding
     * @param clusterRoleBindingList
     * @param roleList
     * @param clusterRoleList
     * @param roleBindingList
     */
    public ValidationSchema(AggregationRule aggregationRule, ClusterRole clusterRole, ClusterRoleBinding clusterRoleBinding, ClusterRoleBindingList clusterRoleBindingList, ClusterRoleList clusterRoleList, Role role, RoleBinding roleBinding, RoleBindingList roleBindingList, RoleList roleList) {
        super();
        this.aggregationRule = aggregationRule;
        this.clusterRole = clusterRole;
        this.clusterRoleBinding = clusterRoleBinding;
        this.clusterRoleBindingList = clusterRoleBindingList;
        this.clusterRoleList = clusterRoleList;
        this.role = role;
        this.roleBinding = roleBinding;
        this.roleBindingList = roleBindingList;
        this.roleList = roleList;
    }

    @JsonProperty("AggregationRule")
    public AggregationRule getAggregationRule() {
        return aggregationRule;
    }

    @JsonProperty("AggregationRule")
    public void setAggregationRule(AggregationRule aggregationRule) {
        this.aggregationRule = aggregationRule;
    }

    @JsonProperty("ClusterRole")
    public ClusterRole getClusterRole() {
        return clusterRole;
    }

    @JsonProperty("ClusterRole")
    public void setClusterRole(ClusterRole clusterRole) {
        this.clusterRole = clusterRole;
    }

    @JsonProperty("ClusterRoleBinding")
    public ClusterRoleBinding getClusterRoleBinding() {
        return clusterRoleBinding;
    }

    @JsonProperty("ClusterRoleBinding")
    public void setClusterRoleBinding(ClusterRoleBinding clusterRoleBinding) {
        this.clusterRoleBinding = clusterRoleBinding;
    }

    @JsonProperty("ClusterRoleBindingList")
    public ClusterRoleBindingList getClusterRoleBindingList() {
        return clusterRoleBindingList;
    }

    @JsonProperty("ClusterRoleBindingList")
    public void setClusterRoleBindingList(ClusterRoleBindingList clusterRoleBindingList) {
        this.clusterRoleBindingList = clusterRoleBindingList;
    }

    @JsonProperty("ClusterRoleList")
    public ClusterRoleList getClusterRoleList() {
        return clusterRoleList;
    }

    @JsonProperty("ClusterRoleList")
    public void setClusterRoleList(ClusterRoleList clusterRoleList) {
        this.clusterRoleList = clusterRoleList;
    }

    @JsonProperty("Role")
    public Role getRole() {
        return role;
    }

    @JsonProperty("Role")
    public void setRole(Role role) {
        this.role = role;
    }

    @JsonProperty("RoleBinding")
    public RoleBinding getRoleBinding() {
        return roleBinding;
    }

    @JsonProperty("RoleBinding")
    public void setRoleBinding(RoleBinding roleBinding) {
        this.roleBinding = roleBinding;
    }

    @JsonProperty("RoleBindingList")
    public RoleBindingList getRoleBindingList() {
        return roleBindingList;
    }

    @JsonProperty("RoleBindingList")
    public void setRoleBindingList(RoleBindingList roleBindingList) {
        this.roleBindingList = roleBindingList;
    }

    @JsonProperty("RoleList")
    public RoleList getRoleList() {
        return roleList;
    }

    @JsonProperty("RoleList")
    public void setRoleList(RoleList roleList) {
        this.roleList = roleList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
