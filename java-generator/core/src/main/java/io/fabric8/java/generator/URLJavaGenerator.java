/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.java.generator;

import io.fabric8.java.generator.exceptions.JavaGeneratorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;

/**
 * {@link JavaGenerator} implementation that reads CRD from remote URLs and generates
 * Java classes for them.
 */
public class URLJavaGenerator implements JavaGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(URLJavaGenerator.class);

  private final Collection<URL> urls;
  private final File downloadDirectory;
  private final FileJavaGenerator delegate;

  public URLJavaGenerator(Config config, Collection<URL> urls, File downloadDirectory) {
    this.urls = urls;
    this.downloadDirectory = downloadDirectory;
    delegate = new FileJavaGenerator(config, downloadDirectory);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run(File outputDirectory) {
    if (urls == null || urls.isEmpty()) {
      throw new JavaGeneratorException("No URLs provided");
    }
    if (downloadDirectory == null) {
      throw new JavaGeneratorException(
          "Download directory is required");
    }
    if (!downloadDirectory.isDirectory()) {
      throw new JavaGeneratorException(
          "Download directory " + downloadDirectory.getAbsolutePath() + " is not a valid directory");
    }
    if (!downloadDirectory.exists() && !downloadDirectory.mkdirs()) {
      throw new JavaGeneratorException("Unable to create download directory " + downloadDirectory.getAbsolutePath());
    }
    LOGGER.info("Downloading CRDs from URLs: {}", urls);
    urls.forEach(this::downloadCRD);
    LOGGER.info("Generating Java classes from downloaded CRDs");
    delegate.run(outputDirectory);
  }

  private void downloadCRD(URL url) {
    final File finalDestination = new File(downloadDirectory, new File(url.getFile()).getName());
    if (finalDestination.exists()) {
      LOGGER.warn("Skipping download of {} because it already exists at {}", url, finalDestination);
      return;
    }
    try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(finalDestination)) {
      fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    } catch (IOException e) {
      throw new JavaGeneratorException("Error downloading CRD from URL: " + url, e);
    }
  }
}
