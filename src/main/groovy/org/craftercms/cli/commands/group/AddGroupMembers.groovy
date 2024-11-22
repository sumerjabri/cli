/*
 * Copyright (C) 2007-2024 Crafter Software Corporation. All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 as published by
 * the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.craftercms.cli.commands.group

import org.craftercms.cli.commands.AbstractCommand
import picocli.CommandLine

@CommandLine.Command(name = 'add-group-members', description = 'Adds one or more users to a group')
class AddGroupMembers extends AbstractCommand {

	@CommandLine.Option(names = ['-gn', '--group-name'], required = true, description = 'Group name. Required if not bulk importing from a file.')
	String name

	@CommandLine.Option(names = ['-u', '--users'], split = ',', required = true, description = 'Comma separated list of users to add')
	String[] users

	def validateParameters() {
		if (!name) {
			throw new CommandLine.ParameterException(commandSpec.commandLine(), 'Missing required option group-name')
		}

		if (!users) {
			throw new CommandLine.ParameterException(commandSpec.commandLine(), 'Missing required option users')
		}
	}

	@Override
	def run(client) {
		validateParameters()
		addMembers(client, name, users)
	}

	/**
	 * Add users to a group
	 * @param client HTTPClient object
	 * @param options create group options
	 */
	def addMembers(client, options) {
//		def params = [
//			name: options.name,
//			desc: options.desc
//		]
//
//		def path = '/studio/api/2/groups'
//		def result = client.post(path, params)
//		if (result) {
//			println "${result.response.message}. Group: ${options.name}"
//		}
	}
}