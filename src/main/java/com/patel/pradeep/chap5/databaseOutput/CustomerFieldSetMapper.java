/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.patel.pradeep.chap5.databaseOutput;

import java.util.Arrays;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * @author Michael Minella
 */
public class CustomerFieldSetMapper implements FieldSetMapper<Customer> {

	@Override
	public Customer mapFieldSet(FieldSet fieldSet) throws BindException {
		System.out.println("NAMES->"+Arrays.toString(fieldSet.getNames()));
		System.out.println("VALUES->"+Arrays.toString(fieldSet.getValues()));

		/*if(fieldSet.readLong("id") == 35){
			throw new RuntimeException("MY ERROR");
		}*/

		return new Customer(fieldSet.readLong("id"),
				fieldSet.readString("firstName"),
				fieldSet.readString("lastName"),
				fieldSet.readDate("birthdate", "yyyy-MM-dd HH:mm:ss"));
	}
}
