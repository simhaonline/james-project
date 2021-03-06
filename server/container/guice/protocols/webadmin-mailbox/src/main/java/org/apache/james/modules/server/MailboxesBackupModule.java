/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.modules.server;

import org.apache.james.mailbox.backup.ArchiveService;
import org.apache.james.mailbox.backup.DefaultMailboxBackup;
import org.apache.james.mailbox.backup.MailArchiveRestorer;
import org.apache.james.mailbox.backup.MailArchivesLoader;
import org.apache.james.mailbox.backup.MailboxBackup;
import org.apache.james.mailbox.backup.ZipMailArchiveRestorer;
import org.apache.james.mailbox.backup.zip.ZipArchivesLoader;
import org.apache.james.mailbox.backup.zip.Zipper;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class MailboxesBackupModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Zipper.class).in(Scopes.SINGLETON);
        bind(ArchiveService.class).to(Zipper.class);

        bind(ZipMailArchiveRestorer.class).in(Scopes.SINGLETON);
        bind(MailArchiveRestorer.class).to(ZipMailArchiveRestorer.class);

        bind(ZipArchivesLoader.class).in(Scopes.SINGLETON);
        bind(MailArchivesLoader.class).to(ZipArchivesLoader.class);

        bind(DefaultMailboxBackup.class).in(Scopes.SINGLETON);
        bind(MailboxBackup.class).to(DefaultMailboxBackup.class);
    }
}
