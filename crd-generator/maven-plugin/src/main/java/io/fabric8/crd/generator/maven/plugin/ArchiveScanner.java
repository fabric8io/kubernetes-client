/*
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
package io.fabric8.crd.generator.maven.plugin;

import org.codehaus.plexus.util.AbstractScanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class ArchiveScanner extends AbstractScanner {
  private static final String[] EMPTY_STRING_ARRAY = new String[0];

  private final File archive;

  private ArrayList<String> filesIncluded;

  ArchiveScanner(File archive) {
    this.archive = archive;
  }

  @Override
  public void scan() {
    if (archive == null) {
      throw new IllegalStateException("No archive set");
    }
    if (!archive.exists()) {
      throw new IllegalStateException("Archive " + archive + " does not exist");
    }
    if (!archive.isFile()) {
      throw new IllegalStateException("Archive " + archive + " is not a file");
    }

    setupDefaultFilters();
    setupMatchPatterns();

    filesIncluded = new ArrayList<>();

    List<String> files = new ArrayList<>();
    try (ZipFile zip = new ZipFile(archive)) {
      Enumeration<? extends ZipEntry> entries = zip.entries();
      while (entries.hasMoreElements()) {
        ZipEntry entry = entries.nextElement();
        if (!entry.isDirectory()) {
          files.add(entry.getName());
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    if (filenameComparator != null) {
      files.sort(filenameComparator);
    }

    for (String file : files) {
      String forMatching = file.replace('/', File.separatorChar);
      if (isIncluded(forMatching) && !isExcluded(forMatching)) {
        filesIncluded.add(file);
      }
    }
  }

  @Override
  public String[] getIncludedFiles() {
    return filesIncluded.toArray(EMPTY_STRING_ARRAY);
  }

  @Override
  public String[] getIncludedDirectories() {
    throw new UnsupportedOperationException();
  }

  @Override
  public File getBasedir() {
    return archive;
  }
}
