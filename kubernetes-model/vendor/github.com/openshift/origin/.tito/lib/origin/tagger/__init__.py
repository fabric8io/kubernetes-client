#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

"""
Code for tagging Origin packages
"""
from tito.tagger import VersionTagger

from ..common import inject_os_git_vars, update_global_hash

class OriginTagger(VersionTagger):
    """
    Origin custom tagger. This tagger has several deviations from the normal
    tito tagger.

    ** Rather than versions being tagged %{name}-%{version}-%{release} they're
    tagged as v%{version} in order to preserve compatibility with origin build
    processes. This means you really should not attempt to use the release field
    for anything useful, it should probably always remain zero.

    ** RPM specfile global commit is updated with the git hash, this may be
    relevant and popular with other golang projects, so TODO: submit to tito
    upstream.

    Requires that your commit global is written on one single line like this:

    %global commit 460abe2a3abe0fa22ac96c551fe71c0fc36f7475

    ** RPM specfile global ldflags is updated with os::build::ldflags as generated
    by importing hack/common.sh this absolutely depends on the non standard
    version tagging outlined above. This is 100% openshift specific

    Requires that your ldflags global is written on one single line like this:
    %global ldflags -X foo -X bar

    Used For:
    - Origin, probably not much else
    """

    def _tag_release(self):
        update_global_hash(self.spec_file)
        inject_os_git_vars(self.spec_file)
        super(OriginTagger, self)._tag_release()

    def _get_tag_for_version(self, version, release=None):
        return "v{}".format(version)
# vim:expandtab:autoindent:tabstop=4:shiftwidth=4:filetype=python:textwidth=0:
