package io.fabric8.certmanager.api.model.v1;

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
public class X509SubjectFluent<A extends io.fabric8.certmanager.api.model.v1.X509SubjectFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> countries = new ArrayList<String>();
  private List<String> localities = new ArrayList<String>();
  private List<String> organizationalUnits = new ArrayList<String>();
  private List<String> organizations = new ArrayList<String>();
  private List<String> postalCodes = new ArrayList<String>();
  private List<String> provinces = new ArrayList<String>();
  private String serialNumber;
  private List<String> streetAddresses = new ArrayList<String>();

  public X509SubjectFluent() {
  }
  
  public X509SubjectFluent(X509Subject instance) {
    this.copyInstance(instance);
  }

  public A addAllToCountries(Collection<String> items) {
    if (this.countries == null) {
      this.countries = new ArrayList();
    }
    for (String item : items) {
      this.countries.add(item);
    }
    return (A) this;
  }
  
  public A addAllToLocalities(Collection<String> items) {
    if (this.localities == null) {
      this.localities = new ArrayList();
    }
    for (String item : items) {
      this.localities.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOrganizationalUnits(Collection<String> items) {
    if (this.organizationalUnits == null) {
      this.organizationalUnits = new ArrayList();
    }
    for (String item : items) {
      this.organizationalUnits.add(item);
    }
    return (A) this;
  }
  
  public A addAllToOrganizations(Collection<String> items) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    for (String item : items) {
      this.organizations.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPostalCodes(Collection<String> items) {
    if (this.postalCodes == null) {
      this.postalCodes = new ArrayList();
    }
    for (String item : items) {
      this.postalCodes.add(item);
    }
    return (A) this;
  }
  
  public A addAllToProvinces(Collection<String> items) {
    if (this.provinces == null) {
      this.provinces = new ArrayList();
    }
    for (String item : items) {
      this.provinces.add(item);
    }
    return (A) this;
  }
  
  public A addAllToStreetAddresses(Collection<String> items) {
    if (this.streetAddresses == null) {
      this.streetAddresses = new ArrayList();
    }
    for (String item : items) {
      this.streetAddresses.add(item);
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
  
  public A addToCountries(String... items) {
    if (this.countries == null) {
      this.countries = new ArrayList();
    }
    for (String item : items) {
      this.countries.add(item);
    }
    return (A) this;
  }
  
  public A addToCountries(int index,String item) {
    if (this.countries == null) {
      this.countries = new ArrayList();
    }
    this.countries.add(index, item);
    return (A) this;
  }
  
  public A addToLocalities(String... items) {
    if (this.localities == null) {
      this.localities = new ArrayList();
    }
    for (String item : items) {
      this.localities.add(item);
    }
    return (A) this;
  }
  
  public A addToLocalities(int index,String item) {
    if (this.localities == null) {
      this.localities = new ArrayList();
    }
    this.localities.add(index, item);
    return (A) this;
  }
  
  public A addToOrganizationalUnits(String... items) {
    if (this.organizationalUnits == null) {
      this.organizationalUnits = new ArrayList();
    }
    for (String item : items) {
      this.organizationalUnits.add(item);
    }
    return (A) this;
  }
  
  public A addToOrganizationalUnits(int index,String item) {
    if (this.organizationalUnits == null) {
      this.organizationalUnits = new ArrayList();
    }
    this.organizationalUnits.add(index, item);
    return (A) this;
  }
  
  public A addToOrganizations(String... items) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    for (String item : items) {
      this.organizations.add(item);
    }
    return (A) this;
  }
  
  public A addToOrganizations(int index,String item) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    this.organizations.add(index, item);
    return (A) this;
  }
  
  public A addToPostalCodes(String... items) {
    if (this.postalCodes == null) {
      this.postalCodes = new ArrayList();
    }
    for (String item : items) {
      this.postalCodes.add(item);
    }
    return (A) this;
  }
  
  public A addToPostalCodes(int index,String item) {
    if (this.postalCodes == null) {
      this.postalCodes = new ArrayList();
    }
    this.postalCodes.add(index, item);
    return (A) this;
  }
  
  public A addToProvinces(String... items) {
    if (this.provinces == null) {
      this.provinces = new ArrayList();
    }
    for (String item : items) {
      this.provinces.add(item);
    }
    return (A) this;
  }
  
  public A addToProvinces(int index,String item) {
    if (this.provinces == null) {
      this.provinces = new ArrayList();
    }
    this.provinces.add(index, item);
    return (A) this;
  }
  
  public A addToStreetAddresses(String... items) {
    if (this.streetAddresses == null) {
      this.streetAddresses = new ArrayList();
    }
    for (String item : items) {
      this.streetAddresses.add(item);
    }
    return (A) this;
  }
  
  public A addToStreetAddresses(int index,String item) {
    if (this.streetAddresses == null) {
      this.streetAddresses = new ArrayList();
    }
    this.streetAddresses.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(X509Subject instance) {
    instance = instance != null ? instance : new X509Subject();
    if (instance != null) {
        this.withCountries(instance.getCountries());
        this.withLocalities(instance.getLocalities());
        this.withOrganizationalUnits(instance.getOrganizationalUnits());
        this.withOrganizations(instance.getOrganizations());
        this.withPostalCodes(instance.getPostalCodes());
        this.withProvinces(instance.getProvinces());
        this.withSerialNumber(instance.getSerialNumber());
        this.withStreetAddresses(instance.getStreetAddresses());
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
    X509SubjectFluent that = (X509SubjectFluent) o;
    if (!(Objects.equals(countries, that.countries))) {
      return false;
    }
    if (!(Objects.equals(localities, that.localities))) {
      return false;
    }
    if (!(Objects.equals(organizationalUnits, that.organizationalUnits))) {
      return false;
    }
    if (!(Objects.equals(organizations, that.organizations))) {
      return false;
    }
    if (!(Objects.equals(postalCodes, that.postalCodes))) {
      return false;
    }
    if (!(Objects.equals(provinces, that.provinces))) {
      return false;
    }
    if (!(Objects.equals(serialNumber, that.serialNumber))) {
      return false;
    }
    if (!(Objects.equals(streetAddresses, that.streetAddresses))) {
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
  
  public List<String> getCountries() {
    return this.countries;
  }
  
  public String getCountry(int index) {
    return this.countries.get(index);
  }
  
  public String getFirstCountry() {
    return this.countries.get(0);
  }
  
  public String getFirstLocality() {
    return this.localities.get(0);
  }
  
  public String getFirstOrganization() {
    return this.organizations.get(0);
  }
  
  public String getFirstOrganizationalUnit() {
    return this.organizationalUnits.get(0);
  }
  
  public String getFirstPostalCode() {
    return this.postalCodes.get(0);
  }
  
  public String getFirstProvince() {
    return this.provinces.get(0);
  }
  
  public String getFirstStreetAddress() {
    return this.streetAddresses.get(0);
  }
  
  public String getLastCountry() {
    return this.countries.get(countries.size() - 1);
  }
  
  public String getLastLocality() {
    return this.localities.get(localities.size() - 1);
  }
  
  public String getLastOrganization() {
    return this.organizations.get(organizations.size() - 1);
  }
  
  public String getLastOrganizationalUnit() {
    return this.organizationalUnits.get(organizationalUnits.size() - 1);
  }
  
  public String getLastPostalCode() {
    return this.postalCodes.get(postalCodes.size() - 1);
  }
  
  public String getLastProvince() {
    return this.provinces.get(provinces.size() - 1);
  }
  
  public String getLastStreetAddress() {
    return this.streetAddresses.get(streetAddresses.size() - 1);
  }
  
  public List<String> getLocalities() {
    return this.localities;
  }
  
  public String getLocality(int index) {
    return this.localities.get(index);
  }
  
  public String getMatchingCountry(Predicate<String> predicate) {
      for (String item : countries) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingLocality(Predicate<String> predicate) {
      for (String item : localities) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingOrganization(Predicate<String> predicate) {
      for (String item : organizations) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingOrganizationalUnit(Predicate<String> predicate) {
      for (String item : organizationalUnits) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPostalCode(Predicate<String> predicate) {
      for (String item : postalCodes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingProvince(Predicate<String> predicate) {
      for (String item : provinces) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingStreetAddress(Predicate<String> predicate) {
      for (String item : streetAddresses) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOrganization(int index) {
    return this.organizations.get(index);
  }
  
  public String getOrganizationalUnit(int index) {
    return this.organizationalUnits.get(index);
  }
  
  public List<String> getOrganizationalUnits() {
    return this.organizationalUnits;
  }
  
  public List<String> getOrganizations() {
    return this.organizations;
  }
  
  public String getPostalCode(int index) {
    return this.postalCodes.get(index);
  }
  
  public List<String> getPostalCodes() {
    return this.postalCodes;
  }
  
  public String getProvince(int index) {
    return this.provinces.get(index);
  }
  
  public List<String> getProvinces() {
    return this.provinces;
  }
  
  public String getSerialNumber() {
    return this.serialNumber;
  }
  
  public String getStreetAddress(int index) {
    return this.streetAddresses.get(index);
  }
  
  public List<String> getStreetAddresses() {
    return this.streetAddresses;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCountries() {
    return this.countries != null && !(this.countries.isEmpty());
  }
  
  public boolean hasLocalities() {
    return this.localities != null && !(this.localities.isEmpty());
  }
  
  public boolean hasMatchingCountry(Predicate<String> predicate) {
      for (String item : countries) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLocality(Predicate<String> predicate) {
      for (String item : localities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOrganization(Predicate<String> predicate) {
      for (String item : organizations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOrganizationalUnit(Predicate<String> predicate) {
      for (String item : organizationalUnits) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPostalCode(Predicate<String> predicate) {
      for (String item : postalCodes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingProvince(Predicate<String> predicate) {
      for (String item : provinces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStreetAddress(Predicate<String> predicate) {
      for (String item : streetAddresses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOrganizationalUnits() {
    return this.organizationalUnits != null && !(this.organizationalUnits.isEmpty());
  }
  
  public boolean hasOrganizations() {
    return this.organizations != null && !(this.organizations.isEmpty());
  }
  
  public boolean hasPostalCodes() {
    return this.postalCodes != null && !(this.postalCodes.isEmpty());
  }
  
  public boolean hasProvinces() {
    return this.provinces != null && !(this.provinces.isEmpty());
  }
  
  public boolean hasSerialNumber() {
    return this.serialNumber != null;
  }
  
  public boolean hasStreetAddresses() {
    return this.streetAddresses != null && !(this.streetAddresses.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(countries, localities, organizationalUnits, organizations, postalCodes, provinces, serialNumber, streetAddresses, additionalProperties);
  }
  
  public A removeAllFromCountries(Collection<String> items) {
    if (this.countries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.countries.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromLocalities(Collection<String> items) {
    if (this.localities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.localities.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOrganizationalUnits(Collection<String> items) {
    if (this.organizationalUnits == null) {
      return (A) this;
    }
    for (String item : items) {
      this.organizationalUnits.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromOrganizations(Collection<String> items) {
    if (this.organizations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.organizations.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPostalCodes(Collection<String> items) {
    if (this.postalCodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.postalCodes.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromProvinces(Collection<String> items) {
    if (this.provinces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.provinces.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromStreetAddresses(Collection<String> items) {
    if (this.streetAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.streetAddresses.remove(item);
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
  
  public A removeFromCountries(String... items) {
    if (this.countries == null) {
      return (A) this;
    }
    for (String item : items) {
      this.countries.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromLocalities(String... items) {
    if (this.localities == null) {
      return (A) this;
    }
    for (String item : items) {
      this.localities.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOrganizationalUnits(String... items) {
    if (this.organizationalUnits == null) {
      return (A) this;
    }
    for (String item : items) {
      this.organizationalUnits.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromOrganizations(String... items) {
    if (this.organizations == null) {
      return (A) this;
    }
    for (String item : items) {
      this.organizations.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPostalCodes(String... items) {
    if (this.postalCodes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.postalCodes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromProvinces(String... items) {
    if (this.provinces == null) {
      return (A) this;
    }
    for (String item : items) {
      this.provinces.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromStreetAddresses(String... items) {
    if (this.streetAddresses == null) {
      return (A) this;
    }
    for (String item : items) {
      this.streetAddresses.remove(item);
    }
    return (A) this;
  }
  
  public A setToCountries(int index,String item) {
    if (this.countries == null) {
      this.countries = new ArrayList();
    }
    this.countries.set(index, item);
    return (A) this;
  }
  
  public A setToLocalities(int index,String item) {
    if (this.localities == null) {
      this.localities = new ArrayList();
    }
    this.localities.set(index, item);
    return (A) this;
  }
  
  public A setToOrganizationalUnits(int index,String item) {
    if (this.organizationalUnits == null) {
      this.organizationalUnits = new ArrayList();
    }
    this.organizationalUnits.set(index, item);
    return (A) this;
  }
  
  public A setToOrganizations(int index,String item) {
    if (this.organizations == null) {
      this.organizations = new ArrayList();
    }
    this.organizations.set(index, item);
    return (A) this;
  }
  
  public A setToPostalCodes(int index,String item) {
    if (this.postalCodes == null) {
      this.postalCodes = new ArrayList();
    }
    this.postalCodes.set(index, item);
    return (A) this;
  }
  
  public A setToProvinces(int index,String item) {
    if (this.provinces == null) {
      this.provinces = new ArrayList();
    }
    this.provinces.set(index, item);
    return (A) this;
  }
  
  public A setToStreetAddresses(int index,String item) {
    if (this.streetAddresses == null) {
      this.streetAddresses = new ArrayList();
    }
    this.streetAddresses.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(countries == null) && !(countries.isEmpty())) {
        sb.append("countries:");
        sb.append(countries);
        sb.append(",");
    }
    if (!(localities == null) && !(localities.isEmpty())) {
        sb.append("localities:");
        sb.append(localities);
        sb.append(",");
    }
    if (!(organizationalUnits == null) && !(organizationalUnits.isEmpty())) {
        sb.append("organizationalUnits:");
        sb.append(organizationalUnits);
        sb.append(",");
    }
    if (!(organizations == null) && !(organizations.isEmpty())) {
        sb.append("organizations:");
        sb.append(organizations);
        sb.append(",");
    }
    if (!(postalCodes == null) && !(postalCodes.isEmpty())) {
        sb.append("postalCodes:");
        sb.append(postalCodes);
        sb.append(",");
    }
    if (!(provinces == null) && !(provinces.isEmpty())) {
        sb.append("provinces:");
        sb.append(provinces);
        sb.append(",");
    }
    if (!(serialNumber == null)) {
        sb.append("serialNumber:");
        sb.append(serialNumber);
        sb.append(",");
    }
    if (!(streetAddresses == null) && !(streetAddresses.isEmpty())) {
        sb.append("streetAddresses:");
        sb.append(streetAddresses);
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
  
  public A withCountries(List<String> countries) {
    if (countries != null) {
        this.countries = new ArrayList();
        for (String item : countries) {
          this.addToCountries(item);
        }
    } else {
      this.countries = null;
    }
    return (A) this;
  }
  
  public A withCountries(String... countries) {
    if (this.countries != null) {
        this.countries.clear();
        _visitables.remove("countries");
    }
    if (countries != null) {
      for (String item : countries) {
        this.addToCountries(item);
      }
    }
    return (A) this;
  }
  
  public A withLocalities(List<String> localities) {
    if (localities != null) {
        this.localities = new ArrayList();
        for (String item : localities) {
          this.addToLocalities(item);
        }
    } else {
      this.localities = null;
    }
    return (A) this;
  }
  
  public A withLocalities(String... localities) {
    if (this.localities != null) {
        this.localities.clear();
        _visitables.remove("localities");
    }
    if (localities != null) {
      for (String item : localities) {
        this.addToLocalities(item);
      }
    }
    return (A) this;
  }
  
  public A withOrganizationalUnits(List<String> organizationalUnits) {
    if (organizationalUnits != null) {
        this.organizationalUnits = new ArrayList();
        for (String item : organizationalUnits) {
          this.addToOrganizationalUnits(item);
        }
    } else {
      this.organizationalUnits = null;
    }
    return (A) this;
  }
  
  public A withOrganizationalUnits(String... organizationalUnits) {
    if (this.organizationalUnits != null) {
        this.organizationalUnits.clear();
        _visitables.remove("organizationalUnits");
    }
    if (organizationalUnits != null) {
      for (String item : organizationalUnits) {
        this.addToOrganizationalUnits(item);
      }
    }
    return (A) this;
  }
  
  public A withOrganizations(List<String> organizations) {
    if (organizations != null) {
        this.organizations = new ArrayList();
        for (String item : organizations) {
          this.addToOrganizations(item);
        }
    } else {
      this.organizations = null;
    }
    return (A) this;
  }
  
  public A withOrganizations(String... organizations) {
    if (this.organizations != null) {
        this.organizations.clear();
        _visitables.remove("organizations");
    }
    if (organizations != null) {
      for (String item : organizations) {
        this.addToOrganizations(item);
      }
    }
    return (A) this;
  }
  
  public A withPostalCodes(List<String> postalCodes) {
    if (postalCodes != null) {
        this.postalCodes = new ArrayList();
        for (String item : postalCodes) {
          this.addToPostalCodes(item);
        }
    } else {
      this.postalCodes = null;
    }
    return (A) this;
  }
  
  public A withPostalCodes(String... postalCodes) {
    if (this.postalCodes != null) {
        this.postalCodes.clear();
        _visitables.remove("postalCodes");
    }
    if (postalCodes != null) {
      for (String item : postalCodes) {
        this.addToPostalCodes(item);
      }
    }
    return (A) this;
  }
  
  public A withProvinces(List<String> provinces) {
    if (provinces != null) {
        this.provinces = new ArrayList();
        for (String item : provinces) {
          this.addToProvinces(item);
        }
    } else {
      this.provinces = null;
    }
    return (A) this;
  }
  
  public A withProvinces(String... provinces) {
    if (this.provinces != null) {
        this.provinces.clear();
        _visitables.remove("provinces");
    }
    if (provinces != null) {
      for (String item : provinces) {
        this.addToProvinces(item);
      }
    }
    return (A) this;
  }
  
  public A withSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return (A) this;
  }
  
  public A withStreetAddresses(List<String> streetAddresses) {
    if (streetAddresses != null) {
        this.streetAddresses = new ArrayList();
        for (String item : streetAddresses) {
          this.addToStreetAddresses(item);
        }
    } else {
      this.streetAddresses = null;
    }
    return (A) this;
  }
  
  public A withStreetAddresses(String... streetAddresses) {
    if (this.streetAddresses != null) {
        this.streetAddresses.clear();
        _visitables.remove("streetAddresses");
    }
    if (streetAddresses != null) {
      for (String item : streetAddresses) {
        this.addToStreetAddresses(item);
      }
    }
    return (A) this;
  }
  
}