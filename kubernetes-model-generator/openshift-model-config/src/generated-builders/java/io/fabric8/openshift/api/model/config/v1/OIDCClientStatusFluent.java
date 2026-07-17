package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OIDCClientStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.OIDCClientStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String componentName;
  private String componentNamespace;
  private List<Condition> conditions = new ArrayList<Condition>();
  private List<String> consumingUsers = new ArrayList<String>();
  private ArrayList<OIDCClientReferenceBuilder> currentOIDCClients = new ArrayList<OIDCClientReferenceBuilder>();

  public OIDCClientStatusFluent() {
  }
  
  public OIDCClientStatusFluent(OIDCClientStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConsumingUsers(Collection<String> items) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    for (String item : items) {
      this.consumingUsers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToCurrentOIDCClients(Collection<OIDCClientReference> items) {
    if (this.currentOIDCClients == null) {
      this.currentOIDCClients = new ArrayList();
    }
    for (OIDCClientReference item : items) {
        OIDCClientReferenceBuilder builder = new OIDCClientReferenceBuilder(item);
        _visitables.get("currentOIDCClients").add(builder);
        this.currentOIDCClients.add(builder);
    }
    return (A) this;
  }
  
  public CurrentOIDCClientsNested<A> addNewCurrentOIDCClient() {
    return new CurrentOIDCClientsNested(-1, null);
  }
  
  public A addNewCurrentOIDCClient(String clientID,String issuerURL,String oidcProviderName) {
    return (A) this.addToCurrentOIDCClients(new OIDCClientReference(clientID, issuerURL, oidcProviderName));
  }
  
  public CurrentOIDCClientsNested<A> addNewCurrentOIDCClientLike(OIDCClientReference item) {
    return new CurrentOIDCClientsNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToConsumingUsers(String... items) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    for (String item : items) {
      this.consumingUsers.add(item);
    }
    return (A) this;
  }
  
  public A addToConsumingUsers(int index,String item) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    this.consumingUsers.add(index, item);
    return (A) this;
  }
  
  public A addToCurrentOIDCClients(OIDCClientReference... items) {
    if (this.currentOIDCClients == null) {
      this.currentOIDCClients = new ArrayList();
    }
    for (OIDCClientReference item : items) {
        OIDCClientReferenceBuilder builder = new OIDCClientReferenceBuilder(item);
        _visitables.get("currentOIDCClients").add(builder);
        this.currentOIDCClients.add(builder);
    }
    return (A) this;
  }
  
  public A addToCurrentOIDCClients(int index,OIDCClientReference item) {
    if (this.currentOIDCClients == null) {
      this.currentOIDCClients = new ArrayList();
    }
    OIDCClientReferenceBuilder builder = new OIDCClientReferenceBuilder(item);
    if (index < 0 || index >= currentOIDCClients.size()) {
        _visitables.get("currentOIDCClients").add(builder);
        currentOIDCClients.add(builder);
    } else {
        _visitables.get("currentOIDCClients").add(builder);
        currentOIDCClients.add(index, builder);
    }
    return (A) this;
  }
  
  public OIDCClientReference buildCurrentOIDCClient(int index) {
    return this.currentOIDCClients.get(index).build();
  }
  
  public List<OIDCClientReference> buildCurrentOIDCClients() {
    return this.currentOIDCClients != null ? build(currentOIDCClients) : null;
  }
  
  public OIDCClientReference buildFirstCurrentOIDCClient() {
    return this.currentOIDCClients.get(0).build();
  }
  
  public OIDCClientReference buildLastCurrentOIDCClient() {
    return this.currentOIDCClients.get(currentOIDCClients.size() - 1).build();
  }
  
  public OIDCClientReference buildMatchingCurrentOIDCClient(Predicate<OIDCClientReferenceBuilder> predicate) {
      for (OIDCClientReferenceBuilder item : currentOIDCClients) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(OIDCClientStatus instance) {
    instance = instance != null ? instance : new OIDCClientStatus();
    if (instance != null) {
        this.withComponentName(instance.getComponentName());
        this.withComponentNamespace(instance.getComponentNamespace());
        this.withConditions(instance.getConditions());
        this.withConsumingUsers(instance.getConsumingUsers());
        this.withCurrentOIDCClients(instance.getCurrentOIDCClients());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CurrentOIDCClientsNested<A> editCurrentOIDCClient(int index) {
    if (currentOIDCClients.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "currentOIDCClients"));
    }
    return this.setNewCurrentOIDCClientLike(index, this.buildCurrentOIDCClient(index));
  }
  
  public CurrentOIDCClientsNested<A> editFirstCurrentOIDCClient() {
    if (currentOIDCClients.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "currentOIDCClients"));
    }
    return this.setNewCurrentOIDCClientLike(0, this.buildCurrentOIDCClient(0));
  }
  
  public CurrentOIDCClientsNested<A> editLastCurrentOIDCClient() {
    int index = currentOIDCClients.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "currentOIDCClients"));
    }
    return this.setNewCurrentOIDCClientLike(index, this.buildCurrentOIDCClient(index));
  }
  
  public CurrentOIDCClientsNested<A> editMatchingCurrentOIDCClient(Predicate<OIDCClientReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < currentOIDCClients.size();i++) {
      if (predicate.test(currentOIDCClients.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "currentOIDCClients"));
    }
    return this.setNewCurrentOIDCClientLike(index, this.buildCurrentOIDCClient(index));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    OIDCClientStatusFluent that = (OIDCClientStatusFluent) o;
    if (!(Objects.equals(componentName, that.componentName))) {
      return false;
    }
    if (!(Objects.equals(componentNamespace, that.componentNamespace))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(consumingUsers, that.consumingUsers))) {
      return false;
    }
    if (!(Objects.equals(currentOIDCClients, that.currentOIDCClients))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getComponentName() {
    return this.componentName;
  }
  
  public String getComponentNamespace() {
    return this.componentNamespace;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getConsumingUser(int index) {
    return this.consumingUsers.get(index);
  }
  
  public List<String> getConsumingUsers() {
    return this.consumingUsers;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public String getFirstConsumingUser() {
    return this.consumingUsers.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastConsumingUser() {
    return this.consumingUsers.get(consumingUsers.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingConsumingUser(Predicate<String> predicate) {
      for (String item : consumingUsers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComponentName() {
    return this.componentName != null;
  }
  
  public boolean hasComponentNamespace() {
    return this.componentNamespace != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasConsumingUsers() {
    return this.consumingUsers != null && !(this.consumingUsers.isEmpty());
  }
  
  public boolean hasCurrentOIDCClients() {
    return this.currentOIDCClients != null && !(this.currentOIDCClients.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConsumingUser(Predicate<String> predicate) {
      for (String item : consumingUsers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCurrentOIDCClient(Predicate<OIDCClientReferenceBuilder> predicate) {
      for (OIDCClientReferenceBuilder item : currentOIDCClients) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(componentName, componentNamespace, conditions, consumingUsers, currentOIDCClients, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConsumingUsers(Collection<String> items) {
    if (this.consumingUsers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.consumingUsers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromCurrentOIDCClients(Collection<OIDCClientReference> items) {
    if (this.currentOIDCClients == null) {
      return (A) this;
    }
    for (OIDCClientReference item : items) {
        OIDCClientReferenceBuilder builder = new OIDCClientReferenceBuilder(item);
        _visitables.get("currentOIDCClients").remove(builder);
        this.currentOIDCClients.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConsumingUsers(String... items) {
    if (this.consumingUsers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.consumingUsers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCurrentOIDCClients(OIDCClientReference... items) {
    if (this.currentOIDCClients == null) {
      return (A) this;
    }
    for (OIDCClientReference item : items) {
        OIDCClientReferenceBuilder builder = new OIDCClientReferenceBuilder(item);
        _visitables.get("currentOIDCClients").remove(builder);
        this.currentOIDCClients.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCurrentOIDCClients(Predicate<OIDCClientReferenceBuilder> predicate) {
    if (currentOIDCClients == null) {
      return (A) this;
    }
    Iterator<OIDCClientReferenceBuilder> each = currentOIDCClients.iterator();
    List visitables = _visitables.get("currentOIDCClients");
    while (each.hasNext()) {
        OIDCClientReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CurrentOIDCClientsNested<A> setNewCurrentOIDCClientLike(int index,OIDCClientReference item) {
    return new CurrentOIDCClientsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToConsumingUsers(int index,String item) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    this.consumingUsers.set(index, item);
    return (A) this;
  }
  
  public A setToCurrentOIDCClients(int index,OIDCClientReference item) {
    if (this.currentOIDCClients == null) {
      this.currentOIDCClients = new ArrayList();
    }
    OIDCClientReferenceBuilder builder = new OIDCClientReferenceBuilder(item);
    if (index < 0 || index >= currentOIDCClients.size()) {
        _visitables.get("currentOIDCClients").add(builder);
        currentOIDCClients.add(builder);
    } else {
        _visitables.get("currentOIDCClients").add(builder);
        currentOIDCClients.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(componentName == null)) {
        sb.append("componentName:");
        sb.append(componentName);
        sb.append(",");
    }
    if (!(componentNamespace == null)) {
        sb.append("componentNamespace:");
        sb.append(componentNamespace);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(consumingUsers == null) && !(consumingUsers.isEmpty())) {
        sb.append("consumingUsers:");
        sb.append(consumingUsers);
        sb.append(",");
    }
    if (!(currentOIDCClients == null) && !(currentOIDCClients.isEmpty())) {
        sb.append("currentOIDCClients:");
        sb.append(currentOIDCClients);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withComponentName(String componentName) {
    this.componentName = componentName;
    return (A) this;
  }
  
  public A withComponentNamespace(String componentNamespace) {
    this.componentNamespace = componentNamespace;
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withConsumingUsers(List<String> consumingUsers) {
    if (consumingUsers != null) {
        this.consumingUsers = new ArrayList();
        for (String item : consumingUsers) {
          this.addToConsumingUsers(item);
        }
    } else {
      this.consumingUsers = null;
    }
    return (A) this;
  }
  
  public A withConsumingUsers(String... consumingUsers) {
    if (this.consumingUsers != null) {
        this.consumingUsers.clear();
        _visitables.remove("consumingUsers");
    }
    if (consumingUsers != null) {
      for (String item : consumingUsers) {
        this.addToConsumingUsers(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentOIDCClients(List<OIDCClientReference> currentOIDCClients) {
    if (this.currentOIDCClients != null) {
      this._visitables.get("currentOIDCClients").clear();
    }
    if (currentOIDCClients != null) {
        this.currentOIDCClients = new ArrayList();
        for (OIDCClientReference item : currentOIDCClients) {
          this.addToCurrentOIDCClients(item);
        }
    } else {
      this.currentOIDCClients = null;
    }
    return (A) this;
  }
  
  public A withCurrentOIDCClients(OIDCClientReference... currentOIDCClients) {
    if (this.currentOIDCClients != null) {
        this.currentOIDCClients.clear();
        _visitables.remove("currentOIDCClients");
    }
    if (currentOIDCClients != null) {
      for (OIDCClientReference item : currentOIDCClients) {
        this.addToCurrentOIDCClients(item);
      }
    }
    return (A) this;
  }
  public class CurrentOIDCClientsNested<N> extends OIDCClientReferenceFluent<CurrentOIDCClientsNested<N>> implements Nested<N>{
  
    OIDCClientReferenceBuilder builder;
    int index;
  
    CurrentOIDCClientsNested(int index,OIDCClientReference item) {
      this.index = index;
      this.builder = new OIDCClientReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) OIDCClientStatusFluent.this.setToCurrentOIDCClients(index, builder.build());
    }
    
    public N endCurrentOIDCClient() {
      return and();
    }
    
  }
}