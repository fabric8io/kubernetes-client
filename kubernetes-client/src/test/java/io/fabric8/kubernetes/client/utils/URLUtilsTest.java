package io.fabric8.kubernetes.client.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class URLUtilsTest {


  @Test
  public void shouldJoinUrlWithoutQueryParams() {

    // Given

    String masterUrl = "https://oso-master-url:8888/kubernetes";

    // When

    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then

    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/api"));

  }

  @Test
  public void shouldJoinUrlWithQueryParams() {

    // Given

    String masterUrl = "https://oso-master-url:8888/kubernetes?key=value";

    // When

    final String fullUrl = URLUtils.join(masterUrl, "api");

    // Then

    assertThat(fullUrl, is("https://oso-master-url:8888/kubernetes/api?key=value"));

  }


}
