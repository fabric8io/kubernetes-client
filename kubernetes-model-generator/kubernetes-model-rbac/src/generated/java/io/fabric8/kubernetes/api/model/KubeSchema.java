
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.rbac.AggregationRule;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleList;
import io.fabric8.kubernetes.api.model.rbac.Role;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.RoleList;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private AggregationRule aggregationRule;
    private ClusterRole clusterRole;
    private ClusterRoleBinding clusterRoleBinding;
    private ClusterRoleBindingList clusterRoleBindingList;
    private ClusterRoleList clusterRoleList;
    private Role role;
    private RoleBinding roleBinding;
    private RoleBindingList roleBindingList;
    private RoleList roleList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(AggregationRule aggregationRule, ClusterRole clusterRole, ClusterRoleBinding clusterRoleBinding, ClusterRoleBindingList clusterRoleBindingList, ClusterRoleList clusterRoleList, Role role, RoleBinding roleBinding, RoleBindingList roleBindingList, RoleList roleList) {
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
