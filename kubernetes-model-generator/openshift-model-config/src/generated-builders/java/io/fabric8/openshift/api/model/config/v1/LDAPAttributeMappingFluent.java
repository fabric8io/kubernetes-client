package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class LDAPAttributeMappingFluent<A extends io.fabric8.openshift.api.model.config.v1.LDAPAttributeMappingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> email = new ArrayList<String>();
  private List<String> id = new ArrayList<String>();
  private List<String> name = new ArrayList<String>();
  private List<String> preferredUsername = new ArrayList<String>();

  public LDAPAttributeMappingFluent() {
  }
  
  public LDAPAttributeMappingFluent(LDAPAttributeMapping instance) {
    this.copyInstance(instance);
  }

  public A addAllToEmail(Collection<String> items) {
    if (this.email == null) {
      this.email = new ArrayList();
    }
    for (String item : items) {
      this.email.add(item);
    }
    return (A) this;
  }
  
  public A addAllToId(Collection<String> items) {
    if (this.id == null) {
      this.id = new ArrayList();
    }
    for (String item : items) {
      this.id.add(item);
    }
    return (A) this;
  }
  
  public A addAllToName(Collection<String> items) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    for (String item : items) {
      this.name.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPreferredUsername(Collection<String> items) {
    if (this.preferredUsername == null) {
      this.preferredUsername = new ArrayList();
    }
    for (String item : items) {
      this.preferredUsername.add(item);
    }
    return (A) this;
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
  
  public A addToEmail(String... items) {
    if (this.email == null) {
      this.email = new ArrayList();
    }
    for (String item : items) {
      this.email.add(item);
    }
    return (A) this;
  }
  
  public A addToEmail(int index,String item) {
    if (this.email == null) {
      this.email = new ArrayList();
    }
    this.email.add(index, item);
    return (A) this;
  }
  
  public A addToId(String... items) {
    if (this.id == null) {
      this.id = new ArrayList();
    }
    for (String item : items) {
      this.id.add(item);
    }
    return (A) this;
  }
  
  public A addToId(int index,String item) {
    if (this.id == null) {
      this.id = new ArrayList();
    }
    this.id.add(index, item);
    return (A) this;
  }
  
  public A addToName(String... items) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    for (String item : items) {
      this.name.add(item);
    }
    return (A) this;
  }
  
  public A addToName(int index,String item) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    this.name.add(index, item);
    return (A) this;
  }
  
  public A addToPreferredUsername(String... items) {
    if (this.preferredUsername == null) {
      this.preferredUsername = new ArrayList();
    }
    for (String item : items) {
      this.preferredUsername.add(item);
    }
    return (A) this;
  }
  
  public A addToPreferredUsername(int index,String item) {
    if (this.preferredUsername == null) {
      this.preferredUsername = new ArrayList();
    }
    this.preferredUsername.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(LDAPAttributeMapping instance) {
    instance = instance != null ? instance : new LDAPAttributeMapping();
    if (instance != null) {
        this.withEmail(instance.getEmail());
        this.withId(instance.getId());
        this.withName(instance.getName());
        this.withPreferredUsername(instance.getPreferredUsername());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    LDAPAttributeMappingFluent that = (LDAPAttributeMappingFluent) o;
    if (!(Objects.equals(email, that.email))) {
      return false;
    }
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(preferredUsername, that.preferredUsername))) {
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
  
  public List<String> getEmail() {
    return this.email;
  }
  
  public String getEmail(int index) {
    return this.email.get(index);
  }
  
  public String getFirstEmail() {
    return this.email.get(0);
  }
  
  public String getFirstId() {
    return this.id.get(0);
  }
  
  public String getFirstName() {
    return this.name.get(0);
  }
  
  public String getFirstPreferredUsername() {
    return this.preferredUsername.get(0);
  }
  
  public List<String> getId() {
    return this.id;
  }
  
  public String getId(int index) {
    return this.id.get(index);
  }
  
  public String getLastEmail() {
    return this.email.get(email.size() - 1);
  }
  
  public String getLastId() {
    return this.id.get(id.size() - 1);
  }
  
  public String getLastName() {
    return this.name.get(name.size() - 1);
  }
  
  public String getLastPreferredUsername() {
    return this.preferredUsername.get(preferredUsername.size() - 1);
  }
  
  public String getMatchingEmail(Predicate<String> predicate) {
      for (String item : email) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingId(Predicate<String> predicate) {
      for (String item : id) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingName(Predicate<String> predicate) {
      for (String item : name) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPreferredUsername(Predicate<String> predicate) {
      for (String item : preferredUsername) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getName() {
    return this.name;
  }
  
  public String getName(int index) {
    return this.name.get(index);
  }
  
  public List<String> getPreferredUsername() {
    return this.preferredUsername;
  }
  
  public String getPreferredUsername(int index) {
    return this.preferredUsername.get(index);
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEmail() {
    return this.email != null && !(this.email.isEmpty());
  }
  
  public boolean hasId() {
    return this.id != null && !(this.id.isEmpty());
  }
  
  public boolean hasMatchingEmail(Predicate<String> predicate) {
      for (String item : email) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingId(Predicate<String> predicate) {
      for (String item : id) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingName(Predicate<String> predicate) {
      for (String item : name) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPreferredUsername(Predicate<String> predicate) {
      for (String item : preferredUsername) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null && !(this.name.isEmpty());
  }
  
  public boolean hasPreferredUsername() {
    return this.preferredUsername != null && !(this.preferredUsername.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(email, id, name, preferredUsername, additionalProperties);
  }
  
  public A removeAllFromEmail(Collection<String> items) {
    if (this.email == null) {
      return (A) this;
    }
    for (String item : items) {
      this.email.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromId(Collection<String> items) {
    if (this.id == null) {
      return (A) this;
    }
    for (String item : items) {
      this.id.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromName(Collection<String> items) {
    if (this.name == null) {
      return (A) this;
    }
    for (String item : items) {
      this.name.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPreferredUsername(Collection<String> items) {
    if (this.preferredUsername == null) {
      return (A) this;
    }
    for (String item : items) {
      this.preferredUsername.remove(item);
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
  
  public A removeFromEmail(String... items) {
    if (this.email == null) {
      return (A) this;
    }
    for (String item : items) {
      this.email.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromId(String... items) {
    if (this.id == null) {
      return (A) this;
    }
    for (String item : items) {
      this.id.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromName(String... items) {
    if (this.name == null) {
      return (A) this;
    }
    for (String item : items) {
      this.name.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPreferredUsername(String... items) {
    if (this.preferredUsername == null) {
      return (A) this;
    }
    for (String item : items) {
      this.preferredUsername.remove(item);
    }
    return (A) this;
  }
  
  public A setToEmail(int index,String item) {
    if (this.email == null) {
      this.email = new ArrayList();
    }
    this.email.set(index, item);
    return (A) this;
  }
  
  public A setToId(int index,String item) {
    if (this.id == null) {
      this.id = new ArrayList();
    }
    this.id.set(index, item);
    return (A) this;
  }
  
  public A setToName(int index,String item) {
    if (this.name == null) {
      this.name = new ArrayList();
    }
    this.name.set(index, item);
    return (A) this;
  }
  
  public A setToPreferredUsername(int index,String item) {
    if (this.preferredUsername == null) {
      this.preferredUsername = new ArrayList();
    }
    this.preferredUsername.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(email == null) && !(email.isEmpty())) {
        sb.append("email:");
        sb.append(email);
        sb.append(",");
    }
    if (!(id == null) && !(id.isEmpty())) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(name == null) && !(name.isEmpty())) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(preferredUsername == null) && !(preferredUsername.isEmpty())) {
        sb.append("preferredUsername:");
        sb.append(preferredUsername);
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
  
  public A withEmail(List<String> email) {
    if (email != null) {
        this.email = new ArrayList();
        for (String item : email) {
          this.addToEmail(item);
        }
    } else {
      this.email = null;
    }
    return (A) this;
  }
  
  public A withEmail(String... email) {
    if (this.email != null) {
        this.email.clear();
        _visitables.remove("email");
    }
    if (email != null) {
      for (String item : email) {
        this.addToEmail(item);
      }
    }
    return (A) this;
  }
  
  public A withId(List<String> id) {
    if (id != null) {
        this.id = new ArrayList();
        for (String item : id) {
          this.addToId(item);
        }
    } else {
      this.id = null;
    }
    return (A) this;
  }
  
  public A withId(String... id) {
    if (this.id != null) {
        this.id.clear();
        _visitables.remove("id");
    }
    if (id != null) {
      for (String item : id) {
        this.addToId(item);
      }
    }
    return (A) this;
  }
  
  public A withName(List<String> name) {
    if (name != null) {
        this.name = new ArrayList();
        for (String item : name) {
          this.addToName(item);
        }
    } else {
      this.name = null;
    }
    return (A) this;
  }
  
  public A withName(String... name) {
    if (this.name != null) {
        this.name.clear();
        _visitables.remove("name");
    }
    if (name != null) {
      for (String item : name) {
        this.addToName(item);
      }
    }
    return (A) this;
  }
  
  public A withPreferredUsername(List<String> preferredUsername) {
    if (preferredUsername != null) {
        this.preferredUsername = new ArrayList();
        for (String item : preferredUsername) {
          this.addToPreferredUsername(item);
        }
    } else {
      this.preferredUsername = null;
    }
    return (A) this;
  }
  
  public A withPreferredUsername(String... preferredUsername) {
    if (this.preferredUsername != null) {
        this.preferredUsername.clear();
        _visitables.remove("preferredUsername");
    }
    if (preferredUsername != null) {
      for (String item : preferredUsername) {
        this.addToPreferredUsername(item);
      }
    }
    return (A) this;
  }
  
}