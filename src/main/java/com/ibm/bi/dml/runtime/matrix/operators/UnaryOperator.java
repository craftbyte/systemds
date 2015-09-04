/**
 * (C) Copyright IBM Corp. 2010, 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */


package com.ibm.bi.dml.runtime.matrix.operators;

import com.ibm.bi.dml.runtime.functionobjects.Builtin;
import com.ibm.bi.dml.runtime.functionobjects.ValueFunction;

public class UnaryOperator extends Operator 
{

	private static final long serialVersionUID = 2441990876648978637L;

	public ValueFunction fn;
	public UnaryOperator(ValueFunction p)
	{
		fn = p;
		sparseSafe = false;
		
		if(fn instanceof Builtin)
		{
			Builtin f=(Builtin)fn;
			if(f.bFunc==Builtin.BuiltinFunctionCode.SIN || f.bFunc==Builtin.BuiltinFunctionCode.TAN 
					|| f.bFunc==Builtin.BuiltinFunctionCode.ROUND || f.bFunc==Builtin.BuiltinFunctionCode.ABS
					|| f.bFunc==Builtin.BuiltinFunctionCode.SQRT || f.bFunc==Builtin.BuiltinFunctionCode.SPROP
					|| f.bFunc==Builtin.BuiltinFunctionCode.SELP || f.bFunc==Builtin.BuiltinFunctionCode.LOG_NZ )
			{
				sparseSafe = true;
			}
		}
	}
}
